package com.example.administrator.lifeschool_new;


import android.content.Intent;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
/**
 * Created by Administrator on 2020/3/12.
 */

public class firstActivity extends AppCompatActivity {

    private int recLen = 5;//跳过倒计时提示5秒
    private Button dl;
    private Handler handler;
    private Runnable runnable;
    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        Button button = findViewById(R.id.dl);
        //延时操作
        timer.schedule(timetast,1000,1000);
        Bmob.initialize(this,"a6184deeaa6e1e8e05bb3d9e08e0cc7c");

        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                BmobUser bmobUser = BmobUser.getCurrentUser(BmobUser.class);
                if(bmobUser == null)
                startActivity(new Intent(firstActivity.this,loginActivity.class));

            }
        },5000);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(firstActivity.this,loginActivity.class));
                if (runnable!= null){
                    handler.removeCallbacks(runnable);
                }
            }
        });

        }



    TimerTask timetast = new TimerTask() {
        @Override
        public void run() {
            //startActivity(new Intent(first_Activity.this,MainActivity.class));
            BmobUser bmobUser = BmobUser.getCurrentUser(BmobUser.class);
            if(bmobUser != null) {
                startActivity(new Intent(firstActivity.this, MainActivity.class));
                finish();
                timer.cancel();
            }
            else{
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recLen--;
                        if (recLen<0){
                            timer.cancel();
                        }
                    }
                });
            }
        }
    };

}




