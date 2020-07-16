package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_toolbar);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);
    }

    public void assam(View view) {
        goToUrl("http://103.8.249.88/applyonline/index.php/gatepasscontrol/applycaronline");
    }

    public void chattis(View view) {
        goToUrl("https://play.google.com/store/apps/details?id=com.allsoft.corona");
    }

    public void del(View view) {
        goToUrl("https://www.nvsrobhopal.com/article/delhi-curfew-e-pass-online-status-janta-samwad/");
    }

    public void har(View view) {
        goToUrl("https://covidssharyana.in/");
    }

    public void up(View view) {
        goToUrl("http://164.100.68.164/upepass2/");
    }

    public void mp(View view) {
        goToUrl("https://mapit.gov.in/covid-19/");
    }

    public void jh(View view) {
        goToUrl("https://play.google.com/store/apps/details?id=com.pragyaam.grid.mobile&hl=en_IN");
    }

    public void kol(View view) {
        goToUrl("https://coronapass.kolkatapolice.org/");
    }

    public void uk(View view) {
        goToUrl("https://policecitizenportal.uk.gov.in/e_pass/Home/Index");
    }

    public void pb(View view) {
        goToUrl("https://epasscovid19.pais.net.in/");
    }

    public void ker(View view) {
        goToUrl("https://pass.bsafe.kerala.gov.in/");
    }

    public void go(View view) {
        goToUrl("https://goaonline.gov.in/Public/UserRegistration_af");
    }

    public void tn(View view) {
        goToUrl("https://serviceonline.gov.in/tamilnadu/error.do");
    }

    public void hp(View view) {
        goToUrl("http://covidepass.hp.gov.in/apply-for-e-pass/");
    }

    public void mh(View view) {
        goToUrl("https://covid19.mhpolice.in/");
    }

    public void rj(View view) {
        goToUrl("https://play.google.com/store/apps/details?id=com.datainfosys.rajasthanpolice.publicapp");
    }

    public void bih(View view) {
        goToUrl("http://biharpolice.bih.nic.in/");
    }

    public void gj(View view) {
        goToUrl("https://www.digitalgujarat.gov.in/Citizen/CitizenService.aspx");
    }

    public void wb(View view) {
        goToUrl("https://uidai-aadharhelp.in/corona-e-pass-curfew-pass-online/#epassinkolkata");
    }

    public void kr(View view) {
        goToUrl("https://play.google.com/store/apps/details?id=com.mygate.express&hl=en");
    }

    public void odi(View view) {
        goToUrl("http://epass.ocac.in/");
    }

    public void ap(View view) {
        goToUrl("https://gramawardsachivalayam.ap.gov.in/CVPASSAPP/CV/CVOrganizationRegistration");
    }


    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);

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


