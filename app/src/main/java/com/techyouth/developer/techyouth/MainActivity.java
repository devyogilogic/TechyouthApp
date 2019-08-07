package com.techyouth.developer.techyouth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,LoginActivity.class);

                startActivity(i);
                overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);


            }
        },3000);
      //  CheckLoginStatus();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    void CheckLoginStatus () {
        SharedPreferences prefs = getSharedPreferences("LoginCache", MODE_PRIVATE);
        String restoredText = prefs.getString("Status", null);
        //  Userid = prefs.getString("userid", null);
        //  Toast.makeText(this, ""+Userid, Toast.LENGTH_SHORT).show();
        // Toast.makeText(this, ""+restoredText, Toast.LENGTH_SHORT).show();
        if (restoredText.equals("User Log in")) {
            Intent i = new Intent(MainActivity.this, maincontrolller.class);

            startActivity(i);
            overridePendingTransition(R.anim.lefttoright, R.anim.righttoleft);

        }
        else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i=new Intent(MainActivity.this,LoginActivity.class);

                    startActivity(i);
                    overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);


                }
            },3000);
        }
    }
}

