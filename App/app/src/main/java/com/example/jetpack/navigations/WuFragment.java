package com.example.jetpack.navigations;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpack.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class WuFragment extends Fragment {

    @BindView(R.id.btn_to_shu)
    AppCompatButton mBtnToShu;

    @BindView(R.id.btn_to_wei)
    AppCompatButton mBtnWei;

    @BindView(R.id.tv_strategist)
    AppCompatTextView mTvStrategist;

    private NavController mNavController;

    public WuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wu, container, false);
        ButterKnife.bind(this, view);
        initNavController();
        setupUI();
        return view;
    }

    private void setupUI() {
        getDataFromBundle();
    }

    private void getDataFromBundle() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            String strategist = WuFragmentArgs.fromBundle(getArguments()).getStrategist();
            mTvStrategist.setText(strategist);
        }
    }

    private void initNavController() {
        mNavController = NavHostFragment.findNavController(this);
    }

    @OnClick(R.id.btn_to_wei)
    void navigateToWei() {
        if (mNavController != null) {
            NavDirections action = WuFragmentDirections.actionWuFragmentToPlaceholderWei();
            mNavController.navigate(action);
        }
    }

    @OnClick(R.id.btn_to_shu)
    void navigateToShu() {
        if (mNavController != null) {
            NavDirections action = WuFragmentDirections.actionWuFragmentToPlaceholderShu();
            mNavController.navigate(action);
        }
    }
}
