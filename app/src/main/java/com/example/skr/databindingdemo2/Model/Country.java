package com.example.skr.databindingdemo2.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SKR on 10-05-2018.
 */

public class Country implements Parcelable {

    private String mCountry="";

    private String imgUrl;


    public Country(){

    }

    protected Country(Parcel in) {
        mCountry = in.readString();
        imgUrl = in.readString();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mCountry);
        parcel.writeString(imgUrl);
    }
}
