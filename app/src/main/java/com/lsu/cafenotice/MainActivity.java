package com.lsu.cafenotice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerviewAdapter adapter = new RecyclerviewAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        getData();

    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.logoRecyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        List<Integer> listResId = Arrays.asList(
                R.drawable.logo_starbucks,
                R.drawable.logo_atwosomeplace,
                R.drawable.logo_coffeebean,
                R.drawable.logo_tomntoms,
                R.drawable.logo_angelinus,
                R.drawable.logo_hollys
        );

        for (int i = 0; i < listResId.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Recyclerviewitem data = new Recyclerviewitem();
            data.setResId(listResId.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }
    }

}