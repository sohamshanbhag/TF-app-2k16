package org.techfest.techfest2k16;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<PagerFragment> mFragmentList;
    private String[] titles;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<PagerFragment> fragment, String[] titles) {
        super(fm);
        this.mFragmentList = new ArrayList();
        this.mFragmentList = fragment;
        this.titles = titles;
    }

    public Fragment getItem(int position) {
        PagerFragment pagerFragment = (PagerFragment) this.mFragmentList.get(position);
        return PagerFragment.newInstance(this.titles[position]);
    }

    public int getCount() {
        return this.titles.length;
    }

    public CharSequence getPageTitle(int position) {
        return this.titles[position].toUpperCase();
    }
}
