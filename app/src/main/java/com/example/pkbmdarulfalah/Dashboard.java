package com.example.pkbmdarulfalah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class Dashboard extends Activity {

    ImageButton imagebutton04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        View imagebutton00 = findViewById(R.id.button);
        View imagebutton01 = findViewById(R.id.button1);
        View imagebutton02 = findViewById(R.id.button2);
        View imagebutton03 = findViewById(R.id.button3);
        imagebutton04 = findViewById(R.id.button4);
        View exit = findViewById(R.id.button5);

        imagebutton00.setOnClickListener(v -> {
            Intent intentProfile_UserActivity = new Intent (Dashboard.this, Profile_User.class);
            startActivity(intentProfile_UserActivity);
        });

        imagebutton01.setOnClickListener(v -> {
            Intent intentProfile_UserActivity = new Intent (Dashboard.this, Info_Kelas.class);
            startActivity(intentProfile_UserActivity);
        });

        imagebutton02.setOnClickListener(v -> {
            Intent intentProfile_UserActivity = new Intent (Dashboard.this, Jadwal.class);
            startActivity(intentProfile_UserActivity);
        });

        imagebutton03.setOnClickListener(v -> {
            Intent intentProfile_LembagaActivity = new Intent (Dashboard.this, Profile_Lembaga.class);
            startActivity(intentProfile_LembagaActivity);
        });

        exit.setOnClickListener(v -> {
        Dialog customDialog = new Dialog (this);
        customDialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        customDialog.getWindow().getAttributes().windowAnimations
                = android.R.style.Animation_Dialog;
        customDialog.setContentView(R.layout.confirm_exit);

        ImageButton yesBtn = customDialog.findViewById(R.id.btn_yes);
        ImageButton noBtn = customDialog.findViewById(R.id.btn_no);

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfile_UserActivity = new Intent (Dashboard.this, Log_In_Form.class);
                startActivity(intentProfile_UserActivity);
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.cancel();
            }
        });
        customDialog.show();

        });

        imagebutton04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("mailto: pkbmdarulfalah.jepara@gmail.com");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


    @Override
    public void onBackPressed(){

        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setMessage("Apakah Anda ingin keluar?")
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