package com.fathanpklkt.myapplication;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {



    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1,R.string.tab_text_2};
    private final Context mContext;
    private ListMoviesFragment moviesFragment;
    private ListTvShowFragment tvShowFragment;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        moviesFragment = new ListMoviesFragment();
        tvShowFragment = new ListTvShowFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ListMoviesFragment();
            case 1:
                return new ListTvShowFragment();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);

    }

    @Override
    public int getCount() {
        return 2;
    }
}
