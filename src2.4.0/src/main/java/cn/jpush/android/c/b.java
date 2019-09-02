package cn.jpush.android.c;

final class b {
    public byte a;
    public String b;
    public long c;
    public byte[] d;
    public int e = 0;
    final /* synthetic */ a f;

    public b(a aVar, byte b, String str, long j, byte[] bArr) {
        this.f = aVar;
        this.a = b;
        this.b = str;
        this.c = j;
        this.d = bArr;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PluginPlatformRegIDBean{pluginPlatformType=");
        stringBuilder.append(this.a);
        stringBuilder.append(", regid='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", rid=");
        stringBuilder.append(this.c);
        stringBuilder.append(", retryCount=");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
