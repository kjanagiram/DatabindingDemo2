package com.example.skr.databindingdemo2.Handler;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.skr.databindingdemo2.Activity.HomeActivity;
import com.example.skr.databindingdemo2.Activity.MainActivity;
import com.example.skr.databindingdemo2.Model.User;

/**
 * Created by SKR on 03-05-2018.
 */

public class LoginHandler {


    private Context mContext;
    private boolean isChecked = false;

    public LoginHandler(Context context) {

        mContext = context;

    }

    public void performLogin(String mUserName, String mPassword) {


        if (validateLogin(mUserName, mPassword, isChecked)) {
            if (mUserName.equalsIgnoreCase("test") && mPassword.equalsIgnoreCase("1234")) {
                Log.v("login", "success");

                User user = new User();


                user.setmUserName(mUserName);


                Intent intent = new Intent(mContext, HomeActivity.class);
                intent.putExtra("user", user);
                mContext.startActivity(intent);
                ((MainActivity) mContext).finish();
            } else {
                Log.v("login", "failed");
            }
        } else {
            Toast.makeText(mContext, "Please enter mandatory fields", Toast.LENGTH_LONG).show();
        }

    }

    private boolean validateLogin(String mUserName, String mPassword, boolean isChecked) {


        if (mUserName.length() <= 0) {
            return false;
        } else if (mPassword.length() <= 0) {
            return false;
        } else if (!isChecked) {
            return false;
        } else {
            return true;
        }

    }

    @BindingAdapter("onPageChangeListener")
    public static void setOnPageChangeListener(ViewPager viewPager, ViewPager.OnPageChangeListener listener) {
        Log.i("setOnPageChangeListener","inside");

        // clear listeners first avoid adding duplicate listener upon calling notify update related code
        viewPager.clearOnPageChangeListeners();
        viewPager.addOnPageChangeListener(listener);
    }

    public void isChecked(CompoundButton buttonView, boolean checked) {

        Log.v("foooo", checked + "");
        isChecked = checked;

    }
}
