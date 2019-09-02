package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.widget.Checkable;

class CheckableWrapperView extends WrapperView implements Checkable {
    public CheckableWrapperView(Context context) {
    }

    public boolean isChecked() {
        return false;
    }

    public void setChecked(boolean z) {
    }

    public void toggle() {
    }
}
