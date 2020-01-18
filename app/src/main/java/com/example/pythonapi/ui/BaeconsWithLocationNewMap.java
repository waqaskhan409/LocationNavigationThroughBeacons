package com.example.pythonapi.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.pythonapi.interfaces.JsonApiHolder;
import com.example.pythonapi.model.BeaconsProperties;
import com.example.pythonapi.model.Room;
import com.example.pythonapi.rest_api.RestApi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.RemoteException;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pythonapi.R;

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
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaeconsWithLocationNewMap extends AppCompatActivity implements BeaconConsumer {
    private static final String TAG = "BaeconsWithLocationNewM";
    private Unbinder unbinder;
    private ArrayList<BeaconsProperties> list = new ArrayList();
    private ArrayList<String> models = new ArrayList();
    //Beacon Manager
    private BeaconManager beaconManager;
    private ProgressDialog dialog;

    @BindView(R.id.beacon1)
    TextView beacon1;

    @BindView(R.id.beacon2)
    TextView beacon2;

    @BindView(R.id.beacon3)
    TextView beacon3;

    @BindView(R.id.beacon4)
    TextView beacon4;

    @BindView(R.id.beacon5)
    TextView beacon5;

    @BindView(R.id.beacon6)
    TextView beacon6;

    @BindView(R.id.beacon7)
    TextView beacon7;
    @BindView(R.id.beacon8)
    TextView beacon8;
    @BindView(R.id.beacon9)
    TextView beacon9;
    @BindView(R.id.beacons10)
    TextView beacon10;
    @BindView(R.id.beacons11)
    TextView beacon11;


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

    @BindView(R.id.a7)
    TextView a7T;

    @BindView(R.id.a8)
    TextView a8T;

    @BindView(R.id.a9)
    TextView a9T;

    @BindView(R.id.a10)
    TextView a10T;

    @BindView(R.id.a11)
    TextView a11T;

    @BindView(R.id.a12)
    TextView a12T;

    @BindView(R.id.a13)
    TextView a13T;

    @BindView(R.id.a14)
    TextView a14T;

    @BindView(R.id.a15)
    TextView a15T;

    @BindView(R.id.a16)
    TextView a16T;

    @BindView(R.id.a17)
    TextView a17T;

    @BindView(R.id.a18)
    TextView a18T;

    @BindView(R.id.a19)
    TextView a19T;

    @BindView(R.id.a20)
    TextView a20T;

    @BindView(R.id.a21)
    TextView a21T;

    @BindView(R.id.a22)
    TextView a22T;

    @BindView(R.id.a23)
    TextView a23T;

    @BindView(R.id.a24)
    TextView a24T;

    @BindView(R.id.a25)
    TextView a25T;

    @BindView(R.id.a26)
    TextView a26T;

    @BindView(R.id.a27)
    TextView a27T;

    @BindView(R.id.a28)
    TextView a28T;

    @BindView(R.id.a29)
    TextView a29T;

    @BindView(R.id.a30)
    TextView a30T;

    @BindView(R.id.a31)
    TextView a31T;

    @BindView(R.id.a32)
    TextView a32T;

    @BindView(R.id.a33)
    TextView a33T;

    @BindView(R.id.a34)
    TextView a34T;

    @BindView(R.id.a35)
    TextView a35T;

    @BindView(R.id.a36)
    TextView a36T;

    @BindView(R.id.a37)
    TextView a37T;

    @BindView(R.id.a38)
    TextView a38T;

    @BindView(R.id.a39)
    TextView a39T;

    @BindView(R.id.a40)
    TextView a40T;

    @BindView(R.id.a41)
    TextView a41T;


    @BindView(R.id.b1)
    TextView b1T;

    @BindView(R.id.b41)
    TextView b41T;

    @BindView(R.id.c1)
    TextView c1T;

    @BindView(R.id.c41)
    TextView c41T;

    @BindView(R.id.c42)
    TextView c42T;

    @BindView(R.id.c43)
    TextView c43T;

    @BindView(R.id.c44)
    TextView c44T;

    @BindView(R.id.c45)
    TextView c45T;

    @BindView(R.id.c46)
    TextView c46T;

    @BindView(R.id.c47)
    TextView c47T;

    @BindView(R.id.c48)
    TextView c48T;

    @BindView(R.id.c49)
    TextView c49T;

    @BindView(R.id.c50)
    TextView c50T;

    @BindView(R.id.d1)
    TextView d1T;

    @BindView(R.id.d50)
    TextView d50T;

    @BindView(R.id.e1)
    TextView e1T;

    @BindView(R.id.e50)
    TextView e50T;

    @BindView(R.id.f1)
    TextView f1T;

    @BindView(R.id.f50)
    TextView f50T;

    @BindView(R.id.g1)
    TextView g1T;

    @BindView(R.id.g50)
    TextView g50T;

    @BindView(R.id.h1)
    TextView h1T;

    @BindView(R.id.h50)
    TextView h50T;


    @BindView(R.id.i1)
    TextView i1T;

    @BindView(R.id.i2)
    TextView i2T;

    @BindView(R.id.i3)
    TextView i3T;

    @BindView(R.id.i4)
    TextView i4T;

    @BindView(R.id.i5)
    TextView i5T;

    @BindView(R.id.i6)
    TextView i6T;

    @BindView(R.id.i7)
    TextView i7T;

    @BindView(R.id.i8)
    TextView i8T;

    @BindView(R.id.i9)
    TextView i9T;

    @BindView(R.id.i10)
    TextView i10T;

    @BindView(R.id.i11)
    TextView i11T;

    @BindView(R.id.i12)
    TextView i12T;

    @BindView(R.id.i13)
    TextView i13T;

    @BindView(R.id.i14)
    TextView i14T;

    @BindView(R.id.i15)
    TextView i15T;

    @BindView(R.id.i16)
    TextView i16T;

    @BindView(R.id.i17)
    TextView i17T;

    @BindView(R.id.i18)
    TextView i18T;

    @BindView(R.id.i19)
    TextView i19T;

    @BindView(R.id.i20)
    TextView i20T;

    @BindView(R.id.i21)
    TextView i21T;

    @BindView(R.id.i22)
    TextView i22T;

    @BindView(R.id.i23)
    TextView i23T;

    @BindView(R.id.i24)
    TextView i24T;

    @BindView(R.id.i25)
    TextView i25T;

    @BindView(R.id.i26)
    TextView i26T;

    @BindView(R.id.i27)
    TextView i27T;

    @BindView(R.id.i28)
    TextView i28T;

    @BindView(R.id.i29)
    TextView i29T;

    @BindView(R.id.i30)
    TextView i30T;

    @BindView(R.id.i31)
    TextView i31T;

    @BindView(R.id.i32)
    TextView i32T;

    @BindView(R.id.i33)
    TextView i33T;

    @BindView(R.id.i34)
    TextView i34T;

    @BindView(R.id.i35)
    TextView i35T;

    @BindView(R.id.i36)
    TextView i36T;

    @BindView(R.id.i37)
    TextView i37T;

    @BindView(R.id.i38)
    TextView i38T;

    @BindView(R.id.i39)
    TextView i39T;

    @BindView(R.id.i40)
    TextView i40T;

    @BindView(R.id.i41)
    TextView i41T;

    @BindView(R.id.i42)
    TextView i42T;

    @BindView(R.id.i43)
    TextView i43T;

    @BindView(R.id.i44)
    TextView i44T;

    @BindView(R.id.i45)
    TextView i45T;

    @BindView(R.id.i46)
    TextView i46T;

    @BindView(R.id.i47)
    TextView i47T;

    @BindView(R.id.i48)
    TextView i48T;

    @BindView(R.id.i49)
    TextView i49T;

    @BindView(R.id.i50)
    TextView i50T;

    @BindView(R.id.models)
    Spinner model;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baecons_with_location_new_map);

        if(unbinder == null){
            unbinder = ButterKnife.bind(this);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        showProgressDialogue("Finding beacons", "Please wait...");

        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));
        list.add(new BeaconsProperties("","", "","","",""));

        models.add("KNeighborsClassifier");
        models.add("GaussianNB");
        models.add("SVC");
        models.add("DecisionTreeClassifier");
        models.add("LinearDiscriminantAnalysis");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, models);
        model.setAdapter(adapter);
        Log.d(TAG, "onCreate: position" + model.getSelectedItemPosition());
        startBeaconListener();

    }

    @Override
    public void onBeaconServiceConnect() {
        beaconManager.addRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                if (beacons.size() > 0) {

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
                                if(beacon1 != null){
                                    beacon1.setText(String.valueOf(rssi));
                                }
                            }
                            if(getString(R.string.beacon2).equals(uuid)){
                                list.set(1, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                if(beacon2 != null){
                                    beacon2.setText(String.valueOf(rssi));
                                }
                            }
                            if(getString(R.string.beacon3).equals(uuid)){
                                list.set(2, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                if(beacon3 != null){
                                    beacon3.setText(String.valueOf(rssi));
                                }
                            }
                            if(getString(R.string.beacon4).equals(uuid)){
                                list.set(3, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                if(beacon4 != null){
                                    beacon4.setText(String.valueOf(rssi));
                                }
                            }
                            if(getString(R.string.beacon5).equals(uuid)){
                                list.set(4, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                if(beacon5 != null){
                                    beacon5.setText(String.valueOf(rssi));
                                }
                            }
                            if(getString(R.string.beacon6).equals(uuid)){
                                list.set(5, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                if(beacon6 != null){
                                    beacon6.setText(String.valueOf(rssi));
                                }
                            }
                            if(getString(R.string.beacon7).equals(uuid)){
                                list.set(6, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                if(beacon7 != null){
                                    beacon7.setText(String.valueOf(rssi));
                                }
                            }
                            if(getString(R.string.beacon8).equals(uuid)){
                                list.set(7, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                if(beacon8 != null){
                                    beacon8.setText(String.valueOf(rssi));
                                }
                            }
                            if(getString(R.string.beacon9).equals(uuid)){
                                list.set(8, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                if(beacon9 != null){
                                    beacon9.setText(String.valueOf(rssi));
                                }
                            }
                            if(getString(R.string.beacon10).equals(uuid)){
                                list.set(9, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                if(beacon10 != null){
                                    beacon10.setText(String.valueOf(rssi));
                                }
                            }
                            if(getString(R.string.beacon11).equals(uuid)){
                                list.set(10, new BeaconsProperties(uuid, major, minor, String.valueOf(rssi), distance, "iBeacon"));
                                if(beacon11 != null){
                                    beacon11.setText(String.valueOf(rssi));
                                }
                            }

                            sendDataForPrediction();

                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        Log.d(TAG, "didRangeBeaconsInRegion: "+ e.getMessage());
                    }


                }

            }
        });

        try {
            beaconManager.startRangingBeaconsInRegion(new Region("myRangingUniqueId", null, null, null));
        } catch (RemoteException e) {    }
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

    public void reNewLocation(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            a1T.setBackground(getDrawable(R.color.red));
            a2T.setBackground(getDrawable(R.color.red));
            a3T.setBackground(getDrawable(R.color.red));
            a4T.setBackground(getDrawable(R.color.red));
            a5T.setBackground(getDrawable(R.color.red));
            a6T.setBackground(getDrawable(R.color.red));
            a7T.setBackground(getDrawable(R.color.red));
            a8T.setBackground(getDrawable(R.color.red));
            a9T.setBackground(getDrawable(R.color.red));
            a10T.setBackground(getDrawable(R.color.red));
            a11T.setBackground(getDrawable(R.color.red));
            a12T.setBackground(getDrawable(R.color.red));
            a13T.setBackground(getDrawable(R.color.red));
            a14T.setBackground(getDrawable(R.color.red));
            a15T.setBackground(getDrawable(R.color.red));
            a16T.setBackground(getDrawable(R.color.red));
            a17T.setBackground(getDrawable(R.color.red));
            a18T.setBackground(getDrawable(R.color.red));
            a19T.setBackground(getDrawable(R.color.red));
            a20T.setBackground(getDrawable(R.color.red));
            a21T.setBackground(getDrawable(R.color.red));
            a22T.setBackground(getDrawable(R.color.red));
            a23T.setBackground(getDrawable(R.color.red));
            a24T.setBackground(getDrawable(R.color.red));
            a25T.setBackground(getDrawable(R.color.red));
            a26T.setBackground(getDrawable(R.color.red));
            a27T.setBackground(getDrawable(R.color.red));
            a28T.setBackground(getDrawable(R.color.red));
            a29T.setBackground(getDrawable(R.color.red));
            a30T.setBackground(getDrawable(R.color.red));
            a31T.setBackground(getDrawable(R.color.red));
            a32T.setBackground(getDrawable(R.color.red));
            a33T.setBackground(getDrawable(R.color.red));
            a34T.setBackground(getDrawable(R.color.red));
            a35T.setBackground(getDrawable(R.color.red));
            a36T.setBackground(getDrawable(R.color.red));
            a37T.setBackground(getDrawable(R.color.red));
            a38T.setBackground(getDrawable(R.color.red));
            a39T.setBackground(getDrawable(R.color.red));
            a40T.setBackground(getDrawable(R.color.red));
            a41T.setBackground(getDrawable(R.color.red));
            b41T.setBackground(getDrawable(R.color.red));
            c41T.setBackground(getDrawable(R.color.red));
            c42T.setBackground(getDrawable(R.color.red));
            c43T.setBackground(getDrawable(R.color.red));
            c44T.setBackground(getDrawable(R.color.red));
            c45T.setBackground(getDrawable(R.color.red));
            c46T.setBackground(getDrawable(R.color.red));
            c47T.setBackground(getDrawable(R.color.red));
            c48T.setBackground(getDrawable(R.color.red));
            c49T.setBackground(getDrawable(R.color.red));
            c50T.setBackground(getDrawable(R.color.red));
            d50T.setBackground(getDrawable(R.color.red));
            e50T.setBackground(getDrawable(R.color.red));
            f50T.setBackground(getDrawable(R.color.red));
            g50T.setBackground(getDrawable(R.color.red));
            h50T.setBackground(getDrawable(R.color.red));
            i50T.setBackground(getDrawable(R.color.red));
            i49T.setBackground(getDrawable(R.color.red));
            i48T.setBackground(getDrawable(R.color.red));
            i47T.setBackground(getDrawable(R.color.red));
            i46T.setBackground(getDrawable(R.color.red));
            i45T.setBackground(getDrawable(R.color.red));
            i44T.setBackground(getDrawable(R.color.red));
            i43T.setBackground(getDrawable(R.color.red));
            i42T.setBackground(getDrawable(R.color.red));
            i41T.setBackground(getDrawable(R.color.red));
            i40T.setBackground(getDrawable(R.color.red));
            i39T.setBackground(getDrawable(R.color.red));
            i38T.setBackground(getDrawable(R.color.red));
            i37T.setBackground(getDrawable(R.color.red));
            i36T.setBackground(getDrawable(R.color.red));
            i35T.setBackground(getDrawable(R.color.red));
            i34T.setBackground(getDrawable(R.color.red));
            i33T.setBackground(getDrawable(R.color.red));
            i32T.setBackground(getDrawable(R.color.red));
            i31T.setBackground(getDrawable(R.color.red));
            i30T.setBackground(getDrawable(R.color.red));
            i29T.setBackground(getDrawable(R.color.red));
            i28T.setBackground(getDrawable(R.color.red));
            i27T.setBackground(getDrawable(R.color.red));
            i26T.setBackground(getDrawable(R.color.red));
            i25T.setBackground(getDrawable(R.color.red));
            i24T.setBackground(getDrawable(R.color.red));
            i23T.setBackground(getDrawable(R.color.red));
            i22T.setBackground(getDrawable(R.color.red));
            i21T.setBackground(getDrawable(R.color.red));
            i20T.setBackground(getDrawable(R.color.red));
            i19T.setBackground(getDrawable(R.color.red));
            i18T.setBackground(getDrawable(R.color.red));
            i17T.setBackground(getDrawable(R.color.red));
            i16T.setBackground(getDrawable(R.color.red));
            i15T.setBackground(getDrawable(R.color.red));
            i14T.setBackground(getDrawable(R.color.red));
            i13T.setBackground(getDrawable(R.color.red));
            i12T.setBackground(getDrawable(R.color.red));
            i11T.setBackground(getDrawable(R.color.red));
            i10T.setBackground(getDrawable(R.color.red));
            i9T.setBackground(getDrawable(R.color.red));
            i8T.setBackground(getDrawable(R.color.red));
            i7T.setBackground(getDrawable(R.color.red));
            i6T.setBackground(getDrawable(R.color.red));
            i5T.setBackground(getDrawable(R.color.red));
            i4T.setBackground(getDrawable(R.color.red));
            i3T.setBackground(getDrawable(R.color.red));
            i2T.setBackground(getDrawable(R.color.red));
            i1T.setBackground(getDrawable(R.color.red));
            h1T.setBackground(getDrawable(R.color.red));
            g1T.setBackground(getDrawable(R.color.red));
            f1T.setBackground(getDrawable(R.color.red));
            e1T.setBackground(getDrawable(R.color.red));
            d1T.setBackground(getDrawable(R.color.red));
            c1T.setBackground(getDrawable(R.color.red));
            b1T.setBackground(getDrawable(R.color.red));
        }
    }

    public void settingRoomLocation(String room){
        reNewLocation();
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
            case "['a7']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a7T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a8']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a8T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a9']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a9T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a10']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a10T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a11']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a11T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a12']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a12T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a13']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a13T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a14']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a14T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a15']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a15T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a16']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a16T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a17']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a17T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a18']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a18T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a19']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a19T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a20']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a20T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a21']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a21T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a22']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a22T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a23']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a23T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a24']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a24T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a25']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a25T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a26']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a26T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a27']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a27T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a28']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a28T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a29']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a29T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a30']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a30T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a31']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a31T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a32']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a32T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a33']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a33T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a34']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a34T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a35']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a35T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a36']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a36T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a37']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a37T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a38']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a38T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a39']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a39T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a40']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a40T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['a41']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    a41T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['b41']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    b41T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c41']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c41T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c42']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c42T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c43']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c43T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c45']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c45T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c46']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c46T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c47']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c47T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c48']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c48T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c49']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c49T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c50']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c50T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['d50']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    d50T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['e50']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    e50T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['f50']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    f50T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['g50']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    g50T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['h50']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    h50T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i50']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i50T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i49']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i49T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i48']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i48T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i47']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i47T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i46']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i46T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i45']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i45T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i44']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i44T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i43']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i43T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i42']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i42T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i41']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i41T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i40']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i40T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i39']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i39T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i38']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i38T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i37']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i37T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i36']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i36T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i35']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i35T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i34']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i34T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i33']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i33T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i32']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i32T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i31']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i31T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i30']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i30T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i29']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i29T.setBackground(getDrawable(R.color.blue));
                }
                break;

            case "['i28']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i28T.setBackground(getDrawable(R.color.blue));
                }
                break;

            case "['i27']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i27T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i26']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i26T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i25']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i25T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i24']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i24T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i23']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i23T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i22']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i22T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i21']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i21T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i20']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i20T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i19']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i19T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i18']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i18T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i17']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i17T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i16']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i16T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i15']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i15T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i14']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i14T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i13']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i13T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i12']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i12T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i11']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i11T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i10']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i10T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i9']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i9T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i8']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i8T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i7']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i7T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i6']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i6T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i5']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i5T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i4']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i4T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i3']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i3T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i2']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i2T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['i1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    i1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['h1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    h1T.setBackground(getDrawable(R.color.blue));
                }
                break;

            case "['g1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    g1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['f1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    f1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['e1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    e1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['d1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    d1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['c1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    c1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            case "['b1']":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    b1T.setBackground(getDrawable(R.color.blue));
                }
                break;
            default:
//                Toast.makeText(this, "Sorry, this address is not found", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void sendDataForPrediction() {
        JsonApiHolder service = RestApi.getApi();
        String rssi1,rssi2, rssi3, rssi4, rssi5, rssi6, rssi7, rssi8, rssi9, rssi10, rssi11, modelString;
        modelString = String.valueOf(model.getSelectedItemPosition() + 1);
        Log.d(TAG, "sendDataForPrediction: " + modelString);
        if(beacon1 != null){
            rssi1 = beacon1.getText().toString();
        }else{
            rssi1 = "0";
        }
        if(beacon2 != null){
            rssi2 = beacon2.getText().toString();
        }else{
            rssi2 = "0";
        }
        if(beacon3 != null){
            rssi3 = beacon3.getText().toString();
        }else{
            rssi3 = "0";
        }
        if(beacon4 != null){
            rssi4 = beacon4.getText().toString();
        }else{
            rssi4 = "0";
        }
        if(beacon5 != null){
            rssi5 = beacon5.getText().toString();
        }else{
            rssi5 = "0";
        }
        if(beacon6 != null){
            rssi6 = beacon6.getText().toString();
        }else{
            rssi6 = "0";
        }
        if(beacon7 != null){
            rssi7 = beacon7.getText().toString();
        }else{
            rssi7 = "0";
        }
        if(beacon8 != null){
            rssi8 = beacon8.getText().toString();
        }else{
            rssi8 = "0";
        }
        if(beacon9 != null){
            rssi9 = beacon9.getText().toString();
        }else{
            rssi9 = "0";
        }
        if(beacon10 != null){
            rssi10 = beacon10.getText().toString();
        }else{
            rssi10 = "0";
        }
        if(beacon11 != null){
            rssi11 = beacon11.getText().toString();
        }else{
            rssi11 = "0";
        }
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
        if(rssi7.equals("B7")){
            rssi7 = "0";
        }
        if(rssi8.equals("B8")){
            rssi8 = "0";
        }
        if(rssi9.equals("B9")){
            rssi9 = "0";
        }
        if(rssi10.equals("B10")){
            rssi10 = "0";
        }
        if(rssi11.equals("B11")){
            rssi11 = "0";
        }

        Log.d(TAG, "sendDataForPrediction: " + rssi4);
        Log.d(TAG, "sendDataForPrediction: " + rssi2);


        Call<Room> call = service.predictNewMap(
                rssi1,
                rssi2,
                rssi3,
                rssi4,
                rssi5,
                rssi6,
                rssi7,
                rssi8,
                rssi9,
                rssi10,
                rssi11,
                modelString
        );
        call.enqueue(new Callback<Room>() {
            @Override
            public void onResponse(Call<Room> call, Response<Room> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+ response.body().getRoom());
                    settingRoomLocation(response.body().getRoom());
                }else {
                    Toast.makeText(BaeconsWithLocationNewMap.this, "Cannot comunicate with server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Room> call, Throwable t) {
                Toast.makeText(BaeconsWithLocationNewMap.this, "Cannot comunicate with server " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
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


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
        }

        if(item.getItemId() == R.id.action_oldMap){
            startActivity(new Intent(this, BeaconsWithLocations.class));

        }


        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unbinder.unbind();
        beaconManager.unbind(this);

    }

}
