package com.logohungry.findoffer.findoffers;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by vikramsingh on 04/01/18.
 */

public class MFrag  extends Fragment{

    boolean showing;
    RecyclerView recyclerView;
    List<Offers> offersList = new ArrayList<>();
    OfferAdapter adapter;


    interface sendJSON {
        void sendData(List<Offers> offers);
    }
    public MFrag()
    {
        showing = false;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v= (ViewGroup)inflater.inflate(R.layout.frag1,container,false);

        recyclerView = (RecyclerView)v.findViewById(R.id.recylceviewListOffers);
        adapter = new OfferAdapter(DATA.offers,getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        ;
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



        data();
        //RequestQueue queue = Volley.newRequestQueue(getContext());

        //new JSONData(CustomVolleyRequestQueue.getmInstance(getContext()).getmRequestQueue(),adapter,"12.850809","77.648472",offersList,pd).callJSON("http://192.168.0.4/list");

        return v;
    }



    void data()
    {
        /*
        offersList.add(new Offers("50% Off and 10% discount on soap","0.5km","Susmita Palace,E-City Phase 1"));
        offersList.add(new Offers("upto 20% off on Cosmetics","0.75 km","Vishal Mega mart,E-City Phase 2"));
        offersList.add(new Offers("upto 30% off","1 km","Kudlu Gate"));
        offersList.add(new Offers("upto 20% off on groceries","1.2 km","A K Food Mart"));
        offersList.add(new Offers("10% Off and 20% discount on groceries","2.1km","SU,Singasandra"));
        offersList.add(new Offers("upto 20% off on Cosmetics","2.3 km","Vishal Mega mart,Singasandra"));
        offersList.add(new Offers("Buy one ,get one ","3 km","Mohit Chai point,Kudlu Gate"));
        offersList.add(new Offers("upto 20% off on groceries","3.2 km","KK Food Mart"));

        adapter.notifyDataSetChanged();

*/
    }
/*

         Typeface f1= Typeface.createFromAsset(getContext().getAssets(),"lob_regular.otf");
        Typeface f1_bold= Typeface.createFromAsset(getContext().getAssets(),"lob_bold.otf");

        TextView tv1,tv2,tv3,tv1s,tv2s,tv3s;
        final CardView cardView_small,cardView_big;
        ImageButton button_big,button_small;

        button_big = (ImageButton)v.findViewById(R.id.big_imagebutton);
        button_small = (ImageButton)v.findViewById(R.id.small_imagebutton);

        cardView_big = (CardView)v.findViewById(R.id.cv_big);
        cardView_small = (CardView)v.findViewById(R.id.cv_small);

        button_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cardView_big.setVisibility(View.GONE);
                cardView_small.setVisibility(View.VISIBLE);
            }
        });
        button_small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView_big.setVisibility(View.VISIBLE);
                cardView_small.setVisibility(View.GONE);
            }
        });

        tv1=(TextView)v.findViewById(R.id.offer_name_tv_big);
        tv2=(TextView)v.findViewById(R.id.offer_distance_big);
        tv3=(TextView)v.findViewById(R.id.offer_location_big);

        tv1s=(TextView)v.findViewById(R.id.offer_name_tv_small);
        tv2s=(TextView)v.findViewById(R.id.offer_distance_small);
        tv3s=(TextView)v.findViewById(R.id.offer_location_small);

        tv1.setTypeface(f1_bold); tv2.setTypeface(f1); tv3.setTypeface(f1);
        tv1.setTextColor(Color.parseColor("#c0392b"));
        tv2.setTextColor(Color.parseColor("#c0392b"));
        tv3.setTextColor(Color.parseColor("#c0392b"));

        tv1s.setTypeface(f1_bold); tv2s.setTypeface(f1); tv3s.setTypeface(f1);
        tv1s.setTextColor(Color.parseColor("#c0392b"));
        tv2s.setTextColor(Color.parseColor("#c0392b"));
        tv3s.setTextColor(Color.parseColor("#c0392b"));
        */


}
