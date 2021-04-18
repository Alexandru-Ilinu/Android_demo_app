package com.example.demoandroidviewmodel;

public class ReadException extends GeneralException
{

    private Exception innerException;

    public ReadException(Exception innerException)
    {
        this.innerException = innerException;
    }

    public String getDescription()
    {
        return "An error occurred reading the number. \n" +
                "Error details: [" + innerException.getMessage() + "]";
    }

}
