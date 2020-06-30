package com.example.customspinnertask;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatSpinner;

import java.util.List;

public class CustomSpinner extends AppCompatSpinner {
    private int TextAlignment;
    private int backgroundColor;
    private List<IDisplay> data;
    private CustomSpinnerAdapter adapter;


    public CustomSpinner(Context context) {
        super(context);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    private void init(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().
                obtainStyledAttributes(attrs, R.styleable.CustomSpinner, 0, 0);
        try {
            backgroundColor = a.getColor(R.styleable.CustomSpinner_backgroundcolor, Color.WHITE);
            TextAlignment = a.getInt(R.styleable.CustomSpinner_textAlignment, Gravity.NO_GRAVITY);
            setBackgroundColor(backgroundColor);
            setTextAlignment(TextAlignment);
        } finally {

            a.recycle();

        }


    }


    @Override
    public void setTextAlignment(int textAlignment) {
        super.setTextAlignment(textAlignment);
    }

    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
    }

    public void setCustomAdapter(CustomSpinnerAdapter adapter) {
        this.adapter = adapter;
        setAdapter(adapter);
    }

    public void setData(List<IDisplay> data) {
        this.data = data;
        if (this.adapter == null) {
            adapter = new CustomSpinnerAdapter(getContext(), data);
        } else
            adapter.changeData(data);
        setAdapter(adapter);
    }

}
