package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.PlatformConfig$Platform;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.handler.UMMoreHandler;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.media.O0000Oo;
import com.umeng.socialize.media.O0000o;
import com.umeng.socialize.media.O00oOooO;
import com.umeng.socialize.utils.O00000Oo;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o0;
import com.umeng.socialize.utils.O0000o00;
import com.umeng.socialize.utils.O0000o00.O00000o0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: SocialRouter */
/* renamed from: bp */
public final class bp {
    private static final String O00000Oo = "umeng_share_platform";
    private static final String O00000o0 = "share_action";
    private by O000000o;
    private String O00000o = "6.9.4";
    private final Map<by, UMSSOHandler> O00000oO = new HashMap();
    private final List<Pair<by, String>> O00000oo = new ArrayList();
    private O000000o O0000O0o;
    private Context O0000OOo;
    private SparseArray<UMShareListener> O0000Oo;
    private SparseArray<UMAuthListener> O0000Oo0;
    private SparseArray<UMAuthListener> O0000OoO;

    /* compiled from: SocialRouter */
    /* renamed from: bp$1 */
    class 1 implements UMAuthListener {
        1() {
        }

        public void onCancel(by byVar, int i) {
        }

        public void onComplete(by byVar, int i, Map<String, String> map) {
        }

        public void onError(by byVar, int i, Throwable th) {
        }

        public void onStart(by byVar) {
        }
    }

    /* compiled from: SocialRouter */
    /* renamed from: bp$O000000o */
    private static class O000000o {
        private Map<by, UMSSOHandler> O000000o;

        public O000000o(Map<by, UMSSOHandler> map) {
            this.O000000o = map;
        }

        private boolean O000000o(Context context) {
            return context != null;
        }

        private boolean O000000o(by byVar) {
            PlatformConfig$Platform platformConfig$Platform = (PlatformConfig$Platform) PlatformConfig.configs.get(byVar);
            if (((UMSSOHandler) this.O000000o.get(byVar)) != null) {
                return true;
            }
            O0000O0o.O000000o(O00000o0.O00000Oo(byVar), O0000o0.O0000o0o);
            return false;
        }

        public boolean O000000o(Context context, by byVar) {
            if (!O000000o(context) || !O000000o(byVar)) {
                return false;
            }
            if (((UMSSOHandler) this.O000000o.get(byVar)).O000000o()) {
                return true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(byVar.toString());
            stringBuilder.append(com.umeng.socialize.utils.O0000o00.O000000o.O00000o0);
            O0000O0o.O000000o(stringBuilder.toString());
            return false;
        }

        public boolean O000000o(ShareAction shareAction) {
            by platform = shareAction.getPlatform();
            if (platform == null) {
                return false;
            }
            if ((platform != by.SINA && platform != by.QQ && platform != by.WEIXIN) || ((PlatformConfig$Platform) PlatformConfig.configs.get(platform)).isConfigured()) {
                return O000000o(platform);
            } else {
                O0000O0o.O000000o(O00000o0.O000000o(platform));
                return false;
            }
        }
    }

