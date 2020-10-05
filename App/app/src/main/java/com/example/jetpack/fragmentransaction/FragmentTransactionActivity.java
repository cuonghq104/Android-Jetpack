package com.example.jetpack.fragmentransaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.jetpack.R;
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentTransactionActivity extends AppCompatActivity {

    @BindView(R.id.fl_container)
    FrameLayout mFlContainer;

    @BindView(R.id.btn_change)
    AppCompatButton mBtnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transaction);
        ButterKnife.bind(this);
        changeFragment(new FragmentA(), "A");
    }

    private void changeFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment)
                .addToBackStack(tag)
                .commit();
    }

    @OnClick(R.id.btn_change)
    void changeFragmentB() {
        changeFragment(new FragmentB(), "B");
    }
}
