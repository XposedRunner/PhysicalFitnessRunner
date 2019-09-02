package com.geetest.mobinfo;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Process;
import android.provider.Settings.Secure;
import com.bangcle.andJni.JniLib1557756502;
import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONObject;

/* compiled from: DeveloperMode */
public class n {
    public static JSONObject a(Context context, String str, String str2, String str3, String str4, String str5) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, str4, str5, Integer.valueOf(138));
    }

    private static boolean a() {
        try {
            return Debug.isDebuggerConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean a(Context context) {
        try {
            boolean z = Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0;
            if (z && VERSION.SDK_INT > 22) {
                z = false;
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean b() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("/proc/");
            stringBuilder.append(Process.myPid());
            stringBuilder.append("/status");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(stringBuilder.toString()));
            Object obj = "";
            String readLine;
            do {
                readLine = bufferedReader.readLine();
                if (readLine.contains("TracerPid")) {
                    obj = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                    break;
                }
            } while (readLine != null);
            bufferedReader.close();
            return "0".equals(obj) ^ 1;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean b(Context context) {
        return JniLib1557756502.cZ(context, Integer.valueOf(139));
    }

    private static boolean c(Context context) {
        return JniLib1557756502.cZ(context, Integer.valueOf(140));
    }
}
