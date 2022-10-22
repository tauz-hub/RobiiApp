package com.tauaferreira.robiitcc.UI.LevelOne;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_template_dialog);
        TextView txt = findViewById(R.id.textView_template_dialog);

        txt.setText("Já tenho a base,\n" +
                "porém preciso destrancar o baú onde ele está. Me ajude a colocar a ordem correta dos números \n");


        ImageView btNext = findViewById(R.id.button_template_next);
        ImageView btBack = findViewById(R.id.button_backArrow);
        btNext.setOnClickListener(v->{
            startActivity(new Intent(getBaseContext(), ThreeActivity.class));
        });

        btBack.setOnClickListener(v->{
            this.finish();
        });

    }
}
