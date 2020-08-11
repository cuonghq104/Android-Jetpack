package com.example.jetpack.livedata;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpack.R;
import com.example.jetpack.viewmodels.ViewModelStatus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {

    @BindView(R.id.tv_hex)
    AppCompatTextView mTvHex;

    private ShareViewModel mViewModel;

    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        ButterKnife.bind(this, view);
        mViewModel = ShareViewModel.getInstance(this);
        addLiveDataListener();
        return view;
    }

    private void addLiveDataListener() {
        mTvHex.setOnClickListener(v -> {
            mViewModel.generatedRandomNumber();
        });
        mViewModel.getGeneratedNumber()
                .observe(getViewLifecycleOwner(), v -> {
                    if (v != null) {
                        if (v.getStatus() == ViewModelStatus.LOADING) {
                            mTvHex.setText("Loading...");
                        } else if (v.getStatus() == ViewModelStatus.SUCCESS) {
                            mTvHex.setText(Integer.toBinaryString(v.getData()));
                        }
                    }
                });
    }

}
