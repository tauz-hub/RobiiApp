package com.tauaferreira.robiitcc.fragments;

import static android.content.Context.MODE_PRIVATE;

import static com.tauaferreira.robiitcc.Utils.Constants.SECRET_PREFERENCE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tauaferreira.robiitcc.DAO.UsuarioDAO;
import com.tauaferreira.robiitcc.R;
import com.tauaferreira.robiitcc.UI.LevelFive.LevelMainFive;
import com.tauaferreira.robiitcc.UI.LevelFour.LevelMainFour;
import com.tauaferreira.robiitcc.UI.LevelOne.LevelMainOne;
import com.tauaferreira.robiitcc.UI.LevelSix.LevelMainSix;
import com.tauaferreira.robiitcc.UI.LevelThree.LevelMainThree;
import com.tauaferreira.robiitcc.UI.LevelTwo.LevelMainTwo;

public class HomeFragment extends Fragment {


    public HomeFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onStart() {
        super.onStart();
        ImageView level1 = getActivity().findViewById(R.id.level_1);

        ImageView level2 = getActivity().findViewById(R.id.level_2);


        SharedPreferences prefs = getActivity().getSharedPreferences(SECRET_PREFERENCE, MODE_PRIVATE);
        String username = prefs.getString("usernameSave", null);
        String level = UsuarioDAO.getLevelUser(username);


        if (level.equals("1")) {
            System.out.println(level);
            Drawable drawable = getResources().getDrawable(R.drawable.main_blue_ellipse);
            level1.setImageDrawable(drawable);


            TextView progressBar = getActivity().findViewById(R.id.progress_percentage);
            Integer percent = Integer.parseInt(level) * 100 / 8;

            progressBar.setText(percent + "%");
        }

        if (level.equals("2")) {
            System.out.println(level);
            Drawable drawable = getResources().getDrawable(R.drawable.main_blue_ellipse);
            level1.setImageDrawable(drawable);
            level2.setImageDrawable(drawable);


            TextView progressBar = getActivity().findViewById(R.id.progress_percentage);
            Integer percent = Integer.parseInt(level) * 100 / 8;

            progressBar.setText(percent + "%");
        }



        ImageView level3 = getActivity().findViewById(R.id.level_3);
        ImageView level4 = getActivity().findViewById(R.id.level_4);
        ImageView level5 = getActivity().findViewById(R.id.level_5);
        ImageView level6 = getActivity().findViewById(R.id.level_6);
        ImageView level7 = getActivity().findViewById(R.id.level_7);
        ImageView level8 = getActivity().findViewById(R.id.level_8);

        level1.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), LevelMainOne.class));
        });
        level2.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), LevelMainTwo.class));
        });
        level3.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), LevelMainThree.class));
        });
        level4.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), LevelMainFour.class));
        });
        level5.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), LevelMainFive.class));
        });
        level6.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), LevelMainSix.class));
        });

    }
}