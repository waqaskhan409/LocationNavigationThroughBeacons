package com.example.pythonapi.beacons;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pythonapi.R;

import java.util.ArrayList;

/*
     Adapter for Recycler View
*/
public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<ArrayList<String>> arr;

    // Constructor
    public RecyclerAdapter(ArrayList<ArrayList<String>> arr)
    {
        this.arr = arr;
    }

    /*
       View Holder class to instantiate views
     */
    class ViewHolder extends RecyclerView.ViewHolder{

        //UUID
        private TextView uuid;

        //Major
        private TextView major;

        //Minor
        private TextView minor;

        //Distance
        private TextView distance;


        //RSSI
        private TextView rssi;

        //View Holder Class Constructor
        public ViewHolder(View itemView)
        {
            super(itemView);

            //Initializing views
            uuid = itemView.findViewById(R.id.uuid);
            major = itemView.findViewById(R.id.major);
            minor = itemView.findViewById(R.id.minor);
            distance = itemView.findViewById(R.id.distance);
            rssi = itemView.findViewById(R.id.rssi);
        }
    }


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_search,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        // Getting Array List within respective position
        ArrayList<String> arrayList = arr.get(position);

        // Checking if arrayList size > 0
        if (arrayList.size()>0){

            // Displaying UUID
            holder.uuid.setText(arrayList.get(0));

            //Displaying Major
            holder.major.setText(arrayList.get(1));

            //Displaying Minor
            holder.minor.setText(arrayList.get(2));

            //Displaying distance
            holder.distance.setText(arrayList.get(3));

            //Displaying rssi
            holder.rssi.setText(arrayList.get(4));
        }
    }
    @Override
    public int getItemCount()
    {
        return arr.size();
    }
}