package com.tauaferreira.robiitcc.UI.LevelOne;

import static com.tauaferreira.robiitcc.Utils.Constants.SECRET_PREFERENCE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.DAO.UsuarioDAO;
import com.tauaferreira.robiitcc.R;
import com.tauaferreira.robiitcc.UI.LessonListActivity;

public class LevelOneFourActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_template_dialog);
        TextView txt = findViewById(R.id.textView_template_dialog);

        txt.setText("Parabéns");


        ImageView btBack = findViewById(R.id.button_backArrow);

        Drawable drawable = getResources().getDrawable(R.drawable.phases_black_arrow);
        btBack.setImageDrawable(drawable);




    }

    @Override
    protected void onResume() {
        super.onResume();
        ImageView btNext = findViewById(R.id.button_template_next);

        btNext.setOnClickListener(v->{
            SharedPreferences prefs = getSharedPreferences(SECRET_PREFERENCE , MODE_PRIVATE);
            String username = prefs.getString("usernameSave", null);

            boolean setLevel = UsuarioDAO.setLevelUser(username, 1);

            if(setLevel){
                System.out.print("tudo certo");
            }


            startActivity(new Intent(getBaseContext(), LessonListActivity.class));
            finish();
        });
    }
}
