package com.example.pkbmdarulfalah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Info_Kelas extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_kelas);

        View back_home = findViewById(R.id.button_info);
        View to_window = findViewById(R.id.button_window);

        back_home.setOnClickListener(v -> {
            Intent intentProfile_UserActivity = new Intent (Info_Kelas.this, Dashboard.class);
            startActivity(intentProfile_UserActivity);
        });
        to_window.setOnClickListener(v -> {
            Intent intentProfile_UserActivity = new Intent (Info_Kelas.this, Window_Kelas.class);
            startActivity(intentProfile_UserActivity);
        });

    }
}