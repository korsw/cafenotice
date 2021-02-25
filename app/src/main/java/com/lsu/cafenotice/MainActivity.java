package com.lsu.cafenotice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Point;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import com.lsu.cafenotice.action_bar;
import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    RecyclerviewAdapter adapter = new RecyclerviewAdapter();


    public LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.DefaultTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        getData();

        //setActionBar();

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

        for (int i = 0; i < listResId.size(); i++) {
            Recyclerviewitem data = new Recyclerviewitem();
            data.setName(listName.get(i));
            data.setResId(listResId.get(i));

            adapter.addItem(data);
        }

        adapter.notifyDataSetChanged();
    }

    public int getDisplayWidth(){
        Display display = getWindowManager().getDefaultDisplay();  // in Activity
        /* getActivity().getWindowManager().getDefaultDisplay() */ // in Fragment
        Point size = new Point();
        display.getRealSize(size); // or getSize(size)
        int width = size.x;

        return width;
    }

    private void setActionBar(){
        action_bar ca = new action_bar(this, getSupportActionBar());
        ca.setActionBar();
    }

}