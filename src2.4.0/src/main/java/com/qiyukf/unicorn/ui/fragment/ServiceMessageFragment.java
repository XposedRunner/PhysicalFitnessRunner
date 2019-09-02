package com.qiyukf.unicorn.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.qiyukf.nim.uikit.session.fragment.MessageFragment;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.nimlib.sdk.auth.AuthServiceObserver;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.ConsultSource;
import com.qiyukf.unicorn.api.ProductDetail;
import com.qiyukf.unicorn.api.lifecycle.SessionLifeCycleListener;
import com.qiyukf.unicorn.api.lifecycle.SessionLifeCycleOptions;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.e.b;
import com.qiyukf.unicorn.f.a.d.j;
import com.qiyukf.unicorn.f.a.d.k;
import com.qiyukf.unicorn.f.a.e;
import com.qiyukf.unicorn.f.a.e.f;
import com.qiyukf.unicorn.ui.a.a;
import com.qiyukf.unicorn.ui.evaluate.c;
import com.qiyukf.unicorn.widget.a.g;
import java.util.List;
import s.h.e.l.l.C;

public class ServiceMessageFragment extends MessageFragment {
    private static long i;
    private int j = 0;
    private a k;
    private ViewGroup l;
    private SessionLifeCycleListener m;
    private c n;
    private ConsultSource o;
    private SessionLifeCycleOptions p;
    private b q;
    private boolean r = false;
    private boolean s = false;
    private d.a t = new d.a() {
        public final void a() {
            d.g().a(ServiceMessageFragment.this.o);
            ServiceMessageFragment.this.a(true);
            ServiceMessageFragment.c(ServiceMessageFragment.this);
            ServiceMessageFragment.d(ServiceMessageFragment.this);
        }
    };
    private Observer<CustomNotification> u = new Observer<CustomNotification>() {
        public final /* synthetic */ void onEvent(Object obj) {
            CustomNotification customNotification = (CustomNotification) obj;
            if (TextUtils.equals(ServiceMessageFragment.this.f, customNotification.getSessionId()) && customNotification.getSessionType() == SessionTypeEnum.Ysf) {
                ServiceMessageFragment.this.a(customNotification);
            }
        }
    };
    private Observer<StatusCode> v = new Observer<StatusCode>() {
        public final /* synthetic */ void onEvent(Object obj) {
            StatusCode statusCode = (StatusCode) obj;
            if (ServiceMessageFragment.this.j != 7) {
                if (statusCode == StatusCode.LOGINED) {
                    if (ServiceMessageFragment.this.s) {
                        ServiceMessageFragment.l(ServiceMessageFragment.this);
                    } else if (ServiceMessageFragment.this.isResumed() || ServiceMessageFragment.this.j == -1) {
                        ServiceMessageFragment.this.a(0);
                    }
                } else if (statusCode.shouldReLogin() || statusCode.wontAutoLogin()) {
                    ServiceMessageFragment.this.j = -1;
                    ServiceMessageFragment.this.b(null);
                }
            }
        }
    };

