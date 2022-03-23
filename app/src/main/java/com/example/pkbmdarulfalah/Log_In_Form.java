package com.example.pkbmdarulfalah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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

public class Log_In_Form extends Activity {

    private FirebaseAuth nAuth;
    private EditText email,password;
    private Button btnlogin;
    private TextView textregister;
    private TextView textbantuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_form);

        nAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        btnlogin = findViewById(R.id.tombol_masuk);
        textregister = findViewById(R.id.tombol_daftar);
        textbantuan = findViewById(R.id.bantuan);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        textregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Log_In_Form.this, Sign_Up_Form.class));
            }
        });
        textbantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("mailto: pkbmdarulfalah.jepara@gmail.com");
            }
        });
    }
    private void login()
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
            nAuth.signInWithEmailAndPassword(user,pass). addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if (task.isSuccessful())

                    {
                        Intent intentProfile_UserActivity = new Intent (Log_In_Form.this, Dashboard.class);
                        startActivity(intentProfile_UserActivity);
                        Toast.makeText(Log_In_Form.this, "login berhasil", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Log_In_Form.this,Dashboard.class));
                    }
                    else
                    {
                        Toast.makeText(Log_In_Form.this, "login gagal"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    @Override
    public void onBackPressed(){

        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setMessage("Apakah Anda ingin keluar dari aplikasi?")
                .setCancelable(false)
                .setPositiveButton("YA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}