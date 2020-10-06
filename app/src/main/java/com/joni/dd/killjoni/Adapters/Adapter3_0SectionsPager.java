package com.joni.dd.killjoni.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.joni.dd.killjoni.Fragments.Fragment3_3Status;
import com.joni.dd.killjoni.Fragments.Fragment3_4Players;
import com.joni.dd.killjoni.Fragments.Fragment3_5Message;

/**
 * Created by dds86 on 16-Oct-17.
 */

public class Adapter3_0SectionsPager extends FragmentPagerAdapter {


    public Adapter3_0SectionsPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                Fragment3_3Status activityMenu3 = new Fragment3_3Status();
                return activityMenu3;
            case 1:
                Fragment3_4Players activityMenu4 = new Fragment3_4Players();
                return activityMenu4;
            case 2:
                Fragment3_5Message activityMenu5 = new Fragment3_5Message();
                return activityMenu5;



        }


        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Status";
            case 1:
                return "Players";
            case 2:
                return "Message";


        }
        return null;
    }
}
