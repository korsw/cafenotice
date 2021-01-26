package com.lsu.caffenotice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button=findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {//버튼 이벤트 처리
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"스타벅스", Toast.LENGTH_SHORT).show();
                //버튼 클릭시 Toast 메세지"버튼 클릭 성공" 출력
            }
        });

        ImageButton button2=findViewById(R.id.imageButton2);
        button2.setOnClickListener(new View.OnClickListener() {//버튼 이벤트 처리
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"투썸", Toast.LENGTH_SHORT).show();
                //버튼 클릭시 Toast 메세지"버튼 클릭 성공" 출력
            }
        });

        ImageButton button3=findViewById(R.id.imageButton3);
        button3.setOnClickListener(new View.OnClickListener() {//버튼 이벤트 처리
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"커피빈", Toast.LENGTH_SHORT).show();
                //버튼 클릭시 Toast 메세지"버튼 클릭 성공" 출력
            }
        });

        ImageButton button4=findViewById(R.id.imageButton4);
        button4.setOnClickListener(new View.OnClickListener() {//버튼 이벤트 처리
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"탐앤탐스", Toast.LENGTH_SHORT).show();
                //버튼 클릭시 Toast 메세지"버튼 클릭 성공" 출력
            }
        });

        ImageButton button5=findViewById(R.id.imageButton5);
        button5.setOnClickListener(new View.OnClickListener() {//버튼 이벤트 처리
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"엔젤리너스", Toast.LENGTH_SHORT).show();
                //버튼 클릭시 Toast 메세지"버튼 클릭 성공" 출력
            }
        });

        ImageButton button6=findViewById(R.id.imageButton6);
        button6.setOnClickListener(new View.OnClickListener() {//버튼 이벤트 처리
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"할리스", Toast.LENGTH_SHORT).show();
                //버튼 클릭시 Toast 메세지"버튼 클릭 성공" 출력
            }
        });
    }

}