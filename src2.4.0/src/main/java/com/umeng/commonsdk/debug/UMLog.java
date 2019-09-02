package com.umeng.commonsdk.debug;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.commonsdk.UMConfigure;
import org.json.JSONArray;
import org.json.JSONObject;

public class UMLog {
    private static final String AQ = "├───────────────────解决方案─────────────────────────────────────────────────────────────────────────────";
    private static final String BOTTOM_BORDER = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final char BOTTOM_LEFT_CORNER = '└';
    private static final String DOUBLE_DIVIDER = "────────────────────────────────────────────────────────";
    private static final String DOUBLE_DIVIDER_AQ = "───────────────────问题─────────────────────";
    private static final char HORIZONTAL_LINE = '│';
    private static final String INDENT = "     ";
    private static final int JSON_INDENT = 2;
    private static final int KEYLENGTH = 10;
    private static final String MIDDLE_BORDER = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final char MIDDLE_CORNER = '├';
    private static final String SINGLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final String SINGLE_DIVIDER_AQ = "───────────────────解决方案─────────────────────";
    private static final String TAG = "UMLog";
    private static final String TOP_BORDER = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final String TOP_BORDER_AQ = "┌───────────────────问题─────────────────────────────────────────────────────────────────────────────";
    private static final char TOP_LEFT_CORNER = '┌';

    public static void aq(int i, String str, String str2) {
        try {
            if (UMConfigure.isDebugLog()) {
                UInterface logger = getLogger(i);
                logger.log(TAG, TOP_BORDER_AQ);
                String str3 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("│     ");
                stringBuilder.append(str);
                logger.log(str3, stringBuilder.toString());
                logger.log(TAG, AQ);
                str = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("│     ");
                stringBuilder2.append(str2);
                logger.log(str, stringBuilder2.toString());
                logger.log(TAG, BOTTOM_BORDER);
            }
        } catch (Exception unused) {
        }
    }

    public static void aq(String str, int i, String str2) {
        aq(null, str, i, str2);
    }

    public static void aq(String str, int i, String str2, String str3) {
        try {
            if (UMConfigure.isDebugLog()) {
                UInterface logger = getLogger(i);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UMLog_");
                stringBuilder.append(str);
                str = stringBuilder.toString();
                logger.log(str, TOP_BORDER_AQ);
                stringBuilder = new StringBuilder();
                stringBuilder.append("│     ");
                stringBuilder.append(str2);
                logger.log(str, stringBuilder.toString());
                logger.log(str, AQ);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("│     ");
                stringBuilder2.append(str3);
                logger.log(str, stringBuilder2.toString());
                logger.log(str, BOTTOM_BORDER);
            }
        } catch (Exception unused) {
        }
    }

    public static void aq(String str, int i, String str2, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        aq(null, str, i, str2, strArr, strArr2, strArr3, strArr4);
    }

    public static void aq(String str, String str2, int i, String str3) {
        aq(str, str2, i, str3, null, null, null, null);
    }

