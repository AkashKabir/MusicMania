package com.akitsme.retrofit.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akitsme.retrofit.R;

/**
 * Created by AKASH on 08-03-2017.
 */

public class FragementA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment,container,false);
        return v;
    }
}
