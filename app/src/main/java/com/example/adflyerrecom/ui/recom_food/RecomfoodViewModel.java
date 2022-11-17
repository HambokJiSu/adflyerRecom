package com.example.adflyerrecom.ui.recom_food;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecomfoodViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecomfoodViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}