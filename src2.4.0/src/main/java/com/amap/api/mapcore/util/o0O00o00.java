package com.amap.api.mapcore.util;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.CoordinateConverter.CoordType;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: TraceManager */
public class o0O00o00 implements OnLocationChangedListener, LBSTraceBase {
    private static final TimeUnit O0000oO = TimeUnit.SECONDS;
    int O000000o = Runtime.getRuntime().availableProcessors();
    private Context O00000Oo;
    private ExecutorService O00000o;
    private CoordinateConverter O00000o0;
    private ExecutorService O00000oO;
    private long O00000oo = 2000;
    private int O0000O0o = 5;
    private TraceStatusListener O0000OOo;
    private List<TraceLocation> O0000Oo = new ArrayList();
    private O000o0 O0000Oo0;
    private int O0000OoO = 0;
    private int O0000Ooo = 0;
    private List<LatLng> O0000o = new ArrayList();
    private O00000o0 O0000o0;
    private long O0000o00 = 0;
    private TraceLocation O0000o0O = null;
    private List<LatLng> O0000o0o = new ArrayList();
    private List<LatLng> O0000oO0 = new ArrayList();
    private BlockingQueue<Runnable> O0000oOO = new LinkedBlockingQueue();
    private BlockingQueue<Runnable> O0000oOo = new LinkedBlockingQueue();

    /* compiled from: TraceManager */
    class O000000o implements Runnable {
        private List<TraceLocation> O00000Oo = new ArrayList();
        private int O00000o;
        private int O00000o0;
        private List<TraceLocation> O00000oO;
        private String O00000oo;
        private TraceListener O0000O0o;

        public O000000o(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
            this.O00000o0 = i2;
            this.O00000o = i;
            this.O00000oO = list;
            this.O00000oo = OOOOo0.O000000o();
            this.O0000O0o = traceListener;
        }

        private int O000000o() {
            int i = 0;
            if (this.O00000oO == null || this.O00000oO.size() == 0) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            for (TraceLocation traceLocation : this.O00000oO) {
                if (traceLocation != null) {
                    if (((double) traceLocation.getSpeed()) < 0.01d) {
                        arrayList.add(traceLocation);
                    } else {
                        i += O000000o(arrayList);
                        arrayList.clear();
                    }
                }
            }
            return i;
        }

        private int O000000o(List<TraceLocation> list) {
            int size = list.size();
            int i = 0;
            if (size <= 1) {
                return 0;
            }
            TraceLocation traceLocation = (TraceLocation) list.get(0);
            TraceLocation traceLocation2 = (TraceLocation) list.get(size - 1);
            if (traceLocation == null || traceLocation2 == null) {
                return 0;
            }
            if (!(traceLocation == null || traceLocation2 == null)) {
                i = (int) ((traceLocation2.getTime() - traceLocation.getTime()) / 1000);
            }
            return i;
        }

