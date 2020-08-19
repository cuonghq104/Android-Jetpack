package com.example.jetpack.fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.jetpack.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class FragmentPagerStateActivity extends AppCompatActivity {

    @BindView(R.id.vp_container)
    ViewPager mVpContainer;

    PagerStateAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager_state);
        ButterKnife.bind(this);
        mAdapter = new PagerStateAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        mVpContainer.setAdapter(mAdapter);
        mVpContainer.setOffscreenPageLimit(3);
    }
}
