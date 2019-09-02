package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap();
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList();
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap();

    private static class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent;
            this.receivers = arrayList;
        }
    }

    private static class ReceiverRecord {
        boolean broadcasting;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.receiver);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.filter);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    /* JADX WARNING: Missing block: B:9:0x001a, code skipped:
            r2 = 0;
     */
    /* JADX WARNING: Missing block: B:11:0x001d, code skipped:
            if (r2 >= r1.length) goto L_0x0000;
     */
    /* JADX WARNING: Missing block: B:12:0x001f, code skipped:
            r3 = r1[r2];
            r4 = 0;
     */
    /* JADX WARNING: Missing block: B:14:0x0028, code skipped:
            if (r4 >= r3.receivers.size()) goto L_0x003e;
     */
    /* JADX WARNING: Missing block: B:15:0x002a, code skipped:
            ((android.support.v4.content.LocalBroadcastManager.ReceiverRecord) r3.receivers.get(r4)).receiver.onReceive(r8.mAppContext, r3.intent);
            r4 = r4 + 1;
     */
    /* JADX WARNING: Missing block: B:16:0x003e, code skipped:
            r2 = r2 + 1;
     */
    private void executePendingBroadcasts() {
        /*
        r8 = this;
    L_0x0000:
        r0 = r8.mReceivers;
        monitor-enter(r0);
        r1 = r8.mPendingBroadcasts;	 Catch:{ all -> 0x0041 }
        r1 = r1.size();	 Catch:{ all -> 0x0041 }
        if (r1 > 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r0);	 Catch:{ all -> 0x0041 }
        return;
    L_0x000d:
        r1 = new android.support.v4.content.LocalBroadcastManager.BroadcastRecord[r1];	 Catch:{ all -> 0x0041 }
        r2 = r8.mPendingBroadcasts;	 Catch:{ all -> 0x0041 }
        r2.toArray(r1);	 Catch:{ all -> 0x0041 }
        r2 = r8.mPendingBroadcasts;	 Catch:{ all -> 0x0041 }
        r2.clear();	 Catch:{ all -> 0x0041 }
        monitor-exit(r0);	 Catch:{ all -> 0x0041 }
        r0 = 0;
        r2 = r0;
    L_0x001c:
        r3 = r1.length;
        if (r2 >= r3) goto L_0x0000;
    L_0x001f:
        r3 = r1[r2];
        r4 = r0;
    L_0x0022:
        r5 = r3.receivers;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x003e;
    L_0x002a:
        r5 = r3.receivers;
        r5 = r5.get(r4);
        r5 = (android.support.v4.content.LocalBroadcastManager.ReceiverRecord) r5;
        r5 = r5.receiver;
        r6 = r8.mAppContext;
        r7 = r3.intent;
        r5.onReceive(r6, r7);
        r4 = r4 + 1;
        goto L_0x0022;
    L_0x003e:
        r2 = r2 + 1;
        goto L_0x001c;
    L_0x0041:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0041 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.LocalBroadcastManager.executePendingBroadcasts():void");
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList arrayList2 = (ArrayList) this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    /* JADX WARNING: Missing block: B:52:0x016f, code skipped:
            return true;
     */
    public boolean sendBroadcast(android.content.Intent r24) {
        /*
        r23 = this;
        r1 = r23;
        r2 = r24;
        r3 = r1.mReceivers;
        monitor-enter(r3);
        r11 = r24.getAction();	 Catch:{ all -> 0x0173 }
        r4 = r1.mAppContext;	 Catch:{ all -> 0x0173 }
        r4 = r4.getContentResolver();	 Catch:{ all -> 0x0173 }
        r12 = r2.resolveTypeIfNeeded(r4);	 Catch:{ all -> 0x0173 }
        r13 = r24.getData();	 Catch:{ all -> 0x0173 }
        r14 = r24.getScheme();	 Catch:{ all -> 0x0173 }
        r15 = r24.getCategories();	 Catch:{ all -> 0x0173 }
        r4 = r24.getFlags();	 Catch:{ all -> 0x0173 }
        r4 = r4 & 8;
        if (r4 == 0) goto L_0x002c;
    L_0x0029:
        r16 = 1;
        goto L_0x002e;
    L_0x002c:
        r16 = 0;
    L_0x002e:
        if (r16 == 0) goto L_0x0056;
    L_0x0030:
        r4 = "LocalBroadcastManager";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0173 }
        r5.<init>();	 Catch:{ all -> 0x0173 }
        r6 = "Resolving type ";
        r5.append(r6);	 Catch:{ all -> 0x0173 }
        r5.append(r12);	 Catch:{ all -> 0x0173 }
        r6 = " scheme ";
        r5.append(r6);	 Catch:{ all -> 0x0173 }
        r5.append(r14);	 Catch:{ all -> 0x0173 }
        r6 = " of intent ";
        r5.append(r6);	 Catch:{ all -> 0x0173 }
        r5.append(r2);	 Catch:{ all -> 0x0173 }
        r5 = r5.toString();	 Catch:{ all -> 0x0173 }
        android.util.Log.v(r4, r5);	 Catch:{ all -> 0x0173 }
    L_0x0056:
        r4 = r1.mActions;	 Catch:{ all -> 0x0173 }
        r5 = r24.getAction();	 Catch:{ all -> 0x0173 }
        r4 = r4.get(r5);	 Catch:{ all -> 0x0173 }
        r8 = r4;
        r8 = (java.util.ArrayList) r8;	 Catch:{ all -> 0x0173 }
        if (r8 == 0) goto L_0x0170;
    L_0x0065:
        if (r16 == 0) goto L_0x007d;
    L_0x0067:
        r4 = "LocalBroadcastManager";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0173 }
        r5.<init>();	 Catch:{ all -> 0x0173 }
        r6 = "Action list: ";
        r5.append(r6);	 Catch:{ all -> 0x0173 }
        r5.append(r8);	 Catch:{ all -> 0x0173 }
        r5 = r5.toString();	 Catch:{ all -> 0x0173 }
        android.util.Log.v(r4, r5);	 Catch:{ all -> 0x0173 }
    L_0x007d:
        r4 = 0;
        r6 = r4;
        r7 = 0;
    L_0x0080:
        r4 = r8.size();	 Catch:{ all -> 0x0173 }
        if (r7 >= r4) goto L_0x0140;
    L_0x0086:
        r4 = r8.get(r7);	 Catch:{ all -> 0x0173 }
        r5 = r4;
        r5 = (android.support.v4.content.LocalBroadcastManager.ReceiverRecord) r5;	 Catch:{ all -> 0x0173 }
        if (r16 == 0) goto L_0x00a7;
    L_0x008f:
        r4 = "LocalBroadcastManager";
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0173 }
        r9.<init>();	 Catch:{ all -> 0x0173 }
        r10 = "Matching against filter ";
        r9.append(r10);	 Catch:{ all -> 0x0173 }
        r10 = r5.filter;	 Catch:{ all -> 0x0173 }
        r9.append(r10);	 Catch:{ all -> 0x0173 }
        r9 = r9.toString();	 Catch:{ all -> 0x0173 }
        android.util.Log.v(r4, r9);	 Catch:{ all -> 0x0173 }
    L_0x00a7:
        r4 = r5.broadcasting;	 Catch:{ all -> 0x0173 }
        if (r4 == 0) goto L_0x00c2;
    L_0x00ab:
        if (r16 == 0) goto L_0x00b4;
    L_0x00ad:
        r4 = "LocalBroadcastManager";
        r5 = "  Filter's target already added";
        android.util.Log.v(r4, r5);	 Catch:{ all -> 0x0173 }
    L_0x00b4:
        r18 = r7;
        r19 = r8;
        r17 = r11;
        r20 = r12;
        r21 = r13;
        r13 = 1;
        r11 = r6;
        goto L_0x0133;
    L_0x00c2:
        r4 = r5.filter;	 Catch:{ all -> 0x0173 }
        r10 = "LocalBroadcastManager";
        r9 = r5;
        r5 = r11;
        r17 = r11;
        r11 = r6;
        r6 = r12;
        r18 = r7;
        r7 = r14;
        r19 = r8;
        r8 = r13;
        r20 = r12;
        r21 = r13;
        r13 = 1;
        r12 = r9;
        r9 = r15;
        r4 = r4.match(r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0173 }
        if (r4 < 0) goto L_0x010a;
    L_0x00df:
        if (r16 == 0) goto L_0x00fb;
    L_0x00e1:
        r5 = "LocalBroadcastManager";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0173 }
        r6.<init>();	 Catch:{ all -> 0x0173 }
        r7 = "  Filter matched!  match=0x";
        r6.append(r7);	 Catch:{ all -> 0x0173 }
        r4 = java.lang.Integer.toHexString(r4);	 Catch:{ all -> 0x0173 }
        r6.append(r4);	 Catch:{ all -> 0x0173 }
        r4 = r6.toString();	 Catch:{ all -> 0x0173 }
        android.util.Log.v(r5, r4);	 Catch:{ all -> 0x0173 }
    L_0x00fb:
        if (r11 != 0) goto L_0x0103;
    L_0x00fd:
        r6 = new java.util.ArrayList;	 Catch:{ all -> 0x0173 }
        r6.<init>();	 Catch:{ all -> 0x0173 }
        goto L_0x0104;
    L_0x0103:
        r6 = r11;
    L_0x0104:
        r6.add(r12);	 Catch:{ all -> 0x0173 }
        r12.broadcasting = r13;	 Catch:{ all -> 0x0173 }
        goto L_0x0134;
    L_0x010a:
        if (r16 == 0) goto L_0x0133;
    L_0x010c:
        switch(r4) {
            case -4: goto L_0x011b;
            case -3: goto L_0x0118;
            case -2: goto L_0x0115;
            case -1: goto L_0x0112;
            default: goto L_0x010f;
        };	 Catch:{ all -> 0x0173 }
    L_0x010f:
        r4 = "unknown reason";
        goto L_0x011d;
    L_0x0112:
        r4 = "type";
        goto L_0x011d;
    L_0x0115:
        r4 = "data";
        goto L_0x011d;
    L_0x0118:
        r4 = "action";
        goto L_0x011d;
    L_0x011b:
        r4 = "category";
    L_0x011d:
        r5 = "LocalBroadcastManager";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0173 }
        r6.<init>();	 Catch:{ all -> 0x0173 }
        r7 = "  Filter did not match: ";
        r6.append(r7);	 Catch:{ all -> 0x0173 }
        r6.append(r4);	 Catch:{ all -> 0x0173 }
        r4 = r6.toString();	 Catch:{ all -> 0x0173 }
        android.util.Log.v(r5, r4);	 Catch:{ all -> 0x0173 }
    L_0x0133:
        r6 = r11;
    L_0x0134:
        r7 = r18 + 1;
        r11 = r17;
        r8 = r19;
        r12 = r20;
        r13 = r21;
        goto L_0x0080;
    L_0x0140:
        r11 = r6;
        r13 = 1;
        if (r11 == 0) goto L_0x0170;
    L_0x0144:
        r4 = 0;
    L_0x0145:
        r5 = r11.size();	 Catch:{ all -> 0x0173 }
        if (r4 >= r5) goto L_0x0157;
    L_0x014b:
        r5 = r11.get(r4);	 Catch:{ all -> 0x0173 }
        r5 = (android.support.v4.content.LocalBroadcastManager.ReceiverRecord) r5;	 Catch:{ all -> 0x0173 }
        r6 = 0;
        r5.broadcasting = r6;	 Catch:{ all -> 0x0173 }
        r4 = r4 + 1;
        goto L_0x0145;
    L_0x0157:
        r4 = r1.mPendingBroadcasts;	 Catch:{ all -> 0x0173 }
        r5 = new android.support.v4.content.LocalBroadcastManager$BroadcastRecord;	 Catch:{ all -> 0x0173 }
        r5.<init>(r2, r11);	 Catch:{ all -> 0x0173 }
        r4.add(r5);	 Catch:{ all -> 0x0173 }
        r2 = r1.mHandler;	 Catch:{ all -> 0x0173 }
        r2 = r2.hasMessages(r13);	 Catch:{ all -> 0x0173 }
        if (r2 != 0) goto L_0x016e;
    L_0x0169:
        r2 = r1.mHandler;	 Catch:{ all -> 0x0173 }
        r2.sendEmptyMessage(r13);	 Catch:{ all -> 0x0173 }
    L_0x016e:
        monitor-exit(r3);	 Catch:{ all -> 0x0173 }
        return r13;
    L_0x0170:
        r6 = 0;
        monitor-exit(r3);	 Catch:{ all -> 0x0173 }
        return r6;
    L_0x0173:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r3);	 Catch:{ all -> 0x0173 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.LocalBroadcastManager.sendBroadcast(android.content.Intent):boolean");
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList arrayList = (ArrayList) this.mReceivers.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                IntentFilter intentFilter = (IntentFilter) arrayList.get(i);
                for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                    String action = intentFilter.getAction(i2);
                    ArrayList arrayList2 = (ArrayList) this.mActions.get(action);
                    if (arrayList2 != null) {
                        int i3 = 0;
                        while (i3 < arrayList2.size()) {
                            if (((ReceiverRecord) arrayList2.get(i3)).receiver == broadcastReceiver) {
                                arrayList2.remove(i3);
                                i3--;
                            }
                            i3++;
                        }
                        if (arrayList2.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }
}
