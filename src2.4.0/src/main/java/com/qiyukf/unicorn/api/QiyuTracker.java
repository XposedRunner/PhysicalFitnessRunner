package com.qiyukf.unicorn.api;

import android.app.Activity;
import android.app.Fragment;
import com.qiyukf.unicorn.i.b;
import org.json.JSONObject;
import s.h.e.l.l.C;

public class QiyuTracker {

    /* renamed from: com.qiyukf.unicorn.api.QiyuTracker$10 */
    static class AnonymousClass10 implements Runnable {
        final /* synthetic */ Fragment val$fragment;
        final /* synthetic */ JSONObject val$jsonObject;
        final /* synthetic */ String val$title;

        AnonymousClass10(Fragment fragment, String str, JSONObject jSONObject) {
            this.val$fragment = fragment;
            this.val$title = str;
            this.val$jsonObject = jSONObject;
        }

        public final void run() {
            if (Unicorn.isInit()) {
                b.a().a(this.val$fragment, this.val$title, this.val$jsonObject);
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.QiyuTracker$11 */
    static class AnonymousClass11 implements Runnable {
        final /* synthetic */ android.support.v4.app.Fragment val$fragment;
        final /* synthetic */ JSONObject val$jsonObject;
        final /* synthetic */ String val$title;

        AnonymousClass11(android.support.v4.app.Fragment fragment, String str, JSONObject jSONObject) {
            this.val$fragment = fragment;
            this.val$title = str;
            this.val$jsonObject = jSONObject;
        }

        public final void run() {
            if (Unicorn.isInit()) {
                b.a().a(this.val$fragment, this.val$title, this.val$jsonObject);
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.QiyuTracker$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Activity val$activity;

        AnonymousClass1(Activity activity) {
            this.val$activity = activity;
        }

        public final void run() {
            if (Unicorn.isInit()) {
                b.a().a(this.val$activity);
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.QiyuTracker$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Activity val$activity;

        AnonymousClass2(Activity activity) {
            this.val$activity = activity;
        }

        public final void run() {
            if (Unicorn.isInit()) {
                b.a().b(this.val$activity);
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.QiyuTracker$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ CharSequence val$title;

        AnonymousClass3(Activity activity, CharSequence charSequence) {
            this.val$activity = activity;
            this.val$title = charSequence;
        }

        public final void run() {
            if (Unicorn.isInit()) {
                b.a().a(this.val$activity, this.val$title);
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.QiyuTracker$4 */
    static class AnonymousClass4 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ CharSequence val$title;

        AnonymousClass4(Activity activity, CharSequence charSequence) {
            this.val$activity = activity;
            this.val$title = charSequence;
        }

        public final void run() {
            if (Unicorn.isInit()) {
                b.a().b(this.val$activity, this.val$title);
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.QiyuTracker$5 */
    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ Fragment val$fragment;
        final /* synthetic */ CharSequence val$title;

        AnonymousClass5(Fragment fragment, CharSequence charSequence) {
            this.val$fragment = fragment;
            this.val$title = charSequence;
        }

        public final void run() {
            if (Unicorn.isInit()) {
                b.a().a(this.val$fragment, this.val$title);
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.QiyuTracker$6 */
    static class AnonymousClass6 implements Runnable {
        final /* synthetic */ Fragment val$fragment;
        final /* synthetic */ CharSequence val$title;

        AnonymousClass6(Fragment fragment, CharSequence charSequence) {
            this.val$fragment = fragment;
            this.val$title = charSequence;
        }

        public final void run() {
            if (Unicorn.isInit()) {
                b.a().b(this.val$fragment, this.val$title);
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.QiyuTracker$7 */
    static class AnonymousClass7 implements Runnable {
        final /* synthetic */ android.support.v4.app.Fragment val$fragment;
        final /* synthetic */ CharSequence val$title;

        AnonymousClass7(android.support.v4.app.Fragment fragment, CharSequence charSequence) {
            this.val$fragment = fragment;
            this.val$title = charSequence;
        }

        public final void run() {
            if (Unicorn.isInit()) {
                b.a().a(this.val$fragment, this.val$title);
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.QiyuTracker$8 */
    static class AnonymousClass8 implements Runnable {
        final /* synthetic */ android.support.v4.app.Fragment val$fragment;
        final /* synthetic */ CharSequence val$title;

        AnonymousClass8(android.support.v4.app.Fragment fragment, CharSequence charSequence) {
            this.val$fragment = fragment;
            this.val$title = charSequence;
        }

        public final void run() {
            if (Unicorn.isInit()) {
                b.a().b(this.val$fragment, this.val$title);
            }
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.QiyuTracker$9 */
    static class AnonymousClass9 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ JSONObject val$jsonObject;
        final /* synthetic */ String val$title;

        AnonymousClass9(Activity activity, String str, JSONObject jSONObject) {
            this.val$activity = activity;
            this.val$title = str;
            this.val$jsonObject = jSONObject;
        }

        public final void run() {
            if (Unicorn.isInit()) {
                b.a().a(this.val$activity, this.val$title, this.val$jsonObject);
            }
        }
    }

    static {
        C.i(30);
    }

    public static native void onBehavior(Activity activity, String str, JSONObject jSONObject);

    public static native void onBehavior(Fragment fragment, String str, JSONObject jSONObject);

    public static native void onBehavior(android.support.v4.app.Fragment fragment, String str, JSONObject jSONObject);

    public static native void onPause(Activity activity);

    public static native void onPause(Activity activity, CharSequence charSequence);

    public static native void onPause(Fragment fragment, CharSequence charSequence);

    public static native void onPause(android.support.v4.app.Fragment fragment, CharSequence charSequence);

    public static native void onResume(Activity activity);

    public static native void onResume(Activity activity, CharSequence charSequence);

    public static native void onResume(Fragment fragment, CharSequence charSequence);

    public static native void onResume(android.support.v4.app.Fragment fragment, CharSequence charSequence);
}
