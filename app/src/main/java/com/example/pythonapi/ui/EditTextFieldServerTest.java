package com.example.pythonapi.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.example.pythonapi.R;
import com.example.pythonapi.beacons.BeaconSearc;
import com.example.pythonapi.dialogues.BottomSheetDialogueMessageForPredictedMessage;
import com.example.pythonapi.interfaces.JsonApiHolder;
import com.example.pythonapi.model.Room;
import com.example.pythonapi.rest_api.RestApi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditTextFieldServerTest extends AppCompatActivity {
    private static final String TAG = "EditTextFieldServerTest";
    private static final int PERMISSION_REQUEST_COARSE_LOCATION = 1;



    /* DataBinding through butterknife library */
    private Unbinder unbinder;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.wap1)
    EditText wap1;

    @BindView(R.id.wap2)
    EditText wap2;

    @BindView(R.id.wap3)
    EditText wap3;

    @BindView(R.id.wap4)
    EditText wap4;

    @BindView(R.id.wap5)
    EditText wap5;

    @BindView(R.id.wap6)
    EditText wap6;

    @BindView(R.id.wap7)
    EditText wap7;

    @BindView(R.id.room)
    Button room;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(unbinder == null){
            unbinder = ButterKnife.bind(this);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.room)
    public void sendingData(){
        gettingValues();
    }

    private void gettingValues() {
        String wap1S, wap2S, wap3S, wap4S, wap5S, wap6S, wap7S;
        wap1S = wap1.getText().toString().trim();
        wap2S = wap2.getText().toString().trim();
        wap3S = wap3.getText().toString().trim();
        wap4S = wap4.getText().toString().trim();
        wap5S = wap5.getText().toString().trim();
        wap6S = wap6.getText().toString().trim();
        wap7S = wap7.getText().toString().trim();
        if(wap1S == null || wap1S.isEmpty()){
         wap1.setError(getString(R.string.empty_edit_text));
         wap1.requestFocus();
        }else if(wap2S == null || wap2S.isEmpty()){
            wap2.setError(getString(R.string.empty_edit_text));
            wap2.requestFocus();
        }else if(wap3S == null || wap3S.isEmpty()){
            wap3.setError(getString(R.string.empty_edit_text));
            wap3.requestFocus();
        }else if(wap4S == null || wap4S.isEmpty()){
            wap4.setError(getString(R.string.empty_edit_text));
            wap4.requestFocus();
        }else if(wap5S == null || wap5S.isEmpty()){
            wap5.setError(getString(R.string.empty_edit_text));
            wap5.requestFocus();
        }else if(wap6S == null || wap6S.isEmpty()){
            wap6.setError(getString(R.string.empty_edit_text));
            wap6.requestFocus();
        }else if(wap7S == null || wap7S.isEmpty()){
            wap7.setError(getString(R.string.empty_edit_text));
            wap7.requestFocus();
        }else {
            sendDataForPredict(wap1S, wap2S, wap3S, wap4S, wap5S, wap6S, wap7S);
        }
    }

    private void sendDataForPredict(String wap1S, String wap2S, String wap3S, String wap4S, String wap5S, String wap6S, String wap7S) {
        JsonApiHolder service = RestApi.getApi();
        Call<Room> call = service.predict(
                wap1S,
                wap2S,
                wap3S,
                wap4S,
                wap5S,
                wap6S,
                wap7S
                );
        call.enqueue(new Callback<Room>() {
            @Override
            public void onResponse(Call<Room> call, Response<Room> response) {
                if(response.isSuccessful()){
                    BottomSheetDialogueMessageForPredictedMessage message = new
                            BottomSheetDialogueMessageForPredictedMessage(response.body().getRoom());
                    message.show(getSupportFragmentManager(), "JustDialogue");
                }else {
                    Toast.makeText(EditTextFieldServerTest.this, "Cannot comunicate with server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Room> call, Throwable t) {
                Toast.makeText(EditTextFieldServerTest.this, "Cannot comunicate with server " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder = null;
    }


}
