package com.example.workproject2.ui.devices;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.workproject2.Device;
import com.example.workproject2.DeviceDataTwo;
import com.example.workproject2.DeviceTwo;
import com.example.workproject2.Devicedata;
import com.example.workproject2.IconColors;
import com.example.workproject2.Items;
import com.example.workproject2.ItemsTwo;
import com.example.workproject2.R;
import com.example.workproject2.SimpleApi;
import com.example.workproject2.Users;
import com.example.workproject2.databinding.FragmentDevicesBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DevicesFragment extends Fragment {
    private TextView FragmentText;
    LinearLayout layout;
    private TextView sike;
    private SimpleApi simpleApi;
    private TextView viewDevices1,viewDevices2,viewDevices3;

    private Device[] device,devicereceive;
    private DeviceTwo[] deviceTwo;
    String newuah;
    DevicesViewModel devicesViewModel;
    View devices_view;
    FloatingActionButton immobilizebtn,enablebtn;
    FrameLayout howdy;
    ArrayList<Integer> number = new ArrayList<>();
    ArrayList<String> checkboxstring = new ArrayList<>();
    ArrayList<Integer> cbselecteddevices = new ArrayList<>();
    Boolean succeeded;

    private FragmentDevicesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        devicesViewModel = new ViewModelProvider(this).get(DevicesViewModel.class);

        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);
        //Fragment View Declaration
        binding = FragmentDevicesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        immobilizebtn = getActivity().findViewById(R.id.fBimmobilize);
        enablebtn = getActivity().findViewById(R.id.fBenable);
        //Access to Atrams API

