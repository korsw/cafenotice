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

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }



}