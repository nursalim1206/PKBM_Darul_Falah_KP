package com.example.pkbmdarulfalah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {


    private FirebaseAuth nAuth;
    private EditText email,password;
    private Button btnregister;
    private TextView textlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        btnregister = findViewById(R.id.register);
        textlogin = findViewById(R.id.text_login);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();

            }
        });

        textlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, Log_In_Form.class));
            }
        });

    }

    private void register()
    {
        String user=email.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(user.isEmpty())
        {
            email.setError("email tidak boleh kosong");

        }
        if (pass.isEmpty())
        {
            password.setError("password tidak boleh kosong");

        }
        else
        {
            nAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(RegisterActivity.this, "pendaftaran berhasil", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, Log_In_Form.class));
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, "pendaftaran gagal"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}