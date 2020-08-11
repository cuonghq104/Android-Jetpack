package com.example.jetpack.livedata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.jetpack.R;

public class MainActivity extends AppCompatActivity {

    private LeftFragment mLeftFragment;
    private RightFragment mRightFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }

    private void setupUI() {
        mLeftFragment = new LeftFragment();
        mRightFragment = new RightFragment();

        changeFragment(R.id.fl_left_container, mLeftFragment);
        changeFragment(R.id.fl_right_container, mRightFragment);
    }

    private void changeFragment(int fragmentId, @NonNull Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(fragmentId, fragment)
                .commit();
    }
}
