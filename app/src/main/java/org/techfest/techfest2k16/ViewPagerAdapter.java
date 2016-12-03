package org.techfest.techfest2k16;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by soham_shanbhag on 10/10/16.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<PagerFragment> mFragmentList = new ArrayList<PagerFragment>();
    private String[] titles;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<PagerFragment> fragment, String[] titles) {
        super(fm);
        mFragmentList = fragment;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position).newInstance(titles[position]);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position].toUpperCase();
    }
}