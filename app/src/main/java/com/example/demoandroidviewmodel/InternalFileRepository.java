package com.example.demoandroidviewmodel;

import android.app.Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InternalFileRepository implements Repository
{

    private static final String NUMBER_FILE_NAME = "number";

    private File numberFile;

    public InternalFileRepository(Application application)
    {
        File appDir = application.getFilesDir();
        numberFile = new File(appDir, NUMBER_FILE_NAME);
    }

    public void storeNumber(int number)
        throws WriteException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numberFile)))
        {
            writer.write(number);
        }
        catch (IOException e)
        {
            throw new WriteException(e);
        }
    }

    public int loadNumber()
        throws ReadException, ReadBeforeWriteException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(numberFile)))
        {
            return reader.read();
        }
        catch (FileNotFoundException e)
        {
            throw new ReadBeforeWriteException();
        }
        catch (IOException e)
        {
            throw new ReadException(e);
        }
    }

}
