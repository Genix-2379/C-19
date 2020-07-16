package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.local.IndexedQueryEngine;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    public GoogleSignInClient mGoogleSignInClient;
    private  int RC_SIGN_IN =1;
    private FirebaseAuth mAuth;
    private TextView signu;
    private Button login;
    private TextView welcome;
    private final int SPLASH__DELAY=1000;
    private final int SPLASH__DELAY1=2000;
    private ImageView back;
    private EditText pass;
    private  ImageView line;
    private TextView skip;
    private TextView ss;
    private ImageView logo;
    private Toast backToast;
    private TextView c19;
    private long backPressedTime;
    private EditText Email;
   @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null)
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        login = (Button) findViewById(R.id.login);
       // line=(ImageView)findViewById(R.id.line);
       // Button register = (Button) findViewById(R.id.lregister);
        back=(ImageView)findViewById(R.id.Back);
        pass=(EditText)findViewById(R.id.lpassword);
        logo=(ImageView)findViewById(R.id.logo);
        Email=(EditText)findViewById(R.id.lemail);
        ss=(TextView)findViewById(R.id.ss2);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.login_tool);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        welcome=(TextView)findViewById(R.id.Welcome);
        skip=(TextView)findViewById(R.id.skip);
        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        signu=(TextView)findViewById(R.id.signup);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        animatetext();
        animatetb();
        animatetb2();
        animatebut();
        animateimage();
        animatec9();
        animatess();
        animateline();


        signu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, LoginRegActivity.class);
                startActivity(intent);
                finish();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String logemail= Email.getText().toString().trim();
                String logpass= pass.getText().toString().trim();
                if(TextUtils.isEmpty(logemail))
                {
                    Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(logpass))
                {
                    Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(logpass.length() < 6)
                {
                    Toast.makeText(LoginActivity.this, "Password Should be Atleast 6 Characters", Toast.LENGTH_SHORT).show();
                }

                    mAuth.signInWithEmailAndPassword(logemail,logpass)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                        Toast.makeText(getApplicationContext(),"Login Successfull!",Toast.LENGTH_SHORT).show();

                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();               }
                                }
                            });

            }
        });

    }

    private void animatebut() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        login.startAnimation(fadingInAnimation);
    }

    private void animatetb2() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        Email.startAnimation(fadingInAnimation);
    }



    private void animatetb() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        pass.startAnimation(fadingInAnimation);
    }


    private void animateimage() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        signu.startAnimation(fadingInAnimation);
    }

    private void animatetext() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        welcome.startAnimation(fadingInAnimation);
    }
         private void animatec9(){
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadingInAnimation.setDuration(SPLASH__DELAY1);
        logo.startAnimation(fadingInAnimation);
    }
    private void animatess(){
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        ss.startAnimation(fadingInAnimation);
        
    }
    private void animateline() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fadingInAnimation.setDuration(SPLASH__DELAY);
        line.startAnimation(fadingInAnimation);
    }
  private void signIn() {

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);

                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                Toast.makeText(this, "Failed to open", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();


                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }

                        }
                });
    }

    public TextView getWelcome() {
        return welcome;
    }

    public void setWelcome(TextView welcome) {
        this.welcome = welcome;
    }
    @Override
    public void onBackPressed(){

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(), "Press Back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime= System.currentTimeMillis();

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
