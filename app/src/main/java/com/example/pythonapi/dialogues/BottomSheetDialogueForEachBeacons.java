package com.example.pythonapi.dialogues;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pythonapi.R;
import com.example.pythonapi.model.BeaconsProperties;
import com.example.pythonapi.ui.LocationActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class BottomSheetDialogueForEachBeacons extends BottomSheetDialogFragment {
    private static final String TAG = "BottomSheetDialogueCompose";
    private View view;
    private Unbinder unbinder;
    private BeaconsProperties properties;

    private String detailString;

    public BottomSheetDialogueForEachBeacons(BeaconsProperties properties, String detailString) {
        this.properties = properties;
        this.detailString = detailString;
    }

    @BindView(R.id.detail)
    TextView detail;

    @BindView(R.id.uuid)
    TextView uuid;

    @BindView(R.id.major)
    TextView major;

    @BindView(R.id.minor)
    TextView minor;

    @BindView(R.id.rssi)
    TextView rssi;

    @BindView(R.id.beaconType)
    TextView beaconType;

    @SuppressLint("LongLogTag")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_for_each_beacons, container, false);
        if (unbinder == null) {
            unbinder = ButterKnife.bind(this, view);
        }
        initializeValues();
        detail.setText(detailString);

        return view;
    }

    private void initializeValues() {
        rssi.setText(properties.getRssi());
        major.setText(properties.getMajor());
        minor.setText(properties.getMinor());
        beaconType.setText(properties.getName());
        uuid.setText(properties.getUuid());
    }


}
