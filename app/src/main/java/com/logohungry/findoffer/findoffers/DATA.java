package com.logohungry.findoffer.findoffers;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;

import com.google.android.gms.maps.model.LatLng;
import com.scottyab.aescrypt.AESCrypt;

import org.json.JSONObject;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikramsingh on 24/01/18.
 */

public  class DATA {

    public static String location_name;
    public static String email;
    public static String token;
    public static String name;
    public static String latitute;
    public static String longitude;
    public static LatLng coordinates;
    public static int white_color = Color.parseColor("#F5F5F5");
    public static int bluish_white_color = Color.parseColor("#f2f4fd");
    public static boolean liesure = false;
    public static boolean foods = false;
    public static boolean apparels = false;
    public static boolean music = false;
    public static boolean home_items = false;
    public static boolean cosmetic = false;
    public static boolean books = false;
    public static JSONObject jsonObject;

    public static String encrypt(String message)
    {
        String encyptedmessage = "";

        String secret_key="<key removed intentionaly>";
        try
        {
            encyptedmessage = AESCrypt.encrypt(secret_key,message);
        }
        catch (GeneralSecurityException e)
        {
            e.printStackTrace();
        }

        return encyptedmessage;
    }
    public static String decrypt(String message) //NOT working
    {
        String encyptedmessage = "";

        String secret_key="vikram489";
        AESCrypt.DEBUG_LOG_ENABLED=true;
        try
        {
            encyptedmessage = AESCrypt.decrypt(secret_key,message);
        }
        catch (GeneralSecurityException e)
        {
            e.printStackTrace();
        }

        return encyptedmessage;
    }
    public static List<Offers> offers ;

}
