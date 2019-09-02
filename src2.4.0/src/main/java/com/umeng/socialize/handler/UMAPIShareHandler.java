package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.socialize.PlatformConfig$Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.editorpage.IEditor;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O0000Oo0;
import defpackage.by;
import defpackage.cb;
import defpackage.cc;
import defpackage.ce;
import defpackage.cl;
import defpackage.co;
import defpackage.cp;
import java.util.Map;
import java.util.Stack;

public abstract class UMAPIShareHandler extends UMSSOHandler implements IEditor {
    private Stack<StatHolder> O000000o = new Stack();

    private static class StatHolder {
        public ShareContent O000000o;
        private UMShareListener O00000Oo;

        private StatHolder() {
        }

        /* synthetic */ StatHolder(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public void O000000o(int i, int i2, Intent intent) {
        if (i == O00000Oo()) {
            StatHolder statHolder;
            if (i2 == 1000) {
                if (!this.O000000o.isEmpty()) {
                    statHolder = (StatHolder) this.O000000o.pop();
                    if (statHolder != null) {
                        statHolder.O00000Oo.onCancel(O00000oO());
                    }
                }
            } else if (intent == null || !intent.hasExtra(ce.O0000oOO)) {
                O00000Oo(i, i2, intent);
            } else if (!this.O000000o.empty()) {
                statHolder = (StatHolder) this.O000000o.pop();
                final Bundle extras = intent.getExtras();
                if (i2 == -1) {
                    cc.O000000o(new Runnable() {
                        public void run() {
                            UMAPIShareHandler.this.O00000o0(UMAPIShareHandler.this.O000000o(statHolder.O000000o, extras), statHolder.O00000Oo);
                        }
                    }, true);
                } else if (statHolder.O00000Oo != null) {
                    statHolder.O00000Oo.onCancel(O00000oO());
                }
            }
        }
    }

    public void O000000o(Context context, PlatformConfig$Platform platformConfig$Platform) {
        super.O000000o(context, platformConfig$Platform);
    }

    public boolean O000000o(final ShareContent shareContent, final UMShareListener uMShareListener) {
        if (O0000O0o()) {
            O00000Oo(shareContent, uMShareListener);
        } else {
            O00000Oo(new UMAuthListener() {
                public void onCancel(by byVar, int i) {
                    uMShareListener.onCancel(byVar);
                }

                public void onComplete(by byVar, int i, Map<String, String> map) {
                    cc.O000000o(new Runnable() {
                        public void run() {
                            UMAPIShareHandler.this.O00000Oo(shareContent, uMShareListener);
                        }
                    }, true);
                }

                public void onError(by byVar, int i, Throwable th) {
                    uMShareListener.onError(byVar, th);
                }

                public void onStart(by byVar) {
                    uMShareListener.onStart(byVar);
                }
            });
        }
        return false;
    }

    public abstract void O00000Oo(int i, int i2, Intent intent);

    /* Access modifiers changed, original: protected */
    public void O00000Oo(ShareContent shareContent, UMShareListener uMShareListener) {
        if (O0000o0O().isOpenShareEditActivity()) {
            StatHolder statHolder = new StatHolder();
            statHolder.O000000o = shareContent;
            statHolder.O00000Oo = uMShareListener;
            this.O000000o.push(statHolder);
            if (this.O000O0Oo.get() != null && !((Activity) this.O000O0Oo.get()).isFinishing()) {
                try {
                    Intent intent = new Intent((Context) this.O000O0Oo.get(), Class.forName("com.umeng.socialize.editorpage.ShareActivity"));
                    intent.putExtras(O000000o(shareContent));
                    ((Activity) this.O000O0Oo.get()).startActivityForResult(intent, O00000Oo());
                    return;
                } catch (ClassNotFoundException e) {
                    O00000o0(shareContent, uMShareListener);
                    O0000O0o.O000000o(O0000Oo0.O000000o, e);
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        O00000o0(shareContent, uMShareListener);
    }

    public abstract String O00000o();

    public void O00000o0(ShareContent shareContent, final UMShareListener uMShareListener) {
        final by O00000oO = O00000oO();
        String toLowerCase = O00000oO.toString().toLowerCase();
        String O00000o = O00000o();
        co coVar = new co(O0000o00(), toLowerCase, shareContent.mText);
        coVar.O000000o(shareContent.mMedia);
        coVar.O00000oO(O00000o);
        coVar.O000000o(0);
        final cp O000000o = cl.O000000o(coVar);
        if (O000000o == null) {
            cc.O000000o(new Runnable() {
                public void run() {
                    UMShareListener uMShareListener = uMShareListener;
                    by byVar = O00000oO;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cb.ShareFailed.O000000o());
                    stringBuilder.append("response is null");
                    uMShareListener.onError(byVar, new Throwable(stringBuilder.toString()));
                }
            });
        } else if (O000000o.O00000o0()) {
            cc.O000000o(new Runnable() {
                public void run() {
                    uMShareListener.onResult(O00000oO);
                }
            });
        } else {
            final cp cpVar = O000000o;
            final ShareContent shareContent2 = shareContent;
            final UMShareListener uMShareListener2 = uMShareListener;
            cc.O000000o(new Runnable() {
                public void run() {
                    if (cpVar.O0000o0 == 5027) {
                        UMAPIShareHandler.this.O0000Oo();
                        UMAPIShareHandler.this.O000000o(shareContent2, uMShareListener2);
                        return;
                    }
                    UMShareListener uMShareListener = uMShareListener2;
                    by byVar = O00000oO;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cb.ShareFailed.O000000o());
                    stringBuilder.append(O000000o.O0000o00);
                    uMShareListener.onError(byVar, new Throwable(stringBuilder.toString()));
                }
            });
        }
    }

    public abstract by O00000oO();

    public abstract void O0000Oo();
}
