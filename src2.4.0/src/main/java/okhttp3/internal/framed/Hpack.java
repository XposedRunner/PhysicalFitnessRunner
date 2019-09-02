package okhttp3.internal.framed;

import com.ximalaya.ting.android.opensdk.auth.constants.XmlyAuthErrorNoConstants;
import defpackage.ce;
import defpackage.db;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

final class Hpack {
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final Header[] STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, XmlyAuthErrorNoConstants.XM_OAUTH2_REDIRECT_URI_INVALID), new Header(Header.RESPONSE_STATUS, XmlyAuthErrorNoConstants.XM_OAUTH2_AUTHORIZATION_GRANT_DENIED), new Header(Header.RESPONSE_STATUS, XmlyAuthErrorNoConstants.XM_OAUTH2_ACCESS_TOKEN_INVALID_OR_EXPIRED), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, XmlyAuthErrorNoConstants.XM_SYSTEM_INTERNAL_SERVICE_ERROR), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(ce.O0000oo0, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header(db.O000OoOO, ""), new Header("www-authenticate", "")};

    static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        Reader(int i, int i2, Source source) {
        }

        Reader(int i, Source source) {
        }

        private void adjustDynamicTableByteCount() {
        }

        private void clearDynamicTable() {
        }

        private int dynamicTableIndex(int i) {
            return 0;
        }

        private int evictToRecoverBytes(int i) {
            return 0;
        }

        private ByteString getName(int i) {
            return null;
        }

        private void insertIntoDynamicTable(int i, Header header) {
        }

        private boolean isStaticHeader(int i) {
            return false;
        }

        private int readByte() throws IOException {
            return 0;
        }

        private void readIndexedHeader(int i) throws IOException {
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) throws IOException {
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i) throws IOException {
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
        }

        public List<Header> getAndResetHeaderList() {
            return null;
        }

        /* Access modifiers changed, original: 0000 */
        public int maxDynamicTableByteCount() {
            return 0;
        }

        /* Access modifiers changed, original: 0000 */
        public ByteString readByteString() throws IOException {
            return null;
        }

        /* Access modifiers changed, original: 0000 */
        public void readHeaders() throws IOException {
        }

        /* Access modifiers changed, original: 0000 */
        public int readInt(int i, int i2) throws IOException {
            return 0;
        }
    }

    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;

        Writer(int i, Buffer buffer) {
        }

        Writer(Buffer buffer) {
        }

        private void adjustDynamicTableByteCount() {
        }

        private void clearDynamicTable() {
        }

        private int evictToRecoverBytes(int i) {
            return 0;
        }

        private void insertIntoDynamicTable(Header header) {
        }

        /* Access modifiers changed, original: 0000 */
        public void setHeaderTableSizeSetting(int i) {
        }

        /* Access modifiers changed, original: 0000 */
        public void writeByteString(ByteString byteString) throws IOException {
        }

        /* Access modifiers changed, original: 0000 */
        public void writeHeaders(List<Header> list) throws IOException {
        }

        /* Access modifiers changed, original: 0000 */
        public void writeInt(int i, int i2, int i3) {
        }
    }

    private Hpack() {
    }

    private static ByteString checkLowercase(ByteString byteString) throws IOException {
        return null;
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        return null;
    }
}
