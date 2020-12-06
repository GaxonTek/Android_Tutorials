package com.gaxontek.instagram_clone.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gaxontek.instagram_clone.R;
import com.gaxontek.instagram_clone.main_navigation.MainNavigationActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btnSignIn;
    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        UtilsInitialization();

        //For Testing
        btnSignIn.setEnabled(true);

        etEmail.addTextChangedListener(watcher);
        etPassword.addTextChangedListener(watcher);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                //For Testing
                email = "test@email.com";
                password = "Password";
                if(FieldCheck()){
                    Toast.makeText(SignInActivity.this, "Please Fill in All the Fields!", Toast.LENGTH_LONG).show();
                }
                else{
                    SignIn(email,password);
                }
            }
        });
    }

    private void UtilsInitialization(){
        btnSignIn = findViewById(R.id.btn_signin);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void afterTextChanged(Editable editable) {
            if(FieldCheck()){
                btnSignIn.setEnabled(true);
            }
        }
    };

    private boolean FieldCheck() {
        if (etEmail.getText().toString().trim().length() == 0 || etPassword.getText().toString().trim().length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    private void SignIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(SignInActivity.this, MainNavigationActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}