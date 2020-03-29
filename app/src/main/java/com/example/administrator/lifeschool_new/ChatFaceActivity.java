package com.example.administrator.lifeschool_new;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Created by Administrator on 2020/3/23.
 */


public class ChatFaceActivity extends AppCompatActivity  {


    //底部导航栏点击事件
    private BottomNavigationView.OnNavigationItemSelectedListener nOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent_button = new Intent(ChatFaceActivity.this,MainActivity.class);
                    startActivity(intent_button);
                    finish();
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatface_bottom);

        BottomNavigationView navigation = findViewById(R.id.navigation_bottom);
        navigation.setOnNavigationItemSelectedListener(nOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_notifications);

     EditText chatface = findViewById(R.id.chatface);
        Drawable drawable = getResources().getDrawable(R.drawable.search);
        drawable .setBounds(0, 0, 100, 100);//第一个 0 是距左边距离，第二个 0 是距上边距离，40 分别是长宽
        chatface.setCompoundDrawables(drawable , null, null, null);//只放左边
    }



}
