package com.example.skr.databindingdemo2.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.skr.databindingdemo2.Fragment.FragmentSample;
import com.example.skr.databindingdemo2.Model.Country;

import java.util.List;

/**
 * Created by SKR on 10-05-2018.
 */

public class CountryPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private List<Country> countryList;

    public CountryPagerAdapter(FragmentManager fm, Context mContext, List<Country> countryList) {
        super(fm);
        this.mContext = mContext;
        this.countryList = countryList;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment=null;

        switch (position){
            default:
                fragment=new FragmentSample();
                Bundle bundle=new Bundle();
                bundle.putParcelable("model",countryList.get(position));
                fragment.setArguments(bundle);
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {


        return countryList.get(position).getmCountry();


    }
}
