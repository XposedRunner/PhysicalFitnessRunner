package org.jsoup.helper;

import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import defpackage.bt;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.codec.CharEncoding;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.parser.TokenQueue;

public class HttpConnection implements Connection {
    public static final String O000000o = "Content-Encoding";
    public static final String O00000Oo = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36";
    private static final String O00000o = "Content-Type";
    private static final String O00000o0 = "User-Agent";
    private static final String O00000oO = "multipart/form-data";
    private static final String O00000oo = "application/x-www-form-urlencoded";
    private static final int O0000O0o = 307;
    private org.jsoup.Connection.Request O0000OOo = new Request();
    private org.jsoup.Connection.Response O0000Oo0 = new Response();

    private static abstract class Base<T extends org.jsoup.Connection.Base> implements org.jsoup.Connection.Base<T> {
        URL O000000o;
        Method O00000Oo;
        Map<String, String> O00000o;
        Map<String, String> O00000o0;

        private Base() {
            this.O00000o0 = new LinkedHashMap();
            this.O00000o = new LinkedHashMap();
        }

        /* JADX WARNING: Missing block: B:13:0x0026, code skipped:
            if ((((r8[1] & 255) == 187 ? 1 : 0) & ((r8[2] & 255) == 191 ? 1 : 0)) != 0) goto L_0x002a;
     */
        private static boolean O000000o(byte[] r8) {
            /*
            r0 = 3;
            r1 = 0;
            r2 = 1;
            r3 = r8.length;
            if (r3 < r0) goto L_0x0029;
        L_0x0006:
            r3 = r8[r1];
            r3 = r3 & 255;
            r4 = 239; // 0xef float:3.35E-43 double:1.18E-321;
            if (r3 != r4) goto L_0x0029;
        L_0x000e:
            r3 = r8[r2];
            r3 = r3 & 255;
            r4 = 187; // 0xbb float:2.62E-43 double:9.24E-322;
            if (r3 != r4) goto L_0x0018;
        L_0x0016:
            r3 = r2;
            goto L_0x0019;
        L_0x0018:
            r3 = r1;
        L_0x0019:
            r4 = 2;
            r4 = r8[r4];
            r4 = r4 & 255;
            r5 = 191; // 0xbf float:2.68E-43 double:9.44E-322;
            if (r4 != r5) goto L_0x0024;
        L_0x0022:
            r4 = r2;
            goto L_0x0025;
        L_0x0024:
            r4 = r1;
        L_0x0025:
            r3 = r3 & r4;
            if (r3 == 0) goto L_0x0029;
        L_0x0028:
            goto L_0x002a;
        L_0x0029:
            r0 = r1;
        L_0x002a:
            r3 = r8.length;
        L_0x002b:
            if (r0 >= r3) goto L_0x005d;
        L_0x002d:
            r4 = r8[r0];
            r5 = r4 & 128;
            if (r5 != 0) goto L_0x0034;
        L_0x0033:
            goto L_0x005a;
        L_0x0034:
            r5 = r4 & 224;
            r6 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
            if (r5 != r6) goto L_0x003d;
        L_0x003a:
            r4 = r0 + 1;
            goto L_0x004e;
        L_0x003d:
            r5 = r4 & 240;
            r7 = 224; // 0xe0 float:3.14E-43 double:1.107E-321;
            if (r5 != r7) goto L_0x0046;
        L_0x0043:
            r4 = r0 + 2;
            goto L_0x004e;
        L_0x0046:
            r4 = r4 & 248;
            r5 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
            if (r4 != r5) goto L_0x005c;
        L_0x004c:
            r4 = r0 + 3;
        L_0x004e:
            if (r0 >= r4) goto L_0x005a;
        L_0x0050:
            r0 = r0 + 1;
            r5 = r8[r0];
            r5 = r5 & r6;
            r7 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            if (r5 == r7) goto L_0x004e;
        L_0x0059:
            return r1;
        L_0x005a:
            r0 = r0 + r2;
            goto L_0x002b;
        L_0x005c:
            return r1;
        L_0x005d:
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection$Base.O000000o(byte[]):boolean");
        }

        private static String O0000O0o(String str) {
            try {
                byte[] bytes = str.getBytes(CharEncoding.ISO_8859_1);
                return !O000000o(bytes) ? str : new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }

        private String O0000OOo(String str) {
            Validate.O000000o((Object) str, "Header name must not be null");
            String str2 = (String) this.O00000o0.get(str);
            if (str2 == null) {
                str2 = (String) this.O00000o0.get(str.toLowerCase());
            }
            if (str2 != null) {
                return str2;
            }
            Entry O0000Oo0 = O0000Oo0(str);
            return O0000Oo0 != null ? (String) O0000Oo0.getValue() : str2;
        }

        private Entry<String, String> O0000Oo0(String str) {
            str = str.toLowerCase();
            for (Entry entry : this.O00000o0.entrySet()) {
                if (((String) entry.getKey()).toLowerCase().equals(str)) {
                    return entry;
                }
            }
            return null;
        }

        public String O000000o(String str) {
            Validate.O000000o((Object) str, "Header name must not be null");
            str = O0000OOo(str);
            return str != null ? O0000O0o(str) : str;
        }

        public URL O000000o() {
            return this.O000000o;
        }

        public T O000000o(String str, String str2) {
            Validate.O000000o(str, "Header name must not be empty");
            Validate.O000000o((Object) str2, "Header value must not be null");
            O00000o0(str);
            this.O00000o0.put(str, str2);
            return this;
        }

        public T O000000o(URL url) {
            Validate.O000000o((Object) url, "URL must not be null");
            this.O000000o = url;
            return this;
        }

        public T O000000o(Method method) {
            Validate.O000000o((Object) method, "Method must not be null");
            this.O00000Oo = method;
            return this;
        }

        public Method O00000Oo() {
            return this.O00000Oo;
        }

        public boolean O00000Oo(String str) {
            Validate.O000000o(str, "Header name must not be empty");
            return O0000OOo(str) != null;
        }

        public boolean O00000Oo(String str, String str2) {
            return O00000Oo(str) && O000000o(str).equalsIgnoreCase(str2);
        }

        public String O00000o(String str) {
            Validate.O000000o(str, "Cookie name must not be empty");
            return (String) this.O00000o.get(str);
        }

        public Map<String, String> O00000o() {
            return this.O00000o;
        }

        public Map<String, String> O00000o0() {
            return this.O00000o0;
        }

        public T O00000o0(String str) {
            Validate.O000000o(str, "Header name must not be empty");
            Entry O0000Oo0 = O0000Oo0(str);
            if (O0000Oo0 != null) {
                this.O00000o0.remove(O0000Oo0.getKey());
            }
            return this;
        }

        public T O00000o0(String str, String str2) {
            Validate.O000000o(str, "Cookie name must not be empty");
            Validate.O000000o((Object) str2, "Cookie value must not be null");
            this.O00000o.put(str, str2);
            return this;
        }

        public boolean O00000oO(String str) {
            Validate.O000000o(str, "Cookie name must not be empty");
            return this.O00000o.containsKey(str);
        }

        public T O00000oo(String str) {
            Validate.O000000o(str, "Cookie name must not be empty");
            this.O00000o.remove(str);
            return this;
        }
    }

    public static class KeyVal implements org.jsoup.Connection.KeyVal {
        private String O000000o;
        private String O00000Oo;
        private InputStream O00000o0;

        private KeyVal() {
        }

        public static KeyVal O000000o(String str, String str2) {
            return new KeyVal().O000000o(str).O00000Oo(str2);
        }

        public static KeyVal O000000o(String str, String str2, InputStream inputStream) {
            return new KeyVal().O000000o(str).O00000Oo(str2).O000000o(inputStream);
        }

        public String O000000o() {
            return this.O000000o;
        }

        public String O00000Oo() {
            return this.O00000Oo;
        }

        /* renamed from: O00000Oo */
        public KeyVal O000000o(InputStream inputStream) {
            Validate.O000000o(this.O00000Oo, "Data input stream must not be null");
            this.O00000o0 = inputStream;
            return this;
        }

        /* renamed from: O00000o */
        public KeyVal O00000Oo(String str) {
            Validate.O000000o((Object) str, "Data value must not be null");
            this.O00000Oo = str;
            return this;
        }

        public boolean O00000o() {
            return this.O00000o0 != null;
        }

        public InputStream O00000o0() {
            return this.O00000o0;
        }

        /* renamed from: O00000o0 */
        public KeyVal O000000o(String str) {
            Validate.O000000o(str, "Data key must not be empty");
            this.O000000o = str;
            return this;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.O000000o);
            stringBuilder.append("=");
            stringBuilder.append(this.O00000Oo);
            return stringBuilder.toString();
        }
    }

