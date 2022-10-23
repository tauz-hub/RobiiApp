package com.tauaferreira.robiitcc.UI.LevelThree;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;

public class LevelMainThree extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_template_dialog);
        TextView txt = findViewById(R.id.textView_template_dialog);

        txt.setText("Está indo muito bem!!!\n" +
                "Agora precisamos conectar os fios \n" +
                "para que o Robii se mexa ");


        ImageView btNext = findViewById(R.id.button_template_next);

        btNext.setOnClickListener(v->{
           startActivity(new Intent(getBaseContext(), LevelThreeSecondActivity.class));
        });
        ImageView btBack = findViewById(R.id.button_backArrow);


        btBack.setOnClickListener(v->{
            this.finish();
        });


    }
}
