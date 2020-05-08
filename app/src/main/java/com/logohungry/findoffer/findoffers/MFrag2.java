package com.logohungry.findoffer.findoffers;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by rudranildas on 05/01/18.
 */

public class MFrag2 extends Fragment implements OnMapReadyCallback{

    GoogleMap map;
    MapView mapView;
    View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET},1);

        ViewGroup v = (ViewGroup)  inflater.inflate(R.layout.frag2,container,false);

        view = v;
        mapView = v.findViewById(R.id.mapView);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        if(mapView !=null)
        {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        map = googleMap;

        /*Cache cache = new DiskBasedCache(getContext().getCacheDir(),1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        RequestQueue queue = new RequestQueue(cache,network);
        queue.start();*/

       // JSONData data =new JSONData();

        //data.getData(CustomVolleyRequestQueue.getmInstance(getContext()).getmRequestQueue(),"12.850809","77.648472","http://192.168.0.4/list",googleMap);



        LatLng myloc = new LatLng(12.850809,77.648472);

       // View marker = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker,null);

       // ImageView pic = (ImageView) marker.findViewById(R.id.map_location_image);


        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        for(Offers o : DATA.offers)
        {
            //Picasso.with(marker.getContext()).load("http://findoffer.tk/img/?id="+o.getImage_url()).error(R.drawable.not_avail).into(pic);
          Marker m =  map.addMarker(new MarkerOptions().position(new LatLng(o.getLatitude(),o.getLongitude())).title(o.getOffer_name()).snippet(o.getOffer_distanceInKM()).icon((vectorToBitmap(R.drawable.ic_maps_and_flags))));
            Log.d("LAT: ",String.valueOf(o.getLatitude()));
            Log.d("NAME :",String.valueOf(o.getOffer_name()));
        }

        for(Offers o : DATA.offers)
        {
           Log.d("LAT: ",String.valueOf(o.getLatitude()));
           Log.d("NAME :",String.valueOf(o.getOffer_name()));
        }
        googleMap.addMarker(new MarkerOptions().position(myloc).title("You are Here").icon(vectorToBitmap(R.drawable.ic_maps_and_flags)));
       // googleMap.addMarker(new MarkerOptions().position(new LatLng(offersList.get(0).getLatitude(),offersList.get(0).getLongitude())).title("INDIA").snippet("MY INDIA"));


        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myloc));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13.0f));


    }

    /*
    public static Bitmap createDrawableFromView(Context context, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }
    */
    private BitmapDescriptor vectorToBitmap(@DrawableRes int id) {
        Drawable vectorDrawable = ResourcesCompat.getDrawable(getResources(), id, null);
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    private  class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{

        private View view;

        CustomInfoWindowAdapter()
        {

        }
        @Override
        public View getInfoWindow(Marker marker) {
           return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            view = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker,null);
            return view;

        }
    }


}
