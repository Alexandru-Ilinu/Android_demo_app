package com.example.demoandroidviewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel
{

    public MutableLiveData<Integer> counter;

    public MyViewModel()
    {
        counter = new MutableLiveData<>();
        counter.setValue(0);
    }

    public void increment()
    {
        counter.setValue(counter.getValue() + 1);
    }
}
