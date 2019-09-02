package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.map.SwipeDismissTouchListener.DismissCallbacks;

class r implements DismissCallbacks {
    final /* synthetic */ SwipeDismissView a;

    r(SwipeDismissView swipeDismissView) {
        this.a = swipeDismissView;
    }

    public boolean canDismiss(Object obj) {
        return true;
    }

    public void onDismiss(View view, Object obj) {
        if (this.a.a != null) {
            this.a.a.onDismiss();
        }
    }

    public void onNotify() {
        if (this.a.a != null) {
            this.a.a.onNotify();
        }
    }
}
