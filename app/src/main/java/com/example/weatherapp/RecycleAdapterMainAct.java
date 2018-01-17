package com.example.weatherapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import org.xml.sax.SAXException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class RecycleAdapterMainAct extends RecyclerView.Adapter<RowHolderMainAct>  {

    private Context mcontext2;
    private ArrayList<SavedWeather> listdata2;
    RowHolderMainAct holdmain;


    public RecycleAdapterMainAct(Context mcontext, ArrayList<SavedWeather> listdata){
        this.listdata2 = listdata;
        this.mcontext2 = mcontext;
   //    Log.d("premam","Inside Recycle Adapter:");


    }



    @Override
    public int getItemCount() {

    //    Log.d("premam","Inside  Recycle Adapter count");
        if(listdata2.size()!=0)
        {
            return listdata2.size();
        }
        else
            return 0;
    }


    @Override
    public RowHolderMainAct onCreateViewHolder(ViewGroup parent, int viewType) {
        mcontext2 = parent.getContext();

     //   Log.d("premam","Inside On Create View Holder");
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.main_activity_recycler, null);
        RowHolderMainAct holder5 = new RowHolderMainAct(view,mcontext2,listdata2);

        return holder5;
    }

    @Override
    public void onBindViewHolder(RowHolderMainAct holder5, int position) {

        holdmain = holder5;
        final SavedWeather weathersav =listdata2.get(position);

        holdmain.updateddate.setText(weathersav.getDate());
        if(weathersav.getFavorite().equals("false")) {
            Picasso.with(mcontext2).load(R.drawable.star_gray).into(holdmain.imageviestar);
        }
        else {
            Picasso.with(mcontext2).load(R.drawable.star_gold).into(holdmain.imageviestar);
        }

        holdmain.imageviestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(mcontext2).load(R.drawable.star_gold).into(holdmain.imageviestar);

            }
        });
        holdmain.tempsaved.setText(weathersav.getTemperature() + "\u00B0" + " C");
        holdmain.citycountry.setText(weathersav.getCityname()+", " + weathersav.getCountryname());

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
