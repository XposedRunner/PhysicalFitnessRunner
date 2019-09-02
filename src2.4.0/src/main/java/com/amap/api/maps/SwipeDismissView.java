package com.amap.api.maps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.WearMapView.OnDismissCallback;

@SuppressLint({"ViewConstructor"})
public class SwipeDismissView extends RelativeLayout {
    protected OnDismissCallback onDismissCallback = null;

    public SwipeDismissView(Context context, AttributeSet attributeSet, int i, View view) {
        super(context, attributeSet, i);
        setOnTouchListener(view);
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, View view) {
        super(context, attributeSet);
        setOnTouchListener(view);
    }

    public SwipeDismissView(Context context, View view) {
        super(context);
        setOnTouchListener(view);
    }

    public void setCallback(OnDismissCallback onDismissCallback) {
        this.onDismissCallback = onDismissCallback;
    }

    /* Access modifiers changed, original: protected */
    public void setOnTouchListener(View view) {
        setOnTouchListener(new SwipeDismissTouchListener(view, new Object(), new SwipeDismissCallBack(this)));
    }
}
