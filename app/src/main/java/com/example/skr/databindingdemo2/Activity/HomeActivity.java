package com.example.skr.databindingdemo2.Activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.skr.databindingdemo2.Adapter.UserRecyclerAdapter;
import com.example.skr.databindingdemo2.Handler.ItemClick;
import com.example.skr.databindingdemo2.Model.SubItem;
import com.example.skr.databindingdemo2.Model.User;
import com.example.skr.databindingdemo2.Model.UserList;

import com.example.skr.databindingdemo2.R;
import com.example.skr.databindingdemo2.databinding.UserMenu;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private Context mContext;
    private User user;
    private UserRecyclerAdapter userRecyclerAdapter;
    private List<UserList> userLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);

        mContext = HomeActivity.this;


        if (getIntent() != null) {
            user = getIntent().getParcelableExtra("user");
        }
        UserMenu binding = DataBindingUtil.setContentView((HomeActivity) mContext, R.layout.activity_home);

        binding.setUser(user);




        binding.recyclerview.setLayoutManager(new LinearLayoutManager(mContext));

        binding.recyclerview.setItemAnimator(new DefaultItemAnimator());

        userLists = prepareData();


        userRecyclerAdapter = new UserRecyclerAdapter(mContext, userLists);
        binding.recyclerview.setAdapter(userRecyclerAdapter);


        userRecyclerAdapter.setOnItemClick(new ItemClick() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(mContext, userLists.get(position).getmName(), Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(mContext,TabActivity.class);
                startActivity(intent);
            }
        });


    }


    public List<UserList> prepareData() {
        List<UserList> flights = new ArrayList<>();


        for (int i = 1; i < 10; i++) {

            UserList flight = new UserList(mContext);
            flight.setmName("Airlines2" + i);
            flight.setmAge("2" + i);
            flight.setImage_url("https://pbs.twimg.com/profile_images/446522135721164800/pdVA44as.jpeg");

            List<SubItem> integers=new ArrayList<>();

            for(int j=1;j<4;j++)
            {

                SubItem item=new SubItem();
                item.setItem(j);
                integers.add(item);
            }

            flight.setIntegerList(integers);

            flights.add(flight);

        }

        return flights;
    }

}
