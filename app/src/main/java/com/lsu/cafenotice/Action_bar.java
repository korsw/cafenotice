package com.lsu.cafenotice;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.ActionBar;
import android.app.Activity;
import android.media.Image;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Action_bar extends AppCompatActivity{

    private Activity activity;
    private ActionBar actionBar;
    private int resId;

    public Action_bar(Activity mactivity, ActionBar mactionBar){
        this.activity = mactivity;
        this.actionBar = mactionBar;
    }

    public void setActionBar(){
        ImageView lefticon;
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        View mCustomView = LayoutInflater.from(activity).inflate(R.layout.activity_action_bar, null);

        lefticon = mCustomView.findViewById(R.id.cafe_icon_1);
        lefticon.setImageResource(getResId());

        actionBar.setCustomView(mCustomView);
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }



}