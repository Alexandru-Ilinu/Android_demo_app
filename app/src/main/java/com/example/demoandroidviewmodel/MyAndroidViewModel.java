package com.example.demoandroidviewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MyAndroidViewModel extends AndroidViewModel
{

    public MutableLiveData<Integer> counter;

    private Repository repository;

    public MyAndroidViewModel(Application application, int startValue)
    {
        super(application);
        counter = new MutableLiveData<>(startValue);
        repository = new InternalFileRepository(application);
    }

    public void increment()
    {
        Integer currentValue = counter.getValue();
        if (currentValue != null)
        {
            counter.setValue(counter.getValue() + 1);
        }
    }

    public void storeNumber()
            throws WriteException
    {
        repository.storeNumber(counter.getValue());
    }

    public void loadNumber()
        throws ReadException, ReadBeforeWriteException
    {
        int number = repository.loadNumber();
        counter.setValue(number);
    }

}
