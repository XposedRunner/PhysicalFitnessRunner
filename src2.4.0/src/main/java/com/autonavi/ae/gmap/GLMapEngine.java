package com.autonavi.ae.gmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import com.amap.api.mapcore.util.OOOo000;
import com.amap.api.mapcore.util.OOo000;
import com.amap.api.mapcore.util.ca;
import com.amap.api.mapcore.util.ooOOOOoo;
import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.ae.gmap.glanimation.AbstractAdglAnimation;
import com.autonavi.ae.gmap.glanimation.AdglMapAnimFling;
import com.autonavi.ae.gmap.glanimation.AdglMapAnimGroup;
import com.autonavi.ae.gmap.glanimation.AdglMapAnimationMgr;
import com.autonavi.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener;
import com.autonavi.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.ae.gmap.style.StyleItem;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.FileUtil;
import com.autonavi.amap.mapcore.IAMapEngineCallback;
import com.autonavi.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.amap.mapcore.maploader.AMapLoader;
import com.autonavi.amap.mapcore.maploader.AMapLoader.ADataRequestParam;
import com.autonavi.amap.mapcore.maploader.NetworkState;
import com.autonavi.amap.mapcore.maploader.NetworkState.NetworkChangeListener;
import com.autonavi.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.amap.mapcore.tools.GLConvertUtil;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.amap.mapcore.tools.TextTextureGenerator;
import java.io.File;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GLMapEngine implements IAMapEngineCallback, NetworkChangeListener {
    Hashtable<Long, AMapLoader> aMapLoaderHashtable;
    GLOverlayBundle<BaseMapOverlay<?, ?>> bundle;
    private Context context;
    private GLMapState copyGLMapState;
    private boolean isEngineRenderComplete;
    boolean isGestureStep;
    boolean isMoveCameraStep;
    private List<AbstractCameraUpdateMessage> mAnimateStateMessageList;
    private List<AbstractGestureMapMessage> mGestureEndMessageList;
    private List<AbstractGestureMapMessage> mGestureMessageList;
    private ca mGlMapView;
    private Lock mLock;
    private IAMapListener mMapListener;
    private long mNativeMapengineInstance;
    private NetworkState mNetworkState;
    boolean mRequestDestroy;
    private AtomicInteger mRequestID;
    private List<AbstractCameraUpdateMessage> mStateMessageList;
    private TextTextureGenerator mTextTextureGenerator;
    private AdglMapAnimationMgr mapAnimationMgr;
    private int mapGestureCount;
    private Object mutLock;
    GLMapState state;
    private String userAgent;

    public static class InitParam {
        public String mConfigContent;
        public String mConfigPath;
        public String mOfflineDataPath;
        public String mP3dCrossPath;
        public String mRootPath;
    }

    public static class MapViewInitParam {
        public int engineId;
        public int height;
        public float mapZoomScale;
        public int screenHeight;
        public float screenScale;
        public int screenWidth;
        public float textScale;
        public int width;
        public int x;
        public int y;
    }

    public GLMapEngine(Context context, ca caVar) {
        this.mNativeMapengineInstance = 0;
        this.mGlMapView = null;
        this.mStateMessageList = new Vector();
        this.mGestureMessageList = new Vector();
        this.mGestureEndMessageList = new Vector();
        this.mAnimateStateMessageList = new Vector();
        this.isMoveCameraStep = false;
        this.isGestureStep = false;
        this.mapGestureCount = 0;
        this.mapAnimationMgr = null;
        this.copyGLMapState = null;
        this.mLock = new ReentrantLock();
        this.mutLock = new Object();
        this.mNetworkState = null;
        this.bundle = null;
        this.isEngineRenderComplete = false;
        this.aMapLoaderHashtable = new Hashtable();
        this.mRequestDestroy = false;
        this.mRequestID = new AtomicInteger(1);
        this.mRequestDestroy = false;
        if (context != null) {
            this.context = context.getApplicationContext();
            this.mGlMapView = caVar;
            this.mTextTextureGenerator = new TextTextureGenerator();
            this.mapAnimationMgr = new AdglMapAnimationMgr();
            this.mapAnimationMgr.setMapAnimationListener(new MapAnimationListener() {
                public void onMapAnimationFinish(CancelableCallback cancelableCallback) {
                    GLMapEngine.this.doMapAnimationFinishCallback(cancelableCallback);
                }
            });
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.getProperty("http.agent"));
            stringBuilder.append(" amap/");
            stringBuilder.append(GlMapUtil.getAppVersionName(context));
            this.userAgent = stringBuilder.toString();
        }
    }

    public static void destroyOverlay(int i, long j) {
        synchronized (GLMapEngine.class) {
            nativeDestroyOverlay(i, j);
        }
    }

    private void doMapAnimationCancelCallback(final CancelableCallback cancelableCallback) {
        if (!(cancelableCallback == null || this.mGlMapView == null)) {
            this.mGlMapView.getMainHandler().post(new Runnable() {
                public void run() {
                    try {
                        cancelableCallback.onCancel();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void doMapAnimationFinishCallback(final CancelableCallback cancelableCallback) {
        if (this.mMapListener != null) {
            this.mMapListener.afterAnimation();
        }
        if (!(cancelableCallback == null || this.mGlMapView == null)) {
            this.mGlMapView.getMainHandler().post(new Runnable() {
                public void run() {
                    try {
                        cancelableCallback.onFinish();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void gestureBegin() {
        this.mapGestureCount++;
    }

    private void gestureEnd() {
        this.mapGestureCount--;
        if (this.mapGestureCount == 0) {
            recycleMessage();
        }
    }

    private void initAnimation() {
        if (this.mStateMessageList.size() <= 0 && this.mAnimateStateMessageList.size() > 0) {
            AbstractCameraUpdateMessage abstractCameraUpdateMessage = (AbstractCameraUpdateMessage) this.mAnimateStateMessageList.remove(0);
            if (abstractCameraUpdateMessage != null) {
                abstractCameraUpdateMessage.generateMapAnimation(this);
            }
        }
    }

    private void initNetworkState() {
        this.mNetworkState = new NetworkState();
        this.mNetworkState.setNetworkListener(this);
        this.mNetworkState.registerNetChangeReceiver(this.context.getApplicationContext(), true);
        boolean isNetworkConnected = NetworkState.isNetworkConnected(this.context.getApplicationContext());
        if (this.mNativeMapengineInstance != 0) {
            nativeSetNetStatus(this.mNativeMapengineInstance, isNetworkConnected);
        }
    }

    protected static native String nativeAddNativeOverlay(int i, long j, int i2, int i3);

    private static native boolean nativeAddOverlayTexture(int i, long j, int i2, int i3, float f, float f2, Bitmap bitmap, boolean z, boolean z2);

    private static native void nativeCreateAMapEngineWithFrame(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, float f2, float f3);

    private static native long nativeCreateAMapInstance(String str, String str2, String str3);

    protected static native long nativeCreateOverlay(int i, long j, int i2);

    private static native void nativeDestroy(long j);

    private static native void nativeDestroyCurrentState(long j, long j2);

    protected static native void nativeDestroyOverlay(int i, long j);

    private static native void nativeFinishDownLoad(int i, long j, long j2);

    private static native void nativeGetCurTileIDs(int i, long j, int[] iArr, int i2);

    private static native long nativeGetCurrentMapState(int i, long j);

    private static native long nativeGetGlOverlayMgrPtr(int i, long j);

    public static native String nativeGetMapEngineVersion(int i);

    private static native int[] nativeGetMapModeState(int i, long j, boolean z);

    private static native boolean nativeGetSrvViewStateBoolValue(int i, long j, int i2);

    private static native void nativeInitAMapEngineCallback(long j, Object obj);

    private static native void nativeInitParam(String str, String str2, String str3, String str4);

    private static native boolean nativeIsEngineCreated(long j, int i);

    private static native void nativePopRenderState(int i, long j);

    private static native void nativePostRenderAMap(long j, int i);

    private static native void nativePushRendererState(int i, long j);

    private static native void nativeReceiveNetData(int i, long j, byte[] bArr, long j2, int i2);

    protected static native void nativeRemoveNativeAllOverlay(int i, long j);

    protected static native void nativeRemoveNativeOverlay(int i, long j, String str);

    private static native void nativeRenderAMap(long j, int i);

    private static native void nativeSelectMapPois(int i, long j, int i2, int i3, int i4, byte[] bArr);

    private static native void nativeSetAllContentEnable(int i, long j, boolean z);

    private static native void nativeSetBuildingEnable(int i, long j, boolean z);

    private static native void nativeSetBuildingTextureEnable(int i, long j, boolean z);

    private static native void nativeSetCustomStyleData(int i, long j, byte[] bArr, byte[] bArr2);

    private static native void nativeSetCustomStyleTexture(int i, long j, byte[] bArr);

    private static native void nativeSetHighlightSubwayEnable(int i, long j, boolean z);

    private static native void nativeSetIndoorBuildingToBeActive(int i, long j, String str, int i2, String str2);

    private static native void nativeSetIndoorEnable(int i, long j, boolean z);

    private static native void nativeSetLabelEnable(int i, long j, boolean z);

    private static native boolean nativeSetMapModeAndStyle(int i, long j, int[] iArr, boolean z, boolean z2, StyleItem[] styleItemArr);

    private static native void nativeSetNetStatus(long j, int i);

    private static native void nativeSetOfflineDataEnable(int i, long j, boolean z);

    private static native void nativeSetParameter(int i, long j, int i2, int i3, int i4, int i5, int i6);

    private static native void nativeSetProjectionCenter(int i, long j, float f, float f2);

    private static native void nativeSetRenderListenerStatus(int i, long j);

    private static native void nativeSetServiceViewRect(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native void nativeSetSetBackgroundTexture(int i, long j, byte[] bArr);

    private static native void nativeSetSimple3DEnable(int i, long j, boolean z);

    private static native void nativeSetSkyTexture(int i, long j, byte[] bArr);

    private static native void nativeSetSrvViewStateBoolValue(int i, long j, int i2, boolean z);

    private static native void nativeSetTrafficEnable(int i, long j, boolean z);

    private static native void nativeSetTrafficTexture(int i, long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    private static native void nativeSetTrafficTextureAllInOne(int i, long j, byte[] bArr);

    protected static native void nativeUpdateNativeArrowOverlay(int i, long j, String str, int[] iArr, int[] iArr2, int i2, int i3, int i4, float f, boolean z, int i5, int i6, int i7);

    private boolean processAnimations(GLMapState gLMapState) {
        try {
            if (this.mapAnimationMgr.getAnimationsCount() > 0) {
                gLMapState.recalculate();
                this.mapAnimationMgr.doAnimations(gLMapState);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private boolean processGestureMessage(GLMapState gLMapState) {
        if (this.mGestureMessageList.size() <= 0) {
            if (this.isGestureStep) {
                this.isGestureStep = false;
            }
            return false;
        }
        this.isGestureStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (this.mGestureMessageList.size() > 0) {
            AbstractGestureMapMessage abstractGestureMapMessage = (AbstractGestureMapMessage) this.mGestureMessageList.remove(0);
            if (abstractGestureMapMessage == null) {
                break;
            }
            if (abstractGestureMapMessage.width == 0) {
                abstractGestureMapMessage.width = this.mGlMapView.getMapWidth();
            }
            if (abstractGestureMapMessage.height == 0) {
                abstractGestureMapMessage.height = this.mGlMapView.getMapHeight();
            }
            int mapGestureState = abstractGestureMapMessage.getMapGestureState();
            if (mapGestureState == 100) {
                gestureBegin();
            } else if (mapGestureState == 101) {
                abstractGestureMapMessage.runCameraUpdate(gLMapState);
            } else if (mapGestureState == 102) {
                gestureEnd();
            }
            this.mGestureEndMessageList.add(abstractGestureMapMessage);
        }
        if (this.mGestureEndMessageList.size() == 1) {
            recycleMessage();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A:{Catch:{ Exception -> 0x0041 }} */
    private boolean processMessage() {
        /*
        r5 = this;
        r0 = 0;
        r1 = 1;
        r2 = r5.getNewMapState(r1);	 Catch:{ Exception -> 0x0041 }
        r3 = r5.processGestureMessage(r2);	 Catch:{ Exception -> 0x0041 }
        r4 = r5.mGestureMessageList;	 Catch:{ Exception -> 0x0041 }
        r4 = r4.size();	 Catch:{ Exception -> 0x0041 }
        if (r4 > 0) goto L_0x001f;
    L_0x0012:
        if (r3 != 0) goto L_0x001d;
    L_0x0014:
        r3 = r5.processStateMapMessage(r2);	 Catch:{ Exception -> 0x0041 }
        if (r3 == 0) goto L_0x001b;
    L_0x001a:
        goto L_0x001d;
    L_0x001b:
        r3 = r0;
        goto L_0x002c;
    L_0x001d:
        r3 = r1;
        goto L_0x002c;
    L_0x001f:
        r4 = r5.mStateMessageList;	 Catch:{ Exception -> 0x0041 }
        r4 = r4.size();	 Catch:{ Exception -> 0x0041 }
        if (r4 <= 0) goto L_0x002c;
    L_0x0027:
        r4 = r5.mStateMessageList;	 Catch:{ Exception -> 0x0041 }
        r4.clear();	 Catch:{ Exception -> 0x0041 }
    L_0x002c:
        if (r3 != 0) goto L_0x0037;
    L_0x002e:
        r3 = r5.processAnimations(r2);	 Catch:{ Exception -> 0x0041 }
        if (r3 == 0) goto L_0x0035;
    L_0x0034:
        goto L_0x0037;
    L_0x0035:
        r3 = r0;
        goto L_0x0038;
    L_0x0037:
        r3 = r1;
    L_0x0038:
        if (r3 == 0) goto L_0x003d;
    L_0x003a:
        r5.setMapState(r1, r2);	 Catch:{ Exception -> 0x0041 }
    L_0x003d:
        r2.recycle();	 Catch:{ Exception -> 0x0041 }
        return r3;
    L_0x0041:
        r1 = move-exception;
        r1.printStackTrace();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.ae.gmap.GLMapEngine.processMessage():boolean");
    }

    private boolean processStateMapMessage(GLMapState gLMapState) {
        if (this.mStateMessageList.size() <= 0) {
            if (this.isMoveCameraStep) {
                this.isMoveCameraStep = false;
            }
            return false;
        }
        this.isMoveCameraStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (this.mStateMessageList.size() > 0) {
            AbstractCameraUpdateMessage abstractCameraUpdateMessage = (AbstractCameraUpdateMessage) this.mStateMessageList.remove(0);
            if (abstractCameraUpdateMessage == null) {
                break;
            }
            if (abstractCameraUpdateMessage.width == 0) {
                abstractCameraUpdateMessage.width = this.mGlMapView.getMapWidth();
            }
            if (abstractCameraUpdateMessage.height == 0) {
                abstractCameraUpdateMessage.height = this.mGlMapView.getMapHeight();
            }
            gLMapState.recalculate();
            abstractCameraUpdateMessage.runCameraUpdate(gLMapState);
        }
        return true;
    }

    private void recycleMessage() {
        while (this.mGestureEndMessageList.size() > 0) {
            AbstractGestureMapMessage abstractGestureMapMessage = (AbstractGestureMapMessage) this.mGestureEndMessageList.remove(0);
            if (abstractGestureMapMessage == null) {
                return;
            }
            if (abstractGestureMapMessage instanceof MoveGestureMapMessage) {
                ((MoveGestureMapMessage) abstractGestureMapMessage).recycle();
            } else if (abstractGestureMapMessage instanceof HoverGestureMapMessage) {
                ((HoverGestureMapMessage) abstractGestureMapMessage).recycle();
            } else if (abstractGestureMapMessage instanceof RotateGestureMapMessage) {
                ((RotateGestureMapMessage) abstractGestureMapMessage).recycle();
            } else if (abstractGestureMapMessage instanceof ScaleGestureMapMessage) {
                ((ScaleGestureMapMessage) abstractGestureMapMessage).recycle();
            }
        }
    }

    public void AddOverlayTexture(int i, Bitmap bitmap, int i2, int i3) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i2;
        gLTextureProperty.mAnchor = i3;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        addOverlayTexture(i, gLTextureProperty);
    }

    public void OnIndoorBuildingActivity(int i, byte[] bArr) {
        if (this.mGlMapView != null) {
            try {
                this.mGlMapView.onIndoorBuildingActivity(i, bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void addGestureMessage(int i, AbstractGestureMapMessage abstractGestureMapMessage, boolean z, int i2, int i3) {
        if (abstractGestureMapMessage != null) {
            abstractGestureMapMessage.isGestureScaleByMapCenter = z;
            this.mGestureMessageList.add(abstractGestureMapMessage);
        }
    }

    public void addGroupAnimation(int i, int i2, float f, int i3, int i4, int i5, int i6, CancelableCallback cancelableCallback) {
        AdglMapAnimGroup adglMapAnimGroup = new AdglMapAnimGroup(i2);
        adglMapAnimGroup.setToCameraDegree((float) i4, 0);
        adglMapAnimGroup.setToMapAngle((float) i3, 0);
        adglMapAnimGroup.setToMapLevel(f, 0);
        adglMapAnimGroup.setToMapCenterGeo(i5, i6, 0);
        if (this.mapAnimationMgr != null && adglMapAnimGroup != null && adglMapAnimGroup.isValid()) {
            this.mapAnimationMgr.addAnimation(adglMapAnimGroup, cancelableCallback);
        }
    }

    public void addMessage(AbstractCameraUpdateMessage abstractCameraUpdateMessage, boolean z) {
        if (z) {
            if (this.mAnimateStateMessageList != null) {
                this.mAnimateStateMessageList.clear();
                this.mAnimateStateMessageList.add(abstractCameraUpdateMessage);
            }
        } else if (this.mStateMessageList != null) {
            this.mStateMessageList.add(abstractCameraUpdateMessage);
        }
    }

    public String addNativeOverlay(int i, int i2, int i3) {
        if (this.mNativeMapengineInstance == 0) {
            return null;
        }
        String nativeAddNativeOverlay = nativeAddNativeOverlay(i, this.mNativeMapengineInstance, i2, i3);
        return TextUtils.isEmpty(nativeAddNativeOverlay) ? null : nativeAddNativeOverlay;
    }

    public void addOverlayTexture(int i, GLTextureProperty gLTextureProperty) {
        if (this.mNativeMapengineInstance != 0 && gLTextureProperty != null && gLTextureProperty.mBitmap != null && !gLTextureProperty.mBitmap.isRecycled()) {
            nativeAddOverlayTexture(i, this.mNativeMapengineInstance, gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap, gLTextureProperty.isGenMimps, gLTextureProperty.isRepeat);
        }
    }

    public boolean canStopMapRender(int i) {
        return this.isEngineRenderComplete;
    }

    public void cancelAllAMapDownload() {
        try {
            synchronized (this.aMapLoaderHashtable) {
                for (Entry value : this.aMapLoaderHashtable.entrySet()) {
                    AMapLoader aMapLoader = (AMapLoader) value.getValue();
                    aMapLoader.doCancel();
                    if (!aMapLoader.isFinish) {
                        synchronized (aMapLoader) {
                            if (!aMapLoader.isFinish) {
                                aMapLoader.notify();
                                aMapLoader.isFinish = true;
                            }
                        }
                    }
                }
                this.aMapLoaderHashtable.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cancelRequireMapData(Object obj) {
        if (obj != null && (obj instanceof AMapLoader)) {
            ((AMapLoader) obj).doCancel();
        }
    }

    public void changeSurface(int i, int i2) {
    }

    public void clearAllMessages(int i) {
    }

    public void clearAnimations(int i, boolean z) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void clearAnimations(int i, boolean z, int i2) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void createAMapEngineWithFrame(MapViewInitParam mapViewInitParam) {
        if (this.mNativeMapengineInstance != 0) {
            synchronized (GLMapEngine.class) {
                nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, mapViewInitParam.engineId, mapViewInitParam.x, mapViewInitParam.y, mapViewInitParam.width, mapViewInitParam.height, mapViewInitParam.screenWidth, mapViewInitParam.screenHeight, mapViewInitParam.screenScale, mapViewInitParam.textScale, mapViewInitParam.mapZoomScale);
            }
        }
    }

    public void createAMapInstance(InitParam initParam) {
        if (initParam != null) {
            synchronized (GLMapEngine.class) {
                nativeInitParam(initParam.mRootPath, initParam.mConfigContent, initParam.mOfflineDataPath, initParam.mP3dCrossPath);
                this.mNativeMapengineInstance = nativeCreateAMapInstance("", "http://mpsapi.amap.com/", "http://m5.amap.com/");
                nativeInitAMapEngineCallback(this.mNativeMapengineInstance, this);
                initNetworkState();
            }
        }
    }

    public long createOverlay(int i, int i2) {
        return this.mNativeMapengineInstance != 0 ? nativeCreateOverlay(i, this.mNativeMapengineInstance, i2) : 0;
    }

    public void destroyAMapEngine() {
        try {
            this.mRequestDestroy = true;
            cancelAllAMapDownload();
            synchronized (this.mutLock) {
                if (this.mNativeMapengineInstance != 0) {
                    synchronized (this) {
                        if (this.copyGLMapState != null) {
                            this.copyGLMapState.recycle();
                        }
                    }
                    nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());
                    nativeDestroy(this.mNativeMapengineInstance);
                }
                this.mNativeMapengineInstance = 0;
            }
            this.mGlMapView = null;
            this.mStateMessageList.clear();
            this.mAnimateStateMessageList.clear();
            this.mGestureEndMessageList.clear();
            this.mGestureMessageList.clear();
            this.mMapListener = null;
            OOOo000.O00000Oo();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void finishDownLoad(int i, long j) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
            if (this.mNativeMapengineInstance != 0) {
                nativeFinishDownLoad(i, this.mNativeMapengineInstance, j);
            }
            this.aMapLoaderHashtable.remove(Long.valueOf(j));
        }
    }

    public int generateRequestId() {
        return this.mRequestID.incrementAndGet();
    }

    public int getAnimateionsCount() {
        return this.mNativeMapengineInstance != 0 ? this.mapAnimationMgr.getAnimationsCount() : 0;
    }

    public synchronized GLMapState getCloneMapState() {
        this.mLock.lock();
        try {
            if (this.mNativeMapengineInstance != 0) {
                if (this.copyGLMapState == null) {
                    this.copyGLMapState = new GLMapState(1, this.mNativeMapengineInstance);
                }
                this.copyGLMapState.setMapZoomer(this.mGlMapView.getMapConfig().getSZ());
                this.copyGLMapState.setCameraDegree(this.mGlMapView.getMapConfig().getSC());
                this.copyGLMapState.setMapAngle(this.mGlMapView.getMapConfig().getSR());
                this.copyGLMapState.setMapGeoCenter(this.mGlMapView.getMapConfig().getSX(), this.mGlMapView.getMapConfig().getSY());
            }
        } finally {
            this.mLock.unlock();
        }
        return this.copyGLMapState;
    }

    public Context getContext() {
        return this.context;
    }

    public void getCurTileIDs(int i, int[] iArr) {
        if (iArr != null) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = 0;
            }
            nativeGetCurTileIDs(i, this.mNativeMapengineInstance, iArr, iArr.length);
        }
    }

    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        long j = this.mNativeMapengineInstance;
        return 1;
    }

    public int getEngineIDWithType(int i) {
        return 1;
    }

    public long getGlOverlayMgrPtr(int i) {
        return this.mNativeMapengineInstance != 0 ? nativeGetGlOverlayMgrPtr(i, this.mNativeMapengineInstance) : 0;
    }

    public boolean getIsProcessBuildingMark(int i) {
        return false;
    }

    public byte[] getLabelBuffer(int i, int i2, int i3, int i4) {
        this.mLock.lock();
        try {
            byte[] bArr = new byte[3072];
            if (this.mNativeMapengineInstance != 0) {
                nativeSelectMapPois(i, this.mNativeMapengineInstance, i2, i3, i4, bArr);
            }
            this.mLock.unlock();
            return bArr;
        } catch (Throwable th) {
            this.mLock.unlock();
        }
    }

    public boolean getMapDataTaskIsCancel(int i, long j) {
        return !this.aMapLoaderHashtable.containsKey(Long.valueOf(j));
    }

    public int[] getMapModeState(int i, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            nativeGetMapModeState(i, this.mNativeMapengineInstance, z);
        }
        return null;
    }

    public GLMapState getMapState(int i) {
        this.mLock.lock();
        try {
            if (this.mNativeMapengineInstance != 0 && this.state == null) {
                long nativeGetCurrentMapState = nativeGetCurrentMapState(i, this.mNativeMapengineInstance);
                if (nativeGetCurrentMapState != 0) {
                    this.state = new GLMapState(this.mNativeMapengineInstance, nativeGetCurrentMapState);
                }
            }
            this.mLock.unlock();
            return this.state;
        } catch (Throwable th) {
            this.mLock.unlock();
        }
    }

    public long getMapStateInstance(int i) {
        return 0;
    }

    public long getNativeInstance() {
        return this.mNativeMapengineInstance;
    }

    public GLMapState getNewMapState(int i) {
        this.mLock.lock();
        GLMapState gLMapState;
        try {
            if (this.mNativeMapengineInstance != 0) {
                gLMapState = new GLMapState(i, this.mNativeMapengineInstance);
                return gLMapState;
            }
            this.mLock.unlock();
            return null;
        } finally {
            gLMapState = this.mLock;
            gLMapState.unlock();
        }
    }

    public GLOverlayBundle getOverlayBundle(int i) {
        return this.bundle;
    }

    public boolean getSrvViewStateBoolValue(int i, int i2) {
        return this.mNativeMapengineInstance != 0 ? nativeGetSrvViewStateBoolValue(i, this.mNativeMapengineInstance, i2) : false;
    }

    public synchronized AbstractCameraUpdateMessage getStateMessage() {
        if (this.mStateMessageList != null) {
            if (this.mStateMessageList.size() != 0) {
                AbstractCameraUpdateMessage abstractCameraUpdateMessage = (AbstractCameraUpdateMessage) this.mStateMessageList.get(0);
                this.mStateMessageList.remove(abstractCameraUpdateMessage);
                return abstractCameraUpdateMessage;
            }
        }
        return null;
    }

    public int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void initNativeTexture(int i) {
        try {
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
            Bitmap bitmap = null;
            Bitmap bitmap2 = fromAsset != null ? fromAsset.getBitmap() : null;
            BitmapDescriptor fromAsset2 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
            Bitmap bitmap3 = fromAsset2 != null ? fromAsset2.getBitmap() : null;
            BitmapDescriptor fromAsset3 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
            if (fromAsset3 != null) {
                bitmap = fromAsset3.getBitmap();
            }
            AddOverlayTexture(i, bitmap2, 111, 4);
            AddOverlayTexture(i, bitmap3, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 4);
            AddOverlayTexture(i, bitmap, AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID, 4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void interruptAnimation() {
        if (isInMapAnimation(1)) {
            try {
                doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());
                clearAnimations(1, false);
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, getClass().getName(), "CancelableCallback.onCancel");
                th.printStackTrace();
            }
        }
    }

    public boolean isEngineCreated(int i) {
        return this.mNativeMapengineInstance != 0 ? nativeIsEngineCreated(this.mNativeMapengineInstance, i) : false;
    }

    public boolean isInMapAction(int i) {
        return false;
    }

    public boolean isInMapAnimation(int i) {
        return getAnimateionsCount() > 0;
    }

    public synchronized void netError(int i, long j, int i2) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j))) {
            if (this.mNativeMapengineInstance != 0) {
                nativeFinishDownLoad(i, this.mNativeMapengineInstance, j);
            }
            this.aMapLoaderHashtable.remove(Long.valueOf(j));
        }
    }

    public void networkStateChanged(Context context) {
        if (!(this.mRequestDestroy || this.mNativeMapengineInstance == 0)) {
            final boolean isNetworkConnected = NetworkState.isNetworkConnected(context);
            this.mGlMapView.queueEvent(new Runnable() {
                public void run() {
                    GLMapEngine.nativeSetNetStatus(GLMapEngine.this.mNativeMapengineInstance, isNetworkConnected);
                }
            });
        }
    }

    public void onClearCache(int i) {
    }

    public void onMapRender(int i, int i2) {
        if (i2 != 13) {
            switch (i2) {
                case 5:
                    if (this.mMapListener != null) {
                        this.mMapListener.beforeDrawLabel(i, getMapState(i));
                        return;
                    }
                    return;
                case 6:
                    if (this.mMapListener != null) {
                        this.mMapListener.afterDrawLabel(i, getMapState(i));
                        return;
                    }
                    return;
                case 7:
                    try {
                        if (this.mMapListener != null) {
                            this.mMapListener.afterRendererOver(i, getMapState(i));
                            return;
                        }
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                default:
                    return;
            }
        }
        this.isEngineRenderComplete = true;
    }

    public void popRendererState() {
        if (this.mNativeMapengineInstance != 0) {
            nativePopRenderState(1, this.mNativeMapengineInstance);
        }
    }

    public void pushRendererState() {
        if (this.mNativeMapengineInstance != 0) {
            nativePushRendererState(1, this.mNativeMapengineInstance);
        }
    }

    public void putResourceData(int i, byte[] bArr) {
    }

    /*  JADX ERROR: NullPointerException in pass: EliminatePhiNodes
        java.lang.NullPointerException
        	at jadx.core.utils.BlockUtils.getBlockByInsn(BlockUtils.java:172)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMerge(EliminatePhiNodes.java:90)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.replaceMergeInstructions(EliminatePhiNodes.java:68)
        	at jadx.core.dex.visitors.ssa.EliminatePhiNodes.visit(EliminatePhiNodes.java:31)
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
    public synchronized void receiveNetData(int r15, long r16, byte[] r18, int r19) {
        /*
        r14 = this;
        r1 = r14;
        monitor-enter(r14);
        r2 = r1.mRequestDestroy;	 Catch:{ all -> 0x001e }
        if (r2 == 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r14);
        return;
    L_0x0008:
        r2 = r1.mNativeMapengineInstance;	 Catch:{ all -> 0x001e }
        r4 = 0;	 Catch:{ all -> 0x001e }
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ all -> 0x001e }
        if (r6 == 0) goto L_0x001c;	 Catch:{ all -> 0x001e }
    L_0x0010:
        r8 = r1.mNativeMapengineInstance;	 Catch:{ all -> 0x001e }
        r7 = r15;	 Catch:{ all -> 0x001e }
        r10 = r18;	 Catch:{ all -> 0x001e }
        r11 = r16;	 Catch:{ all -> 0x001e }
        r13 = r19;	 Catch:{ all -> 0x001e }
        nativeReceiveNetData(r7, r8, r10, r11, r13);	 Catch:{ all -> 0x001e }
    L_0x001c:
        monitor-exit(r14);
        return;
    L_0x001e:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r14);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.ae.gmap.GLMapEngine.receiveNetData(int, long, byte[], int):void");
    }

    public void releaseNetworkState() {
        if (this.mNetworkState != null) {
            this.mNetworkState.registerNetChangeReceiver(this.context.getApplicationContext(), false);
            this.mNetworkState.setNetworkListener(null);
            this.mNetworkState = null;
        }
    }

    public void reloadMapResource(int i, String str, int i2) {
    }

    public void removeNativeAllOverlay(int i) {
        if (this.mNativeMapengineInstance != 0) {
            nativeRemoveNativeAllOverlay(i, this.mNativeMapengineInstance);
        }
    }

    public void removeNativeOverlay(int i, String str) {
        if (this.mNativeMapengineInstance != 0 && str != null) {
            nativeRemoveNativeOverlay(i, this.mNativeMapengineInstance, str);
        }
    }

    public void renderAMap() {
        if (this.mNativeMapengineInstance != 0) {
            boolean processMessage = processMessage();
            synchronized (GLMapEngine.class) {
                nativeRenderAMap(this.mNativeMapengineInstance, 1);
                nativePostRenderAMap(this.mNativeMapengineInstance, 1);
            }
            initAnimation();
            if (processMessage) {
                startCheckEngineRenderComplete();
            }
            if (!this.isEngineRenderComplete) {
                nativeSetRenderListenerStatus(1, this.mNativeMapengineInstance);
            }
        }
    }

    public byte[] requireCharBitmap(int i, int i2, int i3) {
        return this.mTextTextureGenerator.getTextPixelBuffer(i2, i3);
    }

    public byte[] requireCharsWidths(int i, int[] iArr, int i2, int i3) {
        return this.mTextTextureGenerator.getCharsWidths(iArr);
    }

    public void requireMapData(int i, byte[] bArr) {
    }

    public int requireMapDataAsyn(int i, byte[] bArr) {
        if (!(this.mRequestDestroy || bArr == null)) {
            ADataRequestParam aDataRequestParam = new ADataRequestParam();
            int i2 = GLConvertUtil.getInt(bArr, 0);
            aDataRequestParam.requestBaseUrl = GLConvertUtil.getString(bArr, 4, i2);
            i2 += 4;
            int i3 = GLConvertUtil.getInt(bArr, i2);
            i2 += 4;
            aDataRequestParam.requestUrl = GLConvertUtil.getString(bArr, i2, i3);
            i2 += i3;
            aDataRequestParam.handler = GLConvertUtil.getLong(bArr, i2);
            i2 += 8;
            aDataRequestParam.nRequestType = GLConvertUtil.getInt(bArr, i2);
            i2 += 4;
            i3 = GLConvertUtil.getInt(bArr, i2);
            i2 += 4;
            aDataRequestParam.enCodeString = GLConvertUtil.getSubBytes(bArr, i2, i3);
            aDataRequestParam.nCompress = GLConvertUtil.getInt(bArr, i2 + i3);
            final AMapLoader aMapLoader = new AMapLoader(i, this, aDataRequestParam);
            synchronized (this) {
                this.aMapLoaderHashtable.put(Long.valueOf(aDataRequestParam.handler), aMapLoader);
            }
            aMapLoader.isFinish = false;
            try {
                OOOo000.O000000o().O000000o(new Runnable() {
                    public void run() {
                        try {
                            if (GLMapEngine.this.mRequestDestroy) {
                                if (!(aMapLoader == null || aMapLoader.isFinish)) {
                                    synchronized (aMapLoader) {
                                        if (!aMapLoader.isFinish) {
                                            aMapLoader.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                }
                            } else if (aMapLoader == null) {
                                if (!(aMapLoader == null || aMapLoader.isFinish)) {
                                    synchronized (aMapLoader) {
                                        if (!aMapLoader.isFinish) {
                                            aMapLoader.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                }
                            } else {
                                aMapLoader.doRequest();
                                if (!(aMapLoader == null || aMapLoader.isFinish)) {
                                    synchronized (aMapLoader) {
                                        if (!aMapLoader.isFinish) {
                                            aMapLoader.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                ooOOOOoo.O00000o0(th, "download Thread", "AMapLoader doRequest");
                                if (!(aMapLoader == null || aMapLoader.isFinish)) {
                                    synchronized (aMapLoader) {
                                        if (!aMapLoader.isFinish) {
                                            aMapLoader.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                if (!(aMapLoader == null || aMapLoader.isFinish)) {
                                    synchronized (aMapLoader) {
                                        if (!aMapLoader.isFinish) {
                                            aMapLoader.notify();
                                            aMapLoader.isFinish = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
                synchronized (aMapLoader) {
                    while (!aMapLoader.isFinish) {
                        aMapLoader.wait();
                    }
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "download Thread", "requireMapData");
            }
        }
        return 0;
    }

    public void requireMapRender(int i, int i2, int i3) {
    }

    public byte[] requireMapResource(int i, String str) {
        if (str == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("map_assets/");
        stringBuilder.append(str);
        String stringBuilder2 = stringBuilder.toString();
        try {
            String str2 = "icons_5";
            String str3 = "bktile";
            if (this.mGlMapView.getMapConfig().isCustomStyleEnable()) {
                byte[] readFileContents;
                if (str.startsWith(str2)) {
                    readFileContents = FileUtil.readFileContents(this.mGlMapView.getMapConfig().getCustomTextureResourcePath());
                } else if (str.startsWith(str3)) {
                    readFileContents = FileUtil.readFileContentsFromAssets(this.context, stringBuilder2);
                    int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
                    if (customBackgroundColor != 0) {
                        readFileContents = OOo000.O000000o(readFileContents, customBackgroundColor);
                    }
                } else {
                    readFileContents = null;
                }
                if (readFileContents != null) {
                    return readFileContents;
                }
            }
            return FileUtil.readFileContentsFromAssets(this.context, stringBuilder2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void setAllContentEnable(int i, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            nativeSetAllContentEnable(i, this.mNativeMapengineInstance, z);
        }
    }

    public void setBackgroundTexture(int i, byte[] bArr) {
        if (!(bArr == null || this.mNativeMapengineInstance == 0)) {
            nativeSetSetBackgroundTexture(i, this.mNativeMapengineInstance, bArr);
        }
    }

    public void setBuildingEnable(int i, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            nativeSetBuildingEnable(i, this.mNativeMapengineInstance, z);
        }
    }

    public void setBuildingTextureEnable(int i, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            nativeSetBuildingTextureEnable(i, this.mNativeMapengineInstance, z);
        }
    }

    public void setCustomStyleData(int i, byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || this.mNativeMapengineInstance == 0)) {
            nativeSetCustomStyleData(i, this.mNativeMapengineInstance, bArr, bArr2);
        }
    }

    public void setCustomStyleTexture(int i, byte[] bArr) {
        if (!(bArr == null || this.mNativeMapengineInstance == 0)) {
            nativeSetCustomStyleTexture(i, this.mNativeMapengineInstance, bArr);
        }
    }

    public void setHighlightSubwayEnable(int i, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            nativeSetHighlightSubwayEnable(i, this.mNativeMapengineInstance, z);
        }
    }

    /* JADX WARNING: Missing block: B:8:0x001f, code skipped:
            return;
     */
    public void setIndoorBuildingToBeActive(int r12, java.lang.String r13, int r14, java.lang.String r15) {
        /*
        r11 = this;
        r0 = android.text.TextUtils.isEmpty(r13);
        if (r0 != 0) goto L_0x001f;
    L_0x0006:
        r0 = android.text.TextUtils.isEmpty(r15);
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        goto L_0x001f;
    L_0x000d:
        r0 = r11.mNativeMapengineInstance;
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 == 0) goto L_0x001e;
    L_0x0015:
        r6 = r11.mNativeMapengineInstance;
        r5 = r12;
        r8 = r13;
        r9 = r14;
        r10 = r15;
        nativeSetIndoorBuildingToBeActive(r5, r6, r8, r9, r10);
    L_0x001e:
        return;
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.ae.gmap.GLMapEngine.setIndoorBuildingToBeActive(int, java.lang.String, int, java.lang.String):void");
    }

    public void setIndoorEnable(int i, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            nativeSetIndoorEnable(i, this.mNativeMapengineInstance, z);
        }
    }

    public void setInternaltexture(int i, byte[] bArr, int i2) {
    }

    public void setLabelEnable(int i, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            nativeSetLabelEnable(i, this.mNativeMapengineInstance, z);
        }
    }

    public void setMapListener(IAMapListener iAMapListener) {
        this.mMapListener = iAMapListener;
    }

    public void setMapLoaderToTask(int i, long j, AMapLoader aMapLoader) {
    }

    public boolean setMapModeAndStyle(int i, int i2, int i3, int i4, boolean z, boolean z2, StyleItem[] styleItemArr) {
        if (this.mNativeMapengineInstance == 0) {
            return false;
        }
        z = setNativeMapModeAndStyle(i, i2, i3, i4, z, z2, styleItemArr);
        if (styleItemArr != null && z2) {
            i2 = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
            if (i2 != 0) {
                Context context = this.context;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
                stringBuilder.append(File.separator);
                stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
                setBackgroundTexture(i, OOo000.O000000o(FileUtil.readFileContentsFromAssets(context, stringBuilder.toString()), i2));
            }
            String customTextureResourcePath = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
            if (this.mGlMapView.getMapConfig().isProFunctionAuthEnable() && !TextUtils.isEmpty(customTextureResourcePath)) {
                this.mGlMapView.getMapConfig().setUseProFunction(true);
                setCustomStyleTexture(i, FileUtil.readFileContents(customTextureResourcePath));
            }
        } else if (i2 == 0 && i3 == 0 && i4 == 0) {
            Context context2 = this.context;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
            stringBuilder2.append(File.separator);
            stringBuilder2.append(AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
            setBackgroundTexture(i, FileUtil.readFileContentsFromAssets(context2, stringBuilder2.toString()));
            context2 = this.context;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
            stringBuilder2.append(File.separator);
            stringBuilder2.append(AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME);
            setCustomStyleTexture(i, FileUtil.readFileContentsFromAssets(context2, stringBuilder2.toString()));
        }
        return z;
    }

    public void setMapState(int i, GLMapState gLMapState) {
        setMapState(i, gLMapState, true);
    }

    public void setMapState(int i, GLMapState gLMapState, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            if (!(!z || this.mGlMapView == null || this.mGlMapView.getMapConfig() == null)) {
                this.mGlMapView.checkMapState(gLMapState);
            }
            this.mLock.lock();
            try {
                gLMapState.setNativeMapengineState(i, this.mNativeMapengineInstance);
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public boolean setNativeMapModeAndStyle(int i, int i2, int i3, int i4, boolean z, boolean z2, StyleItem[] styleItemArr) {
        if (this.mNativeMapengineInstance == 0) {
            return false;
        }
        return nativeSetMapModeAndStyle(i, this.mNativeMapengineInstance, new int[]{i2, i3, i4, 0, 0}, z, z2, styleItemArr);
    }

    public void setOfflineDataEnable(int i, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            nativeSetOfflineDataEnable(i, this.mNativeMapengineInstance, z);
        }
    }

    public void setOvelayBundle(int i, GLOverlayBundle<BaseMapOverlay<?, ?>> gLOverlayBundle) {
        this.bundle = gLOverlayBundle;
    }

    public void setParamater(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mLock.lock();
        try {
            if (this.mNativeMapengineInstance != 0) {
                nativeSetParameter(i, this.mNativeMapengineInstance, i2, i3, i4, i5, i6);
            }
            this.mLock.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.mLock.unlock();
        }
    }

    public void setProjectionCenter(int i, int i2, int i3) {
        if (this.mNativeMapengineInstance != 0) {
            nativeSetProjectionCenter(i, this.mNativeMapengineInstance, (float) i2, (float) i3);
        }
    }

    public void setServiceViewRect(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        nativeSetServiceViewRect(i, this.mNativeMapengineInstance, i2, i3, i4, i5, i6, i7);
    }

    public void setSimple3DEnable(int i, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            nativeSetSimple3DEnable(i, this.mNativeMapengineInstance, z);
        }
    }

    public void setSkyTexture(int i, byte[] bArr) {
        if (!(bArr == null || this.mNativeMapengineInstance == 0)) {
            nativeSetSkyTexture(i, this.mNativeMapengineInstance, bArr);
        }
    }

    public void setSrvViewStateBoolValue(int i, int i2, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            nativeSetSrvViewStateBoolValue(i, this.mNativeMapengineInstance, i2, z);
        }
    }

    public void setTrafficEnable(int i, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            nativeSetTrafficEnable(i, this.mNativeMapengineInstance, z);
        }
    }

    public void setTrafficStyle(int i, int i2, int i3, int i4, int i5) {
        setTrafficStyle(i, i2, i3, i4, i5, true);
    }

    public void setTrafficStyle(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (this.mNativeMapengineInstance != 0) {
            Context context = this.context;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
            stringBuilder.append(File.separator);
            stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_TRL_NAME);
            byte[] readFileContentsFromAssets = FileUtil.readFileContentsFromAssets(context, stringBuilder.toString());
            if (z) {
                nativeSetTrafficTextureAllInOne(i, this.mNativeMapengineInstance, OOo000.O000000o(readFileContentsFromAssets, new int[]{i4, i5, i3, i2}));
                return;
            }
            nativeSetTrafficTextureAllInOne(i, this.mNativeMapengineInstance, readFileContentsFromAssets);
        }
    }

    public void startCheckEngineRenderComplete() {
        this.isEngineRenderComplete = false;
    }

    public void startMapSlidAnim(int i, Point point, float f, float f2) {
        if (point != null) {
            try {
                clearAnimations(i, true);
                GLMapState cloneMapState = getCloneMapState();
                cloneMapState.reset();
                cloneMapState.recalculate();
                float abs = Math.abs(f);
                float abs2 = Math.abs(f2);
                float f3 = (float) 12000;
                if ((abs > abs2 ? abs : abs2) > f3) {
                    if (abs > abs2) {
                        f = f > 0.0f ? f3 : (float) -12000;
                        f2 *= f3 / abs;
                    } else {
                        f *= f3 / abs2;
                        f2 = f2 > 0.0f ? f3 : (float) -12000;
                    }
                }
                int mapWidth = this.mGlMapView.getMapWidth() >> 1;
                int mapHeight = this.mGlMapView.getMapHeight() >> 1;
                if (this.mGlMapView.O0000OoO()) {
                    mapWidth = this.mGlMapView.getMapConfig().getAnchorX();
                    mapHeight = this.mGlMapView.getMapConfig().getAnchorY();
                }
                AdglMapAnimFling adglMapAnimFling = new AdglMapAnimFling(500, mapWidth, mapHeight);
                adglMapAnimFling.setPositionAndVelocity(f, f2);
                adglMapAnimFling.commitAnimation(cloneMapState);
                this.mapAnimationMgr.addAnimation(adglMapAnimFling, null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void startPivotZoomRotateAnim(int i, Point point, float f, int i2, int i3) {
        if (f == -9999.0f && i2 != AbstractAdglAnimation.INVALIDE_VALUE) {
        }
    }

    public void updateNativeArrowOverlay(int i, String str, int[] iArr, int[] iArr2, int i2, int i3, int i4, float f, int i5, int i6, int i7, boolean z) {
        if (this.mNativeMapengineInstance != 0 && str != null) {
            nativeUpdateNativeArrowOverlay(i, this.mNativeMapengineInstance, str, iArr, iArr2, i2, i3, i4, f, z, i5, i6, i7);
        }
    }
}
