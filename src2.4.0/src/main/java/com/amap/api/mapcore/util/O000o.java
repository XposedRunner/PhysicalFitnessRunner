package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.OO00Oo0.O000000o;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.FileUtil;
import com.autonavi.amap.mapcore.MapConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.zip.GZIPInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AMapCustomStyleManager */
public class O000o implements O000000o {
    private ca O000000o;
    private CustomMapStyleOptions O00000Oo;
    private boolean O00000o = false;
    private boolean O00000o0 = false;
    private boolean O00000oO = false;
    private boolean O00000oo = false;
    private int O0000O0o = 1;
    private Context O0000OOo;
    private byte[] O0000Oo = null;
    private byte[] O0000Oo0 = null;
    private byte[] O0000OoO = null;
    private byte[] O0000Ooo = null;
    private boolean O0000o = false;
    private boolean O0000o0 = false;
    private byte[] O0000o00 = null;
    private boolean O0000o0O = false;
    private boolean O0000o0o = false;
    private OO00Oo0 O0000oO;
    private boolean O0000oO0 = false;
    private OO00Oo0 O0000oOO;
    private byte[] O0000oOo = null;
    private boolean O0000oo = false;
    private byte[] O0000oo0 = null;
    private MyTrafficStyle O0000ooO = new MyTrafficStyle();

    public O000o(ca caVar, Context context) {
        this.O000000o = caVar;
        this.O0000OOo = context;
        this.O0000o0 = false;
        this.O0000o0O = false;
    }

    private void O000000o(String str, boolean z) {
        int O000000o = !TextUtils.isEmpty(str) ? OO0OO0o.O000000o(str) : Integer.MIN_VALUE;
        if (this.O000000o != null && this.O000000o.O000000o() != null) {
            if (this.O0000OoO == null) {
                Context context = this.O0000OOo;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
                stringBuilder.append(File.separator);
                stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
                this.O0000OoO = FileUtil.readFileContentsFromAssets(context, stringBuilder.toString());
            }
            if (this.O0000OoO != null) {
                if (z) {
                    z = O000000o == Integer.MIN_VALUE;
                } else {
                    O000000o = 0;
                    z = O000000o;
                }
                this.O000000o.O000000o().setBackgroundTexture(this.O0000O0o, OOo000.O000000o((byte[]) this.O0000OoO.clone(), 0, O000000o, z));
            }
        }
    }

