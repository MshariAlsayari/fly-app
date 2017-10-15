package com.example.msharialsayari.flyapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.msharialsayari.flyapp.Adapters.SectionPageAdapter;
import com.example.msharialsayari.flyapp.Tabs.FlyTab;




public class MainActivity extends AppCompatActivity {


    private SectionPageAdapter sectionPageAdapter;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(FlyTab.newInstance("A"), getString(R.string.arrival));
        adapter.addFragment(FlyTab.newInstance("D"), getString(R.string.departure));
        viewPager.setAdapter(adapter);

    }





}
