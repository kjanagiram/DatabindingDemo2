package com.example.skr.databindingdemo2.Activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;

import com.example.skr.databindingdemo2.Adapter.SliderPagerAdapter;
import com.example.skr.databindingdemo2.Model.ImageModel;
import com.example.skr.databindingdemo2.Model.SubItem;
import com.example.skr.databindingdemo2.R;
import com.example.skr.databindingdemo2.databinding.ActivitySliderBinding;

import java.util.ArrayList;
import java.util.List;

public class SliderActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_slider);

        mContext = SliderActivity.this;
        ActivitySliderBinding binding = DataBindingUtil.setContentView((SliderActivity) mContext, R.layout.activity_slider);


        List<ImageModel> imageModelList = prepareData();
        SliderPagerAdapter sliderPagerAdapter = new SliderPagerAdapter(mContext, imageModelList);

        binding.viewpagerSlider.setAdapter(sliderPagerAdapter);

    }

    public List<ImageModel> prepareData() {
        List<ImageModel> flights = new ArrayList<>();


        ImageModel flight = new ImageModel();
        flight.setImgUrl("http://spize.sg/wp-content/uploads/2016/10/Spize-Background-1.jpg");

        flights.add(flight);

        ImageModel flight1 = new ImageModel();
        flight1.setImgUrl("http://spize.sg/wp-content/uploads/2016/10/Spize-Background-2.jpg");

        flights.add(flight1);

        ImageModel flight2 = new ImageModel();
        flight2.setImgUrl("http://spize.sg/wp-content/uploads/2016/10/Spize-Background-5.jpg");
        flights.add(flight2);

        ImageModel flight3 = new ImageModel();
        flight3.setImgUrl("http://spize.sg/wp-content/uploads/2016/10/Spize-Background-6.jpg");
        flights.add(flight3);

        ImageModel flight4 = new ImageModel();
        flight4.setImgUrl("http://spize.sg/wp-content/uploads/2016/10/Spize-Background-7.jpg");
        flights.add(flight4);

        ImageModel flight5 = new ImageModel();
        flight5.setImgUrl("http://spize.sg/wp-content/uploads/2016/10/Spize-Background-8.jpg");
        flights.add(flight5);


        Log.v("list size",flights.size()+"");
        return flights;
    }
}
