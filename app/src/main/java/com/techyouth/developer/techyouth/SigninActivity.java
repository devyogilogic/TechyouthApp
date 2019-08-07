package com.techyouth.developer.techyouth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
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
    public SharedPreferences mDetailsCahche;
    public  SharedPreferences.Editor editor;
    public static  String Userid;
    String pass;
    String email;

     EditText emailaddress;
    EditText password;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
         emailaddress =(EditText)findViewById(R.id.emailaddress);
         password=(EditText)findViewById(R.id.passsword);
         signin=(Button)findViewById(R.id.signbtn);



      //   CheckLoginStatus();



             mDetailsCahche = getSharedPreferences("LoginCache", MODE_PRIVATE);
             editor = mDetailsCahche.edit();
             mAPIService = ApiUtils.getLoginServiceApi();
             signin.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     email = emailaddress.getText().toString();
                     pass = password.getText().toString();
                     if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)) {
                         new LoginManager().execute();
                        // CheckLoginStatus();
                     }
                 }
             });


    }
     void CheckLoginStatus (){
        SharedPreferences prefs = getSharedPreferences("LoginCache", MODE_PRIVATE);
        String restoredText = prefs.getString("Status", null);
         Userid = prefs.getString("userid", null);
         Toast.makeText(this, ""+Userid, Toast.LENGTH_SHORT).show();
        // Toast.makeText(this, ""+restoredText, Toast.LENGTH_SHORT).show();
         if(restoredText.equals("User Log in")){
             startActivity(new Intent(SigninActivity.this,maincontrolller.class));

         }




    }
    public class LoginManager extends AsyncTask<Void,Void,Void>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog= new ProgressDialog(SigninActivity.this);
            progressDialog.setTitle("Logging you in !!!");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAPIService.loginuser(email,"",pass,"login").enqueue(new Callback<Register>() {
                @Override
                public void onResponse(Call<Register> call, Response<Register> response) {

                    Toast.makeText(SigninActivity.this, ""+response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    if(response.body().getStatus().equals("User Log in")){
                        editor.putString("userid",response.body().getUserid());
                        editor.putString("emailid",response.body().getEmailid());
                        editor.putString("username",response.body().getUsername());
                        editor.putString("password",response.body().getPassword());
                        editor.putString("Status",response.body().getStatus());
                        editor.apply();
                        editor.commit();

                        startActivity(new Intent(SigninActivity.this,maincontrolller.class));
                    }
                }

                @Override
                public void onFailure(Call<Register> call, Throwable t) {

                }
            });


            return null;
        }
    }
}
