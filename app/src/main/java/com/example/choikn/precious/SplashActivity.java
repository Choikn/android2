package com.example.choikn.precious;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.logging.LogRecord;

public class SplashActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView tv = (TextView)findViewById(R.id.precious);
        String string = "PRECIOUS";
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/Cocogoose_trial.otf");
        tv.setTypeface(face);
        int color = Color.rgb(102,67,30);
        SpannableStringBuilder builder = new SpannableStringBuilder(string);
        builder.setSpan(new ForegroundColorSpan(color),0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.append(builder);


        initialize();
    }



    private void initialize()
    {
        Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                finish();

                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        };
        handler.sendEmptyMessageDelayed(0,1500);
    }
}