/*
        Interceptor myinterceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                String url = request.url().toString();
                Log.d("TAG", url);

             return null;
            }
        };

        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
        okhttpBuilder.interceptors().add(myinterceptor);
*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vmtrack.atrams.co/")
     //         .client(okhttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        simpleApi = retrofit.create(SimpleApi.class);
        devicesViewModel = new ViewModelProvider(this).get(DevicesViewModel.class);
        devicesViewModel.getText().observe(getViewLifecycleOwner(), mText -> {
            // Perform an action with the latest item data

        });

        Bundle data = getArguments();
        if( data != null ){
            newuah = getArguments().getString("transfer");
        }
        System.out.println(newuah);

     try{
         createDevices(newuah);
        }
     catch (IllegalStateException e){
         createDevicesTwo(newuah);
        }


        //   final TextView textView = binding.textDevices;
     //   devicesViewModel.getText().observe(getViewLifecycleOwner(), FragmentText::setText);
        return root;


    }

   @Override
   public void onDestroyView() {
       super.onDestroyView();
       binding = null;
   }

    private void addnew(){
        layout = binding.getRoot().findViewById(R.id.container);
        devices_view = getLayoutInflater().inflate(R.layout.device_table,null,false);
        layout.addView(devices_view);
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
                    System.out.println(response.raw().request().url());
                    Toast.makeText(DevicesFragment.this.getContext(),"Code:::::: "+ response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                System.out.println(response.raw().request().url());
                device = response.body();
                int sumlength = 0;
                int itemslength = 0;
                Items[] items;

                for (int j=0; j<device.length; j++){
                    sumlength = sumlength + device[j].getItems().length;
                    System.out.println("total length of groups" + sumlength);

                }
                items = new Items[sumlength];
                int count = 0;
                for (int j=0; j<device.length; j++){

                    itemslength = itemslength + device[j].getItems().length;
                    System.out.println("total length of groups" + itemslength);

                    for(int i=0; i<device[j].getItems().length;i++){
                        items[count] = device[j].getItems()[i];
                        count++;
                    }

                }

                System.out.println("This is after the loop" + items.length);


                System.out.println("Device length" + device.length);

                System.out.println("in items " + items.length);

               /*
                items[0] = device[0].getItems()[0];
                System.out.println(items[0].getName());

                */


                Devicedata devicedata = items[0].getDevice_data();
                Log.d("this:::::::::::::::::",device[0].getTitle());
                Users users = devicedata.getUsers();
                System.out.println("hello" + users.getemail());
              //  sike.setText(users.getemail().toString());

                for (int i=0; i<items.length;i++){
                   int counters = i;
                    addnew();
                    CheckBox checkBox = (CheckBox) layout.getChildAt(i).findViewById(R.id.checkbox1);
                    checkBox.setText(items[i].getName());
                    viewDevices1 = layout.getChildAt(i).findViewById(R.id.textView1);
                    String speed = items[i].getSpeed().toString();
                    viewDevices2 = layout.getChildAt(i).findViewById(R.id.textView2);
                    if(speed.equals("0")){
                        viewDevices2.setText("No");
                    }
                    else {
                        viewDevices2.setText("Yes");
                    }
                    speed = speed + " kph";
                    viewDevices1.setText(speed);
                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            if (checkBox.isChecked()) {
                                number.add(compoundButton.getLayout().hashCode());
                                checkboxstring.add(checkBox.getLayout().getText().toString());
                                System.out.println("this is the index of this checkbox" + counters);
                            }
                            else {
                                for(int j=0;j<number.size();j++){
                                    if(compoundButton.getLayout().hashCode() == number.get(j)){
                                        number.remove(j);
                                    }
                                    if(compoundButton.getLayout().getText().toString() == checkboxstring.get(j)){
                                        checkboxstring.remove(j);
                                    }
                                }
                            }
                            System.out.println(number);
                            System.out.println(checkboxstring);
                        }
                    });

                    viewDevices3 = layout.getChildAt(i).findViewById(R.id.textView3);
                    viewDevices3.setText("No");

                }

                immobilizebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                             for (int i=0;i<checkboxstring.size();i++){
                                 for(int j=0; j<items.length; j++){
                                  if(checkboxstring.get(i) == items[j].getName().toString()){
                                  System.out.println("found the number at " + j);

                                  cbselecteddevices.add(j);
                                        succeeded = true;
                                      }
                                      else {
                                          succeeded = false;
                                      }

                                  }
                              }


                        int running=0;
                        //onClick Area

                        for (int i=0;i<cbselecteddevices.size(); i++){
                            String devicedaabi = items[cbselecteddevices.get(i)].getDevice_data().getsim_number();
                            System.out.println(devicedaabi.replaceAll("\\s",""));
                            sendSms(devicedaabi.trim(),"smart 24KN1 setparam 11700:2");
                            viewDevices3 = layout.getChildAt(cbselecteddevices.get(i)).findViewById(R.id.textView3);
                            viewDevices3.setText("Yes");

                      //
                        }
                        for (int i=0;i<cbselecteddevices.size(); i++) {
                            CheckBox checkBox = (CheckBox) layout.getChildAt(cbselecteddevices.get(i)).findViewById(R.id.checkbox1);
                            checkBox.toggle();
                        }
                        cbselecteddevices.clear();

                        //onClick Area
                    }
                });

                enablebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        for (int i=0;i<checkboxstring.size();i++){
                            for(int j=0; j<items.length; j++){
                                if(checkboxstring.get(i) == items[j].getName().toString()){
                                    System.out.println("found the number at " + j);
                                    cbselecteddevices.add(j);
                                    succeeded = true;
                                }
                                else {
                                    succeeded = false;
                                }
                            }
                        }

                        int running=0;
                        //onClick Area

                        for (int i=0;i<cbselecteddevices.size(); i++){
                            String devicedaabi = items[cbselecteddevices.get(i)].getDevice_data().getsim_number();
                            System.out.println(devicedaabi.replaceAll("\\s",""));
                            sendSms(devicedaabi.trim(),"resume");
                            viewDevices3 = layout.getChildAt(cbselecteddevices.get(i)).findViewById(R.id.textView3);
                            viewDevices3.setText("No");
                            //
                        }
                        //onClick Area
                        for (int i=0;i<cbselecteddevices.size(); i++) {
                            CheckBox checkBox = (CheckBox) layout.getChildAt(cbselecteddevices.get(i)).findViewById(R.id.checkbox1);
                            checkBox.toggle();
                        }

                        cbselecteddevices.clear();
                    }
                });



                int viewcount = layout.getChildCount();
                  }

            @Override
            public void onFailure(Call<Device[]> hello, Throwable t) {
          //      Toast.makeText(DevicesFragment.this.getContext(),"Code::: " + t.getMessage(),Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage().toString());
                createDevicesTwo(newuah);
            }
        });

    }

    public void sendSms(String passphone ,String passmessage){
        SmsManager mySmsManager = SmsManager.getDefault();
        if(!passphone.equals(" ")){
            mySmsManager.sendTextMessage(passphone,null,passmessage,null,null);
        }

    }

    private void createDevicesTwo(String apiToken){

        Map<String, String> data = new HashMap<>();
        data.put("lang","en");
        data.put("user_api_hash", apiToken);
        Call<DeviceTwo[]> hello = simpleApi.createDevicesTwo(data);

        hello.enqueue(new Callback<DeviceTwo[]>() {
            @Override
            public void onResponse(Call<DeviceTwo[]> hello, Response<DeviceTwo[]> response) {
                if (!response.isSuccessful()){
                    //  viewResults.setText("Code: " + response.code());
                    System.out.println(response.raw().request().url());
                    Toast.makeText(DevicesFragment.this.getContext(),"Code:::::: "+ response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                System.out.println(response.raw().request().url());
                deviceTwo = response.body();
                System.out.println("Device length" + deviceTwo.length);


                ItemsTwo[] items = deviceTwo[0].getItems();
                DeviceDataTwo devicedata = items[0].getDevice_data();
                IconColors iconColors = items[0].getIcon_colors();
                String devicesContent = "";
                Log.d("this:::::::::::::::::",deviceTwo[0].getTitle());
                Users[] users = devicedata.getUsers();


                for (int i=0; i<items.length;i++){
                    int count = i;
                    addnew();
                    CheckBox checkBox = (CheckBox) layout.getChildAt(i).findViewById(R.id.checkbox1);
                    checkBox.setText(items[i].getName());
                    viewDevices1 = layout.getChildAt(i).findViewById(R.id.textView1);
                    String speed = items[i].getSpeed().toString();
                    viewDevices2 = layout.getChildAt(i).findViewById(R.id.textView2);
                    if(speed.equals("0")){
                        viewDevices2.setText("No");
                    }
                    else {
                        viewDevices2.setText("Yes");
                    }
                    speed = speed + " kph";
                    viewDevices1.setText(speed);
                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            if (checkBox.isChecked()) {
                                number.add(compoundButton.getLayout().hashCode()    );
                                checkboxstring.add(compoundButton.getLayout().getText().toString());
                                System.out.println("this is the index of this checkbox" + count);
                            }
                            else {
                                for(int j=0;j<number.size();j++){
                                    if(compoundButton.getLayout().hashCode() == number.get(j)){
                                        number.remove(j);
                                    }
                                    if(compoundButton.getLayout().getText().toString() == checkboxstring.get(j)){
                                        checkboxstring.remove(j);
                                    }
                                }
                            }
                            System.out.println(number);
                            System.out.println(checkboxstring);
                        }
                    });

                    viewDevices3 = layout.getChildAt(i).findViewById(R.id.textView3);
                    viewDevices3.setText("No");

                }

                immobilizebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        for (int i=0;i<checkboxstring.size();i++){
                            for(int j=0; j<items.length; j++){
                                if(checkboxstring.get(i) == items[j].getName().toString()){
                                    System.out.println("found the number at " + j);

                                    cbselecteddevices.add(j);
                                    succeeded = true;
                                }
                                else {
                                    succeeded = false;
                                }
                            }
                        }



                        int running=0;
                        running = cbselecteddevices.size();
                        //onClick Area
                        for (int i=0;i<cbselecteddevices.size(); i++){
                            String devicedaabi = items[cbselecteddevices.get(i)].getDevice_data().getsim_number();
                            System.out.println(devicedaabi.replaceAll("\\s",""));
                            sendSms(devicedaabi.trim(),"smart 24KN1 setparam 11700:2");
                            viewDevices3 = layout.getChildAt(cbselecteddevices.get(i)).findViewById(R.id.textView3);
                            viewDevices3.setText("Yes");

                            //
                        }

                        for (int i=0;i< cbselecteddevices.size(); i++) {
                            CheckBox checkBox = (CheckBox) layout.getChildAt(cbselecteddevices.get(i)).findViewById(R.id.checkbox1);
                            checkBox.toggle();

                        }
                        cbselecteddevices.clear();
                        //onClick Area
                    }
                });

                enablebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        for (int i=0;i<checkboxstring.size();i++){
                            for(int j=0; j<items.length; j++){
                                if(checkboxstring.get(i) == items[j].getName().toString()){
                                    System.out.println("found the number at " + j);
                                    cbselecteddevices.add(j);
                                    succeeded = true;
                                }
                                else {
                                    succeeded = false;
                                }
                            }
                        }

                        int running=0;
                        //onClick Area

                        for (int i=0;i<cbselecteddevices.size(); i++){
                            String devicedaabi = items[cbselecteddevices.get(i)].getDevice_data().getsim_number();
                            System.out.println(devicedaabi.replaceAll("\\s",""));
                            sendSms(devicedaabi.trim(),"resume");
                            viewDevices3 = layout.getChildAt(cbselecteddevices.get(i)).findViewById(R.id.textView3);
                            viewDevices3.setText("No");
                            //
                        }
                        //onClick Area
                        for (int i=0;i<cbselecteddevices.size(); i++) {
                            CheckBox checkBox = (CheckBox) layout.getChildAt(cbselecteddevices.get(i)).findViewById(R.id.checkbox1);
                            checkBox.toggle();
                        }

                        cbselecteddevices.clear();
                    }
                });

                int viewcount = layout.getChildCount();
            }

            @Override
            public void onFailure(Call<DeviceTwo[]> hello, Throwable t) {
      //        Toast.makeText(DevicesFragment.this.getContext(),"Code::: " + t.getMessage(),Toast.LENGTH_SHORT).show();
                System.out.println(t.getMessage().toString());
            }
        });

    }





}
//   LayoutInflater inflater2 =  (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//private TextView igotit;
/*       //viewmodel = new ViewModelProvider(this).get(DevicesViewModel.class);
       // devicesViewModel.getText().observe(getViewLifecycleOwner(), FragmentText::setText );
      //  devicesViewModel.getText().observe(getViewLifecycleOwner(), FragmentText::setText);
      //  igotit = binding.fragmentTextview;
        newuah = igotit.getText().toString();
   */