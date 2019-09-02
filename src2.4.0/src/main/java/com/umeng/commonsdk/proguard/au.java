package com.umeng.commonsdk.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: TIOStreamTransport */
public class au extends aw {
    protected InputStream a = null;
    protected OutputStream b = null;

    protected au() {
    }

    public au(InputStream inputStream) {
        this.a = inputStream;
    }

    public au(InputStream inputStream, OutputStream outputStream) {
        this.a = inputStream;
        this.b = outputStream;
    }

    public au(OutputStream outputStream) {
        this.b = outputStream;
    }

    public int a(byte[] bArr, int i, int i2) throws ax {
        if (this.a == null) {
            throw new ax(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new ax(4);
        } catch (IOException e) {
            throw new ax(0, e);
        }
    }

    public boolean a() {
        return true;
    }

    public void b() throws ax {
    }

    public void b(byte[] bArr, int i, int i2) throws ax {
        if (this.b == null) {
            throw new ax(1, "Cannot write to null outputStream");
        }
        try {
            this.b.write(bArr, i, i2);
        } catch (IOException e) {
            throw new ax(0, e);
        }
    }

    public void c() {
        if (this.a != null) {
            try {
                this.a.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.a = null;
        }
        if (this.b != null) {
            try {
                this.b.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.b = null;
        }
    }

    public void d() throws ax {
        if (this.b == null) {
            throw new ax(1, "Cannot flush null outputStream");
        }
        try {
            this.b.flush();
        } catch (IOException e) {
            throw new ax(0, e);
        }
    }
}
