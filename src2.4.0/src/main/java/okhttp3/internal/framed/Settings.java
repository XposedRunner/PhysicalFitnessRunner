package okhttp3.internal.framed;

public final class Settings {
    static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    static final int COUNT = 10;
    static final int CURRENT_CWND = 5;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
    static final int DOWNLOAD_BANDWIDTH = 2;
    static final int DOWNLOAD_RETRANS_RATE = 6;
    static final int ENABLE_PUSH = 2;
    static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
    static final int FLOW_CONTROL_OPTIONS = 10;
    static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    static final int PERSISTED = 2;
    static final int PERSIST_VALUE = 1;
    static final int ROUND_TRIP_TIME = 3;
    static final int UPLOAD_BANDWIDTH = 1;
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values;

    /* Access modifiers changed, original: 0000 */
    public void clear() {
    }

    /* Access modifiers changed, original: 0000 */
    public int flags(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int get(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getClientCertificateVectorSize(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getCurrentCwnd(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getDownloadBandwidth(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getDownloadRetransRate(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean getEnablePush(boolean z) {
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public int getHeaderTableSize() {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getInitialWindowSize(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getMaxConcurrentStreams(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getMaxFrameSize(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getMaxHeaderListSize(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getRoundTripTime(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getUploadBandwidth(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isFlowControlDisabled() {
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isPersisted(int i) {
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isSet(int i) {
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public void merge(Settings settings) {
    }

    /* Access modifiers changed, original: 0000 */
    public boolean persistValue(int i) {
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public Settings set(int i, int i2, int i3) {
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public int size() {
        return 0;
    }
}
