package com.example.pythonapi.ui;

import android.os.Build;
import android.os.Bundle;

import com.example.pythonapi.model.Room;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pythonapi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LocationActivity extends AppCompatActivity {
    private static final String TAG = "LocationActivity";
    private Unbinder unbinder;
    private Bundle data;
    private String room;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        if(unbinder == null){
            unbinder = ButterKnife.bind(this);
        }

        if(data == null){
            data = getIntent().getExtras();
            room = data.getString(getString(R.string.get_room_object));
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        settingLocation();
    }

    private void settingLocation() {
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
                Toast.makeText(this, "Sorry, this address is not found", Toast.LENGTH_SHORT).show();

        }
    }


}
