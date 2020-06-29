package com.example.customspinnertask;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatSpinner;

public class CustomSpinner extends AppCompatSpinner {
    int textAlignment;
    private int backgroundColor;

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
            textAlignment = a.getInt(R.styleable.CustomSpinner_textAlignment, Gravity.NO_GRAVITY);
            setBackgroundColor(backgroundColor);
            setTextAlignment(textAlignment);
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


}
