package cn.jpush.android.api;

import android.app.Activity;

public class InstrumentedActivity extends Activity {
    /* Access modifiers changed, original: protected */
    public void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
