package com.example.demoandroidviewmodel;

public class ReadBeforeWriteException extends GeneralException
{
    public String getDescription()
    {
        return "No number has been saved yet.";
    }
}
