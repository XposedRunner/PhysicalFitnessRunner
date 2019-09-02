package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg.m_AppUI;

class k extends Handler {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.a.g != null && ((Long) message.obj).longValue() == this.a.g.j) {
            if (message.what == m_AppUI.MSG_APP_SAVESCREEN) {
                if (this.a.g.h != null) {
                    for (l lVar : this.a.g.h) {
                        Bitmap bitmap = null;
                        if (message.arg2 == 1) {
                            int[] iArr = new int[(this.a.d * this.a.e)];
                            int[] iArr2 = new int[(this.a.d * this.a.e)];
                            if (this.a.g.i != null) {
                                iArr = this.a.g.i.a(iArr, this.a.d, this.a.e);
                                for (int i = 0; i < this.a.e; i++) {
                                    for (int i2 = 0; i2 < this.a.d; i2++) {
                                        int i3 = iArr[(this.a.d * i) + i2];
                                        iArr2[(((this.a.e - i) - 1) * this.a.d) + i2] = ((i3 & -16711936) | ((i3 << 16) & 16711680)) | ((i3 >> 16) & 255);
                                    }
                                }
                                bitmap = Bitmap.createBitmap(iArr2, this.a.d, this.a.e, Config.RGB_565);
                            } else {
                                return;
                            }
                        }
                        if (lVar != null) {
                            lVar.a(bitmap);
                        }
                    }
                }
            } else if (message.what == 39) {
                if (this.a.g != null && this.a.g.h != null) {
                    if (message.arg1 == 100) {
                        this.a.g.B();
                    } else if (message.arg1 == 200) {
                        this.a.g.L();
                    } else if (message.arg1 == 1) {
                        this.a.requestRender();
                    } else if (message.arg1 == 0) {
                        this.a.requestRender();
                        if (!(this.a.g.b() || this.a.getRenderMode() == 0)) {
                            this.a.setRenderMode(0);
                        }
                    } else if (message.arg1 == 2) {
                        if (this.a.g.h != null) {
                            for (l lVar2 : this.a.g.h) {
                                if (lVar2 != null) {
                                    lVar2.c();
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    if (!this.a.g.k && this.a.e > 0 && this.a.d > 0 && this.a.g.b(0, 0) != null) {
                        this.a.g.k = true;
                        for (l lVar22 : this.a.g.h) {
                            if (lVar22 != null) {
                                lVar22.b();
                            }
                        }
                    }
                    for (l lVar222 : this.a.g.h) {
                        if (lVar222 != null) {
                            lVar222.a();
                        }
                    }
                }
            } else if (message.what == 41) {
                if (this.a.g != null && this.a.g.h != null) {
                    if (this.a.g.n || this.a.g.o) {
                        for (l lVar2222 : this.a.g.h) {
                            if (lVar2222 != null) {
                                lVar2222.b(this.a.g.E());
                            }
                        }
                    }
                }
            } else if (message.what == 999) {
                if (this.a.g.h != null) {
                    for (l lVar22222 : this.a.g.h) {
                        if (lVar22222 != null) {
                            lVar22222.e();
                        }
                    }
                }
            } else if (message.what == 50 && this.a.g.h != null) {
                for (l lVar3 : this.a.g.h) {
                    if (lVar3 != null) {
                        if (message.arg1 != 0) {
                            if (message.arg1 == 1) {
                                if (this.a.g.E().a >= 18.0f) {
                                    lVar3.a(true);
                                }
                            }
                        }
                        lVar3.a(false);
                    }
                }
            }
        }
    }
}