    public static byte[] O000000o(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void O00000Oo(byte[] bArr) {
        if (bArr != null) {
            OO0O0OO O000000o = OO0OO0o.O000000o(bArr);
            if (!(O000000o == null || O000000o.O000000o() == null)) {
                try {
                    JSONObject jSONObject = new JSONObject(O000000o.O000000o());
                    if (jSONObject != null) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("bg");
                        String str = null;
                        boolean z = true;
                        if (optJSONObject != null) {
                            z = optJSONObject.optBoolean("visible", true);
                            str = optJSONObject.optString("lineColor", null);
                        }
                        O000000o(str, z);
                        optJSONObject = jSONObject.optJSONObject("traffic");
                        if (optJSONObject != null) {
                            optJSONObject = optJSONObject.optJSONObject("multiFillColors");
                            if (optJSONObject != null) {
                                int O000000o2 = OO0OO0o.O000000o(optJSONObject.optString("smooth"));
                                int O000000o3 = OO0OO0o.O000000o(optJSONObject.optString("slow"));
                                int O000000o4 = OO0OO0o.O000000o(optJSONObject.optString("congested"));
                                int O000000o5 = OO0OO0o.O000000o(optJSONObject.optString("seriousCongested"));
                                this.O0000ooO.setSmoothColor(O000000o2);
                                this.O0000ooO.setSlowColor(O000000o3);
                                this.O0000ooO.setCongestedColor(O000000o4);
                                this.O0000ooO.setSeriousCongestedColor(O000000o5);
                                if (!(this.O000000o == null || this.O000000o.O000000o() == null)) {
                                    this.O000000o.O000000o().setTrafficStyle(this.O0000O0o, this.O0000ooO.getSmoothColor(), this.O0000ooO.getSlowColor(), this.O0000ooO.getCongestedColor(), this.O0000ooO.getSeriousCongestedColor(), true);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "AMapCustomStyleManager", "setExtraStyle");
                }
            }
        }
    }

    private boolean O00000o0(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            if (bArr.length < 10240) {
                OO0O0OO O000000o = OO0OO0o.O000000o((byte[]) bArr.clone());
                if (!(O000000o == null || O000000o.O000000o() == null)) {
                    if (new JSONObject(O000000o.O000000o()) != null) {
                        return false;
                    }
                }
            }
        } catch (JSONException e) {
            ooOOOOoo.O00000o0(e, "AMapCustomStyleManager", "checkData");
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapCustomStyleManager", "checkData");
        }
        return true;
    }

    private void O00000oo() {
        if (!(this.O000000o == null || this.O000000o.O000000o() == null || this.O0000OoO == null)) {
            this.O000000o.O000000o().setBackgroundTexture(this.O0000O0o, this.O0000OoO);
        }
        if (!(this.O000000o == null || this.O000000o.O000000o() == null)) {
            this.O000000o.O000000o().setTrafficStyle(this.O0000O0o, 0, 0, 0, 0, false);
        }
        this.O0000oO0 = false;
    }

    private void O0000O0o() {
        if (this.O0000Oo == null) {
            Context context = this.O0000OOo;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
            stringBuilder.append(File.separator);
            stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA);
            this.O0000Oo = O000000o(FileUtil.readFileContentsFromAssets(context, stringBuilder.toString()));
        }
        byte[] bArr = this.O0000Oo0;
        this.O000000o.O000000o().setCustomStyleData(this.O0000O0o, this.O0000Oo, this.O0000Oo0);
        this.O0000o = false;
    }

    private void O0000OOo() {
        if (this.O0000o0o) {
            if (this.O0000Ooo == null) {
                Context context = this.O0000OOo;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
                stringBuilder.append(File.separator);
                stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME_FOR_CUSTOM);
                this.O0000Ooo = FileUtil.readFileContentsFromAssets(context, stringBuilder.toString());
            }
            this.O0000o0o = false;
            this.O000000o.O000000o().setCustomStyleTexture(this.O0000O0o, this.O0000Ooo);
        }
    }

    private void O0000Oo0() {
        if (this.O00000Oo != null) {
            this.O00000Oo.setStyleId(null);
            this.O00000Oo.setStyleDataPath(null);
            this.O00000Oo.setStyleData(null);
            this.O00000Oo.setStyleTexturePath(null);
            this.O00000Oo.setStyleTextureData(null);
            this.O00000Oo.setStyleExtraData(null);
            this.O00000Oo.setStyleExtraPath(null);
        }
    }

