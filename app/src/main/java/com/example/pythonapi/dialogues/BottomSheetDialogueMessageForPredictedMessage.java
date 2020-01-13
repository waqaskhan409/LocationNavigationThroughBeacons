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
import com.example.pythonapi.ui.LocationActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class BottomSheetDialogueMessageForPredictedMessage extends BottomSheetDialogFragment {
    private static final String TAG = "BottomSheetDialogueCompose";
    private View view;
    private Unbinder unbinder;
    private String predictedResult;


    public BottomSheetDialogueMessageForPredictedMessage(String predictedResult) {
        this.predictedResult = predictedResult;
    }

    @BindView(R.id.predictedResult)
    TextView predictedResultT;

    @BindView(R.id.location)
    Button location;

    @SuppressLint("LongLogTag")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_for_predicted_result, container, false);
        if (unbinder == null) {
            unbinder = ButterKnife.bind(this, view);
        }
        Log.d(TAG, "onCreateView: " + predictedResult);
        predictedResultT.setText(predictedResult);

        return view;
    }

    @OnClick(R.id.location)
    public void setLocation(){
        Intent intent = new Intent(getContext(), LocationActivity.class);
        intent.putExtra(getString(R.string.get_room_object), predictedResult);
        startActivity(intent);
    }



}
