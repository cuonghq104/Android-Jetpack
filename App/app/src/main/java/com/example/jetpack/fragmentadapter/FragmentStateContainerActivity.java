package com.example.jetpack.fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.content.Intent;
import android.os.Bundle;

import com.example.jetpack.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentStateContainerActivity extends AppCompatActivity {

    @BindView(R.id.btn_fragment_pager)
    AppCompatButton mBtnFragmentPager;

    @BindView(R.id.btn_fragment_state_pager)
    AppCompatButton mBtnFragmentStatePager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_state_container);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_fragment_pager)
    public void goToFragmentPagerActivity() {
        Intent intent = new Intent(FragmentStateContainerActivity.this, FragmentPagerActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_fragment_state_pager)
    public void goToFragmentStatePagerActivity() {
        Intent intent = new Intent(FragmentStateContainerActivity.this, FragmentPagerStateActivity.class);
        startActivity(intent);
    }
}
