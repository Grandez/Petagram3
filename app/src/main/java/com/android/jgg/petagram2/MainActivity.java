package com.android.jgg.petagram2;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.android.jgg.petagram2.adapter.PageAdapter;
import com.android.jgg.petagram2.adapter.TabsAdapter;
import com.android.jgg.petagram2.fragment.DetailFragment;
import com.android.jgg.petagram2.fragment.RecyclerviewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabsAdapter tabsAdapter;

    private ArrayList<Fragment> fragments;

    private int test = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)  findViewById(R.id.tool_bar);
        tabLayout = (TabLayout)  findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        setupViewPager();

        if (toolbar != null) setSupportActionBar(toolbar);

        getSupportActionBar().setIcon(R.drawable.huella);
    }

    public void cvMascota_onClick(View v) {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        TabLayout.Tab tab = tabLayout.getTabAt(1);
        tab.select();
    }

    private void setupViewPager() {
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(RecyclerviewFragment.newInstance());
        fragments.add(DetailFragment.newInstance());

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                test++;
                if (position > 0) DetailFragment.getInstance().update();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_detail);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch(item.getItemId()) {
            case R.id.mnuAbout:
                intent = new Intent(this, AboutActivity.class);
                break;
            case R.id.mnuContacto:
                intent = new Intent(this, ContactActivity.class);
                break;
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void incRating(View v) {

    }
    public void showRating(View v) {
        Intent intent = new Intent(this, RatingActivity.class);
        startActivity(intent);
    }
}
