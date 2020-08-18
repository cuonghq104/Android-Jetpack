package com.example.jetpack.navigations;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
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
public class ShuFragment extends Fragment {

    @BindView(R.id.btn_to_wu)
    AppCompatButton mBtnToWu;

    @BindView(R.id.btn_to_wei)
    AppCompatButton mBtnToWei;

    private NavController mNavController;

    public ShuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shu, container, false);
        ButterKnife.bind(this, view);
        initNavController();
        return view;
    }

    private void initNavController() {
        mNavController = NavHostFragment.findNavController(this);
    }


    @OnClick(R.id.btn_to_wu)
    void navigateToWu() {
        if (mNavController != null) {
            ShuFragmentDirections.ActionPlaceholderShuToWuFragment action = ShuFragmentDirections.actionPlaceholderShuToWuFragment();
            action.setStrategist("Liu Bei");
            mNavController.navigate(action);
        }
    }

    @OnClick(R.id.btn_to_wei)
    void navigateToWei() {
        if (mNavController != null) {
            NavDirections action = ShuFragmentDirections.actionPlaceholderShuToPlaceholderWei();
            mNavController.navigate(action);
        }
    }
}
