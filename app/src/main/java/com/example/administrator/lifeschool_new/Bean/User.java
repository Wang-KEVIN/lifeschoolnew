package com.example.administrator.lifeschool_new.Bean;

import cn.bmob.v3.BmobUser;
/**
 * Created by Administrator on 2020/3/12.
 */

    public class User extends BmobUser {

        private  String nickname;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;

        }
    }

