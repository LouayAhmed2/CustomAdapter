package com.example.customspinnertask;

import android.os.Bundle;
import android.widget.Toast;

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
        customSpinner.setOnSpinnerItemClickListener(new OnSpinnerItemClickListener() {
            @Override
            public void onItemSelected(IDisplay item, int position) {
                Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public List<IDisplay> getTestData() {
        List<IDisplay> data = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            data.add(new User("userNum " + i));

        return data;
    }
}