    public static class Request extends Base<org.jsoup.Connection.Request> implements org.jsoup.Connection.Request {
        private Proxy O00000oO;
        private int O00000oo;
        private int O0000O0o;
        private boolean O0000OOo;
        private String O0000Oo;
        private Collection<org.jsoup.Connection.KeyVal> O0000Oo0;
        private boolean O0000OoO;
        private boolean O0000Ooo;
        private boolean O0000o0;
        private Parser O0000o00;
        private boolean O0000o0O;
        private String O0000o0o;

        private Request() {
            super();
            this.O0000Oo = null;
            this.O0000OoO = false;
            this.O0000Ooo = false;
            this.O0000o0 = false;
            this.O0000o0O = true;
            this.O0000o0o = "UTF-8";
            this.O00000oo = XMediaPlayerConstants.TIME_OUT;
            this.O0000O0o = bt.O000000o;
            this.O0000OOo = true;
            this.O0000Oo0 = new ArrayList();
            this.O00000Oo = Method.GET;
            this.O00000o0.put("Accept-Encoding", "gzip");
            this.O00000o0.put(HttpConnection.O00000o0, HttpConnection.O00000Oo);
            this.O0000o00 = Parser.O00000oO();
        }

        public /* bridge */ /* synthetic */ URL O000000o() {
            return super.O000000o();
        }

        public org.jsoup.Connection.Request O000000o(boolean z) {
            this.O0000OOo = z;
            return this;
        }

        public /* bridge */ /* synthetic */ Method O00000Oo() {
            return super.O00000Oo();
        }

        public org.jsoup.Connection.Request O00000Oo(int i) {
            Validate.O000000o(i >= 0, "maxSize must be 0 (unlimited) or larger");
            this.O0000O0o = i;
            return this;
        }

        public org.jsoup.Connection.Request O00000Oo(boolean z) {
            this.O0000OoO = z;
            return this;
        }

        /* renamed from: O00000Oo */
        public Request O000000o(String str, int i) {
            this.O00000oO = new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(str, i));
            return this;
        }

        /* renamed from: O00000Oo */
        public Request O000000o(Proxy proxy) {
            this.O00000oO = proxy;
            return this;
        }