    public bp(Context context) {
        List list = this.O00000oo;
        list.add(new Pair(by.LAIWANG, "com.umeng.socialize.handler.UMLWHandler"));
        list.add(new Pair(by.LAIWANG_DYNAMIC, "com.umeng.socialize.handler.UMLWHandler"));
        list.add(new Pair(by.SINA, "com.umeng.socialize.handler.SinaSimplyHandler"));
        list.add(new Pair(by.PINTEREST, "com.umeng.socialize.handler.UMPinterestHandler"));
        list.add(new Pair(by.QZONE, "com.umeng.qq.handler.UmengQZoneHandler"));
        list.add(new Pair(by.QQ, "com.umeng.qq.handler.UmengQQHandler"));
        list.add(new Pair(by.RENREN, "com.umeng.socialize.handler.RenrenSsoHandler"));
        list.add(new Pair(by.TENCENT, "com.umeng.socialize.handler.TencentWBSsoHandler"));
        list.add(new Pair(by.WEIXIN, "com.umeng.weixin.handler.UmengWXHandler"));
        list.add(new Pair(by.WEIXIN_CIRCLE, "com.umeng.weixin.handler.UmengWXHandler"));
        list.add(new Pair(by.WEIXIN_FAVORITE, "com.umeng.weixin.handler.UmengWXHandler"));
        list.add(new Pair(by.YIXIN, "com.umeng.socialize.handler.UMYXHandler"));
        list.add(new Pair(by.YIXIN_CIRCLE, "com.umeng.socialize.handler.UMYXHandler"));
        list.add(new Pair(by.EMAIL, "com.umeng.socialize.handler.EmailHandler"));
        list.add(new Pair(by.EVERNOTE, "com.umeng.socialize.handler.UMEvernoteHandler"));
        list.add(new Pair(by.FACEBOOK, "com.umeng.socialize.handler.UMFacebookHandler"));
        list.add(new Pair(by.FACEBOOK_MESSAGER, "com.umeng.socialize.handler.UMFacebookHandler"));
        list.add(new Pair(by.FLICKR, "com.umeng.socialize.handler.UMFlickrHandler"));
        list.add(new Pair(by.FOURSQUARE, "com.umeng.socialize.handler.UMFourSquareHandler"));
        list.add(new Pair(by.GOOGLEPLUS, "com.umeng.socialize.handler.UMGooglePlusHandler"));
        list.add(new Pair(by.INSTAGRAM, "com.umeng.socialize.handler.UMInstagramHandler"));
        list.add(new Pair(by.KAKAO, "com.umeng.socialize.handler.UMKakaoHandler"));
        list.add(new Pair(by.LINE, "com.umeng.socialize.handler.UMLineHandler"));
        list.add(new Pair(by.LINKEDIN, "com.umeng.socialize.handler.UMLinkedInHandler"));
        list.add(new Pair(by.POCKET, "com.umeng.socialize.handler.UMPocketHandler"));
        list.add(new Pair(by.WHATSAPP, "com.umeng.socialize.handler.UMWhatsAppHandler"));
        list.add(new Pair(by.YNOTE, "com.umeng.socialize.handler.UMYNoteHandler"));
        list.add(new Pair(by.SMS, "com.umeng.socialize.handler.SmsHandler"));
        list.add(new Pair(by.DOUBAN, "com.umeng.socialize.handler.DoubanHandler"));
        list.add(new Pair(by.TUMBLR, "com.umeng.socialize.handler.UMTumblrHandler"));
        list.add(new Pair(by.TWITTER, "com.umeng.socialize.handler.TwitterHandler"));
        list.add(new Pair(by.ALIPAY, "com.umeng.socialize.handler.AlipayHandler"));
        list.add(new Pair(by.MORE, "com.umeng.socialize.handler.UMMoreHandler"));
        list.add(new Pair(by.DINGTALK, "com.umeng.socialize.handler.UMDingSSoHandler"));
        list.add(new Pair(by.VKONTAKTE, "com.umeng.socialize.handler.UMVKHandler"));
        list.add(new Pair(by.DROPBOX, "com.umeng.socialize.handler.UMDropBoxHandler"));
        this.O0000O0o = new O000000o(this.O00000oO);
        this.O0000OOo = null;
        this.O0000Oo0 = new SparseArray();
        this.O0000Oo = new SparseArray();
        this.O0000OoO = new SparseArray();
        this.O0000OOo = context;
        O00000Oo();
    }

    private UMAuthListener O000000o(final int i, final String str, final boolean z) {
        return new UMAuthListener() {
            public void onCancel(by byVar, int i) {
                UMAuthListener O00000Oo = bp.this.O00000o0(i);
                if (O00000Oo != null) {
                    O00000Oo.onCancel(byVar, i);
                }
                if (O00000Oo.O000000o() != null) {
                    cq.O000000o(O00000Oo.O000000o(), byVar, cu.O00O0Oo, z, "", str, null);
                }
            }

            public void onComplete(by byVar, int i, Map<String, String> map) {
                UMAuthListener O00000Oo = bp.this.O00000o0(i);
                if (O00000Oo != null) {
                    O00000Oo.onComplete(byVar, i, map);
                }
                if (O00000Oo.O000000o() != null) {
                    cq.O000000o(O00000Oo.O000000o(), byVar, "success", z, "", str, bp.this.O000000o(byVar, (Map) map));
                }
            }

            public void onError(by byVar, int i, Throwable th) {
                UMAuthListener O00000Oo = bp.this.O00000o0(i);
                if (O00000Oo != null) {
                    O00000Oo.onError(byVar, i, th);
                }
                if (th != null) {
                    O0000O0o.O000000o(th.getMessage());
                    O0000O0o.O00000oO(th.getMessage());
                } else {
                    O0000O0o.O000000o("null");
                    O0000O0o.O00000oO("null");
                }
                if (O00000Oo.O000000o() != null && th != null) {
                    cq.O000000o(O00000Oo.O000000o(), byVar, cu.O000OoO0, z, th.getMessage(), str, null);
                }
            }

            public void onStart(by byVar) {
                UMAuthListener O00000Oo = bp.this.O00000o0(i);
                if (O00000Oo != null) {
                    O00000Oo.onStart(byVar);
                }
            }
        };
    }

