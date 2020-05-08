package com.logohungry.findoffer.findoffers;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.scottyab.aescrypt.AESCrypt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by vikramsingh on 18/01/18.
 */

public class JSONData {

    private Context context;
    private RequestQueue requestQueue;
    private JSONObject jsonObject;
    private String token = "<ommited>";
    private String la, lo;
    private OfferAdapter adapter;
    List<Offers> offersList;
     List<Offers> off = new ArrayList<>();
     Dialog pd;

     int flag =0;


    public JSONData(RequestQueue q, OfferAdapter o, String lati, String longi, List<Offers> offers,Dialog pb) {
        adapter = o;
        requestQueue = q;
        la = lati;
        lo = longi;
        offersList = offers;
        pd =pb;

    }

    public JSONData() {

    }
/*
    public void callJSON(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            jsonObject = new JSONObject(response);

                            JSONArray name = jsonObject.getJSONArray("name");
                            JSONArray coordinates = jsonObject.getJSONArray("coordinates");
                            JSONArray dest = jsonObject.getJSONArray("destination_addresses");
                            JSONArray mylocation = jsonObject.getJSONArray("startlocation_name");
                            JSONArray image_name = jsonObject.getJSONArray("image_address");

                            DATA.location_name = mylocation.getString(0);


                            //JSONArray dist_array = jsonObject.getJSONArray("rows");

                            //  JSONObject dis_obj = dist_array.getJSONObject(0);
                            // JSONArray dist_array1  = dis_obj.getJSONArray("elements");


                            for (int i = 0; i < name.length(); i++) {
                                String n = name.getString(i);
                                String add = dest.getString(i);
                                String coord = coordinates.getString(i);
                                String img_name = image_name.getString(i);

                                String[] coo = coord.split(",");
                                String latitude = coo[0];
                                String longitude = coo[1];

                                JSONObject jsonRespRouteDistance = new JSONObject(response)
                                        .getJSONArray("rows")
                                        .getJSONObject(0)
                                        .getJSONArray("elements")
                                        .getJSONObject(i)
                                        .getJSONObject("distance");

                                String distance = jsonRespRouteDistance.get("text").toString();

                                offersList.add(new Offers(n, add, Float.parseFloat(latitude), Float.parseFloat(longitude), distance,img_name));

                                Log.e("NAME : ", n + "\n");
                            }


                            Collections.sort(offersList, new Comparator<Offers>() {
                                @Override
                                public int compare(Offers offers, Offers t1) {
                                    return (offers.getOffer_distance() < t1.getOffer_distance())
                                            ?
                                            -1
                                            : (offers.getOffer_distance() > t1.getOffer_distance())
                                            ? 1
                                            : 0;
                                }
                            });

                            if (adapter != null)
                                adapter.notifyDataSetChanged();

                            DATA.location_name=mylocation.getString(0);
                            pd.dismiss();



                        } catch (JSONException e) {
                            Log.e("JSON ERR : ", e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("token", token);
                params.put("latitude", la);
                params.put("longitude", lo);

                return params;
            }


        };
        requestQueue.add(stringRequest);


    }



    public void getData(RequestQueue rq, final String lati, final String longi, String urll, final GoogleMap map) {




        StringRequest stringRequest = new StringRequest(Request.Method.POST, urll,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            jsonObject = new JSONObject(response);

                            JSONArray name = jsonObject.getJSONArray("name");
                            JSONArray coordinates = jsonObject.getJSONArray("coordinates");
                            JSONArray dest = jsonObject.getJSONArray("destination_addresses");
                            JSONArray image_name = jsonObject.getJSONArray("image_address");

                            //JSONArray dist_array = jsonObject.getJSONArray("rows");

                            //  JSONObject dis_obj = dist_array.getJSONObject(0);
                            // JSONArray dist_array1  = dis_obj.getJSONArray("elements");



                            for (int i = 0; i < name.length(); i++) {
                                String n = name.getString(i);
                                String add = dest.getString(i);
                                String coord = coordinates.getString(i);
                                String img_name = image_name.getString(i);

                                String[] coo = coord.split(",");
                                String latitude = coo[0];
                                String longitude = coo[1];

                                JSONObject jsonRespRouteDistance = new JSONObject(response)
                                        .getJSONArray("rows")
                                        .getJSONObject(0)
                                        .getJSONArray("elements")
                                        .getJSONObject(i)
                                        .getJSONObject("distance");

                                String distance = jsonRespRouteDistance.get("text").toString();

                                off.add(new Offers(n, add, Float.parseFloat(latitude), Float.parseFloat(longitude), distance,img_name));




                                Log.e("NAME : ", n + "\n");
                            }
                            for(Offers o : off)
                            {
                                 map.addMarker(new MarkerOptions().position(new LatLng(o.getLatitude(),o.getLongitude())).title(o.getOffer_name()).snippet(o.getOffer_distanceInKM()));
                                Log.d("LAT: ",String.valueOf(o.getLatitude()));
                                Log.d("NAME :",String.valueOf(o.getOffer_name()));
                            }


                        } catch (JSONException e) {
                            Log.e("JSON ERR : ", e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("token", token);
                params.put("latitude", lati);
                params.put("longitude", longi);

                return params;
            }


        };

        rq.add(stringRequest);


    }

*/

