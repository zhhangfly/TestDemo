package com.example.zb.testdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zb.testdemo.FirstPage.PlayPartFragment;
import com.example.zb.testdemo.ForthPage.MyPartFragment;
import com.example.zb.testdemo.SecondPage.LivePartFragment;
import com.example.zb.testdemo.ThirdPage.ShardPartFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager mviewPager;//加载展示内容
    public Toolbar toolbar;
    public ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toobar);
        toolbar.setTitle("乐活");//初始title
        toolbar.setSubtitle("快来玩啊~");//初始副title

        setSupportActionBar(toolbar);

    /*设置ViewPager用以加载布局*/
        mviewPager = (NoSlidingViewPaper) findViewById(R.id.content);
        final ArrayList<Fragment> fgLists = new ArrayList<>(4);
        fgLists.add(new PlayPartFragment());
        fgLists.add(new LivePartFragment());
        fgLists.add(new ShardPartFragment());
        fgLists.add(new MyPartFragment());
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fgLists.get(position);
            }

            @Override
            public int getCount() {
                return fgLists.size();
            }
        };
        mviewPager.setAdapter(mAdapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);//底部菜单栏的点击监听
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);//
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mviewPager.setCurrentItem(0);
                    toolbar.setTitle("乐活");
                    toolbar.setSubtitle("快来玩啊~");//乐活
                    return true;
                case R.id.navigation_dashboard:
                    mviewPager.setCurrentItem(1);
                    toolbar.setTitle("乐生");
                    toolbar.setSubtitle("人生在于努力");//乐做
                    return true;
                case R.id.navigation_notifications:
                    mviewPager.setCurrentItem(2);
                    toolbar.setTitle("乐享");
                    toolbar.setSubtitle("说出你的故事");//乐享
                    return true;
                case  R.id.navigation_myself:
                    mviewPager.setCurrentItem(3);
                    toolbar.setTitle("我的");
                    toolbar.setSubtitle("如此优秀的自己");//我的
                    return true;


            }
            return false;
        }

    };



}
