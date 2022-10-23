package com.tauaferreira.robiitcc.UI.LevelFour;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;

public class LevelFourSecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phases_create_commands);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ImageView imgV = findViewById(R.id.graph_level);

        Drawable drawable= getResources().getDrawable(R.drawable.phases_create_directions_front_white);
        imgV.setImageDrawable(drawable);

        ImageView btBack = findViewById(R.id.button_backArrow);


        btBack.setOnClickListener(v->{
            this.finish();
        });
    }
}
