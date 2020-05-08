package com.logohungry.findoffer.findoffers;

import android.support.annotation.NonNull;

import com.android.volley.toolbox.StringRequest;

/**
 * Created by vikramsingh on 16/01/18.
 */

public class Offers  {
    private String offer_name,offer_location,distance_in_KM,image_url;
    private  float latitude,longitude,distance;


    public Offers(String name,String location,float lati,float longi,String dist,String image_name)
    {
        offer_name = name;
        offer_location =location;
        latitude = lati;
        longitude = longi;
        distance_in_KM = dist;
        distance = toDistance(dist);
        image_url = image_name;

    }

    private float toDistance(String d)
    {
        float dist =0f;

        d =d.replaceAll("\\s","");
        d = d.replace("km","");
        return Float.parseFloat(d);
    }

    public String getOffer_name() {
        return offer_name;
    }


    public float  getOffer_distance() {
        return distance;
    }

    public String getOffer_distanceInKM() {return String.valueOf(distance)+" km"; }

    public String getOffer_location() {
        return offer_location;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getImage_url() {
        return image_url;
    }

}
