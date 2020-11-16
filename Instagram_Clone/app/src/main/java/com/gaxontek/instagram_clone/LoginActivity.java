package com.gaxontek.instagram_clone;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    private  FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

    }
}