package com.example.workproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity{

    private SimpleApi simpleApi;
    private TextView username;
    private TextView password;
    private MaterialButton loginbtn;
    private String Successful = "";
    private String uah;
    private TextView token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        token = (TextView) findViewById(R.id.token);


        loginbtn.setOnClickListener(new View.OnClickListener() { //When this button is clicked the paramaters get passed and the function to post is called
            @Override
            public void onClick(View view) {
             createPost(username.getText().toString(),password.getText().toString());
            }
        });


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vmtrack.atrams.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        simpleApi = retrofit.create(SimpleApi.class);
    }

    private void createPost(String emailParam,String passwordParam){
        Successful = "True";
        Post post = new Post( emailParam, passwordParam); //send post request
        Call<Post> call = simpleApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                  //  viewResults.setText("Code: " + response.code());//if it is not successful enter block
                    Toast.makeText(LoginActivity.this,"Code::: "+ response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                Post postResponse = response.body();
                uah = postResponse.getUser_api_hash().toString();

                if (Successful == "True"){
                    Toast.makeText(LoginActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();

                    token.setText(uah);
                    Log.d("This is token in login", token.getText().toString());
                    token.setVisibility(View.INVISIBLE);

                    openActivity();
                }
                else{
                    Toast.makeText(LoginActivity.this,"LOGIN FAILED!!!",Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Code::: " + t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }



        private void openActivity(){
            Intent intent = new Intent(LoginActivity.this, NavigationDrawer.class);
            intent.putExtra("sendDevice",uah);
            startActivity(intent);

        }
    //       private void openFragment(String thehashtoken){
 //       DevicesFragment myFragment = new DevicesFragment();
//
 //           FragmentTransaction fragmentTransaction = getSupportFragmentManager()
 //                   .beginTransaction();
 //
 //           data.putString("mydata", thehashtoken);
 //           myFragment.setArguments(data);
 //       // Intent intent = new Intent(LoginActivity.this, DevicesFragment.class);
 //      // intent.putExtra("sendDevice",uah);
 //      // startActivity(intent);
 //   }


    //       DevicesFragment myfragment = new DevicesFragment();
    //       FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//
    //       Bundle data = new Bundle();
    //       data.putString("dataapitoken",uah);
    //       myfragment.setArguments(data);
    //       fragmentTransaction.replace(R.id.nav_devicescustom, myfragment).commit();

    //  createDevices(uah);
    ///            FragmentManager fragmentManager = getSupportFragmentManager();
    ///             FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

    //DevicesFragment myFragment = new DevicesFragment();

//                    FragmentTransaction fragmentTransaction = getSupportFragmentManager()
    //                          .beginTransaction();

    ///           data.putString("mydata", uah);
    ///            DevicesFragment homeFragment = new DevicesFragment();
    ///             homeFragment.setArguments(data);
    //    myFragment.setArguments(data);
    ///             fragmentTransaction.commit();

}