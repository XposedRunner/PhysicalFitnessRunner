package com.ximalaya.ting.android.player;

public class HlsDownloadThread {
    private BufferItem mBufferItem;
    private String mCurrentDownloadUrl;
    long mLimitConnectTime;
    long mLimitDownloadSpeed;

    public HlsDownloadThread(String str, BufferItem bufferItem) {
        this.mCurrentDownloadUrl = str;
        this.mBufferItem = bufferItem;
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0412 A:{Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0d9e  */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0435 A:{Splitter:B:152:0x03d7, ExcHandler: all (th java.lang.Throwable), Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:550:0x0bf6 A:{Splitter:B:253:0x051d, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02a0 A:{PHI: r14 , Splitter:B:84:0x0271, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x05c1 A:{Splitter:B:290:0x05bc, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0f37 A:{Splitter:B:11:0x005e, ExcHandler: Throwable (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:719:0x0f2b A:{Splitter:B:11:0x005e, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:992:0x14b4 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:1005:0x1518  */
    /* JADX WARNING: Removed duplicated region for block: B:1008:0x1526  */
    /* JADX WARNING: Removed duplicated region for block: B:1015:0x154b  */
    /* JADX WARNING: Removed duplicated region for block: B:1017:0x1550 A:{SYNTHETIC, Splitter:B:1017:0x1550} */
    /* JADX WARNING: Removed duplicated region for block: B:1021:0x1555 A:{SYNTHETIC, Splitter:B:1021:0x1555} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:956:0x13e0 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:959:0x13f9 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:960:0x1419 A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:966:0x1446  */
    /* JADX WARNING: Removed duplicated region for block: B:969:0x1454  */
    /* JADX WARNING: Removed duplicated region for block: B:976:0x1479  */
    /* JADX WARNING: Removed duplicated region for block: B:978:0x147e A:{SYNTHETIC, Splitter:B:978:0x147e} */
    /* JADX WARNING: Removed duplicated region for block: B:982:0x1483 A:{SYNTHETIC, Splitter:B:982:0x1483} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:922:0x133b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:928:0x1378  */
    /* JADX WARNING: Removed duplicated region for block: B:931:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:938:0x13ab  */
    /* JADX WARNING: Removed duplicated region for block: B:940:0x13b0 A:{SYNTHETIC, Splitter:B:940:0x13b0} */
    /* JADX WARNING: Removed duplicated region for block: B:944:0x13b5 A:{SYNTHETIC, Splitter:B:944:0x13b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:888:0x129b A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:894:0x12d8  */
    /* JADX WARNING: Removed duplicated region for block: B:897:0x12e6  */
    /* JADX WARNING: Removed duplicated region for block: B:904:0x130b  */
    /* JADX WARNING: Removed duplicated region for block: B:906:0x1310 A:{SYNTHETIC, Splitter:B:906:0x1310} */
    /* JADX WARNING: Removed duplicated region for block: B:910:0x1315 A:{SYNTHETIC, Splitter:B:910:0x1315} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:851:0x11db A:{Catch:{ all -> 0x113f, all -> 0x127b }} */
    /* JADX WARNING: Removed duplicated region for block: B:858:0x1232  */
    /* JADX WARNING: Removed duplicated region for block: B:861:0x1240  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x1265  */
    /* JADX WARNING: Removed duplicated region for block: B:870:0x126a A:{SYNTHETIC, Splitter:B:870:0x126a} */
    /* JADX WARNING: Removed duplicated region for block: B:874:0x126f A:{SYNTHETIC, Splitter:B:874:0x126f} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:786:0x1079 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:823:0x1178  */
    /* JADX WARNING: Removed duplicated region for block: B:826:0x1186  */
    /* JADX WARNING: Removed duplicated region for block: B:833:0x11ab  */
    /* JADX WARNING: Removed duplicated region for block: B:835:0x11b0 A:{SYNTHETIC, Splitter:B:835:0x11b0} */
    /* JADX WARNING: Removed duplicated region for block: B:839:0x11b5 A:{SYNTHETIC, Splitter:B:839:0x11b5} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:728:0x0f46 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:761:0x1008  */
    /* JADX WARNING: Removed duplicated region for block: B:764:0x1016  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x103b  */
    /* JADX WARNING: Removed duplicated region for block: B:773:0x1040 A:{SYNTHETIC, Splitter:B:773:0x1040} */
    /* JADX WARNING: Removed duplicated region for block: B:777:0x1045 A:{SYNTHETIC, Splitter:B:777:0x1045} */
    /* JADX WARNING: Removed duplicated region for block: B:1026:0x1576 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:719:0x0f2b A:{Splitter:B:11:0x005e, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Removed duplicated region for block: B:1041:0x15b2  */
    /* JADX WARNING: Removed duplicated region for block: B:1044:0x15c0  */
    /* JADX WARNING: Removed duplicated region for block: B:1051:0x15e5  */
    /* JADX WARNING: Removed duplicated region for block: B:1070:0x16f5  */
    /* JADX WARNING: Removed duplicated region for block: B:1072:0x16fa A:{SYNTHETIC, Splitter:B:1072:0x16fa} */
    /* JADX WARNING: Removed duplicated region for block: B:1076:0x16ff A:{SYNTHETIC, Splitter:B:1076:0x16ff} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:89:0x02a0, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:90:0x02a1, code skipped:
            r1 = r2;
            r33 = r8;
     */
    /* JADX WARNING: Missing block: B:91:0x02a6, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:92:0x02a7, code skipped:
            r3 = r0;
            r33 = r8;
            r8 = r16;
            r30 = r26;
     */
    /* JADX WARNING: Missing block: B:93:0x02b0, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:94:0x02b1, code skipped:
            r1 = r0;
            r40 = r2;
            r33 = r8;
            r8 = r16;
            r30 = r26;
     */
    /* JADX WARNING: Missing block: B:95:0x02bc, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:96:0x02bd, code skipped:
            r1 = r0;
            r40 = r2;
            r33 = r8;
            r30 = r26;
     */
    /* JADX WARNING: Missing block: B:97:0x02c6, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:98:0x02c7, code skipped:
            r1 = r0;
            r40 = r2;
            r33 = r8;
            r30 = r26;
     */
    /* JADX WARNING: Missing block: B:99:0x02d0, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:100:0x02d1, code skipped:
            r1 = r0;
            r40 = r2;
            r33 = r8;
            r30 = r26;
     */
    /* JADX WARNING: Missing block: B:101:0x02da, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:102:0x02db, code skipped:
            r1 = r0;
            r40 = r2;
            r33 = r8;
            r30 = r26;
     */
    /* JADX WARNING: Missing block: B:103:0x02e4, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:104:0x02e5, code skipped:
            r1 = r0;
            r40 = r2;
            r33 = r8;
            r30 = r26;
     */
    /* JADX WARNING: Missing block: B:175:0x0427, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:177:0x0429, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:179:0x042b, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:181:0x042d, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:183:0x042f, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:185:0x0431, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:187:0x0433, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:189:0x0435, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:190:0x0436, code skipped:
            r32 = r10;
     */
    /* JADX WARNING: Missing block: B:292:0x05c1, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:322:0x0631, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:323:0x0634, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:324:0x0637, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:325:0x063a, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:326:0x063d, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:327:0x0640, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:328:0x0643, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:550:0x0bf6, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:551:0x0bf7, code skipped:
            r33 = r8;
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:552:0x0bfc, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:553:0x0bfd, code skipped:
            r33 = r8;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:554:0x0c02, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:555:0x0c03, code skipped:
            r33 = r8;
            r1 = r0;
            r40 = r2;
     */
    /* JADX WARNING: Missing block: B:556:0x0c0a, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:557:0x0c0b, code skipped:
            r33 = r8;
            r1 = r0;
            r40 = r2;
     */
    /* JADX WARNING: Missing block: B:558:0x0c12, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:559:0x0c13, code skipped:
            r33 = r8;
            r1 = r0;
            r40 = r2;
     */
    /* JADX WARNING: Missing block: B:560:0x0c1a, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:561:0x0c1b, code skipped:
            r33 = r8;
            r1 = r0;
            r40 = r2;
     */
    /* JADX WARNING: Missing block: B:562:0x0c22, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:563:0x0c23, code skipped:
            r33 = r8;
            r1 = r0;
            r40 = r2;
     */
    /* JADX WARNING: Missing block: B:564:0x0c2a, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:565:0x0c2b, code skipped:
            r33 = r8;
            r1 = r0;
            r40 = r2;
     */
    /* JADX WARNING: Missing block: B:701:0x0ee3, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:702:0x0ee4, code skipped:
            r30 = r7;
            r33 = r8;
            r28 = r14;
     */
    /* JADX WARNING: Missing block: B:704:0x0eef, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:705:0x0ef0, code skipped:
            r30 = r7;
            r33 = r8;
            r28 = r14;
     */
    /* JADX WARNING: Missing block: B:707:0x0efb, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:708:0x0efc, code skipped:
            r30 = r7;
            r33 = r8;
            r28 = r14;
     */
    /* JADX WARNING: Missing block: B:710:0x0f07, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:711:0x0f08, code skipped:
            r30 = r7;
            r33 = r8;
            r28 = r14;
     */
    /* JADX WARNING: Missing block: B:713:0x0f13, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:714:0x0f14, code skipped:
            r30 = r7;
            r33 = r8;
            r28 = r14;
     */
    /* JADX WARNING: Missing block: B:716:0x0f1f, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:717:0x0f20, code skipped:
            r30 = r7;
            r33 = r8;
            r28 = r14;
     */
    /* JADX WARNING: Missing block: B:719:0x0f2b, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:720:0x0f2c, code skipped:
            r33 = r8;
            r28 = r14;
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:723:0x0f37, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:724:0x0f38, code skipped:
            r30 = r7;
            r33 = r8;
            r28 = r14;
     */
    /* JADX WARNING: Missing block: B:731:0x0f50, code skipped:
            if (android.text.TextUtils.isEmpty(r12.getDownloadSpeed()) != false) goto L_0x0f52;
     */
    /* JADX WARNING: Missing block: B:733:0x0f56, code skipped:
            r38 = r14;
            r13 = java.lang.System.currentTimeMillis() - r17;
     */
    /* JADX WARNING: Missing block: B:734:0x0f5e, code skipped:
            if (r13 != 0) goto L_0x0f60;
     */
    /* JADX WARNING: Missing block: B:735:0x0f60, code skipped:
            r10 = ((((float) r8) + com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) / 1024.0f) / ((((float) r13) + com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) / 1000.0f);
     */
    /* JADX WARNING: Missing block: B:737:?, code skipped:
            r4 = new java.lang.StringBuilder();
            r4.append(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, true));
            r4.append("");
            r12.setDownloadSpeed(r4.toString());
            r4 = new java.lang.StringBuilder();
            r4.append(r8);
            r4.append("");
            r12.setDownloaded(r4.toString());
            r4 = new java.lang.StringBuilder();
            r4.append(r13);
            r4.append("");
            r12.setDownloadTime(r4.toString());
     */
    /* JADX WARNING: Missing block: B:738:0x0faf, code skipped:
            r38 = r14;
     */
    /* JADX WARNING: Missing block: B:740:0x0fb8, code skipped:
            if (r12.getConnectedTime() <= com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) goto L_0x0fba;
     */
    /* JADX WARNING: Missing block: B:742:0x0fbe, code skipped:
            r40 = r2;
            r1 = java.lang.System.currentTimeMillis() - r33;
     */
    /* JADX WARNING: Missing block: B:744:?, code skipped:
            r12.setConnectedTime(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal((float) r1, false));
     */
    /* JADX WARNING: Missing block: B:745:0x0fcb, code skipped:
            r14 = r1;
     */
    /* JADX WARNING: Missing block: B:746:0x0fcd, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:747:0x0fce, code skipped:
            r14 = r1;
            r1 = r40;
     */
    /* JADX WARNING: Missing block: B:748:0x0fd2, code skipped:
            r40 = r2;
            r14 = r38;
     */
    /* JADX WARNING: Missing block: B:750:?, code skipped:
            r12.setDownloaded(com.ximalaya.ting.android.player.cdn.CdnConstants.DOWNLOAD_FAILED);
            r12.setErrorType(com.ximalaya.ting.android.player.cdn.CdnConstants.CDN_UNKNOWN_EXCEPTION);
            r12.setExceptionReason(com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3));
     */
    /* JADX WARNING: Missing block: B:751:0x0fe8, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:752:0x0fe9, code skipped:
            r1 = r2;
            r14 = r38;
     */
    /* JADX WARNING: Missing block: B:753:0x0fed, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:754:0x0fee, code skipped:
            r38 = r14;
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:755:0x0ff1, code skipped:
            r13 = 1;
     */
    /* JADX WARNING: Missing block: B:761:0x1008, code skipped:
            r12.setViaInfo(null);
     */
    /* JADX WARNING: Missing block: B:764:0x1016, code skipped:
            r12.setStatusCode("");
     */
    /* JADX WARNING: Missing block: B:771:0x103b, code skipped:
            r11.disconnect();
     */
    /* JADX WARNING: Missing block: B:774:?, code skipped:
            r9.close();
     */
    /* JADX WARNING: Missing block: B:778:?, code skipped:
            r7.close();
     */
    /* JADX WARNING: Missing block: B:782:0x1068, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:783:0x1069, code skipped:
            r40 = r2;
            r30 = r7;
            r33 = r8;
            r28 = r14;
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:789:0x1083, code skipped:
            if (android.text.TextUtils.isEmpty(r12.getDownloadSpeed()) != false) goto L_0x1085;
     */
    /* JADX WARNING: Missing block: B:791:0x1089, code skipped:
            r41 = r14;
            r13 = java.lang.System.currentTimeMillis() - r17;
     */
    /* JADX WARNING: Missing block: B:792:0x1091, code skipped:
            if (r13 != 0) goto L_0x1093;
     */
    /* JADX WARNING: Missing block: B:793:0x1093, code skipped:
            r10 = ((((float) r8) + com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) / 1024.0f) / ((((float) r13) + com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) / 1000.0f);
     */
    /* JADX WARNING: Missing block: B:795:?, code skipped:
            r2 = new java.lang.StringBuilder();
            r2.append(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, true));
            r2.append("");
            r12.setDownloadSpeed(r2.toString());
            r2 = new java.lang.StringBuilder();
            r2.append(r8);
            r2.append("");
            r12.setDownloaded(r2.toString());
            r2 = new java.lang.StringBuilder();
            r2.append(r13);
            r2.append("");
            r12.setDownloadTime(r2.toString());
     */
    /* JADX WARNING: Missing block: B:796:0x10e2, code skipped:
            r41 = r14;
     */
    /* JADX WARNING: Missing block: B:798:0x10eb, code skipped:
            if (r12.getConnectedTime() <= com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) goto L_0x10ed;
     */
    /* JADX WARNING: Missing block: B:800:0x10f1, code skipped:
            r14 = java.lang.System.currentTimeMillis() - r33;
     */
    /* JADX WARNING: Missing block: B:802:?, code skipped:
            r12.setConnectedTime(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal((float) r14, false));
     */
    /* JADX WARNING: Missing block: B:803:0x10fd, code skipped:
            r14 = r41;
     */
    /* JADX WARNING: Missing block: B:805:0x1103, code skipped:
            if (r1.getMessage() == null) goto L_0x112d;
     */
    /* JADX WARNING: Missing block: B:810:0x111d, code skipped:
            r12.setDownloaded("0");
            r12.setDownloadTime("0");
            r12.setErrorType(com.ximalaya.ting.android.player.cdn.CdnConstants.SYSTEM_EXCEPTION);
     */
    /* JADX WARNING: Missing block: B:811:0x112d, code skipped:
            r12.setErrorType(com.ximalaya.ting.android.player.cdn.CdnConstants.CDN_IO_EXCEPTION);
     */
    /* JADX WARNING: Missing block: B:812:0x1132, code skipped:
            r12.setExceptionReason(com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r1));
            r12.setDownloadResult(com.ximalaya.ting.android.player.cdn.CdnConstants.DOWNLOAD_FAILED);
     */
    /* JADX WARNING: Missing block: B:813:0x113f, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:814:0x1140, code skipped:
            r2 = r0;
            r1 = r40;
            r14 = r41;
     */
    /* JADX WARNING: Missing block: B:815:0x1147, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:816:0x1148, code skipped:
            r41 = r14;
     */
    /* JADX WARNING: Missing block: B:823:0x1178, code skipped:
            r12.setViaInfo(null);
     */
    /* JADX WARNING: Missing block: B:826:0x1186, code skipped:
            r12.setStatusCode("");
     */
    /* JADX WARNING: Missing block: B:833:0x11ab, code skipped:
            r11.disconnect();
     */
    /* JADX WARNING: Missing block: B:836:?, code skipped:
            r9.close();
     */
    /* JADX WARNING: Missing block: B:840:?, code skipped:
            r7.close();
     */
    /* JADX WARNING: Missing block: B:843:0x11c1, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:844:0x11c2, code skipped:
            r40 = r2;
            r30 = r7;
            r33 = r8;
            r28 = r14;
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:851:0x11db, code skipped:
            r14 = java.lang.System.currentTimeMillis() - r33;
            r12.setConnectedTime(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal((float) r14, false));
     */
    /* JADX WARNING: Missing block: B:858:0x1232, code skipped:
            r12.setViaInfo(null);
     */
    /* JADX WARNING: Missing block: B:861:0x1240, code skipped:
            r12.setStatusCode("");
     */
    /* JADX WARNING: Missing block: B:868:0x1265, code skipped:
            r11.disconnect();
     */
    /* JADX WARNING: Missing block: B:871:?, code skipped:
            r9.close();
     */
    /* JADX WARNING: Missing block: B:875:?, code skipped:
            r7.close();
     */
    /* JADX WARNING: Missing block: B:878:0x127b, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:879:0x127c, code skipped:
            r2 = r0;
            r1 = r40;
     */
    /* JADX WARNING: Missing block: B:880:0x1281, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:881:0x1282, code skipped:
            r40 = r2;
            r30 = r7;
            r33 = r8;
            r28 = r14;
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:888:0x129b, code skipped:
            r14 = java.lang.System.currentTimeMillis() - r33;
            r12.setConnectedTime(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal((float) r14, false));
     */
    /* JADX WARNING: Missing block: B:894:0x12d8, code skipped:
            r12.setViaInfo(null);
     */
    /* JADX WARNING: Missing block: B:897:0x12e6, code skipped:
            r12.setStatusCode("");
     */
    /* JADX WARNING: Missing block: B:904:0x130b, code skipped:
            r11.disconnect();
     */
    /* JADX WARNING: Missing block: B:907:?, code skipped:
            r9.close();
     */
    /* JADX WARNING: Missing block: B:911:?, code skipped:
            r7.close();
     */
    /* JADX WARNING: Missing block: B:914:0x1321, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:915:0x1322, code skipped:
            r40 = r2;
            r30 = r7;
            r33 = r8;
            r28 = r14;
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:922:0x133b, code skipped:
            r14 = java.lang.System.currentTimeMillis() - r33;
            r12.setConnectedTime(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal((float) r14, false));
     */
    /* JADX WARNING: Missing block: B:928:0x1378, code skipped:
            r12.setViaInfo(null);
     */
    /* JADX WARNING: Missing block: B:931:0x1386, code skipped:
            r12.setStatusCode("");
     */
    /* JADX WARNING: Missing block: B:938:0x13ab, code skipped:
            r11.disconnect();
     */
    /* JADX WARNING: Missing block: B:941:?, code skipped:
            r9.close();
     */
    /* JADX WARNING: Missing block: B:945:?, code skipped:
            r7.close();
     */
    /* JADX WARNING: Missing block: B:948:0x13c1, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:949:0x13c2, code skipped:
            r40 = r2;
            r30 = r7;
            r33 = r8;
            r28 = r14;
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:956:0x13e0, code skipped:
            r14 = java.lang.System.currentTimeMillis() - r33;
            r12.setConnectedTime(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal((float) r14, false));
     */
    /* JADX WARNING: Missing block: B:959:0x13f9, code skipped:
            r12.setErrorType(com.ximalaya.ting.android.player.cdn.CdnConstants.CDN_SOCKET_TIMEOUT);
            r2 = new java.lang.StringBuilder();
            r2.append(java.lang.String.valueOf(r1));
            r2.append(com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r1));
            r12.setExceptionReason(r2.toString());
     */
    /* JADX WARNING: Missing block: B:960:0x1419, code skipped:
            r12.setErrorType(com.ximalaya.ting.android.player.cdn.CdnConstants.CDN_CONNECT_TIMEOUT);
            r12.setExceptionReason(com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r1));
     */
    /* JADX WARNING: Missing block: B:966:0x1446, code skipped:
            r12.setViaInfo(null);
     */
    /* JADX WARNING: Missing block: B:969:0x1454, code skipped:
            r12.setStatusCode("");
     */
    /* JADX WARNING: Missing block: B:976:0x1479, code skipped:
            r11.disconnect();
     */
    /* JADX WARNING: Missing block: B:979:?, code skipped:
            r9.close();
     */
    /* JADX WARNING: Missing block: B:983:?, code skipped:
            r7.close();
     */
    /* JADX WARNING: Missing block: B:988:0x14a5, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:989:0x14a6, code skipped:
            r40 = r2;
            r30 = r7;
            r33 = r8;
            r28 = r14;
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:995:0x14bd, code skipped:
            if (r12.getConnectedTime() <= com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) goto L_0x14bf;
     */
    /* JADX WARNING: Missing block: B:996:0x14bf, code skipped:
            r14 = java.lang.System.currentTimeMillis() - r33;
            r12.setConnectedTime(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal((float) r14, false));
     */
    /* JADX WARNING: Missing block: B:997:0x14ce, code skipped:
            r12.setErrorType(com.ximalaya.ting.android.player.cdn.CdnConstants.CDN_CONNECT_FAIL);
            r12.setExceptionReason(com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r1));
            r12.setDownloadSpeed("0.0");
            r12.setDownloaded("0");
            r12.setDownloadTime("0");
            r12.setDownloadResult(com.ximalaya.ting.android.player.cdn.CdnConstants.DOWNLOAD_FAILED);
     */
    /* JADX WARNING: Missing block: B:1005:0x1518, code skipped:
            r12.setViaInfo(null);
     */
    /* JADX WARNING: Missing block: B:1008:0x1526, code skipped:
            r12.setStatusCode("");
     */
    /* JADX WARNING: Missing block: B:1015:0x154b, code skipped:
            r11.disconnect();
     */
    /* JADX WARNING: Missing block: B:1018:?, code skipped:
            r9.close();
     */
    /* JADX WARNING: Missing block: B:1022:?, code skipped:
            r7.close();
     */
    /* JADX WARNING: Missing block: B:1031:0x158c, code skipped:
            r1 = r40;
            com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r12, r1);
     */
    /* JADX WARNING: Missing block: B:1041:0x15b2, code skipped:
            r12.setViaInfo(null);
     */
    /* JADX WARNING: Missing block: B:1044:0x15c0, code skipped:
            r12.setStatusCode("");
     */
    /* JADX WARNING: Missing block: B:1051:0x15e5, code skipped:
            r3 = r1.getNetType();
     */
    /* JADX WARNING: Missing block: B:1052:0x15ea, code skipped:
            if (r3 != -1) goto L_0x15ee;
     */
    /* JADX WARNING: Missing block: B:1053:0x15ee, code skipped:
            if (r3 == 0) goto L_0x15f0;
     */
    /* JADX WARNING: Missing block: B:1054:0x15f0, code skipped:
            r5 = r43;
            r5.mLimitConnectTime = (long) r1.getCdnNotWifiConnectTimeout();
            r5.mLimitDownloadSpeed = (long) r1.getCdnNotWifiAlertRate();
     */
    /* JADX WARNING: Missing block: B:1055:0x1606, code skipped:
            if (r14 > (r5.mLimitConnectTime * 1000)) goto L_0x1608;
     */
    /* JADX WARNING: Missing block: B:1056:0x1608, code skipped:
            r12.setErrorType(com.ximalaya.ting.android.player.cdn.CdnConstants.CDN_CONNECTED_TOO_SLOW);
            r1 = new java.lang.StringBuilder();
            r1.append("connected_time=");
            r1.append(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal((float) r14, false));
            r1.append("s, connected_time_threshold=");
            r1.append(r5.mLimitConnectTime);
            r1.append(com.umeng.commonsdk.proguard.e.ap);
            r12.setExceptionReason(r1.toString());
     */
    /* JADX WARNING: Missing block: B:1058:0x163d, code skipped:
            if (((float) r5.mLimitDownloadSpeed) > r10) goto L_0x163f;
     */
    /* JADX WARNING: Missing block: B:1059:0x163f, code skipped:
            r12.setErrorType(com.ximalaya.ting.android.player.cdn.CdnConstants.CDN_DOWNLOAD_TOO_SLOW);
            r1 = new java.lang.StringBuilder();
            r1.append("download_speed=");
            r1.append(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, true));
            r1.append("KB/s, download_speed_threshold=");
            r1.append(r5.mLimitDownloadSpeed);
            r1.append("KB/s");
            r12.setExceptionReason(r1.toString());
     */
    /* JADX WARNING: Missing block: B:1060:0x166e, code skipped:
            r5 = r43;
     */
    /* JADX WARNING: Missing block: B:1061:0x1671, code skipped:
            if (r3 == 1) goto L_0x1673;
     */
    /* JADX WARNING: Missing block: B:1062:0x1673, code skipped:
            r5.mLimitConnectTime = (long) r1.getCdnWifiConnectTimeout();
            r5.mLimitDownloadSpeed = (long) r1.getCdnWifiAlertRate();
            r5.mLimitConnectTime = 0;
     */
    /* JADX WARNING: Missing block: B:1063:0x168b, code skipped:
            if (r14 > (r5.mLimitConnectTime * 1000)) goto L_0x168d;
     */
    /* JADX WARNING: Missing block: B:1064:0x168d, code skipped:
            r12.setErrorType(com.ximalaya.ting.android.player.cdn.CdnConstants.CDN_CONNECTED_TOO_SLOW);
            r1 = new java.lang.StringBuilder();
            r1.append("connected_time=");
            r1.append(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal((float) r14, false));
            r1.append("s, connected_time_threshold=");
            r1.append(r5.mLimitConnectTime);
            r1.append(com.umeng.commonsdk.proguard.e.ap);
            r12.setExceptionReason(r1.toString());
     */
    /* JADX WARNING: Missing block: B:1066:0x16c1, code skipped:
            if (((float) r5.mLimitDownloadSpeed) > r10) goto L_0x16c3;
     */
    /* JADX WARNING: Missing block: B:1067:0x16c3, code skipped:
            r12.setErrorType(com.ximalaya.ting.android.player.cdn.CdnConstants.CDN_DOWNLOAD_TOO_SLOW);
            r1 = new java.lang.StringBuilder();
            r1.append("download_speed=");
            r1.append(com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, true));
            r1.append("KB/s, download_speed_threshold=");
            r1.append(r5.mLimitDownloadSpeed);
            r1.append("KB/s");
            r12.setExceptionReason(r1.toString());
     */
    /* JADX WARNING: Missing block: B:1070:0x16f5, code skipped:
            r11.disconnect();
     */
    /* JADX WARNING: Missing block: B:1073:?, code skipped:
            r9.close();
     */
    /* JADX WARNING: Missing block: B:1077:?, code skipped:
            r7.close();
     */
    public int download() {
        /*
        r43 = this;
        r1 = r43;
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.getCdnConfigModel();
        r4 = 1;
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        r5 = r4;
        goto L_0x000c;
    L_0x000b:
        r5 = 0;
    L_0x000c:
        r6 = 3;
        r7 = java.util.UUID.randomUUID();
        r7 = r7.toString();
        r10 = 0;
        r12 = 0;
        r13 = 0;
        r14 = 0;
        r16 = 0;
        r17 = 0;
    L_0x001e:
        r19 = r6 + -1;
        if (r6 <= 0) goto L_0x171f;
    L_0x0022:
        r8 = java.lang.System.currentTimeMillis();
        r6 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r3 = "DownloadThread hls readData start:";
        r11.append(r3);
        r11.append(r8);
        r3 = r11.toString();
        com.ximalaya.ting.android.player.Logger.log(r6, r3);
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r11 = "DownloadThread hls readData mCurrentDownloadUrl:";
        r6.append(r11);
        r11 = r1.mCurrentDownloadUrl;
        r6.append(r11);
        r6 = r6.toString();
        com.ximalaya.ting.android.player.Logger.log(r3, r6);
        if (r5 != 0) goto L_0x005c;
    L_0x0056:
        r3 = new com.ximalaya.ting.android.player.cdn.CdnCollectDataForPlay;
        r3.<init>();
        r12 = r3;
    L_0x005c:
        r22 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r11 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ MalformedURLException -> 0x14a5, SocketTimeoutException -> 0x13c1, UnknownHostException -> 0x1321, IllegalArgumentException -> 0x1281, FileNotFoundException -> 0x11c1, IOException -> 0x1068, Throwable -> 0x0f37, all -> 0x0f2b }
        r3 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r3.<init>();	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r6 = "HlsDownloadThread mPlayUrl:";
        r3.append(r6);	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r6 = r1.mCurrentDownloadUrl;	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r3.append(r6);	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r3 = r3.toString();	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        com.ximalaya.ting.android.player.Logger.log(r11, r3);	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r3 = new java.lang.String[r4];	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r6 = r1.mCurrentDownloadUrl;	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r11 = 0;
        r3[r11] = r6;	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r6 = r1.mCurrentDownloadUrl;	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        if (r6 == 0) goto L_0x00d3;
    L_0x0085:
        r6 = "";
        goto L_0x00dd;
    L_0x0089:
        r0 = move-exception;
        r1 = r2;
        r33 = r8;
        goto L_0x0f31;
    L_0x008f:
        r0 = move-exception;
        r3 = r0;
        r30 = r7;
        r33 = r8;
        goto L_0x0f3f;
    L_0x0097:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        goto L_0x1072;
    L_0x00a1:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        goto L_0x11cb;
    L_0x00ab:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        goto L_0x128b;
    L_0x00b5:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        goto L_0x132b;
    L_0x00bf:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        goto L_0x13cb;
    L_0x00c9:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        goto L_0x14af;
    L_0x00d3:
        r6 = r1.mCurrentDownloadUrl;	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r6 = android.net.Uri.parse(r6);	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
        r6 = r6.getHost();	 Catch:{ MalformedURLException -> 0x0f1f, SocketTimeoutException -> 0x0f13, UnknownHostException -> 0x0f07, IllegalArgumentException -> 0x0efb, FileNotFoundException -> 0x0eef, IOException -> 0x0ee3, Throwable -> 0x0f37, all -> 0x0f2b }
    L_0x00dd:
        r11 = 4;
        r4 = "GET";
        r27 = r6;
        r26 = r7;
        r6 = 0;
        r7 = 0;
        r11 = com.ximalaya.ting.android.player.PlayerUtil.getConnectionUseDnsCache(r3, r6, r11, r7, r4);	 Catch:{ MalformedURLException -> 0x0edb, SocketTimeoutException -> 0x0ed3, UnknownHostException -> 0x0ecb, IllegalArgumentException -> 0x0ec3, FileNotFoundException -> 0x0ebb, IOException -> 0x0eb3, Throwable -> 0x0eaa, all -> 0x0f2b }
        r3 = r3[r7];	 Catch:{ MalformedURLException -> 0x0e9c, SocketTimeoutException -> 0x0e8e, UnknownHostException -> 0x0e80, IllegalArgumentException -> 0x0e72, FileNotFoundException -> 0x0e64, IOException -> 0x0e54, Throwable -> 0x0e46, all -> 0x0e3c }
        r1.mCurrentDownloadUrl = r3;	 Catch:{ MalformedURLException -> 0x0e9c, SocketTimeoutException -> 0x0e8e, UnknownHostException -> 0x0e80, IllegalArgumentException -> 0x0e72, FileNotFoundException -> 0x0e64, IOException -> 0x0e54, Throwable -> 0x0e46, all -> 0x0e3c }
        if (r11 != 0) goto L_0x0265;
    L_0x00f0:
        if (r5 != 0) goto L_0x0239;
    L_0x00f2:
        if (r12 == 0) goto L_0x0239;
    L_0x00f4:
        r3 = r12.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0102;
    L_0x00fe:
        r3 = 0;
        r12.setViaInfo(r3);
    L_0x0102:
        r3 = r12.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0111;
    L_0x010c:
        r3 = "";
        r12.setStatusCode(r3);
    L_0x0111:
        r3 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r3);
        r3 = r12.getDownloadResult();
        if (r3 == 0) goto L_0x012a;
    L_0x011e:
        r3 = r12.getDownloadResult();
        r4 = "success";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x012f;
    L_0x012a:
        r3 = "failed";
        r12.setDownloadResult(r3);
    L_0x012f:
        if (r13 != 0) goto L_0x0239;
    L_0x0131:
        r3 = r2.getNetType();
        r4 = -1;
        if (r3 != r4) goto L_0x013b;
    L_0x0138:
        r5 = 1;
        goto L_0x0239;
    L_0x013b:
        if (r3 != 0) goto L_0x01b9;
    L_0x013d:
        r3 = r2.getCdnNotWifiConnectTimeout();
        r3 = (long) r3;
        r1.mLimitConnectTime = r3;
        r3 = r2.getCdnNotWifiAlertRate();
        r3 = (long) r3;
        r1.mLimitDownloadSpeed = r3;
        r3 = r1.mLimitConnectTime;
        r3 = r3 * r22;
        r6 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1));
        if (r6 <= 0) goto L_0x0183;
    L_0x0153:
        r3 = "cdn_connected_too_slow";
        r12.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "connected_time=";
        r3.append(r4);
        r4 = (float) r14;
        r6 = 0;
        r4 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r4, r6);
        r3.append(r4);
        r4 = "s, connected_time_threshold=";
        r3.append(r4);
        r6 = r1.mLimitConnectTime;
        r3.append(r6);
        r4 = "s";
        r3.append(r4);
        r3 = r3.toString();
        r12.setExceptionReason(r3);
        goto L_0x0239;
    L_0x0183:
        r3 = r1.mLimitDownloadSpeed;
        r3 = (float) r3;
        r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x0239;
    L_0x018a:
        r3 = "cdn_download_too_slow";
        r12.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "download_speed=";
        r3.append(r4);
        r4 = 1;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r4);
        r3.append(r6);
        r4 = "KB/s, download_speed_threshold=";
        r3.append(r4);
        r6 = r1.mLimitDownloadSpeed;
        r3.append(r6);
        r4 = "KB/s";
        r3.append(r4);
        r3 = r3.toString();
        r12.setExceptionReason(r3);
        goto L_0x0239;
    L_0x01b9:
        r4 = 1;
        if (r3 != r4) goto L_0x0239;
    L_0x01bc:
        r3 = r2.getCdnWifiConnectTimeout();
        r3 = (long) r3;
        r1.mLimitConnectTime = r3;
        r3 = r2.getCdnWifiAlertRate();
        r3 = (long) r3;
        r1.mLimitDownloadSpeed = r3;
        r3 = 0;
        r1.mLimitConnectTime = r3;
        r3 = r1.mLimitConnectTime;
        r3 = r3 * r22;
        r6 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1));
        if (r6 <= 0) goto L_0x0205;
    L_0x01d6:
        r3 = "cdn_connected_too_slow";
        r12.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "connected_time=";
        r3.append(r4);
        r4 = (float) r14;
        r6 = 0;
        r4 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r4, r6);
        r3.append(r4);
        r4 = "s, connected_time_threshold=";
        r3.append(r4);
        r6 = r1.mLimitConnectTime;
        r3.append(r6);
        r4 = "s";
        r3.append(r4);
        r3 = r3.toString();
        r12.setExceptionReason(r3);
        goto L_0x0239;
    L_0x0205:
        r3 = r1.mLimitDownloadSpeed;
        r3 = (float) r3;
        r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x0239;
    L_0x020c:
        r3 = "cdn_download_too_slow";
        r12.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "download_speed=";
        r3.append(r4);
        r4 = 1;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r4);
        r3.append(r6);
        r4 = "KB/s, download_speed_threshold=";
        r3.append(r4);
        r6 = r1.mLimitDownloadSpeed;
        r3.append(r6);
        r4 = "KB/s";
        r3.append(r4);
        r3 = r3.toString();
        r12.setExceptionReason(r3);
    L_0x0239:
        if (r11 == 0) goto L_0x023e;
    L_0x023b:
        r11.disconnect();
    L_0x023e:
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "DownloadThread hls readData end:";
        r4.append(r6);
        r6 = java.lang.System.currentTimeMillis();
        r28 = r14;
        r14 = r6 - r8;
        r4.append(r14);
        r4 = r4.toString();
        com.ximalaya.ting.android.player.Logger.log(r3, r4);
        r6 = r19;
        r7 = r26;
        r14 = r28;
    L_0x0262:
        r4 = 1;
        goto L_0x001e;
    L_0x0265:
        r28 = r14;
        if (r12 == 0) goto L_0x034c;
    L_0x0269:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x0340, SocketTimeoutException -> 0x0334, UnknownHostException -> 0x0328, IllegalArgumentException -> 0x031c, FileNotFoundException -> 0x0310, IOException -> 0x0302, Throwable -> 0x02f6, all -> 0x02ee }
        r14 = r3 - r8;
        r3 = (float) r14;
        r4 = 0;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r3, r4);	 Catch:{ MalformedURLException -> 0x02e4, SocketTimeoutException -> 0x02da, UnknownHostException -> 0x02d0, IllegalArgumentException -> 0x02c6, FileNotFoundException -> 0x02bc, IOException -> 0x02b0, Throwable -> 0x02a6, all -> 0x02a0 }
        r12.setConnectedTime(r3);	 Catch:{ MalformedURLException -> 0x02e4, SocketTimeoutException -> 0x02da, UnknownHostException -> 0x02d0, IllegalArgumentException -> 0x02c6, FileNotFoundException -> 0x02bc, IOException -> 0x02b0, Throwable -> 0x02a6, all -> 0x02a0 }
        r3 = r1.mCurrentDownloadUrl;	 Catch:{ MalformedURLException -> 0x02e4, SocketTimeoutException -> 0x02da, UnknownHostException -> 0x02d0, IllegalArgumentException -> 0x02c6, FileNotFoundException -> 0x02bc, IOException -> 0x02b0, Throwable -> 0x02a6, all -> 0x02a0 }
        r12.setAudioUrl(r3);	 Catch:{ MalformedURLException -> 0x02e4, SocketTimeoutException -> 0x02da, UnknownHostException -> 0x02d0, IllegalArgumentException -> 0x02c6, FileNotFoundException -> 0x02bc, IOException -> 0x02b0, Throwable -> 0x02a6, all -> 0x02a0 }
        r3 = r1.mCurrentDownloadUrl;	 Catch:{ MalformedURLException -> 0x02e4, SocketTimeoutException -> 0x02da, UnknownHostException -> 0x02d0, IllegalArgumentException -> 0x02c6, FileNotFoundException -> 0x02bc, IOException -> 0x02b0, Throwable -> 0x02a6, all -> 0x02a0 }
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.getUrlIp(r3);	 Catch:{ MalformedURLException -> 0x02e4, SocketTimeoutException -> 0x02da, UnknownHostException -> 0x02d0, IllegalArgumentException -> 0x02c6, FileNotFoundException -> 0x02bc, IOException -> 0x02b0, Throwable -> 0x02a6, all -> 0x02a0 }
        r12.setCdnIP(r3);	 Catch:{ MalformedURLException -> 0x02e4, SocketTimeoutException -> 0x02da, UnknownHostException -> 0x02d0, IllegalArgumentException -> 0x02c6, FileNotFoundException -> 0x02bc, IOException -> 0x02b0, Throwable -> 0x02a6, all -> 0x02a0 }
        r6 = r27;
        r12.setCdnDomain(r6);	 Catch:{ MalformedURLException -> 0x02e4, SocketTimeoutException -> 0x02da, UnknownHostException -> 0x02d0, IllegalArgumentException -> 0x02c6, FileNotFoundException -> 0x02bc, IOException -> 0x02b0, Throwable -> 0x02a6, all -> 0x02a0 }
        r3 = "play_hls";
        r12.setType(r3);	 Catch:{ MalformedURLException -> 0x02e4, SocketTimeoutException -> 0x02da, UnknownHostException -> 0x02d0, IllegalArgumentException -> 0x02c6, FileNotFoundException -> 0x02bc, IOException -> 0x02b0, Throwable -> 0x02a6, all -> 0x02a0 }
        r3 = "via";
        r3 = r11.getHeaderField(r3);	 Catch:{ MalformedURLException -> 0x02e4, SocketTimeoutException -> 0x02da, UnknownHostException -> 0x02d0, IllegalArgumentException -> 0x02c6, FileNotFoundException -> 0x02bc, IOException -> 0x02b0, Throwable -> 0x02a6, all -> 0x02a0 }
        r12.setViaInfo(r3);	 Catch:{ MalformedURLException -> 0x02e4, SocketTimeoutException -> 0x02da, UnknownHostException -> 0x02d0, IllegalArgumentException -> 0x02c6, FileNotFoundException -> 0x02bc, IOException -> 0x02b0, Throwable -> 0x02a6, all -> 0x02a0 }
        r3 = r26;
        r12.setRequestUUID(r3);	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        goto L_0x0350;
    L_0x02a0:
        r0 = move-exception;
    L_0x02a1:
        r1 = r2;
        r33 = r8;
        goto L_0x0e42;
    L_0x02a6:
        r0 = move-exception;
        r3 = r0;
        r33 = r8;
        r8 = r16;
        r30 = r26;
        goto L_0x0e50;
    L_0x02b0:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r8 = r16;
        r30 = r26;
        goto L_0x0e60;
    L_0x02bc:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r30 = r26;
        goto L_0x0e6e;
    L_0x02c6:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r30 = r26;
        goto L_0x0e7c;
    L_0x02d0:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r30 = r26;
        goto L_0x0e8a;
    L_0x02da:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r30 = r26;
        goto L_0x0e98;
    L_0x02e4:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r30 = r26;
        goto L_0x0ea6;
    L_0x02ee:
        r0 = move-exception;
        r1 = r2;
        r33 = r8;
        r14 = r28;
        goto L_0x0e42;
    L_0x02f6:
        r0 = move-exception;
        r3 = r0;
        r33 = r8;
        r8 = r16;
        r30 = r26;
        r14 = r28;
        goto L_0x0e50;
    L_0x0302:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r8 = r16;
        r30 = r26;
        r14 = r28;
        goto L_0x0e60;
    L_0x0310:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r30 = r26;
        r14 = r28;
        goto L_0x0e6e;
    L_0x031c:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r30 = r26;
        r14 = r28;
        goto L_0x0e7c;
    L_0x0328:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r30 = r26;
        r14 = r28;
        goto L_0x0e8a;
    L_0x0334:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r30 = r26;
        r14 = r28;
        goto L_0x0e98;
    L_0x0340:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
        r30 = r26;
        r14 = r28;
        goto L_0x0ea6;
    L_0x034c:
        r3 = r26;
        r14 = r28;
    L_0x0350:
        r4 = r11.getResponseCode();	 Catch:{ MalformedURLException -> 0x0e35, SocketTimeoutException -> 0x0e2e, UnknownHostException -> 0x0e27, IllegalArgumentException -> 0x0e21, FileNotFoundException -> 0x0e1b, IOException -> 0x0e15, Throwable -> 0x0e0f, all -> 0x0e0b }
        if (r12 == 0) goto L_0x03cb;
    L_0x0356:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        r14 = r6 - r8;
        r6 = (float) r14;	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        r7 = 0;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r6, r7);	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        r12.setConnectedTime(r6);	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        r6 = "via";
        r6 = r11.getHeaderField(r6);	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        r12.setViaInfo(r6);	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        r6 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        r6.<init>();	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        r6.append(r4);	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        r7 = "";
        r6.append(r7);	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        r6 = r6.toString();	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        r12.setStatusCode(r6);	 Catch:{ MalformedURLException -> 0x03c1, SocketTimeoutException -> 0x03b7, UnknownHostException -> 0x03ad, IllegalArgumentException -> 0x03a3, FileNotFoundException -> 0x0399, IOException -> 0x038f, Throwable -> 0x0383, all -> 0x02a0 }
        goto L_0x03cb;
    L_0x0383:
        r0 = move-exception;
        r30 = r3;
        r33 = r8;
        r8 = r16;
    L_0x038a:
        r7 = 0;
        r9 = 0;
    L_0x038c:
        r3 = r0;
        goto L_0x0f44;
    L_0x038f:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r3;
    L_0x0395:
        r33 = r8;
        goto L_0x0e5e;
    L_0x0399:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r3;
    L_0x039f:
        r33 = r8;
        goto L_0x0e6e;
    L_0x03a3:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r3;
    L_0x03a9:
        r33 = r8;
        goto L_0x0e7c;
    L_0x03ad:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r3;
    L_0x03b3:
        r33 = r8;
        goto L_0x0e8a;
    L_0x03b7:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r3;
    L_0x03bd:
        r33 = r8;
        goto L_0x0e98;
    L_0x03c1:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r30 = r3;
    L_0x03c7:
        r33 = r8;
        goto L_0x0ea6;
    L_0x03cb:
        r6 = "Content-Range";
        r6 = r11.getHeaderField(r6);	 Catch:{ MalformedURLException -> 0x0e35, SocketTimeoutException -> 0x0e2e, UnknownHostException -> 0x0e27, IllegalArgumentException -> 0x0e21, FileNotFoundException -> 0x0e1b, IOException -> 0x0e15, Throwable -> 0x0e0f, all -> 0x0e0b }
        r7 = android.text.TextUtils.isEmpty(r6);	 Catch:{ MalformedURLException -> 0x0e35, SocketTimeoutException -> 0x0e2e, UnknownHostException -> 0x0e27, IllegalArgumentException -> 0x0e21, FileNotFoundException -> 0x0e1b, IOException -> 0x0e15, Throwable -> 0x0e0f, all -> 0x0e0b }
        if (r7 != 0) goto L_0x0480;
    L_0x03d7:
        r7 = "/";
        r6 = r6.split(r7);	 Catch:{ MalformedURLException -> 0x0476, SocketTimeoutException -> 0x046c, UnknownHostException -> 0x0462, IllegalArgumentException -> 0x0458, FileNotFoundException -> 0x044e, IOException -> 0x0444, Throwable -> 0x043a, all -> 0x0435 }
        r7 = "";
        r26 = "";
        r30 = r3;
        r3 = r6.length;	 Catch:{ MalformedURLException -> 0x0433, SocketTimeoutException -> 0x0431, UnknownHostException -> 0x042f, IllegalArgumentException -> 0x042d, FileNotFoundException -> 0x042b, IOException -> 0x0429, Throwable -> 0x0427, all -> 0x0435 }
        r31 = r7;
        r7 = 2;
        if (r3 < r7) goto L_0x0417;
    L_0x03e9:
        r3 = 0;
        r7 = r6[r3];	 Catch:{ MalformedURLException -> 0x0433, SocketTimeoutException -> 0x0431, UnknownHostException -> 0x042f, IllegalArgumentException -> 0x042d, FileNotFoundException -> 0x042b, IOException -> 0x0429, Throwable -> 0x0427, all -> 0x0435 }
        r7 = android.text.TextUtils.isEmpty(r7);	 Catch:{ MalformedURLException -> 0x0433, SocketTimeoutException -> 0x0431, UnknownHostException -> 0x042f, IllegalArgumentException -> 0x042d, FileNotFoundException -> 0x042b, IOException -> 0x0429, Throwable -> 0x0427, all -> 0x0435 }
        if (r7 != 0) goto L_0x0405;
    L_0x03f2:
        r7 = r6[r3];	 Catch:{ MalformedURLException -> 0x0433, SocketTimeoutException -> 0x0431, UnknownHostException -> 0x042f, IllegalArgumentException -> 0x042d, FileNotFoundException -> 0x042b, IOException -> 0x0429, Throwable -> 0x0427, all -> 0x0435 }
        r3 = " ";
        r3 = r7.split(r3);	 Catch:{ MalformedURLException -> 0x0433, SocketTimeoutException -> 0x0431, UnknownHostException -> 0x042f, IllegalArgumentException -> 0x042d, FileNotFoundException -> 0x042b, IOException -> 0x0429, Throwable -> 0x0427, all -> 0x0435 }
        r7 = r3.length;	 Catch:{ MalformedURLException -> 0x0433, SocketTimeoutException -> 0x0431, UnknownHostException -> 0x042f, IllegalArgumentException -> 0x042d, FileNotFoundException -> 0x042b, IOException -> 0x0429, Throwable -> 0x0427, all -> 0x0435 }
        r32 = r10;
        r10 = 2;
        if (r7 < r10) goto L_0x0407;
    L_0x0400:
        r7 = 1;
        r3 = r3[r7];	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r7 = r3;
        goto L_0x0409;
    L_0x0405:
        r32 = r10;
    L_0x0407:
        r7 = r31;
    L_0x0409:
        r3 = 1;
        r10 = r6[r3];	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r10 = android.text.TextUtils.isEmpty(r10);	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        if (r10 != 0) goto L_0x0414;
    L_0x0412:
        r26 = r6[r3];	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
    L_0x0414:
        r3 = r26;
        goto L_0x041d;
    L_0x0417:
        r32 = r10;
        r3 = r26;
        r7 = r31;
    L_0x041d:
        if (r12 == 0) goto L_0x0484;
    L_0x041f:
        r12.setRange(r7);	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r12.setFileSize(r3);	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        goto L_0x0484;
    L_0x0427:
        r0 = move-exception;
        goto L_0x043d;
    L_0x0429:
        r0 = move-exception;
        goto L_0x0447;
    L_0x042b:
        r0 = move-exception;
        goto L_0x0451;
    L_0x042d:
        r0 = move-exception;
        goto L_0x045b;
    L_0x042f:
        r0 = move-exception;
        goto L_0x0465;
    L_0x0431:
        r0 = move-exception;
        goto L_0x046f;
    L_0x0433:
        r0 = move-exception;
        goto L_0x0479;
    L_0x0435:
        r0 = move-exception;
        r32 = r10;
        goto L_0x02a1;
    L_0x043a:
        r0 = move-exception;
        r30 = r3;
    L_0x043d:
        r32 = r10;
        r3 = r0;
        r33 = r8;
        goto L_0x0e4e;
    L_0x0444:
        r0 = move-exception;
        r30 = r3;
    L_0x0447:
        r32 = r10;
        r1 = r0;
        r40 = r2;
        goto L_0x0395;
    L_0x044e:
        r0 = move-exception;
        r30 = r3;
    L_0x0451:
        r32 = r10;
        r1 = r0;
        r40 = r2;
        goto L_0x039f;
    L_0x0458:
        r0 = move-exception;
        r30 = r3;
    L_0x045b:
        r32 = r10;
        r1 = r0;
        r40 = r2;
        goto L_0x03a9;
    L_0x0462:
        r0 = move-exception;
        r30 = r3;
    L_0x0465:
        r32 = r10;
        r1 = r0;
        r40 = r2;
        goto L_0x03b3;
    L_0x046c:
        r0 = move-exception;
        r30 = r3;
    L_0x046f:
        r32 = r10;
        r1 = r0;
        r40 = r2;
        goto L_0x03bd;
    L_0x0476:
        r0 = move-exception;
        r30 = r3;
    L_0x0479:
        r32 = r10;
        r1 = r0;
        r40 = r2;
        goto L_0x03c7;
    L_0x0480:
        r30 = r3;
        r32 = r10;
    L_0x0484:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 == r3) goto L_0x050b;
    L_0x0488:
        r3 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r4 != r3) goto L_0x048e;
    L_0x048c:
        goto L_0x050b;
    L_0x048e:
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r6 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r6.<init>();	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r7 = "HlsDownloadThread fail responseCode:";
        r6.append(r7);	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r6.append(r4);	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r6 = r6.toString();	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        com.ximalaya.ting.android.player.Logger.log(r3, r6);	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r3 = new java.io.IOException;	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r6 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r6.<init>();	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r7 = "HlsDownloadThread fail responseCode:";
        r6.append(r7);	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r6.append(r4);	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r4 = r6.toString();	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        r3.<init>(r4);	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
        throw r3;	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
    L_0x04bb:
        r0 = move-exception;
        r1 = r2;
        r33 = r8;
    L_0x04bf:
        r10 = r32;
        goto L_0x0e42;
    L_0x04c3:
        r0 = move-exception;
        r3 = r0;
        r33 = r8;
    L_0x04c7:
        r8 = r16;
        r10 = r32;
        goto L_0x0e50;
    L_0x04cd:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
    L_0x04d3:
        r8 = r16;
        r10 = r32;
        goto L_0x0e60;
    L_0x04d9:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
    L_0x04df:
        r10 = r32;
        goto L_0x0e6e;
    L_0x04e3:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
    L_0x04e9:
        r10 = r32;
        goto L_0x0e7c;
    L_0x04ed:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
    L_0x04f3:
        r10 = r32;
        goto L_0x0e8a;
    L_0x04f7:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
    L_0x04fd:
        r10 = r32;
        goto L_0x0e98;
    L_0x0501:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r33 = r8;
    L_0x0507:
        r10 = r32;
        goto L_0x0ea6;
    L_0x050b:
        r3 = r11.getContentLength();	 Catch:{ MalformedURLException -> 0x0e04, SocketTimeoutException -> 0x0dfd, UnknownHostException -> 0x0df6, IllegalArgumentException -> 0x0def, FileNotFoundException -> 0x0de8, IOException -> 0x0de1, Throwable -> 0x0dda, all -> 0x0dd3 }
        if (r12 == 0) goto L_0x0515;
    L_0x0511:
        r6 = (long) r3;
        r12.setAudioBytes(r6);	 Catch:{ MalformedURLException -> 0x0501, SocketTimeoutException -> 0x04f7, UnknownHostException -> 0x04ed, IllegalArgumentException -> 0x04e3, FileNotFoundException -> 0x04d9, IOException -> 0x04cd, Throwable -> 0x04c3, all -> 0x04bb }
    L_0x0515:
        if (r3 <= 0) goto L_0x0c32;
    L_0x0517:
        r4 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
        if (r3 <= r4) goto L_0x051d;
    L_0x051b:
        goto L_0x0c32;
    L_0x051d:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x0c2a, SocketTimeoutException -> 0x0c22, UnknownHostException -> 0x0c1a, IllegalArgumentException -> 0x0c12, FileNotFoundException -> 0x0c0a, IOException -> 0x0c02, Throwable -> 0x0bfc, all -> 0x0bf6 }
        r6 = r11.getInputStream();	 Catch:{ MalformedURLException -> 0x0bec, SocketTimeoutException -> 0x0be2, UnknownHostException -> 0x0bd8, IllegalArgumentException -> 0x0bce, FileNotFoundException -> 0x0bc4, IOException -> 0x0bba, Throwable -> 0x0baf, all -> 0x0bf6 }
        r7 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ MalformedURLException -> 0x0ba1, SocketTimeoutException -> 0x0b93, UnknownHostException -> 0x0b85, IllegalArgumentException -> 0x0b77, FileNotFoundException -> 0x0b69, IOException -> 0x0b59, Throwable -> 0x0b4c, all -> 0x0b42 }
        r10 = "HlsDownloadThread 0";
        com.ximalaya.ting.android.player.Logger.log(r7, r10);	 Catch:{ MalformedURLException -> 0x0ba1, SocketTimeoutException -> 0x0b93, UnknownHostException -> 0x0b85, IllegalArgumentException -> 0x0b77, FileNotFoundException -> 0x0b69, IOException -> 0x0b59, Throwable -> 0x0b4c, all -> 0x0b42 }
        r7 = r1.mBufferItem;	 Catch:{ MalformedURLException -> 0x0ba1, SocketTimeoutException -> 0x0b93, UnknownHostException -> 0x0b85, IllegalArgumentException -> 0x0b77, FileNotFoundException -> 0x0b69, IOException -> 0x0b59, Throwable -> 0x0b4c, all -> 0x0b42 }
        if (r7 == 0) goto L_0x05a6;
    L_0x0530:
        r7 = new java.io.ByteArrayOutputStream;	 Catch:{ MalformedURLException -> 0x0598, SocketTimeoutException -> 0x058a, UnknownHostException -> 0x057c, IllegalArgumentException -> 0x056e, FileNotFoundException -> 0x0560, IOException -> 0x0550, Throwable -> 0x0542, all -> 0x0537 }
        r7.<init>();	 Catch:{ MalformedURLException -> 0x0598, SocketTimeoutException -> 0x058a, UnknownHostException -> 0x057c, IllegalArgumentException -> 0x056e, FileNotFoundException -> 0x0560, IOException -> 0x0550, Throwable -> 0x0542, all -> 0x0537 }
        goto L_0x05a7;
    L_0x0537:
        r0 = move-exception;
        r1 = r2;
        r33 = r8;
        r10 = r32;
        r7 = 0;
        r2 = r0;
        r9 = r6;
        goto L_0x15a4;
    L_0x0542:
        r0 = move-exception;
        r17 = r3;
        r33 = r8;
        r8 = r16;
        r10 = r32;
        r7 = 0;
        r3 = r0;
        r9 = r6;
        goto L_0x0f44;
    L_0x0550:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r33 = r8;
        r8 = r16;
        r10 = r32;
        r7 = 0;
        r9 = r6;
        goto L_0x1077;
    L_0x0560:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r33 = r8;
        r10 = r32;
        r7 = 0;
        r9 = r6;
        goto L_0x11ce;
    L_0x056e:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r33 = r8;
        r10 = r32;
        r7 = 0;
        r9 = r6;
        goto L_0x128e;
    L_0x057c:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r33 = r8;
        r10 = r32;
        r7 = 0;
        r9 = r6;
        goto L_0x132e;
    L_0x058a:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r33 = r8;
        r10 = r32;
        r7 = 0;
        r9 = r6;
        goto L_0x13ce;
    L_0x0598:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r33 = r8;
        r10 = r32;
        r7 = 0;
        r9 = r6;
        goto L_0x14b2;
    L_0x05a6:
        r7 = 0;
    L_0x05a7:
        r10 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r10 = new byte[r10];	 Catch:{ MalformedURLException -> 0x0b35, SocketTimeoutException -> 0x0b28, UnknownHostException -> 0x0b1b, IllegalArgumentException -> 0x0b0e, FileNotFoundException -> 0x0b01, IOException -> 0x0af2, Throwable -> 0x0ae6, all -> 0x0add }
        r33 = r8;
        r8 = 0;
    L_0x05ae:
        r9 = r6.read(r10);	 Catch:{ MalformedURLException -> 0x0ada, SocketTimeoutException -> 0x0ad7, UnknownHostException -> 0x0ad5, IllegalArgumentException -> 0x0ad3, FileNotFoundException -> 0x0ad1, IOException -> 0x0acf, Throwable -> 0x0acd, all -> 0x0acb }
        r35 = r6;
        r6 = -1;
        if (r9 == r6) goto L_0x0624;
    L_0x05b7:
        r6 = r8 + r9;
        if (r7 == 0) goto L_0x061e;
    L_0x05bb:
        r8 = 0;
        r7.write(r10, r8, r9);	 Catch:{ MalformedURLException -> 0x0612, SocketTimeoutException -> 0x0606, UnknownHostException -> 0x05fa, IllegalArgumentException -> 0x05ee, FileNotFoundException -> 0x05e2, IOException -> 0x05d4, Throwable -> 0x05c9, all -> 0x05c1 }
        goto L_0x061e;
    L_0x05c1:
        r0 = move-exception;
    L_0x05c2:
        r1 = r2;
        r10 = r32;
        r9 = r35;
        goto L_0x0f34;
    L_0x05c9:
        r0 = move-exception;
        r17 = r3;
        r8 = r16;
    L_0x05ce:
        r10 = r32;
        r9 = r35;
        goto L_0x038c;
    L_0x05d4:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r8 = r16;
    L_0x05dc:
        r10 = r32;
        r9 = r35;
        goto L_0x1077;
    L_0x05e2:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
    L_0x05e8:
        r10 = r32;
        r9 = r35;
        goto L_0x11ce;
    L_0x05ee:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
    L_0x05f4:
        r10 = r32;
        r9 = r35;
        goto L_0x128e;
    L_0x05fa:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
    L_0x0600:
        r10 = r32;
        r9 = r35;
        goto L_0x132e;
    L_0x0606:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
    L_0x060c:
        r10 = r32;
        r9 = r35;
        goto L_0x13ce;
    L_0x0612:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
    L_0x0618:
        r10 = r32;
        r9 = r35;
        goto L_0x14b2;
    L_0x061e:
        r8 = r6;
        r16 = r8;
        r6 = r35;
        goto L_0x05ae;
    L_0x0624:
        if (r12 == 0) goto L_0x0763;
    L_0x0626:
        if (r8 <= 0) goto L_0x0646;
    L_0x0628:
        r6 = -1;
        if (r9 != r6) goto L_0x0646;
    L_0x062b:
        r6 = "success";
        r12.setDownloadResult(r6);	 Catch:{ MalformedURLException -> 0x0643, SocketTimeoutException -> 0x0640, UnknownHostException -> 0x063d, IllegalArgumentException -> 0x063a, FileNotFoundException -> 0x0637, IOException -> 0x0634, Throwable -> 0x0631, all -> 0x05c1 }
        goto L_0x064b;
    L_0x0631:
        r0 = move-exception;
        goto L_0x0719;
    L_0x0634:
        r0 = move-exception;
        goto L_0x0720;
    L_0x0637:
        r0 = move-exception;
        goto L_0x072a;
    L_0x063a:
        r0 = move-exception;
        goto L_0x0736;
    L_0x063d:
        r0 = move-exception;
        goto L_0x0742;
    L_0x0640:
        r0 = move-exception;
        goto L_0x074e;
    L_0x0643:
        r0 = move-exception;
        goto L_0x075a;
    L_0x0646:
        r6 = "failed";
        r12.setDownloadResult(r6);	 Catch:{ MalformedURLException -> 0x0757, SocketTimeoutException -> 0x074b, UnknownHostException -> 0x073f, IllegalArgumentException -> 0x0733, FileNotFoundException -> 0x0727, IOException -> 0x071d, Throwable -> 0x0716, all -> 0x0711 }
    L_0x064b:
        r9 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x0757, SocketTimeoutException -> 0x074b, UnknownHostException -> 0x073f, IllegalArgumentException -> 0x0733, FileNotFoundException -> 0x0727, IOException -> 0x071d, Throwable -> 0x0716, all -> 0x0711 }
        r36 = r14;
        r14 = r9 - r3;
        r9 = 0;
        r6 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1));
        if (r6 == 0) goto L_0x0667;
    L_0x0659:
        r6 = (float) r8;
        r9 = 0;
        r6 = r6 + r9;
        r10 = 1149239296; // 0x44800000 float:1024.0 double:5.67799655E-315;
        r6 = r6 / r10;
        r10 = (float) r14;
        r10 = r10 + r9;
        r9 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r10 = r10 / r9;
        r10 = r6 / r10;
        goto L_0x0669;
    L_0x0667:
        r10 = r32;
    L_0x0669:
        r6 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r6.<init>();	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r6.append(r8);	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r9 = "";
        r6.append(r9);	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r6 = r6.toString();	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r12.setDownloaded(r6);	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r6 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r6.<init>();	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r6.append(r14);	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r9 = "";
        r6.append(r9);	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r6 = r6.toString();	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r12.setDownloadTime(r6);	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r6 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r6.<init>();	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r9 = 1;
        r14 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r9);	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r6.append(r14);	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r9 = "";
        r6.append(r9);	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r6 = r6.toString();	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r12.setDownloadSpeed(r6);	 Catch:{ MalformedURLException -> 0x0703, SocketTimeoutException -> 0x06f5, UnknownHostException -> 0x06e7, IllegalArgumentException -> 0x06d9, FileNotFoundException -> 0x06cb, IOException -> 0x06bf, Throwable -> 0x06b6, all -> 0x06ae }
        r16 = r8;
        goto L_0x0767;
    L_0x06ae:
        r0 = move-exception;
        r1 = r2;
        r9 = r35;
        r14 = r36;
        goto L_0x0f34;
    L_0x06b6:
        r0 = move-exception;
        r17 = r3;
        r9 = r35;
        r14 = r36;
        goto L_0x038c;
    L_0x06bf:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r9 = r35;
        r14 = r36;
        goto L_0x1077;
    L_0x06cb:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r16 = r8;
        r9 = r35;
        r14 = r36;
        goto L_0x11ce;
    L_0x06d9:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r16 = r8;
        r9 = r35;
        r14 = r36;
        goto L_0x128e;
    L_0x06e7:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r16 = r8;
        r9 = r35;
        r14 = r36;
        goto L_0x132e;
    L_0x06f5:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r16 = r8;
        r9 = r35;
        r14 = r36;
        goto L_0x13ce;
    L_0x0703:
        r0 = move-exception;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r16 = r8;
        r9 = r35;
        r14 = r36;
        goto L_0x14b2;
    L_0x0711:
        r0 = move-exception;
        r36 = r14;
        goto L_0x05c2;
    L_0x0716:
        r0 = move-exception;
        r36 = r14;
    L_0x0719:
        r17 = r3;
        goto L_0x05ce;
    L_0x071d:
        r0 = move-exception;
        r36 = r14;
    L_0x0720:
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x05dc;
    L_0x0727:
        r0 = move-exception;
        r36 = r14;
    L_0x072a:
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r16 = r8;
        goto L_0x05e8;
    L_0x0733:
        r0 = move-exception;
        r36 = r14;
    L_0x0736:
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r16 = r8;
        goto L_0x05f4;
    L_0x073f:
        r0 = move-exception;
        r36 = r14;
    L_0x0742:
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r16 = r8;
        goto L_0x0600;
    L_0x074b:
        r0 = move-exception;
        r36 = r14;
    L_0x074e:
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r16 = r8;
        goto L_0x060c;
    L_0x0757:
        r0 = move-exception;
        r36 = r14;
    L_0x075a:
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r16 = r8;
        goto L_0x0618;
    L_0x0763:
        r36 = r14;
        r10 = r32;
    L_0x0767:
        if (r7 == 0) goto L_0x0953;
    L_0x0769:
        r6 = r1.mBufferItem;	 Catch:{ MalformedURLException -> 0x0947, SocketTimeoutException -> 0x093b, UnknownHostException -> 0x092f, IllegalArgumentException -> 0x0923, FileNotFoundException -> 0x0917, IOException -> 0x0909, Throwable -> 0x08fe, all -> 0x08f6 }
        if (r6 == 0) goto L_0x0953;
    L_0x076d:
        r6 = r1.mBufferItem;	 Catch:{ MalformedURLException -> 0x0947, SocketTimeoutException -> 0x093b, UnknownHostException -> 0x092f, IllegalArgumentException -> 0x0923, FileNotFoundException -> 0x0917, IOException -> 0x0909, Throwable -> 0x08fe, all -> 0x08f6 }
        r8 = r7.toByteArray();	 Catch:{ MalformedURLException -> 0x0947, SocketTimeoutException -> 0x093b, UnknownHostException -> 0x092f, IllegalArgumentException -> 0x0923, FileNotFoundException -> 0x0917, IOException -> 0x0909, Throwable -> 0x08fe, all -> 0x08f6 }
        r6.setBuffer(r8);	 Catch:{ MalformedURLException -> 0x0947, SocketTimeoutException -> 0x093b, UnknownHostException -> 0x092f, IllegalArgumentException -> 0x0923, FileNotFoundException -> 0x0917, IOException -> 0x0909, Throwable -> 0x08fe, all -> 0x08f6 }
        r6 = r1.mBufferItem;	 Catch:{ MalformedURLException -> 0x0947, SocketTimeoutException -> 0x093b, UnknownHostException -> 0x092f, IllegalArgumentException -> 0x0923, FileNotFoundException -> 0x0917, IOException -> 0x0909, Throwable -> 0x08fe, all -> 0x08f6 }
        r6 = r6.getDataSize();	 Catch:{ MalformedURLException -> 0x0947, SocketTimeoutException -> 0x093b, UnknownHostException -> 0x092f, IllegalArgumentException -> 0x0923, FileNotFoundException -> 0x0917, IOException -> 0x0909, Throwable -> 0x08fe, all -> 0x08f6 }
        if (r5 != 0) goto L_0x08c8;
    L_0x077e:
        if (r12 == 0) goto L_0x08c8;
    L_0x0780:
        r3 = r12.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x078e;
    L_0x078a:
        r3 = 0;
        r12.setViaInfo(r3);
    L_0x078e:
        r3 = r12.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x079d;
    L_0x0798:
        r3 = "";
        r12.setStatusCode(r3);
    L_0x079d:
        r3 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r3);
        r3 = r12.getDownloadResult();
        if (r3 == 0) goto L_0x07b6;
    L_0x07aa:
        r3 = r12.getDownloadResult();
        r4 = "success";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x07bb;
    L_0x07b6:
        r3 = "failed";
        r12.setDownloadResult(r3);
    L_0x07bb:
        if (r13 != 0) goto L_0x08c8;
    L_0x07bd:
        r3 = r2.getNetType();
        r4 = -1;
        if (r3 != r4) goto L_0x07c6;
    L_0x07c4:
        goto L_0x08c8;
    L_0x07c6:
        if (r3 != 0) goto L_0x0846;
    L_0x07c8:
        r3 = r2.getCdnNotWifiConnectTimeout();
        r3 = (long) r3;
        r1.mLimitConnectTime = r3;
        r2 = r2.getCdnNotWifiAlertRate();
        r2 = (long) r2;
        r1.mLimitDownloadSpeed = r2;
        r2 = r1.mLimitConnectTime;
        r2 = r2 * r22;
        r4 = (r36 > r2 ? 1 : (r36 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x0810;
    L_0x07de:
        r2 = "cdn_connected_too_slow";
        r12.setErrorType(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "connected_time=";
        r2.append(r3);
        r14 = r36;
        r3 = (float) r14;
        r4 = 0;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r3, r4);
        r2.append(r3);
        r3 = "s, connected_time_threshold=";
        r2.append(r3);
        r3 = r1.mLimitConnectTime;
        r2.append(r3);
        r3 = "s";
        r2.append(r3);
        r2 = r2.toString();
        r12.setExceptionReason(r2);
        goto L_0x08c8;
    L_0x0810:
        r2 = r1.mLimitDownloadSpeed;
        r2 = (float) r2;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x08c8;
    L_0x0817:
        r2 = "cdn_download_too_slow";
        r12.setErrorType(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "download_speed=";
        r2.append(r3);
        r3 = 1;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r3);
        r2.append(r3);
        r3 = "KB/s, download_speed_threshold=";
        r2.append(r3);
        r3 = r1.mLimitDownloadSpeed;
        r2.append(r3);
        r3 = "KB/s";
        r2.append(r3);
        r2 = r2.toString();
        r12.setExceptionReason(r2);
        goto L_0x08c8;
    L_0x0846:
        r14 = r36;
        r4 = 1;
        if (r3 != r4) goto L_0x08c8;
    L_0x084b:
        r3 = r2.getCdnWifiConnectTimeout();
        r3 = (long) r3;
        r1.mLimitConnectTime = r3;
        r2 = r2.getCdnWifiAlertRate();
        r2 = (long) r2;
        r1.mLimitDownloadSpeed = r2;
        r2 = 0;
        r1.mLimitConnectTime = r2;
        r2 = r1.mLimitConnectTime;
        r2 = r2 * r22;
        r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x0894;
    L_0x0865:
        r2 = "cdn_connected_too_slow";
        r12.setErrorType(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "connected_time=";
        r2.append(r3);
        r3 = (float) r14;
        r4 = 0;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r3, r4);
        r2.append(r3);
        r3 = "s, connected_time_threshold=";
        r2.append(r3);
        r3 = r1.mLimitConnectTime;
        r2.append(r3);
        r3 = "s";
        r2.append(r3);
        r2 = r2.toString();
        r12.setExceptionReason(r2);
        goto L_0x08c8;
    L_0x0894:
        r2 = r1.mLimitDownloadSpeed;
        r2 = (float) r2;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x08c8;
    L_0x089b:
        r2 = "cdn_download_too_slow";
        r12.setErrorType(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "download_speed=";
        r2.append(r3);
        r3 = 1;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r3);
        r2.append(r3);
        r3 = "KB/s, download_speed_threshold=";
        r2.append(r3);
        r3 = r1.mLimitDownloadSpeed;
        r2.append(r3);
        r3 = "KB/s";
        r2.append(r3);
        r2 = r2.toString();
        r12.setExceptionReason(r2);
    L_0x08c8:
        if (r11 == 0) goto L_0x08cd;
    L_0x08ca:
        r11.disconnect();
    L_0x08cd:
        if (r35 == 0) goto L_0x08d4;
    L_0x08cf:
        r9 = r35;
        r9.close();	 Catch:{ IOException -> 0x08d4 }
    L_0x08d4:
        if (r7 == 0) goto L_0x08d9;
    L_0x08d6:
        r7.close();	 Catch:{ IOException -> 0x08d9 }
    L_0x08d9:
        r2 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "DownloadThread hls readData end:";
        r3.append(r4);
        r4 = java.lang.System.currentTimeMillis();
        r7 = r4 - r33;
        r3.append(r7);
        r3 = r3.toString();
        com.ximalaya.ting.android.player.Logger.log(r2, r3);
        return r6;
    L_0x08f6:
        r0 = move-exception;
        r9 = r35;
        r14 = r36;
        r1 = r2;
        goto L_0x0f34;
    L_0x08fe:
        r0 = move-exception;
        r9 = r35;
        r14 = r36;
        r17 = r3;
        r8 = r16;
        goto L_0x038c;
    L_0x0909:
        r0 = move-exception;
        r9 = r35;
        r14 = r36;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r8 = r16;
        goto L_0x1077;
    L_0x0917:
        r0 = move-exception;
        r9 = r35;
        r14 = r36;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x11ce;
    L_0x0923:
        r0 = move-exception;
        r9 = r35;
        r14 = r36;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x128e;
    L_0x092f:
        r0 = move-exception;
        r9 = r35;
        r14 = r36;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x132e;
    L_0x093b:
        r0 = move-exception;
        r9 = r35;
        r14 = r36;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x13ce;
    L_0x0947:
        r0 = move-exception;
        r9 = r35;
        r14 = r36;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x14b2;
    L_0x0953:
        r9 = r35;
        r14 = r36;
        if (r5 != 0) goto L_0x0a9f;
    L_0x0959:
        if (r12 == 0) goto L_0x0a9f;
    L_0x095b:
        r3 = r12.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0969;
    L_0x0965:
        r3 = 0;
        r12.setViaInfo(r3);
    L_0x0969:
        r3 = r12.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0978;
    L_0x0973:
        r3 = "";
        r12.setStatusCode(r3);
    L_0x0978:
        r3 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r3);
        r3 = r12.getDownloadResult();
        if (r3 == 0) goto L_0x0991;
    L_0x0985:
        r3 = r12.getDownloadResult();
        r4 = "success";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x0996;
    L_0x0991:
        r3 = "failed";
        r12.setDownloadResult(r3);
    L_0x0996:
        if (r13 != 0) goto L_0x0a9f;
    L_0x0998:
        r3 = r2.getNetType();
        r4 = -1;
        if (r3 != r4) goto L_0x09a1;
    L_0x099f:
        goto L_0x0a9f;
    L_0x09a1:
        if (r3 != 0) goto L_0x0a1f;
    L_0x09a3:
        r3 = r2.getCdnNotWifiConnectTimeout();
        r3 = (long) r3;
        r1.mLimitConnectTime = r3;
        r2 = r2.getCdnNotWifiAlertRate();
        r2 = (long) r2;
        r1.mLimitDownloadSpeed = r2;
        r2 = r1.mLimitConnectTime;
        r2 = r2 * r22;
        r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x09e9;
    L_0x09b9:
        r2 = "cdn_connected_too_slow";
        r12.setErrorType(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "connected_time=";
        r2.append(r3);
        r3 = (float) r14;
        r4 = 0;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r3, r4);
        r2.append(r3);
        r3 = "s, connected_time_threshold=";
        r2.append(r3);
        r3 = r1.mLimitConnectTime;
        r2.append(r3);
        r3 = "s";
        r2.append(r3);
        r2 = r2.toString();
        r12.setExceptionReason(r2);
        goto L_0x0a9f;
    L_0x09e9:
        r2 = r1.mLimitDownloadSpeed;
        r2 = (float) r2;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x0a9f;
    L_0x09f0:
        r2 = "cdn_download_too_slow";
        r12.setErrorType(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "download_speed=";
        r2.append(r3);
        r3 = 1;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r3);
        r2.append(r3);
        r3 = "KB/s, download_speed_threshold=";
        r2.append(r3);
        r3 = r1.mLimitDownloadSpeed;
        r2.append(r3);
        r3 = "KB/s";
        r2.append(r3);
        r2 = r2.toString();
        r12.setExceptionReason(r2);
        goto L_0x0a9f;
    L_0x0a1f:
        r4 = 1;
        if (r3 != r4) goto L_0x0a9f;
    L_0x0a22:
        r3 = r2.getCdnWifiConnectTimeout();
        r3 = (long) r3;
        r1.mLimitConnectTime = r3;
        r2 = r2.getCdnWifiAlertRate();
        r2 = (long) r2;
        r1.mLimitDownloadSpeed = r2;
        r2 = 0;
        r1.mLimitConnectTime = r2;
        r2 = r1.mLimitConnectTime;
        r2 = r2 * r22;
        r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x0a6b;
    L_0x0a3c:
        r2 = "cdn_connected_too_slow";
        r12.setErrorType(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "connected_time=";
        r2.append(r3);
        r3 = (float) r14;
        r4 = 0;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r3, r4);
        r2.append(r3);
        r3 = "s, connected_time_threshold=";
        r2.append(r3);
        r3 = r1.mLimitConnectTime;
        r2.append(r3);
        r3 = "s";
        r2.append(r3);
        r2 = r2.toString();
        r12.setExceptionReason(r2);
        goto L_0x0a9f;
    L_0x0a6b:
        r2 = r1.mLimitDownloadSpeed;
        r2 = (float) r2;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x0a9f;
    L_0x0a72:
        r2 = "cdn_download_too_slow";
        r12.setErrorType(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "download_speed=";
        r2.append(r3);
        r3 = 1;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r3);
        r2.append(r3);
        r3 = "KB/s, download_speed_threshold=";
        r2.append(r3);
        r3 = r1.mLimitDownloadSpeed;
        r2.append(r3);
        r3 = "KB/s";
        r2.append(r3);
        r2 = r2.toString();
        r12.setExceptionReason(r2);
    L_0x0a9f:
        if (r11 == 0) goto L_0x0aa4;
    L_0x0aa1:
        r11.disconnect();
    L_0x0aa4:
        if (r9 == 0) goto L_0x0aa9;
    L_0x0aa6:
        r9.close();	 Catch:{ IOException -> 0x0aa9 }
    L_0x0aa9:
        if (r7 == 0) goto L_0x0aae;
    L_0x0aab:
        r7.close();	 Catch:{ IOException -> 0x0aae }
    L_0x0aae:
        r2 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "DownloadThread hls readData end:";
        r3.append(r4);
        r4 = java.lang.System.currentTimeMillis();
        r6 = r4 - r33;
        r3.append(r6);
        r3 = r3.toString();
        com.ximalaya.ting.android.player.Logger.log(r2, r3);
        return r8;
    L_0x0acb:
        r0 = move-exception;
        goto L_0x0ae0;
    L_0x0acd:
        r0 = move-exception;
        goto L_0x0ae9;
    L_0x0acf:
        r0 = move-exception;
        goto L_0x0af5;
    L_0x0ad1:
        r0 = move-exception;
        goto L_0x0b04;
    L_0x0ad3:
        r0 = move-exception;
        goto L_0x0b11;
    L_0x0ad5:
        r0 = move-exception;
        goto L_0x0b1e;
    L_0x0ad7:
        r0 = move-exception;
        goto L_0x0b2b;
    L_0x0ada:
        r0 = move-exception;
        goto L_0x0b38;
    L_0x0add:
        r0 = move-exception;
        r33 = r8;
    L_0x0ae0:
        r9 = r6;
        r1 = r2;
        r10 = r32;
        goto L_0x0f34;
    L_0x0ae6:
        r0 = move-exception;
        r33 = r8;
    L_0x0ae9:
        r9 = r6;
        r17 = r3;
        r8 = r16;
        r10 = r32;
        goto L_0x038c;
    L_0x0af2:
        r0 = move-exception;
        r33 = r8;
    L_0x0af5:
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r8 = r16;
        r10 = r32;
        goto L_0x1077;
    L_0x0b01:
        r0 = move-exception;
        r33 = r8;
    L_0x0b04:
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r10 = r32;
        goto L_0x11ce;
    L_0x0b0e:
        r0 = move-exception;
        r33 = r8;
    L_0x0b11:
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r10 = r32;
        goto L_0x128e;
    L_0x0b1b:
        r0 = move-exception;
        r33 = r8;
    L_0x0b1e:
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r10 = r32;
        goto L_0x132e;
    L_0x0b28:
        r0 = move-exception;
        r33 = r8;
    L_0x0b2b:
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r10 = r32;
        goto L_0x13ce;
    L_0x0b35:
        r0 = move-exception;
        r33 = r8;
    L_0x0b38:
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r10 = r32;
        goto L_0x14b2;
    L_0x0b42:
        r0 = move-exception;
        r33 = r8;
        r9 = r6;
        r1 = r2;
        r10 = r32;
        r7 = 0;
        goto L_0x0f34;
    L_0x0b4c:
        r0 = move-exception;
        r33 = r8;
        r9 = r6;
        r17 = r3;
        r8 = r16;
        r10 = r32;
        r7 = 0;
        goto L_0x038c;
    L_0x0b59:
        r0 = move-exception;
        r33 = r8;
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r8 = r16;
        r10 = r32;
        r7 = 0;
        goto L_0x1077;
    L_0x0b69:
        r0 = move-exception;
        r33 = r8;
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r10 = r32;
        r7 = 0;
        goto L_0x11ce;
    L_0x0b77:
        r0 = move-exception;
        r33 = r8;
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r10 = r32;
        r7 = 0;
        goto L_0x128e;
    L_0x0b85:
        r0 = move-exception;
        r33 = r8;
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r10 = r32;
        r7 = 0;
        goto L_0x132e;
    L_0x0b93:
        r0 = move-exception;
        r33 = r8;
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r10 = r32;
        r7 = 0;
        goto L_0x13ce;
    L_0x0ba1:
        r0 = move-exception;
        r33 = r8;
        r9 = r6;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        r10 = r32;
        r7 = 0;
        goto L_0x14b2;
    L_0x0baf:
        r0 = move-exception;
        r33 = r8;
        r17 = r3;
        r8 = r16;
        r10 = r32;
        goto L_0x038a;
    L_0x0bba:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x04d3;
    L_0x0bc4:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x04df;
    L_0x0bce:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x04e9;
    L_0x0bd8:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x04f3;
    L_0x0be2:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x04fd;
    L_0x0bec:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        r17 = r3;
        goto L_0x0507;
    L_0x0bf6:
        r0 = move-exception;
        r33 = r8;
        r1 = r2;
        goto L_0x04bf;
    L_0x0bfc:
        r0 = move-exception;
        r33 = r8;
        r3 = r0;
        goto L_0x04c7;
    L_0x0c02:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        goto L_0x04d3;
    L_0x0c0a:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        goto L_0x04df;
    L_0x0c12:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        goto L_0x04e9;
    L_0x0c1a:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        goto L_0x04f3;
    L_0x0c22:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        goto L_0x04fd;
    L_0x0c2a:
        r0 = move-exception;
        r33 = r8;
        r1 = r0;
        r40 = r2;
        goto L_0x0507;
    L_0x0c32:
        r33 = r8;
        r4 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ MalformedURLException -> 0x0dd1, SocketTimeoutException -> 0x0dcf, UnknownHostException -> 0x0dcd, IllegalArgumentException -> 0x0dcb, FileNotFoundException -> 0x0dc9, IOException -> 0x0dc7, Throwable -> 0x0dc5, all -> 0x0dc3 }
        r6 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0dd1, SocketTimeoutException -> 0x0dcf, UnknownHostException -> 0x0dcd, IllegalArgumentException -> 0x0dcb, FileNotFoundException -> 0x0dc9, IOException -> 0x0dc7, Throwable -> 0x0dc5, all -> 0x0dc3 }
        r6.<init>();	 Catch:{ MalformedURLException -> 0x0dd1, SocketTimeoutException -> 0x0dcf, UnknownHostException -> 0x0dcd, IllegalArgumentException -> 0x0dcb, FileNotFoundException -> 0x0dc9, IOException -> 0x0dc7, Throwable -> 0x0dc5, all -> 0x0dc3 }
        r7 = "HlsDownloadThread fail contentLength:";
        r6.append(r7);	 Catch:{ MalformedURLException -> 0x0dd1, SocketTimeoutException -> 0x0dcf, UnknownHostException -> 0x0dcd, IllegalArgumentException -> 0x0dcb, FileNotFoundException -> 0x0dc9, IOException -> 0x0dc7, Throwable -> 0x0dc5, all -> 0x0dc3 }
        r6.append(r3);	 Catch:{ MalformedURLException -> 0x0dd1, SocketTimeoutException -> 0x0dcf, UnknownHostException -> 0x0dcd, IllegalArgumentException -> 0x0dcb, FileNotFoundException -> 0x0dc9, IOException -> 0x0dc7, Throwable -> 0x0dc5, all -> 0x0dc3 }
        r3 = r6.toString();	 Catch:{ MalformedURLException -> 0x0dd1, SocketTimeoutException -> 0x0dcf, UnknownHostException -> 0x0dcd, IllegalArgumentException -> 0x0dcb, FileNotFoundException -> 0x0dc9, IOException -> 0x0dc7, Throwable -> 0x0dc5, all -> 0x0dc3 }
        com.ximalaya.ting.android.player.Logger.log(r4, r3);	 Catch:{ MalformedURLException -> 0x0dd1, SocketTimeoutException -> 0x0dcf, UnknownHostException -> 0x0dcd, IllegalArgumentException -> 0x0dcb, FileNotFoundException -> 0x0dc9, IOException -> 0x0dc7, Throwable -> 0x0dc5, all -> 0x0dc3 }
        if (r5 != 0) goto L_0x0d9a;
    L_0x0c4c:
        if (r12 == 0) goto L_0x0d9a;
    L_0x0c4e:
        r3 = r12.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0c5c;
    L_0x0c58:
        r3 = 0;
        r12.setViaInfo(r3);
    L_0x0c5c:
        r3 = r12.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0c6b;
    L_0x0c66:
        r3 = "";
        r12.setStatusCode(r3);
    L_0x0c6b:
        r3 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r3);
        r3 = r12.getDownloadResult();
        if (r3 == 0) goto L_0x0c84;
    L_0x0c78:
        r3 = r12.getDownloadResult();
        r4 = "success";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x0c89;
    L_0x0c84:
        r3 = "failed";
        r12.setDownloadResult(r3);
    L_0x0c89:
        if (r13 != 0) goto L_0x0d9a;
    L_0x0c8b:
        r3 = r2.getNetType();
        r4 = -1;
        if (r3 != r4) goto L_0x0c97;
    L_0x0c92:
        r10 = r32;
        r5 = 1;
        goto L_0x0d9c;
    L_0x0c97:
        if (r3 != 0) goto L_0x0d17;
    L_0x0c99:
        r3 = r2.getCdnNotWifiConnectTimeout();
        r3 = (long) r3;
        r1.mLimitConnectTime = r3;
        r3 = r2.getCdnNotWifiAlertRate();
        r3 = (long) r3;
        r1.mLimitDownloadSpeed = r3;
        r3 = r1.mLimitConnectTime;
        r3 = r3 * r22;
        r6 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1));
        if (r6 <= 0) goto L_0x0cdf;
    L_0x0caf:
        r3 = "cdn_connected_too_slow";
        r12.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "connected_time=";
        r3.append(r4);
        r4 = (float) r14;
        r6 = 0;
        r4 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r4, r6);
        r3.append(r4);
        r4 = "s, connected_time_threshold=";
        r3.append(r4);
        r6 = r1.mLimitConnectTime;
        r3.append(r6);
        r4 = "s";
        r3.append(r4);
        r3 = r3.toString();
        r12.setExceptionReason(r3);
        goto L_0x0d9a;
    L_0x0cdf:
        r3 = r1.mLimitDownloadSpeed;
        r3 = (float) r3;
        r3 = (r3 > r32 ? 1 : (r3 == r32 ? 0 : -1));
        if (r3 <= 0) goto L_0x0d9a;
    L_0x0ce6:
        r3 = "cdn_download_too_slow";
        r12.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "download_speed=";
        r3.append(r4);
        r10 = r32;
        r4 = 1;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r4);
        r3.append(r6);
        r4 = "KB/s, download_speed_threshold=";
        r3.append(r4);
        r6 = r1.mLimitDownloadSpeed;
        r3.append(r6);
        r4 = "KB/s";
        r3.append(r4);
        r3 = r3.toString();
        r12.setExceptionReason(r3);
        goto L_0x0d9c;
    L_0x0d17:
        r10 = r32;
        r4 = 1;
        if (r3 != r4) goto L_0x0d9c;
    L_0x0d1c:
        r3 = r2.getCdnWifiConnectTimeout();
        r3 = (long) r3;
        r1.mLimitConnectTime = r3;
        r3 = r2.getCdnWifiAlertRate();
        r3 = (long) r3;
        r1.mLimitDownloadSpeed = r3;
        r3 = 0;
        r1.mLimitConnectTime = r3;
        r3 = r1.mLimitConnectTime;
        r3 = r3 * r22;
        r6 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1));
        if (r6 <= 0) goto L_0x0d65;
    L_0x0d36:
        r3 = "cdn_connected_too_slow";
        r12.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "connected_time=";
        r3.append(r4);
        r4 = (float) r14;
        r6 = 0;
        r4 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r4, r6);
        r3.append(r4);
        r4 = "s, connected_time_threshold=";
        r3.append(r4);
        r6 = r1.mLimitConnectTime;
        r3.append(r6);
        r4 = "s";
        r3.append(r4);
        r3 = r3.toString();
        r12.setExceptionReason(r3);
        goto L_0x0d9c;
    L_0x0d65:
        r3 = r1.mLimitDownloadSpeed;
        r3 = (float) r3;
        r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x0d9c;
    L_0x0d6c:
        r3 = "cdn_download_too_slow";
        r12.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "download_speed=";
        r3.append(r4);
        r4 = 1;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r4);
        r3.append(r6);
        r4 = "KB/s, download_speed_threshold=";
        r3.append(r4);
        r6 = r1.mLimitDownloadSpeed;
        r3.append(r6);
        r4 = "KB/s";
        r3.append(r4);
        r3 = r3.toString();
        r12.setExceptionReason(r3);
        goto L_0x0d9c;
    L_0x0d9a:
        r10 = r32;
    L_0x0d9c:
        if (r11 == 0) goto L_0x0da1;
    L_0x0d9e:
        r11.disconnect();
    L_0x0da1:
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "DownloadThread hls readData end:";
        r4.append(r6);
        r6 = java.lang.System.currentTimeMillis();
        r8 = r6 - r33;
        r4.append(r8);
        r4 = r4.toString();
        com.ximalaya.ting.android.player.Logger.log(r3, r4);
        r6 = r19;
        r7 = r30;
        goto L_0x0262;
    L_0x0dc3:
        r0 = move-exception;
        goto L_0x0dd6;
    L_0x0dc5:
        r0 = move-exception;
        goto L_0x0ddd;
    L_0x0dc7:
        r0 = move-exception;
        goto L_0x0de4;
    L_0x0dc9:
        r0 = move-exception;
        goto L_0x0deb;
    L_0x0dcb:
        r0 = move-exception;
        goto L_0x0df2;
    L_0x0dcd:
        r0 = move-exception;
        goto L_0x0df9;
    L_0x0dcf:
        r0 = move-exception;
        goto L_0x0e00;
    L_0x0dd1:
        r0 = move-exception;
        goto L_0x0e07;
    L_0x0dd3:
        r0 = move-exception;
        r33 = r8;
    L_0x0dd6:
        r10 = r32;
        goto L_0x0e41;
    L_0x0dda:
        r0 = move-exception;
        r33 = r8;
    L_0x0ddd:
        r10 = r32;
        goto L_0x0e4d;
    L_0x0de1:
        r0 = move-exception;
        r33 = r8;
    L_0x0de4:
        r10 = r32;
        goto L_0x0e5b;
    L_0x0de8:
        r0 = move-exception;
        r33 = r8;
    L_0x0deb:
        r10 = r32;
        goto L_0x0e6b;
    L_0x0def:
        r0 = move-exception;
        r33 = r8;
    L_0x0df2:
        r10 = r32;
        goto L_0x0e79;
    L_0x0df6:
        r0 = move-exception;
        r33 = r8;
    L_0x0df9:
        r10 = r32;
        goto L_0x0e87;
    L_0x0dfd:
        r0 = move-exception;
        r33 = r8;
    L_0x0e00:
        r10 = r32;
        goto L_0x0e95;
    L_0x0e04:
        r0 = move-exception;
        r33 = r8;
    L_0x0e07:
        r10 = r32;
        goto L_0x0ea3;
    L_0x0e0b:
        r0 = move-exception;
        r33 = r8;
        goto L_0x0e41;
    L_0x0e0f:
        r0 = move-exception;
        r30 = r3;
        r33 = r8;
        goto L_0x0e4d;
    L_0x0e15:
        r0 = move-exception;
        r30 = r3;
        r33 = r8;
        goto L_0x0e5b;
    L_0x0e1b:
        r0 = move-exception;
        r30 = r3;
        r33 = r8;
        goto L_0x0e6b;
    L_0x0e21:
        r0 = move-exception;
        r30 = r3;
        r33 = r8;
        goto L_0x0e79;
    L_0x0e27:
        r0 = move-exception;
        r30 = r3;
        r33 = r8;
        goto L_0x0e87;
    L_0x0e2e:
        r0 = move-exception;
        r30 = r3;
        r33 = r8;
        goto L_0x0e95;
    L_0x0e35:
        r0 = move-exception;
        r30 = r3;
        r33 = r8;
        goto L_0x0ea3;
    L_0x0e3c:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
    L_0x0e41:
        r1 = r2;
    L_0x0e42:
        r7 = 0;
        r9 = 0;
        goto L_0x0f34;
    L_0x0e46:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
    L_0x0e4d:
        r3 = r0;
    L_0x0e4e:
        r8 = r16;
    L_0x0e50:
        r7 = 0;
        r9 = 0;
        goto L_0x0f44;
    L_0x0e54:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
    L_0x0e5b:
        r1 = r0;
        r40 = r2;
    L_0x0e5e:
        r8 = r16;
    L_0x0e60:
        r7 = 0;
        r9 = 0;
        goto L_0x1077;
    L_0x0e64:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
    L_0x0e6b:
        r1 = r0;
        r40 = r2;
    L_0x0e6e:
        r7 = 0;
        r9 = 0;
        goto L_0x11ce;
    L_0x0e72:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
    L_0x0e79:
        r1 = r0;
        r40 = r2;
    L_0x0e7c:
        r7 = 0;
        r9 = 0;
        goto L_0x128e;
    L_0x0e80:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
    L_0x0e87:
        r1 = r0;
        r40 = r2;
    L_0x0e8a:
        r7 = 0;
        r9 = 0;
        goto L_0x132e;
    L_0x0e8e:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
    L_0x0e95:
        r1 = r0;
        r40 = r2;
    L_0x0e98:
        r7 = 0;
        r9 = 0;
        goto L_0x13ce;
    L_0x0e9c:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
    L_0x0ea3:
        r1 = r0;
        r40 = r2;
    L_0x0ea6:
        r7 = 0;
        r9 = 0;
        goto L_0x14b2;
    L_0x0eaa:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
        goto L_0x0f3e;
    L_0x0eb3:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
        goto L_0x0eea;
    L_0x0ebb:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
        goto L_0x0ef6;
    L_0x0ec3:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
        goto L_0x0f02;
    L_0x0ecb:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
        goto L_0x0f0e;
    L_0x0ed3:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
        goto L_0x0f1a;
    L_0x0edb:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r30 = r26;
        goto L_0x0f26;
    L_0x0ee3:
        r0 = move-exception;
        r30 = r7;
        r33 = r8;
        r28 = r14;
    L_0x0eea:
        r1 = r0;
        r40 = r2;
        goto L_0x1072;
    L_0x0eef:
        r0 = move-exception;
        r30 = r7;
        r33 = r8;
        r28 = r14;
    L_0x0ef6:
        r1 = r0;
        r40 = r2;
        goto L_0x11cb;
    L_0x0efb:
        r0 = move-exception;
        r30 = r7;
        r33 = r8;
        r28 = r14;
    L_0x0f02:
        r1 = r0;
        r40 = r2;
        goto L_0x128b;
    L_0x0f07:
        r0 = move-exception;
        r30 = r7;
        r33 = r8;
        r28 = r14;
    L_0x0f0e:
        r1 = r0;
        r40 = r2;
        goto L_0x132b;
    L_0x0f13:
        r0 = move-exception;
        r30 = r7;
        r33 = r8;
        r28 = r14;
    L_0x0f1a:
        r1 = r0;
        r40 = r2;
        goto L_0x13cb;
    L_0x0f1f:
        r0 = move-exception;
        r30 = r7;
        r33 = r8;
        r28 = r14;
    L_0x0f26:
        r1 = r0;
        r40 = r2;
        goto L_0x14af;
    L_0x0f2b:
        r0 = move-exception;
        r33 = r8;
        r28 = r14;
        r1 = r2;
    L_0x0f31:
        r7 = 0;
        r9 = 0;
        r11 = 0;
    L_0x0f34:
        r2 = r0;
        goto L_0x15a4;
    L_0x0f37:
        r0 = move-exception;
        r30 = r7;
        r33 = r8;
        r28 = r14;
    L_0x0f3e:
        r3 = r0;
    L_0x0f3f:
        r8 = r16;
        r7 = 0;
        r9 = 0;
        r11 = 0;
    L_0x0f44:
        if (r5 != 0) goto L_0x0ff4;
    L_0x0f46:
        if (r12 == 0) goto L_0x0ff4;
    L_0x0f48:
        r4 = r12.getDownloadSpeed();	 Catch:{ all -> 0x0fed }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0fed }
        if (r4 == 0) goto L_0x0faf;
    L_0x0f52:
        r26 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0fed }
        r38 = r14;
        r13 = r26 - r17;
        r20 = 0;
        r4 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1));
        if (r4 == 0) goto L_0x0f6d;
    L_0x0f60:
        r4 = (float) r8;
        r6 = 0;
        r4 = r4 + r6;
        r10 = 1149239296; // 0x44800000 float:1024.0 double:5.67799655E-315;
        r4 = r4 / r10;
        r10 = (float) r13;
        r10 = r10 + r6;
        r6 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r10 = r10 / r6;
        r4 = r4 / r10;
        r10 = r4;
    L_0x0f6d:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fe8 }
        r4.<init>();	 Catch:{ all -> 0x0fe8 }
        r6 = 1;
        r15 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r6);	 Catch:{ all -> 0x0fe8 }
        r4.append(r15);	 Catch:{ all -> 0x0fe8 }
        r6 = "";
        r4.append(r6);	 Catch:{ all -> 0x0fe8 }
        r4 = r4.toString();	 Catch:{ all -> 0x0fe8 }
        r12.setDownloadSpeed(r4);	 Catch:{ all -> 0x0fe8 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fe8 }
        r4.<init>();	 Catch:{ all -> 0x0fe8 }
        r4.append(r8);	 Catch:{ all -> 0x0fe8 }
        r6 = "";
        r4.append(r6);	 Catch:{ all -> 0x0fe8 }
        r4 = r4.toString();	 Catch:{ all -> 0x0fe8 }
        r12.setDownloaded(r4);	 Catch:{ all -> 0x0fe8 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fe8 }
        r4.<init>();	 Catch:{ all -> 0x0fe8 }
        r4.append(r13);	 Catch:{ all -> 0x0fe8 }
        r6 = "";
        r4.append(r6);	 Catch:{ all -> 0x0fe8 }
        r4 = r4.toString();	 Catch:{ all -> 0x0fe8 }
        r12.setDownloadTime(r4);	 Catch:{ all -> 0x0fe8 }
        goto L_0x0fb1;
    L_0x0faf:
        r38 = r14;
    L_0x0fb1:
        r4 = r12.getConnectedTime();	 Catch:{ all -> 0x0fe8 }
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 > 0) goto L_0x0fd2;
    L_0x0fba:
        r13 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0fe8 }
        r40 = r2;
        r1 = r13 - r33;
        r4 = (float) r1;
        r6 = 0;
        r4 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r4, r6);	 Catch:{ all -> 0x0fcd }
        r12.setConnectedTime(r4);	 Catch:{ all -> 0x0fcd }
        r14 = r1;
        goto L_0x0fd6;
    L_0x0fcd:
        r0 = move-exception;
        r14 = r1;
        r1 = r40;
        goto L_0x0ff1;
    L_0x0fd2:
        r40 = r2;
        r14 = r38;
    L_0x0fd6:
        r1 = "failed";
        r12.setDownloaded(r1);	 Catch:{ all -> 0x127b }
        r1 = "cdn_unknown_exception";
        r12.setErrorType(r1);	 Catch:{ all -> 0x127b }
        r1 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3);	 Catch:{ all -> 0x127b }
        r12.setExceptionReason(r1);	 Catch:{ all -> 0x127b }
        goto L_0x0ffa;
    L_0x0fe8:
        r0 = move-exception;
        r1 = r2;
        r14 = r38;
        goto L_0x0ff1;
    L_0x0fed:
        r0 = move-exception;
        r38 = r14;
        r1 = r2;
    L_0x0ff1:
        r13 = 1;
        goto L_0x0f34;
    L_0x0ff4:
        r40 = r2;
        r38 = r14;
        r14 = r38;
    L_0x0ffa:
        if (r5 != 0) goto L_0x1039;
    L_0x0ffc:
        if (r12 == 0) goto L_0x1039;
    L_0x0ffe:
        r1 = r12.getViaInfo();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x100c;
    L_0x1008:
        r1 = 0;
        r12.setViaInfo(r1);
    L_0x100c:
        r1 = r12.getStatusCode();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x101b;
    L_0x1016:
        r1 = "";
        r12.setStatusCode(r1);
    L_0x101b:
        r1 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r1);
        r1 = r12.getDownloadResult();
        if (r1 == 0) goto L_0x1034;
    L_0x1028:
        r1 = r12.getDownloadResult();
        r2 = "success";
        r1 = r1.contains(r2);
        if (r1 != 0) goto L_0x1039;
    L_0x1034:
        r1 = "failed";
        r12.setDownloadResult(r1);
    L_0x1039:
        if (r11 == 0) goto L_0x103e;
    L_0x103b:
        r11.disconnect();
    L_0x103e:
        if (r9 == 0) goto L_0x1043;
    L_0x1040:
        r9.close();	 Catch:{ IOException -> 0x1043 }
    L_0x1043:
        if (r7 == 0) goto L_0x1048;
    L_0x1045:
        r7.close();	 Catch:{ IOException -> 0x1048 }
    L_0x1048:
        r1 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
    L_0x104f:
        r3 = "DownloadThread hls readData end:";
        r2.append(r3);
        r3 = java.lang.System.currentTimeMillis();
        r6 = r3 - r33;
        r2.append(r6);
        r2 = r2.toString();
        com.ximalaya.ting.android.player.Logger.log(r1, r2);
        r16 = r8;
        goto L_0x14a2;
    L_0x1068:
        r0 = move-exception;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        r28 = r14;
        r1 = r0;
    L_0x1072:
        r8 = r16;
        r7 = 0;
        r9 = 0;
        r11 = 0;
    L_0x1077:
        if (r5 != 0) goto L_0x114c;
    L_0x1079:
        if (r12 == 0) goto L_0x114c;
    L_0x107b:
        r2 = r12.getDownloadSpeed();	 Catch:{ all -> 0x1147 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x1147 }
        if (r2 == 0) goto L_0x10e2;
    L_0x1085:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x1147 }
        r41 = r14;
        r13 = r2 - r17;
        r2 = 0;
        r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1));
        if (r4 == 0) goto L_0x10a0;
    L_0x1093:
        r2 = (float) r8;
        r3 = 0;
        r2 = r2 + r3;
        r4 = 1149239296; // 0x44800000 float:1024.0 double:5.67799655E-315;
        r2 = r2 / r4;
        r4 = (float) r13;
        r4 = r4 + r3;
        r3 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r4 = r4 / r3;
        r2 = r2 / r4;
        r10 = r2;
    L_0x10a0:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x113f }
        r2.<init>();	 Catch:{ all -> 0x113f }
        r3 = 1;
        r4 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r3);	 Catch:{ all -> 0x113f }
        r2.append(r4);	 Catch:{ all -> 0x113f }
        r3 = "";
        r2.append(r3);	 Catch:{ all -> 0x113f }
        r2 = r2.toString();	 Catch:{ all -> 0x113f }
        r12.setDownloadSpeed(r2);	 Catch:{ all -> 0x113f }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x113f }
        r2.<init>();	 Catch:{ all -> 0x113f }
        r2.append(r8);	 Catch:{ all -> 0x113f }
        r3 = "";
        r2.append(r3);	 Catch:{ all -> 0x113f }
        r2 = r2.toString();	 Catch:{ all -> 0x113f }
        r12.setDownloaded(r2);	 Catch:{ all -> 0x113f }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x113f }
        r2.<init>();	 Catch:{ all -> 0x113f }
        r2.append(r13);	 Catch:{ all -> 0x113f }
        r3 = "";
        r2.append(r3);	 Catch:{ all -> 0x113f }
        r2 = r2.toString();	 Catch:{ all -> 0x113f }
        r12.setDownloadTime(r2);	 Catch:{ all -> 0x113f }
        goto L_0x10e4;
    L_0x10e2:
        r41 = r14;
    L_0x10e4:
        r2 = r12.getConnectedTime();	 Catch:{ all -> 0x113f }
        r3 = 0;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 > 0) goto L_0x10fd;
    L_0x10ed:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x113f }
        r14 = r2 - r33;
        r2 = (float) r14;
        r3 = 0;
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r2, r3);	 Catch:{ all -> 0x127b }
        r12.setConnectedTime(r2);	 Catch:{ all -> 0x127b }
        goto L_0x10ff;
    L_0x10fd:
        r14 = r41;
    L_0x10ff:
        r2 = r1.getMessage();	 Catch:{ all -> 0x127b }
        if (r2 == 0) goto L_0x112d;
    L_0x1105:
        r2 = r1.getMessage();	 Catch:{ all -> 0x127b }
        r3 = "ENOSPC";
        r2 = r2.contains(r3);	 Catch:{ all -> 0x127b }
        if (r2 != 0) goto L_0x111d;
    L_0x1111:
        r2 = r1.getMessage();	 Catch:{ all -> 0x127b }
        r3 = "EACCES";
        r2 = r2.contains(r3);	 Catch:{ all -> 0x127b }
        if (r2 == 0) goto L_0x112d;
    L_0x111d:
        r2 = "0";
        r12.setDownloaded(r2);	 Catch:{ all -> 0x127b }
        r2 = "0";
        r12.setDownloadTime(r2);	 Catch:{ all -> 0x127b }
        r2 = "system_exception";
        r12.setErrorType(r2);	 Catch:{ all -> 0x127b }
        goto L_0x1132;
    L_0x112d:
        r2 = "cdn_io_exception";
        r12.setErrorType(r2);	 Catch:{ all -> 0x127b }
    L_0x1132:
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r1);	 Catch:{ all -> 0x127b }
        r12.setExceptionReason(r2);	 Catch:{ all -> 0x127b }
        r2 = "failed";
        r12.setDownloadResult(r2);	 Catch:{ all -> 0x127b }
        goto L_0x1150;
    L_0x113f:
        r0 = move-exception;
        r2 = r0;
        r1 = r40;
        r14 = r41;
        goto L_0x15a3;
    L_0x1147:
        r0 = move-exception;
        r41 = r14;
        goto L_0x127c;
    L_0x114c:
        r41 = r14;
        r14 = r41;
    L_0x1150:
        r2 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x127b }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x127b }
        r3.<init>();	 Catch:{ all -> 0x127b }
        r4 = "HlsDownloadThread IOException:";
        r3.append(r4);	 Catch:{ all -> 0x127b }
        r1 = r1.toString();	 Catch:{ all -> 0x127b }
        r3.append(r1);	 Catch:{ all -> 0x127b }
        r1 = r3.toString();	 Catch:{ all -> 0x127b }
        com.ximalaya.ting.android.player.Logger.log(r2, r1);	 Catch:{ all -> 0x127b }
        if (r5 != 0) goto L_0x11a9;
    L_0x116c:
        if (r12 == 0) goto L_0x11a9;
    L_0x116e:
        r1 = r12.getViaInfo();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x117c;
    L_0x1178:
        r1 = 0;
        r12.setViaInfo(r1);
    L_0x117c:
        r1 = r12.getStatusCode();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x118b;
    L_0x1186:
        r1 = "";
        r12.setStatusCode(r1);
    L_0x118b:
        r1 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r1);
        r1 = r12.getDownloadResult();
        if (r1 == 0) goto L_0x11a4;
    L_0x1198:
        r1 = r12.getDownloadResult();
        r2 = "success";
        r1 = r1.contains(r2);
        if (r1 != 0) goto L_0x11a9;
    L_0x11a4:
        r1 = "failed";
        r12.setDownloadResult(r1);
    L_0x11a9:
        if (r11 == 0) goto L_0x11ae;
    L_0x11ab:
        r11.disconnect();
    L_0x11ae:
        if (r9 == 0) goto L_0x11b3;
    L_0x11b0:
        r9.close();	 Catch:{ IOException -> 0x11b3 }
    L_0x11b3:
        if (r7 == 0) goto L_0x11b8;
    L_0x11b5:
        r7.close();	 Catch:{ IOException -> 0x11b8 }
    L_0x11b8:
        r1 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        goto L_0x104f;
    L_0x11c1:
        r0 = move-exception;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        r28 = r14;
        r1 = r0;
    L_0x11cb:
        r7 = 0;
        r9 = 0;
        r11 = 0;
    L_0x11ce:
        if (r5 != 0) goto L_0x120a;
    L_0x11d0:
        if (r12 == 0) goto L_0x120a;
    L_0x11d2:
        r2 = r12.getConnectedTime();	 Catch:{ all -> 0x127b }
        r3 = 0;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 > 0) goto L_0x11ea;
    L_0x11db:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x127b }
        r14 = r2 - r33;
        r2 = (float) r14;	 Catch:{ all -> 0x127b }
        r3 = 0;
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r2, r3);	 Catch:{ all -> 0x127b }
        r12.setConnectedTime(r2);	 Catch:{ all -> 0x127b }
    L_0x11ea:
        r2 = "system_exception";
        r12.setErrorType(r2);	 Catch:{ all -> 0x127b }
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r1);	 Catch:{ all -> 0x127b }
        r12.setExceptionReason(r2);	 Catch:{ all -> 0x127b }
        r2 = "0.0";
        r12.setDownloadSpeed(r2);	 Catch:{ all -> 0x127b }
        r2 = "0";
        r12.setDownloaded(r2);	 Catch:{ all -> 0x127b }
        r2 = "0";
        r12.setDownloadTime(r2);	 Catch:{ all -> 0x127b }
        r2 = "failed";
        r12.setDownloadResult(r2);	 Catch:{ all -> 0x127b }
    L_0x120a:
        r2 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x127b }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x127b }
        r3.<init>();	 Catch:{ all -> 0x127b }
        r4 = "DownloadThread IOException:";
        r3.append(r4);	 Catch:{ all -> 0x127b }
        r1 = r1.toString();	 Catch:{ all -> 0x127b }
        r3.append(r1);	 Catch:{ all -> 0x127b }
        r1 = r3.toString();	 Catch:{ all -> 0x127b }
        com.ximalaya.ting.android.player.Logger.log(r2, r1);	 Catch:{ all -> 0x127b }
        if (r5 != 0) goto L_0x1263;
    L_0x1226:
        if (r12 == 0) goto L_0x1263;
    L_0x1228:
        r1 = r12.getViaInfo();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x1236;
    L_0x1232:
        r1 = 0;
        r12.setViaInfo(r1);
    L_0x1236:
        r1 = r12.getStatusCode();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x1245;
    L_0x1240:
        r1 = "";
        r12.setStatusCode(r1);
    L_0x1245:
        r1 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r1);
        r1 = r12.getDownloadResult();
        if (r1 == 0) goto L_0x125e;
    L_0x1252:
        r1 = r12.getDownloadResult();
        r2 = "success";
        r1 = r1.contains(r2);
        if (r1 != 0) goto L_0x1263;
    L_0x125e:
        r1 = "failed";
        r12.setDownloadResult(r1);
    L_0x1263:
        if (r11 == 0) goto L_0x1268;
    L_0x1265:
        r11.disconnect();
    L_0x1268:
        if (r9 == 0) goto L_0x126d;
    L_0x126a:
        r9.close();	 Catch:{ IOException -> 0x126d }
    L_0x126d:
        if (r7 == 0) goto L_0x1272;
    L_0x126f:
        r7.close();	 Catch:{ IOException -> 0x1272 }
    L_0x1272:
        r1 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        goto L_0x148d;
    L_0x127b:
        r0 = move-exception;
    L_0x127c:
        r2 = r0;
        r1 = r40;
        goto L_0x15a3;
    L_0x1281:
        r0 = move-exception;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        r28 = r14;
        r1 = r0;
    L_0x128b:
        r7 = 0;
        r9 = 0;
        r11 = 0;
    L_0x128e:
        if (r5 != 0) goto L_0x12ca;
    L_0x1290:
        if (r12 == 0) goto L_0x12ca;
    L_0x1292:
        r2 = r12.getConnectedTime();	 Catch:{ all -> 0x127b }
        r3 = 0;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 > 0) goto L_0x12aa;
    L_0x129b:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x127b }
        r14 = r2 - r33;
        r2 = (float) r14;	 Catch:{ all -> 0x127b }
        r3 = 0;
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r2, r3);	 Catch:{ all -> 0x127b }
        r12.setConnectedTime(r2);	 Catch:{ all -> 0x127b }
    L_0x12aa:
        r2 = "dns_fail";
        r12.setErrorType(r2);	 Catch:{ all -> 0x127b }
        r1 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r1);	 Catch:{ all -> 0x127b }
        r12.setExceptionReason(r1);	 Catch:{ all -> 0x127b }
        r1 = "0.0";
        r12.setDownloadSpeed(r1);	 Catch:{ all -> 0x127b }
        r1 = "0";
        r12.setDownloaded(r1);	 Catch:{ all -> 0x127b }
        r1 = "0";
        r12.setDownloadTime(r1);	 Catch:{ all -> 0x127b }
        r1 = "failed";
        r12.setDownloadResult(r1);	 Catch:{ all -> 0x127b }
    L_0x12ca:
        if (r5 != 0) goto L_0x1309;
    L_0x12cc:
        if (r12 == 0) goto L_0x1309;
    L_0x12ce:
        r1 = r12.getViaInfo();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x12dc;
    L_0x12d8:
        r1 = 0;
        r12.setViaInfo(r1);
    L_0x12dc:
        r1 = r12.getStatusCode();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x12eb;
    L_0x12e6:
        r1 = "";
        r12.setStatusCode(r1);
    L_0x12eb:
        r1 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r1);
        r1 = r12.getDownloadResult();
        if (r1 == 0) goto L_0x1304;
    L_0x12f8:
        r1 = r12.getDownloadResult();
        r2 = "success";
        r1 = r1.contains(r2);
        if (r1 != 0) goto L_0x1309;
    L_0x1304:
        r1 = "failed";
        r12.setDownloadResult(r1);
    L_0x1309:
        if (r11 == 0) goto L_0x130e;
    L_0x130b:
        r11.disconnect();
    L_0x130e:
        if (r9 == 0) goto L_0x1313;
    L_0x1310:
        r9.close();	 Catch:{ IOException -> 0x1313 }
    L_0x1313:
        if (r7 == 0) goto L_0x1318;
    L_0x1315:
        r7.close();	 Catch:{ IOException -> 0x1318 }
    L_0x1318:
        r1 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        goto L_0x148d;
    L_0x1321:
        r0 = move-exception;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        r28 = r14;
        r1 = r0;
    L_0x132b:
        r7 = 0;
        r9 = 0;
        r11 = 0;
    L_0x132e:
        if (r5 != 0) goto L_0x136a;
    L_0x1330:
        if (r12 == 0) goto L_0x136a;
    L_0x1332:
        r2 = r12.getConnectedTime();	 Catch:{ all -> 0x127b }
        r3 = 0;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 > 0) goto L_0x134a;
    L_0x133b:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x127b }
        r14 = r2 - r33;
        r2 = (float) r14;	 Catch:{ all -> 0x127b }
        r3 = 0;
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r2, r3);	 Catch:{ all -> 0x127b }
        r12.setConnectedTime(r2);	 Catch:{ all -> 0x127b }
    L_0x134a:
        r2 = "dns_fail";
        r12.setErrorType(r2);	 Catch:{ all -> 0x127b }
        r1 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r1);	 Catch:{ all -> 0x127b }
        r12.setExceptionReason(r1);	 Catch:{ all -> 0x127b }
        r1 = "0.0";
        r12.setDownloadSpeed(r1);	 Catch:{ all -> 0x127b }
        r1 = "0";
        r12.setDownloaded(r1);	 Catch:{ all -> 0x127b }
        r1 = "0";
        r12.setDownloadTime(r1);	 Catch:{ all -> 0x127b }
        r1 = "failed";
        r12.setDownloadResult(r1);	 Catch:{ all -> 0x127b }
    L_0x136a:
        if (r5 != 0) goto L_0x13a9;
    L_0x136c:
        if (r12 == 0) goto L_0x13a9;
    L_0x136e:
        r1 = r12.getViaInfo();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x137c;
    L_0x1378:
        r1 = 0;
        r12.setViaInfo(r1);
    L_0x137c:
        r1 = r12.getStatusCode();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x138b;
    L_0x1386:
        r1 = "";
        r12.setStatusCode(r1);
    L_0x138b:
        r1 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r1);
        r1 = r12.getDownloadResult();
        if (r1 == 0) goto L_0x13a4;
    L_0x1398:
        r1 = r12.getDownloadResult();
        r2 = "success";
        r1 = r1.contains(r2);
        if (r1 != 0) goto L_0x13a9;
    L_0x13a4:
        r1 = "failed";
        r12.setDownloadResult(r1);
    L_0x13a9:
        if (r11 == 0) goto L_0x13ae;
    L_0x13ab:
        r11.disconnect();
    L_0x13ae:
        if (r9 == 0) goto L_0x13b3;
    L_0x13b0:
        r9.close();	 Catch:{ IOException -> 0x13b3 }
    L_0x13b3:
        if (r7 == 0) goto L_0x13b8;
    L_0x13b5:
        r7.close();	 Catch:{ IOException -> 0x13b8 }
    L_0x13b8:
        r1 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        goto L_0x148d;
    L_0x13c1:
        r0 = move-exception;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        r28 = r14;
        r1 = r0;
    L_0x13cb:
        r7 = 0;
        r9 = 0;
        r11 = 0;
    L_0x13ce:
        if (r5 != 0) goto L_0x1438;
    L_0x13d0:
        if (r12 == 0) goto L_0x1438;
    L_0x13d2:
        r2 = "0.0";
        r12.setDownloadSpeed(r2);	 Catch:{ all -> 0x127b }
        r2 = r12.getConnectedTime();	 Catch:{ all -> 0x127b }
        r3 = 0;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 > 0) goto L_0x13ef;
    L_0x13e0:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x127b }
        r14 = r2 - r33;
        r2 = (float) r14;	 Catch:{ all -> 0x127b }
        r3 = 0;
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r2, r3);	 Catch:{ all -> 0x127b }
        r12.setConnectedTime(r2);	 Catch:{ all -> 0x127b }
    L_0x13ef:
        r2 = r1.getMessage();	 Catch:{ all -> 0x127b }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x127b }
        if (r2 == 0) goto L_0x1419;
    L_0x13f9:
        r2 = "cdn_socket_timeout";
        r12.setErrorType(r2);	 Catch:{ all -> 0x127b }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x127b }
        r2.<init>();	 Catch:{ all -> 0x127b }
        r3 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x127b }
        r2.append(r3);	 Catch:{ all -> 0x127b }
        r1 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r1);	 Catch:{ all -> 0x127b }
        r2.append(r1);	 Catch:{ all -> 0x127b }
        r1 = r2.toString();	 Catch:{ all -> 0x127b }
        r12.setExceptionReason(r1);	 Catch:{ all -> 0x127b }
        goto L_0x1425;
    L_0x1419:
        r2 = "cdn_connect_timeout";
        r12.setErrorType(r2);	 Catch:{ all -> 0x127b }
        r1 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r1);	 Catch:{ all -> 0x127b }
        r12.setExceptionReason(r1);	 Catch:{ all -> 0x127b }
    L_0x1425:
        r1 = "0";
        r12.setDownloaded(r1);	 Catch:{ all -> 0x127b }
        r1 = "0";
        r12.setDownloadTime(r1);	 Catch:{ all -> 0x127b }
        r1 = "failed";
        r12.setDownloadResult(r1);	 Catch:{ all -> 0x127b }
        r1 = 1;
        r12.setTimeout(r1);	 Catch:{ all -> 0x127b }
    L_0x1438:
        if (r5 != 0) goto L_0x1477;
    L_0x143a:
        if (r12 == 0) goto L_0x1477;
    L_0x143c:
        r1 = r12.getViaInfo();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x144a;
    L_0x1446:
        r1 = 0;
        r12.setViaInfo(r1);
    L_0x144a:
        r1 = r12.getStatusCode();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x1459;
    L_0x1454:
        r1 = "";
        r12.setStatusCode(r1);
    L_0x1459:
        r1 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r1);
        r1 = r12.getDownloadResult();
        if (r1 == 0) goto L_0x1472;
    L_0x1466:
        r1 = r12.getDownloadResult();
        r2 = "success";
        r1 = r1.contains(r2);
        if (r1 != 0) goto L_0x1477;
    L_0x1472:
        r1 = "failed";
        r12.setDownloadResult(r1);
    L_0x1477:
        if (r11 == 0) goto L_0x147c;
    L_0x1479:
        r11.disconnect();
    L_0x147c:
        if (r9 == 0) goto L_0x1481;
    L_0x147e:
        r9.close();	 Catch:{ IOException -> 0x1481 }
    L_0x1481:
        if (r7 == 0) goto L_0x1486;
    L_0x1483:
        r7.close();	 Catch:{ IOException -> 0x1486 }
    L_0x1486:
        r1 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
    L_0x148d:
        r3 = "DownloadThread hls readData end:";
        r2.append(r3);
        r3 = java.lang.System.currentTimeMillis();
        r6 = r3 - r33;
        r2.append(r6);
        r2 = r2.toString();
        com.ximalaya.ting.android.player.Logger.log(r1, r2);
    L_0x14a2:
        r3 = 0;
        goto L_0x1574;
    L_0x14a5:
        r0 = move-exception;
        r40 = r2;
        r30 = r7;
        r33 = r8;
        r28 = r14;
        r1 = r0;
    L_0x14af:
        r7 = 0;
        r9 = 0;
        r11 = 0;
    L_0x14b2:
        if (r5 != 0) goto L_0x14ef;
    L_0x14b4:
        if (r12 == 0) goto L_0x14ef;
    L_0x14b6:
        r2 = r12.getConnectedTime();	 Catch:{ all -> 0x127b }
        r3 = 0;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 > 0) goto L_0x14ce;
    L_0x14bf:
        r24 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x127b }
        r14 = r24 - r33;
        r2 = (float) r14;	 Catch:{ all -> 0x127b }
        r4 = 0;
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r2, r4);	 Catch:{ all -> 0x127b }
        r12.setConnectedTime(r2);	 Catch:{ all -> 0x127b }
    L_0x14ce:
        r2 = "cdn_connect_fail ";
        r12.setErrorType(r2);	 Catch:{ all -> 0x127b }
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r1);	 Catch:{ all -> 0x127b }
        r12.setExceptionReason(r2);	 Catch:{ all -> 0x127b }
        r2 = "0.0";
        r12.setDownloadSpeed(r2);	 Catch:{ all -> 0x127b }
        r2 = "0";
        r12.setDownloaded(r2);	 Catch:{ all -> 0x127b }
        r2 = "0";
        r12.setDownloadTime(r2);	 Catch:{ all -> 0x127b }
        r2 = "failed";
        r12.setDownloadResult(r2);	 Catch:{ all -> 0x127b }
        goto L_0x14f0;
    L_0x14ef:
        r3 = 0;
    L_0x14f0:
        r2 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x159f }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x159f }
        r4.<init>();	 Catch:{ all -> 0x159f }
        r6 = "HlsDownloadThread MalformedURLException:";
        r4.append(r6);	 Catch:{ all -> 0x159f }
        r1 = r1.toString();	 Catch:{ all -> 0x159f }
        r4.append(r1);	 Catch:{ all -> 0x159f }
        r1 = r4.toString();	 Catch:{ all -> 0x159f }
        com.ximalaya.ting.android.player.Logger.log(r2, r1);	 Catch:{ all -> 0x159f }
        if (r5 != 0) goto L_0x1549;
    L_0x150c:
        if (r12 == 0) goto L_0x1549;
    L_0x150e:
        r1 = r12.getViaInfo();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x151c;
    L_0x1518:
        r1 = 0;
        r12.setViaInfo(r1);
    L_0x151c:
        r1 = r12.getStatusCode();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x152b;
    L_0x1526:
        r1 = "";
        r12.setStatusCode(r1);
    L_0x152b:
        r1 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r1);
        r1 = r12.getDownloadResult();
        if (r1 == 0) goto L_0x1544;
    L_0x1538:
        r1 = r12.getDownloadResult();
        r2 = "success";
        r1 = r1.contains(r2);
        if (r1 != 0) goto L_0x1549;
    L_0x1544:
        r1 = "failed";
        r12.setDownloadResult(r1);
    L_0x1549:
        if (r11 == 0) goto L_0x154e;
    L_0x154b:
        r11.disconnect();
    L_0x154e:
        if (r9 == 0) goto L_0x1553;
    L_0x1550:
        r9.close();	 Catch:{ IOException -> 0x1553 }
    L_0x1553:
        if (r7 == 0) goto L_0x1558;
    L_0x1555:
        r7.close();	 Catch:{ IOException -> 0x1558 }
    L_0x1558:
        r1 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "DownloadThread hls readData end:";
        r2.append(r4);
        r6 = java.lang.System.currentTimeMillis();
        r8 = r6 - r33;
        r2.append(r8);
        r2 = r2.toString();
        com.ximalaya.ting.android.player.Logger.log(r1, r2);
    L_0x1574:
        if (r12 == 0) goto L_0x1592;
    L_0x1576:
        if (r5 != 0) goto L_0x1592;
    L_0x1578:
        r1 = r12.getErrorType();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x1592;
    L_0x1582:
        r1 = r12.getExceptionReason();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x1592;
    L_0x158c:
        r1 = r40;
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r12, r1);
        goto L_0x1594;
    L_0x1592:
        r1 = r40;
    L_0x1594:
        r2 = r1;
        r6 = r19;
        r7 = r30;
        r1 = r43;
        r4 = 1;
        r13 = 1;
        goto L_0x001e;
    L_0x159f:
        r0 = move-exception;
        r1 = r40;
        r2 = r0;
    L_0x15a3:
        r13 = 1;
    L_0x15a4:
        if (r5 != 0) goto L_0x16f1;
    L_0x15a6:
        if (r12 == 0) goto L_0x16f1;
    L_0x15a8:
        r3 = r12.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x15b6;
    L_0x15b2:
        r3 = 0;
        r12.setViaInfo(r3);
    L_0x15b6:
        r3 = r12.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x15c5;
    L_0x15c0:
        r3 = "";
        r12.setStatusCode(r3);
    L_0x15c5:
        r3 = java.lang.System.currentTimeMillis();
        r12.setTimestamp(r3);
        r3 = r12.getDownloadResult();
        if (r3 == 0) goto L_0x15de;
    L_0x15d2:
        r3 = r12.getDownloadResult();
        r4 = "success";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x15e3;
    L_0x15de:
        r3 = "failed";
        r12.setDownloadResult(r3);
    L_0x15e3:
        if (r13 != 0) goto L_0x16f1;
    L_0x15e5:
        r3 = r1.getNetType();
        r4 = -1;
        if (r3 != r4) goto L_0x15ee;
    L_0x15ec:
        goto L_0x16f1;
    L_0x15ee:
        if (r3 != 0) goto L_0x166e;
    L_0x15f0:
        r3 = r1.getCdnNotWifiConnectTimeout();
        r3 = (long) r3;
        r5 = r43;
        r5.mLimitConnectTime = r3;
        r1 = r1.getCdnNotWifiAlertRate();
        r3 = (long) r1;
        r5.mLimitDownloadSpeed = r3;
        r3 = r5.mLimitConnectTime;
        r3 = r3 * r22;
        r1 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x1638;
    L_0x1608:
        r1 = "cdn_connected_too_slow";
        r12.setErrorType(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "connected_time=";
        r1.append(r3);
        r3 = (float) r14;
        r4 = 0;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r3, r4);
        r1.append(r3);
        r3 = "s, connected_time_threshold=";
        r1.append(r3);
        r3 = r5.mLimitConnectTime;
        r1.append(r3);
        r3 = "s";
        r1.append(r3);
        r1 = r1.toString();
        r12.setExceptionReason(r1);
        goto L_0x16f3;
    L_0x1638:
        r3 = r5.mLimitDownloadSpeed;
        r1 = (float) r3;
        r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1));
        if (r1 <= 0) goto L_0x16f3;
    L_0x163f:
        r1 = "cdn_download_too_slow";
        r12.setErrorType(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "download_speed=";
        r1.append(r3);
        r3 = 1;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r3);
        r1.append(r3);
        r3 = "KB/s, download_speed_threshold=";
        r1.append(r3);
        r3 = r5.mLimitDownloadSpeed;
        r1.append(r3);
        r3 = "KB/s";
        r1.append(r3);
        r1 = r1.toString();
        r12.setExceptionReason(r1);
        goto L_0x16f3;
    L_0x166e:
        r4 = 1;
        r5 = r43;
        if (r3 != r4) goto L_0x16f3;
    L_0x1673:
        r3 = r1.getCdnWifiConnectTimeout();
        r3 = (long) r3;
        r5.mLimitConnectTime = r3;
        r1 = r1.getCdnWifiAlertRate();
        r3 = (long) r1;
        r5.mLimitDownloadSpeed = r3;
        r3 = 0;
        r5.mLimitConnectTime = r3;
        r3 = r5.mLimitConnectTime;
        r3 = r3 * r22;
        r1 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x16bc;
    L_0x168d:
        r1 = "cdn_connected_too_slow";
        r12.setErrorType(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "connected_time=";
        r1.append(r3);
        r3 = (float) r14;
        r4 = 0;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r3, r4);
        r1.append(r3);
        r3 = "s, connected_time_threshold=";
        r1.append(r3);
        r3 = r5.mLimitConnectTime;
        r1.append(r3);
        r3 = "s";
        r1.append(r3);
        r1 = r1.toString();
        r12.setExceptionReason(r1);
        goto L_0x16f3;
    L_0x16bc:
        r3 = r5.mLimitDownloadSpeed;
        r1 = (float) r3;
        r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1));
        if (r1 <= 0) goto L_0x16f3;
    L_0x16c3:
        r1 = "cdn_download_too_slow";
        r12.setErrorType(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "download_speed=";
        r1.append(r3);
        r3 = 1;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r10, r3);
        r1.append(r3);
        r3 = "KB/s, download_speed_threshold=";
        r1.append(r3);
        r3 = r5.mLimitDownloadSpeed;
        r1.append(r3);
        r3 = "KB/s";
        r1.append(r3);
        r1 = r1.toString();
        r12.setExceptionReason(r1);
        goto L_0x16f3;
    L_0x16f1:
        r5 = r43;
    L_0x16f3:
        if (r11 == 0) goto L_0x16f8;
    L_0x16f5:
        r11.disconnect();
    L_0x16f8:
        if (r9 == 0) goto L_0x16fd;
    L_0x16fa:
        r9.close();	 Catch:{ IOException -> 0x16fd }
    L_0x16fd:
        if (r7 == 0) goto L_0x1702;
    L_0x16ff:
        r7.close();	 Catch:{ IOException -> 0x1702 }
    L_0x1702:
        r1 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "DownloadThread hls readData end:";
        r3.append(r4);
        r6 = java.lang.System.currentTimeMillis();
        r8 = r6 - r33;
        r3.append(r8);
        r3 = r3.toString();
        com.ximalaya.ting.android.player.Logger.log(r1, r3);
        throw r2;
    L_0x171f:
        r5 = r1;
        r1 = -1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.HlsDownloadThread.download():int");
    }
}
