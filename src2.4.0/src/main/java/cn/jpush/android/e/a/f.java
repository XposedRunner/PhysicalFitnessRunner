package cn.jpush.android.e.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a.e;
import cn.jpush.android.a.i;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.c;
import cn.jpush.android.d.a;
import cn.jpush.android.data.b;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.lang.ref.WeakReference;

public final class f {
    private final WeakReference<Activity> a;
    private final b b;

    public f(Context context, b bVar) {
        this.a = new WeakReference((Activity) context);
        this.b = bVar;
    }

    @JavascriptInterface
    private void userClick(String str) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(str);
        } catch (Exception unused) {
            parseInt = 1100;
        }
        e.a(this.b.c, parseInt, null, (Context) this.a.get());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0028  */
    @android.webkit.JavascriptInterface
    public final void click(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
        r1 = this;
        r0 = r1.a;
        r0 = r0.get();
        if (r0 == 0) goto L_0x0033;
    L_0x0008:
        r1.userClick(r2);
        r2 = 0;
        r3 = java.lang.Boolean.parseBoolean(r3);	 Catch:{ Exception -> 0x0015 }
        r4 = java.lang.Boolean.parseBoolean(r4);	 Catch:{ Exception -> 0x0016 }
        goto L_0x0017;
    L_0x0015:
        r3 = r2;
    L_0x0016:
        r4 = r2;
    L_0x0017:
        if (r4 == 0) goto L_0x0026;
    L_0x0019:
        r4 = r1.a;
        r4 = r4.get();
        r4 = (android.content.Context) r4;
        r0 = r1.b;
        cn.jpush.android.api.c.a(r4, r0, r2);
    L_0x0026:
        if (r3 == 0) goto L_0x0033;
    L_0x0028:
        r2 = r1.a;
        r2 = r2.get();
        r2 = (android.app.Activity) r2;
        r2.finish();
    L_0x0033:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.e.a.f.click(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @JavascriptInterface
    public final void close() {
        if (this.a.get() != null) {
            ((Activity) this.a.get()).finish();
        }
    }

    @JavascriptInterface
    public final void createShortcut(String str, String str2, String str3) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(str3);
        } catch (Exception unused) {
            parseInt = 0;
        }
        if (this.a.get() != null) {
            Context context = (Context) this.a.get();
            parseInt = c.a(parseInt);
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                Intent intent = new Intent("android.intent.action.VIEW", parse);
                intent.setFlags(335544320);
                try {
                    ShortcutIconResource fromContext = ShortcutIconResource.fromContext(context, parseInt);
                    Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                    intent2.putExtra("duplicate", false);
                    intent2.putExtra("android.intent.extra.shortcut.NAME", str);
                    intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
                    intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", fromContext);
                    intent2.setPackage(context.getPackageName());
                    context.sendBroadcast(intent2);
                } catch (Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("createShortCut error:");
                    stringBuilder.append(th.getMessage());
                    cn.jpush.android.d.f.c("AndroidUtil", stringBuilder.toString());
                }
            }
        }
    }

    @JavascriptInterface
    public final void download(String str) {
        if (this.a.get() == null) {
        }
    }

    @JavascriptInterface
    public final void download(String str, String str2) {
        if (this.a.get() != null) {
            userClick(str);
            download(str2);
            c.a((Context) this.a.get(), this.b, 0);
            ((Activity) this.a.get()).finish();
        }
    }

    @JavascriptInterface
    public final void download(String str, String str2, String str3) {
        download(str, str2);
    }

    @JavascriptInterface
    public final void executeMsgMessage(String str) {
        if (JCoreInterface.getDebugMode() && this.a.get() != null) {
            i.a((Context) this.a.get(), str);
        }
    }

    @JavascriptInterface
    public final void showTitleBar() {
        if (this.a.get() != null && (this.a.get() instanceof PushActivity)) {
            ((PushActivity) this.a.get()).a();
        }
    }

    @JavascriptInterface
    public final void showToast(String str) {
        if (this.a.get() != null) {
            Toast.makeText((Context) this.a.get(), str, 0).show();
        }
    }

    @JavascriptInterface
    public final void startActivityByIntent(String str, String str2) {
        Context context = (Context) this.a.get();
        if (context != null) {
            try {
                Intent intent = new Intent(str);
                intent.addCategory(context.getPackageName());
                intent.putExtra(JPushInterface.EXTRA_EXTRA, str2);
                intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
                context.startActivity(intent);
            } catch (Exception unused) {
                StringBuilder stringBuilder = new StringBuilder("Unhandle intent : ");
                stringBuilder.append(str);
                cn.jpush.android.d.f.d("WebViewHelper", stringBuilder.toString());
            }
        }
    }

    @JavascriptInterface
    public final void startActivityByName(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            cn.jpush.android.d.f.d("WebViewHelper", "The activity name is null or empty, Give up..");
        }
        Context context = (Context) this.a.get();
        if (context != null) {
            try {
                Class cls = Class.forName(str);
                if (cls != null) {
                    Intent intent = new Intent(context, cls);
                    intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                    intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
                    context.startActivity(intent);
                }
            } catch (Exception unused) {
                cn.jpush.android.d.f.d("WebViewHelper", "The activity name is invalid, Give up..");
            }
        }
    }

    @JavascriptInterface
    public final void startMainActivity(String str) {
        Context context = (Context) this.a.get();
        if (context != null) {
            try {
                ((Activity) context).finish();
                a.d(context, str);
            } catch (Exception unused) {
                cn.jpush.android.d.f.d("WebViewHelper", "startMainActivity failed");
            }
        }
    }

    @JavascriptInterface
    public final void startPushActivity(String str) {
        if (this.a.get() != null && (this.a.get() instanceof PopWinActivity)) {
            ((PopWinActivity) this.a.get()).a(str);
        }
    }

    @JavascriptInterface
    public final void triggerNativeAction(String str) {
        Context context = (Context) this.a.get();
        if (context != null) {
            String str2 = JPushInterface.ACTION_RICHPUSH_CALLBACK;
            String str3 = JPushInterface.EXTRA_EXTRA;
            Bundle bundle = new Bundle();
            if (str3 != null) {
                bundle.putString(str3, str);
            }
            a.a(context, str2, bundle);
        }
    }
}