        /* renamed from: O00000Oo */
        public Request O000000o(org.jsoup.Connection.KeyVal keyVal) {
            Validate.O000000o((Object) keyVal, "Key val must not be null");
            this.O0000Oo0.add(keyVal);
            return this;
        }

        /* renamed from: O00000Oo */
        public Request O000000o(Parser parser) {
            this.O0000o00 = parser;
            this.O0000o0 = true;
            return this;
        }

        public /* bridge */ /* synthetic */ Map O00000o() {
            return super.O00000o();
        }

        public void O00000o(boolean z) {
            this.O0000o0O = z;
        }

        public /* bridge */ /* synthetic */ Map O00000o0() {
            return super.O00000o0();
        }

        public org.jsoup.Connection.Request O00000o0(boolean z) {
            this.O0000Ooo = z;
            return this;
        }

        /* renamed from: O00000o0 */
        public Request O000000o(int i) {
            Validate.O000000o(i >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.O00000oo = i;
            return this;
        }

        public Proxy O00000oO() {
            return this.O00000oO;
        }

        public /* bridge */ /* synthetic */ boolean O00000oO(String str) {
            return super.O00000oO(str);
        }

        public int O00000oo() {
            return this.O00000oo;
        }

        public int O0000O0o() {
            return this.O0000O0o;
        }

        public org.jsoup.Connection.Request O0000O0o(String str) {
            this.O0000Oo = str;
            return this;
        }

        public org.jsoup.Connection.Request O0000OOo(String str) {
            Validate.O000000o((Object) str, "Charset must not be null");
            if (Charset.isSupported(str)) {
                this.O0000o0o = str;
                return this;
            }
            throw new IllegalCharsetNameException(str);
        }

        public boolean O0000OOo() {
            return this.O0000OOo;
        }

        public boolean O0000Oo() {
            return this.O0000Ooo;
        }

        public boolean O0000Oo0() {
            return this.O0000OoO;
        }

        public boolean O0000OoO() {
            return this.O0000o0O;
        }

        public Collection<org.jsoup.Connection.KeyVal> O0000Ooo() {
            return this.O0000Oo0;
        }

        public Parser O0000o0() {
            return this.O0000o00;
        }

        public String O0000o00() {
            return this.O0000Oo;
        }

        public String O0000o0O() {
            return this.O0000o0o;
        }
    }

    public static class Response extends Base<org.jsoup.Connection.Response> implements org.jsoup.Connection.Response {
        private static final int O00000oO = 20;
        private static SSLSocketFactory O00000oo = null;
        private static final String O0000O0o = "Location";
        private static final Pattern O0000o0o = Pattern.compile("(application|text)/\\w*\\+?xml.*");
        private int O0000OOo;
        private ByteBuffer O0000Oo;
        private String O0000Oo0;
        private String O0000OoO;
        private String O0000Ooo;
        private int O0000o0 = 0;
        private boolean O0000o00 = false;
        private org.jsoup.Connection.Request O0000o0O;

        Response() {
            super();
        }

        private Response(Response response) throws IOException {
            super();
            if (response != null) {
                this.O0000o0 = response.O0000o0 + 1;
                if (this.O0000o0 >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", new Object[]{response.O000000o()}));
                }
            }
        }

