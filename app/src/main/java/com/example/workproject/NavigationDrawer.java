package com.example.workproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.workproject.databinding.ContentNavigationDrawerBinding;
import com.example.workproject.ui.devices.DevicesFragment;
import com.example.workproject.ui.devices.DevicesViewModel;
import com.example.workproject.ui.devicescustom.Devicescustom;
import com.example.workproject.ui.gallery.GalleryFragment;
import com.example.workproject.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.workproject.databinding.ActivityNavigationDrawerBinding;

import org.w3c.dom.Text;

public class NavigationDrawer extends AppCompatActivity {
    String sendtoken = "True";
    String tokenreceived = "False";
    private TextView FragmentText;
    String uah,email;
    MenuItem item;
    Handler handler;
    public DevicesViewModel viewmodel;
    NavController navController;


    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewmodel = new ViewModelProvider(this).get(DevicesViewModel.class);


        uah = getIntent().getStringExtra("sendDevice");
        email = getIntent().getStringExtra("sendEmail");

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar);
    /*    binding.appBarNavigationDrawer.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

     */
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_devices, R.id.nav_devicescustom)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        View headerview = navigationView.getHeaderView(0);


        FragmentText = headerview.findViewById(R.id.textView);
        FragmentText.setText(email);
        openFragment();
        Log.d("this is navigation", uah);
    }

    private void openFragment(){
      FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
      DevicesFragment fragment = new DevicesFragment();
      Bundle data = new Bundle();
      data.putString("transfer", uah);
      fragment.setArguments(data);
      fragmentTransaction.add(fragment,"myfragment").replace(R.id.nav_host_fragment_content_navigation_drawer,fragment).commit();








        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
      //  GalleryFragment fragment1 = new GalleryFragment();
      //  HomeFragment fragment2 = new HomeFragment();
      //  FragmentManager fragmentTransaction = getSupportFragmentManager();
      //  DevicesFragment fragment = new DevicesFragment();
      //  Bundle data = new Bundle();
//
      //  data.putString("transfer", uah);
//
      //  fragment.setArguments(data);
      //  fragmentTransaction.beginTransaction().replace(R.id.nav_host_fragment_content_navigation_drawer,new DevicesFragment()).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_logout:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



 //  private void openActivity(){
 //      Intent intent = new Intent(NavigationDrawer.this, Devicescustom.class);
 //      intent.putExtra("devicescustom",uah);
 //      intent.putExtra("tokenproblem", "False");
 //      startActivity(intent);
 //  }


}