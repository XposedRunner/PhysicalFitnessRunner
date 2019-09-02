package org.jsoup;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.jsoup.helper.DataUtil;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.parser.Parser;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

public class Jsoup {
    private Jsoup() {
    }

    public static String O000000o(String str, String str2, Whitelist whitelist) {
        return new Cleaner(whitelist).O000000o(O00000Oo(str, str2)).O00000o().O000OOo();
    }

    public static String O000000o(String str, String str2, Whitelist whitelist, OutputSettings outputSettings) {
        Document O000000o = new Cleaner(whitelist).O000000o(O00000Oo(str, str2));
        O000000o.O000000o(outputSettings);
        return O000000o.O00000o().O000OOo();
    }

    public static String O000000o(String str, Whitelist whitelist) {
        return O000000o(str, "", whitelist);
    }

    public static Document O000000o(File file, String str) throws IOException {
        return DataUtil.O000000o(file, str, file.getAbsolutePath());
    }

    public static Document O000000o(File file, String str, String str2) throws IOException {
        return DataUtil.O000000o(file, str, str2);
    }

    public static Document O000000o(InputStream inputStream, String str, String str2) throws IOException {
        return DataUtil.O000000o(inputStream, str, str2);
    }

    public static Document O000000o(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        return DataUtil.O000000o(inputStream, str, str2, parser);
    }

    public static Document O000000o(String str) {
        return Parser.O00000Oo(str, "");
    }

    public static Document O000000o(String str, String str2) {
        return Parser.O00000Oo(str, str2);
    }

    public static Document O000000o(String str, String str2, Parser parser) {
        return parser.O000000o(str, str2);
    }

    public static Document O000000o(URL url, int i) throws IOException {
        Connection O00000Oo = HttpConnection.O00000Oo(url);
        O00000Oo.O000000o(i);
        return O00000Oo.O000000o();
    }

    public static Connection O00000Oo(String str) {
        return HttpConnection.O0000O0o(str);
    }

    public static Document O00000Oo(String str, String str2) {
        return Parser.O00000o(str, str2);
    }

    public static boolean O00000Oo(String str, Whitelist whitelist) {
        return new Cleaner(whitelist).O000000o(str);
    }

    public static Document O00000o0(String str) {
        return Parser.O00000o(str, "");
    }
}
