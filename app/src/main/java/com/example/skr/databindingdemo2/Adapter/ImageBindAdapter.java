package com.example.skr.databindingdemo2.Adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

/**
 * Created by SKR on 09-05-2018.
 */

public class ImageBindAdapter {

    @BindingAdapter({"bind:image_url"})
    public static void loadImage(ImageView imageView, String imageUrl){

//        Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);

    }
}
