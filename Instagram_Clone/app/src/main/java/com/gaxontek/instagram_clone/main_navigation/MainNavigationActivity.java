package com.gaxontek.instagram_clone.main_navigation;

import android.os.Bundle;

import com.gaxontek.instagram_clone.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainNavigationActivity extends AppCompatActivity {

    BottomNavigationView mNavView;
    NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        UtilsInitilization();



        NavigationUI.setupWithNavController(mNavView, mNavController);
    }

    public void UtilsInitilization(){
        mNavView = findViewById(R.id.nav_view);
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);

    }
}