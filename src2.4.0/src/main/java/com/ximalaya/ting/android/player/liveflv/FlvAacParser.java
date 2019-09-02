package com.ximalaya.ting.android.player.liveflv;

import com.ximalaya.ting.android.player.StaticConfig;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;
import java.util.Map.Entry;
import jp.co.cyberagent.android.gpuimage.O000000o;

public class FlvAacParser {
    static FileOutputStream outputStream;
    private int ADTS_HEAD_SIZE = 7;
    private int FLV_FILE_HEAD_SIZE = 9;
    private int FLV_HEAD_SIZE = 7;
    private int FLV_PREVIOUS_TAG_SIZE = 4;
    private int FLV_SIGN_HEAD_SIZE = 2;
    private int FLV_TAG_HEAD_SIZE = 11;
    private byte MASK_AUDIO = (byte) 4;
    private byte MASK_VIDEO = (byte) 1;
    private String TAG = "FLVPARSER";
    private int TYPE_AUDIO = 8;
    private int aacProfile;
    private int channelConfig;
    private DataInputStream dataInputStream = null;
    private boolean isFlvDataCallbackEnable = true;
    private int sampleRateIndex;
    int tagNum;

    public FlvAacParser(InputStream inputStream) throws IOException {
        int i = 0;
        this.tagNum = 0;
        this.dataInputStream = new DataInputStream(inputStream);
        if (((char) this.dataInputStream.readByte()) == 'F' && ((char) this.dataInputStream.readByte()) == 'L' && ((char) this.dataInputStream.readByte()) == 'V') {
            this.dataInputStream.readUnsignedByte();
            int readUnsignedByte = this.dataInputStream.readUnsignedByte();
            int i2 = this.MASK_VIDEO & readUnsignedByte;
            if ((readUnsignedByte & this.MASK_AUDIO) != 0) {
                i = 1;
            }
            if (i == 0) {
                throw new IOException("No Audio Stream");
            }
            readUnsignedByte = this.dataInputStream.readInt();
            if (readUnsignedByte != this.FLV_FILE_HEAD_SIZE) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unpexpected FLV header length: ");
                stringBuilder.append(readUnsignedByte);
                throw new IOException(stringBuilder.toString());
            }
            return;
        }
        throw new IOException("The file is not a FLV file.");
    }

    protected static void dumpHeaders(URLConnection uRLConnection) {
        for (Entry value : uRLConnection.getHeaderFields().entrySet()) {
            for (String str : (List) value.getValue()) {
            }
        }
    }

    private byte[] fillBuffer(int i) throws IOException {
        if (readAACHeader(i)) {
            return null;
        }
        i -= this.FLV_SIGN_HEAD_SIZE;
        byte[] bArr = new byte[(this.ADTS_HEAD_SIZE + i)];
        long writeBits = writeBits(writeBits(writeBits(0, 12, 4095), 3, 0), 1, 1);
        bArr[0] = (byte) ((int) (writeBits >> 8));
        bArr[1] = (byte) ((int) writeBits);
        int i2 = i + 7;
        long writeBits2 = writeBits(writeBits(writeBits(writeBits(writeBits(writeBits(0, 2, this.aacProfile - 1), 4, this.sampleRateIndex), 1, 0), 3, this.channelConfig), 4, 0), 2, i2 & 6144);
        bArr[2] = (byte) ((int) (writeBits2 >> 8));
        bArr[3] = (byte) ((int) writeBits2);
        writeBits = writeBits(writeBits(writeBits(0, 11, i2 & 2047), 11, 2047), 2, 0);
        bArr[4] = (byte) ((int) (writeBits >> 16));
        bArr[5] = (byte) ((int) (writeBits >> 8));
        bArr[6] = (byte) ((int) writeBits);
        this.dataInputStream.readFully(bArr, this.ADTS_HEAD_SIZE, i);
        return bArr;
    }

    public static void main(String[] strArr) {
        try {
            FlvAacParser flvAacParser = new FlvAacParser(new FileInputStream("/Users/roc/Desktop/ktv-101010.flv"));
            outputStream = new FileOutputStream(new File("/Users/roc/Desktop/ktv-101010-out2.data"));
            int i = 0;
            while (true) {
                try {
                    i = flvAacParser.readFrame(i).length;
                } catch (EOFException e) {
                    e.printStackTrace();
                    flvAacParser.close();
                    outputStream.close();
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean readAACHeader(int i) throws IOException {
        this.dataInputStream.readUnsignedByte();
        if (this.dataInputStream.readUnsignedByte() != 0) {
            return false;
        }
        int readByte = (((this.dataInputStream.readByte() & 255) * O000000o.O00000oO) + (this.dataInputStream.readByte() & 255)) << 16;
        if (i > 4) {
            this.dataInputStream.skipBytes(i - 4);
        }
        this.aacProfile = readBits(readByte, 5);
        i = readByte << 5;
        this.sampleRateIndex = readBits(i, 4);
        this.channelConfig = readBits(i << 4, 4);
        if (this.aacProfile < 0 || this.aacProfile > 3) {
            throw new IOException("Unsupported AAC profile.");
        } else if (this.sampleRateIndex > 12) {
            throw new IOException("Invalid AAC sample rate index.");
        } else if (this.channelConfig <= 6) {
            return true;
        } else {
            throw new IOException("Invalid AAC channel configuration.");
        }
    }

    private int readBits(int i, int i2) {
        return i >> (32 - i2);
    }

    private int readNext3Bytes() throws IOException {
        return ((this.dataInputStream.read() << 16) + (this.dataInputStream.read() << 8)) + this.dataInputStream.read();
    }

    public void close() throws IOException {
        if (this.dataInputStream != null) {
            this.dataInputStream.close();
        }
    }

    public byte[] readFrame(int i) throws IOException {
        int readInt = this.dataInputStream.readInt();
        if (i == 0 || readInt == ((i - this.FLV_HEAD_SIZE) + this.FLV_SIGN_HEAD_SIZE) + this.FLV_TAG_HEAD_SIZE) {
            i = this.dataInputStream.readUnsignedByte();
            while (i != this.TYPE_AUDIO) {
                readInt = readNext3Bytes();
                this.dataInputStream.skipBytes(3);
                this.dataInputStream.skipBytes(1);
                this.dataInputStream.skipBytes(3);
                if (readInt != 0) {
                    byte[] bArr = new byte[readInt];
                    this.dataInputStream.readFully(bArr);
                    if (this.isFlvDataCallbackEnable && StaticConfig.mIFlvDataCallback != null) {
                        StaticConfig.mIFlvDataCallback.dataOutput(i, bArr);
                    }
                }
                i = this.dataInputStream.readInt();
                if (i == 0 || i == this.FLV_TAG_HEAD_SIZE + readInt) {
                    i = this.dataInputStream.readUnsignedByte();
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("previousOtherTagSize not equal nextDataSize previousOtherTagSize:");
                    stringBuilder.append(i);
                    stringBuilder.append(" nextDataSize:");
                    stringBuilder.append(readInt);
                    throw new IOException(stringBuilder.toString());
                }
            }
            i = readNext3Bytes();
            this.dataInputStream.readInt();
            readNext3Bytes();
            if (i == 0) {
                return readFrame(0);
            }
            byte[] fillBuffer = fillBuffer(i);
            return fillBuffer == null ? readFrame(0) : fillBuffer;
        } else {
            throw new IOException("previousTagSize not equal previousReadBytes");
        }
    }

    public void setFlvDataCallbackIsEnable(boolean z) {
        this.isFlvDataCallbackEnable = z;
    }

    public long writeBits(long j, int i, int i2) {
        return (j << i) | (((long) i2) & (4294967295L >> (32 - i)));
    }
}
