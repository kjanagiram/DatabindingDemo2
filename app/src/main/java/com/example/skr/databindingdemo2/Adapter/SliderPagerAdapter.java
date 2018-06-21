package com.example.skr.databindingdemo2.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.skr.databindingdemo2.Model.ImageModel;
import com.example.skr.databindingdemo2.Model.User;
import com.example.skr.databindingdemo2.Model.UserList;
import com.example.skr.databindingdemo2.databinding.LayoutSliderItemBinding;

import java.util.List;

/**
 * Created by SKR on 09-05-2018.
 */

public class SliderPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<ImageModel> userLists;

    public SliderPagerAdapter(Context mContext, List<ImageModel> userLists) {
        this.mContext = mContext;
        this.userLists = userLists;
    }

    @Override
    public int getCount() {
        return userLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


//        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        LayoutSliderItemBinding sliderItemBinding=LayoutSliderItemBinding.inflate(LayoutInflater.from(mContext),container,false);

        sliderItemBinding.setSlider(userLists.get(position));

        container.addView(sliderItemBinding.getRoot());

        return sliderItemBinding.getRoot();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
