package com.android.jgg.petagram3.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.jgg.petagram3.interfaces.Updatable;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;

    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        if (object instanceof Updatable) {
            ((Updatable) object).update();
        }
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
