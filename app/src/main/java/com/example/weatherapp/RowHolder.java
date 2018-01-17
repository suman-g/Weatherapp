package com.example.weatherapp;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



public class RowHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

    Context context;
    ArrayList<AverageWeather> RowHolderList;
    Weather weather;

    protected TextView dateTV;
    protected ImageView Image;
    protected TextView tempTV;

    protected LinearLayout linearLayout;





    public RowHolder(View itemView,Context context, ArrayList<AverageWeather> list) {
        super(itemView);



        this.context=context;
        this.RowHolderList=list;
        itemView.setOnClickListener(this);


        this.Image=(ImageView)itemView.findViewById(R.id.imageView_avg);
        this.dateTV=(TextView)itemView.findViewById(R.id.textView1);
        this.tempTV=(TextView)itemView.findViewById(R.id.textView2);
        this.linearLayout= (LinearLayout) itemView.findViewById(R.id.Layout);
    }

    @Override
    public void onClick(View v) {
        int position = getLayoutPosition();
        ((CityWeather) context).calladapter(position);
    }

}