    public void O000000o() {
        if (this.O00000Oo != null && !this.O0000o0O) {
            try {
                MapConfig mapConfig = this.O000000o.getMapConfig();
                if (mapConfig != null) {
                    synchronized (this) {
                        String styleDataPath;
                        byte[] styleData;
                        if (!(!mapConfig.isHideLogoEnable() || this.O000000o == null || this.O000000o.O0000OOo() == null)) {
                            if (this.O000000o.O0000OOo().isLogoEnable()) {
                                if (!this.O00000Oo.isEnable()) {
                                    this.O000000o.O0000OOo().setLogoEnable(true);
                                } else if (this.O0000o) {
                                    this.O000000o.O0000OOo().setLogoEnable(false);
                                }
                            } else if (!this.O0000o) {
                                this.O000000o.O0000OOo().setLogoEnable(true);
                            }
                        }
                        if (this.O00000o0) {
                            if (this.O00000Oo.isEnable()) {
                                this.O000000o.O000000o().setNativeMapModeAndStyle(this.O0000O0o, 0, 0, 0, false, false, null);
                                mapConfig.setCustomStyleEnable(true);
                                this.O00000o0 = false;
                            } else {
                                this.O000000o.O000000o().setNativeMapModeAndStyle(this.O0000O0o, mapConfig.getMapStyleMode(), mapConfig.getMapStyleTime(), mapConfig.getMapStyleState(), false, false, null);
                                this.O0000o = false;
                                if (mapConfig.isCustomStyleEnable()) {
                                    if (mapConfig.getMapStyleMode() == 0 && mapConfig.getMapStyleTime() == 0 && mapConfig.getMapStyleState() == 0) {
                                        O0000O0o();
                                    }
                                    O0000OOo();
                                    if (this.O0000oO0) {
                                        O00000oo();
                                    }
                                    mapConfig.setCustomStyleEnable(false);
                                }
                                this.O00000o0 = false;
                                return;
                            }
                        }
                        if (this.O00000oO) {
                            String styleTexturePath = this.O00000Oo.getStyleTexturePath();
                            if (this.O00000Oo.getStyleTextureData() == null && !TextUtils.isEmpty(styleTexturePath)) {
                                this.O00000Oo.setStyleTextureData(FileUtil.readFileContents(styleTexturePath));
                            }
                            if (this.O00000Oo.getStyleTextureData() != null) {
                                this.O0000oo = true;
                                if (mapConfig.isProFunctionAuthEnable()) {
                                    this.O0000o0o = true;
                                    this.O000000o.O000000o().setCustomStyleTexture(this.O0000O0o, this.O00000Oo.getStyleTextureData());
                                    mapConfig.setUseProFunction(true);
                                } else {
                                    O0000OOo();
                                }
                            } else {
                                O0000OOo();
                                this.O0000oo = false;
                            }
                            this.O00000oO = false;
                        }
                        if (this.O00000o) {
                            styleDataPath = this.O00000Oo.getStyleDataPath();
                            if (this.O00000Oo.getStyleData() == null && !TextUtils.isEmpty(styleDataPath)) {
                                this.O00000Oo.setStyleData(FileUtil.readFileContents(styleDataPath));
                            }
                            if (this.O00000Oo.getStyleData() == null) {
                                if (this.O0000oOo == null) {
                                    if (this.O0000o) {
                                        this.O00000o0 = true;
                                        this.O00000Oo.setEnable(false);
                                    }
                                    this.O00000o = false;
                                }
                            }
                            if (this.O0000o00 == null) {
                                Context context = this.O0000OOo;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
                                stringBuilder.append(File.separator);
                                stringBuilder.append(AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_0_FOR_TEXTURE);
                                this.O0000o00 = O000000o(FileUtil.readFileContentsFromAssets(context, stringBuilder.toString()));
                            }
                            styleData = this.O0000oOo != null ? this.O0000oOo : this.O00000Oo.getStyleData();
                            if (O00000o0(styleData)) {
                                this.O000000o.O000000o().setCustomStyleData(this.O0000O0o, styleData, this.O0000o00);
                                this.O0000o = true;
                                if (this.O000000o != null) {
                                    this.O000000o.resetRenderTime();
                                }
                            } else {
                                OO0o000.O000000o();
                            }
                            this.O00000o = false;
                        }
                        if (this.O00000oo) {
                            styleDataPath = this.O00000Oo.getStyleExtraPath();
                            if (this.O00000Oo.getStyleExtraData() == null && !TextUtils.isEmpty(styleDataPath)) {
                                this.O00000Oo.setStyleExtraData(FileUtil.readFileContents(styleDataPath));
                            }
                            if (!(this.O00000Oo.getStyleExtraData() == null && this.O0000oo0 == null)) {
                                styleData = this.O0000oo0 != null ? this.O0000oo0 : this.O00000Oo.getStyleExtraData();
                                if (styleData != null) {
                                    O00000Oo(styleData);
                                    this.O0000oO0 = true;
                                }
                            }
                            this.O00000oo = false;
                        }
                    }
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "AMapCustomStyleManager", "updateStyle");
            }
        }
    }

