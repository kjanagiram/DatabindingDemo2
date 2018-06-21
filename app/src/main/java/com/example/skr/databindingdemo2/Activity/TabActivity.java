package com.example.skr.databindingdemo2.Activity;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.skr.databindingdemo2.Adapter.CountryPagerAdapter;
import com.example.skr.databindingdemo2.Handler.LoginHandler;
import com.example.skr.databindingdemo2.Model.Country;
import com.example.skr.databindingdemo2.R;
import com.example.skr.databindingdemo2.databinding.ActivityTabBinding;
import com.example.skr.databindingdemo2.databinding.LayoutTabItemBinding;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {

    private Context mContext;
    private Country mCountry;
    private List<Country> countryList;
    private ActivityTabBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tab);

        mContext = TabActivity.this;

        binding = DataBindingUtil.setContentView((TabActivity) mContext, R.layout.activity_tab);


        prepareData();

        setupTab();
        CountryPagerAdapter countryPagerAdapter = new CountryPagerAdapter(getSupportFragmentManager(), mContext, countryList);

        binding.viewPager.setAdapter(countryPagerAdapter);
//        binding.tabLayout.setupWithViewPager(binding.viewPager);

        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));

        binding.tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }




    private void setupTab() {



        for (int i = 0; i < countryList.size(); i++) {

            LayoutTabItemBinding tabItemBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.layout_tab_item, null, false);
            tabItemBinding.setCountry(countryList.get(i));

            binding.tabLayout.addTab(binding.tabLayout.newTab().setCustomView(tabItemBinding.getRoot()));
        }


    }

    private void prepareData() {


        countryList = new ArrayList<>();

        mCountry = new Country();
        mCountry.setmCountry("India");
        mCountry.setImgUrl("http://spize.sg/wp-content/uploads/2016/10/Spize-Background-6.jpg");

        countryList.add(mCountry);

        mCountry = new Country();
        mCountry.setmCountry("USA");
        mCountry.setImgUrl("http://spize.sg/wp-content/uploads/2016/10/Spize-Background-1.jpg");

        countryList.add(mCountry);

        mCountry = new Country();
        mCountry.setmCountry("UK");
        mCountry.setImgUrl("http://spize.sg/wp-content/uploads/2016/10/Spize-Background-2.jpg");

        countryList.add(mCountry);

        mCountry = new Country();
        mCountry.setmCountry("Canada");
        mCountry.setImgUrl("http://spize.sg/wp-content/uploads/2016/10/Spize-Background-3.jpg");

        countryList.add(mCountry);

        mCountry = new Country();
        mCountry.setmCountry("UAE");
        mCountry.setImgUrl("http://spize.sg/wp-content/uploads/2016/10/Spize-Background-4.jpg");

        countryList.add(mCountry);


    }
}
