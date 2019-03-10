package com.techyouth.developer.techyouth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.JsonReader;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private LoginServiceApi mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText username=(EditText)findViewById(R.id.username);
        final EditText emaildadd=(EditText)findViewById(R.id.emailadd);
        final EditText pass=(EditText)findViewById(R.id.pass);
        final ImageView correct=(ImageView)findViewById(R.id.correct);
        mAPIService = ApiUtils.getLoginServiceApi();
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            correct.setAlpha(1f);

            correct.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String usernames = username.getText().toString().trim();
                    String ema = emaildadd.getText().toString().trim();
                    String passes = pass.getText().toString().trim();
                    String want="signup";
                    Toast.makeText(RegisterActivity.this, ""+   usernames, Toast.LENGTH_SHORT).show();
                    Toast.makeText(RegisterActivity.this, ""+   ema, Toast.LENGTH_SHORT).show();

                    if(!TextUtils.isEmpty(usernames) && !TextUtils.isEmpty(ema) && !TextUtils.isEmpty(passes)) {
                        Register register=new Register(ema,want,usernames,passes);
                        mAPIService.registeruser(ema,usernames,passes,want).enqueue(new Callback<Register>() {
                            @Override
                            public void onResponse(Call<Register> call, Response<Register> response) {


                                Toast.makeText(RegisterActivity.this, ""+response.body().getStatus(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onFailure(Call<Register> call, Throwable t) {
                                Toast.makeText(RegisterActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                    else  {
                        correct.setAlpha(0.5f);
                        correct.setClickable(false);
                    }
                }
            });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
}
