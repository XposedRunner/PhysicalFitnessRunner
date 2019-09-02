package com.qiyukf.unicorn.api.pop;

import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.api.msg.UnicornMessage;
import com.qiyukf.unicorn.c;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.j.e;
import java.util.ArrayList;
import java.util.List;

public class POPManager {
    public static void addOnSessionListChangedListener(final OnSessionListChangedListener onSessionListChangedListener, final boolean z) {
        e.a(new Runnable() {
            public final void run() {
                c h = d.h();
                if (h != null) {
                    h.a(onSessionListChangedListener, z);
                }
            }
        });
    }

    public static void clearUnreadCount(final String str) {
        e.a(new Runnable() {
            public final void run() {
                if (d.h() != null) {
                    ((MsgService) NIMClient.getService(MsgService.class)).clearUnreadCount(str, SessionTypeEnum.Ysf);
                }
            }
        });
    }

    public static void deleteSession(final String str, final boolean z) {
        e.a(new Runnable() {
            public final void run() {
                c h = d.h();
                if (h != null) {
                    h.a(str, z);
                }
            }
        });
    }

    public static List<Session> getSessionList() {
        c h = d.h();
        return h == null ? new ArrayList() : h.e();
    }

    public static ShopInfo getShopInfo(String str) {
        return d.h() == null ? null : d.g().b().getUserInfo(str);
    }

    public static UnicornMessage queryLastMessage(String str) {
        return d.h() != null ? ((MsgService) NIMClient.getService(MsgService.class)).queryLastMessage(str, SessionTypeEnum.Ysf) : null;
    }
}
