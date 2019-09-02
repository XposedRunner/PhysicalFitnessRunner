package net.sqlcipher;

public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public CursorIndexOutOfBoundsException(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index ");
        stringBuilder.append(i);
        stringBuilder.append(" requested, with a size of ");
        stringBuilder.append(i2);
        super(stringBuilder.toString());
    }

    public CursorIndexOutOfBoundsException(String str) {
        super(str);
    }
}
