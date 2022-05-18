package com.example.workproject.ui.devices;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.workproject.Device;
import com.example.workproject.Devicedata;
import com.example.workproject.IconColors;
import com.example.workproject.Items;
import com.example.workproject.MainActivity2;
import com.example.workproject.NavigationDrawer;
import com.example.workproject.R;
import com.example.workproject.SimpleApi;
import com.example.workproject.databinding.FragmentDevicesBinding;
import com.example.workproject.databinding.FragmentGalleryBinding;
import com.example.workproject.ui.devices.DevicesViewModel;

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
    private SimpleApi simpleApi;
    private TextView viewDevices1,viewDevices2,viewDevices3;
    private TextView igotit;
    private Device[] device,devicereceive;
    String newuah;
    DevicesViewModel devicesViewModel;
    View devices_view;
    FrameLayout howdy;

    private FragmentDevicesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        devicesViewModel = new ViewModelProvider(this).get(DevicesViewModel.class);

        //Fragment View Declaration
        binding = FragmentDevicesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //viewmodel = new ViewModelProvider(this).get(DevicesViewModel.class);
       // devicesViewModel.getText().observe(getViewLifecycleOwner(), FragmentText::setText );
      //  devicesViewModel.getText().observe(getViewLifecycleOwner(), FragmentText::setText);
        igotit = binding.fragmentTextview;
    //    newuah = igotit.getText().toString();

        //Log.d("hopefully",newuah);
        //Access to Atrams API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vmtrack.atrams.co/")
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
            Log.d("worked",newuah);
        }
        createDevices(newuah);

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
                    Toast.makeText(DevicesFragment.this.getContext(),"Code:::::: "+ response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }
                device = response.body();
                Items[] items = device[0].getItems();
                Devicedata devicedata = items[0].getDevice_data();
                IconColors iconColors = items[0].getIcon_colors();
                String devicesContent = "";
                Log.d("this:::::::::::::::::",device[0].getTitle());

                for (int i=0; i<items.length;i++){
                    addnew();
                    final CheckBox checkBox = (CheckBox) layout.getChildAt(i).findViewById(R.id.checkbox1);
                    checkBox.setText(items[i].getName());
                    viewDevices1 = layout.getChildAt(i).findViewById(R.id.textView1);
                    String speed = items[i].getSpeed().toString() + " kph";
                    viewDevices1.setText(speed);
                    viewDevices2 = layout.getChildAt(i).findViewById(R.id.textView2);
                    if(speed == "0"){
                        viewDevices2.setText("No");
                    }
                    else{
                        viewDevices2.setText("No");
                    }

                    viewDevices3 = layout.getChildAt(i).findViewById(R.id.textView3);

                }

                int viewcount = layout.getChildCount();
                Log.d("Number of views", String.valueOf(viewcount));
                //  Log.d("checking", mandem );



            }

            @Override
            public void onFailure(Call<Device[]> hello, Throwable t) {

            }
        });

    }


}
//   LayoutInflater inflater2 =  (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);