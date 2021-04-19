package com.example.demoandroidviewmodel;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferencesRepository implements Repository
{

    private static final String NUMBER_KEY = "number";
    private SharedPreferences prefs;

    public SharedPreferencesRepository(Application application)
    {
        prefs = PreferenceManager.getDefaultSharedPreferences(application);
    }

    public void storeNumber(int number)
        throws WriteException
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(NUMBER_KEY, number);
        editor.apply();
    }

    public int loadNumber()
        throws ReadException, ReadBeforeWriteException
    {
        int defaultValue = -1;
        int number = prefs.getInt(NUMBER_KEY, defaultValue);
        if (number == defaultValue)
        {
            throw new ReadBeforeWriteException();
        }
        return number;
    }

}
