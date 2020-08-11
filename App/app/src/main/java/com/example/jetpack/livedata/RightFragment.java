package com.example.jetpack.livedata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.jetpack.R;
import com.example.jetpack.viewmodels.ViewModelStatus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RightFragment extends Fragment {

    private ShareViewModel mViewModel;

    @BindView(R.id.pb_generate)
    ProgressBar mPbGenerate;

    @BindView(R.id.tv_generate_number)
    AppCompatTextView mTvGenerateNumber;

    public RightFragment() {
        // Required empty public constructor
    }

    private int mValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        ButterKnife.bind(this, view);
        mPbGenerate.setVisibility(View.INVISIBLE);
        mViewModel = ShareViewModel.getInstance(this);
        addViewModelListener();
        return view;
    }

    private void addViewModelListener() {
        mViewModel.getGeneratedNumber()
                .observe(getViewLifecycleOwner(), v -> {
                    if (v != null) {
                        if (v.getStatus() == ViewModelStatus.LOADING) {
                            mPbGenerate.setVisibility(View.VISIBLE);
                        } else if (v.getStatus() == ViewModelStatus.SUCCESS) {
                            mTvGenerateNumber.setText(v.getData() + "");
                            mPbGenerate.setVisibility(View.INVISIBLE);
                        }
                    }
                });
    }

    @OnClick(R.id.btn_generate)
    void generateNumber() {
        if (mViewModel != null) {
            mViewModel.generatedRandomNumber();
        }
    }
}
