package com.tauaferreira.robiitcc.UI.LevelTwo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;

public class LevelMainTwo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_template_dialog);
        TextView txt = findViewById(R.id.textView_template_dialog);

        txt.setText("IOBIIIIIIIIIII!!!!!!\n" +
                "Você foi excelente :)\n" +
                "Agora vamos começar a decorar o nosso Robô, me ajude a colocar as cores nos lugares certos.");


        ImageView btNext = findViewById(R.id.button_template_next);

        btNext.setOnClickListener(v->{
           startActivity(new Intent(getBaseContext(), LevelTwoSecondActivity.class));
        });
        ImageView btBack = findViewById(R.id.button_backArrow);


        btBack.setOnClickListener(v->{
            this.finish();
        });


    }
}
