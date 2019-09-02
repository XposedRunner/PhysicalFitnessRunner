package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.BaseApi.TempRequestListener;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.web.security.JniInterface;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class AuthAgent extends BaseApi {
    public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_NAME = null;
    public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";
    private IUiListener c;
    private String d;
    private WeakReference<Activity> e;

    /* compiled from: ProGuard */
    private class a implements IUiListener {
        IUiListener a;

        public a(IUiListener iUiListener) {
            this.a = iUiListener;
        }

        public void onCancel() {
            if (this.a != null) {
                this.a.onCancel();
            }
        }

        public void onComplete(Object obj) {
            if (obj == null) {
                f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            try {
                int i = jSONObject.getInt("ret");
                obj = i == 0 ? "success" : jSONObject.getString("msg");
                if (this.a != null) {
                    this.a.onComplete(new JSONObject().put("ret", i).put("msg", obj));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }

        public void onError(UiError uiError) {
            if (this.a != null) {
                this.a.onError(uiError);
            }
        }
    }

    /* compiled from: ProGuard */
    private class b implements IUiListener {
        IUiListener a;
        private final String c = "sendinstall";
        private final String d = "installwording";
        private final String e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        /* compiled from: ProGuard */
        private abstract class a implements OnClickListener {
            Dialog d;

            a(Dialog dialog) {
                this.d = dialog;
            }
        }

        public b(IUiListener iUiListener) {
            this.a = iUiListener;
        }

        private Drawable a(String str, Context context) {
            Drawable ninePatchDrawable;
            IOException e;
            Drawable drawable = null;
            try {
                InputStream open = context.getApplicationContext().getAssets().open(str);
                if (open == null) {
                    return null;
                }
                if (str.endsWith(".9.png")) {
                    Bitmap decodeStream;
                    try {
                        decodeStream = BitmapFactory.decodeStream(open);
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                        decodeStream = null;
                    }
                    if (decodeStream == null) {
                        return null;
                    }
                    byte[] ninePatchChunk = decodeStream.getNinePatchChunk();
                    NinePatch.isNinePatchChunk(ninePatchChunk);
                    ninePatchDrawable = new NinePatchDrawable(decodeStream, ninePatchChunk, new Rect(), null);
                } else {
                    ninePatchDrawable = Drawable.createFromStream(open, str);
                    try {
                        open.close();
                    } catch (IOException e3) {
                        drawable = ninePatchDrawable;
                        e = e3;
                    }
                }
                return ninePatchDrawable;
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                ninePatchDrawable = drawable;
                return ninePatchDrawable;
            }
        }

        private View a(Context context, Drawable drawable, String str, OnClickListener onClickListener, OnClickListener onClickListener2) {
            Context context2 = context;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f = displayMetrics.density;
            RelativeLayout relativeLayout = new RelativeLayout(context2);
            ImageView imageView = new ImageView(context2);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setId(1);
            int i = (int) (60.0f * f);
            int i2 = (int) (14.0f * f);
            int i3 = (int) (18.0f * f);
            int i4 = (int) (6.0f * f);
            LayoutParams layoutParams = new LayoutParams(i, i);
            layoutParams.addRule(9);
            layoutParams.setMargins(0, i3, i4, i3);
            relativeLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(context2);
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setGravity(3);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 0);
            textView.setLines(2);
            textView.setId(5);
            textView.setMinWidth((int) (185.0f * f));
            layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(1, 1);
            layoutParams.addRule(6, 1);
            float f2 = 5.0f * f;
            layoutParams.setMargins(0, 0, (int) f2, 0);
            relativeLayout.addView(textView, layoutParams);
            View view = new View(context2);
            view.setBackgroundColor(Color.rgb(214, 214, 214));
            view.setId(3);
            layoutParams = new LayoutParams(-2, 2);
            layoutParams.addRule(3, 1);
            layoutParams.addRule(5, 1);
            layoutParams.addRule(7, 5);
            int i5 = (int) (12.0f * f);
            layoutParams.setMargins(0, 0, 0, i5);
            relativeLayout.addView(view, layoutParams);
            LinearLayout linearLayout = new LinearLayout(context2);
            layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(5, 1);
            layoutParams.addRule(7, 5);
            layoutParams.addRule(3, 3);
            Button button = new Button(context2);
            button.setText("跳过");
            button.setBackgroundDrawable(a("buttonNegt.png", context2));
            button.setTextColor(Color.rgb(36, 97, 131));
            button.setTextSize(20.0f);
            button.setOnClickListener(onClickListener2);
            button.setId(4);
            i4 = (int) (45.0f * f);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, i4);
            layoutParams2.rightMargin = i2;
            int i6 = (int) (4.0f * f);
            layoutParams2.leftMargin = i6;
            layoutParams2.weight = 1.0f;
            linearLayout.addView(button, layoutParams2);
            button = new Button(context2);
            button.setText("确定");
            button.setTextSize(20.0f);
            button.setTextColor(Color.rgb(255, 255, 255));
            button.setBackgroundDrawable(a("buttonPost.png", context2));
            button.setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, i4);
            layoutParams3.weight = 1.0f;
            layoutParams3.rightMargin = i6;
            linearLayout.addView(button, layoutParams3);
            relativeLayout.addView(linearLayout, layoutParams);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (279.0f * f), (int) (163.0f * f));
            relativeLayout.setPadding(i2, 0, i5, i5);
            relativeLayout.setLayoutParams(layoutParams4);
            relativeLayout.setBackgroundColor(Color.rgb(247, 251, 247));
            PaintDrawable paintDrawable = new PaintDrawable(Color.rgb(247, 251, 247));
            paintDrawable.setCornerRadius(f2);
            relativeLayout.setBackgroundDrawable(paintDrawable);
            return relativeLayout;
        }

        private void a(String str, final IUiListener iUiListener, final Object obj) {
            if (AuthAgent.this.e != null) {
                Context context = (Activity) AuthAgent.this.e.get();
                if (context != null) {
                    PackageInfo packageInfo;
                    Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(1);
                    PackageManager packageManager = context.getPackageManager();
                    Drawable drawable = null;
                    try {
                        packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                    } catch (NameNotFoundException e) {
                        e.printStackTrace();
                        packageInfo = null;
                    }
                    if (packageInfo != null) {
                        drawable = packageInfo.applicationInfo.loadIcon(packageManager);
                    }
                    AnonymousClass1 anonymousClass1 = new a(dialog) {
                        public void onClick(View view) {
                            b.this.a();
                            if (this.d != null && this.d.isShowing()) {
                                this.d.dismiss();
                            }
                            if (iUiListener != null) {
                                iUiListener.onComplete(obj);
                            }
                        }
                    };
                    AnonymousClass2 anonymousClass2 = new a(dialog) {
                        public void onClick(View view) {
                            if (this.d != null && this.d.isShowing()) {
                                this.d.dismiss();
                            }
                            if (iUiListener != null) {
                                iUiListener.onComplete(obj);
                            }
                        }
                    };
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setAlpha(0);
                    dialog.getWindow().setBackgroundDrawable(colorDrawable);
                    dialog.setContentView(a(context, drawable, str, anonymousClass1, anonymousClass2));
                    dialog.setOnCancelListener(new OnCancelListener() {
                        public void onCancel(DialogInterface dialogInterface) {
                            if (iUiListener != null) {
                                iUiListener.onComplete(obj);
                            }
                        }
                    });
                    if (!(context == null || context.isFinishing())) {
                        dialog.show();
                    }
                }
            }
        }

        /* Access modifiers changed, original: protected */
        public void a() {
            Bundle j = AuthAgent.this.b();
            if (AuthAgent.this.e != null) {
                Activity activity = (Activity) AuthAgent.this.e.get();
                if (activity != null) {
                    HttpUtils.requestAsync(AuthAgent.this.b, activity, "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", j, Constants.HTTP_POST, null);
                }
            }
        }

        public void onCancel() {
            if (this.a != null) {
                this.a.onCancel();
            }
        }

        public void onComplete(Object obj) {
            if (obj != null) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    String str = "";
                    Object obj2 = null;
                    try {
                        if (jSONObject.getInt("sendinstall") == 1) {
                            obj2 = 1;
                        }
                        str = jSONObject.getString("installwording");
                    } catch (JSONException unused) {
                        f.d("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
                    }
                    str = URLDecoder.decode(str);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(" WORDING = ");
                    stringBuilder.append(str);
                    stringBuilder.append("xx");
                    f.a("openSDK_LOG.AuthAgent", stringBuilder.toString());
                    if (obj2 != null && !TextUtils.isEmpty(str)) {
                        a(str, this.a, obj);
                    } else if (this.a != null) {
                        if (AuthAgent.this.b != null) {
                            AuthAgent.this.b.saveSession(jSONObject);
                        }
                        this.a.onComplete(obj);
                    }
                }
            }
        }

        public void onError(UiError uiError) {
            if (this.a != null) {
                this.a.onError(uiError);
            }
        }
    }

    /* compiled from: ProGuard */
    private class c implements IUiListener {
        private final IUiListener b;
        private final boolean c;
        private final Context d;

        public c(Context context, IUiListener iUiListener, boolean z, boolean z2) {
            this.d = context;
            this.b = iUiListener;
            this.c = z;
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        public void onCancel() {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.b.onCancel();
            f.b();
        }

        public void onComplete(Object obj) {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            JSONObject jSONObject = (JSONObject) obj;
            try {
                String string = jSONObject.getString("access_token");
                String string2 = jSONObject.getString("expires_in");
                String string3 = jSONObject.getString("openid");
                if (!(string == null || AuthAgent.this.b == null || string3 == null)) {
                    AuthAgent.this.b.setAccessToken(string, string2);
                    AuthAgent.this.b.setOpenId(string3);
                    com.tencent.connect.a.a.d(this.d, AuthAgent.this.b);
                }
                string = jSONObject.getString(Constants.PARAM_PLATFORM_ID);
                if (string != null) {
                    try {
                        this.d.getSharedPreferences(Constants.PREFERENCE_PF, 0).edit().putString(Constants.PARAM_PLATFORM_ID, string).commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                        f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e);
                    }
                }
                if (this.c) {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
            }
            this.b.onComplete(jSONObject);
            AuthAgent.this.releaseResource();
            f.b();
        }

        public void onError(UiError uiError) {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.b.onError(uiError);
            f.b();
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SECURE_LIB_FILE_NAME);
        stringBuilder.append(".so");
        SECURE_LIB_NAME = stringBuilder.toString();
        String str = Build.CPU_ABI;
        if (str == null || str.equals("")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
            stringBuilder = new StringBuilder();
            stringBuilder.append(SECURE_LIB_FILE_NAME);
            stringBuilder.append(".so");
            SECURE_LIB_NAME = stringBuilder.toString();
            f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
        } else if (str.equalsIgnoreCase("arm64-v8a")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM64_FILE_NAME;
            stringBuilder = new StringBuilder();
            stringBuilder.append(SECURE_LIB_FILE_NAME);
            stringBuilder.append(".so");
            SECURE_LIB_NAME = stringBuilder.toString();
            f.c("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
        } else if (str.equalsIgnoreCase("x86")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_FILE_NAME;
            stringBuilder = new StringBuilder();
            stringBuilder.append(SECURE_LIB_FILE_NAME);
            stringBuilder.append(".so");
            SECURE_LIB_NAME = stringBuilder.toString();
            f.c("openSDK_LOG.AuthAgent", "is x86 architecture");
        } else if (str.equalsIgnoreCase("x86_64")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_64_FILE_NAME;
            stringBuilder = new StringBuilder();
            stringBuilder.append(SECURE_LIB_FILE_NAME);
            stringBuilder.append(".so");
            SECURE_LIB_NAME = stringBuilder.toString();
            f.c("openSDK_LOG.AuthAgent", "is x86_64 architecture");
        } else {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
            stringBuilder = new StringBuilder();
            stringBuilder.append(SECURE_LIB_FILE_NAME);
            stringBuilder.append(".so");
            SECURE_LIB_NAME = stringBuilder.toString();
            f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
        }
    }

    public AuthAgent(QQToken qQToken) {
        super(qQToken);
    }

    private int a(boolean z, IUiListener iUiListener) {
        String str;
        f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
        CookieSyncManager.createInstance(e.a());
        Bundle a = a();
        if (z) {
            a.putString("isadd", "1");
        }
        a.putString("scope", this.d);
        a.putString("client_id", this.b.getAppId());
        if (isOEM) {
            str = Constants.PARAM_PLATFORM_ID;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("desktop_m_qq-");
            stringBuilder.append(installChannel);
            stringBuilder.append("-");
            stringBuilder.append("android");
            stringBuilder.append("-");
            stringBuilder.append(registerChannel);
            stringBuilder.append("-");
            stringBuilder.append(businessId);
            a.putString(str, stringBuilder.toString());
        } else {
            a.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(System.currentTimeMillis() / 1000);
        stringBuilder2.append("");
        str = stringBuilder2.toString();
        a.putString("sign", h.b(e.a(), str));
        a.putString("time", str);
        a.putString("display", "mobile");
        a.putString(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "token");
        a.putString(WBConstants.AUTH_PARAMS_REDIRECT_URL, "auth://tauth.qq.com/");
        a.putString("cancel_display", "1");
        a.putString("switch", "1");
        a.putString("status_userip", j.a());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(g.a().a(e.a(), "https://openmobile.qq.com/oauth2.0/m_authorize?"));
        stringBuilder2.append(HttpUtils.encodeUrl(a));
        str = stringBuilder2.toString();
        final c cVar = new c(e.a(), iUiListener, true, false);
        f.b("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        i.a(new Runnable() {
            public void run() {
                h.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 3);
                JniInterface.loadSo();
                if (AuthAgent.this.e != null) {
                    final Activity activity = (Activity) AuthAgent.this.e.get();
                    if (activity != null) {
                        activity.runOnUiThread(new Runnable() {
                            public void run() {
                                if (JniInterface.isJniOk) {
                                    a aVar = new a(activity, "action_login", str, cVar, AuthAgent.this.b);
                                    if (!activity.isFinishing()) {
                                        aVar.show();
                                        return;
                                    }
                                    return;
                                }
                                f.d("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                                TDialog tDialog = new TDialog(activity, "", AuthAgent.this.a(""), null, AuthAgent.this.b);
                                if (!activity.isFinishing()) {
                                    tDialog.show();
                                }
                            }
                        });
                    }
                }
            }
        });
        f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    private boolean a(Activity activity, Fragment fragment, boolean z) {
        f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        Intent b = b("com.tencent.open.agent.AgentActivity");
        if (b != null) {
            Bundle a = a();
            if (z) {
                a.putString("isadd", "1");
            }
            a.putString("scope", this.d);
            a.putString("client_id", this.b.getAppId());
            if (isOEM) {
                String str = Constants.PARAM_PLATFORM_ID;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("desktop_m_qq-");
                stringBuilder.append(installChannel);
                stringBuilder.append("-");
                stringBuilder.append("android");
                stringBuilder.append("-");
                stringBuilder.append(registerChannel);
                stringBuilder.append("-");
                stringBuilder.append(businessId);
                a.putString(str, stringBuilder.toString());
            } else {
                a.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
            }
            a.putString("need_pay", "1");
            a.putString(Constants.KEY_APP_NAME, h.a(e.a()));
            b.putExtra(Constants.KEY_ACTION, "action_login");
            b.putExtra(Constants.KEY_PARAMS, a);
            b.putExtra("appid", this.b.getAppId());
            if (a(b)) {
                this.c = new b(this.c);
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_LOGIN, this.c);
                if (fragment != null) {
                    f.b("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    a(fragment, b, (int) Constants.REQUEST_LOGIN);
                } else {
                    f.b("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    a(activity, b, (int) Constants.REQUEST_LOGIN);
                }
                f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                d.a().a(0, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                return true;
            }
        }
        d.a().a(1, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void a(IUiListener iUiListener) {
        f.c("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        String str = "tencent&sdk&qazxc***14969%%";
        String str2 = "qzone3.4";
        String accessToken = this.b.getAccessToken();
        String openId = this.b.getOpenId();
        String appId = this.b.getAppId();
        CharSequence charSequence = "";
        if (!(TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId) || TextUtils.isEmpty(appId))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(accessToken);
            stringBuilder.append(appId);
            stringBuilder.append(openId);
            stringBuilder.append(str2);
            charSequence = j.f(stringBuilder.toString());
        }
        if (TextUtils.isEmpty(charSequence)) {
            f.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
            return;
        }
        Bundle a = a();
        a.putString("encrytoken", charSequence);
        HttpUtils.requestAsync(this.b, e.a(), "https://openmobile.qq.com/user/user_login_statis", a, Constants.HTTP_POST, null);
        f.c("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }

    /* Access modifiers changed, original: protected */
    public void b(IUiListener iUiListener) {
        Bundle a = a();
        a.putString("reqType", "checkLogin");
        TempRequestListener tempRequestListener = new TempRequestListener(new a(iUiListener));
        HttpUtils.requestAsync(this.b, e.a(), "https://openmobile.qq.com/v3/user/get_info", a, Constants.HTTP_GET, tempRequestListener);
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener) {
        return doLogin(activity, str, iUiListener, false, null);
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment) {
        this.d = str;
        this.e = new WeakReference(activity);
        this.c = iUiListener;
        if (com.tencent.open.utils.f.a((Context) activity, this.b.getAppId()).b("C_LoginWeb") || !a(activity, fragment, z)) {
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "2", "1", "5", "1", "0", "0");
            f.d("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
            this.c = new b(this.c);
            return a(z, this.c);
        }
        f.c("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
        d.a().a(this.b.getOpenId(), this.b.getAppId(), "2", "1", "5", "0", "0", "0");
        return 1;
    }

    public void releaseResource() {
        this.c = null;
    }
}
