package com.android.jgg.petagram3.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.jgg.petagram3.fragment.DetailFragment;
import com.android.jgg.petagram3.fragment.RecyclerviewFragment;
import com.android.jgg.petagram3.interfaces.Updatable;

public class TabsAdapter extends FragmentStatePagerAdapter {

    public static final int TOTAL_TABS = 2;
    public String mGeneralString;
    public Context mContext;

    public TabsAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RecyclerviewFragment().newInstance();

            case 1:
                return new DetailFragment().newInstance();
        }
        return null;
    }
/*
    //received from ManagerFragment
    public void update(String string) {
        mGeneralString = string;
        //updated
        notifyDataSetChanged();
    }
*/
    @Override
    public int getItemPosition(Object object) {
        if (object instanceof Updatable) {
            ((Updatable) object).update();
        }
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return TOTAL_TABS;
    }
/*
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.fragment_first_title);
            case 1:
                return mContext.getString(R.string.fragment_second_title);
            default:
                return mContext.getString(R.string.fragment_first_title);
        }
    }
    */
}
