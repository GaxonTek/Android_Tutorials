package com.gaxontek.instagram_clone.authentication;

import androidx.appcompat.app.AppCompatActivity;

import com.gaxontek.instagram_clone.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private  FirebaseAuth mAuth;

    private Button btnSignIn;
    private TextView tvNewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        UtilsInitilization();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
        tvNewAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    private void UtilsInitilization(){
        btnSignIn = findViewById(R.id.btn_signin);
        tvNewAccount = findViewById(R.id.text_create_account);
    }
}