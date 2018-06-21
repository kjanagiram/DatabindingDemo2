package com.example.skr.databindingdemo2.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SKR on 06-05-2018.
 */

public class SubItem implements Parcelable{

    private int item;


    public SubItem(){

    }
    protected SubItem(Parcel in) {
        item = in.readInt();
    }

    public static final Creator<SubItem> CREATOR = new Creator<SubItem>() {
        @Override
        public SubItem createFromParcel(Parcel in) {
            return new SubItem(in);
        }

        @Override
        public SubItem[] newArray(int size) {
            return new SubItem[size];
        }
    };

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(item);
    }
}
