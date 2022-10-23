package com.tauaferreira.robiitcc.UI.LevelThree;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;

public class LevelThreeSecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phases_create_eletric);
        ImageView btBack = findViewById(R.id.button_backArrow);


        btBack.setOnClickListener(v->{
            this.finish();
        });
    }
}
