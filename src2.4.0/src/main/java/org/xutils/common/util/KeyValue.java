package org.xutils.common.util;

public class KeyValue {
    public final String key;
    public final Object value;

    public KeyValue(String str, Object obj) {
        this.key = str;
        this.value = obj;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyValue keyValue = (KeyValue) obj;
        if (this.key != null) {
            z = this.key.equals(keyValue.key);
        } else if (keyValue.key != null) {
            z = false;
        }
        return z;
    }

    public String getValueStr() {
        return this.value == null ? null : this.value.toString();
    }

    public int hashCode() {
        return this.key != null ? this.key.hashCode() : 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KeyValue{key='");
        stringBuilder.append(this.key);
        stringBuilder.append('\'');
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
