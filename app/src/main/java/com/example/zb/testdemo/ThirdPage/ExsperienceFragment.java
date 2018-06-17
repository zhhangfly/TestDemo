package com.example.zb.testdemo.ThirdPage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zb.testdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExsperienceFragment extends Fragment {


    public ExsperienceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exsperience, container, false);
    }

}
