package com.example.heng.android12306;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 恒 on 2016/5/15.
 */
public class LoginActivity extends Activity {
    private EditText userName;
    private EditText password;
    private TextView tVLostPassword;
    private Button btnLogin;
    private CheckBox ckLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) this.findViewById(R.id.btnLogin);// 找到控件
        userName = (EditText) this.findViewById(R.id.edtUsername);
        password = (EditText) this.findViewById(R.id.edtPassword);
        tVLostPassword = (TextView) this.findViewById(R.id.tVLostPassword);
        ckLogin = (CheckBox) this.findViewById(R.id.ckLogin);

        // 忘记密码链接
        tVLostPassword.setText(Html
                .fromHtml("<a href=\"http://www.12306.cn\">忘记密码？</a>"));
        tVLostPassword.setMovementMethod(LinkMovementMethod.getInstance());
        // 利用匿名类来响应事件

        btnLogin.setOnClickListener(new View.OnClickListener() {// 使用匿名类

            @Override
            public void onClick(View view) {// 在此方法实现事件处理
                // 如果用户名为空，则提示不能为空
                if (TextUtils.isEmpty(userName.getText().toString())) {

                    userName.setError("请输入用户名");
                    userName.requestFocus();// 获得输入焦点

                } else if (TextUtils.isEmpty(password.getText().toString())) {
                    password.setError("请输入密码");
                    password.requestFocus();
                } else if ("heng".equals(userName.getText().toString())
                        && "heng".equals(password.getText().toString())) {
                    // 实现自动保用户名和密码
                    if (ckLogin.isChecked()) { // 如果自动登录被选 中
                        // 1、获得SharedPreferences 对象
                        SharedPreferences sp = getSharedPreferences("user",
                                Context.MODE_PRIVATE);
                        // 2.获得编辑器
                        SharedPreferences.Editor editor = sp.edit();
                        // 3.利用Editor编辑器将用户和密码通过键值对形式放入到user中
                        editor.putString("name", userName.getText().toString());
                        editor.putString("pwd", password.getText().toString());
                        // 4.提交数据
                        editor.commit();

                    } else {
                        // 如果没有选中则清除以前登录的信息
                        // 1、获得SharedPreferences 对象
                        SharedPreferences sp = getSharedPreferences("user",
                                Context.MODE_PRIVATE);
                        // 2.获得编辑器
                        SharedPreferences.Editor editor = sp.edit();
                        //根据键来清除值
                        editor.remove("name");
                        editor.remove("pwd");
                        editor.commit();

                    }

                    // 使显示意图实现Activity的跳转
                    Intent intent = new Intent(LoginActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "用户名或密码不正确",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
