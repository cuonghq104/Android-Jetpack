package com.example.jetpack.fragmentadapter;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

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
public class FragmentStateDemo extends Fragment {

    @BindView(R.id.cl_container)
    ConstraintLayout mClContainer;

    @BindView(R.id.btn_change)
    AppCompatButton mBtnChange;

    int[] backgroundColor = new int[]{R.color.colorAmber, R.color.colorBlue, R.color.colorCyan, R.color.colorGreen, R.color.colorIndigo, R.color.colorLightBlue, R.color.colorRed};
    private int currentColor = 0;

    public FragmentStateDemo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_state_demo, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick(R.id.btn_change)
    void changeBackgroundColor() {
        currentColor = (currentColor + 1) % backgroundColor.length;
        mClContainer.setBackgroundColor(ContextCompat.getColor(getContext(), backgroundColor[currentColor]));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
