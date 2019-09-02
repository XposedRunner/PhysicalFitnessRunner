package defpackage;

import com.umeng.commonsdk.statistics.proto.Gender;
import java.util.Locale;

/* compiled from: Gender */
/* renamed from: w */
public enum w {
    Male(1) {
        public String toString() {
            return String.format(Locale.US, "Male:%d", new Object[]{Integer.valueOf(this.O00000o)});
        }
    },
    Female(2) {
        public String toString() {
            return String.format(Locale.US, "Female:%d", new Object[]{Integer.valueOf(this.O00000o)});
        }
    },
    Unknown(0) {
        public String toString() {
            return String.format(Locale.US, "Unknown:%d", new Object[]{Integer.valueOf(this.O00000o)});
        }
    };
    
    public int O00000o;

    private w(int i) {
        this.O00000o = i;
    }

    public static Gender O000000o(w wVar) {
        switch (wVar) {
            case Male:
                return Gender.MALE;
            case Female:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }

    public static w O000000o(int i) {
        switch (i) {
            case 1:
                return Male;
            case 2:
                return Female;
            default:
                return Unknown;
        }
    }

    public int O000000o() {
        return this.O00000o;
    }
}
