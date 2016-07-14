package com.example.heng.android12306;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by 恒 on 2016/5/15.
 */
public class SplashActivity extends Activity {
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 首先从SharedPreferences从取值，如果取到的值不为空则为自动登录跳转到MainActivity，否则非自动登录则跳转到LogionActivity
                SharedPreferences sp = getSharedPreferences("user",
                        Context.MODE_PRIVATE);
                String userName = sp.getString("name", "");
                String password = sp.getString("pwd", "");

                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
                    Intent intent = new Intent(SplashActivity.this,
                            LoginActivity.class);
                    startActivity(intent);
                } else {

                    Intent intent = new Intent(SplashActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                }
                finish();

            }
        },3000);
    }

}
