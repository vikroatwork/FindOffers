package com.logohungry.findoffer.findoffers;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.Spinner;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Array;
import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class Content_to_MainScreen extends AppCompatActivity   {

    ViewPager viewPager;
    Typeface font;
    public PagerAdapter pagerAdapter;
    TextView tv;
    private TabLayout tabLayout;




    public interface Locatiom
    {
        void setLocation();
    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);




        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET},1);

        font = Typeface.createFromAsset(getAssets(), "montserrat_semibold.otf");



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //   Window w = getWindow();
            // w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //w.setStatusBarColor(Color.rgb(40, 53, 147));
            getWindow().setStatusBarColor(Color.TRANSPARENT);
           // getWindow().setBackgroundDrawableResource(R.drawable.grad_back);
        }

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
        // final LottieAnimationView animationView = (LottieAnimationView)findViewById(R.id.animation_view);

        viewPager = (ViewPager) findViewById(R.id.content);
        Button b1 = (Button) findViewById(R.id.location_name_button);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
     //  tv = (TextView)findViewById(R.id.offer_title_main_screen_tv);
        //tv.setTypeface(Typeface.createFromAsset(getAssets(), font));


        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(1);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if(position == 0)
                {
                   // tv.setText("Offers in your areas");


                }
                else
                {
                  //  tv.setText("Offers locations ");


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.welcome_toolbar);
        b1 = (Button) findViewById(R.id.location_name_button);
        b1.setTypeface(font);
        b1.setTextColor(Color.parseColor("#ecf0f1"));
        //b1.setText("Electronic City");
        b1.setText(DATA.location_name);


        //Spinner spinner=(Spinner)findViewById(R.id.locations_name_spinner);
        //ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.mock_locations,R.layout.support_simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);

        //final ScaleAnimation scaleAnimation = new ScaleAnimation(1,1,1,10);
        //scaleAnimation.setDuration(1000);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.main,menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*int menuItemSelected = item.getItemId();
        switch (menuItemSelected){
            case R.id.action_search:
            {

            }
        }
        */

        return super.onOptionsItemSelected(item);

    }


}
