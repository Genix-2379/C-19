package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static androidx.core.content.ContextCompat.startActivity;

public class Main5Activity extends AppCompatActivity {
//private ImageView imageView;
private final int SPLASH__DELAY=3500;
    private ImageView logo;
    private TextView textView2;
    @SuppressLint({"WrongViewCast", "WrongConstant"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       requestWindowFeature(Window.FEATURE_NO_TITLE);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main5);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.splash_tool);

       // Logo logo = new Logo();
        //logo.start();
        //getWindow().setBackgroundDrawable(null);
        initalizeView();
        animatetext();
        initalizeView2();
        animatetext2();
        goToMainActivity();
    }


    private void initalizeView() {
         logo = findViewById(R.id.slogo);
    }
    private void animatetext() {

        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        logo.startAnimation(fadingInAnimation);
    }
    private void initalizeView2() {
        textView2 = findViewById(R.id.s);
    }
    private void animatetext2() {

        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        textView2.startAnimation(fadingInAnimation);
    }

    private void goToMainActivity() {
                new Handler().postDelayed(() -> {
                    startActivity(new Intent(this, LoginActivity.class));
                    finish();
                }, SPLASH__DELAY);
            }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
    /*private class Logo extends Thread {
        public void run() {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent;
            intent = new Intent(Main5Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
*/




