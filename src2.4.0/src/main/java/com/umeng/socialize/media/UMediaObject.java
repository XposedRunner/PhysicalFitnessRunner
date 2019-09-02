package com.umeng.socialize.media;

import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import java.util.Map;

public interface UMediaObject {

    public enum O000000o {
        IMAGE {
            public String toString() {
                return "0";
            }
        },
        VEDIO {
            public String toString() {
                return ClientOSType.IOS;
            }
        },
        MUSIC {
            public String toString() {
                return ClientOSType.ANDROID;
            }
        },
        TEXT {
            public String toString() {
                return ClientOSType.WEB_OR_H5;
            }
        },
        TEXT_IMAGE {
            public String toString() {
                return "4";
            }
        },
        WEBPAGE {
            public String toString() {
                return "5";
            }
        }
    }

    String O00000o0();

    boolean O00000oO();

    byte[] O0000O0o();

    Map<String, Object> O0000OOo();

    O000000o O0000Oo0();
}
