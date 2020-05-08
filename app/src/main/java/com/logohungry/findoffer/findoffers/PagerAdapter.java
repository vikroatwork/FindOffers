package com.logohungry.findoffer.findoffers;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Button;

/**
 * Created by vikramsingh on 10/01/18.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    MFrag fragment1;
    MFrag2 fragment2;

    private String[] title={"Offers","Locations"};

    public  PagerAdapter(FragmentManager fm)
    {
        super(fm);
        fragment1 = new MFrag();
        fragment2 = new MFrag2();

    }
    @Override
    public Fragment getItem(int position) {
        if(position ==0)
            return fragment1;
        else
            return fragment2;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
