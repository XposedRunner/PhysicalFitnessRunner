package defpackage;

import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.shareboard.O00000o;

/* compiled from: SHARE_MEDIA */
/* renamed from: by */
public enum by {
    GOOGLEPLUS,
    GENERIC,
    SMS,
    EMAIL,
    SINA,
    QZONE,
    QQ,
    RENREN,
    WEIXIN,
    WEIXIN_CIRCLE,
    WEIXIN_FAVORITE,
    TENCENT,
    DOUBAN,
    FACEBOOK,
    FACEBOOK_MESSAGER,
    TWITTER,
    LAIWANG,
    LAIWANG_DYNAMIC,
    YIXIN,
    YIXIN_CIRCLE,
    INSTAGRAM,
    PINTEREST,
    EVERNOTE,
    POCKET,
    LINKEDIN,
    FOURSQUARE,
    YNOTE,
    WHATSAPP,
    LINE,
    FLICKR,
    TUMBLR,
    ALIPAY,
    KAKAO,
    DROPBOX,
    VKONTAKTE,
    DINGTALK,
    MORE;

    public static by O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("wxtimeline")) {
            return WEIXIN_CIRCLE;
        }
        if (str.equals("wxsession")) {
            return WEIXIN;
        }
        for (by byVar : by.values()) {
            if (byVar.toString().trim().equals(str)) {
                return byVar;
            }
        }
        return null;
    }

    public static O00000o O000000o(String str, String str2, String str3, String str4, int i) {
        O00000o o00000o = new O00000o();
        o00000o.O00000Oo = str;
        o00000o.O00000o0 = str3;
        o00000o.O00000o = str4;
        o00000o.O00000oO = i;
        o00000o.O000000o = str2;
        return o00000o;
    }

    public O00000o O000000o() {
        O00000o o00000o = new O00000o();
        if (toString().equals("QQ")) {
            o00000o.O00000Oo = bw.O00000oo;
            o00000o.O00000o0 = "umeng_socialize_qq";
            o00000o.O00000o = "umeng_socialize_qq";
            o00000o.O00000oO = 0;
            o00000o.O000000o = "qq";
        } else if (toString().equals("SMS")) {
            o00000o.O00000Oo = bw.O00000Oo;
            o00000o.O00000o0 = "umeng_socialize_sms";
            o00000o.O00000o = "umeng_socialize_sms";
            o00000o.O00000oO = 1;
            o00000o.O000000o = "sms";
        } else if (toString().equals("GOOGLEPLUS")) {
            o00000o.O00000Oo = bw.O000000o;
            o00000o.O00000o0 = "umeng_socialize_google";
            o00000o.O00000o = "umeng_socialize_google";
            o00000o.O00000oO = 0;
            o00000o.O000000o = "gooleplus";
        } else if (!toString().equals("GENERIC")) {
            if (toString().equals("EMAIL")) {
                o00000o.O00000Oo = bw.O00000o0;
                o00000o.O00000o0 = "umeng_socialize_gmail";
                o00000o.O00000o = "umeng_socialize_gmail";
                o00000o.O00000oO = 2;
                o00000o.O000000o = "email";
            } else if (toString().equals("SINA")) {
                o00000o.O00000Oo = bw.O00000o;
                o00000o.O00000o0 = "umeng_socialize_sina";
                o00000o.O00000o = "umeng_socialize_sina";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "sina";
            } else if (toString().equals("QZONE")) {
                o00000o.O00000Oo = bw.O00000oO;
                o00000o.O00000o0 = "umeng_socialize_qzone";
                o00000o.O00000o = "umeng_socialize_qzone";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "qzone";
            } else if (toString().equals("RENREN")) {
                o00000o.O00000Oo = bw.O0000O0o;
                o00000o.O00000o0 = "umeng_socialize_renren";
                o00000o.O00000o = "umeng_socialize_renren";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "renren";
            } else if (toString().equals("WEIXIN")) {
                o00000o.O00000Oo = bw.O0000OOo;
                o00000o.O00000o0 = "umeng_socialize_wechat";
                o00000o.O00000o = "umeng_socialize_weichat";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "wechat";
            } else if (toString().equals("WEIXIN_CIRCLE")) {
                o00000o.O00000Oo = bw.O0000Oo0;
                o00000o.O00000o0 = "umeng_socialize_wxcircle";
                o00000o.O00000o = "umeng_socialize_wxcircle";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "wxcircle";
            } else if (toString().equals("WEIXIN_FAVORITE")) {
                o00000o.O00000Oo = bw.O0000Oo;
                o00000o.O00000o0 = "umeng_socialize_fav";
                o00000o.O00000o = "umeng_socialize_fav";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "wechatfavorite";
            } else if (toString().equals("TENCENT")) {
                o00000o.O00000Oo = bw.O0000OoO;
                o00000o.O00000o0 = "umeng_socialize_tx";
                o00000o.O00000o = "umeng_socialize_tx";
                o00000o.O00000oO = 0;
                o00000o.O000000o = db.O000Oo0O;
            } else if (toString().equals("FACEBOOK")) {
                o00000o.O00000Oo = bw.O0000o00;
                o00000o.O00000o0 = "umeng_socialize_facebook";
                o00000o.O00000o = "umeng_socialize_facebook";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "facebook";
            } else if (toString().equals("FACEBOOK_MESSAGER")) {
                o00000o.O00000Oo = bw.O0000o0;
                o00000o.O00000o0 = "umeng_socialize_fbmessage";
                o00000o.O00000o = "umeng_socialize_fbmessage";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "facebook_messager";
            } else if (toString().equals("YIXIN")) {
                o00000o.O00000Oo = bw.O0000oO0;
                o00000o.O00000o0 = "umeng_socialize_yixin";
                o00000o.O00000o = "umeng_socialize_yixin";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "yinxin";
            } else if (toString().equals("TWITTER")) {
                o00000o.O00000Oo = bw.O0000o0O;
                o00000o.O00000o0 = "umeng_socialize_twitter";
                o00000o.O00000o = "umeng_socialize_twitter";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "twitter";
            } else if (toString().equals("LAIWANG")) {
                o00000o.O00000Oo = bw.O0000o0o;
                o00000o.O00000o0 = "umeng_socialize_laiwang";
                o00000o.O00000o = "umeng_socialize_laiwang";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "laiwang";
            } else if (toString().equals("LAIWANG_DYNAMIC")) {
                o00000o.O00000Oo = bw.O0000o;
                o00000o.O00000o0 = "umeng_socialize_laiwang_dynamic";
                o00000o.O00000o = "umeng_socialize_laiwang_dynamic";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "laiwang_dynamic";
            } else if (toString().equals("INSTAGRAM")) {
                o00000o.O00000Oo = bw.O0000oOO;
                o00000o.O00000o0 = "umeng_socialize_instagram";
                o00000o.O00000o = "umeng_socialize_instagram";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "instagram";
            } else if (toString().equals("YIXIN_CIRCLE")) {
                o00000o.O00000Oo = bw.O0000oO;
                o00000o.O00000o0 = "umeng_socialize_yixin_circle";
                o00000o.O00000o = "umeng_socialize_yixin_circle";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "yinxincircle";
            } else if (toString().equals("PINTEREST")) {
                o00000o.O00000Oo = bw.O0000oOo;
                o00000o.O00000o0 = "umeng_socialize_pinterest";
                o00000o.O00000o = "umeng_socialize_pinterest";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "pinterest";
            } else if (toString().equals("EVERNOTE")) {
                o00000o.O00000Oo = bw.O0000oo0;
                o00000o.O00000o0 = "umeng_socialize_evernote";
                o00000o.O00000o = "umeng_socialize_evernote";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "evernote";
            } else if (toString().equals("POCKET")) {
                o00000o.O00000Oo = bw.O0000oo;
                o00000o.O00000o0 = "umeng_socialize_pocket";
                o00000o.O00000o = "umeng_socialize_pocket";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "pocket";
            } else if (toString().equals("LINKEDIN")) {
                o00000o.O00000Oo = bw.O0000ooO;
                o00000o.O00000o0 = "umeng_socialize_linkedin";
                o00000o.O00000o = "umeng_socialize_linkedin";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "linkedin";
            } else if (toString().equals("FOURSQUARE")) {
                o00000o.O00000Oo = bw.O0000ooo;
                o00000o.O00000o0 = "umeng_socialize_foursquare";
                o00000o.O00000o = "umeng_socialize_foursquare";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "foursquare";
            } else if (toString().equals("YNOTE")) {
                o00000o.O00000Oo = bw.O00oOooO;
                o00000o.O00000o0 = "umeng_socialize_ynote";
                o00000o.O00000o = "umeng_socialize_ynote";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "ynote";
            } else if (toString().equals("WHATSAPP")) {
                o00000o.O00000Oo = bw.O00oOooo;
                o00000o.O00000o0 = "umeng_socialize_whatsapp";
                o00000o.O00000o = "umeng_socialize_whatsapp";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "whatsapp";
            } else if (toString().equals("LINE")) {
                o00000o.O00000Oo = bw.O000O00o;
                o00000o.O00000o0 = "umeng_socialize_line";
                o00000o.O00000o = "umeng_socialize_line";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "line";
            } else if (toString().equals("FLICKR")) {
                o00000o.O00000Oo = bw.O000O0OO;
                o00000o.O00000o0 = "umeng_socialize_flickr";
                o00000o.O00000o = "umeng_socialize_flickr";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "flickr";
            } else if (toString().equals("TUMBLR")) {
                o00000o.O00000Oo = bw.O000O0Oo;
                o00000o.O00000o0 = "umeng_socialize_tumblr";
                o00000o.O00000o = "umeng_socialize_tumblr";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "tumblr";
            } else if (toString().equals("KAKAO")) {
                o00000o.O00000Oo = bw.O000O0o0;
                o00000o.O00000o0 = "umeng_socialize_kakao";
                o00000o.O00000o = "umeng_socialize_kakao";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "kakao";
            } else if (toString().equals("DOUBAN")) {
                o00000o.O00000Oo = bw.O0000Ooo;
                o00000o.O00000o0 = "umeng_socialize_douban";
                o00000o.O00000o = "umeng_socialize_douban";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "douban";
            } else if (toString().equals("ALIPAY")) {
                o00000o.O00000Oo = bw.O00oOoOo;
                o00000o.O00000o0 = "umeng_socialize_alipay";
                o00000o.O00000o = "umeng_socialize_alipay";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "alipay";
            } else if (toString().equals("MORE")) {
                o00000o.O00000Oo = bw.O000OO00;
                o00000o.O00000o0 = "umeng_socialize_more";
                o00000o.O00000o = "umeng_socialize_more";
                o00000o.O00000oO = 0;
                o00000o.O000000o = gf.O000Ooo;
            } else if (toString().equals("DINGTALK")) {
                o00000o.O00000Oo = bw.O000O0oo;
                o00000o.O00000o0 = "umeng_socialize_ding";
                o00000o.O00000o = "umeng_socialize_ding";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "ding";
            } else if (toString().equals("VKONTAKTE")) {
                o00000o.O00000Oo = bw.O000O0oO;
                o00000o.O00000o0 = "vk_icon";
                o00000o.O00000o = "vk_icon";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "vk";
            } else if (toString().equals("DROPBOX")) {
                o00000o.O00000Oo = bw.O000O0o;
                o00000o.O00000o0 = "umeng_socialize_dropbox";
                o00000o.O00000o = "umeng_socialize_dropbox";
                o00000o.O00000oO = 0;
                o00000o.O000000o = "dropbox";
            }
        }
        o00000o.O00000oo = this;
        return o00000o;
    }

    public String O000000o(boolean z) {
        return toString().equals("QQ") ? "sso" : toString().equals("SINA") ? z ? "sso" : Config.isUmengSina.booleanValue() ? "cloudy self" : "cloudy third" : toString().equals("QZONE") ? "sso" : toString().equals("RENREN") ? "cloudy self" : toString().equals("WEIXIN") ? "sso" : toString().equals("FACEBOOK") ? z ? "sso" : "cloudy third" : toString().equals("TENCENT") ? "cloudy self" : toString().equals("YIXIN") ? "sso" : toString().equals("TWITTER") ? "sso" : toString().equals("LAIWANG") ? "sso" : toString().equals("LINE") ? "sso" : toString().equals("DOUBAN") ? "cloudy self" : toString().equals("TWITTER") ? "cloudy self" : toString().equals("LINKEDIN") ? "cloudy self" : null;
    }

    public String O00000Oo() {
        return toString().equals("WEIXIN") ? "wxsession" : toString().equals("WEIXIN_CIRCLE") ? "wxtimeline" : toString().equals("WEIXIN_FAVORITE") ? "wxfavorite" : toString().toLowerCase();
    }

    public String O00000Oo(boolean z) {
        return toString().equals("QQ") ? "sso" : toString().equals("SINA") ? z ? "sso" : Config.isUmengSina.booleanValue() ? "cloudy self" : "cloudy third" : toString().equals("FACEBOOK") ? z ? "sso" : "cloudy third" : toString().equals("RENREN") ? "cloudy self" : toString().equals("DOUBAN") ? "cloudy self" : toString().equals("TENCENT") ? "cloudy self" : toString().equals("TWITTER") ? "cloudy self" : toString().equals("LINKEDIN") ? "cloudy self" : "sso";
    }

    public String toString() {
        return super.toString();
    }
}
