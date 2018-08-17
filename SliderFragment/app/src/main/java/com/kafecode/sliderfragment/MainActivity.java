package com.kafecode.sliderfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SingleFragmentPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        fragmentList.add(SingleFragment.newInstance("Hola"));
        fragmentList.add(SingleFragment.newInstance("Hola 1"));
        fragmentList.add(SingleFragment.newInstance("Hola 22"));
        fragmentList.add(SingleFragment.newInstance("Hola 333"));
        fragmentList.add(SingleFragment.newInstance("Hola 4444"));

        adapter = new SingleFragmentPageAdapter(getSupportFragmentManager(), fragmentList);

        ViewPager pager = (ViewPager)findViewById(R.id.pager);

        pager.setAdapter(adapter);

    }

    private class SingleFragmentPageAdapter extends FragmentPagerAdapter{

        private List<Fragment> fragments;

        public SingleFragmentPageAdapter(FragmentManager manager, List<Fragment> fragments){
            super(manager);

            this.fragments = fragments;


        }

        @Override
        public Fragment getItem(int i) {
            return this.fragments.get(i);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}
