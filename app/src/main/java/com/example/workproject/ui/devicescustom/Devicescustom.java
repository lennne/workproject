package com.example.workproject.ui.devicescustom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.workproject.NavigationDrawer;
import com.example.workproject.Post;
import com.example.workproject.R;
import com.example.workproject.SimpleApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Devicescustom extends AppCompatActivity {

    private TextView something;
    private SimpleApi simpleApi;
    private String hastokenbeensent="False";
    private String tokenreceived ="True";
    private String uah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devicescustom);

        uah = getIntent().getStringExtra("devicescustom");
        Log.d("hastokenbeensentdevices",hastokenbeensent);
        Log.d("tokenreceived",tokenreceived);
        if (uah!=null){
            Log.d("token in devices custom", uah);
        }

   //     hastokenbeensent = getIntent().getStringExtra("tokenproblem");
   //     if(hastokenbeensent!=null){
   //         Log.d("hastokenbeensentdevices",hastokenbeensent);
   //     }
   //     else{
   //         hastokenbeensent="True";
   //     }



    //    if (tokenreceived =="True" && hastokenbeensent=="True"){
    //        openActivity();
    //    }


       // createPost();
      //  something =  (TextView) findViewById(R.id.token);
 //       uah = something.getText().toString();
    //    Log.d("This worked", uah);
    }

    private void createPost(String emailParam,String passwordParam){
        Post post = new Post( emailParam, passwordParam); //send post request
        Call<Post> call = simpleApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    //  viewResults.setText("Code: " + response.code());//if it is not successful enter block
                    Toast.makeText(Devicescustom.this,"Code::: "+ response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                Post postResponse = response.body();
                uah = postResponse.getUser_api_hash().toString();

            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(Devicescustom.this,"Code::: " + t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

  //  private void openActivity(){
  //      Intent intent = new Intent(Devicescustom.this, NavigationDrawer.class);
  //      intent.putExtra("devicescustom",tokenreceived);
  //      startActivity(intent);
  //  }

}