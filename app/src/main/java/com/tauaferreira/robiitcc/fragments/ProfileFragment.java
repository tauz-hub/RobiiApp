package com.tauaferreira.robiitcc.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.tauaferreira.robiitcc.DAO.Usuario;
import com.tauaferreira.robiitcc.DAO.UsuarioDAO;
import com.tauaferreira.robiitcc.R;
import com.tauaferreira.robiitcc.Utils.Constantes;

public class ProfileFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String SECRET_PREFERENCE = Constantes.getSecretPreference();


    private String mParam1;
    private String mParam2;

    public ProfileFragment() {

    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        EditText etUsername = getActivity().findViewById(R.id.editText_profile_username);
        EditText etBirthday = getActivity().findViewById(R.id.editText_profile_birthday);
        EditText etName = getActivity().findViewById(R.id.editText_profile_name);
        TextView tvEmail = getActivity().findViewById(R.id.textView_profile_email);
        //EditText etLastname =getActivity().findViewById(R.id.editText_profile_lastname);
        TextView tvProgressbar = getActivity().findViewById(R.id.textView_profile_progress_bar);

        SharedPreferences prefs = getActivity().getSharedPreferences(SECRET_PREFERENCE , MODE_PRIVATE);
        String username = prefs.getString("usernameSave", null);

        Usuario user = UsuarioDAO.getUsuario(username);

        etUsername.setText( user.getUsername());
        etBirthday.setText(user.getBithdate());
        tvEmail.setText(user.getEmail());
        //etLastname.setText(user.getName());
        etName.setText(user.getName());
        tvProgressbar.setText("22%");
    }

}