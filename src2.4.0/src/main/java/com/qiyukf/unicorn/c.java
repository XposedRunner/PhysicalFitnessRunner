package com.qiyukf.unicorn;

import android.os.Handler;
import android.text.TextUtils;
import com.qiyukf.basesdk.c.a;
import com.qiyukf.nimlib.i.h;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.UnreadCountChangeListener;
import com.qiyukf.unicorn.api.msg.SessionStatusEnum;
import com.qiyukf.unicorn.api.pop.OnSessionListChangedListener;
import com.qiyukf.unicorn.api.pop.Session;
import com.qiyukf.unicorn.b.b;
import com.qiyukf.unicorn.f.a.d.g;
import com.qiyukf.unicorn.f.a.e.i;
import com.qiyukf.unicorn.j.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c {
    private final List<RecentContact> a = new ArrayList();
    private final List<UnreadCountChangeListener> b = new ArrayList();
    private final List<OnSessionListChangedListener> c = new ArrayList();
    private Handler d = a.b();
    private boolean e = false;

    public c() {
        AnonymousClass4 anonymousClass4 = new Observer<List<RecentContact>>() {
            public final /* synthetic */ void onEvent(Object obj) {
                List list = (List) obj;
                if (list != null) {
                    c.a(c.this, list);
                    c.this.b(list);
                }
                c.this.g();
            }
        };
        AnonymousClass5 anonymousClass5 = new Observer<RecentContact>() {
            public final /* synthetic */ void onEvent(Object obj) {
                RecentContact recentContact = (RecentContact) obj;
                if (recentContact == null) {
                    c.this.f();
                    return;
                }
                c.this.a(recentContact);
                c.this.b(recentContact);
                if (recentContact.getUnreadCount() > 0) {
                    c.this.g();
                }
            }
        };
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeRecentContact(anonymousClass4, true);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeRecentContactDeleted(anonymousClass5, true);
    }

    private void a(RecentContact recentContact) {
        synchronized (this.a) {
            for (RecentContact recentContact2 : this.a) {
                if (recentContact2.getContactId().equals(recentContact.getContactId()) && recentContact2.getSessionType() == recentContact.getSessionType()) {
                    this.a.remove(recentContact2);
                    break;
                }
            }
        }
    }

    private static boolean a(int i) {
        for (SessionStatusEnum value : SessionStatusEnum.values()) {
            if (value.value() == i) {
                return true;
            }
        }
        return false;
    }

    private void b(final RecentContact recentContact) {
        synchronized (this.c) {
            for (final OnSessionListChangedListener onSessionListChangedListener : this.c) {
                e.b(new Runnable() {
                    public final void run() {
                        onSessionListChangedListener.onSessionDelete(recentContact.getContactId());
                    }
                });
            }
        }
    }

    private void b(final List<RecentContact> list) {
        synchronized (this.c) {
            for (final OnSessionListChangedListener onSessionListChangedListener : this.c) {
                e.b(new Runnable() {
                    public final void run() {
                        onSessionListChangedListener.onSessionUpdate(c.c(list));
                    }
                });
            }
        }
    }

    private static List<Session> c(List<RecentContact> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        return arrayList;
    }

    private void f() {
        synchronized (this.a) {
            int d = d();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                RecentContact recentContact = (RecentContact) it.next();
                it.remove();
                b(recentContact);
            }
            if (d > 0) {
                g();
            }
        }
    }

    private void g() {
        final int d = d();
        synchronized (this.b) {
            for (final UnreadCountChangeListener unreadCountChangeListener : this.b) {
                e.b(new Runnable() {
                    public final void run() {
                        unreadCountChangeListener.onUnreadCountChange(d);
                    }
                });
            }
        }
    }

    public final int a(String str) {
        synchronized (this.a) {
            for (RecentContact recentContact : this.a) {
                if (TextUtils.equals(str, recentContact.getContactId())) {
                    int unreadCount = recentContact.getUnreadCount();
                    return unreadCount;
                }
            }
            return 0;
        }
    }

    public final void a() {
        synchronized (this.a) {
            if (!this.a.isEmpty()) {
                f();
            }
            List queryRecentContactsBlock = ((MsgService) NIMClient.getService(MsgService.class)).queryRecentContactsBlock();
            if (!(queryRecentContactsBlock == null || queryRecentContactsBlock.isEmpty())) {
                this.a.addAll(queryRecentContactsBlock);
                b(queryRecentContactsBlock);
                g();
            }
        }
    }

    public final void a(final UnreadCountChangeListener unreadCountChangeListener, boolean z) {
        if (unreadCountChangeListener != null) {
            synchronized (this.b) {
                if (z) {
                    try {
                        if (!this.b.contains(unreadCountChangeListener)) {
                            this.b.add(unreadCountChangeListener);
                            e.b(new Runnable() {
                                public final void run() {
                                    unreadCountChangeListener.onUnreadCountChange(c.this.d());
                                }
                            });
                        }
                    } finally {
                    }
                }
                if (!z) {
                    this.b.remove(unreadCountChangeListener);
                }
            }
        }
    }

    public final void a(final OnSessionListChangedListener onSessionListChangedListener, boolean z) {
        if (onSessionListChangedListener != null) {
            synchronized (this.c) {
                if (z) {
                    try {
                        if (!this.c.contains(onSessionListChangedListener)) {
                            this.c.add(onSessionListChangedListener);
                            e.b(new Runnable() {
                                public final void run() {
                                    onSessionListChangedListener.onSessionUpdate(c.this.e());
                                }
                            });
                        }
                    } finally {
                    }
                }
                if (!z) {
                    this.c.remove(onSessionListChangedListener);
                }
            }
        }
    }

    public final void a(g gVar) {
        this.e = true;
        Map a = gVar.a();
        if (a != null && !a.isEmpty()) {
            synchronized (this.a) {
                List arrayList = new ArrayList(a.size());
                for (String str : a.keySet()) {
                    int intValue = ((Integer) a.get(str)).intValue();
                    if (a(intValue)) {
                        h hVar = null;
                        for (RecentContact recentContact : this.a) {
                            if (recentContact.getContactId().equals(str)) {
                                hVar = (h) recentContact;
                            }
                        }
                        if (hVar != null) {
                            hVar.a(SessionStatusEnum.valueOf(intValue));
                            arrayList.add(hVar);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    b(arrayList);
                }
            }
        }
    }

    public final void a(String str, SessionStatusEnum sessionStatusEnum) {
        h hVar;
        synchronized (this.a) {
            for (RecentContact recentContact : this.a) {
                if (recentContact.getContactId().equals(str)) {
                    hVar = (h) recentContact;
                    break;
                }
            }
            hVar = null;
        }
        if (!(hVar == null || hVar.getSessionStatus() == sessionStatusEnum)) {
            hVar.a(sessionStatusEnum);
            List arrayList = new ArrayList(1);
            arrayList.add(hVar);
            b(arrayList);
        }
    }

    public final void a(String str, boolean z) {
        RecentContact recentContact;
        synchronized (this.a) {
            for (RecentContact recentContact2 : this.a) {
                if (recentContact2.getContactId().equals(str)) {
                    break;
                }
            }
            recentContact2 = null;
        }
        if (recentContact2 != null) {
            ((MsgService) NIMClient.getService(MsgService.class)).deleteRecentContact(recentContact2);
            a(recentContact2);
            b(recentContact2);
            if (recentContact2.getUnreadCount() > 0) {
                g();
            }
            if (z) {
                ((MsgService) NIMClient.getService(MsgService.class)).clearChattingHistory(str, SessionTypeEnum.Ysf);
            }
        }
    }

    public final void b() {
        String c = b.c();
        Object obj = (TextUtils.isEmpty(c) || TextUtils.equals(c, "-1")) ? null : 1;
        if (obj != null) {
            if (!this.e || d.g().d()) {
                this.d.postDelayed(new Runnable() {
                    public final void run() {
                        com.qiyukf.unicorn.h.c.a(new i(), com.qiyukf.unicorn.h.c.a(), false);
                    }
                }, 1000);
            }
        }
    }

    public final boolean b(String str) {
        synchronized (this.a) {
            for (RecentContact contactId : this.a) {
                if (contactId.getContactId().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void c() {
        f();
    }

    public final int d() {
        int i;
        synchronized (this.a) {
            i = 0;
            for (RecentContact recentContact : this.a) {
                if (recentContact != null) {
                    i += recentContact.getUnreadCount();
                }
            }
        }
        return i;
    }

    public final List<Session> e() {
        List c;
        synchronized (this.a) {
            c = c(this.a);
        }
        return c;
    }
}
