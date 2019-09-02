package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.d.f.a;

public class DownloadActivity extends Activity {
    private static final String TAG = "DownloadActivity";

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            a.a(getApplicationContext(), getIntent());
        } catch (Throwable unused) {
        }
        finish();
    }

    /* Access modifiers changed, original: protected|final */
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            a.a(getApplicationContext(), intent);
        } catch (Throwable unused) {
        }
        finish();
    }

    /* Access modifiers changed, original: protected|final */
    public final void onRestart() {
        super.onRestart();
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        super.onResume();
    }

    /* Access modifiers changed, original: protected|final */
    public final void onStart() {
        super.onStart();
    }
}
