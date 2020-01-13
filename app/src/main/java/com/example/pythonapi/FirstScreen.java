package com.example.pythonapi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.pythonapi.R;
import com.example.pythonapi.beacons.BeaconSearc;
import com.example.pythonapi.ui.BaeconsWithLocationNewMap;
import com.example.pythonapi.ui.BeaconsWithLocations;
import com.example.pythonapi.ui.EditTextFieldServerTest;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FirstScreen extends AppCompatActivity {
    private static final String TAG = "FirstScreen";
    private static final int PERMISSION_REQUEST_COARSE_LOCATION = 1;


    private Unbinder unbinder;


    @BindView(R.id.rssiLocation)
    LinearLayout rssiLocation;



    @BindView(R.id.fieldTest)
    LinearLayout fieldTest;



    @BindView(R.id.allBeacons)
    LinearLayout allBeacons;


    @BindView(R.id.exit)
    LinearLayout exit;


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen2);

        if(unbinder == null){
            unbinder = ButterKnife.bind(this);
        }
        setSupportActionBar(toolbar);
        checkPermission();

    }
    @OnClick(R.id.rssiLocation)
    public void rssiLocationActivity(){
        startActivity(new Intent(this, BaeconsWithLocationNewMap.class));
//        startActivity(new Intent(this, BeaconsWithLocations.class));

    }
    @OnClick(R.id.fieldTest)
    public void fieldTestActivity(){
        startActivity(new Intent(this, EditTextFieldServerTest.class));
    }

    @OnClick(R.id.allBeacons)
    public void allbeaconActivity(){
        startActivity(new Intent(this, BeaconSearc.class));
    }

    @OnClick(R.id.exit)
    public void exitActivity(){
        finish();
        return;
    }
    // Checking Permission whether ACCESS_COARSE_LOCATION permssion is granted or not
    public void checkPermission(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (this.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("Location Permission");
                builder.setPositiveButton("OK",null);
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @TargetApi(Build.VERSION_CODES.M)
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},PERMISSION_REQUEST_COARSE_LOCATION);
                    }
                });
                builder.show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_COARSE_LOCATION: {

                // If Permission is Granted than its ok
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                }

                // If not Granted then alert the user by the message
                else {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Functionality limited");
                    builder.setMessage("Since location access has not been granted, this app will not be able to discover beacons when in the background.");
                    builder.setPositiveButton(android.R.string.ok, null);
                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            checkPermission();
                        }
                    });
                    builder.show();
                }
                return;
            }
        }
    }



}
