package com.example.pythonapi.beacons;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pythonapi.R;
import com.example.pythonapi.model.BeaconsProperties;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/*
    This Fragment will display all the beacons detected by device with their details in the list
 */
public class BeaconSearc extends AppCompatActivity implements BeaconConsumer {

    private static final String TAG = "BeaconSearc";
    private Unbinder unbinder;


    //Relative Layout
    //Recycler View
    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    //Beacon Manager
    private BeaconManager beaconManager;

    // Progress bar
    private ProgressBar pb;
    private double distance = 0;
    private TextView textView;
    private Region mRegion;


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.searchBeacons)
    FloatingActionButton searchBeacons;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beacon_search);

        if(unbinder == null){
            unbinder = ButterKnife.bind(this);
        }

        checkBluetooth();

        //getting beaconManager instance (object) for Main Activity class
//        startBeaconListener();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);





        // Recycler View
        rv = findViewById(R.id.search_recycler);

        //Progress Bar
        pb = findViewById(R.id.pb);
        pb.setVisibility(View.GONE);


        textView = findViewById(R.id.beacons);


    }
    int i =0;

    @OnClick(R.id.searchBeacons)
    public void searchBeacons(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if(i%2 == 0){
                ++i;
                searchBeacons.setImageDrawable(getDrawable(R.drawable.pause));
                pb.setVisibility(View.VISIBLE);
                startBeaconListener();
            }else {
                ++i;
                searchBeacons.setImageDrawable(getDrawable(R.drawable.play));
                try {
                    beaconManager.stopRangingBeaconsInRegion(mRegion);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void checkBluetooth() {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // Checking if bluetooth is supported by device or not
        if (mBluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(),"Bluetooth Not Supported",Toast.LENGTH_LONG).show();
        } else {
            // if bluetooth is supported but not enabled then enable it
            if (!mBluetoothAdapter.isEnabled()) {
                Intent bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                bluetoothIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(bluetoothIntent);
            }
        }
    }


    public void startBeaconListener() {
        beaconManager = BeaconManager.getInstanceForApplication(this.getApplicationContext());
        // Detect the main Eddystone-UID frame:
        beaconManager.getBeaconParsers().add(new BeaconParser().
                setBeaconLayout("s:0-1=feaa,m:2-2=00,p:3-3:-41,i:4-13,i:14-19"));
        // Detect the telemetry (TLM) frame:
        beaconManager.getBeaconParsers().add(new BeaconParser().
                setBeaconLayout("x,s:0-1=feaa,m:2-2=20,d:3-3,d:4-5,d:6-7,d:8-11,d:12-15"));
        // Detect the URL frame:
        beaconManager.getBeaconParsers().add(new BeaconParser().
                setBeaconLayout("s:0-1=feaa,m:2-2=10,p:3-3:-41,i:4-21v"));
        //Detecte iBeacon frame
        beaconManager.getBeaconParsers().add(new BeaconParser().
                setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));
        //mBeaconManager.setForegroundScanPeriod(5000l);
        beaconManager.setForegroundBetweenScanPeriod(2000);
//        beaconManager.setBackgroundScanPeriod(1000l);
        beaconManager.setForegroundScanPeriod(2000);
        beaconManager.setRegionExitPeriod(2000/*milliseconds*/);
        try {
            beaconManager.updateScanPeriods();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        beaconManager.setDebug(true);
        beaconManager.bind(this);
    }

    @Override
    public void onBeaconServiceConnect() {
        beaconManager.addRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                if (beacons.size() > 0) {
                    mRegion = region;
                    Log.i(TAG, "The first beacon I see is about "+beacons.iterator().next().getDistance()+" meters away.");
                    Log.i(TAG, beacons.size() + "" + "");

                    try {
                        //Tells the BeaconService to start looking for beacons that match the passed Region object.
                        beaconManager.startMonitoringBeaconsInRegion(region);
                        pb.setVisibility(View.INVISIBLE);
                        textView.setText("");
                        for (Beacon b:beacons){

                            //UUID
                            String uuid = String.valueOf(b.getId1());
                            Log.d(TAG, "didRangeBeaconsInRegion: " + uuid);

                            //Major
                            String major = String.valueOf(b.getId2());

                            //Minor
                            String minor = String.valueOf(b.getId3());

                            //Distance
                            double distance1 =b.getDistance();
                            int rssi = b.getRssi();
                            String distance = String.valueOf(Math.round(distance1*100.0)/100.0);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView.append("uuid: "+uuid + "\n");
                                    textView.append("rssi: " + String.valueOf(rssi) + " dBl \n");
                                    textView.append("distance: " + distance + " m \n");
                                    textView.append("------------------ \n");

                                }
                            });
                        }
//

                    } catch (RemoteException e) {    }


                }

                // if Beacon is not detected then size of collection is = 0

            }
        });

        try {
            beaconManager.startRangingBeaconsInRegion(new Region("myRangingUniqueId", null, null, null));
        } catch (RemoteException e) {    }
    }



    /*
         If we are implementing the BeaconConsumer interface in a Fragment
        (and not an Activity, Service or Application instance),
         we need to chain all of the methods.
     */




    // Override onDestroy Method
    @Override
    public void onDestroy() {
        super.onDestroy();
        //Unbinds an Android Activity or Service to the BeaconService to avoid leak.
        beaconManager.unbind(this);
    }
}
