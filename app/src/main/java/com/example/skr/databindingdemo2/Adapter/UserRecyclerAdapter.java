package com.example.skr.databindingdemo2.Adapter;

import android.content.ClipData;
import android.content.Context;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.skr.databindingdemo2.BR;
import com.example.skr.databindingdemo2.Handler.ItemClick;
import com.example.skr.databindingdemo2.Model.UserList;
import com.example.skr.databindingdemo2.R;
import com.example.skr.databindingdemo2.databinding.LayoutItemBinding;


import java.util.List;

/**
 * Created by SKR on 06-05-2018.
 */

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserHolder> {

    private Context mContext;
    private List<UserList> userLists;
    public ItemClick itemClick;
    private RecyclerView.LayoutManager layoutManager;

    public UserRecyclerAdapter(Context mContext, List<UserList> userLists) {
        this.mContext = mContext;
        this.userLists = userLists;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

        LayoutItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.layout_item, parent, false);

        UserHolder holder = new UserHolder(binding);

        return holder;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, final int position) {

        UserList userList = userLists.get(position);
        holder.binding.setUser1(userList);

        layoutManager=new LinearLayoutManager(mContext);
        holder.binding.subList.setLayoutManager(layoutManager);

        SubRecyclerAdapter subRecyclerAdapter=new SubRecyclerAdapter(mContext,userLists.get(position).getIntegerList());

        Log.v("sub list size",userLists.get(position).getIntegerList().size()+"");

        holder.binding.subList.setAdapter(subRecyclerAdapter);
        holder.binding.subList.setNestedScrollingEnabled(false);
        holder.binding.subList.setHasFixedSize(true);
        holder.binding.subList.setItemAnimator(new DefaultItemAnimator());

       /* holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, userLists.get(position).getmName(), Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LayoutItemBinding binding;

        RecyclerView recyclerView;

        public UserHolder(LayoutItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            this.binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if(itemClick!=null)
            {
                itemClick.onClick(view,getPosition());
            }
        }

    }


    public void setOnItemClick(ItemClick click)
    {
        itemClick=click;
    }
}
