package com.example.pkbmdarulfalah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

public class Sign_Up_Form extends AppCompatActivity {


    private FirebaseAuth nAuth;
    private EditText email,password;
    private Button btndaftar;
    private Button textlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);

        nAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.daftar_email);
        password = findViewById(R.id.daftar_password);
        btndaftar = findViewById(R.id.tbldaftar);
        textlogin = findViewById(R.id.text_login);

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();

            }
        });

        textlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Sign_Up_Form.this, Log_In_Form.class));
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
                        Toast.makeText(Sign_Up_Form.this, "pendaftaran berhasil", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Sign_Up_Form.this, Log_In_Form.class));
                    }
                    else
                    {
                        Toast.makeText(Sign_Up_Form.this, "pendaftaran gagal"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}