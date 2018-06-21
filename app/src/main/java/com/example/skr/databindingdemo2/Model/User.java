package com.example.skr.databindingdemo2.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SKR on 04-05-2018.
 */

public class User implements Parcelable {

    private String mUserName="";


    public User(){

    }
    protected User(Parcel in) {
        mUserName = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUserName);
    }
}
