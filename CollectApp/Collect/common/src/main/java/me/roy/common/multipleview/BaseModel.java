package me.roy.common.multipleview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

/**
 * Created by chenupt@gmail.com on 2014/8/8.
 * Description TODO
 */
public abstract class BaseModel extends FrameLayout {
    public static final String TAG = "MonthViewAdapter";

    protected Context context;
    protected Object model;
    protected Object modelList;
    protected int position;

    public BaseModel(Context context){
        this(context, null);
    }

    public BaseModel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    public abstract void bindView();
    public void setModel(Object model, Object modelList){
        this.model = model;
        this.modelList = modelList;
        bindView();
        Log.d(TAG, "setModel");
    };

    public void setViewPosition(int position){
        this.position = position;
    }


}
