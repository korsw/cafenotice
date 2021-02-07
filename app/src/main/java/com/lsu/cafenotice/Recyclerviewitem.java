package com.lsu.cafenotice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;


public class Recyclerviewitem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_item);

        /*DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);

        ImageView img1 = (ImageView) findViewById(R.id.cafe_icon_1);
        LayoutParams params1 = (LayoutParams) img1.getLayoutParams();
        params1.width = metrics.widthPixels/3;
        params1.height = metrics.widthPixels/3;
        ImageView img2 = (ImageView) findViewById(R.id.cafe_icon_2);
        LayoutParams params2 = (LayoutParams) img2.getLayoutParams();
        params2.width = metrics.widthPixels/3;
        params2.height = metrics.widthPixels/3;


        img1.setLayoutParams(params1);
        img2.setLayoutParams(params2);

         */
    }

    String name;
    private int resId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
