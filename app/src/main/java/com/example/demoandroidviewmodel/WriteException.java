package com.example.demoandroidviewmodel;

public class WriteException extends GeneralException
{
    private Exception innerException;

    public WriteException(Exception e)
    {
        this.innerException = e;
    }

    public String getDescription()
    {
        return "Error on writing. Error details: [" + innerException.getMessage() + "]";
    }
}
