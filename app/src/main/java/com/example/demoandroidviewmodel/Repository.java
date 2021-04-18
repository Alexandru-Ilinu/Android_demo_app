package com.example.demoandroidviewmodel;

public interface Repository
{

    void storeNumber(int number) throws WriteException;

    int loadNumber() throws ReadException, ReadBeforeWriteException;

}
