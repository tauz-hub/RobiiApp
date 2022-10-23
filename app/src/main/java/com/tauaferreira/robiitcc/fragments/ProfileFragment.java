package com.tauaferreira.robiitcc.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tauaferreira.robiitcc.DAO.Usuario;
import com.tauaferreira.robiitcc.DAO.UsuarioDAO;
import com.tauaferreira.robiitcc.R;
import com.tauaferreira.robiitcc.UI.LessonListActivity;
import com.tauaferreira.robiitcc.UI.SplashActivity;
import com.tauaferreira.robiitcc.Utils.Constants;

public class ProfileFragment extends Fragment {

    public static final String SECRET_PREFERENCE = Constants.getSecretPreference();


    public ProfileFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        ImageView logoOff = getActivity().findViewById(R.id.logoff);

        logoOff.setOnClickListener(v -> {
            SharedPreferences.Editor editor = getActivity().getSharedPreferences(SECRET_PREFERENCE, MODE_PRIVATE).edit();

            editor.putString("usernameSave", "");
            editor.putString("passwordSave", "");
            editor.apply();
            startActivity(new Intent(getActivity(), SplashActivity.class));


            getActivity().finish();
        });


        EditText etUsername = getActivity().findViewById(R.id.editText_profile_username);
        EditText etBirthday = getActivity().findViewById(R.id.editText_profile_birthday);
        EditText etName = getActivity().findViewById(R.id.editText_profile_name);
        TextView tvEmail = getActivity().findViewById(R.id.textView_profile_email);
        TextView tvProgressbar = getActivity().findViewById(R.id.textView_profile_progress_bar);

        SharedPreferences prefs = getActivity().getSharedPreferences(SECRET_PREFERENCE, MODE_PRIVATE);
        String username = prefs.getString("usernameSave", null);

        Usuario user = UsuarioDAO.getUsuario(username);

        etUsername.setText(user.getUsername());
        etBirthday.setText(user.getBithdate());
        tvEmail.setText(user.getEmail());
        etName.setText(user.getName());


        String level = UsuarioDAO.getLevelUser(username);


        Integer percent = Integer.parseInt(level) * 100 / 8;
        tvProgressbar.setText(percent + "%");

    }

}