package com.example.skr.databindingdemo2.Fragment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skr.databindingdemo2.Model.Country;
import com.example.skr.databindingdemo2.Model.ImageSliderModel;
import com.example.skr.databindingdemo2.R;
import com.example.skr.databindingdemo2.databinding.FragmentSampleBinding;


/**
 * Created by SKR on 08-05-2018.
 */

public class FragmentSample extends Fragment {

    private Activity mContext;
    private Bundle bundle;
    private Country country;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext=activity;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bundle=getArguments();

        if(bundle!=null)
        {
            country=bundle.getParcelable("model");

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentSampleBinding fragmentSampleBinding= FragmentSampleBinding.inflate(inflater, container, false);

        fragmentSampleBinding.setCountry(country);
        Log.v("foooo","welcome");

        return fragmentSampleBinding.getRoot();

        /*View v=inflater.inflate(R.layout.fragment_sample,container,false);

        return v;*/

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
