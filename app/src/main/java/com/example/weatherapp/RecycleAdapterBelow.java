package com.example.weatherapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class RecycleAdapterBelow extends RecyclerView.Adapter<RowHolderBelow>  {

    private Context mcontext1;
    private ArrayList<Weather> listdata1;
    RowHolderBelow hold1;


    public RecycleAdapterBelow(Context mcontext, ArrayList<Weather> listdata){
        this.listdata1 = listdata;
        this.mcontext1 = mcontext;
   //    Log.d("premam","Inside Recycle Adapter:");


    }



    @Override
    public int getItemCount() {

    //    Log.d("premam","Inside  Recycle Adapter count");
        if(listdata1.size()!=0)
        {
            return listdata1.size();
        }
        else
            return 0;
    }


    @Override
    public RowHolderBelow onCreateViewHolder(ViewGroup parent, int viewType) {
        mcontext1 = parent.getContext();

     //   Log.d("premam","Inside On Create View Holder");
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_recyclerbelow, null);
        RowHolderBelow holder1 = new RowHolderBelow(view,mcontext1,listdata1);

        return holder1;
    }

    @Override
    public void onBindViewHolder(RowHolderBelow holder1, int position) {

        hold1 = holder1;
        final Weather weatherbelow =listdata1.get(position);

        hold1.timebelow.setText(parseTimeToAMPM(weatherbelow.getTime()));
        Picasso.with(mcontext1).load(weatherbelow.getWeathericonurl()).into(hold1.imageviewbelow);
        hold1.tempbelow.setText(weatherbelow.getTemperature() + "\u00B0" + " C");
        hold1.condition.setText(weatherbelow.getCondition());
        hold1.pressure.setText(weatherbelow.getPressure());
        hold1.humidity.setText(weatherbelow.getHumidity());
        hold1.wind.setText(weatherbelow.getWindspeed() + " " + weatherbelow.getWinddirection());

    //    Log.d("premam","Inside OnBindView:"+avgweather.() );


    }


    public String parseTimeToAMPM(String time) {
        String inputPattern = "HH:mm:ss";
        String outputPattern = "h:mm a";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }
}
