package com.example.weatherapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



public class RowHolderBelow extends RecyclerView.ViewHolder implements View.OnClickListener {

    Context context2;
    ArrayList<Weather> RowHolderList2;
    Weather weatherbelow;

    protected TextView timebelow;
    protected ImageView imageviewbelow;
    protected TextView tempbelow;
    protected TextView condition;
    protected TextView pressure;
    protected TextView humidity;
    protected TextView wind;
    protected LinearLayout linearLayout2;





    public RowHolderBelow(View itemView, Context context, ArrayList<Weather> list) {
        super(itemView);


        this.context2=context;
        this.RowHolderList2=list;
        itemView.setOnClickListener(this);


        this.timebelow =(TextView) itemView.findViewById(R.id.textView_timebelow);
        this.imageviewbelow = (ImageView) itemView.findViewById(R.id.imageView_below);
        this.tempbelow=(TextView)itemView.findViewById(R.id.TempTV);
        this.pressure=(TextView)itemView.findViewById(R.id.PressureTV);
        this.humidity=(TextView)itemView.findViewById(R.id.HumidityTV);
        this.wind=(TextView)itemView.findViewById(R.id.WindTV);
        this.condition=(TextView)itemView.findViewById(R.id.ConditionTV);
        this.linearLayout2 = (LinearLayout) itemView.findViewById(R.id.Layout);
    }

    @Override
    public void onClick(View v) {

    }
}