    private UMSSOHandler O000000o(int i) {
        int i2 = bv.O0000oO0;
        if (!(i == bv.O0000oO0 || i == bv.O0000oOO)) {
            i2 = i;
        }
        if (i == bv.O0000OOo || i == bv.O0000O0o || i == bv.O0000Oo0) {
            i2 = 64206;
        }
        if (i == bv.O0000o0o || i == bv.O0000o) {
            i2 = 5659;
        }
        if (i == bv.O0000o0O) {
            i2 = 5659;
        }
        for (UMSSOHandler uMSSOHandler : this.O00000oO.values()) {
            if (uMSSOHandler != null && r0 == uMSSOHandler.O00000Oo()) {
                return uMSSOHandler;
            }
        }
        return null;
    }

    private UMSSOHandler O000000o(String str) {
        UMSSOHandler uMSSOHandler;
        try {
            uMSSOHandler = (UMSSOHandler) Class.forName(str).newInstance();
        } catch (Exception unused) {
            uMSSOHandler = null;
        }
        if (uMSSOHandler == null) {
            if (str.contains("SinaSimplyHandler")) {
                Config.isUmengSina = Boolean.valueOf(false);
                return O000000o("com.umeng.socialize.handler.SinaSsoHandler");
            } else if (str.contains("UmengQQHandler")) {
                Config.isUmengQQ = Boolean.valueOf(false);
                return O000000o("com.umeng.socialize.handler.UMQQSsoHandler");
            } else if (str.contains("UmengQZoneHandler")) {
                Config.isUmengQQ = Boolean.valueOf(false);
                return O000000o("com.umeng.socialize.handler.QZoneSsoHandler");
            } else if (str.contains("UmengWXHandler")) {
                Config.isUmengWx = Boolean.valueOf(false);
                return O000000o("com.umeng.socialize.handler.UMWXHandler");
            }
        }
        return uMSSOHandler;
    }

    private Map<String, String> O000000o(by byVar, Map<String, String> map) {
        Object obj = "";
        Object obj2 = "";
        if (PlatformConfig.getPlatform(byVar) != null) {
            obj = PlatformConfig.getPlatform(byVar).getAppid();
            obj2 = PlatformConfig.getPlatform(byVar).getAppSecret();
        }
        map.put("aid", obj);
        map.put(cu.O0000oOo, obj2);
        return map;
    }

    private synchronized void O000000o(int i, UMAuthListener uMAuthListener) {
        this.O0000Oo0.put(i, uMAuthListener);
    }

    private synchronized void O000000o(int i, UMShareListener uMShareListener) {
        this.O0000Oo.put(i, uMShareListener);
    }

    private void O000000o(by byVar, UMAuthListener uMAuthListener, UMSSOHandler uMSSOHandler, String str) {
        if (!uMSSOHandler.d_()) {
            int ordinal = byVar.ordinal();
            O000000o(ordinal, uMAuthListener);
            uMSSOHandler.O00000o(O000000o(ordinal, str, uMSSOHandler.O00000oo()));
        }
    }

