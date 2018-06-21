package com.example.skr.databindingdemo2.Activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.skr.databindingdemo2.Handler.LoginHandler;
import com.example.skr.databindingdemo2.R;
import com.example.skr.databindingdemo2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        mContext=MainActivity.this;

        ActivityMainBinding binding= DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        binding.setLoginHandler(new LoginHandler(mContext));

    }
}
