package com.techyouth.developer.techyouth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigninActivity extends AppCompatActivity {
    private LoginServiceApi mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        final EditText emailaddress =(EditText)findViewById(R.id.emailaddress);
        final EditText password=(EditText)findViewById(R.id.passsword);
        final Button signin=(Button)findViewById(R.id.signbtn);
        mAPIService = ApiUtils.getLoginServiceApi();
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailaddress.getText().toString();
                String pass=password.getText().toString();
                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) ) {
                    mAPIService.loginuser(email,"",pass,"login").enqueue(new Callback<Register>() {
                        @Override
                        public void onResponse(Call<Register> call, Response<Register> response) {
                            Toast.makeText(SigninActivity.this, ""+response.body().getStatus(), Toast.LENGTH_SHORT).show();
                            if(response.body().getStatus().equals("User Log in")){
                                startActivity(new Intent(SigninActivity.this,maincontrolller.class));
                            }
                        }

                        @Override
                        public void onFailure(Call<Register> call, Throwable t) {

                        }
                    });
                }
            }
        });

    }
}
