package com.example.weatherapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class RecycleAdapter extends RecyclerView.Adapter<RowHolder>  {

    private Context mcontext;
    private List<AverageWeather> listdata;
    RowHolder hold;



    public RecycleAdapter(Context mcontext,List<AverageWeather> listdata){
        this.listdata = listdata;
        this.mcontext = mcontext;

        Log.d("premam","Inside Recycle Adapter:");


    }



    @Override
    public int getItemCount() {

        Log.d("premam","Inside  Recycle Adapter count");
        if(listdata.size()!=0)
        {
            return listdata.size();
        }
        else
            return 0;
    }


    @Override
    public RowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mcontext=parent.getContext();

        Log.d("premam","Inside On Create View Holder");
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_hold, null);
        RowHolder holder = new RowHolder(view, mcontext, (ArrayList<AverageWeather>) listdata);

        return holder;
    }

    @Override
    public void onBindViewHolder(RowHolder holder, int position) {

        hold=holder;
        final AverageWeather avgweather=listdata.get(position);

        hold.tempTV.setText(Math.round(Double.parseDouble(avgweather.getAvgtempnew()) * 100.0) / 100.0 + "\u00B0" + " C");
        Picasso.with(mcontext).load(avgweather.getAvgiconurlnew()).into(hold.Image);
        String str = parseDateToddMMyyyy(avgweather.getAvgdatenew());
        hold.dateTV.setText(str);
    //    Log.d("premam","Inside OnBindView:"+avgweather.() );


    }


    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "MMM, dd yyyy";
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
