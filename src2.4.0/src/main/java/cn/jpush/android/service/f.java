package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.a;
import cn.jpush.android.api.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f {
    private static volatile f a;
    private static final Object d = new Object();
    private TagAliasReceiver b;
    private ConcurrentHashMap<Long, a> c = new ConcurrentHashMap();
    private AtomicBoolean e = new AtomicBoolean(false);

    private f() {
    }

    private a a(long j) {
        return (a) this.c.get(Long.valueOf(j));
    }

    public static f a() {
        if (a == null) {
            synchronized (d) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    private static String a(a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            if (aVar.b != null && aVar.b.size() > 0) {
                return (String) aVar.b.toArray()[0];
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private void a(Context context, int i, long j) {
        a a = a(j);
        if (a != null) {
            a(a, i);
            b(j);
        }
    }

    private static void a(a aVar, int i) {
        if (aVar.e == 0 && aVar.c != null) {
            aVar.c.gotResult(i, aVar.a, aVar.b);
        }
    }

    private void b(long j) {
        this.c.remove(Long.valueOf(j));
    }

    private void b(Context context) {
        if (this.c != null && !this.c.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Entry entry : this.c.entrySet()) {
                if (((a) entry.getValue()).a(20000)) {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a(context, b.c, ((Long) it.next()).longValue());
            }
        }
    }

    private synchronized void c(Context context) {
        Throwable e;
        String str;
        String str2;
        b(context);
        if (this.e.get() && this.c != null && this.c.isEmpty()) {
            try {
                if (this.b != null) {
                    context.unregisterReceiver(this.b);
                    this.b = null;
                }
            } catch (IllegalArgumentException e2) {
                e = e2;
                str = "TagAliasOperator";
                str2 = "Receiver not registered, cannot call unregisterReceiver";
                cn.jpush.android.d.f.c(str, str2, e);
                this.e.set(false);
            } catch (Exception e3) {
                e = e3;
                str = "TagAliasOperator";
                str2 = "other exception";
                cn.jpush.android.d.f.c(str, str2, e);
                this.e.set(false);
            }
            this.e.set(false);
        }
    }

    public final JPushMessage a(Intent intent) {
        long longExtra = intent.getLongExtra("tagalias_seqid", -1);
        boolean z = false;
        int intExtra = intent.getIntExtra("tagalias_errorcode", 0);
        a a = a(longExtra);
        if (a == null) {
            return null;
        }
        a().b(longExtra);
        if (intExtra == 0) {
            try {
                if (a.f == 5) {
                    if (a.e == 1) {
                        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("tags");
                        if (stringArrayListExtra != null) {
                            a.b = new HashSet(stringArrayListExtra);
                        }
                    } else if (a.e == 2) {
                        a.a = intent.getStringExtra("alias");
                    }
                } else if (a.f == 6) {
                    z = intent.getBooleanExtra("validated", false);
                }
            } catch (Throwable unused) {
            }
        }
        JPushMessage jPushMessage = new JPushMessage();
        jPushMessage.setErrorCode(intExtra);
        jPushMessage.setSequence(a.d);
        if (a.e != 1) {
            jPushMessage.setAlias(a.a);
            return jPushMessage;
        } else if (a.f == 6) {
            jPushMessage.setCheckTag(a(a));
            jPushMessage.setTagCheckStateResult(z);
            jPushMessage.setTagCheckOperator(true);
            return jPushMessage;
        } else {
            jPushMessage.setTags(a.b);
            return jPushMessage;
        }
    }

    public final synchronized void a(Context context) {
        if (!this.e.get()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addCategory(cn.jpush.android.a.c);
                intentFilter.addAction("cn.jpush.android.intent.TAG_ALIAS_TIMEOUT");
                intentFilter.addAction("cn.jpush.android.intent.TAG_ALIAS_CALLBACK");
                if (this.b == null) {
                    this.b = new TagAliasReceiver();
                }
                context.registerReceiver(this.b, intentFilter);
                this.e.set(true);
            } catch (Exception unused) {
            }
        }
    }

    public final void a(Context context, int i, long j, a aVar) {
        if (aVar != null) {
            if (aVar.e != 0) {
                try {
                    Intent intent = new Intent();
                    intent.addCategory(cn.jpush.android.a.c);
                    intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
                    intent.setPackage(context.getPackageName());
                    if (aVar.e == 1) {
                        intent.putExtra("message_type", 1);
                    } else {
                        intent.putExtra("message_type", 2);
                    }
                    intent.putExtra("tagalias_errorcode", i);
                    intent.putExtra("tagalias_seqid", j);
                    context.sendBroadcast(intent);
                } catch (Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("onTagaliasTimeout error:");
                    stringBuilder.append(th.getMessage());
                    cn.jpush.android.d.f.c("TagAliasOperator", stringBuilder.toString());
                }
            } else if (aVar.c != null) {
                aVar.c.gotResult(i, aVar.a, aVar.b);
                b(j);
            }
        }
    }

    public final void a(Context context, long j, int i, Intent intent) {
        if ("cn.jpush.android.intent.TAG_ALIAS_TIMEOUT".equals(intent.getAction())) {
            a(context, i, j);
        } else {
            a a = a(j);
            if (a != null) {
                a().b(j);
                if (intent != null) {
                    try {
                        if (a.f == 5) {
                            if (a.e == 1) {
                                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("tags");
                                if (stringArrayListExtra != null) {
                                    a.b = new HashSet(stringArrayListExtra);
                                }
                            } else if (a.e == 2) {
                                a.a = intent.getStringExtra("alias");
                            }
                        } else if (a.f == 6) {
                            intent.getBooleanExtra("validated", false);
                        }
                    } catch (Throwable unused) {
                    }
                }
                a(a, i);
            }
        }
        c(context);
    }

    public final void a(Context context, Long l, a aVar) {
        b(context);
        this.c.put(l, aVar);
    }
}
