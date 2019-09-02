package com.ximalaya.ting.android.player;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
    public LittleEndianDataInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public static int IntsfromBytes(byte b, byte b2, byte b3, byte b4) {
        return (((b << 24) | ((b2 & 255) << 16)) | ((b3 & 255) << 8)) | (b4 & 255);
    }

    public static long LongsfromBytes(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((((((((((long) b) & 255) << 56) | ((((long) b2) & 255) << 48)) | ((((long) b3) & 255) << 40)) | ((((long) b4) & 255) << 32)) | ((((long) b5) & 255) << 24)) | ((((long) b6) & 255) << 16)) | ((((long) b7) & 255) << 8)) | (((long) b8) & 255);
    }

    private byte readAndCheckByte() throws IOException, EOFException {
        int read = this.in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new EOFException();
    }

    public int read(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        return i3;
    }

    public boolean readBoolean() throws IOException {
        return readUnsignedByte() != 0;
    }

    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    public char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public void readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int read = read(inputStream, bArr, i, i2);
        if (read != i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("reached end of stream after reading ");
            stringBuilder.append(read);
            stringBuilder.append(" bytes; ");
            stringBuilder.append(i2);
            stringBuilder.append(" bytes expected");
            throw new EOFException(stringBuilder.toString());
        }
    }

    public void readFully(byte[] bArr) throws IOException {
        readFully(this.in, bArr, 0, bArr.length);
    }

    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        readFully(this, bArr, i, i2);
    }

    public int readInt() throws IOException {
        byte readAndCheckByte = readAndCheckByte();
        byte readAndCheckByte2 = readAndCheckByte();
        return IntsfromBytes(readAndCheckByte(), readAndCheckByte(), readAndCheckByte2, readAndCheckByte);
    }

    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    public long readLong() throws IOException {
        byte readAndCheckByte = readAndCheckByte();
        byte readAndCheckByte2 = readAndCheckByte();
        byte readAndCheckByte3 = readAndCheckByte();
        byte readAndCheckByte4 = readAndCheckByte();
        byte readAndCheckByte5 = readAndCheckByte();
        byte readAndCheckByte6 = readAndCheckByte();
        return LongsfromBytes(readAndCheckByte(), readAndCheckByte(), readAndCheckByte6, readAndCheckByte5, readAndCheckByte4, readAndCheckByte3, readAndCheckByte2, readAndCheckByte);
    }

    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    public String readUTF() throws IOException {
        return new DataInputStream(this.in).readUTF();
    }

    public int readUnsignedByte() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    public int readUnsignedShort() throws IOException {
        return IntsfromBytes((byte) 0, (byte) 0, readAndCheckByte(), readAndCheckByte());
    }

    public int skipBytes(int i) throws IOException {
        return (int) this.in.skip((long) i);
    }
}
