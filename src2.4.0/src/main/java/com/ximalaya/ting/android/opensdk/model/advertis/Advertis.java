package com.ximalaya.ting.android.opensdk.model.advertis;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Advertis implements Parcelable {
    public static final int AD_SOURCE_ALI = 3;
    public static final int AD_SOURCE_ALI_NEW = 7;
    public static final int AD_SOURCE_BAIDU = 1;
    public static final int AD_SOURCE_GDT = 4;
    public static final int AD_SOURCE_GDT_WELCOME_SCREEN = 8;
    public static final int AD_SOURCE_GOOGLE = 2;
    public static final int AD_SOURCE_INMOBI = 5;
    public static final int AD_SOURCE_MAD = 6;
    public static final int AD_SOURCE_XIMALAYA = 0;
    public static final int CLICK_TYPE_CANNOT_CLICK = 2;
    public static final int CLICK_TYPE_CAN_CLICK = 1;
    public static final Creator<Advertis> CREATOR = new Creator<Advertis>() {
        public Advertis createFromParcel(Parcel parcel) {
            Advertis advertis = new Advertis();
            advertis.readFromParcel(parcel);
            return advertis;
        }

        public Advertis[] newArray(int i) {
            return new Advertis[i];
        }
    };
    public static final String FIELD_DURING_PLAY = "duringPlay";
    public static final int IMG_SHOW_TYPE_BACKGROUD_TYPE = 19;
    public static final int IMG_SHOW_TYPE_BOTTOM_LARGE_IMG = 16;
    public static final int IMG_SHOW_TYPE_BOTTOM_OPEN = 15;
    public static final int IMG_SHOW_TYPE_BOTTOM_RESIDENT = 14;
    public static final int IMG_SHOW_TYPE_BOTTOM_ROWTYPE = 18;
    public static final int IMG_SHOW_TYPE_BOTTOM_THIRD_SMALL_IMG = 17;
    public static final int IMG_SHOW_TYPE_GIF_FULL = 5;
    public static final int IMG_SHOW_TYPE_GIF_NORMAL = 6;
    public static final int IMG_SHOW_TYPE_MIDDLE_DOWN = 13;
    public static final int IMG_SHOW_TYPE_MIDDLE_UP = 12;
    public static final int IMG_SHOW_TYPE_TITLE = 8;
    public static final int IMG_SHOW_TYPE_VODIE_FULL = 9;
    public static final int IMG_SHOW_TYPE_VODIE_NORMAL = 10;
    public static final String IS_DISPLAYED_IN_SCREEN = "isDisplayedInScreen";
    public static final int LINK_TYPE_FILE = 2;
    public static final int LINK_TYPE_NONE = 0;
    public static final int LINK_TYPE_WEB = 1;
    public static final String PLAYFRAGMENT_AD_DOWN = "playDown";
    public static final String PLAYFRAGMENT_AD_LEFT = "playLeft";
    public static final String PLAYFRAGMENT_AD_RIGHT = "playRight";
    public static final String PLAYFRAGMENT_AD_TEXTAREA = "textArea";
    public static final int SHOW_TYPE_GIF = 1;
    public static final int SHOW_TYPE_STATIC = 0;
    public static final int SHOW_TYPE_VIDEO = 2;
    public static final Type TYPE = new TypeToken<Advertis>() {
    }.getType();
    public static final int TYPE_DANMU = 1;
    public static final int TYPE_DRAG = 4;
    public static final int TYPE_DROP = 7;
    public static final int TYPE_DROP_AND_DANMU = 8;
    public static final int TYPE_FLY_FLOWER = 6;
    public static final int TYPE_GIF = 9;
    public static final int TYPE_GIF_AND_DANMU = 10;
    public static final int TYPE_INTERACTIVE_ALL = 9;
    public static final int TYPE_INTERACTIVE_CLICK = 1;
    public static final int TYPE_INTERACTIVE_YAOYIYAO = 0;
    public static final int TYPE_LARGE_AND_DANMU = 5;
    public static final int TYPE_NORMAL = 3;
    public static final int TYPE_OLD = 0;
    public static final int TYPE_VIDEO = 11;
    public static final int TYPE_YAOYIYAO = 2;
    public static Set<String> thirdHostList = new HashSet();
    private List<String> LoadedUrls;
    private int adLocation;
    private String adMark;
    private long adSoundTime;
    @SerializedName(alternate = {"adId"}, value = "adid")
    private int adid;
    private String adpr;
    @SerializedName(alternate = {"adType"}, value = "adtype")
    private int adtype;
    private String apkUrl;
    private Map<String, String> appendedCovers;
    private String bgCover;
    private List<String> clickTokens;
    private int clickType;
    private List<String> clickUrls;
    private boolean clickable;
    private boolean closable;
    private String colorValue;
    private int countDown;
    private String description;
    private boolean duringPlay;
    private String dynamicCover;
    private String dynamicImage;
    private long endAt;
    private boolean hasCountDownFinished;
    private String iconStyle;
    @SerializedName(alternate = {"cover"}, value = "image")
    private String imageUrl;
    private int interactiveType;
    private boolean isAutoNotifyInstall = true;
    private boolean isEffective = true;
    private int isInternal;
    private boolean isLandScape;
    @SerializedName(alternate = {"shareFlag"}, value = "isShareFlag")
    private boolean isShareFlag;
    private boolean isWordOfMouth;
    private String jumpType;
    private int linkType;
    @SerializedName("link")
    private String linkUrl;
    private int loadingShowTime;
    @SerializedName("logo")
    private String logoUrl;
    private List<String> morePics;
    private String name;
    private int openlinkType;
    private int position;
    private int positionId;
    private int quantity;
    private long radioId;
    private String realLink;
    private String recSrc;
    private String recTrack;
    private long responseId;
    private long scheduleId;
    private String scheme;
    private AdShareDataForOpenSDK shareData;
    private int showTime;
    private List<String> showTokens;
    private List<String> showUrls;
    private int showstyle;
    private int soundType;
    private String soundUrl;
    private long startAt;
    private String subCover;
    private String subName;
    private String tempToken;
    private List<String> thirdClickStatUrls;
    private List<String> thirdShowStatUrls;
    private String thirdStatUrl;
    private long trackId;
    private String videoCover;
    private int volume = 100;
    private boolean xmul;

    public Advertis(Advertis advertis) {
        this.adid = advertis.adid;
        this.name = advertis.name;
        this.clickType = advertis.clickType;
        this.linkUrl = advertis.linkUrl;
        this.imageUrl = advertis.imageUrl;
        this.logoUrl = advertis.logoUrl;
        this.soundUrl = advertis.soundUrl;
        this.thirdStatUrl = advertis.thirdStatUrl;
        this.volume = advertis.volume;
        this.interactiveType = advertis.interactiveType;
        this.countDown = advertis.countDown;
        this.quantity = advertis.quantity;
        this.soundType = advertis.soundType;
        this.iconStyle = advertis.iconStyle;
        this.jumpType = advertis.jumpType;
        this.trackId = advertis.trackId;
        this.isAutoNotifyInstall = advertis.isAutoNotifyInstall;
        this.isShareFlag = advertis.isShareFlag;
        this.shareData = advertis.shareData;
        this.duringPlay = advertis.duringPlay;
        this.adtype = advertis.adtype;
        this.clickable = advertis.clickable;
        this.showTime = advertis.showTime;
        this.hasCountDownFinished = advertis.hasCountDownFinished;
        this.clickTokens = advertis.clickTokens;
        this.showTokens = advertis.showTokens;
        this.realLink = advertis.realLink;
        this.recSrc = advertis.recSrc;
        this.recTrack = advertis.recTrack;
        this.adSoundTime = advertis.adSoundTime;
        this.description = advertis.description;
        this.isLandScape = advertis.isLandScape;
        this.radioId = advertis.radioId;
        this.scheduleId = advertis.scheduleId;
        this.subCover = advertis.subCover;
        this.subName = advertis.subName;
        this.positionId = advertis.positionId;
        this.isInternal = advertis.isInternal;
        this.isWordOfMouth = advertis.isWordOfMouth;
        this.dynamicImage = advertis.dynamicImage;
        this.adpr = advertis.adpr;
    }

    public static String checkAdSourceIsThirdPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String host = Uri.parse(str).getHost();
        if (!("fdfs.xmcdn.com".equals(host) || "fdfs.ximalaya.com".equals(host))) {
            thirdHostList.add(host);
        }
        return str;
    }

    public static List<Advertis> getAdvertis(int i, JSONObject jSONObject) {
        return i == 5 ? parseAd(jSONObject) : i == 6 ? parseMadAd(jSONObject) : new ArrayList();
    }

    private static void getThirdAdByInmobi(List<Advertis> list, JSONArray jSONArray, int i, int i2, long j, int i3) throws JSONException {
        long j2 = (long) jSONArray.getJSONObject(i).getInt("adId");
        JSONArray optJSONArray = jSONArray.optJSONObject(i).optJSONObject("inmobiData").optJSONArray("ads");
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            String optString = optJSONArray.optJSONObject(i4).optString("pubContent", "");
            optJSONArray.optJSONObject(i4).optString("landingPage", "");
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4).optJSONObject("eventTracking");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (optJSONObject != null) {
                int i5;
                JSONArray optJSONArray2 = optJSONObject.optJSONObject("8").optJSONArray("urls");
                JSONArray optJSONArray3 = optJSONObject.optJSONObject("18").optJSONArray("urls");
                JSONArray optJSONArray4 = optJSONObject.optJSONObject("120").optJSONArray("urls");
                if (optJSONArray2 != null) {
                    for (int i6 = 0; i6 < optJSONArray2.length(); i6++) {
                        arrayList.add(optJSONArray2.optString(i6));
                    }
                }
                if (optJSONArray3 != null) {
                    for (i5 = 0; i5 < optJSONArray3.length(); i5++) {
                        arrayList2.add(optJSONArray3.optString(i5));
                    }
                }
                if (optJSONArray4 != null) {
                    for (i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        arrayList3.add(optJSONArray4.optString(i5));
                    }
                }
            }
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(optString, 0)));
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            if (jSONObject != null) {
                jSONObject.optJSONObject("icon").optString("url", "");
                str = jSONObject.optJSONObject("screenshots").optString("url", "");
                str2 = jSONObject.optString("description", "");
                str3 = jSONObject.optString("title", "");
                str4 = jSONObject.optString("landingURL", "");
            }
            Advertis advertis = new Advertis();
            advertis.setAdid((int) j2);
            advertis.setAdtype(i2);
            advertis.setImageUrl(str);
            advertis.setDescription(str2);
            advertis.setRealLink(str4);
            advertis.setLoadingShowTime(i3);
            advertis.setName(str3);
            advertis.setEndAt(j);
            advertis.setClickUrls(arrayList);
            advertis.setShowUrls(arrayList2);
            advertis.setLoadedUrls(arrayList3);
            list.add(advertis);
        }
    }

    private static Advertis getThirdAdByXimalaya(String str, Gson gson) {
        if (str == null) {
            return null;
        }
        Advertis advertis;
        try {
            advertis = (Advertis) gson.fromJson(str, TYPE);
        } catch (Exception e) {
            e.printStackTrace();
            advertis = null;
        }
        return advertis;
    }

    private static List<Advertis> parseAd(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            if (jSONObject.optInt("ret") == 0) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                Gson gson = new Gson();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    int optInt = optJSONArray.optJSONObject(i).optInt("adtype");
                    long optLong = optJSONArray.optJSONObject(i).optLong("endAt");
                    int optInt2 = optJSONArray.optJSONObject(i).optInt("loadingShowTime");
                    if (optInt == 5) {
                        getThirdAdByInmobi(arrayList, optJSONArray, i, optInt, optLong, optInt2);
                    } else {
                        Advertis thirdAdByXimalaya = getThirdAdByXimalaya(optJSONArray.getString(i), gson);
                        if (thirdAdByXimalaya != null) {
                            arrayList.add(thirdAdByXimalaya);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private static List<Advertis> parseMadAd(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            int i = 0;
            jSONObject = jSONObject.optJSONObject(jSONObject.names().optString(0));
            String optString = jSONObject.optString("imgurl", "");
            String optString2 = jSONObject.optString("clickurl", "");
            String optString3 = jSONObject.optString("displaytitle", "");
            String optString4 = jSONObject.optString("displaytext", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("imgtracking");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("thclkurl");
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList3.add(optJSONArray.optString(i2));
                }
            }
            if (optJSONArray2 != null) {
                while (i < optJSONArray2.length()) {
                    arrayList2.add(optJSONArray2.optString(i));
                    i++;
                }
            }
            Advertis advertis = new Advertis();
            advertis.setSoundType(6);
            advertis.setClickType(1);
            advertis.setImageUrl(optString);
            advertis.setDescription(optString4);
            advertis.setRealLink(optString2);
            advertis.setName(optString3);
            advertis.setClickUrls(arrayList2);
            advertis.setShowUrls(arrayList3);
            arrayList.add(advertis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public int getAdLocation() {
        return this.adLocation;
    }

    public String getAdMark() {
        return this.adMark;
    }

    public long getAdSoundTime() {
        return this.adSoundTime;
    }

    public int getAdid() {
        return this.adid;
    }

    public String getAdpr() {
        return this.adpr;
    }

    public int getAdtype() {
        return this.adtype;
    }

    public String getApkUrl() {
        return this.apkUrl;
    }

    public Map<String, String> getAppendedCovers() {
        return this.appendedCovers;
    }

    public String getBgCover() {
        return checkAdSourceIsThirdPath(this.bgCover);
    }

    public List<String> getClickTokens() {
        return this.clickTokens;
    }

    public int getClickType() {
        return this.clickType;
    }

    public List<String> getClickUrls() {
        return this.clickUrls;
    }

    public String getColorValue() {
        return this.colorValue;
    }

    public int getCountDown() {
        return this.countDown;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDynamicCover() {
        return checkAdSourceIsThirdPath(this.dynamicCover);
    }

    public String getDynamicImage() {
        return this.dynamicImage;
    }

    public long getEndAt() {
        return this.endAt;
    }

    public String getIconStyle() {
        return this.iconStyle;
    }

    public String getImageUrl() {
        return checkAdSourceIsThirdPath(this.imageUrl);
    }

    public int getInteractiveType() {
        return this.interactiveType;
    }

    public boolean getIsAutoNotifyInstall() {
        return this.isAutoNotifyInstall;
    }

    public int getIsInternal() {
        return this.isInternal;
    }

    public String getJumpType() {
        return this.jumpType;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public List<String> getLoadedUrls() {
        return this.LoadedUrls;
    }

    public int getLoadingShowTime() {
        return this.loadingShowTime;
    }

    public String getLogoUrl() {
        return checkAdSourceIsThirdPath(this.logoUrl);
    }

    public List<String> getMorePics() {
        return this.morePics;
    }

    public String getName() {
        return this.name;
    }

    public int getOpenlinkType() {
        return this.openlinkType;
    }

    public int getPosition() {
        return this.position;
    }

    public int getPositionId() {
        return this.positionId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public long getRadioId() {
        return this.radioId;
    }

    public String getRealLink() {
        return this.realLink;
    }

    public String getRecSrc() {
        return this.recSrc == null ? "" : this.recSrc;
    }

    public String getRecTrack() {
        return this.recTrack == null ? "" : this.recTrack;
    }

    public long getResponseId() {
        return this.responseId;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public String getScheme() {
        return this.scheme;
    }

    public AdShareDataForOpenSDK getShareData() {
        return this.shareData;
    }

    public int getShowTime() {
        return this.showTime;
    }

    public List<String> getShowTokens() {
        return this.showTokens;
    }

    public List<String> getShowUrls() {
        return this.showUrls;
    }

    public int getShowstyle() {
        return this.showstyle;
    }

    public int getSoundType() {
        return this.soundType;
    }

    public String getSoundUrl() {
        return checkAdSourceIsThirdPath(this.soundUrl);
    }

    public long getStartAt() {
        return this.startAt;
    }

    public String getSubCover() {
        return this.subCover;
    }

    public String getSubName() {
        return this.subName;
    }

    public String getTempToken() {
        return this.tempToken;
    }

    public List<String> getThirdClickStatUrls() {
        return this.thirdClickStatUrls;
    }

    public List<String> getThirdShowStatUrls() {
        return this.thirdShowStatUrls;
    }

    public String getThirdStatUrl() {
        return this.thirdStatUrl;
    }

    public long getTrackId() {
        return this.trackId;
    }

    public String getVideoCover() {
        return checkAdSourceIsThirdPath(this.videoCover);
    }

    public int getVolume() {
        return this.volume;
    }

    public boolean isAutoNotifyInstall() {
        return this.isAutoNotifyInstall;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public boolean isClosable() {
        return this.closable;
    }

    public boolean isDuringPlay() {
        return this.duringPlay;
    }

    public boolean isEffective() {
        return this.isEffective;
    }

    public boolean isHasCountDownFinished() {
        return this.hasCountDownFinished;
    }

    public boolean isLandScape() {
        return this.isLandScape;
    }

    public boolean isShareFlag() {
        return this.isShareFlag;
    }

    public boolean isWordOfMouth() {
        return this.isWordOfMouth;
    }

    public boolean isXmul() {
        return this.xmul;
    }

    public void readFromParcel(Parcel parcel) {
        setAdid(parcel.readInt());
        setName(parcel.readString());
        setClickType(parcel.readInt());
        setLinkUrl(parcel.readString());
        setImageUrl(parcel.readString());
        setLogoUrl(parcel.readString());
        setSoundUrl(parcel.readString());
        setThirdStatUrl(parcel.readString());
        setInteractiveType(parcel.readInt());
        setCountDown(parcel.readInt());
        setQuantity(parcel.readInt());
        setSoundType(parcel.readInt());
        setIconStyle(parcel.readString());
        setJumpType(parcel.readString());
        setTrackId(parcel.readLong());
        setShareData((AdShareDataForOpenSDK) parcel.readParcelable(AdShareDataForOpenSDK.class.getClassLoader()));
        boolean z = false;
        setShareFlag(parcel.readInt() == 1);
        setDuringPlay(parcel.readInt() == 1);
        setAdtype(parcel.readInt());
        setClickable(parcel.readInt() == 1);
        setRealLink(parcel.readString());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        setClickTokens(arrayList);
        arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        setShowTokens(arrayList);
        setRecSrc(parcel.readString());
        setRecTrack(parcel.readString());
        setResponseId(parcel.readLong());
        setXmul(parcel.readInt() == 1);
        setAdSoundTime(parcel.readLong());
        setAdMark(parcel.readString());
        setDescription(parcel.readString());
        setLandScape(parcel.readInt() == 1);
        arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        setThirdShowStatUrls(arrayList);
        arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        setThirdClickStatUrls(arrayList);
        setRadioId(parcel.readLong());
        setScheduleId(parcel.readLong());
        setSubCover(parcel.readString());
        setSubName(parcel.readString());
        setPositionId(parcel.readInt());
        setIsInternal(parcel.readInt());
        arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        setMorePics(arrayList);
        setDynamicImage(parcel.readString());
        if (parcel.readInt() == 1) {
            z = true;
        }
        setWordOfMouth(z);
        setAdpr(parcel.readString());
    }

    public void setAdLocation(int i) {
        this.adLocation = i;
    }

    public void setAdMark(String str) {
        this.adMark = str;
    }

    public void setAdSoundTime(long j) {
        this.adSoundTime = j;
    }

    public void setAdid(int i) {
        this.adid = i;
    }

    public void setAdpr(String str) {
        this.adpr = str;
    }

    public void setAdtype(int i) {
        this.adtype = i;
    }

    public void setApkUrl(String str) {
        this.apkUrl = str;
    }

    public void setAppendedCovers(Map<String, String> map) {
        this.appendedCovers = map;
    }

    public void setAutoNotifyInstall(boolean z) {
        this.isAutoNotifyInstall = z;
    }

    public void setBgCover(String str) {
        this.bgCover = str;
    }

    public void setClickTokens(List<String> list) {
        this.clickTokens = list;
    }

    public void setClickType(int i) {
        this.clickType = i;
    }

    public void setClickUrls(List<String> list) {
        this.clickUrls = list;
    }

    public void setClickable(boolean z) {
        this.clickable = z;
    }

    public void setClosable(boolean z) {
        this.closable = z;
    }

    public void setColorValue(String str) {
        this.colorValue = str;
    }

    public void setCountDown(int i) {
        this.countDown = i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDuringPlay(boolean z) {
        this.duringPlay = z;
    }

    public void setDynamicCover(String str) {
        this.dynamicCover = str;
    }

    public void setDynamicImage(String str) {
        this.dynamicImage = str;
    }

    public void setEffective(boolean z) {
        this.isEffective = z;
    }

    public void setEndAt(long j) {
        this.endAt = j;
    }

    public void setHasCountDownFinished(boolean z) {
        this.hasCountDownFinished = z;
    }

    public void setIconStyle(String str) {
        this.iconStyle = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setInteractiveType(int i) {
        this.interactiveType = i;
    }

    public void setIsAutoNotifyInstall(boolean z) {
        this.isAutoNotifyInstall = z;
    }

    public void setIsInternal(int i) {
        this.isInternal = i;
    }

    public void setJumpType(String str) {
        this.jumpType = str;
    }

    public void setLandScape(boolean z) {
        this.isLandScape = z;
    }

    public void setLinkType(int i) {
        this.linkType = i;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public void setLoadedUrls(List<String> list) {
        this.LoadedUrls = list;
    }

    public void setLoadingShowTime(int i) {
        this.loadingShowTime = i;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public void setMorePics(List<String> list) {
        this.morePics = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpenlinkType(int i) {
        this.openlinkType = i;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setPositionId(int i) {
        this.positionId = i;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public void setRadioId(long j) {
        this.radioId = j;
    }

    public void setRealLink(String str) {
        this.realLink = str;
    }

    public void setRecSrc(String str) {
        this.recSrc = str;
    }

    public void setRecTrack(String str) {
        this.recTrack = str;
    }

    public void setResponseId(long j) {
        this.responseId = j;
    }

    public void setScheduleId(long j) {
        this.scheduleId = j;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setShareData(AdShareDataForOpenSDK adShareDataForOpenSDK) {
        this.shareData = adShareDataForOpenSDK;
    }

    public void setShareFlag(boolean z) {
        this.isShareFlag = z;
    }

    public void setShowTime(int i) {
        this.showTime = i;
    }

    public void setShowTokens(List<String> list) {
        this.showTokens = list;
    }

    public void setShowUrls(List<String> list) {
        this.showUrls = list;
    }

    public void setShowstyle(int i) {
        this.showstyle = i;
    }

    public void setSoundType(int i) {
        this.soundType = i;
    }

    public void setSoundUrl(String str) {
        this.soundUrl = str;
    }

    public void setStartAt(long j) {
        this.startAt = j;
    }

    public void setSubCover(String str) {
        this.subCover = str;
    }

    public void setSubName(String str) {
        this.subName = str;
    }

    public void setTempToken(String str) {
        this.tempToken = str;
    }

    public void setThirdClickStatUrls(List<String> list) {
        this.thirdClickStatUrls = list;
    }

    public void setThirdShowStatUrls(List<String> list) {
        this.thirdShowStatUrls = list;
    }

    public void setThirdStatUrl(String str) {
        this.thirdStatUrl = str;
    }

    public void setTrackId(long j) {
        this.trackId = j;
    }

    public void setVideoCover(String str) {
        this.videoCover = str;
    }

    public void setVolume(int i) {
        this.volume = i;
    }

    public void setWordOfMouth(boolean z) {
        this.isWordOfMouth = z;
    }

    public void setXmul(boolean z) {
        this.xmul = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Advertis [adid=");
        stringBuilder.append(this.adid);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", clickType=");
        stringBuilder.append(this.clickType);
        stringBuilder.append(", linkUrl=");
        stringBuilder.append(this.linkUrl);
        stringBuilder.append(", imageUrl=");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append(", soundType=");
        stringBuilder.append(this.soundType);
        stringBuilder.append(", logoUrl=");
        stringBuilder.append(this.logoUrl);
        stringBuilder.append(", soundUrl=");
        stringBuilder.append(this.soundUrl);
        stringBuilder.append(", thirdStatUrl=");
        stringBuilder.append(this.thirdStatUrl);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.adid);
        parcel.writeString(this.name);
        parcel.writeInt(this.clickType);
        parcel.writeString(this.linkUrl);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.soundUrl);
        parcel.writeString(this.thirdStatUrl);
        parcel.writeInt(this.interactiveType);
        parcel.writeInt(this.countDown);
        parcel.writeInt(this.quantity);
        parcel.writeInt(this.soundType);
        parcel.writeString(this.iconStyle);
        parcel.writeString(this.jumpType);
        parcel.writeLong(this.trackId);
        parcel.writeParcelable(this.shareData, i);
        parcel.writeInt(this.isShareFlag);
        parcel.writeInt(this.duringPlay);
        parcel.writeInt(this.adtype);
        parcel.writeInt(this.clickable);
        parcel.writeString(this.realLink);
        parcel.writeStringList(this.clickTokens);
        parcel.writeStringList(this.showTokens);
        parcel.writeString(this.recSrc);
        parcel.writeString(this.recTrack);
        parcel.writeLong(this.responseId);
        parcel.writeInt(this.xmul);
        parcel.writeLong(this.adSoundTime);
        parcel.writeString(this.adMark);
        parcel.writeString(this.description);
        parcel.writeInt(this.isLandScape);
        parcel.writeStringList(this.thirdShowStatUrls);
        parcel.writeStringList(this.thirdClickStatUrls);
        parcel.writeLong(this.radioId);
        parcel.writeLong(this.scheduleId);
        parcel.writeString(this.subCover);
        parcel.writeString(this.subName);
        parcel.writeInt(this.positionId);
        parcel.writeInt(this.isInternal);
        parcel.writeStringList(this.morePics);
        parcel.writeString(this.dynamicImage);
        parcel.writeInt(this.isWordOfMouth);
        parcel.writeString(this.adpr);
    }
}
