package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.c.a;
import com.tencent.mm.opensdk.utils.c.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MMSharedPreferences implements SharedPreferences {
    private static final String TAG = "MicroMsg.SDK.SharedPreferences";
    private final String[] columns = new String[]{"_id", "key", "type", "value"};
    private final ContentResolver cr;
    private REditor editor = null;
    private final HashMap<String, Object> values = new HashMap();

    private static class REditor implements Editor {
        private boolean clear = false;
        private ContentResolver cr;
        private Set<String> remove = new HashSet();
        private Map<String, Object> values = new HashMap();

        public REditor(ContentResolver contentResolver) {
            this.cr = contentResolver;
        }

        public void apply() {
        }

        public Editor clear() {
            this.clear = true;
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x009b  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x003f A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
        public boolean commit() {
            /*
            r9 = this;
            r0 = new android.content.ContentValues;
            r0.<init>();
            r1 = r9.clear;
            r2 = 0;
            if (r1 == 0) goto L_0x0014;
        L_0x000a:
            r1 = r9.cr;
            r3 = com.tencent.mm.opensdk.utils.c.b.CONTENT_URI;
            r4 = 0;
            r1.delete(r3, r4, r4);
            r9.clear = r2;
        L_0x0014:
            r1 = r9.remove;
            r1 = r1.iterator();
        L_0x001a:
            r3 = r1.hasNext();
            r4 = 1;
            if (r3 == 0) goto L_0x0035;
        L_0x0021:
            r3 = r1.next();
            r3 = (java.lang.String) r3;
            r5 = r9.cr;
            r6 = com.tencent.mm.opensdk.utils.c.b.CONTENT_URI;
            r7 = "key = ?";
            r4 = new java.lang.String[r4];
            r4[r2] = r3;
            r5.delete(r6, r7, r4);
            goto L_0x001a;
        L_0x0035:
            r1 = r9.values;
            r1 = r1.entrySet();
            r1 = r1.iterator();
        L_0x003f:
            r3 = r1.hasNext();
            if (r3 == 0) goto L_0x00c5;
        L_0x0045:
            r3 = r1.next();
            r3 = (java.util.Map.Entry) r3;
            r5 = r3.getValue();
            if (r5 != 0) goto L_0x005a;
        L_0x0051:
            r6 = "MicroMsg.SDK.PluginProvider.Resolver";
            r7 = "unresolve failed, null value";
        L_0x0055:
            com.tencent.mm.opensdk.utils.Log.e(r6, r7);
            r6 = r2;
            goto L_0x0097;
        L_0x005a:
            r6 = r5 instanceof java.lang.Integer;
            if (r6 == 0) goto L_0x0060;
        L_0x005e:
            r6 = r4;
            goto L_0x0097;
        L_0x0060:
            r6 = r5 instanceof java.lang.Long;
            if (r6 == 0) goto L_0x0066;
        L_0x0064:
            r6 = 2;
            goto L_0x0097;
        L_0x0066:
            r6 = r5 instanceof java.lang.String;
            if (r6 == 0) goto L_0x006c;
        L_0x006a:
            r6 = 3;
            goto L_0x0097;
        L_0x006c:
            r6 = r5 instanceof java.lang.Boolean;
            if (r6 == 0) goto L_0x0072;
        L_0x0070:
            r6 = 4;
            goto L_0x0097;
        L_0x0072:
            r6 = r5 instanceof java.lang.Float;
            if (r6 == 0) goto L_0x0078;
        L_0x0076:
            r6 = 5;
            goto L_0x0097;
        L_0x0078:
            r6 = r5 instanceof java.lang.Double;
            if (r6 == 0) goto L_0x007e;
        L_0x007c:
            r6 = 6;
            goto L_0x0097;
        L_0x007e:
            r6 = "MicroMsg.SDK.PluginProvider.Resolver";
            r7 = new java.lang.StringBuilder;
            r8 = "unresolve failed, unknown type=";
            r7.<init>(r8);
            r8 = r5.getClass();
            r8 = r8.toString();
            r7.append(r8);
            r7 = r7.toString();
            goto L_0x0055;
        L_0x0097:
            if (r6 != 0) goto L_0x009b;
        L_0x0099:
            r5 = r2;
            goto L_0x00ae;
        L_0x009b:
            r7 = "type";
            r6 = java.lang.Integer.valueOf(r6);
            r0.put(r7, r6);
            r6 = "value";
            r5 = r5.toString();
            r0.put(r6, r5);
            r5 = r4;
        L_0x00ae:
            if (r5 == 0) goto L_0x003f;
        L_0x00b0:
            r5 = r9.cr;
            r6 = com.tencent.mm.opensdk.utils.c.b.CONTENT_URI;
            r7 = "key = ?";
            r8 = new java.lang.String[r4];
            r3 = r3.getKey();
            r3 = (java.lang.String) r3;
            r8[r2] = r3;
            r5.update(r6, r0, r7, r8);
            goto L_0x003f;
        L_0x00c5:
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.openapi.MMSharedPreferences$REditor.commit():boolean");
        }

        public Editor putBoolean(String str, boolean z) {
            this.values.put(str, Boolean.valueOf(z));
            this.remove.remove(str);
            return this;
        }

        public Editor putFloat(String str, float f) {
            this.values.put(str, Float.valueOf(f));
            this.remove.remove(str);
            return this;
        }

        public Editor putInt(String str, int i) {
            this.values.put(str, Integer.valueOf(i));
            this.remove.remove(str);
            return this;
        }

        public Editor putLong(String str, long j) {
            this.values.put(str, Long.valueOf(j));
            this.remove.remove(str);
            return this;
        }

        public Editor putString(String str, String str2) {
            this.values.put(str, str2);
            this.remove.remove(str);
            return this;
        }

        public Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        public Editor remove(String str) {
            this.remove.add(str);
            return this;
        }
    }

    public MMSharedPreferences(Context context) {
        this.cr = context.getContentResolver();
    }

    private Object getValue(String str) {
        try {
            Cursor query = this.cr.query(b.CONTENT_URI, this.columns, "key = ?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            Object a = query.moveToFirst() ? a.a(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
            query.close();
            return a;
        } catch (Exception e) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder("getValue exception:");
            stringBuilder.append(e.getMessage());
            Log.e(str2, stringBuilder.toString());
            return null;
        }
    }

    public boolean contains(String str) {
        return getValue(str) != null;
    }

    public Editor edit() {
        if (this.editor == null) {
            this.editor = new REditor(this.cr);
        }
        return this.editor;
    }

    public Map<String, ?> getAll() {
        try {
            Cursor query = this.cr.query(b.CONTENT_URI, this.columns, null, null, null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.values.put(query.getString(columnIndex), a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            return this.values;
        } catch (Exception e) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("getAll exception:");
            stringBuilder.append(e.getMessage());
            Log.e(str, stringBuilder.toString());
            return this.values;
        }
    }

    public boolean getBoolean(String str, boolean z) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Boolean)) ? z : ((Boolean) value).booleanValue();
    }

    public float getFloat(String str, float f) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Float)) ? f : ((Float) value).floatValue();
    }

    public int getInt(String str, int i) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Integer)) ? i : ((Integer) value).intValue();
    }

    public long getLong(String str, long j) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Long)) ? j : ((Long) value).longValue();
    }

    public String getString(String str, String str2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof String)) ? str2 : (String) value;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
