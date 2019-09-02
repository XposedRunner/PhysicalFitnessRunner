package defpackage;

import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;

/* compiled from: RequestType */
/* renamed from: bx */
public enum bx {
    SOCIAL {
        public String toString() {
            return "0";
        }
    },
    ANALYTICS {
        public String toString() {
            return ClientOSType.IOS;
        }
    },
    API {
        public String toString() {
            return ClientOSType.ANDROID;
        }
    }
}
