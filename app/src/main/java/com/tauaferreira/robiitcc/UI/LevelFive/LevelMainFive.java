package com.tauaferreira.robiitcc.UI.LevelFive;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;

public class LevelMainFive extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_dialog);
        TextView txt = findViewById(R.id.textView_template_dialog);

        txt.setText("Muito bem progamador(a) !!! você é MUITO BOMMM :)\n" +
                "Agora complete a cruzadinha, para que assim você possa aprender quais as peças do Robii");


        ImageView btNext = findViewById(R.id.button_template_next);

        btNext.setOnClickListener(v -> {
            startActivity(new Intent(getBaseContext(), LevelFiveSecondActivity.class));
        });
        ImageView btBack = findViewById(R.id.button_backArrow);


        btBack.setOnClickListener(v -> {
            this.finish();
        });
    }
}