        public void run() {
            try {
                o0O00o00.this.O0000o0.O000000o(this.O0000O0o);
                int O000000o = O000000o();
                if (this.O00000oO != null) {
                    if (this.O00000oO.size() >= 2) {
                        for (TraceLocation copy : this.O00000oO) {
                            TraceLocation copy2 = copy2.copy();
                            if (copy2 != null && copy2.getLatitude() > 0.0d && copy2.getLongitude() > 0.0d) {
                                this.O00000Oo.add(copy2);
                            }
                        }
                        int size = (this.O00000Oo.size() - 2) / 500;
                        o0O0O00O.O000000o().O000000o(this.O00000oo, this.O00000o, size, O000000o);
                        int i = 0;
                        int i2 = 500;
                        while (i <= size) {
                            if (i == size) {
                                i2 = this.O00000Oo.size();
                            }
                            int i3 = i2;
                            ArrayList arrayList = new ArrayList();
                            for (i2 = 0; i2 < i3; i2++) {
                                TraceLocation traceLocation = (TraceLocation) this.O00000Oo.remove(0);
                                if (traceLocation != null) {
                                    if (this.O00000o0 != 1) {
                                        if (this.O00000o0 == 3) {
                                            o0O00o00.this.O00000o0.from(CoordType.BAIDU);
                                        } else if (this.O00000o0 == 2) {
                                            o0O00o00.this.O00000o0.from(CoordType.GPS);
                                        }
                                        o0O00o00.this.O00000o0.coord(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                                        LatLng convert = o0O00o00.this.O00000o0.convert();
                                        if (convert != null) {
                                            traceLocation.setLatitude(convert.latitude);
                                            traceLocation.setLongitude(convert.longitude);
                                        }
                                    }
                                    arrayList.add(traceLocation);
                                }
                            }
                            if (arrayList.size() >= 2) {
                                if (arrayList.size() <= 500) {
                                    o0O00o00.this.O00000oO.execute(new o0oO0Ooo(o0O00o00.this.O00000Oo, o0O00o00.this.O0000o0, arrayList, this.O00000o0, this.O00000oo, this.O00000o, i));
                                    i++;
                                    Thread.sleep(50);
                                }
                            }
                            i2 = i3;
                        }
                        return;
                    }
                }
                o0O0O00O.O000000o().O000000o(o0O00o00.this.O0000o0, this.O00000o, LBSTraceClient.MIN_GRASP_POINT_ERROR);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: TraceManager */
    class O00000Oo implements TraceListener {
        private final List<TraceLocation> O00000Oo;

        public O00000Oo(List<TraceLocation> list) {
            this.O00000Oo = list;
        }

        private void O000000o(int i, List<LatLng> list) {
            try {
                synchronized (o0O00o00.this.O0000oO0) {
                    o0O00o00.this.O0000oO0.clear();
                    o0O00o00.this.O0000oO0.addAll(list);
                }
                o0O00o00.this.O0000o.clear();
                if (i == 0) {
                    o0O00o00.this.O0000o.addAll(o0O00o00.this.O0000oO0);
                } else {
                    o0O00o00.this.O0000o.addAll(o0O00o00.this.O0000o0o);
                    o0O00o00.this.O0000o.addAll(o0O00o00.this.O0000oO0);
                }
                o0O00o00.this.O0000OOo.onTraceStatus(o0O00o00.this.O0000Oo, o0O00o00.this.O0000o, LBSTraceClient.TRACE_SUCCESS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onFinished(int i, List<LatLng> list, int i2, int i3) {
            O000000o(i, list);
        }

        public void onRequestFailed(int i, String str) {
            ArrayList arrayList = new ArrayList();
            if (o0O00o00.this.O0000oO0 != null) {
                arrayList.addAll(o0O00o00.this.O0000oO0);
            }
            if (this.O00000Oo != null) {
                int size = this.O00000Oo.size();
                if (this.O00000Oo.size() > o0O00o00.this.O0000O0o) {
                    for (int O00000Oo = size - o0O00o00.this.O0000O0o; O00000Oo < size; O00000Oo++) {
                        TraceLocation traceLocation = (TraceLocation) this.O00000Oo.get(O00000Oo);
                        if (traceLocation != null) {
                            arrayList.add(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                    }
                }
            }
            O000000o(i, arrayList);
        }

        public void onTraceProcessing(int i, int i2, List<LatLng> list) {
        }
    }

    /* compiled from: TraceManager */
    static class O00000o0 extends Handler {
        private TraceListener O000000o;

        public O00000o0(Looper looper) {
            super(looper);
        }

        public void O000000o(TraceListener traceListener) {
            this.O000000o = traceListener;
        }

        public void handleMessage(Message message) {
            try {
                if (this.O000000o != null) {
                    Bundle data = message.getData();
                    if (data != null) {
                        int i = data.getInt("lineID");
                        switch (message.what) {
                            case 100:
                                this.O000000o.onTraceProcessing(i, message.arg1, (List) message.obj);
                                break;
                            case 101:
                                this.O000000o.onFinished(i, (List) message.obj, message.arg1, message.arg2);
                                break;
                            case 102:
                                this.O000000o.onRequestFailed(i, (String) message.obj);
                                break;
                            default:
                                break;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public o0O00o00(Context context) {
        this.O00000Oo = context.getApplicationContext();
        this.O00000o0 = new CoordinateConverter(this.O00000Oo);
        this.O0000o0 = new O00000o0(Looper.getMainLooper());
        o0OO00OO.O000000o().O000000o(this.O00000Oo);
        this.O00000o = new ThreadPoolExecutor(1, this.O000000o * 2, 1, O0000oO, this.O0000oOO, new OOO0o00("AMapTraceManagerProcess"), new AbortPolicy());
        this.O00000oO = new ThreadPoolExecutor(1, this.O000000o * 2, 1, O0000oO, this.O0000oOo, new OOO0o00("AMapTraceManagerRequest"), new AbortPolicy());
    }

    private double O000000o(double d, double d2, double d3, double d4) {
        d = d > d3 ? d - d3 : d3 - d;
        d2 = d2 > d4 ? d2 - d4 : d4 - d2;
        return Math.sqrt((d * d) + (d2 * d2));
    }

    private void O000000o() {
        int size = this.O0000Oo.size();
        if (size >= this.O0000O0o) {
            if (size <= 50) {
                ArrayList arrayList = new ArrayList(this.O0000Oo);
                queryProcessedTrace(0, arrayList, 1, new O00000Oo(arrayList));
            } else {
                int i = size - 50;
                if (i >= 0) {
                    O000000o(new ArrayList(this.O0000Oo.subList(i - this.O0000O0o, i)));
                    ArrayList arrayList2 = new ArrayList(this.O0000Oo.subList(i, size));
                    queryProcessedTrace(i, arrayList2, 1, new O00000Oo(arrayList2));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A:{Catch:{ all -> 0x00b2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A:{Catch:{ all -> 0x00b2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0064 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A:{Catch:{ all -> 0x00b2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A:{Catch:{ all -> 0x00b2 }} */
    /* JADX WARNING: Missing block: B:40:0x00b6, code skipped:
            return;
     */
    private void O000000o(java.util.List<com.amap.api.trace.TraceLocation> r25) {
        /*
        r24 = this;
        r10 = r24;
        r11 = r10.O0000oO0;
        monitor-enter(r11);
        if (r25 == 0) goto L_0x00b5;
    L_0x0007:
        r2 = r25.size();	 Catch:{ all -> 0x00b2 }
        r3 = 1;
        if (r2 >= r3) goto L_0x0010;
    L_0x000e:
        goto L_0x00b5;
    L_0x0010:
        r2 = r10.O0000oO0;	 Catch:{ all -> 0x00b2 }
        r2 = r2.size();	 Catch:{ all -> 0x00b2 }
        if (r2 >= r3) goto L_0x001a;
    L_0x0018:
        monitor-exit(r11);	 Catch:{ all -> 0x00b2 }
        return;
    L_0x001a:
        r12 = r25.iterator();	 Catch:{ all -> 0x00b2 }
        r13 = 0;
        r14 = 0;
        r8 = r13;
        r16 = r14;
    L_0x0024:
        r1 = r12.hasNext();	 Catch:{ all -> 0x00b2 }
        if (r1 == 0) goto L_0x0064;
    L_0x002a:
        r1 = r12.next();	 Catch:{ all -> 0x00b2 }
        r9 = r1;
        r9 = (com.amap.api.trace.TraceLocation) r9;	 Catch:{ all -> 0x00b2 }
        if (r9 != 0) goto L_0x0036;
    L_0x0033:
        r21 = r8;
        goto L_0x005c;
    L_0x0036:
        if (r8 != 0) goto L_0x003b;
    L_0x0038:
        r20 = r9;
        goto L_0x0061;
    L_0x003b:
        r2 = r8.getLatitude();	 Catch:{ all -> 0x00b2 }
        r4 = r8.getLongitude();	 Catch:{ all -> 0x00b2 }
        r6 = r9.getLatitude();	 Catch:{ all -> 0x00b2 }
        r18 = r9.getLongitude();	 Catch:{ all -> 0x00b2 }
        r1 = r10;
        r21 = r8;
        r20 = r9;
        r8 = r18;
        r1 = r1.O000000o(r2, r4, r6, r8);	 Catch:{ all -> 0x00b2 }
        r3 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x005f;
    L_0x005c:
        r8 = r21;
        goto L_0x0024;
    L_0x005f:
        r16 = r16 + r1;
    L_0x0061:
        r8 = r20;
        goto L_0x0024;
    L_0x0064:
        r1 = r10.O0000oO0;	 Catch:{ all -> 0x00b2 }
        r12 = r1.iterator();	 Catch:{ all -> 0x00b2 }
    L_0x006a:
        r1 = r12.hasNext();	 Catch:{ all -> 0x00b2 }
        if (r1 == 0) goto L_0x00b0;
    L_0x0070:
        r1 = r12.next();	 Catch:{ all -> 0x00b2 }
        r8 = r1;
        r8 = (com.amap.api.maps.model.LatLng) r8;	 Catch:{ all -> 0x00b2 }
        if (r8 != 0) goto L_0x007d;
    L_0x0079:
        r12.remove();	 Catch:{ all -> 0x00b2 }
        goto L_0x006a;
    L_0x007d:
        if (r13 != 0) goto L_0x008a;
    L_0x007f:
        r1 = r10.O0000o0o;	 Catch:{ all -> 0x00b2 }
        r1.add(r8);	 Catch:{ all -> 0x00b2 }
        r12.remove();	 Catch:{ all -> 0x00b2 }
        r2 = r8;
        r1 = r12;
        goto L_0x00ad;
    L_0x008a:
        r2 = r13.latitude;	 Catch:{ all -> 0x00b2 }
        r4 = r13.longitude;	 Catch:{ all -> 0x00b2 }
        r6 = r8.latitude;	 Catch:{ all -> 0x00b2 }
        r22 = r12;
        r12 = r8.longitude;	 Catch:{ all -> 0x00b2 }
        r1 = r10;
        r23 = r8;
        r8 = r12;
        r1 = r1.O000000o(r2, r4, r6, r8);	 Catch:{ all -> 0x00b2 }
        r14 = r14 + r1;
        r1 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r1 >= 0) goto L_0x00b0;
    L_0x00a1:
        r1 = r10.O0000o0o;	 Catch:{ all -> 0x00b2 }
        r2 = r23;
        r1.add(r2);	 Catch:{ all -> 0x00b2 }
        r1 = r22;
        r1.remove();	 Catch:{ all -> 0x00b2 }
    L_0x00ad:
        r12 = r1;
        r13 = r2;
        goto L_0x006a;
    L_0x00b0:
        monitor-exit(r11);	 Catch:{ all -> 0x00b2 }
        return;
    L_0x00b2:
        r0 = move-exception;
        r1 = r0;
        goto L_0x00b7;
    L_0x00b5:
        monitor-exit(r11);	 Catch:{ all -> 0x00b2 }
        return;
    L_0x00b7:
        monitor-exit(r11);	 Catch:{ all -> 0x00b2 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0O00o00.O000000o(java.util.List):void");
    }

    /* JADX WARNING: Missing block: B:10:0x0021, code skipped:
            return false;
     */
    private boolean O000000o(com.amap.api.trace.TraceLocation r7, com.amap.api.trace.TraceLocation r8) {
        /*
        r6 = this;
        r0 = 0;
        if (r7 == 0) goto L_0x0021;
    L_0x0003:
        if (r8 != 0) goto L_0x0006;
    L_0x0005:
        goto L_0x0021;
    L_0x0006:
        r1 = r7.getLatitude();
        r3 = r8.getLatitude();
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x0020;
    L_0x0012:
        r1 = r7.getLongitude();
        r7 = r8.getLongitude();
        r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1));
        if (r3 != 0) goto L_0x0020;
    L_0x001e:
        r7 = 1;
        return r7;
    L_0x0020:
        return r0;
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0O00o00.O000000o(com.amap.api.trace.TraceLocation, com.amap.api.trace.TraceLocation):boolean");
    }

    private void O00000Oo() {
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.deactivate();
            this.O0000Oo0 = null;
        }
    }

    private void O00000o0() {
        this.O0000oOO.clear();
        this.O0000oOo.clear();
        if (this.O0000Oo != null) {
            synchronized (this.O0000Oo) {
                if (this.O0000Oo != null) {
                    this.O0000Oo.clear();
                }
                this.O0000Ooo = 0;
                this.O0000OoO = 0;
                this.O0000o00 = 0;
                this.O0000o0O = null;
            }
        }
    }

    public void destroy() {
        try {
            stopTrace();
            if (!(this.O00000o == null || this.O00000o.isShutdown())) {
                this.O00000o.shutdownNow();
                this.O00000o = null;
            }
            if (!(this.O00000oO == null || this.O00000oO.isShutdown())) {
                this.O00000oO.shutdownNow();
                this.O00000oO = null;
            }
            this.O0000Oo = null;
            this.O0000OOo = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.O00000Oo = null;
        this.O00000o0 = null;
    }

    public void onLocationChanged(Location location) {
        if (this.O0000OOo != null) {
            try {
                if (System.currentTimeMillis() - this.O0000o00 >= StatisticConfig.MIN_UPLOAD_INTERVAL && this.O0000OOo != null) {
                    this.O0000OOo.onTraceStatus(null, null, LBSTraceClient.LOCATE_TIMEOUT_ERROR);
                }
                this.O0000o00 = System.currentTimeMillis();
                Bundle extras = location.getExtras();
                int i = extras.getInt("errorCode");
                if (i != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Locate failed [errorCode:\"");
                    stringBuilder.append(i);
                    stringBuilder.append("\"  errorInfo:");
                    stringBuilder.append(extras.getString(MyLocationStyle.ERROR_INFO));
                    stringBuilder.append("\"]");
                    Log.w("LBSTraceClient", stringBuilder.toString());
                    return;
                }
                synchronized (this.O0000Oo) {
                    TraceLocation traceLocation = new TraceLocation(location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getBearing(), location.getTime());
                    if (O000000o(this.O0000o0O, traceLocation)) {
                        return;
                    }
                    this.O0000Oo.add(traceLocation);
                    this.O0000o0O = traceLocation;
                    this.O0000OoO++;
                    if (this.O0000OoO == this.O0000O0o) {
                        this.O0000Ooo += this.O0000OoO;
                        O000000o();
                        this.O0000OoO = 0;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
        try {
            this.O00000o.execute(new O000000o(i, list, i2, traceListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLocationInterval(long j) {
        this.O00000oo = j;
    }

    public void setTraceStatusInterval(int i) {
        this.O0000O0o = Math.max(i, 2);
    }

    public void startTrace(TraceStatusListener traceStatusListener) {
        if (this.O00000Oo == null) {
            Log.w("LBSTraceClient", "Context need to be initialized");
            return;
        }
        this.O0000o00 = System.currentTimeMillis();
        this.O0000OOo = traceStatusListener;
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new O000o0(this.O00000Oo);
            this.O0000Oo0.O000000o(this.O00000oo);
            this.O0000Oo0.activate(this);
        }
    }

    public void stopTrace() {
        O00000Oo();
        O00000o0();
    }
}
