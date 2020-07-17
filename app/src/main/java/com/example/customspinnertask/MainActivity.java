package com.example.customspinnertask;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.customspinnertask.SetData.getTestData;

public class MainActivity extends AppCompatActivity {
    CustomSpinner customSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customSpinner = findViewById(R.id.spinner);

        Observable<IDisplay> observable= Observable
                .fromIterable(getTestData())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer<IDisplay>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(IDisplay iDisplay) {
                List<IDisplay> data = getTestData();
                customSpinner.setData(data);
                customSpinner.setOnSpinnerItemClickListener(new OnSpinnerItemClickListener() {
                    @Override
                    public void onItemSelected(IDisplay item, int position) {
                        Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        customSpinner.setBackgroundResource(android.R.color.holo_green_dark);
        customSpinner.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

    }

//    public List<IDisplay> getTestData() {
//        List<IDisplay> data = new ArrayList<>();
//        for (int i = 0; i < 5; i++)
//            data.add(new User("userNum " + i));
//
//        return data;
//    }
}
