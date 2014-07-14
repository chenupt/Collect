package me.roy.collect.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by chenupt@gmail.com on 2014/7/14.
 * Description : TODO
 */
public class ScrollForeverTextView extends TextView {

    public ScrollForeverTextView(Context context) {
        super(context);
    }

    public ScrollForeverTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollForeverTextView(Context context, AttributeSet attrs,int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isFocused() {
        return true;
    }

}