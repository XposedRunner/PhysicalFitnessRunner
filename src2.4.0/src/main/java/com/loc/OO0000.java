package com.loc;

import android.content.Context;

/* compiled from: RollBackDynamic */
public final class OO0000 {
    static boolean O000000o = false;
    static boolean O00000Oo = false;
    static boolean O00000o = false;
    static boolean O00000o0 = false;
    static int O00000oO = 0;
    static int O00000oo = 0;
    static boolean O0000O0o = true;
    static boolean O0000OOo;

    public static void O000000o(Context context) {
        try {
            if (O00000oO(context) && !O000000o) {
                OO0000o.O000000o(context, "loc", "startMark", OO0000o.O00000Oo(context, "loc", "startMark", 0) + 1);
                O000000o = true;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "RollBackDynamic", "AddStartMark");
        }
    }

    private static void O000000o(Context context, int i) {
        try {
            if (O00000oO(context)) {
                OO0000o.O000000o(context, "loc", "endMark", i);
                OO0000o.O000000o(context, "loc", "startMark", i);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "RollBackDynamic", "resetMark");
        }
    }

    public static void O000000o(Context context, OO0Oo0 oO0Oo0) {
        if (!O00000o) {
            O00000o0 = O000OOo.O00000Oo(context, oO0Oo0);
            O00000o = true;
            if (!O00000o0 && O0o0000.O00000o()) {
                O000OOo.O000000o(context, "loc");
                ooO0Ooo.O000000o("dexrollbackstatistics", "RollBack because of version error");
            }
        }
    }

    public static void O000000o(Context context, String str, String str2) {
        try {
            O000OOo.O000000o(context, str);
            StringBuilder stringBuilder = new StringBuilder("RollBack because of ");
            stringBuilder.append(str2);
            ooO0Ooo.O000000o("dexrollbackstatistics", stringBuilder.toString());
        } catch (Throwable th) {
            O0o0000.O000000o(th, "RollBackDynamic", "rollBackDynamicFile");
        }
    }

    public static void O00000Oo(Context context) {
        try {
            if (O00000oO(context) && !O00000Oo) {
                OO0000o.O000000o(context, "loc", "endMark", OO0000o.O00000Oo(context, "loc", "endMark", 0) + 1);
                O00000Oo = true;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "RollBackDynamic", "AddEndMark");
        }
    }

    public static boolean O00000o(Context context) {
        try {
            return !O00000oO(context) ? false : OO0000o.O00000Oo(context, "loc", "isload", false);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "RollBackDynamic", "isLoad");
            return true;
        }
    }

    public static boolean O00000o0(Context context) {
        try {
            if (!O00000oO(context)) {
                return false;
            }
            if (O0000OOo) {
                return O0000O0o;
            }
            if (O00000oO == 0) {
                O00000oO = OO0000o.O00000Oo(context, "loc", "startMark", 0);
            }
            if (O00000oo == 0) {
                O00000oo = OO0000o.O00000Oo(context, "loc", "endMark", 0);
            }
            if (!(O000000o || O00000Oo)) {
                if (O00000oO < O00000oo) {
                    O000000o(context, 0);
                    O0000O0o = true;
                }
                if (O00000oO - O00000oo > 0 && O00000oO > 99) {
                    O000000o(context, 0);
                    O0000O0o = true;
                }
                if (O00000oO - O00000oo > 0 && O00000oO < 99) {
                    O000000o(context, -2);
                    O0000O0o = false;
                }
                if (O00000oO - O00000oo > 0 && O00000oo < 0) {
                    O000000o(context, "loc", "checkMark");
                    O0000O0o = false;
                }
            }
            OO0000o.O000000o(context, "loc", "isload", O0000O0o);
            O0000OOo = true;
            return O0000O0o;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "RollBackDynamic", "checkMark");
        }
    }

    private static boolean O00000oO(Context context) {
        if (!O00000o) {
            O000000o(context, O0o0000.O00000Oo());
        }
        return O00000o0;
    }
}
