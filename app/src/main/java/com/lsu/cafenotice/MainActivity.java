package com.lsu.cafenotice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        getData();

    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.logoRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerviewAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        List<Integer> listResId = Arrays.asList(
                R.drawable.starbucks_logo,
                R.drawable.atwosomeplace_logo,
                R.drawable.coffeebean_logo,
                R.drawable.tomntoms_logo,
                R.drawable.angelinus_logo,
                R.drawable.hollys_logo
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