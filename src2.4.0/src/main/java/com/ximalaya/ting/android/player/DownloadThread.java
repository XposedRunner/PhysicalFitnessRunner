package com.ximalaya.ting.android.player;

import java.nio.ByteBuffer;

public class DownloadThread {
    private static final String TAG = "dl_mp3";
    public static long downloadedSize;
    private ByteBuffer bBuffer = ByteBuffer.allocate(65536);
    private AudioFile mFile;
    private int mIndex;
    private long mLimitConnectTime;
    private long mLimitDownloadSpeed;
    private boolean stopFlag = false;

    public DownloadThread(AudioFile audioFile, int i) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("======================DownloadThread Constructor(");
        stringBuilder.append(i);
        stringBuilder.append(")");
        Logger.log(str, stringBuilder.toString());
        this.mFile = audioFile;
        this.mIndex = i;
    }

    public void close() {
        this.stopFlag = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0871 A:{PHI: r6 r10 , Splitter:B:211:0x0330, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0871 A:{PHI: r6 r10 , Splitter:B:211:0x0330, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:563:0x0944 A:{Splitter:B:18:0x004d, ExcHandler: all (r0_205 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0871 A:{PHI: r6 r10 , Splitter:B:211:0x0330, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0871 A:{PHI: r6 r10 , Splitter:B:211:0x0330, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:505:0x089e A:{Splitter:B:134:0x0231, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0871 A:{PHI: r6 r10 , Splitter:B:211:0x0330, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:822:0x0ed2 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:842:0x0f44  */
    /* JADX WARNING: Removed duplicated region for block: B:845:0x0f52  */
    /* JADX WARNING: Removed duplicated region for block: B:852:0x0f77  */
    /* JADX WARNING: Removed duplicated region for block: B:784:0x0e06 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:793:0x0e41 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:792:0x0e21 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:799:0x0e6e  */
    /* JADX WARNING: Removed duplicated region for block: B:802:0x0e7c  */
    /* JADX WARNING: Removed duplicated region for block: B:809:0x0ea1  */
    /* JADX WARNING: Removed duplicated region for block: B:811:0x0ea6  */
    /* JADX WARNING: Removed duplicated region for block: B:745:0x0d36 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:759:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:762:0x0da7  */
    /* JADX WARNING: Removed duplicated region for block: B:769:0x0dcc  */
    /* JADX WARNING: Removed duplicated region for block: B:771:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:708:0x0c75 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:720:0x0cce  */
    /* JADX WARNING: Removed duplicated region for block: B:723:0x0cdc  */
    /* JADX WARNING: Removed duplicated region for block: B:730:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x0d06  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0bb4 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0c0d  */
    /* JADX WARNING: Removed duplicated region for block: B:686:0x0c1b  */
    /* JADX WARNING: Removed duplicated region for block: B:693:0x0c40  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0c45  */
    /* JADX WARNING: Removed duplicated region for block: B:614:0x0a60 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:646:0x0b4c  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x0b7f  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0b84  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0966 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x09c8 A:{Catch:{ all -> 0x0fa5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:593:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x0a38  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x0a3d  */
    /* JADX WARNING: Removed duplicated region for block: B:868:0x0fbb  */
    /* JADX WARNING: Removed duplicated region for block: B:871:0x0fc9  */
    /* JADX WARNING: Removed duplicated region for block: B:878:0x0fee  */
    /* JADX WARNING: Removed duplicated region for block: B:898:0x10ef  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:183:0x02c9, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:184:0x02ca, code skipped:
            r6 = r11;
     */
    /* JADX WARNING: Missing block: B:185:0x02cd, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:186:0x02ce, code skipped:
            r6 = r11;
     */
    /* JADX WARNING: Missing block: B:187:0x02d1, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:188:0x02d2, code skipped:
            r6 = r11;
     */
    /* JADX WARNING: Missing block: B:189:0x02d5, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:190:0x02d6, code skipped:
            r6 = r11;
     */
    /* JADX WARNING: Missing block: B:191:0x02d9, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:192:0x02da, code skipped:
            r6 = r11;
     */
    /* JADX WARNING: Missing block: B:193:0x02dd, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:194:0x02de, code skipped:
            r6 = r11;
     */
    /* JADX WARNING: Missing block: B:195:0x02e1, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:196:0x02e2, code skipped:
            r6 = r11;
     */
    /* JADX WARNING: Missing block: B:441:0x07e5, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:442:0x07e6, code skipped:
            r3 = r0;
            r22 = r7;
            r16 = r10;
            r14 = r34;
     */
    /* JADX WARNING: Missing block: B:443:0x07ef, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:444:0x07f0, code skipped:
            r3 = r0;
            r22 = r7;
            r16 = r10;
            r14 = r34;
     */
    /* JADX WARNING: Missing block: B:445:0x07f9, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:446:0x07fa, code skipped:
            r3 = r0;
            r22 = r7;
            r16 = r10;
            r14 = r34;
     */
    /* JADX WARNING: Missing block: B:447:0x0803, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:448:0x0804, code skipped:
            r3 = r0;
            r22 = r7;
            r16 = r10;
            r14 = r34;
     */
    /* JADX WARNING: Missing block: B:449:0x080d, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:450:0x080e, code skipped:
            r3 = r0;
            r22 = r7;
            r16 = r10;
            r14 = r34;
     */
    /* JADX WARNING: Missing block: B:451:0x0817, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:452:0x0818, code skipped:
            r3 = r0;
            r22 = r7;
            r16 = r10;
            r14 = r34;
     */
    /* JADX WARNING: Missing block: B:453:0x0821, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:454:0x0822, code skipped:
            r3 = r0;
            r22 = r7;
            r16 = r10;
            r14 = r34;
     */
    /* JADX WARNING: Missing block: B:455:0x082b, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:456:0x082c, code skipped:
            r34 = r14;
     */
    /* JADX WARNING: Missing block: B:457:0x082f, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:458:0x0830, code skipped:
            r34 = r14;
     */
    /* JADX WARNING: Missing block: B:459:0x0833, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:460:0x0834, code skipped:
            r34 = r14;
     */
    /* JADX WARNING: Missing block: B:461:0x0837, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:462:0x0838, code skipped:
            r34 = r14;
     */
    /* JADX WARNING: Missing block: B:463:0x083b, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:464:0x083c, code skipped:
            r34 = r14;
     */
    /* JADX WARNING: Missing block: B:465:0x083f, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:466:0x0840, code skipped:
            r34 = r14;
     */
    /* JADX WARNING: Missing block: B:467:0x0843, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:468:0x0844, code skipped:
            r34 = r14;
     */
    /* JADX WARNING: Missing block: B:469:0x0847, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:471:0x084d, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:473:0x0853, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:475:0x0859, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:477:0x085f, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:479:0x0865, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:481:0x086b, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:483:0x0871, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:484:0x0874, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:485:0x0875, code skipped:
            r33 = r8;
     */
    /* JADX WARNING: Missing block: B:487:0x087a, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:488:0x087b, code skipped:
            r33 = r8;
     */
    /* JADX WARNING: Missing block: B:490:0x0880, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:491:0x0881, code skipped:
            r33 = r8;
     */
    /* JADX WARNING: Missing block: B:493:0x0886, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:494:0x0887, code skipped:
            r33 = r8;
     */
    /* JADX WARNING: Missing block: B:496:0x088c, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:497:0x088d, code skipped:
            r33 = r8;
     */
    /* JADX WARNING: Missing block: B:499:0x0892, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:500:0x0893, code skipped:
            r33 = r8;
     */
    /* JADX WARNING: Missing block: B:502:0x0898, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:503:0x0899, code skipped:
            r33 = r8;
     */
    /* JADX WARNING: Missing block: B:505:0x089e, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:544:0x0903, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:545:0x0904, code skipped:
            r30 = r6;
            r33 = r8;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:546:0x090a, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:547:0x090b, code skipped:
            r30 = r6;
            r33 = r8;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:548:0x0912, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:549:0x0913, code skipped:
            r30 = r6;
            r33 = r8;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:551:0x091c, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:552:0x091d, code skipped:
            r30 = r6;
            r33 = r8;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:554:0x0926, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:555:0x0927, code skipped:
            r30 = r6;
            r33 = r8;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:557:0x0930, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:558:0x0931, code skipped:
            r30 = r6;
            r33 = r8;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:560:0x093a, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:561:0x093b, code skipped:
            r30 = r6;
            r33 = r8;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:563:0x0944, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:564:0x0945, code skipped:
            r30 = r6;
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:609:0x0a51, code skipped:
            if (android.text.TextUtils.isEmpty(r13.getExceptionReason()) == false) goto L_0x0ebc;
     */
    /* JADX WARNING: Missing block: B:662:0x0b98, code skipped:
            if (android.text.TextUtils.isEmpty(r13.getExceptionReason()) == false) goto L_0x0ebc;
     */
    /* JADX WARNING: Missing block: B:699:0x0c59, code skipped:
            if (android.text.TextUtils.isEmpty(r13.getExceptionReason()) == false) goto L_0x0ebc;
     */
    /* JADX WARNING: Missing block: B:736:0x0d1a, code skipped:
            if (android.text.TextUtils.isEmpty(r13.getExceptionReason()) == false) goto L_0x0ebc;
     */
    /* JADX WARNING: Missing block: B:775:0x0de5, code skipped:
            if (android.text.TextUtils.isEmpty(r13.getExceptionReason()) == false) goto L_0x0ebc;
     */
    /* JADX WARNING: Missing block: B:815:0x0eba, code skipped:
            if (android.text.TextUtils.isEmpty(r13.getExceptionReason()) == false) goto L_0x0ebc;
     */
    /* JADX WARNING: Missing block: B:816:0x0ebc, code skipped:
            com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r13, r2);
     */
    public int download() {
        /*
        r40 = this;
        r1 = r40;
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.getCdnConfigModel();
        r3 = r1.stopFlag;
        if (r3 != 0) goto L_0x1112;
    L_0x000a:
        r3 = r1.mFile;
        if (r3 == 0) goto L_0x1112;
    L_0x000e:
        r3 = r1.mIndex;
        if (r3 < 0) goto L_0x1112;
    L_0x0012:
        r3 = r1.mFile;
        r3 = r3.getUrl();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0020;
    L_0x001e:
        goto L_0x1112;
    L_0x0020:
        r3 = 0;
        r5 = 1;
        if (r2 != 0) goto L_0x0026;
    L_0x0024:
        r6 = r5;
        goto L_0x0027;
    L_0x0026:
        r6 = r3;
    L_0x0027:
        r7 = 3;
        r8 = java.util.UUID.randomUUID();
        r8 = r8.toString();
        r14 = r3;
        r18 = r14;
        r19 = r18;
        r13 = 0;
        r15 = 0;
        r16 = 0;
        r20 = 0;
        r22 = 0;
    L_0x003d:
        r24 = r7 + -1;
        if (r7 <= 0) goto L_0x1110;
    L_0x0041:
        if (r6 != 0) goto L_0x0049;
    L_0x0043:
        r7 = new com.ximalaya.ting.android.player.cdn.CdnCollectDataForPlay;
        r7.<init>();
        r13 = r7;
    L_0x0049:
        r25 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r27 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r28 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x0ec5, SocketTimeoutException -> 0x0de9, UnknownHostException -> 0x0d1e, IllegalArgumentException -> 0x0c5d, FileNotFoundException -> 0x0b9c, IOException -> 0x0a55, Throwable -> 0x094f, all -> 0x0944 }
        r11 = r1.mIndex;	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r7 = r1.mFile;	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r7 = r7.getFileInfo();	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r7 = r7.getComChunkNum();	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r7 = r7 - r5;
        r12 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        if (r11 != r7) goto L_0x00af;
    L_0x0062:
        r7 = r1.mIndex;	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r7 = r7 * r12;
        r11 = r1.mFile;	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r11 = r11.getFileInfo();	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r11 = r11.getComFileLen();	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r11 = r11 - r5;
        goto L_0x00b7;
    L_0x0071:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
        goto L_0x0948;
    L_0x0077:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
        r33 = r8;
        goto L_0x0957;
    L_0x007f:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
        r33 = r8;
        goto L_0x0a5d;
    L_0x0087:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
        r33 = r8;
        goto L_0x0918;
    L_0x008f:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
        r33 = r8;
        goto L_0x0922;
    L_0x0097:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
        r33 = r8;
        goto L_0x092c;
    L_0x009f:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
        r33 = r8;
        goto L_0x0936;
    L_0x00a7:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
        r33 = r8;
        goto L_0x0940;
    L_0x00af:
        r7 = r1.mIndex;	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r7 = r7 * r12;
        r11 = r1.mIndex;	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r11 = r11 + r5;
        r11 = r11 * r12;
        r11 = r11 - r5;
    L_0x00b7:
        if (r13 == 0) goto L_0x00e2;
    L_0x00b9:
        r9 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r9.<init>();	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r9.append(r7);	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r10 = "-";
        r9.append(r10);	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r9.append(r11);	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r9 = r9.toString();	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r13.setRange(r9);	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r9 = r1.mFile;	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r9 = r9.getFileInfo();	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r9 = r9.getComFileLen();	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r9 = r9 - r5;
        r9 = java.lang.String.valueOf(r9);	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
        r13.setFileSize(r9);	 Catch:{ MalformedURLException -> 0x00a7, SocketTimeoutException -> 0x009f, UnknownHostException -> 0x0097, IllegalArgumentException -> 0x008f, FileNotFoundException -> 0x0087, IOException -> 0x007f, Throwable -> 0x0077, all -> 0x0071 }
    L_0x00e2:
        r9 = "bytes=%d-%d";
        r10 = 2;
        r4 = new java.lang.Object[r10];	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r4[r3] = r7;	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r7 = java.lang.Integer.valueOf(r11);	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r4[r5] = r7;	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r4 = java.lang.String.format(r9, r4);	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r7 = new java.lang.String[r5];	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r9 = r1.mFile;	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r9 = r9.getUrl();	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r7[r3] = r9;	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r9 = r1.mFile;	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r9 = r9.getUrl();	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        if (r9 == 0) goto L_0x0110;
    L_0x010d:
        r9 = "";
        goto L_0x011e;
    L_0x0110:
        r9 = r1.mFile;	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r9 = r9.getUrl();	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r9 = android.net.Uri.parse(r9);	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r9 = r9.getHost();	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
    L_0x011e:
        r11 = "GET";
        r11 = com.ximalaya.ting.android.player.PlayerUtil.getConnectionUseDnsCache(r7, r4, r3, r3, r11);	 Catch:{ MalformedURLException -> 0x093a, SocketTimeoutException -> 0x0930, UnknownHostException -> 0x0926, IllegalArgumentException -> 0x091c, FileNotFoundException -> 0x0912, IOException -> 0x090a, Throwable -> 0x0903, all -> 0x0944 }
        r4 = r1.mFile;	 Catch:{ MalformedURLException -> 0x08f8, SocketTimeoutException -> 0x08ed, UnknownHostException -> 0x08e2, IllegalArgumentException -> 0x08d7, FileNotFoundException -> 0x08cc, IOException -> 0x08c3, Throwable -> 0x08ba, all -> 0x08af }
        r7 = r7[r3];	 Catch:{ MalformedURLException -> 0x08f8, SocketTimeoutException -> 0x08ed, UnknownHostException -> 0x08e2, IllegalArgumentException -> 0x08d7, FileNotFoundException -> 0x08cc, IOException -> 0x08c3, Throwable -> 0x08ba, all -> 0x08af }
        r4.setUrl(r7);	 Catch:{ MalformedURLException -> 0x08f8, SocketTimeoutException -> 0x08ed, UnknownHostException -> 0x08e2, IllegalArgumentException -> 0x08d7, FileNotFoundException -> 0x08cc, IOException -> 0x08c3, Throwable -> 0x08ba, all -> 0x08af }
        if (r11 != 0) goto L_0x0174;
    L_0x012d:
        r4 = new java.io.IOException;	 Catch:{ MalformedURLException -> 0x016c, SocketTimeoutException -> 0x0164, UnknownHostException -> 0x015c, IllegalArgumentException -> 0x0154, FileNotFoundException -> 0x014c, IOException -> 0x0144, Throwable -> 0x013c, all -> 0x0135 }
        r7 = "DownloadThread fail httpUrlConnection connect fail httpUrlConnection==null";
        r4.<init>(r7);	 Catch:{ MalformedURLException -> 0x016c, SocketTimeoutException -> 0x0164, UnknownHostException -> 0x015c, IllegalArgumentException -> 0x0154, FileNotFoundException -> 0x014c, IOException -> 0x0144, Throwable -> 0x013c, all -> 0x0135 }
        throw r4;	 Catch:{ MalformedURLException -> 0x016c, SocketTimeoutException -> 0x0164, UnknownHostException -> 0x015c, IllegalArgumentException -> 0x0154, FileNotFoundException -> 0x014c, IOException -> 0x0144, Throwable -> 0x013c, all -> 0x0135 }
    L_0x0135:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
    L_0x0139:
        r6 = r11;
        goto L_0x08b4;
    L_0x013c:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
    L_0x0140:
        r33 = r8;
        goto L_0x0958;
    L_0x0144:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
    L_0x0148:
        r33 = r8;
        goto L_0x0a5e;
    L_0x014c:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
    L_0x0150:
        r33 = r8;
        goto L_0x08d3;
    L_0x0154:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
    L_0x0158:
        r33 = r8;
        goto L_0x08de;
    L_0x015c:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
    L_0x0160:
        r33 = r8;
        goto L_0x08e9;
    L_0x0164:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
    L_0x0168:
        r33 = r8;
        goto L_0x08f4;
    L_0x016c:
        r0 = move-exception;
        r3 = r0;
        r30 = r6;
    L_0x0170:
        r33 = r8;
        goto L_0x08ff;
    L_0x0174:
        if (r13 == 0) goto L_0x022f;
    L_0x0176:
        r20 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x0229, SocketTimeoutException -> 0x0223, UnknownHostException -> 0x021d, IllegalArgumentException -> 0x0217, FileNotFoundException -> 0x0211, IOException -> 0x020b, Throwable -> 0x0205, all -> 0x01ff }
        r30 = r6;
        r5 = r20 - r28;
        r4 = (float) r5;
        r4 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r4, r3);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r13.setConnectedTime(r4);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r4 = r1.mFile;	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r4 = r4.getUrl();	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r13.setAudioUrl(r4);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r13.setCdnDomain(r9);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r4 = r1.mFile;	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r4 = r4.getUrl();	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r4 = com.ximalaya.ting.android.player.cdn.CdnUtil.getUrlIp(r4);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r13.setCdnIP(r4);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r4 = "play";
        r13.setType(r4);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r4 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r4.<init>();	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r7 = r11.getResponseCode();	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r4.append(r7);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r7 = "";
        r4.append(r7);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r4 = r4.toString();	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r13.setStatusCode(r4);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r4 = "via";
        r4 = r11.getHeaderField(r4);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r13.setViaInfo(r4);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r13.setRequestUUID(r8);	 Catch:{ MalformedURLException -> 0x01f9, SocketTimeoutException -> 0x01f3, UnknownHostException -> 0x01ed, IllegalArgumentException -> 0x01e7, FileNotFoundException -> 0x01e1, IOException -> 0x01db, Throwable -> 0x01d5, all -> 0x01cc }
        r16 = r5;
        goto L_0x0231;
    L_0x01cc:
        r0 = move-exception;
        r3 = r0;
        r38 = r5;
        r6 = r11;
        r10 = r38;
        goto L_0x08b6;
    L_0x01d5:
        r0 = move-exception;
        r3 = r0;
        r16 = r5;
        goto L_0x0140;
    L_0x01db:
        r0 = move-exception;
        r3 = r0;
        r16 = r5;
        goto L_0x0148;
    L_0x01e1:
        r0 = move-exception;
        r3 = r0;
        r16 = r5;
        goto L_0x0150;
    L_0x01e7:
        r0 = move-exception;
        r3 = r0;
        r16 = r5;
        goto L_0x0158;
    L_0x01ed:
        r0 = move-exception;
        r3 = r0;
        r16 = r5;
        goto L_0x0160;
    L_0x01f3:
        r0 = move-exception;
        r3 = r0;
        r16 = r5;
        goto L_0x0168;
    L_0x01f9:
        r0 = move-exception;
        r3 = r0;
        r16 = r5;
        goto L_0x0170;
    L_0x01ff:
        r0 = move-exception;
        r30 = r6;
        r3 = r0;
        goto L_0x0139;
    L_0x0205:
        r0 = move-exception;
        r30 = r6;
    L_0x0208:
        r3 = r0;
        goto L_0x0140;
    L_0x020b:
        r0 = move-exception;
        r30 = r6;
    L_0x020e:
        r3 = r0;
        goto L_0x0148;
    L_0x0211:
        r0 = move-exception;
        r30 = r6;
    L_0x0214:
        r3 = r0;
        goto L_0x0150;
    L_0x0217:
        r0 = move-exception;
        r30 = r6;
    L_0x021a:
        r3 = r0;
        goto L_0x0158;
    L_0x021d:
        r0 = move-exception;
        r30 = r6;
    L_0x0220:
        r3 = r0;
        goto L_0x0160;
    L_0x0223:
        r0 = move-exception;
        r30 = r6;
    L_0x0226:
        r3 = r0;
        goto L_0x0168;
    L_0x0229:
        r0 = move-exception;
        r30 = r6;
    L_0x022c:
        r3 = r0;
        goto L_0x0170;
    L_0x022f:
        r30 = r6;
    L_0x0231:
        r4 = r11.getResponseCode();	 Catch:{ MalformedURLException -> 0x08ac, SocketTimeoutException -> 0x08aa, UnknownHostException -> 0x08a8, IllegalArgumentException -> 0x08a6, FileNotFoundException -> 0x08a4, IOException -> 0x08a2, Throwable -> 0x08a0, all -> 0x089e }
        if (r13 == 0) goto L_0x02e5;
    L_0x0237:
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x02e1, SocketTimeoutException -> 0x02dd, UnknownHostException -> 0x02d9, IllegalArgumentException -> 0x02d5, FileNotFoundException -> 0x02d1, IOException -> 0x02cd, Throwable -> 0x02c9, all -> 0x089e }
        r31 = r11;
        r10 = r5 - r28;
        r5 = (float) r10;
        r5 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r5, r3);	 Catch:{ MalformedURLException -> 0x02bc, SocketTimeoutException -> 0x02af, UnknownHostException -> 0x02a2, IllegalArgumentException -> 0x0295, FileNotFoundException -> 0x0288, IOException -> 0x027d, Throwable -> 0x0272, all -> 0x026c }
        r13.setConnectedTime(r5);	 Catch:{ MalformedURLException -> 0x02bc, SocketTimeoutException -> 0x02af, UnknownHostException -> 0x02a2, IllegalArgumentException -> 0x0295, FileNotFoundException -> 0x0288, IOException -> 0x027d, Throwable -> 0x0272, all -> 0x026c }
        r5 = "via";
        r6 = r31;
        r5 = r6.getHeaderField(r5);	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r13.setViaInfo(r5);	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r5 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r5.<init>();	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r7 = r6.getResponseCode();	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r5.append(r7);	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r7 = "";
        r5.append(r7);	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r5 = r5.toString();	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r13.setStatusCode(r5);	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        goto L_0x02e8;
    L_0x026c:
        r0 = move-exception;
        r6 = r31;
    L_0x026f:
        r3 = r0;
        goto L_0x08b6;
    L_0x0272:
        r0 = move-exception;
        r6 = r31;
    L_0x0275:
        r3 = r0;
        r33 = r8;
    L_0x0278:
        r16 = r10;
    L_0x027a:
        r11 = r6;
        goto L_0x0958;
    L_0x027d:
        r0 = move-exception;
        r6 = r31;
    L_0x0280:
        r3 = r0;
        r33 = r8;
    L_0x0283:
        r16 = r10;
    L_0x0285:
        r11 = r6;
        goto L_0x0a5e;
    L_0x0288:
        r0 = move-exception;
        r6 = r31;
    L_0x028b:
        r3 = r0;
        r33 = r8;
    L_0x028e:
        r16 = r10;
    L_0x0290:
        r4 = 0;
        r11 = r6;
        goto L_0x0ba7;
    L_0x0295:
        r0 = move-exception;
        r6 = r31;
    L_0x0298:
        r3 = r0;
        r33 = r8;
    L_0x029b:
        r16 = r10;
    L_0x029d:
        r4 = 0;
        r11 = r6;
        goto L_0x0c68;
    L_0x02a2:
        r0 = move-exception;
        r6 = r31;
    L_0x02a5:
        r3 = r0;
        r33 = r8;
    L_0x02a8:
        r16 = r10;
    L_0x02aa:
        r4 = 0;
        r11 = r6;
        goto L_0x0d29;
    L_0x02af:
        r0 = move-exception;
        r6 = r31;
    L_0x02b2:
        r3 = r0;
        r33 = r8;
    L_0x02b5:
        r16 = r10;
    L_0x02b7:
        r4 = 0;
        r11 = r6;
        goto L_0x0df4;
    L_0x02bc:
        r0 = move-exception;
        r6 = r31;
    L_0x02bf:
        r3 = r0;
        r33 = r8;
    L_0x02c2:
        r16 = r10;
    L_0x02c4:
        r4 = 0;
        r11 = r6;
        goto L_0x0ed0;
    L_0x02c9:
        r0 = move-exception;
        r6 = r11;
        goto L_0x0208;
    L_0x02cd:
        r0 = move-exception;
        r6 = r11;
        goto L_0x020e;
    L_0x02d1:
        r0 = move-exception;
        r6 = r11;
        goto L_0x0214;
    L_0x02d5:
        r0 = move-exception;
        r6 = r11;
        goto L_0x021a;
    L_0x02d9:
        r0 = move-exception;
        r6 = r11;
        goto L_0x0220;
    L_0x02dd:
        r0 = move-exception;
        r6 = r11;
        goto L_0x0226;
    L_0x02e1:
        r0 = move-exception;
        r6 = r11;
        goto L_0x022c;
    L_0x02e5:
        r6 = r11;
        r10 = r16;
    L_0x02e8:
        r5 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r4 == r5) goto L_0x0330;
    L_0x02ec:
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 == r5) goto L_0x0330;
    L_0x02f0:
        r5 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r7 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r7.<init>();	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r9 = "DownloadThread fail responseCode:";
        r7.append(r9);	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r7.append(r4);	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r7 = r7.toString();	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        com.ximalaya.ting.android.player.Logger.log(r5, r7);	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r5 = new java.io.IOException;	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r7 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r7.<init>();	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r9 = "DownloadThread fail responseCode:";
        r7.append(r9);	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r7.append(r4);	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r4 = r7.toString();	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        r5.<init>(r4);	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
        throw r5;	 Catch:{ MalformedURLException -> 0x032e, SocketTimeoutException -> 0x032c, UnknownHostException -> 0x0329, IllegalArgumentException -> 0x0326, FileNotFoundException -> 0x0323, IOException -> 0x0320, Throwable -> 0x031d, all -> 0x0871 }
    L_0x031d:
        r0 = move-exception;
        goto L_0x0275;
    L_0x0320:
        r0 = move-exception;
        goto L_0x0280;
    L_0x0323:
        r0 = move-exception;
        goto L_0x028b;
    L_0x0326:
        r0 = move-exception;
        goto L_0x0298;
    L_0x0329:
        r0 = move-exception;
        goto L_0x02a5;
    L_0x032c:
        r0 = move-exception;
        goto L_0x02b2;
    L_0x032e:
        r0 = move-exception;
        goto L_0x02bf;
    L_0x0330:
        r5 = r6.getContentLength();	 Catch:{ MalformedURLException -> 0x0898, SocketTimeoutException -> 0x0892, UnknownHostException -> 0x088c, IllegalArgumentException -> 0x0886, FileNotFoundException -> 0x0880, IOException -> 0x087a, Throwable -> 0x0874, all -> 0x0871 }
        r7 = "Content-Range";
        r7 = r6.getHeaderField(r7);	 Catch:{ MalformedURLException -> 0x0898, SocketTimeoutException -> 0x0892, UnknownHostException -> 0x088c, IllegalArgumentException -> 0x0886, FileNotFoundException -> 0x0880, IOException -> 0x087a, Throwable -> 0x0874, all -> 0x0871 }
        r9 = android.text.TextUtils.isEmpty(r7);	 Catch:{ MalformedURLException -> 0x0898, SocketTimeoutException -> 0x0892, UnknownHostException -> 0x088c, IllegalArgumentException -> 0x0886, FileNotFoundException -> 0x0880, IOException -> 0x087a, Throwable -> 0x0874, all -> 0x0871 }
        if (r9 != 0) goto L_0x037e;
    L_0x0340:
        r9 = "/";
        r7 = r7.split(r9);	 Catch:{ MalformedURLException -> 0x0898, SocketTimeoutException -> 0x0892, UnknownHostException -> 0x088c, IllegalArgumentException -> 0x0886, FileNotFoundException -> 0x0880, IOException -> 0x087a, Throwable -> 0x0874, all -> 0x0871 }
        r9 = "";
        r16 = "";
        r12 = r7.length;	 Catch:{ MalformedURLException -> 0x0898, SocketTimeoutException -> 0x0892, UnknownHostException -> 0x088c, IllegalArgumentException -> 0x0886, FileNotFoundException -> 0x0880, IOException -> 0x087a, Throwable -> 0x0874, all -> 0x0871 }
        r33 = r8;
        r8 = 2;
        if (r12 < r8) goto L_0x0373;
    L_0x0350:
        r8 = r7[r3];	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r8 = android.text.TextUtils.isEmpty(r8);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        if (r8 != 0) goto L_0x0368;
    L_0x0358:
        r8 = r7[r3];	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r12 = " ";
        r8 = r8.split(r12);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r12 = r8.length;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r3 = 2;
        if (r12 < r3) goto L_0x0368;
    L_0x0364:
        r3 = 1;
        r8 = r8[r3];	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r9 = r8;
    L_0x0368:
        r3 = 1;
        r8 = r7[r3];	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r8 = android.text.TextUtils.isEmpty(r8);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        if (r8 != 0) goto L_0x0373;
    L_0x0371:
        r16 = r7[r3];	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
    L_0x0373:
        r3 = r16;
        if (r13 == 0) goto L_0x0380;
    L_0x0377:
        r13.setRange(r9);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r13.setFileSize(r3);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        goto L_0x0380;
    L_0x037e:
        r33 = r8;
    L_0x0380:
        if (r5 > 0) goto L_0x03c9;
    L_0x0382:
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4.<init>();	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r7 = "DownloadThread fail contentLength0:";
        r4.append(r7);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4.append(r5);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4 = r4.toString();	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        com.ximalaya.ting.android.player.Logger.log(r3, r4);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r3 = new java.io.IOException;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4.<init>();	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r7 = "DownloadThread fail contentLength(";
        r4.append(r7);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4.append(r5);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r5 = ") <= 0";
        r4.append(r5);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4 = r4.toString();	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r3.<init>(r4);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        throw r3;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
    L_0x03b4:
        r0 = move-exception;
        goto L_0x0877;
    L_0x03b7:
        r0 = move-exception;
        goto L_0x087d;
    L_0x03ba:
        r0 = move-exception;
        goto L_0x0883;
    L_0x03bd:
        r0 = move-exception;
        goto L_0x0889;
    L_0x03c0:
        r0 = move-exception;
        goto L_0x088f;
    L_0x03c3:
        r0 = move-exception;
        goto L_0x0895;
    L_0x03c6:
        r0 = move-exception;
        goto L_0x089b;
    L_0x03c9:
        r3 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        if (r5 == r3) goto L_0x03df;
    L_0x03cd:
        r3 = r1.mIndex;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r7 = r1.mFile;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r7 = r7.getFileInfo();	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r7 = r7.getComChunkNum();	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r8 = 1;
        r7 = r7 - r8;
        if (r3 < r7) goto L_0x03e1;
    L_0x03dd:
        r3 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
    L_0x03df:
        if (r5 <= r3) goto L_0x0418;
    L_0x03e1:
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4.<init>();	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r7 = "DownloadThread fail contentLength1:";
        r4.append(r7);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4.append(r5);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4 = r4.toString();	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        com.ximalaya.ting.android.player.Logger.log(r3, r4);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r3 = new java.io.IOException;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4.<init>();	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r7 = "DownloadThread fail contentLength(";
        r4.append(r7);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4.append(r5);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r5 = ")!=DEFAULT_CHUNK_SIZE";
        r4.append(r5);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r5 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r4.append(r5);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r4 = r4.toString();	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r3.<init>(r4);	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        throw r3;	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
    L_0x0418:
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x03c6, SocketTimeoutException -> 0x03c3, UnknownHostException -> 0x03c0, IllegalArgumentException -> 0x03bd, FileNotFoundException -> 0x03ba, IOException -> 0x03b7, Throwable -> 0x03b4, all -> 0x0871 }
        r3 = r6.getInputStream();	 Catch:{ MalformedURLException -> 0x086b, SocketTimeoutException -> 0x0865, UnknownHostException -> 0x085f, IllegalArgumentException -> 0x0859, FileNotFoundException -> 0x0853, IOException -> 0x084d, Throwable -> 0x0847, all -> 0x0871 }
        r16 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x086b, SocketTimeoutException -> 0x0865, UnknownHostException -> 0x085f, IllegalArgumentException -> 0x0859, FileNotFoundException -> 0x0853, IOException -> 0x084d, Throwable -> 0x0847, all -> 0x0871 }
        r9 = 0;
    L_0x0425:
        r12 = r1.bBuffer;	 Catch:{ MalformedURLException -> 0x0843, SocketTimeoutException -> 0x083f, UnknownHostException -> 0x083b, IllegalArgumentException -> 0x0837, FileNotFoundException -> 0x0833, IOException -> 0x082f, Throwable -> 0x082b, all -> 0x0871 }
        r12 = r12.array();	 Catch:{ MalformedURLException -> 0x0843, SocketTimeoutException -> 0x083f, UnknownHostException -> 0x083b, IllegalArgumentException -> 0x0837, FileNotFoundException -> 0x0833, IOException -> 0x082f, Throwable -> 0x082b, all -> 0x0871 }
        r34 = r14;
        r20 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r14 = r20 - r9;
        r12 = r3.read(r12, r9, r14);	 Catch:{ MalformedURLException -> 0x0821, SocketTimeoutException -> 0x0817, UnknownHostException -> 0x080d, IllegalArgumentException -> 0x0803, FileNotFoundException -> 0x07f9, IOException -> 0x07ef, Throwable -> 0x07e5, all -> 0x0871 }
        r14 = -1;
        if (r12 == r14) goto L_0x04c5;
    L_0x0438:
        r14 = r9 + r12;
        r21 = downloadedSize;	 Catch:{ MalformedURLException -> 0x04b8, SocketTimeoutException -> 0x04ab, UnknownHostException -> 0x049e, IllegalArgumentException -> 0x0491, FileNotFoundException -> 0x0484, IOException -> 0x0477, Throwable -> 0x046a, all -> 0x0465 }
        r35 = r10;
        r9 = (long) r12;
        r31 = r21 + r9;
        downloadedSize = r31;	 Catch:{ MalformedURLException -> 0x0462, SocketTimeoutException -> 0x045f, UnknownHostException -> 0x045d, IllegalArgumentException -> 0x045b, FileNotFoundException -> 0x0459, IOException -> 0x0457, Throwable -> 0x0455, all -> 0x044d }
        r9 = r20 - r14;
        if (r9 > 0) goto L_0x0449;
    L_0x0447:
        goto L_0x04c9;
    L_0x0449:
        r9 = r14;
        r10 = r35;
        goto L_0x0425;
    L_0x044d:
        r0 = move-exception;
        r3 = r0;
        r5 = r19;
        r10 = r35;
        goto L_0x0fad;
    L_0x0455:
        r0 = move-exception;
        goto L_0x046d;
    L_0x0457:
        r0 = move-exception;
        goto L_0x047a;
    L_0x0459:
        r0 = move-exception;
        goto L_0x0487;
    L_0x045b:
        r0 = move-exception;
        goto L_0x0494;
    L_0x045d:
        r0 = move-exception;
        goto L_0x04a1;
    L_0x045f:
        r0 = move-exception;
        goto L_0x04ae;
    L_0x0462:
        r0 = move-exception;
        goto L_0x04bb;
    L_0x0465:
        r0 = move-exception;
        r35 = r10;
        goto L_0x026f;
    L_0x046a:
        r0 = move-exception;
        r35 = r10;
    L_0x046d:
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r14 = r34;
        r16 = r35;
        goto L_0x0958;
    L_0x0477:
        r0 = move-exception;
        r35 = r10;
    L_0x047a:
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r14 = r34;
        r16 = r35;
        goto L_0x0a5e;
    L_0x0484:
        r0 = move-exception;
        r35 = r10;
    L_0x0487:
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r14 = r34;
        r16 = r35;
        goto L_0x08d3;
    L_0x0491:
        r0 = move-exception;
        r35 = r10;
    L_0x0494:
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r14 = r34;
        r16 = r35;
        goto L_0x08de;
    L_0x049e:
        r0 = move-exception;
        r35 = r10;
    L_0x04a1:
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r14 = r34;
        r16 = r35;
        goto L_0x08e9;
    L_0x04ab:
        r0 = move-exception;
        r35 = r10;
    L_0x04ae:
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r14 = r34;
        r16 = r35;
        goto L_0x08f4;
    L_0x04b8:
        r0 = move-exception;
        r35 = r10;
    L_0x04bb:
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r14 = r34;
        r16 = r35;
        goto L_0x08ff;
    L_0x04c5:
        r35 = r10;
        r14 = r34;
    L_0x04c9:
        r9 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x07e0, SocketTimeoutException -> 0x07db, UnknownHostException -> 0x07d6, IllegalArgumentException -> 0x07d1, FileNotFoundException -> 0x07cc, IOException -> 0x07c7, Throwable -> 0x07c2, all -> 0x07bd }
        r9.<init>();	 Catch:{ MalformedURLException -> 0x07e0, SocketTimeoutException -> 0x07db, UnknownHostException -> 0x07d6, IllegalArgumentException -> 0x07d1, FileNotFoundException -> 0x07cc, IOException -> 0x07c7, Throwable -> 0x07c2, all -> 0x07bd }
        r10 = "UnicomDigestAuthenticator 789 == 读取流成功 ==  耗时=";
        r9.append(r10);	 Catch:{ MalformedURLException -> 0x07e0, SocketTimeoutException -> 0x07db, UnknownHostException -> 0x07d6, IllegalArgumentException -> 0x07d1, FileNotFoundException -> 0x07cc, IOException -> 0x07c7, Throwable -> 0x07c2, all -> 0x07bd }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x07e0, SocketTimeoutException -> 0x07db, UnknownHostException -> 0x07d6, IllegalArgumentException -> 0x07d1, FileNotFoundException -> 0x07cc, IOException -> 0x07c7, Throwable -> 0x07c2, all -> 0x07bd }
        r37 = r2;
        r1 = r10 - r16;
        r9.append(r1);	 Catch:{ MalformedURLException -> 0x07b4, SocketTimeoutException -> 0x07ab, UnknownHostException -> 0x07a2, IllegalArgumentException -> 0x0799, FileNotFoundException -> 0x0790, IOException -> 0x0787, Throwable -> 0x077e, all -> 0x0775 }
        r1 = r9.toString();	 Catch:{ MalformedURLException -> 0x07b4, SocketTimeoutException -> 0x07ab, UnknownHostException -> 0x07a2, IllegalArgumentException -> 0x0799, FileNotFoundException -> 0x0790, IOException -> 0x0787, Throwable -> 0x077e, all -> 0x0775 }
        com.ximalaya.ting.android.player.Logger.log(r1);	 Catch:{ MalformedURLException -> 0x07b4, SocketTimeoutException -> 0x07ab, UnknownHostException -> 0x07a2, IllegalArgumentException -> 0x0799, FileNotFoundException -> 0x0790, IOException -> 0x0787, Throwable -> 0x077e, all -> 0x0775 }
        if (r13 == 0) goto L_0x05c0;
    L_0x04e7:
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r9 = r1 - r7;
        r1 = 0;
        r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1));
        if (r11 == 0) goto L_0x04ff;
    L_0x04f3:
        r1 = (float) r14;	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r2 = 0;
        r1 = r1 + r2;
        r11 = 1149239296; // 0x44800000 float:1024.0 double:5.67799655E-315;
        r1 = r1 / r11;
        r11 = (float) r9;	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r11 = r11 + r2;
        r11 = r11 / r27;
        r15 = r1 / r11;
    L_0x04ff:
        r1 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1.<init>();	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1.append(r14);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r2 = "";
        r1.append(r2);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1 = r1.toString();	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r13.setDownloaded(r1);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1.<init>();	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1.append(r9);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r2 = "";
        r1.append(r2);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1 = r1.toString();	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r13.setDownloadTime(r1);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1 = -1;
        if (r12 == r1) goto L_0x0535;
    L_0x052a:
        r1 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        if (r14 != r1) goto L_0x052f;
    L_0x052e:
        goto L_0x0535;
    L_0x052f:
        r1 = "failed";
        r13.setDownloadResult(r1);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        goto L_0x053a;
    L_0x0535:
        r1 = "success";
        r13.setDownloadResult(r1);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
    L_0x053a:
        r1 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1.<init>();	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r2 = 1;
        r9 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r2);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1.append(r9);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r2 = "";
        r1.append(r2);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1 = r1.toString();	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r13.setDownloadSpeed(r1);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r1 = (long) r5;	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        r13.setAudioBytes(r1);	 Catch:{ MalformedURLException -> 0x05b3, SocketTimeoutException -> 0x05a6, UnknownHostException -> 0x0599, IllegalArgumentException -> 0x058c, FileNotFoundException -> 0x057f, IOException -> 0x0572, Throwable -> 0x0565, all -> 0x0559 }
        goto L_0x05c0;
    L_0x0559:
        r0 = move-exception;
        r3 = r0;
        r5 = r19;
        r10 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x0fad;
    L_0x0565:
        r0 = move-exception;
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r16 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x0958;
    L_0x0572:
        r0 = move-exception;
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r16 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x0a5e;
    L_0x057f:
        r0 = move-exception;
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r16 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x08d3;
    L_0x058c:
        r0 = move-exception;
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r16 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x08de;
    L_0x0599:
        r0 = move-exception;
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r16 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x08e9;
    L_0x05a6:
        r0 = move-exception;
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r16 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x08f4;
    L_0x05b3:
        r0 = move-exception;
        r3 = r0;
        r11 = r6;
        r22 = r7;
        r16 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x08ff;
    L_0x05c0:
        r3.close();	 Catch:{ MalformedURLException -> 0x07b4, SocketTimeoutException -> 0x07ab, UnknownHostException -> 0x07a2, IllegalArgumentException -> 0x0799, FileNotFoundException -> 0x0790, IOException -> 0x0787, Throwable -> 0x077e, all -> 0x0775 }
        r1 = r40;
        r2 = r1.mFile;	 Catch:{ MalformedURLException -> 0x076e, SocketTimeoutException -> 0x0767, UnknownHostException -> 0x0760, IllegalArgumentException -> 0x0759, FileNotFoundException -> 0x0752, IOException -> 0x074b, Throwable -> 0x0744, all -> 0x073d }
        r3 = r1.bBuffer;	 Catch:{ MalformedURLException -> 0x076e, SocketTimeoutException -> 0x0767, UnknownHostException -> 0x0760, IllegalArgumentException -> 0x0759, FileNotFoundException -> 0x0752, IOException -> 0x074b, Throwable -> 0x0744, all -> 0x073d }
        r2.setbBuffer(r3);	 Catch:{ MalformedURLException -> 0x076e, SocketTimeoutException -> 0x0767, UnknownHostException -> 0x0760, IllegalArgumentException -> 0x0759, FileNotFoundException -> 0x0752, IOException -> 0x074b, Throwable -> 0x0744, all -> 0x073d }
        if (r30 != 0) goto L_0x071d;
    L_0x05ce:
        if (r13 == 0) goto L_0x071d;
    L_0x05d0:
        r2 = r13.getViaInfo();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x05de;
    L_0x05da:
        r2 = 0;
        r13.setViaInfo(r2);
    L_0x05de:
        r2 = r13.getStatusCode();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x05ed;
    L_0x05e8:
        r2 = "";
        r13.setStatusCode(r2);
    L_0x05ed:
        r2 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r2);
        r2 = r13.getDownloadResult();
        if (r2 == 0) goto L_0x0606;
    L_0x05fa:
        r2 = r13.getDownloadResult();
        r3 = "success";
        r2 = r2.contains(r3);
        if (r2 != 0) goto L_0x060b;
    L_0x0606:
        r2 = "failed";
        r13.setDownloadResult(r2);
    L_0x060b:
        if (r18 != 0) goto L_0x0715;
    L_0x060d:
        r2 = r37;
        r3 = r2.getNetType();
        r5 = -1;
        if (r3 != r5) goto L_0x061a;
    L_0x0616:
        r30 = 1;
        goto L_0x0717;
    L_0x061a:
        if (r3 != 0) goto L_0x0698;
    L_0x061c:
        r3 = r2.getCdnNotWifiConnectTimeout();
        r7 = (long) r3;
        r1.mLimitConnectTime = r7;
        r3 = r2.getCdnNotWifiAlertRate();
        r7 = (long) r3;
        r1.mLimitDownloadSpeed = r7;
        r7 = r1.mLimitConnectTime;
        r7 = r7 * r25;
        r3 = (r35 > r7 ? 1 : (r35 == r7 ? 0 : -1));
        if (r3 <= 0) goto L_0x0663;
    L_0x0632:
        r3 = "cdn_connected_too_slow";
        r13.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "connected_time=";
        r3.append(r5);
        r10 = r35;
        r5 = (float) r10;
        r5 = r5 / r27;
        r3.append(r5);
        r5 = "s, connected_time_threshold=";
        r3.append(r5);
        r7 = r1.mLimitConnectTime;
        r3.append(r7);
        r5 = "s";
        r3.append(r5);
        r3 = r3.toString();
        r13.setExceptionReason(r3);
    L_0x065f:
        r19 = 1;
        goto L_0x0717;
    L_0x0663:
        r7 = r1.mLimitDownloadSpeed;
        r3 = (float) r7;
        r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1));
        if (r3 <= 0) goto L_0x0717;
    L_0x066a:
        r3 = "cdn_download_too_slow";
        r13.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "download_speed=";
        r3.append(r5);
        r5 = 1;
        r7 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r5);
        r3.append(r7);
        r5 = "KB/s, download_speed_threshold=";
        r3.append(r5);
        r7 = r1.mLimitDownloadSpeed;
        r3.append(r7);
        r5 = "KB/s";
        r3.append(r5);
        r3 = r3.toString();
        r13.setExceptionReason(r3);
        goto L_0x065f;
    L_0x0698:
        r10 = r35;
        r5 = 1;
        if (r3 != r5) goto L_0x0717;
    L_0x069d:
        r3 = r2.getCdnWifiConnectTimeout();
        r7 = (long) r3;
        r1.mLimitConnectTime = r7;
        r3 = r2.getCdnWifiAlertRate();
        r7 = (long) r3;
        r1.mLimitDownloadSpeed = r7;
        r7 = r1.mLimitConnectTime;
        r7 = r7 * r25;
        r3 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1));
        if (r3 <= 0) goto L_0x06df;
    L_0x06b3:
        r3 = "cdn_connected_too_slow";
        r13.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "connected_time=";
        r3.append(r5);
        r5 = (float) r10;
        r5 = r5 / r27;
        r3.append(r5);
        r5 = "s, connected_time_threshold=";
        r3.append(r5);
        r7 = r1.mLimitConnectTime;
        r3.append(r7);
        r5 = "s";
        r3.append(r5);
        r3 = r3.toString();
        r13.setExceptionReason(r3);
        goto L_0x065f;
    L_0x06df:
        r7 = r1.mLimitDownloadSpeed;
        r3 = (float) r7;
        r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1));
        if (r3 <= 0) goto L_0x0717;
    L_0x06e6:
        r3 = "cdn_download_too_slow";
        r13.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "download_speed=";
        r3.append(r5);
        r5 = 1;
        r7 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r5);
        r3.append(r7);
        r5 = "KB/s, download_speed_threshold=";
        r3.append(r5);
        r7 = r1.mLimitDownloadSpeed;
        r3.append(r7);
        r5 = "KB/s";
        r3.append(r5);
        r3 = r3.toString();
        r13.setExceptionReason(r3);
        goto L_0x065f;
    L_0x0715:
        r2 = r37;
    L_0x0717:
        if (r6 == 0) goto L_0x071f;
    L_0x0719:
        r6.disconnect();
        goto L_0x071f;
    L_0x071d:
        r2 = r37;
    L_0x071f:
        if (r13 == 0) goto L_0x073c;
    L_0x0721:
        if (r19 == 0) goto L_0x073c;
    L_0x0723:
        if (r30 != 0) goto L_0x073c;
    L_0x0725:
        r3 = r13.getErrorType();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x073c;
    L_0x072f:
        r3 = r13.getExceptionReason();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x073c;
    L_0x0739:
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r13, r2);
    L_0x073c:
        return r4;
    L_0x073d:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        goto L_0x026f;
    L_0x0744:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        goto L_0x0848;
    L_0x074b:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        goto L_0x084e;
    L_0x0752:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        goto L_0x0854;
    L_0x0759:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        goto L_0x085a;
    L_0x0760:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        goto L_0x0860;
    L_0x0767:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        goto L_0x0866;
    L_0x076e:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        goto L_0x086c;
    L_0x0775:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x026f;
    L_0x077e:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x0848;
    L_0x0787:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x084e;
    L_0x0790:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x0854;
    L_0x0799:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x085a;
    L_0x07a2:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x0860;
    L_0x07ab:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x0866;
    L_0x07b4:
        r0 = move-exception;
        r10 = r35;
        r2 = r37;
        r1 = r40;
        goto L_0x086c;
    L_0x07bd:
        r0 = move-exception;
        r10 = r35;
        goto L_0x026f;
    L_0x07c2:
        r0 = move-exception;
        r10 = r35;
        goto L_0x0848;
    L_0x07c7:
        r0 = move-exception;
        r10 = r35;
        goto L_0x084e;
    L_0x07cc:
        r0 = move-exception;
        r10 = r35;
        goto L_0x0854;
    L_0x07d1:
        r0 = move-exception;
        r10 = r35;
        goto L_0x085a;
    L_0x07d6:
        r0 = move-exception;
        r10 = r35;
        goto L_0x0860;
    L_0x07db:
        r0 = move-exception;
        r10 = r35;
        goto L_0x0866;
    L_0x07e0:
        r0 = move-exception;
        r10 = r35;
        goto L_0x086c;
    L_0x07e5:
        r0 = move-exception;
        r3 = r0;
        r22 = r7;
        r16 = r10;
        r14 = r34;
        goto L_0x027a;
    L_0x07ef:
        r0 = move-exception;
        r3 = r0;
        r22 = r7;
        r16 = r10;
        r14 = r34;
        goto L_0x0285;
    L_0x07f9:
        r0 = move-exception;
        r3 = r0;
        r22 = r7;
        r16 = r10;
        r14 = r34;
        goto L_0x0290;
    L_0x0803:
        r0 = move-exception;
        r3 = r0;
        r22 = r7;
        r16 = r10;
        r14 = r34;
        goto L_0x029d;
    L_0x080d:
        r0 = move-exception;
        r3 = r0;
        r22 = r7;
        r16 = r10;
        r14 = r34;
        goto L_0x02aa;
    L_0x0817:
        r0 = move-exception;
        r3 = r0;
        r22 = r7;
        r16 = r10;
        r14 = r34;
        goto L_0x02b7;
    L_0x0821:
        r0 = move-exception;
        r3 = r0;
        r22 = r7;
        r16 = r10;
        r14 = r34;
        goto L_0x02c4;
    L_0x082b:
        r0 = move-exception;
        r34 = r14;
        goto L_0x0848;
    L_0x082f:
        r0 = move-exception;
        r34 = r14;
        goto L_0x084e;
    L_0x0833:
        r0 = move-exception;
        r34 = r14;
        goto L_0x0854;
    L_0x0837:
        r0 = move-exception;
        r34 = r14;
        goto L_0x085a;
    L_0x083b:
        r0 = move-exception;
        r34 = r14;
        goto L_0x0860;
    L_0x083f:
        r0 = move-exception;
        r34 = r14;
        goto L_0x0866;
    L_0x0843:
        r0 = move-exception;
        r34 = r14;
        goto L_0x086c;
    L_0x0847:
        r0 = move-exception;
    L_0x0848:
        r3 = r0;
        r22 = r7;
        goto L_0x0278;
    L_0x084d:
        r0 = move-exception;
    L_0x084e:
        r3 = r0;
        r22 = r7;
        goto L_0x0283;
    L_0x0853:
        r0 = move-exception;
    L_0x0854:
        r3 = r0;
        r22 = r7;
        goto L_0x028e;
    L_0x0859:
        r0 = move-exception;
    L_0x085a:
        r3 = r0;
        r22 = r7;
        goto L_0x029b;
    L_0x085f:
        r0 = move-exception;
    L_0x0860:
        r3 = r0;
        r22 = r7;
        goto L_0x02a8;
    L_0x0865:
        r0 = move-exception;
    L_0x0866:
        r3 = r0;
        r22 = r7;
        goto L_0x02b5;
    L_0x086b:
        r0 = move-exception;
    L_0x086c:
        r3 = r0;
        r22 = r7;
        goto L_0x02c2;
    L_0x0871:
        r0 = move-exception;
        goto L_0x026f;
    L_0x0874:
        r0 = move-exception;
        r33 = r8;
    L_0x0877:
        r3 = r0;
        goto L_0x0278;
    L_0x087a:
        r0 = move-exception;
        r33 = r8;
    L_0x087d:
        r3 = r0;
        goto L_0x0283;
    L_0x0880:
        r0 = move-exception;
        r33 = r8;
    L_0x0883:
        r3 = r0;
        goto L_0x028e;
    L_0x0886:
        r0 = move-exception;
        r33 = r8;
    L_0x0889:
        r3 = r0;
        goto L_0x029b;
    L_0x088c:
        r0 = move-exception;
        r33 = r8;
    L_0x088f:
        r3 = r0;
        goto L_0x02a8;
    L_0x0892:
        r0 = move-exception;
        r33 = r8;
    L_0x0895:
        r3 = r0;
        goto L_0x02b5;
    L_0x0898:
        r0 = move-exception;
        r33 = r8;
    L_0x089b:
        r3 = r0;
        goto L_0x02c2;
    L_0x089e:
        r0 = move-exception;
        goto L_0x08b2;
    L_0x08a0:
        r0 = move-exception;
        goto L_0x08bd;
    L_0x08a2:
        r0 = move-exception;
        goto L_0x08c6;
    L_0x08a4:
        r0 = move-exception;
        goto L_0x08cf;
    L_0x08a6:
        r0 = move-exception;
        goto L_0x08da;
    L_0x08a8:
        r0 = move-exception;
        goto L_0x08e5;
    L_0x08aa:
        r0 = move-exception;
        goto L_0x08f0;
    L_0x08ac:
        r0 = move-exception;
        goto L_0x08fb;
    L_0x08af:
        r0 = move-exception;
        r30 = r6;
    L_0x08b2:
        r6 = r11;
        r3 = r0;
    L_0x08b4:
        r10 = r16;
    L_0x08b6:
        r5 = r19;
        goto L_0x0fad;
    L_0x08ba:
        r0 = move-exception;
        r30 = r6;
    L_0x08bd:
        r33 = r8;
        r6 = r11;
        r3 = r0;
        goto L_0x0958;
    L_0x08c3:
        r0 = move-exception;
        r30 = r6;
    L_0x08c6:
        r33 = r8;
        r6 = r11;
        r3 = r0;
        goto L_0x0a5e;
    L_0x08cc:
        r0 = move-exception;
        r30 = r6;
    L_0x08cf:
        r33 = r8;
        r6 = r11;
        r3 = r0;
    L_0x08d3:
        r4 = 0;
        goto L_0x0ba7;
    L_0x08d7:
        r0 = move-exception;
        r30 = r6;
    L_0x08da:
        r33 = r8;
        r6 = r11;
        r3 = r0;
    L_0x08de:
        r4 = 0;
        goto L_0x0c68;
    L_0x08e2:
        r0 = move-exception;
        r30 = r6;
    L_0x08e5:
        r33 = r8;
        r6 = r11;
        r3 = r0;
    L_0x08e9:
        r4 = 0;
        goto L_0x0d29;
    L_0x08ed:
        r0 = move-exception;
        r30 = r6;
    L_0x08f0:
        r33 = r8;
        r6 = r11;
        r3 = r0;
    L_0x08f4:
        r4 = 0;
        goto L_0x0df4;
    L_0x08f8:
        r0 = move-exception;
        r30 = r6;
    L_0x08fb:
        r33 = r8;
        r6 = r11;
        r3 = r0;
    L_0x08ff:
        r4 = 0;
        goto L_0x0ed0;
    L_0x0903:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r3 = r0;
        goto L_0x0957;
    L_0x090a:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r3 = r0;
        goto L_0x0a5d;
    L_0x0912:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r3 = r0;
    L_0x0918:
        r4 = 0;
        goto L_0x0ba6;
    L_0x091c:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r3 = r0;
    L_0x0922:
        r4 = 0;
        goto L_0x0c67;
    L_0x0926:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r3 = r0;
    L_0x092c:
        r4 = 0;
        goto L_0x0d28;
    L_0x0930:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r3 = r0;
    L_0x0936:
        r4 = 0;
        goto L_0x0df3;
    L_0x093a:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r3 = r0;
    L_0x0940:
        r4 = 0;
        goto L_0x0ecf;
    L_0x0944:
        r0 = move-exception;
        r30 = r6;
        r3 = r0;
    L_0x0948:
        r10 = r16;
        r5 = r19;
        r6 = 0;
        goto L_0x0fad;
    L_0x094f:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r3 = r0;
        r28 = r20;
    L_0x0957:
        r11 = 0;
    L_0x0958:
        if (r30 != 0) goto L_0x09f7;
    L_0x095a:
        if (r13 == 0) goto L_0x09f7;
    L_0x095c:
        r4 = r13.getDownloadSpeed();	 Catch:{ all -> 0x0fa5 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0fa5 }
        if (r4 == 0) goto L_0x09bf;
    L_0x0966:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0fa5 }
        r6 = r4 - r22;
        r4 = 0;
        r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r8 == 0) goto L_0x097e;
    L_0x0972:
        r4 = (float) r14;	 Catch:{ all -> 0x0fa5 }
        r5 = 0;
        r4 = r4 + r5;
        r8 = 1149239296; // 0x44800000 float:1024.0 double:5.67799655E-315;
        r4 = r4 / r8;
        r8 = (float) r6;	 Catch:{ all -> 0x0fa5 }
        r8 = r8 + r5;
        r8 = r8 / r27;
        r4 = r4 / r8;
        r15 = r4;
    L_0x097e:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r4.<init>();	 Catch:{ all -> 0x0fa5 }
        r5 = 1;
        r8 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r5);	 Catch:{ all -> 0x0fa5 }
        r4.append(r8);	 Catch:{ all -> 0x0fa5 }
        r5 = "";
        r4.append(r5);	 Catch:{ all -> 0x0fa5 }
        r4 = r4.toString();	 Catch:{ all -> 0x0fa5 }
        r13.setDownloadSpeed(r4);	 Catch:{ all -> 0x0fa5 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r4.<init>();	 Catch:{ all -> 0x0fa5 }
        r4.append(r14);	 Catch:{ all -> 0x0fa5 }
        r5 = "";
        r4.append(r5);	 Catch:{ all -> 0x0fa5 }
        r4 = r4.toString();	 Catch:{ all -> 0x0fa5 }
        r13.setDownloaded(r4);	 Catch:{ all -> 0x0fa5 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r4.<init>();	 Catch:{ all -> 0x0fa5 }
        r4.append(r6);	 Catch:{ all -> 0x0fa5 }
        r5 = "";
        r4.append(r5);	 Catch:{ all -> 0x0fa5 }
        r4 = r4.toString();	 Catch:{ all -> 0x0fa5 }
        r13.setDownloadTime(r4);	 Catch:{ all -> 0x0fa5 }
    L_0x09bf:
        r4 = r13.getConnectedTime();	 Catch:{ all -> 0x0fa5 }
        r5 = 0;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 > 0) goto L_0x09e6;
    L_0x09c8:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0fa5 }
        r6 = r4 - r28;
        r4 = (float) r6;
        r5 = 0;
        r4 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r4, r5);	 Catch:{ all -> 0x09da }
        r13.setConnectedTime(r4);	 Catch:{ all -> 0x09da }
        r16 = r6;
        goto L_0x09e6;
    L_0x09da:
        r0 = move-exception;
        r3 = r0;
        r5 = 1;
        r18 = 1;
        r38 = r6;
        r6 = r11;
        r10 = r38;
        goto L_0x0fad;
    L_0x09e6:
        r4 = "failed";
        r13.setDownloaded(r4);	 Catch:{ all -> 0x0fa5 }
        r4 = "cdn_unknown_exception";
        r13.setErrorType(r4);	 Catch:{ all -> 0x0fa5 }
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3);	 Catch:{ all -> 0x0fa5 }
        r13.setExceptionReason(r3);	 Catch:{ all -> 0x0fa5 }
    L_0x09f7:
        if (r30 != 0) goto L_0x0a3b;
    L_0x09f9:
        if (r13 == 0) goto L_0x0a3b;
    L_0x09fb:
        r3 = r13.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0a09;
    L_0x0a05:
        r3 = 0;
        r13.setViaInfo(r3);
    L_0x0a09:
        r3 = r13.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0a18;
    L_0x0a13:
        r3 = "";
        r13.setStatusCode(r3);
    L_0x0a18:
        r3 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r3);
        r3 = r13.getDownloadResult();
        if (r3 == 0) goto L_0x0a31;
    L_0x0a25:
        r3 = r13.getDownloadResult();
        r4 = "success";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x0a36;
    L_0x0a31:
        r3 = "failed";
        r13.setDownloadResult(r3);
    L_0x0a36:
        if (r11 == 0) goto L_0x0a3b;
    L_0x0a38:
        r11.disconnect();
    L_0x0a3b:
        if (r13 == 0) goto L_0x0ebf;
    L_0x0a3d:
        if (r30 != 0) goto L_0x0ebf;
    L_0x0a3f:
        r3 = r13.getErrorType();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0a49:
        r3 = r13.getExceptionReason();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0a53:
        goto L_0x0ebc;
    L_0x0a55:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r3 = r0;
        r28 = r20;
    L_0x0a5d:
        r11 = 0;
    L_0x0a5e:
        if (r30 != 0) goto L_0x0b22;
    L_0x0a60:
        if (r13 == 0) goto L_0x0b22;
    L_0x0a62:
        r4 = r13.getDownloadSpeed();	 Catch:{ all -> 0x0fa5 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0fa5 }
        if (r4 == 0) goto L_0x0ac6;
    L_0x0a6c:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0fa5 }
        r6 = r4 - r22;
        r4 = 0;
        r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r8 == 0) goto L_0x0a84;
    L_0x0a78:
        r8 = (float) r14;	 Catch:{ all -> 0x0fa5 }
        r9 = 0;
        r8 = r8 + r9;
        r10 = 1149239296; // 0x44800000 float:1024.0 double:5.67799655E-315;
        r8 = r8 / r10;
        r10 = (float) r6;	 Catch:{ all -> 0x0fa5 }
        r10 = r10 + r9;
        r10 = r10 / r27;
        r8 = r8 / r10;
        r15 = r8;
    L_0x0a84:
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r8.<init>();	 Catch:{ all -> 0x0fa5 }
        r9 = 1;
        r10 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r9);	 Catch:{ all -> 0x0fa5 }
        r8.append(r10);	 Catch:{ all -> 0x0fa5 }
        r9 = "";
        r8.append(r9);	 Catch:{ all -> 0x0fa5 }
        r8 = r8.toString();	 Catch:{ all -> 0x0fa5 }
        r13.setDownloadSpeed(r8);	 Catch:{ all -> 0x0fa5 }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r8.<init>();	 Catch:{ all -> 0x0fa5 }
        r8.append(r14);	 Catch:{ all -> 0x0fa5 }
        r9 = "";
        r8.append(r9);	 Catch:{ all -> 0x0fa5 }
        r8 = r8.toString();	 Catch:{ all -> 0x0fa5 }
        r13.setDownloaded(r8);	 Catch:{ all -> 0x0fa5 }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r8.<init>();	 Catch:{ all -> 0x0fa5 }
        r8.append(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "";
        r8.append(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = r8.toString();	 Catch:{ all -> 0x0fa5 }
        r13.setDownloadTime(r6);	 Catch:{ all -> 0x0fa5 }
        goto L_0x0ac8;
    L_0x0ac6:
        r4 = 0;
    L_0x0ac8:
        r6 = r13.getConnectedTime();	 Catch:{ all -> 0x0fa5 }
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 > 0) goto L_0x0ae2;
    L_0x0ad1:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0fa5 }
        r8 = r6 - r28;
        r6 = (float) r8;
        r7 = 0;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r6, r7);	 Catch:{ all -> 0x0d48 }
        r13.setConnectedTime(r6);	 Catch:{ all -> 0x0d48 }
        r16 = r8;
    L_0x0ae2:
        r6 = r3.getMessage();	 Catch:{ all -> 0x0fa5 }
        if (r6 == 0) goto L_0x0b10;
    L_0x0ae8:
        r6 = r3.getMessage();	 Catch:{ all -> 0x0fa5 }
        r7 = "ENOSPC";
        r6 = r6.contains(r7);	 Catch:{ all -> 0x0fa5 }
        if (r6 != 0) goto L_0x0b00;
    L_0x0af4:
        r6 = r3.getMessage();	 Catch:{ all -> 0x0fa5 }
        r7 = "EACCES";
        r6 = r6.contains(r7);	 Catch:{ all -> 0x0fa5 }
        if (r6 == 0) goto L_0x0b10;
    L_0x0b00:
        r6 = "0";
        r13.setDownloaded(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "0";
        r13.setDownloadTime(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "system_exception";
        r13.setErrorType(r6);	 Catch:{ all -> 0x0fa5 }
        goto L_0x0b15;
    L_0x0b10:
        r6 = "cdn_io_exception";
        r13.setErrorType(r6);	 Catch:{ all -> 0x0fa5 }
    L_0x0b15:
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3);	 Catch:{ all -> 0x0fa5 }
        r13.setExceptionReason(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "failed";
        r13.setDownloadResult(r6);	 Catch:{ all -> 0x0fa5 }
        goto L_0x0b24;
    L_0x0b22:
        r4 = 0;
    L_0x0b24:
        r6 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x0fa5 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r7.<init>();	 Catch:{ all -> 0x0fa5 }
        r8 = "DownloadThread IOException:";
        r7.append(r8);	 Catch:{ all -> 0x0fa5 }
        r3 = r3.toString();	 Catch:{ all -> 0x0fa5 }
        r7.append(r3);	 Catch:{ all -> 0x0fa5 }
        r3 = r7.toString();	 Catch:{ all -> 0x0fa5 }
        com.ximalaya.ting.android.player.Logger.log(r6, r3);	 Catch:{ all -> 0x0fa5 }
        if (r30 != 0) goto L_0x0b82;
    L_0x0b40:
        if (r13 == 0) goto L_0x0b82;
    L_0x0b42:
        r3 = r13.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0b50;
    L_0x0b4c:
        r3 = 0;
        r13.setViaInfo(r3);
    L_0x0b50:
        r3 = r13.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0b5f;
    L_0x0b5a:
        r3 = "";
        r13.setStatusCode(r3);
    L_0x0b5f:
        r6 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r6);
        r3 = r13.getDownloadResult();
        if (r3 == 0) goto L_0x0b78;
    L_0x0b6c:
        r3 = r13.getDownloadResult();
        r6 = "success";
        r3 = r3.contains(r6);
        if (r3 != 0) goto L_0x0b7d;
    L_0x0b78:
        r3 = "failed";
        r13.setDownloadResult(r3);
    L_0x0b7d:
        if (r11 == 0) goto L_0x0b82;
    L_0x0b7f:
        r11.disconnect();
    L_0x0b82:
        if (r13 == 0) goto L_0x0ebf;
    L_0x0b84:
        if (r30 != 0) goto L_0x0ebf;
    L_0x0b86:
        r3 = r13.getErrorType();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0b90:
        r3 = r13.getExceptionReason();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0b9a:
        goto L_0x0ebc;
    L_0x0b9c:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r4 = 0;
        r3 = r0;
        r28 = r20;
    L_0x0ba6:
        r11 = 0;
    L_0x0ba7:
        if (r30 != 0) goto L_0x0be5;
    L_0x0ba9:
        if (r13 == 0) goto L_0x0be5;
    L_0x0bab:
        r6 = r13.getConnectedTime();	 Catch:{ all -> 0x0fa5 }
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 > 0) goto L_0x0bc5;
    L_0x0bb4:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0fa5 }
        r8 = r6 - r28;
        r6 = (float) r8;
        r7 = 0;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r6, r7);	 Catch:{ all -> 0x0d48 }
        r13.setConnectedTime(r6);	 Catch:{ all -> 0x0d48 }
        r16 = r8;
    L_0x0bc5:
        r6 = "system_exception";
        r13.setErrorType(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3);	 Catch:{ all -> 0x0fa5 }
        r13.setExceptionReason(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "0.0";
        r13.setDownloadSpeed(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "0";
        r13.setDownloaded(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "0";
        r13.setDownloadTime(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "failed";
        r13.setDownloadResult(r6);	 Catch:{ all -> 0x0fa5 }
    L_0x0be5:
        r6 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x0fa5 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r7.<init>();	 Catch:{ all -> 0x0fa5 }
        r8 = "DownloadThread IOException:";
        r7.append(r8);	 Catch:{ all -> 0x0fa5 }
        r3 = r3.toString();	 Catch:{ all -> 0x0fa5 }
        r7.append(r3);	 Catch:{ all -> 0x0fa5 }
        r3 = r7.toString();	 Catch:{ all -> 0x0fa5 }
        com.ximalaya.ting.android.player.Logger.log(r6, r3);	 Catch:{ all -> 0x0fa5 }
        if (r30 != 0) goto L_0x0c43;
    L_0x0c01:
        if (r13 == 0) goto L_0x0c43;
    L_0x0c03:
        r3 = r13.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0c11;
    L_0x0c0d:
        r3 = 0;
        r13.setViaInfo(r3);
    L_0x0c11:
        r3 = r13.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0c20;
    L_0x0c1b:
        r3 = "";
        r13.setStatusCode(r3);
    L_0x0c20:
        r6 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r6);
        r3 = r13.getDownloadResult();
        if (r3 == 0) goto L_0x0c39;
    L_0x0c2d:
        r3 = r13.getDownloadResult();
        r6 = "success";
        r3 = r3.contains(r6);
        if (r3 != 0) goto L_0x0c3e;
    L_0x0c39:
        r3 = "failed";
        r13.setDownloadResult(r3);
    L_0x0c3e:
        if (r11 == 0) goto L_0x0c43;
    L_0x0c40:
        r11.disconnect();
    L_0x0c43:
        if (r13 == 0) goto L_0x0ebf;
    L_0x0c45:
        if (r30 != 0) goto L_0x0ebf;
    L_0x0c47:
        r3 = r13.getErrorType();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0c51:
        r3 = r13.getExceptionReason();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0c5b:
        goto L_0x0ebc;
    L_0x0c5d:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r4 = 0;
        r3 = r0;
        r28 = r20;
    L_0x0c67:
        r11 = 0;
    L_0x0c68:
        if (r30 != 0) goto L_0x0ca6;
    L_0x0c6a:
        if (r13 == 0) goto L_0x0ca6;
    L_0x0c6c:
        r6 = r13.getConnectedTime();	 Catch:{ all -> 0x0fa5 }
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 > 0) goto L_0x0c86;
    L_0x0c75:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0fa5 }
        r8 = r6 - r28;
        r6 = (float) r8;
        r7 = 0;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r6, r7);	 Catch:{ all -> 0x0d48 }
        r13.setConnectedTime(r6);	 Catch:{ all -> 0x0d48 }
        r16 = r8;
    L_0x0c86:
        r6 = "dns_fail";
        r13.setErrorType(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3);	 Catch:{ all -> 0x0fa5 }
        r13.setExceptionReason(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "0.0";
        r13.setDownloadSpeed(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "0";
        r13.setDownloaded(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "0";
        r13.setDownloadTime(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "failed";
        r13.setDownloadResult(r6);	 Catch:{ all -> 0x0fa5 }
    L_0x0ca6:
        r6 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x0fa5 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r7.<init>();	 Catch:{ all -> 0x0fa5 }
        r8 = "DownloadThread IOException:";
        r7.append(r8);	 Catch:{ all -> 0x0fa5 }
        r3 = r3.toString();	 Catch:{ all -> 0x0fa5 }
        r7.append(r3);	 Catch:{ all -> 0x0fa5 }
        r3 = r7.toString();	 Catch:{ all -> 0x0fa5 }
        com.ximalaya.ting.android.player.Logger.log(r6, r3);	 Catch:{ all -> 0x0fa5 }
        if (r30 != 0) goto L_0x0d04;
    L_0x0cc2:
        if (r13 == 0) goto L_0x0d04;
    L_0x0cc4:
        r3 = r13.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0cd2;
    L_0x0cce:
        r3 = 0;
        r13.setViaInfo(r3);
    L_0x0cd2:
        r3 = r13.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0ce1;
    L_0x0cdc:
        r3 = "";
        r13.setStatusCode(r3);
    L_0x0ce1:
        r6 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r6);
        r3 = r13.getDownloadResult();
        if (r3 == 0) goto L_0x0cfa;
    L_0x0cee:
        r3 = r13.getDownloadResult();
        r6 = "success";
        r3 = r3.contains(r6);
        if (r3 != 0) goto L_0x0cff;
    L_0x0cfa:
        r3 = "failed";
        r13.setDownloadResult(r3);
    L_0x0cff:
        if (r11 == 0) goto L_0x0d04;
    L_0x0d01:
        r11.disconnect();
    L_0x0d04:
        if (r13 == 0) goto L_0x0ebf;
    L_0x0d06:
        if (r30 != 0) goto L_0x0ebf;
    L_0x0d08:
        r3 = r13.getErrorType();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0d12:
        r3 = r13.getExceptionReason();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0d1c:
        goto L_0x0ebc;
    L_0x0d1e:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r4 = 0;
        r3 = r0;
        r28 = r20;
    L_0x0d28:
        r11 = 0;
    L_0x0d29:
        if (r30 != 0) goto L_0x0d71;
    L_0x0d2b:
        if (r13 == 0) goto L_0x0d71;
    L_0x0d2d:
        r6 = r13.getConnectedTime();	 Catch:{ all -> 0x0fa5 }
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 > 0) goto L_0x0d51;
    L_0x0d36:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0fa5 }
        r8 = r6 - r28;
        r6 = (float) r8;
        r7 = 0;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r6, r7);	 Catch:{ all -> 0x0d48 }
        r13.setConnectedTime(r6);	 Catch:{ all -> 0x0d48 }
        r16 = r8;
        goto L_0x0d51;
    L_0x0d48:
        r0 = move-exception;
        r3 = r0;
        r6 = r11;
        r5 = 1;
        r18 = 1;
        r10 = r8;
        goto L_0x0fad;
    L_0x0d51:
        r6 = "dns_fail";
        r13.setErrorType(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3);	 Catch:{ all -> 0x0fa5 }
        r13.setExceptionReason(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "0.0";
        r13.setDownloadSpeed(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "0";
        r13.setDownloaded(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "0";
        r13.setDownloadTime(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = "failed";
        r13.setDownloadResult(r6);	 Catch:{ all -> 0x0fa5 }
    L_0x0d71:
        r6 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x0fa5 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r7.<init>();	 Catch:{ all -> 0x0fa5 }
        r8 = "DownloadThread IOException:";
        r7.append(r8);	 Catch:{ all -> 0x0fa5 }
        r3 = r3.toString();	 Catch:{ all -> 0x0fa5 }
        r7.append(r3);	 Catch:{ all -> 0x0fa5 }
        r3 = r7.toString();	 Catch:{ all -> 0x0fa5 }
        com.ximalaya.ting.android.player.Logger.log(r6, r3);	 Catch:{ all -> 0x0fa5 }
        if (r30 != 0) goto L_0x0dcf;
    L_0x0d8d:
        if (r13 == 0) goto L_0x0dcf;
    L_0x0d8f:
        r3 = r13.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0d9d;
    L_0x0d99:
        r3 = 0;
        r13.setViaInfo(r3);
    L_0x0d9d:
        r3 = r13.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0dac;
    L_0x0da7:
        r3 = "";
        r13.setStatusCode(r3);
    L_0x0dac:
        r6 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r6);
        r3 = r13.getDownloadResult();
        if (r3 == 0) goto L_0x0dc5;
    L_0x0db9:
        r3 = r13.getDownloadResult();
        r6 = "success";
        r3 = r3.contains(r6);
        if (r3 != 0) goto L_0x0dca;
    L_0x0dc5:
        r3 = "failed";
        r13.setDownloadResult(r3);
    L_0x0dca:
        if (r11 == 0) goto L_0x0dcf;
    L_0x0dcc:
        r11.disconnect();
    L_0x0dcf:
        if (r13 == 0) goto L_0x0ebf;
    L_0x0dd1:
        if (r30 != 0) goto L_0x0ebf;
    L_0x0dd3:
        r3 = r13.getErrorType();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0ddd:
        r3 = r13.getExceptionReason();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0de7:
        goto L_0x0ebc;
    L_0x0de9:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r4 = 0;
        r3 = r0;
        r28 = r20;
    L_0x0df3:
        r11 = 0;
    L_0x0df4:
        if (r30 != 0) goto L_0x0e60;
    L_0x0df6:
        if (r13 == 0) goto L_0x0e60;
    L_0x0df8:
        r6 = "0.0";
        r13.setDownloadSpeed(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = r13.getConnectedTime();	 Catch:{ all -> 0x0fa5 }
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 > 0) goto L_0x0e17;
    L_0x0e06:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0fa5 }
        r8 = r6 - r28;
        r6 = (float) r8;
        r7 = 0;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r6, r7);	 Catch:{ all -> 0x0d48 }
        r13.setConnectedTime(r6);	 Catch:{ all -> 0x0d48 }
        r16 = r8;
    L_0x0e17:
        r6 = r3.getMessage();	 Catch:{ all -> 0x0fa5 }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0fa5 }
        if (r6 == 0) goto L_0x0e41;
    L_0x0e21:
        r6 = "cdn_socket_timeout";
        r13.setErrorType(r6);	 Catch:{ all -> 0x0fa5 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r6.<init>();	 Catch:{ all -> 0x0fa5 }
        r7 = java.lang.String.valueOf(r3);	 Catch:{ all -> 0x0fa5 }
        r6.append(r7);	 Catch:{ all -> 0x0fa5 }
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3);	 Catch:{ all -> 0x0fa5 }
        r6.append(r3);	 Catch:{ all -> 0x0fa5 }
        r3 = r6.toString();	 Catch:{ all -> 0x0fa5 }
        r13.setExceptionReason(r3);	 Catch:{ all -> 0x0fa5 }
        goto L_0x0e4d;
    L_0x0e41:
        r6 = "cdn_connect_timeout";
        r13.setErrorType(r6);	 Catch:{ all -> 0x0fa5 }
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3);	 Catch:{ all -> 0x0fa5 }
        r13.setExceptionReason(r3);	 Catch:{ all -> 0x0fa5 }
    L_0x0e4d:
        r3 = "0";
        r13.setDownloaded(r3);	 Catch:{ all -> 0x0fa5 }
        r3 = "0";
        r13.setDownloadTime(r3);	 Catch:{ all -> 0x0fa5 }
        r3 = "failed";
        r13.setDownloadResult(r3);	 Catch:{ all -> 0x0fa5 }
        r3 = 1;
        r13.setTimeout(r3);	 Catch:{ all -> 0x0fa5 }
    L_0x0e60:
        if (r30 != 0) goto L_0x0ea4;
    L_0x0e62:
        if (r13 == 0) goto L_0x0ea4;
    L_0x0e64:
        r3 = r13.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0e72;
    L_0x0e6e:
        r3 = 0;
        r13.setViaInfo(r3);
    L_0x0e72:
        r3 = r13.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0e81;
    L_0x0e7c:
        r3 = "";
        r13.setStatusCode(r3);
    L_0x0e81:
        r6 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r6);
        r3 = r13.getDownloadResult();
        if (r3 == 0) goto L_0x0e9a;
    L_0x0e8e:
        r3 = r13.getDownloadResult();
        r6 = "success";
        r3 = r3.contains(r6);
        if (r3 != 0) goto L_0x0e9f;
    L_0x0e9a:
        r3 = "failed";
        r13.setDownloadResult(r3);
    L_0x0e9f:
        if (r11 == 0) goto L_0x0ea4;
    L_0x0ea1:
        r11.disconnect();
    L_0x0ea4:
        if (r13 == 0) goto L_0x0ebf;
    L_0x0ea6:
        if (r30 != 0) goto L_0x0ebf;
    L_0x0ea8:
        r3 = r13.getErrorType();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0eb2:
        r3 = r13.getExceptionReason();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0ebf;
    L_0x0ebc:
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r13, r2);
    L_0x0ebf:
        r20 = r28;
        r7 = 0;
        r8 = 0;
        goto L_0x0f97;
    L_0x0ec5:
        r0 = move-exception;
        r30 = r6;
        r33 = r8;
        r4 = 0;
        r3 = r0;
        r28 = r20;
    L_0x0ecf:
        r11 = 0;
    L_0x0ed0:
        if (r30 != 0) goto L_0x0f1a;
    L_0x0ed2:
        if (r13 == 0) goto L_0x0f1a;
    L_0x0ed4:
        r6 = r13.getConnectedTime();	 Catch:{ all -> 0x0fa5 }
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 > 0) goto L_0x0ef8;
    L_0x0edd:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0fa5 }
        r4 = r8 - r28;
        r6 = (float) r4;
        r8 = 0;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r6, r8);	 Catch:{ all -> 0x0eef }
        r13.setConnectedTime(r6);	 Catch:{ all -> 0x0eef }
        r16 = r4;
        goto L_0x0ef9;
    L_0x0eef:
        r0 = move-exception;
        r3 = r0;
        r6 = r11;
        r18 = 1;
        r10 = r4;
        r5 = 1;
        goto L_0x0fad;
    L_0x0ef8:
        r8 = 0;
    L_0x0ef9:
        r4 = "cdn_connect_fail ";
        r13.setErrorType(r4);	 Catch:{ all -> 0x0fa5 }
        r4 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3);	 Catch:{ all -> 0x0fa5 }
        r13.setExceptionReason(r4);	 Catch:{ all -> 0x0fa5 }
        r4 = "0.0";
        r13.setDownloadSpeed(r4);	 Catch:{ all -> 0x0fa5 }
        r4 = "0";
        r13.setDownloaded(r4);	 Catch:{ all -> 0x0fa5 }
        r4 = "0";
        r13.setDownloadTime(r4);	 Catch:{ all -> 0x0fa5 }
        r4 = "failed";
        r13.setDownloadResult(r4);	 Catch:{ all -> 0x0fa5 }
        goto L_0x0f1c;
    L_0x0f1a:
        r7 = 0;
        r8 = 0;
    L_0x0f1c:
        r4 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x0fa5 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0fa5 }
        r5.<init>();	 Catch:{ all -> 0x0fa5 }
        r6 = "DownloadThread MalformedURLException:";
        r5.append(r6);	 Catch:{ all -> 0x0fa5 }
        r3 = r3.toString();	 Catch:{ all -> 0x0fa5 }
        r5.append(r3);	 Catch:{ all -> 0x0fa5 }
        r3 = r5.toString();	 Catch:{ all -> 0x0fa5 }
        com.ximalaya.ting.android.player.Logger.log(r4, r3);	 Catch:{ all -> 0x0fa5 }
        if (r30 != 0) goto L_0x0f7a;
    L_0x0f38:
        if (r13 == 0) goto L_0x0f7a;
    L_0x0f3a:
        r3 = r13.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0f48;
    L_0x0f44:
        r3 = 0;
        r13.setViaInfo(r3);
    L_0x0f48:
        r3 = r13.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0f57;
    L_0x0f52:
        r3 = "";
        r13.setStatusCode(r3);
    L_0x0f57:
        r3 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r3);
        r3 = r13.getDownloadResult();
        if (r3 == 0) goto L_0x0f70;
    L_0x0f64:
        r3 = r13.getDownloadResult();
        r4 = "success";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x0f75;
    L_0x0f70:
        r3 = "failed";
        r13.setDownloadResult(r3);
    L_0x0f75:
        if (r11 == 0) goto L_0x0f7a;
    L_0x0f77:
        r11.disconnect();
    L_0x0f7a:
        if (r13 == 0) goto L_0x0f95;
    L_0x0f7c:
        if (r30 != 0) goto L_0x0f95;
    L_0x0f7e:
        r3 = r13.getErrorType();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0f95;
    L_0x0f88:
        r3 = r13.getExceptionReason();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0f95;
    L_0x0f92:
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r13, r2);
    L_0x0f95:
        r20 = r28;
    L_0x0f97:
        r3 = r8;
        r7 = r24;
        r6 = r30;
        r8 = r33;
        r5 = 1;
        r18 = 1;
        r19 = 1;
        goto L_0x003d;
    L_0x0fa5:
        r0 = move-exception;
        r3 = r0;
        r6 = r11;
        r10 = r16;
        r5 = 1;
        r18 = 1;
    L_0x0fad:
        if (r30 != 0) goto L_0x10f2;
    L_0x0faf:
        if (r13 == 0) goto L_0x10f2;
    L_0x0fb1:
        r4 = r13.getViaInfo();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x0fbf;
    L_0x0fbb:
        r4 = 0;
        r13.setViaInfo(r4);
    L_0x0fbf:
        r4 = r13.getStatusCode();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x0fce;
    L_0x0fc9:
        r4 = "";
        r13.setStatusCode(r4);
    L_0x0fce:
        r7 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r7);
        r4 = r13.getDownloadResult();
        if (r4 == 0) goto L_0x0fe7;
    L_0x0fdb:
        r4 = r13.getDownloadResult();
        r7 = "success";
        r4 = r4.contains(r7);
        if (r4 != 0) goto L_0x0fec;
    L_0x0fe7:
        r4 = "failed";
        r13.setDownloadResult(r4);
    L_0x0fec:
        if (r18 != 0) goto L_0x10ed;
    L_0x0fee:
        r4 = r2.getNetType();
        r7 = -1;
        if (r4 != r7) goto L_0x0ff9;
    L_0x0ff5:
        r30 = 1;
        goto L_0x10ed;
    L_0x0ff9:
        if (r4 != 0) goto L_0x1074;
    L_0x0ffb:
        r4 = r2.getCdnNotWifiConnectTimeout();
        r7 = (long) r4;
        r1.mLimitConnectTime = r7;
        r4 = r2.getCdnNotWifiAlertRate();
        r7 = (long) r4;
        r1.mLimitDownloadSpeed = r7;
        r7 = r1.mLimitConnectTime;
        r7 = r7 * r25;
        r4 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1));
        if (r4 <= 0) goto L_0x103f;
    L_0x1011:
        r4 = "cdn_connected_too_slow";
        r13.setErrorType(r4);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "connected_time=";
        r4.append(r5);
        r5 = (float) r10;
        r5 = r5 / r27;
        r4.append(r5);
        r5 = "s, connected_time_threshold=";
        r4.append(r5);
        r7 = r1.mLimitConnectTime;
        r4.append(r7);
        r5 = "s";
        r4.append(r5);
        r4 = r4.toString();
        r13.setExceptionReason(r4);
    L_0x103c:
        r5 = 1;
        goto L_0x10ed;
    L_0x103f:
        r7 = r1.mLimitDownloadSpeed;
        r4 = (float) r7;
        r4 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1));
        if (r4 <= 0) goto L_0x10ed;
    L_0x1046:
        r4 = "cdn_download_too_slow";
        r13.setErrorType(r4);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "download_speed=";
        r4.append(r5);
        r5 = 1;
        r7 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r5);
        r4.append(r7);
        r5 = "KB/s, download_speed_threshold=";
        r4.append(r5);
        r7 = r1.mLimitDownloadSpeed;
        r4.append(r7);
        r5 = "KB/s";
        r4.append(r5);
        r4 = r4.toString();
        r13.setExceptionReason(r4);
        goto L_0x103c;
    L_0x1074:
        r7 = 1;
        if (r4 != r7) goto L_0x10ed;
    L_0x1077:
        r4 = r2.getCdnWifiConnectTimeout();
        r7 = (long) r4;
        r1.mLimitConnectTime = r7;
        r4 = r2.getCdnWifiAlertRate();
        r7 = (long) r4;
        r1.mLimitDownloadSpeed = r7;
        r7 = r1.mLimitConnectTime;
        r7 = r7 * r25;
        r4 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1));
        if (r4 <= 0) goto L_0x10b9;
    L_0x108d:
        r4 = "cdn_connected_too_slow";
        r13.setErrorType(r4);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "connected_time=";
        r4.append(r5);
        r5 = (float) r10;
        r5 = r5 / r27;
        r4.append(r5);
        r5 = "s, connected_time_threshold=";
        r4.append(r5);
        r7 = r1.mLimitConnectTime;
        r4.append(r7);
        r5 = "s";
        r4.append(r5);
        r4 = r4.toString();
        r13.setExceptionReason(r4);
        goto L_0x103c;
    L_0x10b9:
        r7 = r1.mLimitDownloadSpeed;
        r4 = (float) r7;
        r4 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1));
        if (r4 <= 0) goto L_0x10ed;
    L_0x10c0:
        r4 = "cdn_download_too_slow";
        r13.setErrorType(r4);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "download_speed=";
        r4.append(r5);
        r5 = 1;
        r7 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r5);
        r4.append(r7);
        r7 = "KB/s, download_speed_threshold=";
        r4.append(r7);
        r7 = r1.mLimitDownloadSpeed;
        r4.append(r7);
        r7 = "KB/s";
        r4.append(r7);
        r4 = r4.toString();
        r13.setExceptionReason(r4);
    L_0x10ed:
        if (r6 == 0) goto L_0x10f2;
    L_0x10ef:
        r6.disconnect();
    L_0x10f2:
        if (r13 == 0) goto L_0x110f;
    L_0x10f4:
        if (r5 == 0) goto L_0x110f;
    L_0x10f6:
        if (r30 != 0) goto L_0x110f;
    L_0x10f8:
        r4 = r13.getErrorType();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x110f;
    L_0x1102:
        r4 = r13.getExceptionReason();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x110f;
    L_0x110c:
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r13, r2);
    L_0x110f:
        throw r3;
    L_0x1110:
        r2 = -1;
        return r2;
    L_0x1112:
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.DownloadThread.download():int");
    }
}
