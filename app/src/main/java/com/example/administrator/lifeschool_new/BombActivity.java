package com.example.administrator.lifeschool_new;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2020/3/12.
 */
import android.app.Application;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import cn.bmob.v3.Bmob;


public class BombActivity extends AppCompatActivity {
    public static String APPID = "-----------------------------------------";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,APPID);
    }
}
