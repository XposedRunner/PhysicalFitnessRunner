package cn.jpush.android.api;

import java.io.Serializable;
import java.util.Set;

public class JPushMessage implements Serializable {
    private String a;
    private Set<String> b;
    private String c;
    private int d;
    private boolean e;
    private boolean f;
    private int g;
    private String h;

    public String getAlias() {
        return this.a;
    }

    public String getCheckTag() {
        return this.c;
    }

    public int getErrorCode() {
        return this.d;
    }

    public String getMobileNumber() {
        return this.h;
    }

    public int getSequence() {
        return this.g;
    }

    public boolean getTagCheckStateResult() {
        return this.e;
    }

    public Set<String> getTags() {
        return this.b;
    }

    public boolean isTagCheckOperator() {
        return this.f;
    }

    public void setAlias(String str) {
        this.a = str;
    }

    public void setCheckTag(String str) {
        this.c = str;
    }

    public void setErrorCode(int i) {
        this.d = i;
    }

    public void setMobileNumber(String str) {
        this.h = str;
    }

    public void setSequence(int i) {
        this.g = i;
    }

    public void setTagCheckOperator(boolean z) {
        this.f = z;
    }

    public void setTagCheckStateResult(boolean z) {
        this.e = z;
    }

    public void setTags(Set<String> set) {
        this.b = set;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("JPushMessage{alias='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", tags=");
        stringBuilder.append(this.b);
        stringBuilder.append(", checkTag='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", errorCode=");
        stringBuilder.append(this.d);
        stringBuilder.append(", tagCheckStateResult=");
        stringBuilder.append(this.e);
        stringBuilder.append(", isTagCheckOperator=");
        stringBuilder.append(this.f);
        stringBuilder.append(", sequence=");
        stringBuilder.append(this.g);
        stringBuilder.append(", mobileNumber=");
        stringBuilder.append(this.h);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
