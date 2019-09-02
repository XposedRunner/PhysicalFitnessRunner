package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.f;
import com.umeng.commonsdk.proguard.s;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.b;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import org.json.JSONObject;

public class Envelope {
    private final int CODEX_ENCRYPT = 1;
    private final int CODEX_NORMAL = 0;
    private final byte[] SEED = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    private boolean encrypt = false;
    private byte[] identity = null;
    private String mAddress = null;
    private byte[] mChecksum = null;
    private byte[] mEntity = null;
    private byte[] mGuid = null;
    private int mLength = 0;
    private int mSerialNo = 0;
    private byte[] mSignature = null;
    private int mTimestamp = 0;
    private String mVersion = "1.0";

    private Envelope(byte[] bArr, String str, byte[] bArr2) throws Exception {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("entity is null or empty");
        }
        this.mAddress = str;
        this.mLength = bArr.length;
        this.mEntity = b.a(bArr);
        this.mTimestamp = (int) (System.currentTimeMillis() / 1000);
        this.identity = bArr2;
    }

    private byte[] genCheckSum() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DataHelper.toHexString(this.mSignature));
        stringBuilder.append(this.mSerialNo);
        stringBuilder.append(this.mTimestamp);
        stringBuilder.append(this.mLength);
        stringBuilder.append(DataHelper.toHexString(this.mGuid));
        return DataHelper.hash(stringBuilder.toString().getBytes());
    }

    public static Envelope genEncryptEnvelope(Context context, String str, byte[] bArr) {
        try {
            String mac = DeviceConfig.getMac(context);
            String deviceId = DeviceConfig.getDeviceId(context);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            String string = sharedPreferences.getString("signature", null);
            int i = sharedPreferences.getInt("serial", 1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(deviceId);
            stringBuilder.append(mac);
            Envelope envelope = new Envelope(bArr, str, stringBuilder.toString().getBytes());
            envelope.setEncrypt(true);
            envelope.setSignature(string);
            envelope.setSerialNumber(i);
            envelope.seal();
            sharedPreferences.edit().putInt("serial", i + 1).putString("signature", envelope.getSignature()).commit();
            envelope.export(context);
            return envelope;
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    public static Envelope genEnvelope(Context context, String str, byte[] bArr) {
        try {
            String mac = DeviceConfig.getMac(context);
            String deviceId = DeviceConfig.getDeviceId(context);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            String string = sharedPreferences.getString("signature", null);
            int i = sharedPreferences.getInt("serial", 1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(deviceId);
            stringBuilder.append(mac);
            Envelope envelope = new Envelope(bArr, str, stringBuilder.toString().getBytes());
            envelope.setSignature(string);
            envelope.setSerialNumber(i);
            envelope.seal();
            sharedPreferences.edit().putInt("serial", i + 1).putString("signature", envelope.getSignature()).commit();
            envelope.export(context);
            return envelope;
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    private byte[] genGuid(byte[] bArr, int i) {
        byte[] hash = DataHelper.hash(this.identity);
        byte[] hash2 = DataHelper.hash(this.mEntity);
        int i2 = 0;
        int length = hash.length;
        byte[] bArr2 = new byte[(length * 2)];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 2;
            bArr2[i4] = hash2[i3];
            bArr2[i4 + 1] = hash[i3];
        }
        for (int i5 = 0; i5 < 2; i5++) {
            bArr2[i5] = bArr[i5];
            bArr2[(bArr2.length - i5) - 1] = bArr[(bArr.length - i5) - 1];
        }
        bArr = new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) (i >>> 24)};
        while (i2 < bArr2.length) {
            bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i2 % 4]);
            i2++;
        }
        return bArr2;
    }

    private byte[] genSignature() {
        return genGuid(this.SEED, (int) (System.currentTimeMillis() / 1000));
    }

    public static String getSignature(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
        return sharedPreferences == null ? null : sharedPreferences.getString("signature", null);
    }

    public void export(Context context) {
        String str = this.mAddress;
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "umid", null);
        String toHexString = DataHelper.toHexString(this.mSignature);
        byte[] bArr = new byte[16];
        System.arraycopy(this.mSignature, 2, bArr, 0, 16);
        String toHexString2 = DataHelper.toHexString(DataHelper.hash(bArr));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", str);
            if (imprintProperty != null) {
                jSONObject.put("umid", imprintProperty);
            }
            jSONObject.put("signature", toHexString);
            jSONObject.put("checksum", toHexString2);
            File file = new File(context.getFilesDir(), ".umeng");
            if (!file.exists()) {
                file.mkdir();
            }
            HelperUtils.writeFile(new File(file, "exchangeIdentity.json"), jSONObject.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appkey", str);
            jSONObject2.put("channel", UMUtils.getChannel(context));
            if (imprintProperty != null) {
                jSONObject2.put("umid", HelperUtils.getUmengMD5(imprintProperty));
            }
            HelperUtils.writeFile(new File(context.getFilesDir(), "exid.dat"), jSONObject2.toString());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public String getSignature() {
        return DataHelper.toHexString(this.mSignature);
    }

    public void seal() {
        if (this.mSignature == null) {
            this.mSignature = genSignature();
        }
        if (this.encrypt) {
            byte[] bArr = new byte[16];
            try {
                System.arraycopy(this.mSignature, 1, bArr, 0, 16);
                this.mEntity = DataHelper.encrypt(this.mEntity, bArr);
            } catch (Exception unused) {
            }
        }
        this.mGuid = genGuid(this.mSignature, this.mTimestamp);
        this.mChecksum = genCheckSum();
    }

    public void setEncrypt(boolean z) {
        this.encrypt = z;
    }

    public void setSerialNumber(int i) {
        this.mSerialNo = i;
    }

    public void setSignature(String str) {
        this.mSignature = DataHelper.reverseHexString(str);
    }

    public byte[] toBinary() {
        f fVar = new f();
        fVar.a(this.mVersion);
        fVar.b(this.mAddress);
        fVar.c(DataHelper.toHexString(this.mSignature));
        fVar.a(this.mSerialNo);
        fVar.b(this.mTimestamp);
        fVar.c(this.mLength);
        fVar.a(this.mEntity);
        fVar.d(this.encrypt);
        fVar.d(DataHelper.toHexString(this.mGuid));
        fVar.e(DataHelper.toHexString(this.mChecksum));
        try {
            return new s().a(fVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("version : %s\n", new Object[]{this.mVersion}));
        stringBuilder.append(String.format("address : %s\n", new Object[]{this.mAddress}));
        stringBuilder.append(String.format("signature : %s\n", new Object[]{DataHelper.toHexString(this.mSignature)}));
        stringBuilder.append(String.format("serial : %s\n", new Object[]{Integer.valueOf(this.mSerialNo)}));
        stringBuilder.append(String.format("timestamp : %d\n", new Object[]{Integer.valueOf(this.mTimestamp)}));
        stringBuilder.append(String.format("length : %d\n", new Object[]{Integer.valueOf(this.mLength)}));
        stringBuilder.append(String.format("guid : %s\n", new Object[]{DataHelper.toHexString(this.mGuid)}));
        stringBuilder.append(String.format("checksum : %s ", new Object[]{DataHelper.toHexString(this.mChecksum)}));
        stringBuilder.append(String.format("codex : %d", new Object[]{Integer.valueOf(this.encrypt)}));
        return stringBuilder.toString();
    }
}
