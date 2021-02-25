package com.lsu.cafenotice;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.ActionBar;
import android.app.Activity;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class action_bar {

    private Activity activity;
    private ActionBar actionBar;

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