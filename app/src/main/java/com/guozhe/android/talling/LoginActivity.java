package com.guozhe.android.talling;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends AppCompatActivity {

    private TextView loginFacebook;
    private TextView loginId;
    private TextView signUp;
    private ImageView imageView;
    private int[] imgIds = {R.mipmap.login_images1,R.mipmap.login_images2};
    private int imgStart = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 123){
                    imageView.setImageResource(imgIds[imgStart++ % 2]);
                }
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        loginAnimation();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(123);
            }
        },0,6000);
    }


    private void initView() {
        loginFacebook = (TextView) findViewById(R.id.login_facebook);
        loginId = (TextView) findViewById(R.id.login_id);
        signUp = (TextView) findViewById(R.id.signUp);
        imageView = (ImageView)findViewById(R.id.img);
    }
    private void loginAnimation(){
        Animation animation = AnimationUtils.loadAnimation(LoginActivity.this,R.anim.login_anim);
        imageView.setAnimation(animation);
    }
}
