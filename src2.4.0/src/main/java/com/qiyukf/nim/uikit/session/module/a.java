package com.qiyukf.nim.uikit.session.module;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;

public final class a {
    public final Activity a;
    public final Fragment b;
    public String c;
    public final SessionTypeEnum d;
    public final b e;

    public a(Fragment fragment, String str, SessionTypeEnum sessionTypeEnum, b bVar) {
        this.b = fragment;
        this.a = fragment.getActivity();
        this.c = str;
        this.d = sessionTypeEnum;
        this.e = bVar;
    }
}
