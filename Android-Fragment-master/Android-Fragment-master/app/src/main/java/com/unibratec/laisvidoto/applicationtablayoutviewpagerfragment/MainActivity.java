package com.unibratec.laisvidoto.applicationtablayoutviewpagerfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adapters.MyAdapterPagerAdapter;

public class MainActivity extends AppCompatActivity
{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout)findViewById(R.id.TabLayout);
        mViewPager = (ViewPager)findViewById(R.id.ViewPager);

        mViewPager.setAdapter( new MyAdapterPagerAdapter(
                getSupportFragmentManager(),getResources().getStringArray( R.array.titles_tab )
                                                        )
        );

        mTabLayout.setupWithViewPager(mViewPager);



    }
}
