package com.example.jetpack.fragmentadapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerStateAdapter extends FragmentStatePagerAdapter {

    public PagerStateAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new FragmentStateDemo();
    }

    @Override
    public int getCount() {
        return 5;
    }
}
