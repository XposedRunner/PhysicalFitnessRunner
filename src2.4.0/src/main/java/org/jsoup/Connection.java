package org.jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public interface Connection {

    public interface Base<T extends Base> {
        String O000000o(String str);

        URL O000000o();

        T O000000o(String str, String str2);

        T O000000o(URL url);

        T O000000o(Method method);

        Method O00000Oo();

        boolean O00000Oo(String str);

        boolean O00000Oo(String str, String str2);

        String O00000o(String str);

        Map<String, String> O00000o();

        Map<String, String> O00000o0();

        T O00000o0(String str);

        T O00000o0(String str, String str2);

        boolean O00000oO(String str);

        T O00000oo(String str);
    }

    public interface KeyVal {
        String O000000o();

        KeyVal O000000o(InputStream inputStream);

        KeyVal O000000o(String str);

        String O00000Oo();

        KeyVal O00000Oo(String str);

        boolean O00000o();

        InputStream O00000o0();
    }

    public enum Method {
        GET(false),
        POST(true),
        PUT(true),
        DELETE(false),
        PATCH(true),
        HEAD(false),
        OPTIONS(false),
        TRACE(false);
        
        private final boolean O0000Oo0;

        private Method(boolean z) {
            this.O0000Oo0 = z;
        }

        public final boolean O000000o() {
            return this.O0000Oo0;
        }
    }

    public interface Request extends Base<Request> {
        Request O000000o(int i);

        Request O000000o(String str, int i);

        Request O000000o(Proxy proxy);

        Request O000000o(KeyVal keyVal);

        Request O000000o(Parser parser);

        Request O000000o(boolean z);

        Request O00000Oo(int i);

        Request O00000Oo(boolean z);

        void O00000o(boolean z);

        Request O00000o0(boolean z);

        Proxy O00000oO();

        int O00000oo();

        int O0000O0o();

        Request O0000O0o(String str);

        Request O0000OOo(String str);

        boolean O0000OOo();

        boolean O0000Oo();

        boolean O0000Oo0();

        boolean O0000OoO();

        Collection<KeyVal> O0000Ooo();

        Parser O0000o0();

        String O0000o00();

        String O0000o0O();
    }

    public interface Response extends Base<Response> {
        int O00000oO();

        String O00000oo();

        String O0000O0o();

        Response O0000O0o(String str);

        String O0000OOo();

        String O0000Oo();

        Document O0000Oo0() throws IOException;

        byte[] O0000OoO();
    }

    Connection O000000o(int i);

    Connection O000000o(String str);

    Connection O000000o(String str, int i);

    Connection O000000o(String str, String str2);

    Connection O000000o(String str, String str2, InputStream inputStream);

    Connection O000000o(Proxy proxy);

    Connection O000000o(URL url);

    Connection O000000o(Collection<KeyVal> collection);

    Connection O000000o(Map<String, String> map);

    Connection O000000o(Method method);

    Connection O000000o(Request request);

    Connection O000000o(Response response);

    Connection O000000o(Parser parser);

    Connection O000000o(boolean z);

    Connection O000000o(String... strArr);

    Document O000000o() throws IOException;

    Connection O00000Oo(int i);

    Connection O00000Oo(String str);

    Connection O00000Oo(String str, String str2);

    Connection O00000Oo(Map<String, String> map);

    Connection O00000Oo(boolean z);

    Document O00000Oo() throws IOException;

    KeyVal O00000o(String str);

    Request O00000o();

    Connection O00000o(boolean z);

    Response O00000o0() throws IOException;

    Connection O00000o0(String str);

    Connection O00000o0(String str, String str2);

    Connection O00000o0(Map<String, String> map);

    Connection O00000o0(boolean z);

    Response O00000oO();

    Connection O00000oO(String str);

    Connection O00000oo(String str);
}