    /* renamed from: com.qiyukf.unicorn.ui.fragment.ServiceMessageFragment$9 */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] a = new int[com.qiyukf.unicorn.ui.a.b.a.a().length];

        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Missing block: B:13:?, code skipped:
            return;
     */
        static {
            /*
            r0 = com.qiyukf.unicorn.ui.a.b.a.a();
            r0 = r0.length;
            r0 = new int[r0];
            a = r0;
            r0 = 1;
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0011 }
            r2 = com.qiyukf.unicorn.ui.a.b.a.b;	 Catch:{ NoSuchFieldError -> 0x0011 }
            r2 = r2 - r0;
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0011 }
        L_0x0011:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0019 }
            r2 = com.qiyukf.unicorn.ui.a.b.a.c;	 Catch:{ NoSuchFieldError -> 0x0019 }
            r2 = r2 - r0;
            r3 = 2;
            r1[r2] = r3;	 Catch:{ NoSuchFieldError -> 0x0019 }
        L_0x0019:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0021 }
            r2 = com.qiyukf.unicorn.ui.a.b.a.d;	 Catch:{ NoSuchFieldError -> 0x0021 }
            r2 = r2 - r0;
            r3 = 3;
            r1[r2] = r3;	 Catch:{ NoSuchFieldError -> 0x0021 }
        L_0x0021:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0029 }
            r2 = com.qiyukf.unicorn.ui.a.b.a.e;	 Catch:{ NoSuchFieldError -> 0x0029 }
            r2 = r2 - r0;
            r3 = 4;
            r1[r2] = r3;	 Catch:{ NoSuchFieldError -> 0x0029 }
        L_0x0029:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0031 }
            r2 = com.qiyukf.unicorn.ui.a.b.a.a;	 Catch:{ NoSuchFieldError -> 0x0031 }
            r2 = r2 - r0;
            r0 = 5;
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0031 }
        L_0x0031:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.ui.fragment.ServiceMessageFragment$AnonymousClass9.<clinit>():void");
        }
    }

    static {
        C.i(31);
    }

    private void a(final ProductDetail productDetail) {
        this.r = true;
        d.g().a(this.f, productDetail.clone());
        a(new Runnable() {
            public final void run() {
                ServiceMessageFragment.a(ServiceMessageFragment.this, productDetail);
            }
        }, 250);
    }

    private void a(com.qiyukf.unicorn.f.a.d.a aVar) {
        int a = aVar.a();
        if (a == 200) {
            this.j = d.g().e(this.f) == 1 ? 6 : 1;
            if (this.o.productDetail != null && this.o.productDetail.valid() && d.g().c(this.f) != i && (this.j == 1 || (this.j == 6 && this.o.isSendProductonRobot))) {
                ProductDetail clone;
                if (this.j == 6 && this.o.productDetail.isSendByUser()) {
                    clone = this.o.productDetail.clone();
                    if (clone != null) {
                        clone.setSendByUser(false);
                    }
                    i = d.g().c(this.f);
                } else {
                    clone = this.o.productDetail;
                }
                a(clone);
                i = d.g().c(this.f);
            }
        } else {
            a = a == SecExceptionCode.SEC_ERROR_STA_STORE_INVALID_PARAM ? 3 : a == SecExceptionCode.SEC_ERROR_STA_STORE_NO_DATA_FILE ? aVar.r() ? 10 : 4 : a == SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE ? 5 : a == SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE_DATA ? 9 : -1;
            this.j = a;
        }
        b(aVar.d());
    }

    private void a(boolean z) {
        com.qiyukf.unicorn.h.d g;
        Context activity;
        if (z) {
            d.g().a(new com.qiyukf.unicorn.h.d.a() {
                public final void a() {
                    ServiceMessageFragment.this.j = -1;
                    ServiceMessageFragment.this.b(null);
                }

                public final void a(String str) {
                    if (TextUtils.equals(ServiceMessageFragment.this.f, str)) {
                        ServiceMessageFragment.this.n.b();
                    }
                }

                public final void a(String str, b bVar) {
                    if (TextUtils.equals(ServiceMessageFragment.this.f, str)) {
                        ServiceMessageFragment.this.j = 2;
                        ServiceMessageFragment.this.q = bVar;
                        ServiceMessageFragment.this.b(null);
                    }
                }
            });
            g = d.g();
            activity = getActivity();
        } else {
            activity = null;
            d.g().a(null);
            g = d.g();
        }
        g.a(activity);
        d.g().a(this.f, z);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.u, z);
        ((AuthServiceObserver) NIMClient.getService(AuthServiceObserver.class)).observeOnlineStatus(this.v, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a A:{RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Missing block: B:7:0x0044, code skipped:
            if (com.qiyukf.unicorn.d.g().a(r11.f, false, null, r12) != false) goto L_0x0067;
     */
    /* JADX WARNING: Missing block: B:16:0x0065, code skipped:
            if (r11.j != 3) goto L_0x0067;
     */
    private boolean a(int r12) {
        /*
        r11 = this;
        r0 = r11.j;
        r1 = r11.j;
        r2 = 0;
        r3 = 1;
        r4 = 7;
        r5 = 0;
        r6 = 2;
        if (r1 != r4) goto L_0x0047;
    L_0x000b:
        r1 = r11.o;
        r7 = r1.staffId;
        r9 = 0;
        r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r1 > 0) goto L_0x001d;
    L_0x0015:
        r1 = r11.o;
        r7 = r1.groupId;
        r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r1 <= 0) goto L_0x0069;
    L_0x001d:
        com.qiyukf.unicorn.d.g();
        r1 = r11.f;
        r1 = com.qiyukf.unicorn.h.d.i(r1);
        r7 = r1.getAttachment();
        r7 = (com.qiyukf.unicorn.f.a.d.o) r7;
        r7.e();
        r7 = com.qiyukf.nimlib.sdk.msg.MsgService.class;
        r7 = com.qiyukf.nimlib.sdk.NIMClient.getService(r7);
        r7 = (com.qiyukf.nimlib.sdk.msg.MsgService) r7;
        r7.updateIMMessageStatus(r1, r3);
        r1 = com.qiyukf.unicorn.d.g();
        r7 = r11.f;
        r12 = r1.a(r7, r5, r2, r12);
        if (r12 == 0) goto L_0x0069;
    L_0x0046:
        goto L_0x0067;
    L_0x0047:
        r1 = com.qiyukf.unicorn.d.g();
        r7 = r11.f;
        r8 = r11.q;
        r9 = r11.q;
        if (r9 != 0) goto L_0x0054;
    L_0x0053:
        goto L_0x0058;
    L_0x0054:
        r12 = r11.q;
        r12 = r12.a;
    L_0x0058:
        r12 = r1.a(r7, r5, r8, r12);
        if (r12 == 0) goto L_0x0069;
    L_0x005e:
        r12 = r11.j;
        if (r12 == r6) goto L_0x0069;
    L_0x0062:
        r12 = r11.j;
        r1 = 3;
        if (r12 == r1) goto L_0x0069;
    L_0x0067:
        r11.j = r6;
    L_0x0069:
        r12 = r11.j;
        if (r12 == r0) goto L_0x0070;
    L_0x006d:
        r11.b(r2);
    L_0x0070:
        r12 = r11.j;
        if (r12 == r6) goto L_0x007a;
    L_0x0074:
        r12 = r11.j;
        if (r12 != r4) goto L_0x0079;
    L_0x0078:
        return r3;
    L_0x0079:
        return r5;
    L_0x007a:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.ui.fragment.ServiceMessageFragment.a(int):boolean");
    }

    private void b() {
        if (getActivity() != null) {
            com.qiyukf.unicorn.e.d b = d.g().b(this.f);
            if (b != null && d()) {
                CharSequence charSequence;
                this.b.setVisibility(0);
                TextView textView = this.b;
                if (b == null) {
                    charSequence = null;
                } else {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    if (b.c) {
                        charSequence = getString(R.string.ysf_service_in_queue, Integer.valueOf(b.b));
                    } else {
                        charSequence = getString(R.string.ysf_service_in_queue_hide_length);
                    }
                    spannableStringBuilder.append(charSequence);
                    SpannableString spannableString = new SpannableString(getString(R.string.ysf_service_quit_queue));
                    spannableString.setSpan(new ClickableSpan() {
                        public final void onClick(View view) {
                            ServiceMessageFragment.a(ServiceMessageFragment.this, false);
                        }
                    }, 0, spannableString.length(), 33);
                    spannableStringBuilder.append(" ").append(spannableString);
                    charSequence = spannableStringBuilder;
                }
                textView.setText(charSequence);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x025c  */
    private void b(final java.lang.String r12) {
        /*
        r11 = this;
        r0 = r11.getActivity();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r11.getActivity();
        r1 = r11.getArguments();
        r2 = "title";
        r1 = r1.getString(r2);
        r0.setTitle(r1);
        r0 = r11.b;
        r1 = android.text.method.LinkMovementMethod.getInstance();
        r0.setMovementMethod(r1);
        r0 = r11.b;
        r1 = 0;
        r0.setOnClickListener(r1);
        r0 = r11.b;
        r2 = 0;
        r0.setCompoundDrawablesWithIntrinsicBounds(r2, r2, r2, r2);
        r0 = r11.j;
        r3 = 9;
        r4 = 2;
        r5 = 3;
        r6 = 8;
        if (r0 != r4) goto L_0x0047;
    L_0x0037:
        r12 = r11.b;
        r12.setVisibility(r6);
        r12 = r11.getActivity();
        r0 = com.qiyukf.unicorn.R.string.ysf_requesting_staff;
        r12.setTitle(r0);
        goto L_0x00eb;
    L_0x0047:
        r0 = r11.j;
        if (r0 == r5) goto L_0x00b8;
    L_0x004b:
        r0 = r11.j;
        if (r0 != r3) goto L_0x0050;
    L_0x004f:
        goto L_0x00b8;
    L_0x0050:
        r12 = r11.j;
        r0 = -1;
        if (r12 != r0) goto L_0x0099;
    L_0x0055:
        r12 = r11.b;
        r12.setVisibility(r2);
        r12 = r11.getContext();
        r12 = com.qiyukf.basesdk.c.d.c.b(r12);
        if (r12 == 0) goto L_0x0091;
    L_0x0064:
        r12 = r11.b;
        r0 = new android.text.SpannableStringBuilder;
        r7 = com.qiyukf.unicorn.R.string.ysf_some_error_happened;
        r7 = r11.getString(r7);
        r0.<init>(r7);
        r7 = new android.text.SpannableString;
        r8 = com.qiyukf.unicorn.R.string.ysf_retry_connect;
        r8 = r11.getString(r8);
        r7.<init>(r8);
        r8 = new com.qiyukf.unicorn.ui.fragment.ServiceMessageFragment$12;
        r8.<init>();
        r9 = r7.length();
        r10 = 33;
        r7.setSpan(r8, r2, r9, r10);
        r0.append(r7);
        r12.setText(r0);
        goto L_0x00eb;
    L_0x0091:
        r12 = r11.b;
        r0 = com.qiyukf.unicorn.R.string.ysf_network_error;
    L_0x0095:
        r12.setText(r0);
        goto L_0x00eb;
    L_0x0099:
        r12 = r11.d();
        if (r12 == 0) goto L_0x00a3;
    L_0x009f:
        r11.b();
        goto L_0x00eb;
    L_0x00a3:
        r12 = r11.j;
        r0 = 5;
        if (r12 != r0) goto L_0x00b2;
    L_0x00a8:
        r12 = r11.b;
        r12.setVisibility(r2);
        r12 = r11.b;
        r0 = com.qiyukf.unicorn.R.string.ysf_service_product_invalid;
        goto L_0x0095;
    L_0x00b2:
        r12 = r11.b;
        r12.setVisibility(r6);
        goto L_0x00eb;
    L_0x00b8:
        r0 = r11.b;
        r0.setVisibility(r2);
        r0 = r11.b;
        r0.setMovementMethod(r1);
        r0 = r11.b;
        r7 = com.qiyukf.unicorn.R.drawable.ysf_ic_leave_message_arrow;
        r0.setCompoundDrawablesWithIntrinsicBounds(r2, r2, r7, r2);
        r0 = r11.b;
        r7 = new com.qiyukf.unicorn.ui.fragment.ServiceMessageFragment$10;
        r7.<init>(r12);
        r0.setOnClickListener(r7);
        r0 = r11.j;
        if (r0 != r5) goto L_0x00da;
    L_0x00d7:
        r0 = com.qiyukf.unicorn.R.string.ysf_no_staff;
        goto L_0x00dc;
    L_0x00da:
        r0 = com.qiyukf.unicorn.R.string.ysf_no_staff_disabled;
    L_0x00dc:
        r7 = r11.b;
        r8 = android.text.TextUtils.isEmpty(r12);
        if (r8 == 0) goto L_0x00e8;
    L_0x00e4:
        r12 = r11.getString(r0);
    L_0x00e8:
        r7.setText(r12);
    L_0x00eb:
        r12 = new java.util.ArrayList;
        r12.<init>();
        r0 = r11.o;
        r0 = r0.shopEntrance;
        r7 = 1;
        if (r0 == 0) goto L_0x0111;
    L_0x00f7:
        r0 = new com.qiyukf.unicorn.ui.a.b;
        r8 = com.qiyukf.unicorn.ui.a.b.a.b;
        r9 = r11.o;
        r9 = r9.shopEntrance;
        r9 = r9.getName();
        r10 = r11.o;
        r10 = r10.shopEntrance;
        r10 = r10.getLogo();
        r0.<init>(r8, r9, r10, r7);
        r12.add(r0);
    L_0x0111:
        r0 = r11.j;
        if (r0 == r7) goto L_0x011d;
    L_0x0115:
        r0 = r11.j;
        if (r0 == 0) goto L_0x011d;
    L_0x0119:
        r0 = r11.j;
        if (r0 != r6) goto L_0x0131;
    L_0x011d:
        r0 = com.qiyukf.unicorn.b.a();
        r0 = r0.b();
        if (r0 != 0) goto L_0x0131;
    L_0x0127:
        r0 = new com.qiyukf.unicorn.ui.a.b;
        r8 = com.qiyukf.unicorn.ui.a.b.a.d;
        r0.<init>(r8);
        r12.add(r0);
    L_0x0131:
        r0 = r11.j;
        r8 = 6;
        if (r0 != r8) goto L_0x0144;
    L_0x0136:
        r0 = com.qiyukf.unicorn.d.g();
        r9 = r11.f;
        r0 = r0.p(r9);
        if (r0 == 0) goto L_0x0144;
    L_0x0142:
        r0 = r7;
        goto L_0x0145;
    L_0x0144:
        r0 = r2;
    L_0x0145:
        if (r0 == 0) goto L_0x0151;
    L_0x0147:
        r0 = new com.qiyukf.unicorn.ui.a.b;
        r9 = com.qiyukf.unicorn.ui.a.b.a.c;
        r0.<init>(r9);
        r12.add(r0);
    L_0x0151:
        r0 = r11.j;
        if (r0 != r7) goto L_0x0168;
    L_0x0155:
        r0 = r11.p;
        r0 = r0.canCloseSession();
        if (r0 == 0) goto L_0x0168;
    L_0x015d:
        r0 = new com.qiyukf.unicorn.ui.a.b;
        r9 = com.qiyukf.unicorn.ui.a.b.a.e;
        r0.<init>(r9, r7);
    L_0x0164:
        r12.add(r0);
        goto L_0x0192;
    L_0x0168:
        r0 = r11.d();
        if (r0 == 0) goto L_0x017e;
    L_0x016e:
        r0 = r11.p;
        r0 = r0.canQuitQueue();
        if (r0 == 0) goto L_0x017e;
    L_0x0176:
        r0 = new com.qiyukf.unicorn.ui.a.b;
        r9 = com.qiyukf.unicorn.ui.a.b.a.e;
        r0.<init>(r9, r7);
        goto L_0x0164;
    L_0x017e:
        r0 = r11.j;
        if (r0 != r6) goto L_0x0192;
    L_0x0182:
        r0 = r11.p;
        r0 = r0.canCloseSession();
        if (r0 == 0) goto L_0x0192;
    L_0x018a:
        r0 = new com.qiyukf.unicorn.ui.a.b;
        r9 = com.qiyukf.unicorn.ui.a.b.a.e;
        r0.<init>(r9, r2);
        goto L_0x0164;
    L_0x0192:
        r0 = r11.k;
        r0.a(r12);
        r12 = r11.j;
        r0 = 10;
        if (r12 == r4) goto L_0x01cb;
    L_0x019d:
        r12 = r11.c;
        r4 = r11.j;
        if (r4 != r3) goto L_0x01a5;
    L_0x01a3:
        r3 = r7;
        goto L_0x01a6;
    L_0x01a5:
        r3 = r2;
    L_0x01a6:
        r12.b(r3);
        r12 = r11.c;
        r3 = r11.j;
        if (r3 == r8) goto L_0x01b6;
    L_0x01af:
        r3 = r11.j;
        if (r3 != r0) goto L_0x01b4;
    L_0x01b3:
        goto L_0x01b6;
    L_0x01b4:
        r3 = r2;
        goto L_0x01b7;
    L_0x01b6:
        r3 = r7;
    L_0x01b7:
        r12.a(r3);
        r12 = r11.d;
        r3 = r11.j;
        if (r3 == r8) goto L_0x01c7;
    L_0x01c0:
        r3 = r11.j;
        if (r3 != r0) goto L_0x01c5;
    L_0x01c4:
        goto L_0x01c7;
    L_0x01c5:
        r3 = r2;
        goto L_0x01c8;
    L_0x01c7:
        r3 = r7;
    L_0x01c8:
        r12.a(r3);
    L_0x01cb:
        r12 = r11.j;
        if (r12 == r8) goto L_0x01ea;
    L_0x01cf:
        r12 = r11.j;
        if (r12 != r0) goto L_0x01d4;
    L_0x01d3:
        goto L_0x01ea;
    L_0x01d4:
        r12 = r11.j;
        if (r12 == r7) goto L_0x01e3;
    L_0x01d8:
        r12 = r11.j;
        if (r12 != r5) goto L_0x01dd;
    L_0x01dc:
        goto L_0x01e3;
    L_0x01dd:
        r12 = r11.c;
        r12.a(r1);
        goto L_0x01f9;
    L_0x01e3:
        r12 = r11.c;
        r0 = r11.o;
        r0 = r0.quickEntryList;
        goto L_0x01f6;
    L_0x01ea:
        r12 = r11.c;
        r0 = com.qiyukf.unicorn.d.g();
        r1 = r11.f;
        r0 = r0.o(r1);
    L_0x01f6:
        r12.a(r0);
    L_0x01f9:
        r12 = r11.n;
        r0 = r11.j;
        if (r0 == r7) goto L_0x020a;
    L_0x01ff:
        r0 = r11.j;
        if (r0 == 0) goto L_0x020a;
    L_0x0203:
        r0 = r11.j;
        if (r0 != r6) goto L_0x0208;
    L_0x0207:
        goto L_0x020a;
    L_0x0208:
        r0 = r2;
        goto L_0x020b;
    L_0x020a:
        r0 = r7;
    L_0x020b:
        r12.a(r0);
        r12 = r11.r;
        if (r12 != 0) goto L_0x027e;
    L_0x0212:
        r12 = r11.o;
        r12 = r12.productDetail;
        if (r12 == 0) goto L_0x027e;
    L_0x0218:
        r12 = r11.o;
        r12 = r12.productDetail;
        r12 = r12.valid();
        if (r12 == 0) goto L_0x027e;
    L_0x0222:
        r12 = r11.o;
        r12 = r12.productDetail;
        r12 = r12.isAlwaysSend();
        if (r12 == 0) goto L_0x027e;
    L_0x022c:
        r12 = r11.o;
        r12 = r12.productDetail;
        r0 = com.qiyukf.unicorn.d.g();
        r1 = r11.f;
        r0 = r0.n(r1);
        r12 = r12.equals(r0);
        if (r12 == 0) goto L_0x024a;
    L_0x0240:
        r12 = r11.o;
        r12 = r12.productDetail;
        r12 = r12.isSendByUser();
        if (r12 == 0) goto L_0x027e;
    L_0x024a:
        r12 = r11.j;
        if (r12 == r7) goto L_0x0258;
    L_0x024e:
        r12 = r11.j;
        if (r12 != r8) goto L_0x027e;
    L_0x0252:
        r12 = r11.o;
        r12 = r12.isSendProductonRobot;
        if (r12 == 0) goto L_0x027e;
    L_0x0258:
        r12 = r11.j;
        if (r12 != r8) goto L_0x0277;
    L_0x025c:
        r12 = r11.o;
        r12 = r12.productDetail;
        r12 = r12.isSendByUser();
        if (r12 == 0) goto L_0x0277;
    L_0x0266:
        r12 = r11.o;
        r12 = r12.productDetail;
        r12 = r12.clone();
        if (r12 == 0) goto L_0x0276;
    L_0x0270:
        r12.setSendByUser(r2);
        r11.a(r12);
    L_0x0276:
        return;
    L_0x0277:
        r12 = r11.o;
        r12 = r12.productDetail;
        r11.a(r12);
    L_0x027e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.ui.fragment.ServiceMessageFragment.b(java.lang.String):void");
    }

    private void c() {
        String p = com.qiyukf.unicorn.b.b.p();
        if (!TextUtils.isEmpty(p)) {
            com.qiyukf.unicorn.b.b.n(null);
            for (final String str : TextUtils.split(p, ",")) {
                com.qiyukf.unicorn.h.c.a(new f(str, 2), this.f, false).setCallback(new RequestCallbackWrapper<Void>() {
                    public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                        if (i != 200) {
                            com.qiyukf.unicorn.b.b.n(str);
                        }
                    }
                });
            }
        }
    }

    static /* synthetic */ void c(ServiceMessageFragment serviceMessageFragment) {
        int i;
        com.qiyukf.unicorn.h.d g = d.g();
        if (com.qiyukf.unicorn.h.d.i(serviceMessageFragment.f) != null) {
            i = 7;
        } else if (g.a(serviceMessageFragment.f) > 0) {
            i = g.b(serviceMessageFragment.f).f ? 10 : 4;
        } else if (g.g(serviceMessageFragment.f)) {
            i = 2;
        } else if (g.e(serviceMessageFragment.f) == 1) {
            i = 6;
        } else {
            if (g.c(serviceMessageFragment.f) > 0) {
                serviceMessageFragment.j = 1;
            }
            serviceMessageFragment.b(null);
        }
        serviceMessageFragment.j = i;
        serviceMessageFragment.b(null);
    }

    static /* synthetic */ void d(ServiceMessageFragment serviceMessageFragment) {
        int i = 1;
        ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(1);
        if (d.a().i()) {
            serviceMessageFragment.c();
            if (d.h().a(serviceMessageFragment.f) > 0) {
                i = 0;
            }
            if (i != 0) {
                serviceMessageFragment.a(0);
            }
            return;
        }
        serviceMessageFragment.s = true;
        serviceMessageFragment.j = 2;
        serviceMessageFragment.b(null);
    }

    private boolean d() {
        return this.j == 4 || this.j == 10;
    }

    static /* synthetic */ void l(ServiceMessageFragment serviceMessageFragment) {
        serviceMessageFragment.s = false;
        if (TextUtils.isEmpty(serviceMessageFragment.f)) {
            serviceMessageFragment.a(com.qiyukf.unicorn.b.b.c());
            serviceMessageFragment.n.a(serviceMessageFragment.f);
            d.g().c().a((Fragment) serviceMessageFragment, serviceMessageFragment.f);
            Bundle arguments = serviceMessageFragment.getArguments();
            if (arguments != null) {
                arguments.putString("account", serviceMessageFragment.f);
            }
        }
        serviceMessageFragment.a();
        d.g().a(serviceMessageFragment.f, false, serviceMessageFragment.q, serviceMessageFragment.q == null ? 0 : serviceMessageFragment.q.a);
    }

    static /* synthetic */ void o(ServiceMessageFragment serviceMessageFragment) {
        if (serviceMessageFragment.j == 1 || serviceMessageFragment.d()) {
            final boolean d = serviceMessageFragment.d();
            g.a(serviceMessageFragment.getContext(), serviceMessageFragment.getString(d ? R.string.ysf_dialog_quit_queue : R.string.ysf_dialog_close_session), true, new g.a() {
                public final void a(int i) {
                    if (i == 0) {
                        if (!d && ServiceMessageFragment.this.j == 1) {
                            ServiceMessageFragment.a(ServiceMessageFragment.this, d.g().c(ServiceMessageFragment.this.f));
                        } else if (d && ServiceMessageFragment.this.d()) {
                            ServiceMessageFragment.a(ServiceMessageFragment.this, true);
                        }
                    }
                }
            });
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(CustomNotification customNotification) {
        e attachment = customNotification.getAttachment();
        if (attachment != null) {
            int cmdId = attachment.getCmdId();
            if (cmdId == 2) {
                final com.qiyukf.unicorn.f.a.d.a aVar = (com.qiyukf.unicorn.f.a.d.a) attachment;
                if (aVar.a() == 200) {
                    a(aVar);
                } else {
                    a(new Runnable() {
                        public final void run() {
                            ServiceMessageFragment.this.a(aVar);
                        }
                    }, 1000);
                }
                this.q = null;
            } else if (cmdId == 6) {
                this.j = 8;
                if (((k) attachment).b() != 1) {
                    this.n.c();
                }
                b(null);
            } else if (cmdId == 15) {
                com.qiyukf.unicorn.f.a.d.f fVar = (com.qiyukf.unicorn.f.a.d.f) attachment;
                if (this.j != 1) {
                    cmdId = fVar.b();
                    if (cmdId == 200) {
                        b();
                    } else if (cmdId == SecExceptionCode.SEC_ERROR_STA_INVALID_PARAM) {
                        this.j = 1;
                        b(null);
                    } else if (cmdId == SecExceptionCode.SEC_ERROR_STA_DATA_FILE_MISMATCH) {
                        this.j = 3;
                        b(fVar.d());
                    } else if (cmdId == SecExceptionCode.SEC_ERROR_STA_NO_DATA_FILE) {
                        this.j = 9;
                        b(fVar.d());
                    } else {
                        this.j = -1;
                        b(null);
                    }
                }
            } else if (cmdId == 25) {
                this.c.a((com.qiyukf.unicorn.f.a.d.d) attachment);
            } else if (cmdId == 90) {
                this.j = 7;
                b(null);
            } else if (cmdId == 211) {
                j jVar = (j) attachment;
                if (!(jVar.a() == null || jVar.a().size() == 0)) {
                    d.g().a(this.f, jVar.a());
                }
                this.c.a(jVar.a());
            }
        }
    }

    public native boolean isAllowSendMessage(boolean z);

    public native void onActivityCreated(Bundle bundle);

    public native boolean onBackPressed();

    public native void onDestroy();

    public void onPause() {
        super.onPause();
        try {
            d.g().c().a();
        } catch (NullPointerException e) {
            com.qiyukf.basesdk.a.a.b("NullPointerException", "邀请评价发生异常", e);
        }
    }

    public void onReceiveMessage(List<IMMessage> list) {
        int i = 0;
        IMMessage iMMessage = (IMMessage) list.get(0);
        if (iMMessage.getSessionType() == SessionTypeEnum.Ysf && TextUtils.equals(this.f, iMMessage.getSessionId())) {
            i = 1;
        }
        if (i != 0) {
            c();
            if (com.qiyukf.unicorn.b.b.i(this.f) != -1) {
                this.n.b();
            }
        }
    }

    public void onResume() {
        super.onResume();
        try {
            d.g().c().a((Fragment) this, this.f);
        } catch (NullPointerException e) {
            com.qiyukf.basesdk.a.a.b("NullPointerException", "邀请评价发生异常", e);
        }
    }

    public native void setArguments(String str, ConsultSource consultSource, ViewGroup viewGroup);
}
