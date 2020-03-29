package com.example.administrator.lifeschool_new;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2020/3/12.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.lifeschool_new.Bean.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class loginActivity extends AppCompatActivity {
    private EditText username,password;
    private Button login,zhuce;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        login = findViewById(R.id.login);
        zhuce = findViewById(R.id.zhuce);
        //
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setUsername(username.getText().toString().trim());
                user.setPassword(password.getText().toString().trim());
                user.login(new SaveListener<User>() {
                    @Override
                    public void done(User user, BmobException e) {
                        if (e == null) {
                            Toast.makeText(loginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            startActivities(new Intent[]{new Intent(loginActivity.this, MainActivity.class)});
                            finish();
                        } else {
                            Toast.makeText(loginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

                //注册监听
                zhuce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(loginActivity.this, Register.class));
                    }
                });

            }

}

