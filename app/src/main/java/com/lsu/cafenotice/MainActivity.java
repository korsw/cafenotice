package com.lsu.cafenotice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    RecyclerviewAdapter adapter = new RecyclerviewAdapter();
    public LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.DefaultTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        //ImageView menu = findViewById(R.id.menu);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        //커스터마이징 하기 위해 필요
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // 툴바 메뉴버튼 생성
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        // 메뉴 버튼 모양 설정
        //툴바 배경색

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                String title = menuItem.getTitle().toString();

                if(id == R.id.account){
                    Toast.makeText(context, title + ": 계정 정보를 확인합니다.", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.setting){
                    Toast.makeText(context, title + ": 설정 정보를 확인합니다.", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.logout){
                    Toast.makeText(context, title + ": 로그아웃 시도중", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });





        init();

        getData();



        /*menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.startAnimation(rotate);
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });
         */


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

    private void setDrawerLayout(){
        // onCreate() 함수 안
        // Toolbar 설정
        LinearLayout ll_navigation_container = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.navigation_item, null);
        ll_navigation_container.setBackground(getResources().getDrawable(R.color.indian_red)); // 네비게이션 헤더의 배경색
        ll_navigation_container.setPadding(30, 70, 30, 50); // 패딩
        ll_navigation_container.setOrientation(LinearLayout.VERTICAL);
        ll_navigation_container.setGravity(Gravity.BOTTOM);
        ll_navigation_container.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT); // 텍스트뷰, 이미지뷰에 margin을 적용하기 위함
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/nanumbarungothicbold.ttf"); // 네비게이션 헤더의 텍스트뷰에 커스텀 폰트를 적용하기 위함

        ImageView iv_userpicture = new ImageView(this);
        iv_userpicture.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        // 패딩과 마진 설정


        final TextView tv_username = new TextView(this);
        tv_username.setTextColor(getResources().getColor(R.color.white));
        tv_username.setTextSize(17);
        tv_username.setTypeface(typeface);
        // 패딩과 마진 설정

        final TextView tv_useremail = new TextView(this);
        tv_useremail.setTextColor(getResources().getColor(R.color.white));
        tv_useremail.setTextSize(14);
        tv_useremail.setTypeface(typeface);
        // 패딩과 마진 설정



        // ll_navigation_container에 만든 요소들을 담음
        ll_navigation_container.addView(iv_userpicture);
        ll_navigation_container.addView(tv_username);
        ll_navigation_container.addView(tv_useremail);

        navigationView.addHeaderView(ll_navigation_container);

        // 네비게이션 메뉴에서 메뉴들이 눌렸을 때의 행동들
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true); drawerLayout.closeDrawers();
                int id = menuItem.getItemId();
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home : {
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
            default: return super.onOptionsItemSelected(item);
        }
    }
}


// 네비게이션 헤더에서 현재 로그인중인 사용자를 보여주기 위한 코드
        /*
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser != null) {
            String uid = firebaseUser.getUid();
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.getReference("users").child(uid).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot : snapshot.getChildren())
                        if(dataSnapshot.getKey().equals("name")) {
                            username = dataSnapshot.getValue().toString();
                            tv_username.setText(username + " 님");
                        }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
            tv_useremail.setText(firebaseUser.getEmail());
        } else if(firebaseUser == null) {
            // 로그인이 되어있지 않다면, '로그인이 필요합니다.'라는 텍스트를 보여주고,
            // 해당 텍스트를 누르면 로그인 화면으로 이동하도록 구현
            iv_userpicture.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher_ewoman_round));
            tv_username.setText("로그인이 필요합니다.");
            tv_useremail.setText(" ");
            tv_username.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent navi_to_login = new Intent(getApplicationContext(), mem_LoginActivity.class);
                    startActivity(navi_to_login);
                }
            });
        }

         */