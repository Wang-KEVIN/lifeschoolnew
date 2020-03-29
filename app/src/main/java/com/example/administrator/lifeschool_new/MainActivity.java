package com.example.administrator.lifeschool_new;



import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.lifeschool_new.dummy.DummyContent;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {





    //底部导航栏点击事件
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_notifications:
                    Intent intent_button = new Intent(MainActivity.this,ChatFaceActivity.class);
                    startActivity(intent_button);
                    finish();
                    return true;
            }
            return false;
        }
    };
/*    private MenuItem item1;
    private MenuItem item2;*/


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //顶部导航栏
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //底部导航栏
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /*//获取整个的NavigationView
        红点显示失败
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigation.getChildAt(0);

        //这里就是获取所添加的每一个Tab(或者叫menu)，
        View tab = menuView.getChildAt(1);
        BottomNavigationItemView itemView = (BottomNavigationItemView) tab;

        //加载我们的角标View，新创建的一个布局
        View badge = LayoutInflater.from(this).inflate(R.layout.badge, menuView, false);

        //添加到Tab上
        itemView.addView(badge);*/




        //左侧导航栏
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.home, R.string.jiaoliu);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //悬浮球点击事件
        com.getbase.floatingactionbutton.FloatingActionButton fab1 = findViewById(R.id.fab_1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "fab_2", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        com.getbase.floatingactionbutton.FloatingActionButton fab2 = findViewById(R.id.fab_2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "fab_2", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //搜索框结果
        String SearchContent = getIntent().getStringExtra(SearchManager.QUERY);
        Toast.makeText(getApplicationContext(),SearchContent,Toast.LENGTH_SHORT).show();

        }


    //左侧导航栏
    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //顶部导航栏菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
       // super.onCreateOptionsMenu(menu);
        SearchManager searchManager =
                (SearchManager) this.getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.ab_search).getActionView();
        assert searchManager != null;
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(this.getComponentName()));
/*         item1 = menu.findItem(R.id.xiaoxi);  失败
         item2 = menu.findItem(R.id.dingwei);*/

        return true;
    }

    //顶部导航栏菜单响应事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
/*            case R.id.ab_search:          失败
                item1.setVisible(false);
                item2.setVisible(false);*/

            case R.id.dingwei:
                Intent intent_dingwei = new Intent(this,mapActivity.class);    //地图获取失败
                startActivity(intent_dingwei);
                break;
            case R.id.xiaoxi:
                Intent intent_xiaoxi = new Intent(this,ChatFaceActivity.class);
                startActivity(intent_xiaoxi);
                break;
            default:

        }
        return super.onOptionsItemSelected(item);
    }




    //左侧导航栏响应事件
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_camera:
                return true;
            case R.id.nav_gallery:
                return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

