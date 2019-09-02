package com.tencent.stat;

import android.app.ListActivity;

public class EasyListActivity extends ListActivity {
    /* Access modifiers changed, original: protected */
    public void onPause() {
        super.onPause();
        StatService.onPause(this);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
        StatService.onResume(this);
    }
}
