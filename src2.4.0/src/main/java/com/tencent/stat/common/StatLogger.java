package com.tencent.stat.common;

import android.util.Log;

public final class StatLogger {
    private String a = "default";
    private boolean b = true;
    private int c = 2;

    public StatLogger(String str) {
        this.a = str;
    }

    private String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.isNativeMethod() || stackTraceElement.getClassName().equals(Thread.class.getName()) || stackTraceElement.getClassName().equals(getClass().getName())) {
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[");
                stringBuilder.append(Thread.currentThread().getName());
                stringBuilder.append("(");
                stringBuilder.append(Thread.currentThread().getId());
                stringBuilder.append("): ");
                stringBuilder.append(stackTraceElement.getFileName());
                stringBuilder.append(":");
                stringBuilder.append(stackTraceElement.getLineNumber());
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        }
        return null;
    }

    public void d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }

    public void debug(Object obj) {
        if (this.c <= 3) {
            String obj2;
            String a = a();
            if (a == null) {
                obj2 = obj.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" - ");
                stringBuilder.append(obj);
                obj2 = stringBuilder.toString();
            }
            Log.d(this.a, obj2);
        }
    }

    public void e(Exception exception) {
        if (isDebugEnable()) {
            error(exception);
        }
    }

    public void e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    public void error(Exception exception) {
        if (this.c <= 6) {
            String stringBuilder;
            StringBuffer stringBuffer = new StringBuffer();
            String a = a();
            StackTraceElement[] stackTrace = exception.getStackTrace();
            if (a != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a);
                stringBuilder2.append(" - ");
                stringBuilder2.append(exception);
                stringBuilder2.append("\r\n");
                stringBuilder = stringBuilder2.toString();
            } else {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(exception);
                stringBuilder3.append("\r\n");
                stringBuilder = stringBuilder3.toString();
            }
            stringBuffer.append(stringBuilder);
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("[ ");
                        stringBuilder4.append(stackTraceElement.getFileName());
                        stringBuilder4.append(":");
                        stringBuilder4.append(stackTraceElement.getLineNumber());
                        stringBuilder4.append(" ]\r\n");
                        stringBuffer.append(stringBuilder4.toString());
                    }
                }
            }
            Log.e(this.a, stringBuffer.toString());
        }
    }

    public void error(Object obj) {
        if (this.c <= 6) {
            String obj2;
            String a = a();
            if (a == null) {
                obj2 = obj.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" - ");
                stringBuilder.append(obj);
                obj2 = stringBuilder.toString();
            }
            Log.e(this.a, obj2);
        }
    }

    public int getLogLevel() {
        return this.c;
    }

    public void i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public void info(Object obj) {
        if (this.c <= 4) {
            String obj2;
            String a = a();
            if (a == null) {
                obj2 = obj.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" - ");
                stringBuilder.append(obj);
                obj2 = stringBuilder.toString();
            }
            Log.i(this.a, obj2);
        }
    }

    public boolean isDebugEnable() {
        return this.b;
    }

    public void setDebugEnable(boolean z) {
        this.b = z;
    }

    public void setLogLevel(int i) {
        this.c = i;
    }

    public void setTag(String str) {
        this.a = str;
    }

    public void v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public void verbose(Object obj) {
        if (this.c <= 2) {
            String obj2;
            String a = a();
            if (a == null) {
                obj2 = obj.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" - ");
                stringBuilder.append(obj);
                obj2 = stringBuilder.toString();
            }
            Log.v(this.a, obj2);
        }
    }

    public void w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public void warn(Object obj) {
        if (this.c <= 5) {
            String obj2;
            String a = a();
            if (a == null) {
                obj2 = obj.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" - ");
                stringBuilder.append(obj);
                obj2 = stringBuilder.toString();
            }
            Log.w(this.a, obj2);
        }
    }
}
