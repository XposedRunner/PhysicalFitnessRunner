package cn.jpush.android.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.support.v4.view.PointerIconCompat;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jiguang.net.HttpUtils;
import cn.jpush.android.a.e;
import cn.jpush.android.d.a;
import cn.jpush.android.data.b;
import java.util.Locale;

public final class c extends WebViewClient {
    private final b a;
    private final Context b;
    private boolean c = false;

    public c(b bVar, Context context) {
        this.a = bVar;
        this.b = context;
    }

    public final void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.c) {
            sslErrorHandler.proceed();
        } else if (this.b == null || this.b.getClass().isAssignableFrom(Activity.class)) {
            sslErrorHandler.cancel();
        } else {
            try {
                Builder builder = new Builder(this.b);
                builder.setTitle("提示");
                builder.setMessage("SSL 证书异常，是否继续加载？");
                builder.setNegativeButton("否", new d(this, sslErrorHandler));
                builder.setPositiveButton("是", new e(this, sslErrorHandler));
                builder.setCancelable(false);
                builder.create().show();
            } catch (Throwable unused) {
                sslErrorHandler.cancel();
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Context context = webView.getContext();
        try {
            webView.getSettings().setSavePassword(false);
            a.a(webView);
            String format = String.format(Locale.ENGLISH, "{\"url\":\"%s\"}", new Object[]{str});
            Intent intent;
            if (this.a.F) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                e.a(this.a.c, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, format, cn.jpush.android.a.e);
                return true;
            } else if (str.endsWith(".mp3")) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(str), "audio/*");
                webView.getContext().startActivity(intent);
                return true;
            } else {
                if (!str.endsWith(".mp4")) {
                    if (!str.endsWith(".3gp")) {
                        if (str.endsWith(".apk")) {
                            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            return true;
                        } else if (str.startsWith("http")) {
                            e.a(this.a.c, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, format, cn.jpush.android.a.e);
                            return false;
                        } else if (!str.startsWith("mailto")) {
                            return false;
                        } else {
                            if (str.lastIndexOf("direct=") < 0 && !str.startsWith("mailto")) {
                                StringBuilder stringBuilder;
                                if (str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) > 0) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(str);
                                    stringBuilder.append("&direct=false");
                                } else {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(str);
                                    stringBuilder.append("?direct=false");
                                }
                                str = stringBuilder.toString();
                                str.lastIndexOf("direct=");
                            }
                            int indexOf = str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR);
                            String substring = str.substring(0, indexOf);
                            String substring2 = str.substring(indexOf);
                            Intent intent2 = null;
                            if (substring.startsWith("mailto")) {
                                if (substring.split(":").length == 2) {
                                    int indexOf2 = substring2.indexOf("title=") + 6;
                                    int indexOf3 = substring2.indexOf("&content=");
                                    str = substring2.substring(indexOf2, indexOf3);
                                    substring2 = substring2.substring(indexOf3 + 9);
                                    String[] strArr = new String[]{r4[1]};
                                    Intent intent3 = new Intent("android.intent.action.SEND");
                                    intent3.setType("plain/text");
                                    intent3.putExtra("android.intent.extra.EMAIL", strArr);
                                    intent3.putExtra("android.intent.extra.SUBJECT", str);
                                    intent3.putExtra("android.intent.extra.TEXT", substring2);
                                    intent2 = intent3;
                                }
                            }
                            if (intent2 != null) {
                                context.startActivity(intent2);
                            }
                            e.a(this.a.c, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, format, cn.jpush.android.a.e);
                            return true;
                        }
                    }
                }
                intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(str), "video/*");
                webView.getContext().startActivity(intent);
                return true;
            }
        } catch (Exception unused) {
        }
    }
}
