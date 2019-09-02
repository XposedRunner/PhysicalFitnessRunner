package kr.co.namee.permissiongen;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.v4.app.Fragment;

public class PermissionGen {
    private String[] mPermissions;
    private int mRequestCode;
    private Object object;

    private PermissionGen(Object obj) {
    }

    private static void doExecuteFail(Object obj, int i) {
    }

    private static void doExecuteSuccess(Object obj, int i) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private static void executeMethod(java.lang.Object r1, java.lang.reflect.Method r2) {
        /*
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.namee.permissiongen.PermissionGen.executeMethod(java.lang.Object, java.lang.reflect.Method):void");
    }

    public static void needPermission(Activity activity, int i, String str) {
    }

    public static void needPermission(Activity activity, int i, String[] strArr) {
    }

    public static void needPermission(Fragment fragment, int i, String str) {
    }

    public static void needPermission(Fragment fragment, int i, String[] strArr) {
    }

    public static void onRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr) {
    }

    public static void onRequestPermissionsResult(Fragment fragment, int i, String[] strArr, int[] iArr) {
    }

    @TargetApi(23)
    private static void requestPermissions(Object obj, int i, String[] strArr) {
    }

    private static void requestResult(Object obj, int i, String[] strArr, int[] iArr) {
    }

    public static PermissionGen with(Activity activity) {
        return null;
    }

    public static PermissionGen with(Fragment fragment) {
        return null;
    }

    public PermissionGen addRequestCode(int i) {
        return null;
    }

    public PermissionGen permissions(String... strArr) {
        return null;
    }

    @TargetApi(23)
    public void request() {
    }
}
