package com.example.demoandroidviewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModelFactory implements ViewModelProvider.Factory
{
    private int startValue;

    public MyViewModelFactory(int startValue)
    {
        this.startValue = startValue;
    }

    public <T extends ViewModel> T create(Class<T> modelClass)
    {
        //return (T) new MyViewModel(startValue);
        return (T) new MyViewModel();
    }

}
