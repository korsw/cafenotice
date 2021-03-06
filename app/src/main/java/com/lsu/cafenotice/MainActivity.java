package com.lsu.cafenotice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    RecyclerviewAdapter adapter = new RecyclerviewAdapter();
    private AppBarConfiguration mAppBarConfiguration;


    public LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.DefaultTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        ImageView menu = findViewById(R.id.menu);

        init();

        getData();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.startAnimation(rotate);
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });

<<<<<<< HEAD
        //setActionBar();
=======

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView, navController);
>>>>>>> f28f113589e9afa318b4dd8a0ea4c7abe9a8b86d

    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.logoRecyclerView);

        RecyclerDecoration spaceDecoration = new RecyclerDecoration(30);
        recyclerView.addItemDecoration(spaceDecoration);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        List<String> listName = Arrays.asList(
                "스타벅스",
                "투썸플레이스",
                "커피빈",
                "탐앤탐스",
                "엔제리너스",
                "할리스커피"

        );

        List<Integer> listResId = Arrays.asList(
                R.drawable.logo_starbucks,
                R.drawable.logo_atwosomeplace,
                R.drawable.logo_coffeebean,
                R.drawable.logo_tomntoms,
                R.drawable.logo_angelinus,
                R.drawable.logo_hollys
        );

        for (int i = 0; i < listResId.size(); i++){
            Recyclerviewitem data = new Recyclerviewitem();
            data.setName(listName.get(i));
            data.setResId(listResId.get(i));
            data.setWitdh(getDisplayWidth());

            adapter.addItem(data);
        }


        adapter.notifyDataSetChanged();
    }

    public int getDisplayWidth(){
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);

        float density = getResources().getDisplayMetrics().density;
        //float dpHeight = outMetrics.heightPixels / density;
        float dpWidth = outMetrics.widthPixels / density;

        return (int)dpWidth;
    }

<<<<<<< HEAD
    private void setActionBar(){
        Action_bar ca = new Action_bar(this, getSupportActionBar());
        ca.setResId(R.drawable.ic_arrow_back);
        ca.setActionBar();
=======
    @SuppressLint("ResourceType")
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.id.menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
>>>>>>> f28f113589e9afa318b4dd8a0ea4c7abe9a8b86d
    }

}