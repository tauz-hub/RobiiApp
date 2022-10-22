package com.tauaferreira.robiitcc.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tauaferreira.robiitcc.R;
import com.tauaferreira.robiitcc.UI.LevelOne.OneActivity;
import com.tauaferreira.robiitcc.UI.MainActivity;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        ImageView level1 = getActivity().findViewById(R.id.level_1);
        ImageView level2 = getActivity().findViewById(R.id.level_2);
        ImageView level3 = getActivity().findViewById(R.id.level_3);
        ImageView level4= getActivity().findViewById(R.id.level_4);
        ImageView level5 = getActivity().findViewById(R.id.level_5);
        ImageView level6 = getActivity().findViewById(R.id.level_6);
        ImageView level7 = getActivity().findViewById(R.id.level_7);
        ImageView level8 = getActivity().findViewById(R.id.level_8);

        level1.setOnClickListener (v -> {
            startActivity(new Intent(getContext(), OneActivity.class));
        });
        level2.setOnClickListener (v -> {
            startActivity(new Intent(getContext(), MainActivity.class));
        });
    }
}