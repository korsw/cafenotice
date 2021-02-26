package com.lsu.cafenotice;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.ActionBar;
import android.app.Activity;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class action_bar {

    private Activity activity;
    private ActionBar actionBar;
    Animation anim_test;

    anim_test = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_test);


    ImageView btn_test;

    btn_test = findViewById(R.id.btn_test);



    public action_bar(Activity mactivity, ActionBar mactionBar){
        this.activity = mactivity;
        this.actionBar = mactionBar;
    }

    public void setActionBar(){
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        View mCustomView = LayoutInflater.from(activity).inflate(R.layout.activity_action_bar, null);

        actionBar.setCustomView(mCustomView);
    }


}