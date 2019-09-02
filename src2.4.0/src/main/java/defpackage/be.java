package defpackage;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: ObjectSerializer */
/* renamed from: be */
public class be {
    public static Object O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ObjectInputStream(new ByteArrayInputStream(be.O00000Oo(str))).readObject();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String O000000o(Serializable serializable) {
        if (serializable == null) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return be.O000000o(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String O000000o(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append((char) (((bArr[i] >> 4) & 15) + 97));
            stringBuffer.append((char) ((bArr[i] & 15) + 97));
        }
        return stringBuffer.toString();
    }

    public static byte[] O00000Oo(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length(); i += 2) {
            int i2 = i / 2;
            bArr[i2] = (byte) ((str.charAt(i) - 97) << 4);
            bArr[i2] = (byte) (bArr[i2] + (str.charAt(i + 1) - 97));
        }
        return bArr;
    }
}
