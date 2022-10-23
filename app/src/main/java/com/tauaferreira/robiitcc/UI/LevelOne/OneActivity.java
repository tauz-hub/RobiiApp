package com.tauaferreira.robiitcc.UI.LevelOne;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;

public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_template_dialog);
        TextView txt = findViewById(R.id.textView_template_dialog);

        txt.setText("Olá programador (a), me chamo Iobi e preciso da sua ajuda para realizar meu projeto que se chama Robii, posso contar com você?\n" +
                "Iobiiiii ! Vamos nessa !!!  \n");


        ImageView btNext = findViewById(R.id.button_template_next);

        btNext.setOnClickListener(v->{
            startActivity(new Intent(getBaseContext(), SecondActivity.class));
        });
        ImageView btBack = findViewById(R.id.button_backArrow);


        btBack.setOnClickListener(v->{
            this.finish();
        });


    }
}
