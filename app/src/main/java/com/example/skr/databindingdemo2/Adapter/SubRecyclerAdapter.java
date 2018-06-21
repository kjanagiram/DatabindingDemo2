package com.example.skr.databindingdemo2.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.skr.databindingdemo2.Model.SubItem;
import com.example.skr.databindingdemo2.R;
import com.example.skr.databindingdemo2.databinding.LayoutSubitemBinding;

import java.util.List;

/**
 * Created by SKR on 06-05-2018.
 */

public class SubRecyclerAdapter extends RecyclerView.Adapter<SubRecyclerAdapter.SubHolder> {

    private Context mContext;
    private List<SubItem> subLists;

    public SubRecyclerAdapter(Context mContext, List<SubItem> subLists) {
        this.mContext = mContext;
        this.subLists = subLists;
    }

    @Override
    public SubHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutSubitemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.layout_subitem, parent, false);

        SubHolder subHolder = new SubHolder(binding);

        return subHolder;
    }

    @Override
    public void onBindViewHolder(SubHolder holder, int position) {

        holder.layoutSubitemBinding.setSubitem(subLists.get(position));

    }

    @Override
    public int getItemCount() {
        return subLists.size();
    }

    public class SubHolder extends RecyclerView.ViewHolder {

        LayoutSubitemBinding layoutSubitemBinding;

        public SubHolder(LayoutSubitemBinding layoutSubitemBinding) {
            super(layoutSubitemBinding.getRoot());
            this.layoutSubitemBinding = layoutSubitemBinding;
        }
    }
}
