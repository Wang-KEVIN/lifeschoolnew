package com.example.administrator.lifeschool_new;

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

/**
 * Created by Administrator on 2020/3/12.
 */

public class Register extends AppCompatActivity {

    private EditText username, password, nickname;
    private Button register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        nickname = findViewById(R.id.nickname);

        register = findViewById(R.id.register);

        //注册监听
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setUsername(username.getText().toString().trim());
                user.setPassword(password.getText().toString().trim());
                user.setNickname(nickname.getText().toString().trim());

                if (username.getText().toString().equals("")) {
                    Toast.makeText(Register.this, "用户名没有输入", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().equals("")) {
                    Toast.makeText(Register.this, "密码没有输入", Toast.LENGTH_SHORT).show();
                } else {
                    user.signUp(new SaveListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                            if (e == null) {
                                Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
                                startActivities(new Intent[]{new Intent(Register.this, MainActivity.class)});
                                finish();
                            } else {
                                Toast.makeText(Register.this, "注册失败", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });
    }
}