package com.example.pythonapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pythonapi.R;
import com.example.pythonapi.beacons.BeaconSearc;
import com.example.pythonapi.dialogues.BottomSheetDialogueForEachBeacons;
import com.example.pythonapi.interfaces.JsonApiHolder;
import com.example.pythonapi.model.BeaconsProperties;
import com.example.pythonapi.model.Room;
import com.example.pythonapi.rest_api.RestApi;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeaconsWithLocations extends AppCompatActivity implements BeaconConsumer {
    private static final String TAG = "BeaconsWithLocations";
    ProgressDialog dialog;



    private ArrayList<BeaconsProperties> list = new ArrayList();


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
    private String room;


    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @BindView(R.id.a1)
    TextView a1T;

    @BindView(R.id.a2)
    TextView a2T;

    @BindView(R.id.a3)
    TextView a3T;

    @BindView(R.id.a4)
    TextView a4T;

    @BindView(R.id.a5)
    TextView a5T;

    @BindView(R.id.a6)
    TextView a6T;


    @BindView(R.id.b1)
    TextView b1T;

    @BindView(R.id.b2)
    TextView b2T;

    @BindView(R.id.b3)
    TextView b3T;

    @BindView(R.id.b4)
    TextView b4T;

    @BindView(R.id.b5)
    TextView b5T;

    @BindView(R.id.b6)
    TextView b6T;



    @BindView(R.id.c1)
    TextView c1T;

    @BindView(R.id.c2)
    TextView c2T;

    @BindView(R.id.c3)
    TextView c3T;

    @BindView(R.id.c4)
    TextView c4T;

    @BindView(R.id.c5)
    TextView c5T;

    @BindView(R.id.c6)
    TextView c6T;


    @BindView(R.id.d1)
    TextView d1T;

    @BindView(R.id.d2)
    TextView d2T;

    @BindView(R.id.d3)
    TextView d3T;

    @BindView(R.id.d4)
    TextView d4T;

    @BindView(R.id.d5)
    TextView d5T;

    @BindView(R.id.d6)
    TextView d6T;


    @BindView(R.id.e1)
    TextView e1T;

    @BindView(R.id.e2)
    TextView e2T;

    @BindView(R.id.e3)
    TextView e3T;

    @BindView(R.id.e4)
    TextView e4T;

    @BindView(R.id.e5)
    TextView e5T;

    @BindView(R.id.e6)
    TextView e6T;


    @BindView(R.id.f1)
    TextView f1T;

    @BindView(R.id.f2)
    TextView f2T;

    @BindView(R.id.f3)
    TextView f3T;

    @BindView(R.id.f4)
    TextView f4T;

    @BindView(R.id.f5)
    TextView f5T;

    @BindView(R.id.f6)
    TextView f6T;


    @BindView(R.id.be1)
    TextView beacon1;

    @BindView(R.id.be2)
    TextView beacon2;

    @BindView(R.id.be3)
    TextView beacon3;

    @BindView(R.id.be4)
    TextView beacon4;

    @BindView(R.id.be5)
    TextView beacon5;

    @BindView(R.id.be6)
    TextView beacon6;

    @BindView(R.id.scanning)
    Button scanning;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        if(unbinder == null){
            unbinder = ButterKnife.bind(this);
        }
        checkBluetooth();
        showProgressDialogue("Finding beacons", "Please wait...");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        startBeaconListener();

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


    @OnClick(R.id.be1)
    public void redirectValueOfBeacon1(){
        BottomSheetDialogueForEachBeacons beacons = new BottomSheetDialogueForEachBeacons(list.get(0), "Beacon 1 Detail");
        beacons.show(getSupportFragmentManager(), "Dialogue");
    }
    @OnClick(R.id.be2)
    public void redirectValueOfBeacon2(){
        BottomSheetDialogueForEachBeacons beacons = new BottomSheetDialogueForEachBeacons(list.get(1), "Beacon 2 Detail");
        beacons.show(getSupportFragmentManager(), "Dialogue");
    }
    @OnClick(R.id.be3)
    public void redirectValueOfBeacon3(){
        BottomSheetDialogueForEachBeacons beacons = new BottomSheetDialogueForEachBeacons(list.get(2), "Beacon 3 Detail");
        beacons.show(getSupportFragmentManager(), "Dialogue");
    }
    @OnClick(R.id.be4)
    public void redirectValueOfBeacon4(){
        BottomSheetDialogueForEachBeacons beacons = new BottomSheetDialogueForEachBeacons(list.get(3), "Beacon 4 Detail");
        beacons.show(getSupportFragmentManager(), "Dialogue");
    }
    @OnClick(R.id.be5)
    public void redirectValueOfBeacon5(){
        BottomSheetDialogueForEachBeacons beacons = new BottomSheetDialogueForEachBeacons(list.get(4), "Beacon 5 Detail");
        beacons.show(getSupportFragmentManager(), "Dialogue");
    }
    @OnClick(R.id.be6)
    public void redirectValueOfBeacon6(){
        BottomSheetDialogueForEachBeacons beacons = new BottomSheetDialogueForEachBeacons(list.get(5), "Beacon 6 Detail");
        beacons.show(getSupportFragmentManager(), "Dialogue");
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

//        beaconManager.setBackgroundScanPeriod(1000l);
        beaconManager.setForegroundScanPeriod(2000);
        try {
            beaconManager.updateScanPeriods();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        beaconManager.setDebug(true);
        beaconManager.bind(this);
    }

    @OnClick(R.id.scanning)
    public void scanning(){
        if(scanning.getText().toString().equals(getString(R.string.start_scanning))){
            scanning.setText(getString(R.string.stop_scanning));
            startBeaconListener();

        }else {
            if(beaconManager != null) {
                scanning.setText(getString(R.string.start_scanning));
            }
        }
    }

    @Override
    public void onBeaconServiceConnect() {
        beaconManager.addRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                if (beacons.size() > 0) {
                    Log.i(TAG, "The first beacon I see is about "+beacons.iterator().next().getDistance()+" meters away.");
                    Log.i(TAG, beacons.size() + "" + "");
                    try {
                        //Tells the BeaconService to start looking for beacons that match the passed Region object.
                        beaconManager.startMonitoringBeaconsInRegion(region);
                        dissmissProgressDialogue();
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

                            if(getString(R.string.beacon1).equals(uuid)){
                                list.set(0, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                beacon1.setText(String.valueOf(rssi));
                            }
                            if(getString(R.string.beacon2).equals(uuid)){
                                list.set(1, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                beacon2.setText(String.valueOf(rssi));
                            }
                            if(getString(R.string.beacon3).equals(uuid)){
                                list.set(2, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                beacon3.setText(String.valueOf(rssi));
                            }
                            if(getString(R.string.beacon4).equals(uuid)){
                                list.set(3, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                beacon4.setText(String.valueOf(rssi));
                            }
                            if(getString(R.string.beacon5).equals(uuid)){
                                list.set(4, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                beacon5.setText(String.valueOf(rssi));
                            }
                            if(getString(R.string.beacon6).equals(uuid)){
                                list.set(5, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                beacon6.setText(String.valueOf(rssi));
                            }

                            sendDataForPrediction();

                        }
                    } catch (RemoteException e) {    }


                }

            }
        });

        try {
            beaconManager.startRangingBeaconsInRegion(new Region("myRangingUniqueId", null, null, null));
        } catch (RemoteException e) {    }
    }

    private void sendDataForPrediction() {
        JsonApiHolder service = RestApi.getApi();
        String rssi1,rssi2, rssi3, rssi4, rssi5, rssi6;
        rssi1 = beacon1.getText().toString();
        rssi2 = beacon2.getText().toString();
        rssi3 = beacon3.getText().toString();
        rssi4 = beacon4.getText().toString().trim();
        rssi5 = beacon5.getText().toString();
        rssi6 = beacon6.getText().toString();
        if(rssi1.equals("B1")){
            rssi1 = "0";
        }
        if(rssi2.equals("B2")){
            rssi2 = "0";
        }
        if(rssi3.equals("B3")){
            rssi3 = "0";
        }
        if(rssi4.equals("B4")){
            rssi4 = "0";
        }
        if(rssi5.equals("B5")){
            rssi5 = "0";
        }
        if(rssi6.equals("B6")){
            rssi6 = "0";
        }
        Log.d(TAG, "sendDataForPrediction: " + rssi4);
        Log.d(TAG, "sendDataForPrediction: " + rssi2);


        Call<Room> call = service.predict(
                rssi1,
                rssi2,
                rssi3,
                rssi4,
                rssi5,
                rssi6,
                "0"
        );
        call.enqueue(new Callback<Room>() {
            @Override
            public void onResponse(Call<Room> call, Response<Room> response) {
                if(response.isSuccessful()){
                    settingLocation(response.body().getRoom());
                }else {
                    Toast.makeText(BeaconsWithLocations.this, "Cannot comunicate with server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Room> call, Throwable t) {
                Toast.makeText(BeaconsWithLocations.this, "Cannot comunicate with server " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    /*
         If we are implementing the BeaconConsumer interface in a Fragment
        (and not an Activity, Service or Application instance),
         we need to chain all of the methods.
     */
    private void settingLocation(String room) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            a1T.setBackground(getDrawable(R.color.red));
            b1T.setBackground(getDrawable(R.color.red));
            a2T.setBackground(getDrawable(R.color.red));
            a3T.setBackground(getDrawable(R.color.red));
            a4T.setBackground(getDrawable(R.color.red));
            a5T.setBackground(getDrawable(R.color.red));
            a6T.setBackground(getDrawable(R.color.red));
            b2T.setBackground(getDrawable(R.color.red));
            b3T.setBackground(getDrawable(R.color.red));
            b4T.setBackground(getDrawable(R.color.red));
            b5T.setBackground(getDrawable(R.color.red));
            b6T.setBackground(getDrawable(R.color.red));
            c1T.setBackground(getDrawable(R.color.red));
            c2T.setBackground(getDrawable(R.color.red));
            c3T.setBackground(getDrawable(R.color.red));
            c4T.setBackground(getDrawable(R.color.red));
            c5T.setBackground(getDrawable(R.color.red));
            c6T.setBackground(getDrawable(R.color.red));
            d1T.setBackground(getDrawable(R.color.red));
            d2T.setBackground(getDrawable(R.color.red));
            d3T.setBackground(getDrawable(R.color.red));
            d4T.setBackground(getDrawable(R.color.red));
            d5T.setBackground(getDrawable(R.color.red));
            d6T.setBackground(getDrawable(R.color.red));
            e1T.setBackground(getDrawable(R.color.red));
            e2T.setBackground(getDrawable(R.color.red));
            e3T.setBackground(getDrawable(R.color.red));
            e4T.setBackground(getDrawable(R.color.red));
            e5T.setBackground(getDrawable(R.color.red));
            e6T.setBackground(getDrawable(R.color.red));
            d3T.setBackground(getDrawable(R.color.red));
            f1T.setBackground(getDrawable(R.color.red));
            f2T.setBackground(getDrawable(R.color.red));
            f3T.setBackground(getDrawable(R.color.red));
            f4T.setBackground(getDrawable(R.color.red));
            f5T.setBackground(getDrawable(R.color.red));
            f6T.setBackground(getDrawable(R.color.red));
        }
        switch (room){
            case "['a1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a2']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a2T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a3']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a3T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a4']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a4T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a5']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a5T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a6']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a6T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['b1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    b1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['b2']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    b2T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['b3']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    b3T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['b4']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    b4T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['b5']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    b5T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['b6']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    b6T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c2']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c2T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c3']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c3T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c4']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c4T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c5']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c5T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c6']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c6T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['d1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    d1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['d2']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    d2T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['d3']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    d3T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['d4']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    d4T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['d5']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    d5T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['d6']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    d6T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['e1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    e1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['e2']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    e2T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['e3']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    e3T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['e4']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    e4T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['e5']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    e5T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['e6']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    e6T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['f1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    f1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['f2']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    f2T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['f3']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    f3T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['f4']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    f4T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['f5']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    f5T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['f6']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    f6T.setBackground(getDrawable(R.color.blue));
                }
                break;
            default:
                Log.d(TAG, "settingLocation: " + room);
//                Toast.makeText(this, "Sorry, this address is not found", Toast.LENGTH_SHORT).show();

        }
    }



    public void showProgressDialogue(String title, String message){
        dialog = new ProgressDialog(this);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.show();
    }
    public void dissmissProgressDialogue(){
        dialog.dismiss();
    }


    // Override onDestroy Method
    @Override
    public void onDestroy() {
        super.onDestroy();
        //Unbinds an Android Activity or Service to the BeaconService to avoid leak.
        beaconManager.unbind(this);
    }
}
