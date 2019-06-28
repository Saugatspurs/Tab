package com.example.tab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TabLayout tb;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.tb1);
        vp=findViewById(R.id.vp);

        MyAdapter adapter=new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tb));
        tb.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(vp));
    }
    public static class MyAdapter extends FragmentPagerAdapter{
        int no_of_tabs=3;
        public MyAdapter(FragmentManager fm){
            super(fm);

        }
        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0: return new Green_Fragment();
                case 1: return new Orange_Fragment();
                case 2: return new Blue_Fragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return no_of_tabs;
        }
    }
}
