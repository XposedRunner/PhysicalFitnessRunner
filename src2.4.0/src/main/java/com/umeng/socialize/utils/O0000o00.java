package com.umeng.socialize.utils;

import com.zjwh.android_wh_physicalfitness.activity.ArticleDetailActivity;
import defpackage.by;
import defpackage.db;

/* compiled from: UmengText */
public class O0000o00 {
    public static String O000000o = "完整版";
    public static String O00000Oo = "精简版";
    public static String O00000o = "女";
    public static String O00000o0 = "男";
    public static String O00000oO = "解决方案--";

    /* compiled from: UmengText */
    public static class O000000o {
        public static String O000000o = "我想每次获取用户资料都授权怎么办？";
        public static String O00000Oo = "为什么我每次获取用户资料都跳转两次授权界面？";
        public static String O00000o = "[SA10001]权限验证失败，请检查你的签名以及该平台Appkey权限.";
        public static String O00000o0 = "[SA10000]平台不支持授权,无法完成操作";
        public static String O00000oO = "[SA10002]获取用户资料为空，uid为空或token为空";
        public static String O00000oo = "[SA10003]返回数据为空";
    }

    /* compiled from: UmengText */
    public static class O00000Oo {
        public static String O000000o = null;
        public static String O00000Oo = null;
        public static String O00000o = "[SCC10002]mSandCache 找不到";
        public static String O00000o0 = "[SCC10001]没有找到存储设备，存储图片";
        private static String O00000oO = "[SCC10000]";

