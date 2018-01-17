package com.example.weatherapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class RowHolderMainAct extends RecyclerView.ViewHolder implements View.OnClickListener {

     Context context3;
     ArrayList<SavedWeather> RowHolderList3;
     SavedWeather weatherbelow2;

    protected TextView citycountry;
    protected ImageView imageviestar;
    protected TextView tempsaved;
    protected TextView updateddate;

    protected LinearLayout linearLayout2;





    public RowHolderMainAct(View itemView, Context context, ArrayList<SavedWeather> list) {
        super(itemView);


        this.context3=context;
        this.RowHolderList3=list;
        itemView.setOnClickListener(this);


        this.updateddate =(TextView) itemView.findViewById(R.id.textView_updateddate);
        this.imageviestar = (ImageView) itemView.findViewById(R.id.imageView_star);
        this.tempsaved=(TextView)itemView.findViewById(R.id.textView_tempsaved);
        this.citycountry=(TextView)itemView.findViewById(R.id.textView_citycountry);
        this.linearLayout2 = (LinearLayout) itemView.findViewById(R.id.Layout);
    }

    @Override
    public void onClick(View v) {
        int position = getLayoutPosition();
        ((MainActivity) context3).calladapter(position);
    }
}