    public void O000000o(CustomMapStyleOptions customMapStyleOptions) {
        if (this.O00000Oo != null && customMapStyleOptions != null) {
            synchronized (this) {
                if (!this.O0000o0) {
                    this.O0000o0 = true;
                    if (this.O00000Oo.isEnable()) {
                        this.O00000o0 = true;
                    }
                }
                if (this.O00000Oo.isEnable() != customMapStyleOptions.isEnable()) {
                    this.O00000Oo.setEnable(customMapStyleOptions.isEnable());
                    this.O00000o0 = true;
                }
                if (this.O00000Oo.isEnable()) {
                    if (!TextUtils.equals(this.O00000Oo.getStyleId(), customMapStyleOptions.getStyleId())) {
                        this.O00000Oo.setStyleId(customMapStyleOptions.getStyleId());
                        String styleId = this.O00000Oo.getStyleId();
                        if (!(TextUtils.isEmpty(styleId) || this.O000000o == null || this.O000000o.getMapConfig() == null || !this.O000000o.getMapConfig().isProFunctionAuthEnable())) {
                            if (this.O0000oO == null) {
                                this.O0000oO = new OO00Oo0(this.O0000OOo, this, 1);
                            }
                            this.O0000oO.O000000o(styleId);
                            this.O0000oO.O00000Oo();
                            if (this.O0000oOO == null) {
                                this.O0000oOO = new OO00Oo0(this.O0000OOo, this, 0);
                            }
                            this.O0000oOO.O000000o(styleId);
                            this.O0000oOO.O00000Oo();
                        }
                    }
                    if (!TextUtils.equals(this.O00000Oo.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                        this.O00000Oo.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                        this.O00000o = true;
                    }
                    if (this.O00000Oo.getStyleData() != customMapStyleOptions.getStyleData()) {
                        this.O00000Oo.setStyleData(customMapStyleOptions.getStyleData());
                        this.O00000o = true;
                    }
                    if (!TextUtils.equals(this.O00000Oo.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                        this.O00000Oo.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                        this.O00000oO = true;
                    }
                    if (this.O00000Oo.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                        this.O00000Oo.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                        this.O00000oO = true;
                    }
                    if (!TextUtils.equals(this.O00000Oo.getStyleExtraPath(), customMapStyleOptions.getStyleExtraPath())) {
                        this.O00000Oo.setStyleExtraPath(customMapStyleOptions.getStyleExtraPath());
                        this.O00000oo = true;
                    }
                    if (this.O00000Oo.getStyleExtraData() != customMapStyleOptions.getStyleExtraData()) {
                        this.O00000Oo.setStyleExtraData(customMapStyleOptions.getStyleExtraData());
                        this.O00000oo = true;
                    }
                    OOOOOo0.O000000o(this.O0000OOo, true);
                } else {
                    O0000Oo0();
                    OOOOOo0.O000000o(this.O0000OOo, false);
                }
            }
        }
    }

    public void O000000o(byte[] bArr, int i) {
        if (this.O00000Oo != null) {
            synchronized (this) {
                if (this.O000000o != null) {
                    MapConfig mapConfig = this.O000000o.getMapConfig();
                    if (mapConfig != null && mapConfig.isProFunctionAuthEnable()) {
                        mapConfig.setUseProFunction(true);
                        if (i == 1) {
                            this.O0000oOo = bArr;
                            this.O00000o = true;
                        } else if (i == 0) {
                            this.O0000oo0 = bArr;
                            this.O00000oo = true;
                        }
                    }
                }
            }
        }
    }

    public void O00000Oo() {
        if (this.O00000Oo != null) {
            synchronized (this) {
                if (!(this.O000000o == null || this.O000000o.getMapConfig() == null || this.O000000o.getMapConfig().isProFunctionAuthEnable())) {
                    this.O00000Oo.setStyleId(null);
                    this.O0000oOo = null;
                    this.O0000oo0 = null;
                }
                this.O00000oO = true;
                this.O00000o = true;
                if (this.O0000oO0) {
                    this.O00000oo = true;
                }
                this.O00000o0 = true;
            }
        }
    }

    public boolean O00000o() {
        return this.O00000Oo != null;
    }

    public void O00000o0() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new CustomMapStyleOptions();
        }
    }

    public void O00000oO() {
        synchronized (this) {
            if (this.O00000Oo != null) {
                this.O00000Oo.setEnable(false);
                O0000Oo0();
                this.O00000o0 = true;
            }
        }
    }
}
