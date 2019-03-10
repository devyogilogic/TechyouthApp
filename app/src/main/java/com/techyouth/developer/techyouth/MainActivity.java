package com.techyouth.developer.techyouth;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

