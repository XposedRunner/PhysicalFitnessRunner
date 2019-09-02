package com.qiyukf.unicorn.api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.basesdk.b.a.a.f;
import com.qiyukf.nimlib.k.c.b;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.api.msg.MessageService;
import com.qiyukf.unicorn.api.msg.OnPushMessageListener;
import com.qiyukf.unicorn.api.msg.UnicornMessage;
import com.qiyukf.unicorn.c;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.j.e;
import com.qiyukf.unicorn.ui.activity.ServiceMessageActivity;
import com.qiyukf.unicorn.ui.fragment.ServiceMessageFragment;

public class Unicorn {
    private static final String TAG = "QIYU";
    private static d delegate;

    public static void addPushMessageListener(OnPushMessageListener onPushMessageListener) {
        if (isInit()) {
            d.g().a(onPushMessageListener);
        }
    }

    public static void addUnreadCountChangeListener(final UnreadCountChangeListener unreadCountChangeListener, final boolean z) {
        e.a(new Runnable() {
            public final void run() {
                c h = d.h();
                if (h != null) {
                    h.a(unreadCountChangeListener, z);
                }
            }
        });
    }

    public static void clearCache() {
        e.a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    try {
                        f.a().b();
                        com.qiyukf.nimlib.k.c.c.c(b.TYPE_FILE);
                    } catch (Throwable th) {
                        a.d(Unicorn.TAG, "clear cache error", th);
                    }
                }
            }
        });
    }

    public static int getUnreadCount() {
        c h = d.h();
        return h != null ? h.d() : 0;
    }

    public static boolean init(Context context, String str, YSFOptions ySFOptions, @NonNull UnicornImageLoader unicornImageLoader) {
        delegate = d.a(context, str, ySFOptions, unicornImageLoader);
        return (com.qiyukf.nimlib.d.f() && delegate == null) ? false : true;
    }

    static boolean isInit() {
        return delegate != null && d.b();
    }

    @Deprecated
    public static boolean isServiceAvailable() {
        return true;
    }

    public static void logout() {
        e.a(new Runnable() {
            public final void run() {
                Unicorn.setUserInfo(null);
            }
        });
    }

    @Deprecated
    public static ServiceMessageFragment newServiceFragment(String str, ConsultSource consultSource) {
        return newServiceFragment(str, consultSource, null);
    }

    public static ServiceMessageFragment newServiceFragment(String str, ConsultSource consultSource, ViewGroup viewGroup) {
        if (delegate != null) {
            ServiceMessageFragment serviceMessageFragment = new ServiceMessageFragment();
            serviceMessageFragment.setArguments(str, consultSource, viewGroup);
            return serviceMessageFragment;
        }
        a.c(TAG, "QIYU is not init, please init first.");
        return null;
    }

    public static void openServiceActivity(final Context context, final String str, final ConsultSource consultSource) {
        e.a(new Runnable() {
            public final void run() {
                if (Unicorn.delegate != null) {
                    ServiceMessageActivity.start(context, str, consultSource);
                } else {
                    a.c(Unicorn.TAG, "QIYU is not init, please init first.");
                }
            }
        });
    }

    public static UnicornMessage queryLastMessage() {
        return isInit() ? ((MsgService) NIMClient.getService(MsgService.class)).queryLastMessage(com.qiyukf.unicorn.h.c.a(), SessionTypeEnum.Ysf) : null;
    }

    public static void removePushMessageListener(OnPushMessageListener onPushMessageListener) {
        if (isInit()) {
            d.g().b(onPushMessageListener);
        }
    }

    @Deprecated
    public static void sendProductMessage(ProductDetail productDetail) {
        MessageService.sendProductMessage(productDetail);
    }

    public static boolean setUserInfo(YSFUserInfo ySFUserInfo) {
        return setUserInfo(ySFUserInfo, null);
    }

    public static boolean setUserInfo(YSFUserInfo ySFUserInfo, RequestCallback<Void> requestCallback) {
        return isInit() && delegate.a(ySFUserInfo, (RequestCallback) requestCallback);
    }

    public static void toggleNotification(final boolean z) {
        e.a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    com.qiyukf.unicorn.b.b.b(z);
                }
            }
        });
    }

    public static void trackUserAccess(final String str, final String str2) {
        e.a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    Unicorn.delegate.a(str, str2);
                }
            }
        });
    }

    public static void updateOptions(final YSFOptions ySFOptions) {
        e.a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    Unicorn.delegate.a(ySFOptions);
                }
            }
        });
    }
}
