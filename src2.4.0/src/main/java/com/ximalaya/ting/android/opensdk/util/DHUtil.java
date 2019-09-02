package com.ximalaya.ting.android.opensdk.util;

import android.content.Context;
import com.ximalaya.ting.android.opensdk.httputil.XmSecretKeyUtil;
import com.ximalaya.ting.android.opensdk.util.dh.DhKeyPair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;

public class DHUtil {
    protected static final BigInteger generator = new BigInteger("9ce2e29b2be0ebfd7b3c58cfb0ee4e9004e65367c069f358effaf2a8e334891d20ff158111f54b50244d682b720f964c4d6234079d480fcc2ce66e0fa3edeb642b0700cd62c4c02a483c92d2361e41a23706332bd3a8aaed07fe53bba376cefbce12fa46265ad5ea5210a3d96f5260f7b6f29588f61a4798e40bdc75bbb2b457", 16);
    private static DhKeyPair mClientKeyPair;
    protected static final BigInteger prime = new BigInteger("f460d489678f7ec903293517e9193fd156c821b3e2b027c644eb96aedc85a54c971468cea07df15e9ecda0e2ca062161add38b9aa8aefcbd7ac18cd05a6bfb1147aaa516a6df694ee2cb5164607c618df7c65e75e274ff49632c34ce18da534ee32cfc42279e0f4c29101e89033130058d7f77744dddaca541094f19c394d485", 16);

    public static void deleteSaveFile(Context context) {
        try {
            new File(context.getFilesDir(), XmSecretKeyUtil.CLIENT_TXT).deleteOnExit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSecret(String str, DhKeyPair dhKeyPair) {
        return new BigInteger(str).modPow(dhKeyPair.getPrivateKey(), prime).toString().toUpperCase();
    }

    public static DhKeyPair initPartyAKey() {
        Context context = Utils.getContext();
        if (mClientKeyPair != null) {
            return mClientKeyPair;
        }
        DhKeyPair dhKeyPair;
        try {
            File file = new File(context.getFilesDir(), XmSecretKeyUtil.CLIENT_TXT);
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DHUtil.initPartyAKey   ");
            stringBuilder.append(file);
            printStream.println(stringBuilder.toString());
            if (file.exists()) {
                dhKeyPair = (DhKeyPair) new ObjectInputStream(new FileInputStream(file)).readObject();
                if (dhKeyPair != null) {
                    mClientKeyPair = dhKeyPair;
                    return dhKeyPair;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        dhKeyPair = new DhKeyPair();
        BigInteger bigInteger = new BigInteger(128, new SecureRandom());
        dhKeyPair.setPublicKey(generator.modPow(bigInteger, prime));
        dhKeyPair.setPrivateKey(bigInteger);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(context.getFilesDir(), XmSecretKeyUtil.CLIENT_TXT)));
            objectOutputStream.writeObject(dhKeyPair);
            objectOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        mClientKeyPair = dhKeyPair;
        return dhKeyPair;
    }
}
