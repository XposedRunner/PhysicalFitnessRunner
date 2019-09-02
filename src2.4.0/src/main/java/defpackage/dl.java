package defpackage;

import com.umeng.socialize.utils.O0000O0o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: WXAuthUtils */
/* renamed from: dl */
public class dl {
    public static String O000000o(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(readLine);
                    stringBuilder2.append("/n");
                    stringBuilder.append(stringBuilder2.toString());
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        O0000O0o.O000000o(e);
                    }
                }
            } catch (IOException e2) {
                O0000O0o.O000000o(e2);
                inputStream.close();
            } catch (Throwable e22) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    O0000O0o.O000000o(e3);
                }
                throw e22;
            }
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    public static String O000000o(String str) {
        String str2 = "";
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection == null) {
                return str2;
            }
            openConnection.connect();
            InputStream inputStream = openConnection.getInputStream();
            return inputStream == null ? str2 : dl.O000000o(inputStream);
        } catch (Exception e) {
            O0000O0o.O000000o(e);
            return "";
        }
    }

    private static String O00000Oo(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(readLine);
                str = stringBuilder.toString();
            } else {
                inputStream.close();
                return str;
            }
        }
    }
}
