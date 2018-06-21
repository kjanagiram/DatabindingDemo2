package com.example.skr.databindingdemo2.Model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;


import java.util.List;


/**
 * Created by SKR on 06-05-2018.
 */

public class UserList implements Parcelable  {


    private Context mContext;
    private String mName="";

    private String mAge="";
    public String image_url;

    private List<SubItem> integerList;

    public UserList(){

    }

    public UserList(Context context) {

        mContext=context;
    }

    protected UserList(Parcel in) {
        mName = in.readString();
        mAge = in.readString();
        image_url = in.readString();
        integerList = in.createTypedArrayList(SubItem.CREATOR);
    }

    public static final Creator<UserList> CREATOR = new Creator<UserList>() {
        @Override
        public UserList createFromParcel(Parcel in) {
            return new UserList(in);
        }

        @Override
        public UserList[] newArray(int size) {
            return new UserList[size];
        }
    };

    public List<SubItem> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<SubItem> integerList) {
        this.integerList = integerList;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mAge);
        parcel.writeString(image_url);
        parcel.writeTypedList(integerList);
    }
}
