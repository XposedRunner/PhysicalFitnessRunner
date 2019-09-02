package com.tencent.stat;

import android.app.Activity;

public class EasyActivity extends Activity {
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
