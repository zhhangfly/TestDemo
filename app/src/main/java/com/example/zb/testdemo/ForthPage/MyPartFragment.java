package com.example.zb.testdemo.ForthPage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zb.testdemo.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPartFragment extends Fragment {
    CircleImageView headImageView;
    TextView nickName;
    TextView selfSummary;


    public MyPartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_part, container, false);
        nickName = (TextView) view.findViewById(R.id.nickName);
        selfSummary = (TextView)view.findViewById(R.id.selfSummary);
        headImageView = (CircleImageView)view.findViewById(R.id.forthHeadImage);
        headImageView.setImageResource(R.drawable.ic_3);
        nickName.setText("我是雷雷你是谁");
        selfSummary.setText("我是垃圾");









        return view;
    }

}
