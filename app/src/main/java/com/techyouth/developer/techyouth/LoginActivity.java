package com.techyouth.developer.techyouth;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
   public static  String server="http://192.168.2.110/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button signin=(Button)findViewById(R.id.sign);
        Button register=(Button)findViewById(R.id.register);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,SigninActivity.class);

                startActivity(i);
                overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
            }
        });
      register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(LoginActivity.this,RegisterActivity.class);

              startActivity(i);
              overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);

          }
      });
    }
}
