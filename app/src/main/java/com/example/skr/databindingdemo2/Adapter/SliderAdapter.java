package com.example.skr.databindingdemo2.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.skr.databindingdemo2.Fragment.FragmentSample;

/**
 * Created by SKR on 08-05-2018.
 */

public class SliderAdapter extends FragmentStatePagerAdapter {

    private Context mContext;

    public SliderAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment=null;

        switch (position)
        {
            default:
                fragment=new FragmentSample();
                Bundle bundle=new Bundle();
                bundle.putString("image","https://www.pexels.com/photo/nature-flowers-plant-flower-87840/");
                fragment.setArguments(bundle);
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
