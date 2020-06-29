package com.example.customspinnertask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CustomSpinner customSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customSpinner = findViewById(R.id.spinner);
        List<IDisplay> data = getTestData();
        customSpinner.setData(data);


    }

    public List<IDisplay> getTestData() {
        List<IDisplay> data = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            data.add(new User("userNum " + i));

        return data;
    }
}
