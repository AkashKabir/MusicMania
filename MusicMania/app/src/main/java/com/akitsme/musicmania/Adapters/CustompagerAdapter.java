package com.akitsme.musicmania.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.akitsme.musicmania.Fragments.Artist_fragment;
import com.akitsme.musicmania.Fragments.Mainpage_fragment;
import com.akitsme.musicmania.Fragments.SecondPage_Fragment;

/**
 * Created by AKASH on 18-02-2017.
 */

public class CustompagerAdapter extends FragmentPagerAdapter {

    public String name[]={"Top Songs","Artists","Albums","Live","Events","About"};
    public CustompagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new Mainpage_fragment();
            case 1: return new Artist_fragment();
            case 2: return new Mainpage_fragment();
            case 3: return new Mainpage_fragment();
            case 4: return new Mainpage_fragment();
            case 5: return new Mainpage_fragment();
            default: return null;

        }
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return name[position];
    }
}