    private void O000000o(ShareAction shareAction) {
        ShareContent shareContent = shareAction.getShareContent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(O0000o00.O0000o0.O00000o0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O0000o00.O0000o0.O00000oO);
        stringBuilder.append(shareAction.getPlatform().toString());
        arrayList.add(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(O0000o00.O0000o0.O00000o);
        stringBuilder.append(shareAction.getShareContent().getShareType());
        arrayList.add(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(O0000o00.O0000o0.O00000oo);
        stringBuilder2.append(shareContent.mText);
        arrayList.add(stringBuilder2.toString());
        if (shareContent.mMedia != null) {
            if (shareContent.mMedia instanceof O0000Oo) {
                O0000Oo o0000Oo = (O0000Oo) shareContent.mMedia;
                if (o0000Oo.O00000oO()) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(O0000o00.O0000o0.O0000O0o);
                    stringBuilder.append(o0000Oo.O0000Ooo());
                    arrayList.add(stringBuilder.toString());
                } else {
                    byte[] O0000o00 = o0000Oo.O0000o00();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(O0000o00.O0000o0.O0000OOo);
                    stringBuilder3.append(O0000o00 == null ? 0 : O0000o00.length);
                    arrayList.add(stringBuilder3.toString());
                }
                if (o0000Oo.O00000o() != null) {
                    o0000Oo = o0000Oo.O00000o();
                    if (o0000Oo.O00000oO()) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(O0000o00.O0000o0.O0000Oo0);
                        stringBuilder.append(o0000Oo.O0000Ooo());
                        arrayList.add(stringBuilder.toString());
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(O0000o00.O0000o0.O0000Oo);
                        stringBuilder.append(o0000Oo.O0000o00().length);
                        arrayList.add(stringBuilder.toString());
                    }
                }
            }
            if (shareContent.mMedia instanceof com.umeng.socialize.media.O0000o0) {
                com.umeng.socialize.media.O0000o0 o0000o0 = (com.umeng.socialize.media.O0000o0) shareContent.mMedia;
                stringBuilder = new StringBuilder();
                stringBuilder.append(O0000o00.O0000o0.O0000OoO);
                stringBuilder.append(o0000o0.O00000o0());
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(O0000o00.O0000o0.O0000Ooo);
                stringBuilder.append(o0000o0.O00000oo());
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(O0000o00.O0000o0.O0000o00);
                stringBuilder.append(o0000o0.O000000o());
                arrayList.add(stringBuilder.toString());
                if (o0000o0.O00000o() != null) {
                    if (o0000o0.O00000o().O00000oO()) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(O0000o00.O0000o0.O0000Oo0);
                        stringBuilder.append(o0000o0.O00000o().O0000Ooo());
                        arrayList.add(stringBuilder.toString());
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(O0000o00.O0000o0.O0000Oo);
                        stringBuilder.append(o0000o0.O00000o().O0000o00().length);
                        arrayList.add(stringBuilder.toString());
                    }
                }
            }
            if (shareContent.mMedia instanceof O00oOooO) {
                O00oOooO o00oOooO = (O00oOooO) shareContent.mMedia;
                stringBuilder = new StringBuilder();
                stringBuilder.append(O0000o00.O0000o0.O0000o);
                stringBuilder.append(o00oOooO.O00000o0());
                stringBuilder.append("   ");
                stringBuilder.append(o00oOooO.O0000Oo());
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(O0000o00.O0000o0.O0000oO0);
                stringBuilder.append(o00oOooO.O00000oo());
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(O0000o00.O0000o0.O0000oO);
                stringBuilder.append(o00oOooO.O000000o());
                arrayList.add(stringBuilder.toString());
                if (o00oOooO.O00000o() != null) {
                    if (o00oOooO.O00000o().O00000oO()) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(O0000o00.O0000o0.O0000Oo0);
                        stringBuilder.append(o00oOooO.O00000o().O0000Ooo());
                        arrayList.add(stringBuilder.toString());
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(O0000o00.O0000o0.O0000Oo);
                        stringBuilder.append(o00oOooO.O00000o().O0000o00().length);
                        arrayList.add(stringBuilder.toString());
                    }
                }
            }
            if (shareContent.mMedia instanceof O0000o) {
                O0000o o0000o = (O0000o) shareContent.mMedia;
                stringBuilder = new StringBuilder();
                stringBuilder.append(O0000o00.O0000o0.O0000o0);
                stringBuilder.append(o0000o.O00000o0());
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(O0000o00.O0000o0.O0000o0O);
                stringBuilder.append(o0000o.O00000oo());
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(O0000o00.O0000o0.O0000o0o);
                stringBuilder.append(o0000o.O000000o());
                arrayList.add(stringBuilder.toString());
                if (o0000o.O00000o() != null) {
                    if (o0000o.O00000o().O00000oO()) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(O0000o00.O0000o0.O0000Oo0);
                        stringBuilder.append(o0000o.O00000o().O0000Ooo());
                        arrayList.add(stringBuilder.toString());
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(O0000o00.O0000o0.O0000Oo);
                        stringBuilder.append(o0000o.O00000o().O0000o00().length);
                        arrayList.add(stringBuilder.toString());
                    }
                }
            }
        }
        if (shareContent.file != null) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(O0000o00.O0000o0.O0000oOO);
            stringBuilder2.append(shareContent.file.getName());
            arrayList.add(stringBuilder2.toString());
        }
        O0000O0o.O00000Oo((String[]) arrayList.toArray(new String[1]));
    }

    private by O00000Oo(int i) {
        return (i == bv.O0000oO0 || i == bv.O0000oOO) ? by.QQ : (i == bv.O0000o0o || i == bv.O0000o) ? by.SINA : by.QQ;
    }

    private void O00000Oo() {
        for (Pair pair : this.O00000oo) {
            Object O000000o = (pair.first == by.WEIXIN_CIRCLE || pair.first == by.WEIXIN_FAVORITE) ? (UMSSOHandler) this.O00000oO.get(by.WEIXIN) : pair.first == by.FACEBOOK_MESSAGER ? (UMSSOHandler) this.O00000oO.get(by.FACEBOOK) : pair.first == by.YIXIN_CIRCLE ? (UMSSOHandler) this.O00000oO.get(by.YIXIN) : pair.first == by.LAIWANG_DYNAMIC ? (UMSSOHandler) this.O00000oO.get(by.LAIWANG) : pair.first == by.TENCENT ? O000000o((String) pair.second) : pair.first == by.MORE ? new UMMoreHandler() : pair.first == by.SINA ? Config.isUmengSina.booleanValue() ? O000000o((String) pair.second) : O000000o("com.umeng.socialize.handler.SinaSsoHandler") : pair.first == by.WEIXIN ? Config.isUmengWx.booleanValue() ? O000000o((String) pair.second) : O000000o("com.umeng.socialize.handler.UMWXHandler") : pair.first == by.QQ ? Config.isUmengQQ.booleanValue() ? O000000o((String) pair.second) : O000000o("com.umeng.socialize.handler.UMQQSsoHandler") : pair.first == by.QZONE ? Config.isUmengQQ.booleanValue() ? O000000o((String) pair.second) : O000000o("com.umeng.socialize.handler.QZoneSsoHandler") : O000000o((String) pair.second);
            this.O00000oO.put(pair.first, O000000o);
        }
    }

    private synchronized void O00000Oo(int i, UMAuthListener uMAuthListener) {
        this.O0000OoO.put(i, uMAuthListener);
    }

    private void O00000Oo(Context context) {
        String O000000o = O0000Oo0.O000000o(context);
        if (TextUtils.isEmpty(O000000o)) {
            throw new SocializeException(O0000o00.O000000o(O00000o0.O00000oO, O0000o0.O0000oo));
        } else if (da.O000000o(O000000o)) {
            throw new SocializeException(O0000o00.O000000o(O00000o0.O00000oO, O0000o0.O0000ooO));
        } else if (da.O00000Oo(O000000o)) {
            throw new SocializeException(O0000o00.O000000o(O00000o0.O00000oO, O0000o0.O0000ooO));
        }
    }

    private synchronized UMAuthListener O00000o(int i) {
        UMAuthListener uMAuthListener;
        uMAuthListener = (UMAuthListener) this.O0000OoO.get(i, null);
        if (uMAuthListener != null) {
            this.O0000OoO.remove(i);
        }
        return uMAuthListener;
    }

    private synchronized UMAuthListener O00000o0(int i) {
        UMAuthListener uMAuthListener;
        this.O000000o = null;
        uMAuthListener = (UMAuthListener) this.O0000Oo0.get(i, null);
        if (uMAuthListener != null) {
            this.O0000Oo0.remove(i);
        }
        return uMAuthListener;
    }

    private synchronized void O00000o0() {
        this.O0000Oo0.clear();
        this.O0000Oo.clear();
        this.O0000OoO.clear();
    }

    private synchronized UMShareListener O00000oO(int i) {
        UMShareListener uMShareListener;
        uMShareListener = (UMShareListener) this.O0000Oo.get(i, null);
        if (uMShareListener != null) {
            this.O0000Oo.remove(i);
        }
        return uMShareListener;
    }

    public UMSSOHandler O000000o(by byVar) {
        UMSSOHandler uMSSOHandler = (UMSSOHandler) this.O00000oO.get(byVar);
        if (uMSSOHandler != null) {
            uMSSOHandler.O000000o(this.O0000OOo, PlatformConfig.getPlatform(byVar));
        }
        return uMSSOHandler;
    }

    public void O000000o() {
        O00000o0();
        br.O00000Oo();
        UMSSOHandler uMSSOHandler = (UMSSOHandler) this.O00000oO.get(by.SINA);
        if (uMSSOHandler != null) {
            uMSSOHandler.O0000Ooo();
        }
        uMSSOHandler = (UMSSOHandler) this.O00000oO.get(by.MORE);
        if (uMSSOHandler != null) {
            uMSSOHandler.O0000Ooo();
        }
        uMSSOHandler = (UMSSOHandler) this.O00000oO.get(by.DINGTALK);
        if (uMSSOHandler != null) {
            uMSSOHandler.O0000Ooo();
        }
        uMSSOHandler = (UMSSOHandler) this.O00000oO.get(by.WEIXIN);
        if (uMSSOHandler != null) {
            uMSSOHandler.O0000Ooo();
        }
        uMSSOHandler = (UMSSOHandler) this.O00000oO.get(by.QQ);
        if (uMSSOHandler != null) {
            uMSSOHandler.O0000Ooo();
        }
        this.O000000o = null;
        cy.O000000o(O00000Oo.O000000o()).O000000o();
    }

    public void O000000o(int i, int i2, Intent intent) {
        UMSSOHandler O000000o = O000000o(i);
        if (O000000o != null) {
            O000000o.O000000o(i, i2, intent);
        }
    }

    @Deprecated
    public void O000000o(Activity activity, int i, UMAuthListener uMAuthListener) {
        UMSSOHandler O000000o = O000000o(i);
        if (O000000o == null) {
            return;
        }
        if (i == bv.O0000oO0 || i == bv.O0000oOO) {
            O000000o.O000000o((Context) activity, PlatformConfig.getPlatform(O00000Oo(i)));
            O000000o(by.QQ, uMAuthListener, O000000o, String.valueOf(System.currentTimeMillis()));
        }
    }

    public void O000000o(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        if (bundle != null && uMAuthListener != null) {
            String string = bundle.getString(O00000Oo, null);
            if (bundle.getInt(O00000o0, -1) == 0 && !TextUtils.isEmpty(string)) {
                by O000000o = by.O000000o(string);
                if (O000000o != null) {
                    UMSSOHandler uMSSOHandler;
                    if (O000000o == by.QQ) {
                        uMSSOHandler = (UMSSOHandler) this.O00000oO.get(O000000o);
                        uMSSOHandler.O000000o((Context) activity, PlatformConfig.getPlatform(O000000o));
                    } else {
                        uMSSOHandler = O000000o(O000000o);
                    }
                    if (uMSSOHandler != null) {
                        O000000o(O000000o, uMAuthListener, uMSSOHandler, String.valueOf(System.currentTimeMillis()));
                    }
                }
            }
        }
    }

    public void O000000o(Activity activity, by byVar, UMAuthListener uMAuthListener) {
        if (this.O0000O0o.O000000o(activity, byVar)) {
            if (uMAuthListener == null) {
                uMAuthListener = new 1();
            }
            ((UMSSOHandler) this.O00000oO.get(byVar)).O000000o((Context) activity, PlatformConfig.getPlatform(byVar));
            ((UMSSOHandler) this.O00000oO.get(byVar)).O000000o(uMAuthListener);
        }
    }

    public void O000000o(Activity activity, final ShareAction shareAction, final UMShareListener uMShareListener) {
        O00000Oo((Context) activity);
        WeakReference weakReference = new WeakReference(activity);
        if (this.O0000O0o.O000000o(shareAction)) {
            if (O0000O0o.O000000o()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(O0000o00.O0000o0.O00000Oo);
                stringBuilder.append(this.O00000o);
                O0000O0o.O000000o(stringBuilder.toString());
                O000000o(shareAction);
            }
            by platform = shareAction.getPlatform();
            UMSSOHandler uMSSOHandler = (UMSSOHandler) this.O00000oO.get(platform);
            uMSSOHandler.O000000o((Context) weakReference.get(), PlatformConfig.getPlatform(platform));
            if (!(platform.toString().equals("TENCENT") || platform.toString().equals("RENREN") || platform.toString().equals("DOUBAN"))) {
                if (platform.toString().equals("WEIXIN")) {
                    cq.O000000o((Context) weakReference.get(), "wxsession", shareAction.getShareContent().mText, shareAction.getShareContent().mMedia);
                } else if (platform.toString().equals("WEIXIN_CIRCLE")) {
                    cq.O000000o((Context) weakReference.get(), "wxtimeline", shareAction.getShareContent().mText, shareAction.getShareContent().mMedia);
                } else if (platform.toString().equals("WEIXIN_FAVORITE")) {
                    cq.O000000o((Context) weakReference.get(), "wxfavorite", shareAction.getShareContent().mText, shareAction.getShareContent().mMedia);
                } else {
                    cq.O000000o((Context) weakReference.get(), platform.toString().toLowerCase(), shareAction.getShareContent().mText, shareAction.getShareContent().mMedia);
                }
            }
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (O00000Oo.O000000o() != null) {
                boolean z = false;
                if (shareAction.getShareContent().mMedia instanceof O0000Oo) {
                    z = ((O0000Oo) shareAction.getShareContent().mMedia).O0000o0O();
                }
                cv.O000000o(O00000Oo.O000000o(), shareAction.getShareContent(), uMSSOHandler.O00000oo(), platform, valueOf, z);
            }
            final int ordinal = platform.ordinal();
            O000000o(ordinal, uMShareListener);
            final UMShareListener 6 = new UMShareListener() {
                public void onCancel(by byVar) {
                    if (O00000Oo.O000000o() != null) {
                        cq.O000000o(O00000Oo.O000000o(), byVar, cu.O00O0Oo, "", valueOf);
                    }
                    UMShareListener O00000o0 = bp.this.O00000oO(ordinal);
                    if (O00000o0 != null) {
                        O00000o0.onCancel(byVar);
                    }
                }

                public void onError(by byVar, Throwable th) {
                    if (!(O00000Oo.O000000o() == null || th == null)) {
                        cq.O000000o(O00000Oo.O000000o(), byVar, cu.O000OoO0, th.getMessage(), valueOf);
                    }
                    UMShareListener O00000o0 = bp.this.O00000oO(ordinal);
                    if (O00000o0 != null) {
                        O00000o0.onError(byVar, th);
                    }
                    StringBuilder stringBuilder;
                    if (th != null) {
                        O0000O0o.O000000o(th.getMessage());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(O0000o00.O00000oO);
                        stringBuilder.append(O0000o0.O0000ooo);
                        O0000O0o.O000000o(stringBuilder.toString());
                        O0000O0o.O00000oO(th.getMessage());
                        return;
                    }
                    O0000O0o.O000000o("null");
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(O0000o00.O00000oO);
                    stringBuilder.append(O0000o0.O0000ooo);
                    O0000O0o.O000000o(stringBuilder.toString());
                    O0000O0o.O00000oO("null");
                }

                public void onResult(by byVar) {
                    if (O00000Oo.O000000o() != null) {
                        cq.O000000o(O00000Oo.O000000o(), byVar, "success", "", valueOf);
                    }
                    UMShareListener O00000o0 = bp.this.O00000oO(ordinal);
                    if (O00000o0 != null) {
                        O00000o0.onResult(byVar);
                    }
                }

                public void onStart(by byVar) {
                    UMShareListener O00000o0 = bp.this.O00000oO(ordinal);
                    if (O00000o0 != null) {
                        O00000o0.onStart(byVar);
                    }
                }
            };
            if (shareAction.getUrlValid()) {
                cc.O000000o(new Runnable() {
                    public void run() {
                        if (uMShareListener != null) {
                            uMShareListener.onStart(shareAction.getPlatform());
                        }
                    }
                });
                try {
                    uMSSOHandler.O000000o(shareAction.getShareContent(), 6);
                } catch (Throwable th) {
                    O0000O0o.O000000o(th);
                }
                return;
            }
            cc.O000000o(new Runnable() {
                public void run() {
                    UMShareListener uMShareListener = 6;
                    by platform = shareAction.getPlatform();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cb.ShareFailed.O000000o());
                    stringBuilder.append(O0000o00.O0000o0.O000O0o);
                    uMShareListener.onError(platform, new Throwable(stringBuilder.toString()));
                }
            });
        }
    }

    public void O000000o(Context context) {
        this.O0000OOo = context.getApplicationContext();
    }

    public void O000000o(Bundle bundle) {
        int i;
        String str = "";
        if (this.O000000o == null || !(this.O000000o == by.WEIXIN || this.O000000o == by.QQ || this.O000000o == by.SINA)) {
            i = -1;
        } else {
            str = this.O000000o.toString();
            i = 0;
        }
        bundle.putString(O00000Oo, str);
        bundle.putInt(O00000o0, i);
        this.O000000o = null;
    }

    public void O000000o(UMShareConfig uMShareConfig) {
        if (this.O00000oO != null && !this.O00000oO.isEmpty()) {
            for (Entry value : this.O00000oO.entrySet()) {
                UMSSOHandler uMSSOHandler = (UMSSOHandler) value.getValue();
                if (uMSSOHandler != null) {
                    uMSSOHandler.O000000o(uMShareConfig);
                }
            }
        }
    }

    public boolean O000000o(Activity activity, by byVar) {
        ((UMSSOHandler) this.O00000oO.get(byVar)).O000000o((Context) activity, PlatformConfig.getPlatform(byVar));
        return ((UMSSOHandler) this.O00000oO.get(byVar)).O00000oo();
    }

    public void O00000Oo(Activity activity, final by byVar, final UMAuthListener uMAuthListener) {
        if (this.O0000O0o.O000000o(activity, byVar)) {
            UMSSOHandler uMSSOHandler = (UMSSOHandler) this.O00000oO.get(byVar);
            uMSSOHandler.O000000o((Context) activity, PlatformConfig.getPlatform(byVar));
            final String valueOf = String.valueOf(System.currentTimeMillis());
            if (O00000Oo.O000000o() != null) {
                cq.O000000o(O00000Oo.O000000o(), byVar, valueOf);
            }
            final int ordinal = byVar.ordinal();
            O00000Oo(ordinal, uMAuthListener);
            2 2 = new UMAuthListener() {
                public void onCancel(by byVar, int i) {
                    UMAuthListener O000000o = bp.this.O00000o(ordinal);
                    if (O000000o != null) {
                        O000000o.onCancel(byVar, i);
                    }
                    if (O00000Oo.O000000o() != null) {
                        cq.O000000o(O00000Oo.O000000o(), byVar, cu.O00O0Oo, "", valueOf, null);
                    }
                }

                public void onComplete(by byVar, int i, Map<String, String> map) {
                    UMAuthListener O000000o = bp.this.O00000o(ordinal);
                    if (O000000o != null) {
                        O000000o.onComplete(byVar, i, map);
                    }
                    if (O00000Oo.O000000o() != null) {
                        cq.O000000o(O00000Oo.O000000o(), byVar, "success", "", valueOf, map);
                    }
                }

                public void onError(by byVar, int i, Throwable th) {
                    UMAuthListener O000000o = bp.this.O00000o(ordinal);
                    if (O000000o != null) {
                        O000000o.onError(byVar, i, th);
                    }
                    StringBuilder stringBuilder;
                    if (th != null) {
                        O0000O0o.O000000o(th.getMessage());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(O0000o00.O00000oO);
                        stringBuilder.append(O0000o0.O00oOooO);
                        O0000O0o.O000000o(stringBuilder.toString());
                        O0000O0o.O00000oO(th.getMessage());
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(O0000o00.O00000oO);
                        stringBuilder.append(O0000o0.O00oOooO);
                        O0000O0o.O000000o(stringBuilder.toString());
                    }
                    if (O00000Oo.O000000o() != null && th != null) {
                        cq.O000000o(O00000Oo.O000000o(), byVar, cu.O000OoO0, th.getMessage(), valueOf, null);
                    }
                }

                public void onStart(by byVar) {
                    UMAuthListener O000000o = bp.this.O00000o(ordinal);
                    if (O000000o != null) {
                        O000000o.onStart(byVar);
                    }
                }
            };
            cc.O000000o(new Runnable() {
                public void run() {
                    uMAuthListener.onStart(byVar);
                }
            });
            uMSSOHandler.O00000o0(2);
        }
    }

    public boolean O00000Oo(Activity activity, by byVar) {
        if (!this.O0000O0o.O000000o(activity, byVar)) {
            return false;
        }
        ((UMSSOHandler) this.O00000oO.get(byVar)).O000000o((Context) activity, PlatformConfig.getPlatform(byVar));
        return ((UMSSOHandler) this.O00000oO.get(byVar)).O0000OOo();
    }

    public boolean O00000o(Activity activity, by byVar) {
        if (!this.O0000O0o.O000000o(activity, byVar)) {
            return false;
        }
        ((UMSSOHandler) this.O00000oO.get(byVar)).O000000o((Context) activity, PlatformConfig.getPlatform(byVar));
        return ((UMSSOHandler) this.O00000oO.get(byVar)).O0000O0o();
    }

    public String O00000o0(Activity activity, by byVar) {
        if (!this.O0000O0o.O000000o(activity, byVar)) {
            return "";
        }
        ((UMSSOHandler) this.O00000oO.get(byVar)).O000000o((Context) activity, PlatformConfig.getPlatform(byVar));
        return ((UMSSOHandler) this.O00000oO.get(byVar)).O0000Oo0();
    }

    public void O00000o0(Activity activity, final by byVar, final UMAuthListener uMAuthListener) {
        if (this.O0000O0o.O000000o(activity, byVar)) {
            UMSSOHandler uMSSOHandler = (UMSSOHandler) this.O00000oO.get(byVar);
            uMSSOHandler.O000000o((Context) activity, PlatformConfig.getPlatform(byVar));
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (O00000Oo.O000000o() != null) {
                cq.O000000o(O00000Oo.O000000o(), byVar, uMSSOHandler.O0000Oo0(), uMSSOHandler.O00000oo(), valueOf);
            }
            int ordinal = byVar.ordinal();
            O000000o(ordinal, uMAuthListener);
            UMAuthListener O000000o = O000000o(ordinal, valueOf, uMSSOHandler.O00000oo());
            cc.O000000o(new Runnable() {
                public void run() {
                    uMAuthListener.onStart(byVar);
                }
            });
            uMSSOHandler.O00000Oo(O000000o);
            this.O000000o = byVar;
        }
    }
}
