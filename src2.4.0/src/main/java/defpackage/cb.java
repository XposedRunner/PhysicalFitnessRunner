package defpackage;

/* compiled from: UmengErrorCode */
/* renamed from: cb */
public enum cb {
    UnKnowCode(2000),
    AuthorizeFailed(2002),
    ShareFailed(2003),
    RequestForUserProfileFailed(2004),
    ShareDataNil(2004),
    ShareDataTypeIllegal(2004),
    NotInstall(2008);
    
    private final int O0000OOo;

    private cb(int i) {
        this.O0000OOo = i;
    }

    private String O00000Oo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("错误码：");
        stringBuilder.append(this.O0000OOo);
        stringBuilder.append(" 错误信息：");
        return stringBuilder.toString();
    }

    public String O000000o() {
        StringBuilder stringBuilder;
        if (this == UnKnowCode) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(O00000Oo());
            stringBuilder.append("未知错误----");
            return stringBuilder.toString();
        } else if (this == AuthorizeFailed) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(O00000Oo());
            stringBuilder.append("授权失败----");
            return stringBuilder.toString();
        } else if (this == ShareFailed) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(O00000Oo());
            stringBuilder.append("分享失败----");
            return stringBuilder.toString();
        } else if (this == RequestForUserProfileFailed) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(O00000Oo());
            stringBuilder.append("获取用户资料失败----");
            return stringBuilder.toString();
        } else if (this == ShareDataNil) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(O00000Oo());
            stringBuilder.append("分享内容为空");
            return stringBuilder.toString();
        } else if (this == ShareDataTypeIllegal) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(O00000Oo());
            stringBuilder.append("分享内容不合法----");
            return stringBuilder.toString();
        } else if (this != NotInstall) {
            return "unkonw";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(O00000Oo());
            stringBuilder.append("没有安装应用");
            return stringBuilder.toString();
        }
    }
}
