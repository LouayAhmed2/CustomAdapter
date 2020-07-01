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
    private OnSpinnerItemClickListener onSpinnerItemClickListener;



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

    /**
     * Set the text alignment.
     *
     * @param textAlignment The text alignment to set. Should be one of
     *                      {@link #TEXT_ALIGNMENT_INHERIT},
     *                      {@link #TEXT_ALIGNMENT_GRAVITY},
     *                      {@link #TEXT_ALIGNMENT_CENTER},
     *                      {@link #TEXT_ALIGNMENT_TEXT_START},
     *                      {@link #TEXT_ALIGNMENT_TEXT_END},
     *                      {@link #TEXT_ALIGNMENT_VIEW_START},
     *                      {@link #TEXT_ALIGNMENT_VIEW_END}
     *                      Resolution will be done if the value is set to TEXT_ALIGNMENT_INHERIT. The resolution
     *                      proceeds up the parent chain of the view to get the value. If there is no parent, then it
     *                      will return the default {@link #TEXT_ALIGNMENT_GRAVITY}.
     * @attr ref android.R.styleable#View_textAlignment
     */
    @Override
    public void setTextAlignment(int textAlignment) {
        super.setTextAlignment(textAlignment);
    }


    /**
     * Set the background to a given resource. The resource should refer to
     * a Drawable object or 0 to remove the background.
     * @param resId The identifier of the resource.
     * @attr ref android.R.styleable#View_background
     */
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
        if (this.adapter == null)
            adapter = new CustomSpinnerAdapter(getContext(), data, this.onSpinnerItemClickListener);
        else
            adapter.changeData(data);
        setAdapter(adapter);
    }

    public void setOnSpinnerItemClickListener(OnSpinnerItemClickListener onSpinnerItemClickListener) {
        this.onSpinnerItemClickListener = onSpinnerItemClickListener;
        if (adapter != null)
            adapter.setOnSpinnerItemClickListener(onSpinnerItemClickListener);
    }


}
