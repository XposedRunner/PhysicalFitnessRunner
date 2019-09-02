package com.umeng.commonsdk.proguard;

import java.util.BitSet;

/* compiled from: TTupleProtocol */
public final class ao extends ac {

    /* compiled from: TTupleProtocol */
    public static class a implements ak {
        public ai a(aw awVar) {
            return new ao(awVar);
        }
    }

    public ao(aw awVar) {
        super(awVar);
    }

    public static BitSet a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if (((1 << (i % 8)) & bArr[(bArr.length - (i / 8)) - 1]) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    public static byte[] b(BitSet bitSet, int i) {
        byte[] bArr = new byte[((int) Math.ceil(((double) i) / 8.0d))];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int length = (bArr.length - (i2 / 8)) - 1;
                bArr[length] = (byte) ((1 << (i2 % 8)) | bArr[length]);
            }
        }
        return bArr;
    }

    public Class<? extends aq> D() {
        return at.class;
    }

    public void a(BitSet bitSet, int i) throws p {
        byte[] b = b(bitSet, i);
        for (byte a : b) {
            a(a);
        }
    }

    public BitSet b(int i) throws p {
        i = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = u();
        }
        return a(bArr);
    }
}
