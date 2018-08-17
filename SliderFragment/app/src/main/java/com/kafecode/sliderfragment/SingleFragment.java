package com.kafecode.sliderfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SingleFragment extends Fragment {

    public static final String MESSAGE = "";

    public static SingleFragment newInstance(String message){
        SingleFragment fragment = new SingleFragment();

        Bundle bundle = new Bundle(1);

        bundle.putString(MESSAGE, message);

        fragment.setArguments(bundle);

        return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String message = getArguments().getString(MESSAGE);

        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        TextView textView = (TextView)view.findViewById(R.id.textView);

        textView.setText(message);

        return view;

    }
}
