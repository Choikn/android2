package com.example.choikn.precious;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private ImageView logo;
    private EditText username, password;
    private TextView signup;
    private RelativeLayout hide;
    private Button login;
    private Animation up, appear;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        startActivity(new Intent(this, SplashActivity.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.rgb(255, 168, 0));
        }

        logo = (ImageView) findViewById(R.id.loginlogo);
        up = AnimationUtils.loadAnimation(this, R.anim.up);
        hide = (RelativeLayout) findViewById(R.id.hide);
        appear = AnimationUtils.loadAnimation(this, R.anim.appear);

        logo.setAnimation(up);
        hide.setAnimation(appear);

        username = (EditText) findViewById(R.id.username);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        username.setTypeface(face);

        password = (EditText) findViewById(R.id.password);
        Typeface face2 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        password.setTypeface(face2);

        signup = (TextView) findViewById(R.id.signup);
        Typeface face3 = Typeface.createFromAsset(getAssets(), "fonts/NotoSans-Regular.ttf");
        signup.setTypeface(face3);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        initialize();
    }

    private void setAnimation(Animation animation) {

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        logo.startAnimation(animation);
        hide.startAnimation(animation);
    }

    private void initialize() {
        InitializationRunnable init = new InitializationRunnable();
        new Thread(init).start();
    }

    class InitializationRunnable implements Runnable {
        public void run() {
        }
    }

}
