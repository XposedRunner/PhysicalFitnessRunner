package com.tencent.open.web.security;

import com.tencent.open.a.b;
import com.tencent.open.a.f;

/* compiled from: ProGuard */
public class SecureJsInterface extends b {
    public static boolean isPWDEdit;
    private String a;

    public void clearAllEdit() {
        f.c("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-->clear all edit exception: ");
            stringBuilder.append(e.getMessage());
            f.e("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
            throw new RuntimeException(e);
        }
    }

    public void curPosFromJS(String str) {
        int parseInt;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->curPosFromJS: ");
        stringBuilder.append(str);
        f.b("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
        try {
            parseInt = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            f.b("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e);
            parseInt = -1;
        }
        if (parseInt < 0) {
            throw new RuntimeException("position is illegal.");
        }
        boolean z = a.c;
        if (!a.b) {
            this.a = a.a;
            JniInterface.insetTextToArray(parseInt, this.a, this.a.length());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("curPosFromJS mKey: ");
            stringBuilder2.append(this.a);
            f.a("openSDK_LOG.SecureJsInterface", stringBuilder2.toString());
        } else if (Boolean.valueOf(JniInterface.BackSpaceChar(a.b, parseInt)).booleanValue()) {
            a.b = false;
        }
    }

    public boolean customCallback() {
        return true;
    }

    public String getMD5FromNative() {
        f.c("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        StringBuilder stringBuilder;
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            stringBuilder = new StringBuilder();
            stringBuilder.append("-->getMD5FromNative, MD5= ");
            stringBuilder.append(pWDKeyToMD5);
            f.a("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
            return pWDKeyToMD5;
        } catch (Exception e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("-->get md5 form native exception: ");
            stringBuilder.append(e.getMessage());
            f.e("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
            throw new RuntimeException(e);
        }
    }

    public void isPasswordEdit(String str) {
        int parseInt;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->is pswd edit, flag: ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
        try {
            parseInt = Integer.parseInt(str);
        } catch (Exception e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("-->is pswd edit exception: ");
            stringBuilder.append(e.getMessage());
            f.e("openSDK_LOG.SecureJsInterface", stringBuilder.toString());
            parseInt = -1;
        }
        if (parseInt != 0 && parseInt != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        } else if (parseInt == 0) {
            isPWDEdit = false;
        } else if (parseInt == 1) {
            isPWDEdit = true;
        }
    }
}
