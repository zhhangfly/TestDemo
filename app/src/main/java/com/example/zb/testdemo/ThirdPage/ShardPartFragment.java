package com.example.zb.testdemo.ThirdPage;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.zb.testdemo.NoSlidingViewPaper;
import com.example.zb.testdemo.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShardPartFragment extends Fragment {
    private ViewPager thirdPager;


    public ShardPartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shard_part, container, false);
        thirdPager = (NoSlidingViewPaper) view.findViewById(R.id.thirdContent);
        final ArrayList<Fragment> thirdLists = new ArrayList<>(2);
        thirdLists.add(new ExsperienceFragment());
        thirdLists.add(new HealthFragment());
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return thirdLists.get(position);
            }

            @Override
            public int getCount() {
                return thirdLists.size();
            }
        };
        thirdPager.setAdapter(mAdapter);
        BottomNavigationView navigationView = (BottomNavigationView) view.findViewById(R.id.thirdButton);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        return view;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_experience:
                    thirdPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_health:
                    thirdPager.setCurrentItem(1);
                    return true;
            }
            return false;
        }

    };
}
