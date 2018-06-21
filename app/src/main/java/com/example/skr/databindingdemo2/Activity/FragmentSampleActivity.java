package com.example.skr.databindingdemo2.Activity;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.skr.databindingdemo2.Adapter.SliderAdapter;
import com.example.skr.databindingdemo2.Fragment.FragmentSample;
import com.example.skr.databindingdemo2.R;
import com.example.skr.databindingdemo2.databinding.ActivityFragmentSampleBinding;

public class FragmentSampleActivity extends AppCompatActivity {

    Context mContext;
    private SliderAdapter sliderAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment_sample);


        mContext= FragmentSampleActivity.this;

        ActivityFragmentSampleBinding binding= DataBindingUtil.setContentView((FragmentSampleActivity)mContext, R.layout.activity_fragment_sample);

        sliderAdapter=new SliderAdapter(getSupportFragmentManager(),mContext);

        binding.viewpagerSlider.setAdapter(sliderAdapter);

       /* FragmentManager fragmentManager=getSupportFragmentManager();

        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        Fragment fragment=new FragmentSample();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();*/





    }
}
