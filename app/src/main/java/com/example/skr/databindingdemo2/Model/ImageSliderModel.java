package com.example.skr.databindingdemo2.Model;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by SKR on 08-05-2018.
 */

public class ImageSliderModel {

    private Context mContext;


    public ImageSliderModel(Activity Context) {
        mContext=Context;
    }

    public String getImageUrl() {
        // The URL will usually come from a model (i.e Profile)
        return "http://cdn.meme.am/instances/60677654.jpg";
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
