package org.xutils.view;

import android.app.Activity;
import android.view.View;

final class ViewFinder {
    private Activity activity;
    private View view;

    public ViewFinder(Activity activity) {
        this.activity = activity;
    }

    public ViewFinder(View view) {
        this.view = view;
    }

    public View findViewById(int i) {
        return this.view != null ? this.view.findViewById(i) : this.activity != null ? this.activity.findViewById(i) : null;
    }

    public View findViewById(int i, int i2) {
        View findViewById = i2 > 0 ? findViewById(i2) : null;
        return findViewById != null ? findViewById.findViewById(i) : findViewById(i);
    }

    public View findViewByInfo(ViewInfo viewInfo) {
        return findViewById(viewInfo.value, viewInfo.parentId);
    }
}
