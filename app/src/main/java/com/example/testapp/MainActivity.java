package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
   // private FirebaseAuth mAuth;
   // private TextView ibutton;

    private int i=0;
    private ImageView imageView;
    private final int SPLASH__DELAY=2500;
    private final int SPLASH__DELAY2=1500;
    private TextView textView;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        initalizeView2();
        animatetext();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.main_tool);
        button = (Button) findViewById(R.id.buttonj);
       // ibutton=(TextView) findViewById(R.id.ibutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMain2Activity();
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain3Activity();
            }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain4Activity();
            }
        });

    }




    /*private void initalizeView() {
        imageView= findViewById (R.id.img1);
    }

        private void animatelogo () {

        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        imageView.startAnimation(fadingInAnimation);
    }
    */

    private void initalizeView2() {
        textView=findViewById (R.id.stay);
    }
    private void animatetext() {

        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY2);
        textView.startAnimation(fadingInAnimation);
    }

    public void openMain2Activity() {
    Intent intent = new Intent(this, Main2Activity.class);
    startActivity(intent);
}
    public void openMain3Activity() {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
    public void openMain4Activity() {
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_profile:
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.action_about:
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                builder.setCancelable(true);

                builder.setTitle("Disclaimer");
                builder.setMessage("This app was only designed to provide \n"+
                        "information about the Covid-19 \n" +
                        "counts all over india this app does not promote \n"+
                        "any kind of illegal activity such as \n" +
                        "stealing personal  information.\n" +
                        "All the data available on this app are form open source Websites.\n" +
                        "Special Thanks to https://www.covid19india.org/ \n" +
                        "and https://www.worldometers.info/coronavirus/country/india/.\n");
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            default:
                break;
        }
        return true;
    }

   /* @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        //    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                          //  | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }*/
}
