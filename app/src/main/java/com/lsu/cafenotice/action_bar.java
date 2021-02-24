package com.lsu.cafenotice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class action_bar {

    private Activity activity;
    private ActionBar actionBar;

    public action_bar(Activity activity1, ActionBar actionBar2){
        this.activity = activity1;
        this.actionBar = actionBar2;
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