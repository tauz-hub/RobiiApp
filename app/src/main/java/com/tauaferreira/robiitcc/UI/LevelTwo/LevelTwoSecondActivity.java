package com.tauaferreira.robiitcc.UI.LevelTwo;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;

public class LevelTwoSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_phases_create_colors);

        ImageView btBack = findViewById(R.id.button_backArrow);
        btBack.setOnClickListener(v->{
            this.finish();
        });

    }
}