    public void getJSONDATAatLocationPage(final String url, final RequestQueue rrequestQueue, final String lati, final String longi, final Loading loading) {



        Log.e("INSIDE getDATA ",".");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {



                    @Override
                    public void onResponse( String response) {
                        try {

                            waitFordata(response,loading);

                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.startActivity(new Intent(loading,ErrorOrNotFound.class));
                        loading.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    }
                }
        ) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("token", token);
                params.put("latitude", lati);
                params.put("longitude", longi);

                return params;
            }


            @Override
            public Priority getPriority() {
                return Priority.HIGH;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
               5000,10,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));



        rrequestQueue.add(stringRequest);

        rrequestQueue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {

            @Override
            public void onRequestFinished(Request<Object> request) {
                rrequestQueue.getCache().clear();
            }
        });



    }

public void createUser(RequestQueue requestQueue,String message)
{
    String url="http://192.168.0.5/user";

    final String encypt_mess = DATA.encrypt(message);


    StringRequest request= new StringRequest(Request.Method.POST, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d(" creating user res :: ",response);
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();

                }
            }

    ){
        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap<>();
            params.put("id",encypt_mess);

            return params;
        }

    };

    requestQueue.add(request);
}


void waitFordata(String response,Loading loading)
{
    while (response.length()==0)
    {

    }

    try {

        JSONObject jsonObject = new JSONObject(response);


        JSONArray name = jsonObject.getJSONArray("name");
        JSONArray coordinates = jsonObject.getJSONArray("coordinates");
        JSONArray dest = jsonObject.getJSONArray("destination_addresses");
        JSONArray mylocation = jsonObject.getJSONArray("startlocation_name");
        JSONArray image_name = jsonObject.getJSONArray("image_address");

        DATA.location_name = mylocation.getString(0);


        //JSONArray dist_array = jsonObject.getJSONArray("rows");

        //  JSONObject dis_obj = dist_array.getJSONObject(0);
        // JSONArray dist_array1  = dis_obj.getJSONArray("elements");


        for (int i = 0; i < name.length(); i++) {
            String n = name.getString(i);
            String add = dest.getString(i);
            String coord = coordinates.getString(i);
            String img_name = image_name.getString(i);

            String[] coo = coord.split(",");
            String latitude = coo[0];
            String longitude = coo[1];

            JSONObject jsonRespRouteDistance = new JSONObject(response)
                    .getJSONArray("rows")
                    .getJSONObject(0)
                    .getJSONArray("elements")
                    .getJSONObject(i)
                    .getJSONObject("distance");

            String distance = jsonRespRouteDistance.get("text").toString();

            DATA.offers.add(new Offers(n, add, Float.parseFloat(latitude), Float.parseFloat(longitude), distance, img_name));

            Log.e("NAME : ", n + "\n");
        }


        Collections.sort(DATA.offers, new Comparator<Offers>() {
            @Override
            public int compare(Offers offers, Offers t1) {
                return (offers.getOffer_distance() < t1.getOffer_distance())
                        ?
                        -1
                        : (offers.getOffer_distance() > t1.getOffer_distance())
                        ? 1
                        : 0;
            }
        });


        loading.startActivity(new Intent(loading, Content_to_MainScreen.class));
        loading.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);



    } catch (JSONException e) {
        Log.e("JSON ERR : ", e.toString());
        e.printStackTrace();
        loading.startActivity(new Intent(loading, ErrorOrNotFound.class));
        loading.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


    }
}

}



