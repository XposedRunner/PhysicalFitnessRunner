package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.t;

public class OfflineMapUtil {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:14:0x0052 in {2, 8, 12, 13} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
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
    public static com.baidu.mapapi.map.offline.MKOLSearchRecord getSearchRecordFromLocalCityInfo(com.baidu.mapsdkplatform.comapi.map.q r9) {
        /*
        if (r9 != 0) goto L_0x0004;
        r9 = 0;
        return r9;
        r0 = new com.baidu.mapapi.map.offline.MKOLSearchRecord;
        r0.<init>();
        r1 = r9.a;
        r0.cityID = r1;
        r1 = r9.b;
        r0.cityName = r1;
        r1 = r9.d;
        r0.cityType = r1;
        r1 = 0;
        r3 = r9.a();
        if (r3 == 0) goto L_0x0046;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = r9.a();
        r4 = r4.iterator();
        r5 = r4.hasNext();
        if (r5 == 0) goto L_0x0046;
        r5 = r4.next();
        r5 = (com.baidu.mapsdkplatform.comapi.map.q) r5;
        r6 = getSearchRecordFromLocalCityInfo(r5);
        r3.add(r6);
        r5 = r5.c;
        r5 = (long) r5;
        r7 = r1 + r5;
        r0.childCities = r3;
        r1 = r7;
        goto L_0x002a;
        r3 = r0.cityType;
        r4 = 1;
        if (r3 != r4) goto L_0x004e;
        r0.dataSize = r1;
        return r0;
        r9 = r9.c;
        r1 = (long) r9;
        goto L_0x004b;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.offline.OfflineMapUtil.getSearchRecordFromLocalCityInfo(com.baidu.mapsdkplatform.comapi.map.q):com.baidu.mapapi.map.offline.MKOLSearchRecord");
    }

    public static MKOLUpdateElement getUpdatElementFromLocalMapElement(t tVar) {
        if (tVar == null) {
            return null;
        }
        MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
        mKOLUpdateElement.cityID = tVar.a;
        mKOLUpdateElement.cityName = tVar.b;
        if (tVar.g != null) {
            mKOLUpdateElement.geoPt = CoordUtil.mc2ll(tVar.g);
        }
        mKOLUpdateElement.level = tVar.e;
        mKOLUpdateElement.ratio = tVar.i;
        mKOLUpdateElement.serversize = tVar.h;
        mKOLUpdateElement.size = tVar.i == 100 ? tVar.h : (tVar.h / 100) * tVar.i;
        mKOLUpdateElement.status = tVar.l;
        mKOLUpdateElement.update = tVar.j;
        return mKOLUpdateElement;
    }
}
