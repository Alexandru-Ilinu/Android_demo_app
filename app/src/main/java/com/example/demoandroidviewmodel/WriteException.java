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
        return "Eroare la scriere. Detalii eroare: [" + innerException.getMessage() + "]";
    }
}
