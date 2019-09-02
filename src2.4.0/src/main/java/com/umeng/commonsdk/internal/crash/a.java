package com.umeng.commonsdk.internal.crash;

import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: UMCrashUtils */
public class a {
    public static String a(Throwable th) {
        if (th == null) {
            return null;
        }
        String obj;
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (th = th.getCause(); th != null; th = th.getCause()) {
                th.printStackTrace(printWriter);
            }
            obj = stringWriter.toString();
            try {
                printWriter.close();
                stringWriter.close();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            obj = null;
        }
        return obj;
    }
}