        static {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O00000oO);
            stringBuilder.append("缓存文件错误，请勿担心，不影响正常使用");
            O000000o = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O00000oO);
            stringBuilder.append("关闭流异常");
            O00000Oo = stringBuilder.toString();
        }
    }

    /* compiled from: UmengText */
    public static class O00000o0 {
        public static String O000000o = "[SCH10000]您的activity中没有重写onActivityResult方法";
        public static String O00000Oo = "[SCH10001]传入Activity为空";
        public static String O00000o = "您使用的SDK版本为：";
        public static String O00000o0 = "[SCH10002]Router为空请检查是否程序被杀死，或释放了我们所有的引用";
        public static String O00000oO = "[SCH10003]请配置您的友盟Appkey";
        public static String O00000oo = "[SCH10004]该平台不支持查询安装";
        public static String O0000O0o = "[SCH10004]该平台不支持查询sdk支持";
        public static String O0000OOo = "[SCH10004]该平台不支持查询是否授权";
        public static String O0000Oo = "[SCH10006]没有配置支付宝回调activity或配置不正确";
        public static String O0000Oo0 = "[SCH10005]监听器为空";
        public static String O0000OoO = "支付宝配置正确";
        public static String O0000Ooo = "你的初始化未完成，请在Application的onCreate中调用 UMConfigure.init(this,appkey,channel,UMConfigure.DEVICE_TYPE_PHONE,\"\");/";
        public static String O0000o00 = "分享对象不能为空!";

        public static String O000000o(int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onActivityResult =");
            stringBuilder.append(i);
            stringBuilder.append("  resultCode=");
            stringBuilder.append(i2);
            return stringBuilder.toString();
        }

        public static String O000000o(by byVar) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("您没有配置");
            stringBuilder.append(byVar.toString());
            stringBuilder.append("的appkey,请在Application中调用PlatformConfig.setxxx进行配置");
            return stringBuilder.toString();
        }

        public static String O000000o(String str, String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[SC20008]您本次打包的签名:");
            stringBuilder.append(str);
            stringBuilder.append("\n");
            stringBuilder.append("包名:");
            stringBuilder.append(str2);
            return stringBuilder.toString();
        }

        public static String O00000Oo(by byVar) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[SC10006]您没有配置 ");
            stringBuilder.append(byVar);
            stringBuilder.append(" 的jar包");
            return stringBuilder.toString();
        }
    }

    /* compiled from: UmengText */
    public static class O00000o {
        public static String O000000o = "[SDB10001]dropbox请传入Activity";
    }

    /* compiled from: UmengText */
    public static class O0000O0o {
        public static String O000000o = "为什么发布按钮为灰色？";
        public static String O00000Oo = "为什么facebook分享取消却回调成功？";
        public static String O00000o = "facebook网页链接，缩略图必须为网络图片";
        public static String O00000o0 = "为什么facebook分享失败？";
        public static String O00000oO = "[SF10000]您没有在AndroidManifest.xml中配置com.umeng.facebook.FacebookActivity";
        public static String O00000oo = "[SF10000]您没有在AndroidManifest.xml中配置com.umeng.facebook.FacebookContentProvider";
        public static String O0000O0o = "[SF10000]您没有在AndroidManifest中配置facebook的appid";
        public static String O0000OOo = "[SF10000]没有找到facebook_app_id，facebook的id必须写在string文件中且名字必须用facebook_app_id";
    }

    /* compiled from: UmengText */
    public static class O0000OOo {
        public static String O000000o = null;
        public static String O00000Oo = null;
        public static String O00000o = null;
        public static String O00000o0 = null;
        public static String O00000oO = null;
        public static String O00000oo = null;
        public static String O0000O0o = null;
        public static String O0000OOo = null;
        public static String O0000Oo = "[SI10001]您的原始图片太大,导致缩略图压缩过后还大于32KB,请将分享到微信的图片进行适当缩小.";
        public static String O0000Oo0 = null;
        public static String O0000OoO = "[SI10002]缩略图参数有误，您没有设置缩略图，或者设置的缩略图内容有误，不能被解析";
        public static String O0000Ooo = "[SI10003]图片参数有误，您没有设置缩略图，或者设置的缩略图内容有误，不能被解析";
        public static String O0000o0 = "[SI10004]不支持的UMImage构建类型，您传入的类型为:";
        public static String O0000o00 = "图片下载链接:";
        private static String O0000o0O = "[SI10000]";

        static {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("字节流转文件错误");
            O000000o = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("bitmap转字节流错误");
            O00000Oo = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("流关闭错误");
            O00000o0 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("字节流输出文件出错");
            O00000o = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("加载文件过大");
            O00000oO = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("文件转入字节流，先要进行压缩出错");
            O00000oo = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("获取文件大小出错");
            O0000O0o = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("读取图片文件出错");
            O0000OOo = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("checkFormat出错");
            O0000Oo0 = stringBuilder.toString();
        }
    }

    /* compiled from: UmengText */
    public static class O0000Oo0 {
        public static String O000000o = "[SIG10000]没有加入界面jar,请添加shareview";
        public static String O00000Oo = "[SIG10001]调用系统分享菜单错误，请换个手机测试";
        public static String O00000o = "handler id:";
        public static String O00000o0 = "[SIG10002]ContextUtil中context为空，请确保程序初始化完毕，且程序中不要使用ContextUtil.setContext（null）方法";
        public static String O00000oO = "分享平台相关信息:";

        public static String O000000o(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("平台(");
            stringBuilder.append(str);
            stringBuilder.append("):");
            return stringBuilder.toString();
        }
    }

    /* compiled from: UmengText */
    public static class O0000Oo {
        public static String O000000o = null;
        public static String O00000Oo = null;
        public static String O00000o = null;
        public static String O00000o0 = "[SN10004]图片下载错误,请检查网址";
        public static String O00000oO = null;
        public static String O00000oo = "[SN10001]重定向问题：url和重定向url相同";
        public static String O0000O0o = "[SN10002]后台返回json为空";
        public static String O0000OOo = "[SN10003]由于权限问题，没有获取到mac";
        public static String O0000Oo = " return json：";
        public static String O0000Oo0 = " post json：";
        public static String O0000OoO = " sharelog success";
        public static String O0000Ooo = " sharelog fail";
        public static String O0000o0 = "body is null";
        public static String O0000o00 = "抱歉,您的网络不可用...";
        private static String O0000o0O = "[SN10000]";

        static {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("返回字符串不是json，可能是由于服务器不通造成");
            O000000o = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("工具类内的错误，不影响用户使用");
            O00000Oo = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("关闭流异常");
            O00000o = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("构建response出错,不影响用户使用，但需要查明原因");
            O00000oO = stringBuilder.toString();
        }

        public static String O000000o(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O0000o0O);
            stringBuilder.append("baseurl=");
            stringBuilder.append(str);
            stringBuilder.append(" 该url不正确");
            return stringBuilder.toString();
        }

        public static String O000000o(String str, String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("urlPath=");
            stringBuilder.append(str);
            stringBuilder.append("  SocializeNetUtils url=");
            stringBuilder.append(str2);
            return stringBuilder.toString();
        }
    }

    /* compiled from: UmengText */
    public static class O0000o00 {
        public static String O000000o = "为什么我的QQ没有回调？";
        public static String O00000Oo = "为什么qq分享成功却回调取消？";
        public static String O00000o = "为什么qq分享失败，缺少权限？";
        public static String O00000o0 = "为什么qq分享成功却没有收到消息？";
        public static String O00000oO = "为什么qq tencent初始化失败？";
        public static String O00000oo = "为什么qq提示100044?";
        public static String O0000O0o = "[SQ20009]initOpenidAndToken error";
        public static String O0000OOo = "错误信息:";
        public static String O0000Oo = "[SQ20007]mTencent信息不正确，请确认appid";
        public static String O0000Oo0 = "[SQ20007]Tencent变量初始化失败，请检查你的app id跟AndroidManifest.xml文件中AuthActivity的scheme是否填写正确";
        public static String O0000OoO = "[SQ10004]QQ图片存储失败，请检查图片或者检查是否有读写权限";
        public static String O0000Ooo = "QQ分享音乐,除了设置播放音乐的url,还可以设置一个跳转的url,可以通过UMusic().setmTargetUrl(xxx)设定";
        public static String O0000o0 = "[SQ10000]qq配置不正确，没有检测到qq的id配置";
        public static String O0000o00 = "[SQ10011]qq配置不正确，AndroidManifest中AuthActivity的data中要加入自己的qq应用id";
        public static String O0000o0O = "[SQ10004]qq 权限配置不正确，缺少android.permission.WRITE_EXTERNAL_STORAGE";

        public static String O000000o(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[SQ10011]没有在AndroidManifest.xml中检测到");
            stringBuilder.append(str);
            stringBuilder.append("请添加");
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
    }

    /* compiled from: UmengText */
    public static class O0000o0 {
        public static String O000000o = "shareview版本号:";
        public static String O00000Oo = "API版本号:";
        public static String O00000o = "分享类型:";
        public static String O00000o0 = "以下为分享的内容:";
        public static String O00000oO = "分享平台:";
        public static String O00000oo = "分享文本:";
        public static String O0000O0o = "图片链接:";
        public static String O0000OOo = "本地图片:";
        public static String O0000Oo = "本地缩略图:";
        public static String O0000Oo0 = "缩略图链接:";
        public static String O0000OoO = "视频链接:";
        public static String O0000Ooo = "视频标题:";
        public static String O0000o = "音乐链接:";
        public static String O0000o0 = "链接:";
        public static String O0000o00 = "视频描述:";
        public static String O0000o0O = "url标题:";
        public static String O0000o0o = "url描述:";
        public static String O0000oO = "音乐描述:";
        public static String O0000oO0 = "音乐标题:";
        public static String O0000oOO = "文件名:";
        public static String O0000oOo = "[SST10000]不支持的分享类型";
        public static String O0000oo = "Foursquare只支持纯图片分享";
        public static String O0000oo0 = "有道云笔记只支持文本，图片，图文分享";
        public static String O0000ooO = "Flickr只支持图片分享";
        public static String O0000ooo = "[SST10001]分享内容有误，请查看log或当前使用的客户端版本不支持分享或授权";
        public static String O000O00o = "[SST10003]您分享的是网页类型但是网址为空";
        public static String O000O0OO = "[SST10004]分享的文本不能为空";
        public static String O000O0Oo = "[SST10005]分享的文本过长";
        public static String O000O0o = "[SST10007]分享的链接需要以http开头";
        public static String O000O0o0 = "分享类型--";
        public static String O000O0oO = "请输入内容....";
        public static String O000O0oo = "超出最大字数限制....";
        public static String O00oOoOo = "[SST10006]分享的链接过长";
        public static String O00oOooO = "[SST10002]当前分享类型内容有误，缺少设置参数或内容不合规，请查看友盟log";
        public static String O00oOooo = "分享到";
    }

    /* compiled from: UmengText */
    public static class O0000o {
        public static String O000000o = "[SSB10000]获取平台名字为空，请检查代码";
        public static String O00000Oo = "[SSB10001]您的工程需要依赖v4或我们提供umeng_shareboard_widget包，请参考线上文档";
    }

    /* compiled from: UmengText */
    public static class O000O00o {
        public static String O000000o = "为什么提示我们无法验证您的凭据？";
        public static String O00000Oo = "当前无活动会话，请确保已经完成授权申请。";
    }

    /* compiled from: UmengText */
    public static class O000O0OO {
        public static String O000000o = "为什么微信没有回调？";
        public static String O00000Oo = "为什么微信朋友圈链接不显示描述文字？";
        public static String O00000o = "为什么微信分享提示hit push hold？";
        public static String O00000o0 = "为什么微信提示40125/invalid APPsecret？";
        public static String O00000oO = "为什么微信登陆提示该链接无法访问？";
        public static String O00000oo = "为什么微信授权一直等待不能成功？";
        public static String O0000O0o = "微信表情分享没有设置缩略图";
        public static String O0000OOo = "微信朋友圈不支持表情分享...";
        public static String O0000Oo = "[SX10000]您没有配置WXEntryActivity或没有配置不正确";
        public static String O0000Oo0 = "微信朋友圈不支持小程序分享...";
        public static String O0000OoO = "[SX10000]请让您的WXEntryActivity继承com.umeng.socialize.weixin.view.WXCallbackActivity";
        public static String O0000Ooo = "[SX10000]请在AndroidManifest文件中配置WXEntryActivity";
    }

    /* compiled from: UmengText */
    public static class O00oOooO {
        public static String O000000o = "[SS10007]新浪多媒体分享，需要添加缩略图，请检查是否添加正确";
        public static String O00000Oo = "[SS10008]启动新浪客户端错误";
        public static String O00000o = "新浪多图分享必须加文字";
        public static String O00000o0 = "[SS10009]新浪AID获取失败";
        public static String O00000oO = "[SS10001]新浪签名或回调地址错误，请去后台检查";
        public static String O00000oo = "[SS10011]返回结果为空，请检查网络，或token是否过期,请检查Appkey是否审核通过";
        public static String O0000O0o = "[SS10012]新浪上传图片失败";
        public static String O0000OOo = "[SS10013]请在AndroidManifest文件中配置com.umeng.socialize.media.WBShareCallBackActivity";
        public static String O0000Oo = "[SS10013]请在AndroidManifest文件中配置com.sina.weibo.sdk.share.WbShareTransActivity";
        public static String O0000Oo0 = "[SS10013]请在AndroidManifest文件中配置com.sina.weibo.sdk.web.WeiboSdkWebActivity";

        public static String O000000o(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[SS10010]没有在AndroidManifest.xml中检测到");
            stringBuilder.append(str);
            stringBuilder.append("请添加");
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
    }

    public static String O000000o(int i) {
        StringBuilder stringBuilder = new StringBuilder("错误:设置视频");
        if (i == 0) {
            stringBuilder.append("视频");
        }
        if (i == 1) {
            stringBuilder.append("音乐");
        }
        if (i == 2) {
            stringBuilder.append("网页");
        }
        stringBuilder.append("分享类型，链接不能为空");
        return stringBuilder.toString();
    }

    public static String O000000o(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("验证请求方式失败[");
        stringBuilder.append(str);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String O000000o(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\n");
        stringBuilder.append("解决方案：");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public static String O000000o(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("缺少资源文件:packageName=");
        stringBuilder.append(str);
        stringBuilder.append("\n");
        stringBuilder.append(" type=");
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        stringBuilder.append(" name=");
        stringBuilder.append(str3);
        stringBuilder.append("请去sdk下载包中拷贝");
        return stringBuilder.toString();
    }

    public static String O000000o(boolean z) {
        String str = z ? O00000Oo : O000000o;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("您使用的是");
        stringBuilder.append(str);
        stringBuilder.append("但是你的AndroidManifest配置不正确，或者配置的不是");
        stringBuilder.append(str);
        stringBuilder.append("的路径，请参照线上报错必看文档");
        return stringBuilder.toString();
    }

    public static String O000000o(boolean z, String str) {
        StringBuilder stringBuilder = new StringBuilder("该平台");
        stringBuilder.append(z ? "只" : "不");
        stringBuilder.append("支持");
        if (str.contains(db.O000Ooo)) {
            stringBuilder.append("图片");
        }
        if (str.contains("netimg")) {
            stringBuilder.append("网络图片");
        }
        if (str.contains("localimg")) {
            stringBuilder.append("本地图片");
        }
        if (str.contains("url")) {
            stringBuilder.append("链接");
        }
        if (str.contains("video")) {
            stringBuilder.append("视频");
        }
        if (str.contains("timg")) {
            stringBuilder.append("图文");
        }
        if (str.contains(ArticleDetailActivity.O00000o)) {
            stringBuilder.append("纯文本");
        }
        stringBuilder.append("分享");
        return stringBuilder.toString();
    }
}
