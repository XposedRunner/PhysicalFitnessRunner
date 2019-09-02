package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import org.greenrobot.eventbus.O00000o0;

public class ErrorDialogManager {
    public static O00000o0<?> O000000o = null;
    protected static final String O00000Oo = "de.greenrobot.eventbus.error_dialog";
    public static final String O00000o = "de.greenrobot.eventbus.errordialog.title";
    protected static final String O00000o0 = "de.greenrobot.eventbus.error_dialog_manager";
    public static final String O00000oO = "de.greenrobot.eventbus.errordialog.message";
    public static final String O00000oo = "de.greenrobot.eventbus.errordialog.finish_after_dialog";
    public static final String O0000O0o = "de.greenrobot.eventbus.errordialog.icon_id";
    public static final String O0000OOo = "de.greenrobot.eventbus.errordialog.event_type_on_close";

    @TargetApi(11)
    public static class O000000o extends Fragment {
        protected boolean O000000o;
        protected Bundle O00000Oo;
        private Object O00000o;
        private O00000o0 O00000o0;

        public static void O000000o(Activity activity, Object obj, boolean z, Bundle bundle) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            O000000o o000000o = (O000000o) fragmentManager.findFragmentByTag(ErrorDialogManager.O00000o0);
            if (o000000o == null) {
                o000000o = new O000000o();
                fragmentManager.beginTransaction().add(o000000o, ErrorDialogManager.O00000o0).commit();
                fragmentManager.executePendingTransactions();
            }
            o000000o.O000000o = z;
            o000000o.O00000Oo = bundle;
            o000000o.O00000o = obj;
        }

        public void onEventMainThread(O0000OOo o0000OOo) {
            if (ErrorDialogManager.O00000Oo(this.O00000o, o0000OOo)) {
                ErrorDialogManager.O000000o(o0000OOo);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.O00000Oo);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                DialogFragment dialogFragment2 = (DialogFragment) ErrorDialogManager.O000000o.O000000o(o0000OOo, this.O000000o, this.O00000Oo);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, ErrorDialogManager.O00000Oo);
                }
            }
        }

        public void onPause() {
            this.O00000o0.O00000o0((Object) this);
            super.onPause();
        }

        public void onResume() {
            super.onResume();
            this.O00000o0 = ErrorDialogManager.O000000o.O000000o.O00000Oo();
            this.O00000o0.O000000o((Object) this);
        }
    }

    public static class SupportManagerFragment extends android.support.v4.app.Fragment {
        protected boolean O000000o;
        protected Bundle O00000Oo;
        private boolean O00000o;
        private O00000o0 O00000o0;
        private Object O00000oO;

        public static void O000000o(Activity activity, Object obj, boolean z, Bundle bundle) {
            android.support.v4.app.FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            SupportManagerFragment supportManagerFragment = (SupportManagerFragment) supportFragmentManager.findFragmentByTag(ErrorDialogManager.O00000o0);
            if (supportManagerFragment == null) {
                supportManagerFragment = new SupportManagerFragment();
                supportFragmentManager.beginTransaction().add(supportManagerFragment, ErrorDialogManager.O00000o0).commit();
                supportFragmentManager.executePendingTransactions();
            }
            supportManagerFragment.O000000o = z;
            supportManagerFragment.O00000Oo = bundle;
            supportManagerFragment.O00000oO = obj;
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.O00000o0 = ErrorDialogManager.O000000o.O000000o.O00000Oo();
            this.O00000o0.O000000o((Object) this);
            this.O00000o = true;
        }

        public void onEventMainThread(O0000OOo o0000OOo) {
            if (ErrorDialogManager.O00000Oo(this.O00000oO, o0000OOo)) {
                ErrorDialogManager.O000000o(o0000OOo);
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                android.support.v4.app.DialogFragment dialogFragment = (android.support.v4.app.DialogFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.O00000Oo);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                android.support.v4.app.DialogFragment dialogFragment2 = (android.support.v4.app.DialogFragment) ErrorDialogManager.O000000o.O000000o(o0000OOo, this.O000000o, this.O00000Oo);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, ErrorDialogManager.O00000Oo);
                }
            }
        }

        public void onPause() {
            this.O00000o0.O00000o0((Object) this);
            super.onPause();
        }

        public void onResume() {
            super.onResume();
            if (this.O00000o) {
                this.O00000o = false;
                return;
            }
            this.O00000o0 = ErrorDialogManager.O000000o.O000000o.O00000Oo();
            this.O00000o0.O000000o((Object) this);
        }
    }

    public static void O000000o(Activity activity) {
        O000000o(activity, false, null);
    }

    public static void O000000o(Activity activity, Object obj, boolean z, Bundle bundle) {
        if (O000000o == null) {
            throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
        } else if (O00000Oo(activity)) {
            SupportManagerFragment.O000000o(activity, obj, z, bundle);
        } else {
            O000000o.O000000o(activity, obj, z, bundle);
        }
    }

    public static void O000000o(Activity activity, boolean z) {
        O000000o(activity, z, null);
    }

    public static void O000000o(Activity activity, boolean z, Bundle bundle) {
        O000000o(activity, activity.getClass(), z, bundle);
    }

    protected static void O000000o(O0000OOo o0000OOo) {
        if (O000000o.O000000o.O00000oo) {
            String str = O000000o.O000000o.O0000O0o;
            if (str == null) {
                str = O00000o0.O000000o;
            }
            Log.i(str, "Error dialog manager received exception", o0000OOo.O000000o);
        }
    }

    private static boolean O00000Oo(Activity activity) {
        Class cls = activity.getClass();
        String name;
        do {
            cls = cls.getSuperclass();
            if (cls == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Illegal activity type: ");
                stringBuilder.append(activity.getClass());
                throw new RuntimeException(stringBuilder.toString());
            }
            name = cls.getName();
            if (name.equals("android.support.v4.app.FragmentActivity")) {
                return true;
            }
            if (name.startsWith("com.actionbarsherlock.app") && (name.endsWith(".SherlockActivity") || name.endsWith(".SherlockListActivity") || name.endsWith(".SherlockPreferenceActivity"))) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Please use SherlockFragmentActivity. Illegal activity: ");
                stringBuilder2.append(name);
                throw new RuntimeException(stringBuilder2.toString());
            }
        } while (!name.equals("android.app.Activity"));
        if (VERSION.SDK_INT >= 11) {
            return false;
        }
        throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
    }

    private static boolean O00000Oo(Object obj, O0000OOo o0000OOo) {
        if (o0000OOo != null) {
            Object O000000o = o0000OOo.O000000o();
            if (!(O000000o == null || O000000o.equals(obj))) {
                return false;
            }
        }
        return true;
    }
}
