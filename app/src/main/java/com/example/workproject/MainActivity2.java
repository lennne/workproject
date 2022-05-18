package com.example.workproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    private SimpleApi simpleApi;
    private TextView viewResults;
    private TextView viewDevices;
    private Device[] device;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vmtrack.atrams.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        simpleApi = retrofit.create(SimpleApi.class);



        viewResults = findViewById(R.id.mA2viewResults);
        viewDevices = findViewById(R.id.mA2viewDevices);
        String uah = getIntent().getStringExtra("sendDevice");
        createDevices(uah);

       Intent intent2 = new Intent(this, NavigationDrawer.class);
       startActivity(intent2);





    }

    private void createDevices(String apiToken){

        Map<String, String> data = new HashMap<>();
        data.put("lang","en");
        data.put("user_api_hash", apiToken);
        Call<Device[]> hello = simpleApi.createDevices(data);

        hello.enqueue(new Callback<Device[]>() {
            @Override
            public void onResponse(Call<Device[]> hello, Response<Device[]> response) {
                if (!response.isSuccessful()){
                    //  viewResults.setText("Code: " + response.code());
                    Toast.makeText(MainActivity2.this,"Code:::::: "+ response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }



                device = response.body();
                Items[] items = device[0].getItems();
                Log.d("this",items[0].getName());
                String devicesContent = "";
                devicesContent += "Name of : " + items[0].getName() + "\n\n";
                devicesContent += "Name of : " + items[1].getName() + "\n\n";
                devicesContent += "Name of : " + items[2].getName() + "\n\n";
                devicesContent += "Name of : " + items[3].getName() + "\n\n";
                devicesContent += "number of devices" + items.length;
                viewDevices.setText(devicesContent);
                Log.d("this:::::::::::::::::",device[0].getTitle());

            }

            @Override
            public void onFailure(Call<Device[]> hello, Throwable t) {
                Toast.makeText(MainActivity2.this,"LOGIN FAILED!!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

}