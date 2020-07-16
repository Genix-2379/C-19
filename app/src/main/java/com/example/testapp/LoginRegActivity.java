package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;


public class LoginRegActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button register;
    private EditText password;
    private final int SPLASH__DELAY=1000;
    private TextView signin;
    private Toolbar toolbar;
    private ImageView logo1;
    private TextView skipp;
    private ImageView back;
    //private Button log;
    private EditText email;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reg);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        email=(EditText)findViewById(R.id.email);
        signin=(TextView)findViewById(R.id.signin);
        password=(EditText)findViewById(R.id.password);
        back=(ImageView)findViewById(R.id.Back);

        logo1=(ImageView)findViewById(R.id.logo1);
        register=(Button)findViewById(R.id.register);
        skipp=(TextView)findViewById(R.id.skipp);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getSupportActionBar().setCustomView(R.layout.reg_tool);
        animatetext();
        animatetb();
        animatetb2();
        animatebut();
        animateimage();

        skipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginRegActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginRegActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginRegActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temail= email.getText().toString().trim();
                String tpassword= password.getText().toString().trim();
                if(TextUtils.isEmpty(temail)){
                    Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(tpassword)){
                    Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(tpassword.length() < 6)
                {
                    Toast.makeText(LoginRegActivity.this, "Password Should be Atleast 6 Characters", Toast.LENGTH_SHORT).show();
                }
                if(tpassword!=null && temail!=null)
                {
                    mAuth.createUserWithEmailAndPassword(temail, tpassword)
                            .addOnCompleteListener(LoginRegActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(LoginRegActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                        Toast.makeText(getApplicationContext(),"Registration complete",Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();                                    }
                                }
                            });
                }
            }
        });
    }

    private void animatebut() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        back.startAnimation(fadingInAnimation);
    }

    private void animatetb2() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        email.startAnimation(fadingInAnimation);
    }



    private void animatetb() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        password.startAnimation(fadingInAnimation);
    }


    private void animateimage() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        signin.startAnimation(fadingInAnimation);
    }

    private void animatetext() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        register.startAnimation(fadingInAnimation);
    }
    private void animatelogo() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        logo1.startAnimation(fadingInAnimation);
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
