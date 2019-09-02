package com.qiyukf.nimlib.i;

import android.text.TextUtils;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.SessionStatusEnum;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;

public final class h implements RecentContact {
    private String a;
    private String b;
    private String c;
    private int d;
    private MsgStatusEnum e;
    private SessionTypeEnum f;
    private String g;
    private long h;
    private long i;
    private String j;
    private int k;
    private MsgAttachment l;
    private SessionStatusEnum m;

    public final String a() {
        return this.j;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(long j) {
        this.h = j;
    }

    public final void a(SessionTypeEnum sessionTypeEnum) {
        this.f = sessionTypeEnum;
    }

    public final void a(SessionStatusEnum sessionStatusEnum) {
        this.m = sessionStatusEnum;
    }

    public final void a(MsgAttachment msgAttachment) {
        this.l = msgAttachment;
        if (msgAttachment != null) {
            this.j = msgAttachment.toJson(false);
        }
    }

    public final void a(String str) {
        this.a = str;
    }

    public final int b() {
        return this.k;
    }

    public final void b(int i) {
        this.k = i;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final void d(String str) {
        this.g = str;
    }

    public final void e(String str) {
        this.j = str;
        if (!TextUtils.isEmpty(str)) {
            this.l = b.a().c().a(this.k, str);
        }
    }

    public final MsgAttachment getAttachment() {
        return this.l;
    }

    public final String getContactId() {
        return this.a;
    }

    public final String getContent() {
        return this.g;
    }

    public final String getFromAccount() {
        return this.b;
    }

    public final MsgStatusEnum getMsgStatus() {
        return this.e;
    }

    public final MsgTypeEnum getMsgType() {
        return g.a(this.k);
    }

    public final String getRecentMessageId() {
        return this.c;
    }

    public final SessionStatusEnum getSessionStatus() {
        return this.m;
    }

    public final SessionTypeEnum getSessionType() {
        return this.f;
    }

    public final long getTag() {
        return this.i;
    }

    public final long getTime() {
        return this.h;
    }

    public final int getUnreadCount() {
        return this.d;
    }

    public final void setMsgStatus(MsgStatusEnum msgStatusEnum) {
        this.e = msgStatusEnum;
    }

    public final void setTag(long j) {
        this.i = j;
    }
}
