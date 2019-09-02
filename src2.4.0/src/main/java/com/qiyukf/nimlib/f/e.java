package com.qiyukf.nimlib.f;

import android.os.Build.VERSION;
import android.os.TransactionTooLargeException;

public final class e {
    public static boolean a(Exception exception) {
        if (!(VERSION.SDK_INT >= 15 ? exception instanceof TransactionTooLargeException : false)) {
            return false;
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
