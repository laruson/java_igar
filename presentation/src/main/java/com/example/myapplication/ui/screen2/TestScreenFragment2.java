package com.example.myapplication.ui.screen2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

public class TestScreenFragment2 extends Fragment {
    private static TestScreenFragment2 instance;
    private View view;

    public static TestScreenFragment2 newInstance() {
        if (instance == null)
            instance = new TestScreenFragment2();
        return instance;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_blank2, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView = view.findViewById(R.id.text2);
        textView.setText("pidor");
    }

}
