package com.baidu.mapsdkplatform.comapi.map;

import android.os.Message;
import com.baidu.mapapi.UIMsg.m_AppUI;

class w {
    private static final String a = "w";
    private v b;

    w() {
    }

    /* Access modifiers changed, original: 0000 */
    public void a(Message message) {
        if (message.what == m_AppUI.V_WM_VDATAENGINE) {
            int i = message.arg1;
            if (i != 12) {
                switch (i) {
                    case -1:
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        switch (i) {
                            case 101:
                            case 102:
                                break;
                            default:
                                return;
                        }
                }
            }
            if (this.b != null) {
                this.b.a(message.arg1, message.arg2);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(v vVar) {
        this.b = vVar;
    }

    /* Access modifiers changed, original: 0000 */
    public void b(v vVar) {
        this.b = null;
    }
}