        private static LinkedHashMap<String, List<String>> O000000o(HttpURLConnection httpURLConnection) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
                String headerField = httpURLConnection.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    return linkedHashMap;
                }
                i++;
                if (headerFieldKey != null) {
                    if (headerField != null) {
                        if (linkedHashMap.containsKey(headerFieldKey)) {
                            ((List) linkedHashMap.get(headerFieldKey)).add(headerField);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(headerField);
                            linkedHashMap.put(headerFieldKey, arrayList);
                        }
                    }
                }
            }
        }

        static Response O000000o(org.jsoup.Connection.Request request) throws IOException {
            return O000000o(request, null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0079 A:{Catch:{ all -> 0x01bc, all -> 0x01cf }} */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0114 A:{Catch:{ all -> 0x01bc, all -> 0x01cf }} */
        static org.jsoup.helper.HttpConnection.Response O000000o(org.jsoup.Connection.Request r5, org.jsoup.helper.HttpConnection.Response r6) throws java.io.IOException {
            /*
            r0 = "Request must not be null";
            org.jsoup.helper.Validate.O000000o(r5, r0);
            r0 = r5.O000000o();
            r0 = r0.getProtocol();
            r1 = "http";
            r1 = r0.equals(r1);
            if (r1 != 0) goto L_0x0025;
        L_0x0015:
            r1 = "https";
            r0 = r0.equals(r1);
            if (r0 != 0) goto L_0x0025;
        L_0x001d:
            r5 = new java.net.MalformedURLException;
            r6 = "Only http & https protocols supported";
            r5.<init>(r6);
            throw r5;
        L_0x0025:
            r0 = r5.O00000Oo();
            r0 = r0.O000000o();
            r1 = r5.O0000o00();
            r2 = 1;
            if (r1 == 0) goto L_0x0036;
        L_0x0034:
            r1 = r2;
            goto L_0x0037;
        L_0x0036:
            r1 = 0;
        L_0x0037:
            if (r0 != 0) goto L_0x0051;
        L_0x0039:
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = "Cannot set a request body for HTTP method ";
            r3.append(r4);
            r4 = r5.O00000Oo();
            r3.append(r4);
            r3 = r3.toString();
            org.jsoup.helper.Validate.O00000Oo(r1, r3);
        L_0x0051:
            r3 = r5.O0000Ooo();
            r3 = r3.size();
            r4 = 0;
            if (r3 <= 0) goto L_0x0064;
        L_0x005c:
            if (r0 == 0) goto L_0x0060;
        L_0x005e:
            if (r1 == 0) goto L_0x0064;
        L_0x0060:
            O00000oO(r5);
            goto L_0x006b;
        L_0x0064:
            if (r0 == 0) goto L_0x006b;
        L_0x0066:
            r0 = O00000o0(r5);
            goto L_0x006c;
        L_0x006b:
            r0 = r4;
        L_0x006c:
            r1 = O00000Oo(r5);
            r1.connect();	 Catch:{ all -> 0x01cf }
            r3 = r1.getDoOutput();	 Catch:{ all -> 0x01cf }
            if (r3 == 0) goto L_0x0080;
        L_0x0079:
            r3 = r1.getOutputStream();	 Catch:{ all -> 0x01cf }
            O000000o(r5, r3, r0);	 Catch:{ all -> 0x01cf }
        L_0x0080:
            r0 = r1.getResponseCode();	 Catch:{ all -> 0x01cf }
            r3 = new org.jsoup.helper.HttpConnection$Response;	 Catch:{ all -> 0x01cf }
            r3.<init>(r6);	 Catch:{ all -> 0x01cf }
            r3.O000000o(r1, r6);	 Catch:{ all -> 0x01cf }
            r3.O0000o0O = r5;	 Catch:{ all -> 0x01cf }
            r6 = "Location";
            r6 = r3.O00000Oo(r6);	 Catch:{ all -> 0x01cf }
            if (r6 == 0) goto L_0x0106;
        L_0x0096:
            r6 = r5.O0000OOo();	 Catch:{ all -> 0x01cf }
            if (r6 == 0) goto L_0x0106;
        L_0x009c:
            r6 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
            if (r0 == r6) goto L_0x00ac;
        L_0x00a0:
            r6 = org.jsoup.Connection.Method.GET;	 Catch:{ all -> 0x01cf }
            r5.O000000o(r6);	 Catch:{ all -> 0x01cf }
            r6 = r5.O0000Ooo();	 Catch:{ all -> 0x01cf }
            r6.clear();	 Catch:{ all -> 0x01cf }
        L_0x00ac:
            r6 = "Location";
            r6 = r3.O000000o(r6);	 Catch:{ all -> 0x01cf }
            if (r6 == 0) goto L_0x00c9;
        L_0x00b4:
            r0 = "http:/";
            r0 = r6.startsWith(r0);	 Catch:{ all -> 0x01cf }
            if (r0 == 0) goto L_0x00c9;
        L_0x00bc:
            r0 = 6;
            r2 = r6.charAt(r0);	 Catch:{ all -> 0x01cf }
            r4 = 47;
            if (r2 == r4) goto L_0x00c9;
        L_0x00c5:
            r6 = r6.substring(r0);	 Catch:{ all -> 0x01cf }
        L_0x00c9:
            r0 = r5.O000000o();	 Catch:{ all -> 0x01cf }
            r6 = org.jsoup.helper.StringUtil.O000000o(r0, r6);	 Catch:{ all -> 0x01cf }
            r6 = org.jsoup.helper.HttpConnection.O00000o(r6);	 Catch:{ all -> 0x01cf }
            r5.O000000o(r6);	 Catch:{ all -> 0x01cf }
            r6 = r3.O00000o;	 Catch:{ all -> 0x01cf }
            r6 = r6.entrySet();	 Catch:{ all -> 0x01cf }
            r6 = r6.iterator();	 Catch:{ all -> 0x01cf }
        L_0x00e2:
            r0 = r6.hasNext();	 Catch:{ all -> 0x01cf }
            if (r0 == 0) goto L_0x00fe;
        L_0x00e8:
            r0 = r6.next();	 Catch:{ all -> 0x01cf }
            r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x01cf }
            r2 = r0.getKey();	 Catch:{ all -> 0x01cf }
            r2 = (java.lang.String) r2;	 Catch:{ all -> 0x01cf }
            r0 = r0.getValue();	 Catch:{ all -> 0x01cf }
            r0 = (java.lang.String) r0;	 Catch:{ all -> 0x01cf }
            r5.O00000o0(r2, r0);	 Catch:{ all -> 0x01cf }
            goto L_0x00e2;
        L_0x00fe:
            r5 = O000000o(r5, r3);	 Catch:{ all -> 0x01cf }
            r1.disconnect();
            return r5;
        L_0x0106:
            r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r0 < r6) goto L_0x010e;
        L_0x010a:
            r6 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
            if (r0 < r6) goto L_0x0124;
        L_0x010e:
            r6 = r5.O0000Oo0();	 Catch:{ all -> 0x01cf }
            if (r6 != 0) goto L_0x0124;
        L_0x0114:
            r6 = new org.jsoup.HttpStatusException;	 Catch:{ all -> 0x01cf }
            r2 = "HTTP error fetching URL";
            r5 = r5.O000000o();	 Catch:{ all -> 0x01cf }
            r5 = r5.toString();	 Catch:{ all -> 0x01cf }
            r6.<init>(r2, r0, r5);	 Catch:{ all -> 0x01cf }
            throw r6;	 Catch:{ all -> 0x01cf }
        L_0x0124:
            r6 = r3.O0000OOo();	 Catch:{ all -> 0x01cf }
            if (r6 == 0) goto L_0x0154;
        L_0x012a:
            r0 = r5.O0000Oo();	 Catch:{ all -> 0x01cf }
            if (r0 != 0) goto L_0x0154;
        L_0x0130:
            r0 = "text/";
            r0 = r6.startsWith(r0);	 Catch:{ all -> 0x01cf }
            if (r0 != 0) goto L_0x0154;
        L_0x0138:
            r0 = O0000o0o;	 Catch:{ all -> 0x01cf }
            r0 = r0.matcher(r6);	 Catch:{ all -> 0x01cf }
            r0 = r0.matches();	 Catch:{ all -> 0x01cf }
            if (r0 != 0) goto L_0x0154;
        L_0x0144:
            r0 = new org.jsoup.UnsupportedMimeTypeException;	 Catch:{ all -> 0x01cf }
            r2 = "Unhandled content type. Must be text/*, application/xml, or application/xhtml+xml";
            r5 = r5.O000000o();	 Catch:{ all -> 0x01cf }
            r5 = r5.toString();	 Catch:{ all -> 0x01cf }
            r0.<init>(r2, r6, r5);	 Catch:{ all -> 0x01cf }
            throw r0;	 Catch:{ all -> 0x01cf }
        L_0x0154:
            if (r6 == 0) goto L_0x0176;
        L_0x0156:
            r0 = O0000o0o;	 Catch:{ all -> 0x01cf }
            r6 = r0.matcher(r6);	 Catch:{ all -> 0x01cf }
            r6 = r6.matches();	 Catch:{ all -> 0x01cf }
            if (r6 == 0) goto L_0x0176;
        L_0x0162:
            r6 = r5 instanceof org.jsoup.helper.HttpConnection.Request;	 Catch:{ all -> 0x01cf }
            if (r6 == 0) goto L_0x0176;
        L_0x0166:
            r6 = r5;
            r6 = (org.jsoup.helper.HttpConnection.Request) r6;	 Catch:{ all -> 0x01cf }
            r6 = r6.O0000o0;	 Catch:{ all -> 0x01cf }
            if (r6 != 0) goto L_0x0176;
        L_0x016f:
            r6 = org.jsoup.parser.Parser.O00000oo();	 Catch:{ all -> 0x01cf }
            r5.O000000o(r6);	 Catch:{ all -> 0x01cf }
        L_0x0176:
            r6 = r3.O0000Ooo;	 Catch:{ all -> 0x01cf }
            r6 = org.jsoup.helper.DataUtil.O000000o(r6);	 Catch:{ all -> 0x01cf }
            r3.O0000OoO = r6;	 Catch:{ all -> 0x01cf }
            r6 = r1.getContentLength();	 Catch:{ all -> 0x01cf }
            if (r6 == 0) goto L_0x01c3;
        L_0x0184:
            r6 = r5.O00000Oo();	 Catch:{ all -> 0x01cf }
            r0 = org.jsoup.Connection.Method.HEAD;	 Catch:{ all -> 0x01cf }
            if (r6 == r0) goto L_0x01c3;
        L_0x018c:
            r6 = r1.getErrorStream();	 Catch:{ all -> 0x01bc }
            if (r6 == 0) goto L_0x0197;
        L_0x0192:
            r6 = r1.getErrorStream();	 Catch:{ all -> 0x01bc }
            goto L_0x019b;
        L_0x0197:
            r6 = r1.getInputStream();	 Catch:{ all -> 0x01bc }
        L_0x019b:
            r4 = r6;
            r6 = "Content-Encoding";
            r0 = "gzip";
            r6 = r3.O00000Oo(r6, r0);	 Catch:{ all -> 0x01bc }
            if (r6 == 0) goto L_0x01ac;
        L_0x01a6:
            r6 = new java.util.zip.GZIPInputStream;	 Catch:{ all -> 0x01bc }
            r6.<init>(r4);	 Catch:{ all -> 0x01bc }
            r4 = r6;
        L_0x01ac:
            r5 = r5.O0000O0o();	 Catch:{ all -> 0x01bc }
            r5 = org.jsoup.helper.DataUtil.O000000o(r4, r5);	 Catch:{ all -> 0x01bc }
            r3.O0000Oo = r5;	 Catch:{ all -> 0x01bc }
            if (r4 == 0) goto L_0x01c9;
        L_0x01b8:
            r4.close();	 Catch:{ all -> 0x01cf }
            goto L_0x01c9;
        L_0x01bc:
            r5 = move-exception;
            if (r4 == 0) goto L_0x01c2;
        L_0x01bf:
            r4.close();	 Catch:{ all -> 0x01cf }
        L_0x01c2:
            throw r5;	 Catch:{ all -> 0x01cf }
        L_0x01c3:
            r5 = org.jsoup.helper.DataUtil.O000000o();	 Catch:{ all -> 0x01cf }
            r3.O0000Oo = r5;	 Catch:{ all -> 0x01cf }
        L_0x01c9:
            r1.disconnect();
            r3.O0000o00 = r2;
            return r3;
        L_0x01cf:
            r5 = move-exception;
            r1.disconnect();
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection$Response.O000000o(org.jsoup.Connection$Request, org.jsoup.helper.HttpConnection$Response):org.jsoup.helper.HttpConnection$Response");
        }

        private void O000000o(HttpURLConnection httpURLConnection, org.jsoup.Connection.Response response) throws IOException {
            this.O00000Oo = Method.valueOf(httpURLConnection.getRequestMethod());
            this.O000000o = httpURLConnection.getURL();
            this.O0000OOo = httpURLConnection.getResponseCode();
            this.O0000Oo0 = httpURLConnection.getResponseMessage();
            this.O0000Ooo = httpURLConnection.getContentType();
            O000000o(O000000o(httpURLConnection));
            if (response != null) {
                for (Entry entry : response.O00000o().entrySet()) {
                    if (!O00000oO((String) entry.getKey())) {
                        O00000o0((String) entry.getKey(), (String) entry.getValue());
                    }
                }
            }
        }

        private static void O000000o(org.jsoup.Connection.Request request, OutputStream outputStream, String str) throws IOException {
            Collection<org.jsoup.Connection.KeyVal> O0000Ooo = request.O0000Ooo();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, request.O0000o0O()));
            if (str != null) {
                for (org.jsoup.Connection.KeyVal keyVal : O0000Ooo) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(HttpConnection.O0000Oo(keyVal.O000000o()));
                    bufferedWriter.write("\"");
                    if (keyVal.O00000o()) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(HttpConnection.O0000Oo(keyVal.O00000Oo()));
                        bufferedWriter.write("\"\r\nContent-Type: application/octet-stream\r\n\r\n");
                        bufferedWriter.flush();
                        DataUtil.O000000o(keyVal.O00000o0(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(keyVal.O00000Oo());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else if (request.O0000o00() != null) {
                bufferedWriter.write(request.O0000o00());
            } else {
                Object obj = 1;
                for (org.jsoup.Connection.KeyVal keyVal2 : O0000Ooo) {
                    if (obj == null) {
                        bufferedWriter.append('&');
                    } else {
                        obj = null;
                    }
                    bufferedWriter.write(URLEncoder.encode(keyVal2.O000000o(), request.O0000o0O()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(keyVal2.O00000Oo(), request.O0000o0O()));
                }
            }
            bufferedWriter.close();
        }

        private static HttpURLConnection O00000Oo(org.jsoup.Connection.Request request) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) (request.O00000oO() == null ? request.O000000o().openConnection() : request.O000000o().openConnection(request.O00000oO()));
            httpURLConnection.setRequestMethod(request.O00000Oo().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(request.O00000oo());
            httpURLConnection.setReadTimeout(request.O00000oo());
            if ((httpURLConnection instanceof HttpsURLConnection) && !request.O0000OoO()) {
                O0000o00();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                httpsURLConnection.setSSLSocketFactory(O00000oo);
                httpsURLConnection.setHostnameVerifier(O0000Ooo());
            }
            if (request.O00000Oo().O000000o()) {
                httpURLConnection.setDoOutput(true);
            }
            if (request.O00000o().size() > 0) {
                httpURLConnection.addRequestProperty("Cookie", O00000o(request));
            }
            for (Entry entry : request.O00000o0().entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            return httpURLConnection;
        }

        private static String O00000o(org.jsoup.Connection.Request request) {
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            for (Entry entry : request.O00000o().entrySet()) {
                if (obj == null) {
                    stringBuilder.append("; ");
                } else {
                    obj = null;
                }
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append('=');
                stringBuilder.append((String) entry.getValue());
            }
            return stringBuilder.toString();
        }

        private static String O00000o0(org.jsoup.Connection.Request request) {
            if (!request.O00000Oo(HttpConnection.O00000o)) {
                String O00000Oo;
                if (HttpConnection.O00000o0(request)) {
                    O00000Oo = DataUtil.O00000Oo();
                    String str = HttpConnection.O00000o;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("multipart/form-data; boundary=");
                    stringBuilder.append(O00000Oo);
                    request.O000000o(str, stringBuilder.toString());
                    return O00000Oo;
                }
                O00000Oo = HttpConnection.O00000o;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("application/x-www-form-urlencoded; charset=");
                stringBuilder2.append(request.O0000o0O());
                request.O000000o(O00000Oo, stringBuilder2.toString());
            }
            return null;
        }

        private static void O00000oO(org.jsoup.Connection.Request request) throws IOException {
            Object obj;
            URL O000000o = request.O000000o();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.getProtocol());
            stringBuilder.append("://");
            stringBuilder.append(O000000o.getAuthority());
            stringBuilder.append(O000000o.getPath());
            stringBuilder.append("?");
            if (O000000o.getQuery() != null) {
                stringBuilder.append(O000000o.getQuery());
                obj = null;
            } else {
                obj = 1;
            }
            for (org.jsoup.Connection.KeyVal keyVal : request.O0000Ooo()) {
                Validate.O00000Oo(keyVal.O00000o(), "InputStream data not supported in URL query string.");
                if (obj == null) {
                    stringBuilder.append('&');
                } else {
                    obj = null;
                }
                stringBuilder.append(URLEncoder.encode(keyVal.O000000o(), "UTF-8"));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode(keyVal.O00000Oo(), "UTF-8"));
            }
            request.O000000o(new URL(stringBuilder.toString()));
            request.O0000Ooo().clear();
        }

        private static HostnameVerifier O0000Ooo() {
            return new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            };
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0028 */
        private static synchronized void O0000o00() throws java.io.IOException {
            /*
            r0 = org.jsoup.helper.HttpConnection.Response.class;
            monitor-enter(r0);
            r1 = O00000oo;	 Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0038;
        L_0x0007:
            r1 = 1;
            r1 = new javax.net.ssl.TrustManager[r1];	 Catch:{ all -> 0x003a }
            r2 = 0;
            r3 = new org.jsoup.helper.HttpConnection$Response$2;	 Catch:{ all -> 0x003a }
            r3.<init>();	 Catch:{ all -> 0x003a }
            r1[r2] = r3;	 Catch:{ all -> 0x003a }
            r2 = "SSL";
            r2 = javax.net.ssl.SSLContext.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
            r3 = 0;
            r4 = new java.security.SecureRandom;	 Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
            r4.<init>();	 Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
            r2.init(r3, r1, r4);	 Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
            r1 = r2.getSocketFactory();	 Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
            O00000oo = r1;	 Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
            goto L_0x0038;
        L_0x0028:
            r1 = new java.io.IOException;	 Catch:{ all -> 0x003a }
            r2 = "Can't create unsecure trust manager";
            r1.<init>(r2);	 Catch:{ all -> 0x003a }
            throw r1;	 Catch:{ all -> 0x003a }
        L_0x0030:
            r1 = new java.io.IOException;	 Catch:{ all -> 0x003a }
            r2 = "Can't create unsecure trust manager";
            r1.<init>(r2);	 Catch:{ all -> 0x003a }
            throw r1;	 Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r0);
            return;
        L_0x003a:
            r1 = move-exception;
            monitor-exit(r0);
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection$Response.O0000o00():void");
        }

        public /* bridge */ /* synthetic */ URL O000000o() {
            return super.O000000o();
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(Map<String, List<String>> map) {
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str != null) {
                    List<String> list = (List) entry.getValue();
                    if (str.equalsIgnoreCase("Set-Cookie")) {
                        for (String str2 : list) {
                            if (str2 != null) {
                                TokenQueue tokenQueue = new TokenQueue(str2);
                                str2 = tokenQueue.O0000OOo("=").trim();
                                String trim = tokenQueue.O00000oo(";").trim();
                                if (str2.length() > 0) {
                                    O00000o0(str2, trim);
                                }
                            }
                        }
                    } else {
                        int i = 0;
                        if (list.size() == 1) {
                            O000000o(str2, (String) list.get(0));
                        } else if (list.size() > 1) {
                            StringBuilder stringBuilder = new StringBuilder();
                            while (i < list.size()) {
                                String str3 = (String) list.get(i);
                                if (i != 0) {
                                    stringBuilder.append(", ");
                                }
                                stringBuilder.append(str3);
                                i++;
                            }
                            O000000o(str2, stringBuilder.toString());
                        }
                    }
                }
            }
        }

        public /* bridge */ /* synthetic */ Method O00000Oo() {
            return super.O00000Oo();
        }

        public /* bridge */ /* synthetic */ boolean O00000Oo(String str, String str2) {
            return super.O00000Oo(str, str2);
        }

        public /* bridge */ /* synthetic */ Map O00000o() {
            return super.O00000o();
        }

        public /* bridge */ /* synthetic */ Map O00000o0() {
            return super.O00000o0();
        }

        public int O00000oO() {
            return this.O0000OOo;
        }

        public String O00000oo() {
            return this.O0000Oo0;
        }

        public String O0000O0o() {
            return this.O0000OoO;
        }

        public String O0000OOo() {
            return this.O0000Ooo;
        }

        /* renamed from: O0000OOo */
        public Response O0000O0o(String str) {
            this.O0000OoO = str;
            return this;
        }

        public String O0000Oo() {
            Validate.O000000o(this.O0000o00, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            String charBuffer = this.O0000OoO == null ? Charset.forName("UTF-8").decode(this.O0000Oo).toString() : Charset.forName(this.O0000OoO).decode(this.O0000Oo).toString();
            this.O0000Oo.rewind();
            return charBuffer;
        }

        public Document O0000Oo0() throws IOException {
            Validate.O000000o(this.O0000o00, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            Document O000000o = DataUtil.O000000o(this.O0000Oo, this.O0000OoO, this.O000000o.toExternalForm(), this.O0000o0O.O0000o0());
            this.O0000Oo.rewind();
            this.O0000OoO = O000000o.O0000OoO().O00000Oo().name();
            return O000000o;
        }

        public byte[] O0000OoO() {
            Validate.O000000o(this.O0000o00, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            return this.O0000Oo.array();
        }
    }

    private HttpConnection() {
    }

    public static Connection O00000Oo(URL url) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.O000000o(url);
        return httpConnection;
    }

    private static URL O00000o(URL url) {
        try {
            return new URL(new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toASCIIString());
        } catch (Exception unused) {
            return url;
        }
    }

    private static boolean O00000o0(org.jsoup.Connection.Request request) {
        for (org.jsoup.Connection.KeyVal O00000o : request.O0000Ooo()) {
            if (O00000o.O00000o()) {
                return true;
            }
        }
        return false;
    }

    public static Connection O0000O0o(String str) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.O000000o(str);
        return httpConnection;
    }

    private static String O0000Oo(String str) {
        return str == null ? null : str.replaceAll("\"", "%22");
    }

    private static String O0000Oo0(String str) {
        try {
            return O00000o(new URL(str)).toExternalForm();
        } catch (Exception unused) {
            return str;
        }
    }

    public Connection O000000o(int i) {
        this.O0000OOo.O000000o(i);
        return this;
    }

    public Connection O000000o(String str) {
        Validate.O000000o(str, "Must supply a valid URL");
        try {
            this.O0000OOo.O000000o(new URL(O0000Oo0(str)));
            return this;
        } catch (MalformedURLException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Malformed URL: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString(), e);
        }
    }

    public Connection O000000o(String str, int i) {
        this.O0000OOo.O000000o(str, i);
        return this;
    }

    public Connection O000000o(String str, String str2) {
        this.O0000OOo.O000000o(KeyVal.O000000o(str, str2));
        return this;
    }

    public Connection O000000o(String str, String str2, InputStream inputStream) {
        this.O0000OOo.O000000o(KeyVal.O000000o(str, str2, inputStream));
        return this;
    }

    public Connection O000000o(Proxy proxy) {
        this.O0000OOo.O000000o(proxy);
        return this;
    }

    public Connection O000000o(URL url) {
        this.O0000OOo.O000000o(url);
        return this;
    }

    public Connection O000000o(Collection<org.jsoup.Connection.KeyVal> collection) {
        Validate.O000000o((Object) collection, "Data collection must not be null");
        for (org.jsoup.Connection.KeyVal O000000o : collection) {
            this.O0000OOo.O000000o(O000000o);
        }
        return this;
    }

    public Connection O000000o(Map<String, String> map) {
        Validate.O000000o((Object) map, "Data map must not be null");
        for (Entry entry : map.entrySet()) {
            this.O0000OOo.O000000o(KeyVal.O000000o((String) entry.getKey(), (String) entry.getValue()));
        }
        return this;
    }

    public Connection O000000o(Method method) {
        this.O0000OOo.O000000o(method);
        return this;
    }

    public Connection O000000o(org.jsoup.Connection.Request request) {
        this.O0000OOo = request;
        return this;
    }

    public Connection O000000o(org.jsoup.Connection.Response response) {
        this.O0000Oo0 = response;
        return this;
    }

    public Connection O000000o(Parser parser) {
        this.O0000OOo.O000000o(parser);
        return this;
    }

    public Connection O000000o(boolean z) {
        this.O0000OOo.O000000o(z);
        return this;
    }

    public Connection O000000o(String... strArr) {
        Validate.O000000o((Object) strArr, "Data key value pairs must not be null");
        int i = 0;
        Validate.O000000o(strArr.length % 2 == 0, "Must supply an even number of key value pairs");
        while (i < strArr.length) {
            String str = strArr[i];
            Object obj = strArr[i + 1];
            Validate.O000000o(str, "Data key must not be empty");
            Validate.O000000o(obj, "Data value must not be null");
            this.O0000OOo.O000000o(KeyVal.O000000o(str, obj));
            i += 2;
        }
        return this;
    }

    public Document O000000o() throws IOException {
        this.O0000OOo.O000000o(Method.GET);
        O00000o0();
        return this.O0000Oo0.O0000Oo0();
    }

    public Connection O00000Oo(int i) {
        this.O0000OOo.O00000Oo(i);
        return this;
    }

    public Connection O00000Oo(String str) {
        Validate.O000000o((Object) str, "User agent must not be null");
        this.O0000OOo.O000000o(O00000o0, str);
        return this;
    }

    public Connection O00000Oo(String str, String str2) {
        this.O0000OOo.O000000o(str, str2);
        return this;
    }

    public Connection O00000Oo(Map<String, String> map) {
        Validate.O000000o((Object) map, "Header map must not be null");
        for (Entry entry : map.entrySet()) {
            this.O0000OOo.O000000o((String) entry.getKey(), (String) entry.getValue());
        }
        return this;
    }

    public Connection O00000Oo(boolean z) {
        this.O0000OOo.O00000Oo(z);
        return this;
    }

    public Document O00000Oo() throws IOException {
        this.O0000OOo.O000000o(Method.POST);
        O00000o0();
        return this.O0000Oo0.O0000Oo0();
    }

    public org.jsoup.Connection.KeyVal O00000o(String str) {
        Validate.O000000o(str, "Data key must not be empty");
        for (org.jsoup.Connection.KeyVal keyVal : O00000o().O0000Ooo()) {
            if (keyVal.O000000o().equals(str)) {
                return keyVal;
            }
        }
        return null;
    }

    public org.jsoup.Connection.Request O00000o() {
        return this.O0000OOo;
    }

    public Connection O00000o(boolean z) {
        this.O0000OOo.O00000o(z);
        return this;
    }

    public org.jsoup.Connection.Response O00000o0() throws IOException {
        this.O0000Oo0 = Response.O000000o(this.O0000OOo);
        return this.O0000Oo0;
    }

    public Connection O00000o0(String str) {
        Validate.O000000o((Object) str, "Referrer must not be null");
        this.O0000OOo.O000000o("Referer", str);
        return this;
    }

    public Connection O00000o0(String str, String str2) {
        this.O0000OOo.O00000o0(str, str2);
        return this;
    }

    public Connection O00000o0(Map<String, String> map) {
        Validate.O000000o((Object) map, "Cookie map must not be null");
        for (Entry entry : map.entrySet()) {
            this.O0000OOo.O00000o0((String) entry.getKey(), (String) entry.getValue());
        }
        return this;
    }

    public Connection O00000o0(boolean z) {
        this.O0000OOo.O00000o0(z);
        return this;
    }

    public org.jsoup.Connection.Response O00000oO() {
        return this.O0000Oo0;
    }

    public Connection O00000oO(String str) {
        this.O0000OOo.O0000O0o(str);
        return this;
    }

    public Connection O00000oo(String str) {
        this.O0000OOo.O0000OOo(str);
        return this;
    }
}
