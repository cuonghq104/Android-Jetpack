package com.example.jetpack.livedata;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.jetpack.viewmodels.ResourceListener;

import java.util.Random;

public class ShareViewModel extends ViewModel {

    private static ShareViewModel sInstance;

    public static ShareViewModel getInstance(ViewModelStoreOwner owner) {
        if (sInstance == null) {
            sInstance = new ViewModelProvider(owner).get(ShareViewModel.class);
        }
        return sInstance;
    }

    MutableLiveData<ResourceListener<Integer>> mGeneratedNumber = new MutableLiveData<>();

    public ShareViewModel() {
        mGeneratedNumber.setValue(null);
    }

    public MutableLiveData<ResourceListener<Integer>> getGeneratedNumber() {
        return mGeneratedNumber;
    }

    public void generatedRandomNumber() {
        mGeneratedNumber.setValue(new ResourceListener<Integer>().loading("", null));
        new Handler().postDelayed(() -> {
            int number = (new Random().nextInt(Integer.MAX_VALUE) % 256);
            mGeneratedNumber.setValue(new ResourceListener<Integer>().success(number));
        }, 2000);
    }
}