    public static void aq(String str, String str2, int i, String str3, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        try {
            if (UMConfigure.isDebugLog()) {
                if (TextUtils.isEmpty(str)) {
                    str = TAG;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("UMLog_");
                    stringBuilder.append(str);
                    str = stringBuilder.toString();
                }
                if (!(TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3))) {
                    String[] split = str2.split(str3);
                    if (split != null && split.length >= 2) {
                        if (strArr != null && strArr.length > 0 && strArr2 != null && strArr2.length > 0) {
                            int i2 = 0;
                            while (i2 < strArr.length && i2 < strArr2.length) {
                                split[0] = split[0].replace(strArr[i2], strArr2[i2]);
                                i2++;
                            }
                        }
                        if (strArr3 != null && strArr3.length > 0 && strArr4 != null && strArr4.length > 0) {
                            int i3 = 0;
                            while (i3 < strArr3.length && i3 < strArr4.length) {
                                split[1] = split[1].replace(strArr3[i3], strArr4[i3]);
                                i3++;
                            }
                        }
                        UInterface logger = getLogger(i);
                        logger.log(str, TOP_BORDER_AQ);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("│     ");
                        stringBuilder2.append(split[0]);
                        logger.log(str, stringBuilder2.toString());
                        logger.log(str, AQ);
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("│     ");
                        stringBuilder3.append(split[1]);
                        logger.log(str, stringBuilder3.toString());
                        logger.log(str, BOTTOM_BORDER);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void bundle(int i, Bundle bundle) {
        bundle(null, i, bundle);
    }

    public static void bundle(String str, int i, Bundle bundle) {
        try {
            if (UMConfigure.isDebugLog()) {
                if (TextUtils.isEmpty(str)) {
                    str = TAG;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("UMLog_");
                    stringBuilder.append(str);
                    str = stringBuilder.toString();
                }
                if (bundle != null) {
                    UInterface logger = getLogger(i);
                    logger.log(str, TOP_BORDER);
                    logger.log(str, "│key│value");
                    logger.log(str, MIDDLE_BORDER);
                    for (String str2 : bundle.keySet()) {
                        if (!(TextUtils.isEmpty(str2) || bundle.get(str2) == null)) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(HORIZONTAL_LINE);
                            stringBuilder2.append(str2);
                            stringBuilder2.append(HORIZONTAL_LINE);
                            stringBuilder2.append(bundle.get(str2).toString());
                            logger.log(str, stringBuilder2.toString());
                            logger.log(str, MIDDLE_BORDER);
                        }
                    }
                    logger.log(str, BOTTOM_BORDER);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static UInterface getLogger(int i) {
        switch (i) {
            case 0:
                return new E();
            case 1:
                return new W();
            case 2:
                return new I();
            case 3:
                return new D();
            default:
                return new D();
        }
    }

    public static void jsonArry(String str, JSONArray jSONArray) {
        try {
            if (UMConfigure.isDebugLog()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UMLog_");
                stringBuilder.append(str);
                Log.e(stringBuilder.toString(), jSONArray.toString(2));
            }
        } catch (Exception unused) {
        }
    }

    public static void jsonArry(JSONArray jSONArray) {
        try {
            if (UMConfigure.isDebugLog()) {
                Log.e(TAG, jSONArray.toString(2));
            }
        } catch (Exception unused) {
        }
    }

    public static void jsonObject(String str, JSONObject jSONObject) {
        try {
            if (UMConfigure.isDebugLog()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UMLog_");
                stringBuilder.append(str);
                Log.e(stringBuilder.toString(), jSONObject.toString(2));
            }
        } catch (Exception unused) {
        }
    }

    public static void jsonObject(JSONObject jSONObject) {
        try {
            if (UMConfigure.isDebugLog()) {
                Log.e(TAG, jSONObject.toString(2));
            }
        } catch (Exception unused) {
        }
    }

    public static void mutlInfo(int i, String... strArr) {
        try {
            if (UMConfigure.isDebugLog()) {
                int length = strArr.length;
                UInterface logger = getLogger(i);
                int i2 = 0;
                if (length == 1) {
                    logger.log(TAG, strArr[0]);
                } else if (length >= 2) {
                    logger.log(TAG, TOP_BORDER);
                    while (i2 < length) {
                        String str = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("│     ");
                        stringBuilder.append(strArr[i2]);
                        logger.log(str, stringBuilder.toString());
                        if (i2 != length - 1) {
                            logger.log(TAG, MIDDLE_BORDER);
                        }
                        i2++;
                    }
                    logger.log(TAG, BOTTOM_BORDER);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void mutlInfo(String str, int i, String str2) {
        mutlInfo(null, str, i, str2);
    }

    public static void mutlInfo(String str, int i, String str2, String[] strArr, String[] strArr2) {
        mutlInfo(null, str, i, str2, strArr, strArr2);
    }

    public static void mutlInfo(String str, int i, String... strArr) {
        try {
            if (UMConfigure.isDebugLog()) {
                int length = strArr.length;
                UInterface logger = getLogger(i);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UMLog_");
                stringBuilder.append(str);
                str = stringBuilder.toString();
                int i2 = 0;
                if (length == 1) {
                    logger.log(str, strArr[0]);
                } else if (length >= 2) {
                    logger.log(str, TOP_BORDER);
                    while (i2 < length) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("│     ");
                        stringBuilder2.append(strArr[i2]);
                        logger.log(str, stringBuilder2.toString());
                        if (i2 != length - 1) {
                            logger.log(str, MIDDLE_BORDER);
                        }
                        i2++;
                    }
                    logger.log(str, BOTTOM_BORDER);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void mutlInfo(String str, String str2, int i, String str3) {
        mutlInfo(str, str2, i, str3, null, null);
    }

    public static void mutlInfo(String str, String str2, int i, String str3, String[] strArr, String[] strArr2) {
        try {
            if (UMConfigure.isDebugLog()) {
                if (TextUtils.isEmpty(str)) {
                    str = TAG;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("UMLog_");
                    stringBuilder.append(str);
                    str = stringBuilder.toString();
                }
                if (!TextUtils.isEmpty(str2)) {
                    int i2 = 0;
                    if (strArr != null && strArr.length > 0 && strArr2 != null && strArr2.length > 0) {
                        String str4 = str2;
                        int i3 = 0;
                        while (i3 < strArr.length && i3 < strArr2.length) {
                            str4 = str4.replace(strArr[i3], strArr2[i3]);
                            i3++;
                        }
                        str2 = str4;
                    }
                    UInterface logger = getLogger(i);
                    if (TextUtils.isEmpty(str3)) {
                        logger.log(str, str2);
                    } else {
                        String[] split = str2.split(str3);
                        if (split != null) {
                            logger.log(str, TOP_BORDER);
                            while (i2 < split.length) {
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("│     ");
                                stringBuilder2.append(split[i2]);
                                logger.log(str, stringBuilder2.toString());
                                if (i2 != split.length - 1) {
                                    logger.log(str, MIDDLE_BORDER);
                                }
                                i2++;
                            }
                            logger.log(str, BOTTOM_BORDER);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
