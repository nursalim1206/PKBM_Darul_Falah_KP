package com.example.pkbmdarulfalah;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class Profile_User extends Activity {

    TextView perubahan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);

        perubahan = findViewById(R.id.ajukan_peru);

        perubahan.setOnClickListener(v -> {
                Dialog customDialog = new Dialog (this);
                customDialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);
                customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                customDialog.getWindow().getAttributes().windowAnimations
                        = android.R.style.Animation_Dialog;
                customDialog.setContentView(R.layout.perubahan_profil);

            ImageButton ganti = customDialog.findViewById(R.id.ganti);

            ganti.setOnClickListener(f -> {
                    Dialog Dialogkonfirm = new Dialog(this);
                    Dialogkonfirm.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                            WindowManager.LayoutParams.WRAP_CONTENT);
                    Dialogkonfirm.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    Dialogkonfirm.getWindow().getAttributes().windowAnimations
                            = android.R.style.Animation_Dialog;
                    Dialogkonfirm.setContentView(R.layout.konfirmasi_perubahan);
                    customDialog.cancel();

                    TextView oke;

                    oke = Dialogkonfirm.findViewById(R.id.ok);

                oke.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    Dialogkonfirm.cancel();
                    }
                });

                    Dialogkonfirm.show();
                });
            customDialog.show();
        });

        };

}
