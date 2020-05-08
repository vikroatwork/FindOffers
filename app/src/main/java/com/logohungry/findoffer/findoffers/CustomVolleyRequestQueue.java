package com.logohungry.findoffer.findoffers;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * Created by vikramsingh on 24/01/18.
 */

public class CustomVolleyRequestQueue {
    private static CustomVolleyRequestQueue mInstance;
    private static Context mCtx;
    private RequestQueue mRequestQueue;

    CustomVolleyRequestQueue(Context context)
    {
        mCtx = context;
        mRequestQueue = getmRequestQueue();
    }

    public static synchronized CustomVolleyRequestQueue getmInstance(Context context)
    {
        if(mInstance ==null)
        {
            mInstance = new CustomVolleyRequestQueue(context);
        }

        return mInstance;
    }

    public RequestQueue getmRequestQueue(){

        if(mRequestQueue ==null)
        {
            Cache cache = new DiskBasedCache(mCtx.getCacheDir(),50*1024*1024);
            Network network = new BasicNetwork(new HurlStack());
            mRequestQueue =new RequestQueue(cache,network);
            mRequestQueue.start();

        }
        return mRequestQueue;
    }
}