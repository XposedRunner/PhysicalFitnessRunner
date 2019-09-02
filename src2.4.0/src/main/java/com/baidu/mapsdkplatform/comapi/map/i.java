package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.a;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comjni.engine.AppEngine;
import com.baidu.mapsdkvi.VMsg;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class i {
    private static int a;
    private static Context b = BMapManager.getContext();

    static {
        if (VersionInfo.getApiVersion().equals(VersionInfo.getApiVersion())) {
            NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
            VMsg.InitClass(VMsg.getInstance());
            AppEngine.InitClass();
            a(BMapManager.getContext());
            SysUpdateObservable.getInstance().addObserver(new SysUpdateUtil());
            SysUpdateObservable.getInstance().init();
            return;
        }
        throw new BaiduMapSDKException("the version of map is not match with base");
    }

    public static void a() {
        if (a == 0) {
            if (b == null) {
                throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            VMsg.init();
            AppEngine.InitEngine(b);
            AppEngine.StartSocketProc();
            NetworkUtil.updateNetworkProxy(b);
        }
        a++;
    }

    private static void a(Context context) {
        Context context2 = context;
        if (context2 != null) {
            try {
                File file = new File(SysOSUtil.getModuleFileName());
                if (!file.exists()) {
                    file.mkdirs();
                }
                context.getAssets();
                r3 = new String[15];
                int i = 0;
                r3[0] = "cfg/a/mode_1/map.sdkrs";
                int i2 = 1;
                r3[1] = "cfg/a/mode_1/reduct.sdkrs";
                r3[2] = "cfg/a/mode_1/traffic.sdkrs";
                r3[3] = "cfg/a/mode_1/map.sty";
                r3[4] = "cfg/a/mode_1/reduct.sty";
                r3[5] = "cfg/a/mode_1/traffic.sty";
                r3[6] = "cfg/idrres/ResPackIndoorMap.sdkrs";
                r3[7] = "cfg/idrres/DVIndoor.cfg";
                r3[8] = "cfg/idrres/baseindoormap.sty";
                r3[9] = "cfg/a/DVDirectory.cfg";
                r3[10] = "cfg/a/DVHotcity.cfg";
                r3[11] = "cfg/a/DVHotMap.cfg";
                r3[12] = "cfg/a/DVSDirectory.cfg";
                r3[13] = "cfg/a/DVVersion.cfg";
                r3[14] = "cfg/a/CustomIndex";
                String[] strArr = new String[]{"cfg/a/CustomIndex"};
                String[] strArr2 = new String[]{"cfg/a/mode_1/map.rs", "cfg/a/mode_1/reduct.rs", "cfg/a/mode_1/traffic.rs", "cfg/a/mode_1/map.sty", "cfg/a/mode_1/reduct.sty", "cfg/a/mode_1/traffic.sty", "cfg/idrres/ResPackIndoorMap.rs", "cfg/idrres/DVIndoor.cfg", "cfg/idrres/baseindoormap.sty", "cfg/a/DVDirectory.cfg", "cfg/a/DVHotcity.cfg", "cfg/a/DVHotMap.cfg", "cfg/a/DVSDirectory.cfg", "cfg/a/DVVersion.cfg", "cfg/a/CustomIndex"};
                String[] strArr3 = new String[]{"cfg/a/CustomIndex"};
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(SysOSUtil.getModuleFileName());
                    stringBuilder.append("/ver.dat");
                    File file2 = new File(stringBuilder.toString());
                    byte[] bArr = new byte[]{(byte) 5, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
                    if (file2.exists()) {
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        byte[] bArr2 = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr2);
                        fileInputStream.close();
                        if (Arrays.equals(bArr2, bArr)) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(SysOSUtil.getModuleFileName());
                            stringBuilder2.append("/cfg/a/mode_1/map.sty");
                            File file3 = new File(stringBuilder2.toString());
                            if (file3.exists() && file3.length() > 0) {
                                i2 = 0;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        file2.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(SysOSUtil.getModuleFileName());
                        stringBuilder.append("/cfg/a/mode_1");
                        file2 = new File(stringBuilder.toString());
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(SysOSUtil.getModuleFileName());
                        stringBuilder.append("/cfg/idrres");
                        file2 = new File(stringBuilder.toString());
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                    }
                    for (int i3 = 0; i3 < strArr3.length; i3++) {
                        a.a(strArr[i3], strArr3[i3], context2);
                    }
                    if (i2 != 0) {
                        while (i < strArr2.length) {
                            a.a(r3[i], strArr2[i], context2);
                            i++;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(boolean z) {
        e.l(z);
    }

    public static void b() {
        a--;
        if (a == 0) {
            AppEngine.UnInitEngine();
            VMsg.destroy();
        }
    }
}
