package com.logohungry.findoffer.findoffers;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by vikramsingh on 16/01/18.
 */

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.MyViewHolder> {

    private List<Offers> offersList;
    private  Context context;
    Typeface f1,f1_bold;

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView offer_location_name,offer_distance,offer;
        public ImageView offer_image;


        public MyViewHolder(View view)
        {
            super(view);


            offer_distance = view.findViewById(R.id.offer_distance_single);
            offer_location_name = view.findViewById(R.id.offer_location_name_single);
            offer = view.findViewById(R.id.offer_tv_single);
            offer_image = (ImageView) view.findViewById(R.id.offer_image_single);


        }



    }

    public OfferAdapter(List<Offers> offers,Context context){
        offersList = offers;
        this.context = context;
        f1= Typeface.createFromAsset(context.getAssets(),"montserrat_semibold.otf");
        f1_bold= Typeface.createFromAsset(context.getAssets(), "montserrat_bold.otf");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_offers_single,parent,false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Offers offers = offersList.get(position);
        holder.offer.setText(offers.getOffer_name());
        holder.offer.setTypeface(f1_bold);
       // holder.offer.setTextColor(Color.parseColor("#c0392b"));
        holder.offer_location_name.setText(offers.getOffer_location());
        holder.offer_location_name.setTypeface(f1);
      //  holder.offer_location_name.setTextColor(Color.parseColor("#c0392b"));
        holder.offer_distance.setText(offers.getOffer_distanceInKM());
        holder.offer_distance.setTypeface(f1);
       //  holder.offer_distance.setTextColor(Color.parseColor("#c0392b"));

        Picasso.with(context).setLoggingEnabled(true);
        Picasso.with(context).load("http://findoffer.tk/imgs/"+offers.getImage_url()+".jpg").error(R.drawable.not_avail).into(holder.offer_image);
        Log.e("PIC NAME : ",". "+offers.getImage_url());

    }



    @Override
    public void onViewAttachedToWindow(MyViewHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public int getItemCount() {
        return  offersList.size();
    }

}
