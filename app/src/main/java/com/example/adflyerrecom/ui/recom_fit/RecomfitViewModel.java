package com.example.adflyerrecom.ui.recom_fit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecomfitViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecomfitViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}