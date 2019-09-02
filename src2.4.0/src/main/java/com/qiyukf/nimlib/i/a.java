package com.qiyukf.nimlib.i;

import android.text.TextUtils;
import com.qiyukf.basesdk.c.b;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomMessageConfig;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import org.json.JSONObject;

public final class a implements IMMessage {
    private static final long serialVersionUID = -1949246189525361810L;
    private long a = -1;
    private String b;
    private SessionTypeEnum c;
    private int d;
    private MsgStatusEnum e;
    private MsgDirectionEnum f;
    private String g;
    private String h;
    private long i;
    private MsgAttachment j;
    private String k;
    private transient JSONObject l;
    private AttachStatusEnum m;
    private String n;
    private long o;
    private String p;
    private CustomMessageConfig q;

    public final long a() {
        return this.a;
    }

    public final String a(boolean z) {
        return this.j != null ? this.j.toJson(z) : this.p;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(long j) {
        this.a = j;
    }

    public final void a(SessionTypeEnum sessionTypeEnum) {
        this.c = sessionTypeEnum;
    }

    public final void a(CustomMessageConfig customMessageConfig) {
        this.q = customMessageConfig;
    }

    public final void a(String str) {
        this.n = str;
    }

    public final int b() {
        return this.d;
    }

    public final void b(long j) {
        this.o = j;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final long c() {
        return this.o;
    }

    public final void c(String str) {
        this.p = str;
        if (!TextUtils.isEmpty(str)) {
            this.j = b.a().c().a(this.d, str);
        }
    }

    public final CustomMessageConfig d() {
        return this.q;
    }

    public final AttachStatusEnum getAttachStatus() {
        return this.m == null ? AttachStatusEnum.def : this.m;
    }

    public final MsgAttachment getAttachment() {
        return this.j;
    }

    public final String getContent() {
        return this.h;
    }

    public final MsgDirectionEnum getDirect() {
        return this.f;
    }

    public final String getExt() {
        return this.k;
    }

    public final JSONObject getExtension() {
        if (!TextUtils.isEmpty(this.k) && this.l == null) {
            this.l = b.a(this.k);
        }
        return this.l;
    }

    public final String getFromAccount() {
        return this.g;
    }

    public final MsgTypeEnum getMsgType() {
        return g.a(this.d);
    }

    public final String getSessionId() {
        return this.b;
    }

    public final SessionTypeEnum getSessionType() {
        return this.c;
    }

    public final MsgStatusEnum getStatus() {
        return this.e;
    }

    public final long getTime() {
        return this.i;
    }

    public final String getUuid() {
        return this.n;
    }

    public final boolean isTheSame(IMMessage iMMessage) {
        if (iMMessage == null) {
            return false;
        }
        long j = ((a) iMMessage).a;
        return (this.a <= 0 || j <= 0) ? TextUtils.equals(this.n, iMMessage.getUuid()) : this.a == j;
    }

    public final void setAttachStatus(AttachStatusEnum attachStatusEnum) {
        this.m = attachStatusEnum;
    }

    public final void setAttachment(MsgAttachment msgAttachment) {
        this.j = msgAttachment;
    }

    public final void setContent(String str) {
        this.h = str;
    }

    public final void setDirect(MsgDirectionEnum msgDirectionEnum) {
        this.f = msgDirectionEnum;
    }

    public final void setExt(String str) {
        this.l = null;
        this.k = str;
    }

    public final void setFromAccount(String str) {
        this.g = str;
    }

    public final void setStatus(MsgStatusEnum msgStatusEnum) {
        this.e = msgStatusEnum;
    }

    public final void setTime(long j) {
        this.i = j;
    }
}
