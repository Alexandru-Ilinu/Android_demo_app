package com.example.demoandroidviewmodel;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyAndroidViewModelFactory extends ViewModelProvider.AndroidViewModelFactory
{

    private int startValue;
    private Application application;

    public MyAndroidViewModelFactory(Application application, int startValue)
    {
        super(application);
        this.application = application;
        this.startValue = startValue;
    }

    public <T extends ViewModel> T create(Class<T> modelClass)
    {
        return (T) new MyAndroidViewModel(application, startValue);
    }

}
