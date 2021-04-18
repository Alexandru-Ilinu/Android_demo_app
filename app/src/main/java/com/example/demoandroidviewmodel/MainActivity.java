package com.example.demoandroidviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private TextView counterTxt;
    private MyAndroidViewModel viewModel;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTxt = findViewById(R.id.counter);

        Application application = getApplication();

        MyAndroidViewModelFactory factory = new MyAndroidViewModelFactory(application, 6);
        viewModel = new ViewModelProvider(this, factory)
                .get(MyAndroidViewModel.class);

        viewModel.counter.observe(this, new Observer<Integer>()
        {
            public void onChanged(Integer counter)
            {
                counterTxt.setText(counter.toString());
            }
        });
    }

    public void increment(View view)
    {
        viewModel.increment();
    }

    public void store(View view)
    {
        try
        {
            viewModel.storeNumber();
        }
        catch (WriteException e)
        {
            print(e.getDescription());
        }
    }

    public void load(View view)
    {
        try
        {
            viewModel.loadNumber();
        }
        catch (ReadException | ReadBeforeWriteException e)
        {
            print(e.getDescription());
        }
    }

    private void print(String text)
    {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}