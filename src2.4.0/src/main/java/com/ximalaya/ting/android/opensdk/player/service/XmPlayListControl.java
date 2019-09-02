package com.ximalaya.ting.android.opensdk.player.service;

import android.os.RemoteException;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.track.CommonTrackList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.constants.PlayerConstants;
import com.ximalaya.ting.android.opensdk.util.BaseUtil;
import com.ximalaya.ting.android.opensdk.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class XmPlayListControl {
    public static final int PLAY_SOURCE_NONE = 1;
    public static final int PLAY_SOURCE_RADIO = 3;
    public static final int PLAY_SOURCE_TRACK = 2;
    public static final String POSITIVE_SEQ = "positive_seq";
    private static final String TAG = "XmPlayListControl";
    private boolean isAsc = true;
    private volatile int mCurrIndex = -1;
    private PlayableModel mCurrModel;
    private int mCurrSize;
    private IXmDataCallback mDataCallback;
    private int mLastIndex = -1;
    private PlayableModel mLastModel;
    private boolean mLoading = false;
    private int mNextPageId;
    private int mPageSize;
    private Map<String, String> mParam;
    private List<Track> mPlayList = new ArrayList();
    private PlayMode mPlayMode = PlayMode.PLAY_MODEL_LIST;
    private int mPlaySource = 1;
    private boolean mPositiveSeq = true;
    private int mPrePageId;
    private int mTotalPage;
    private CommonRequest mXimalaya = CommonRequest.getInstanse();

    public enum PlayMode {
        PLAY_MODEL_SINGLE,
        PLAY_MODEL_SINGLE_LOOP,
        PLAY_MODEL_LIST,
        PLAY_MODEL_LIST_LOOP,
        PLAY_MODEL_RANDOM;

        public static PlayMode getIndex(int i) {
            return i == PLAY_MODEL_SINGLE.ordinal() ? PLAY_MODEL_SINGLE : i == PLAY_MODEL_SINGLE_LOOP.ordinal() ? PLAY_MODEL_SINGLE_LOOP : i == PLAY_MODEL_LIST.ordinal() ? PLAY_MODEL_LIST : i == PLAY_MODEL_LIST_LOOP.ordinal() ? PLAY_MODEL_LIST_LOOP : i == PLAY_MODEL_RANDOM.ordinal() ? PLAY_MODEL_RANDOM : PLAY_MODEL_LIST;
        }
    }

    private boolean checkListType(Map<String, String> map) {
        if (map == null || this.mParam == null) {
            return false;
        }
        int i = 1;
        for (Entry entry : map.entrySet()) {
            i &= ((String) entry.getValue()).equals(this.mParam.get((String) entry.getKey()));
        }
        return i;
    }

    private void dataCallbackOnError(int i, String str, boolean z) {
        if (this.mDataCallback != null) {
            try {
                this.mDataCallback.onError(i, str, z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private int getRadioNextIndex() {
        return -1;
    }

    private int getRadioPreIndex() {
        return -1;
    }

    private int getTrackNextIndex(boolean z) {
        int i;
        PlayMode playMode = this.mPlayMode;
        if (z && playMode == PlayMode.PLAY_MODEL_SINGLE_LOOP) {
            playMode = PlayMode.PLAY_MODEL_LIST;
        }
        switch (playMode) {
            case PLAY_MODEL_LIST:
                i = this.mCurrIndex + 1;
                if (needLoadNextPage(i)) {
                    loadNextPageSync();
                }
                if (i >= this.mCurrSize) {
                    return -1;
                }
                break;
            case PLAY_MODEL_LIST_LOOP:
                i = this.mCurrIndex + 1;
                if (needLoadNextPage(i)) {
                    loadNextPageSync();
                }
                if (i >= this.mCurrSize) {
                    i = 0;
                    break;
                }
                break;
            case PLAY_MODEL_SINGLE_LOOP:
                return this.mCurrIndex;
            case PLAY_MODEL_RANDOM:
                int random = (int) (Math.random() * ((double) this.mCurrSize));
                i = this.mCurrIndex;
                return random;
            default:
                return -1;
        }
        return i;
    }

    private int getTrackPreIndex() {
        int i;
        PlayMode playMode = this.mPlayMode;
        if (playMode == PlayMode.PLAY_MODEL_SINGLE_LOOP) {
            playMode = PlayMode.PLAY_MODEL_LIST;
        }
        switch (playMode) {
            case PLAY_MODEL_LIST:
                i = this.mCurrIndex - 1;
                if (needLoadPrePage(i)) {
                    loadPrePageSync();
                }
                if (i < 0) {
                    return -1;
                }
                break;
            case PLAY_MODEL_LIST_LOOP:
                i = this.mCurrIndex - 1;
                if (needLoadPrePage(i)) {
                    loadPrePageSync();
                }
                if (i < 0) {
                    i = this.mCurrSize - 1;
                    break;
                }
                break;
            case PLAY_MODEL_SINGLE_LOOP:
                return this.mCurrIndex;
            case PLAY_MODEL_RANDOM:
                int random = (int) (Math.random() * ((double) this.mCurrSize));
                i = this.mCurrIndex;
                return random;
            default:
                return -1;
        }
        return i;
    }

    private void loadNextPageSync() {
        Logger.i(TAG, "loadNextPageSync");
        if (this.mLoading || this.mParam == null) {
            dataCallbackOnError(400, "加载失败", this.mPositiveSeq);
            return;
        }
        this.mLoading = true;
        Map map = this.mParam;
        String str = DTransferConstants.PAGE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.mNextPageId + 1);
        map.put(str, stringBuilder.toString());
        if (!this.mParam.containsKey(DTransferConstants.PAGE_SIZE)) {
            Map map2 = this.mParam;
            String str2 = DTransferConstants.PAGE_SIZE;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(this.mXimalaya.getDefaultPagesize());
            map2.put(str2, stringBuilder2.toString());
        }
        CommonRequest.getTrackList(this.mParam, new IDataCallBack<CommonTrackList>() {
            public void onError(int i, String str) {
                String str2 = XmPlayListControl.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("CommonRequest.getTrackList 获取播放器下一页数据 onError ");
                stringBuilder.append(i);
                stringBuilder.append(", ");
                stringBuilder.append(str);
                Logger.i(str2, stringBuilder.toString());
                XmPlayListControl.this.mLoading = false;
                XmPlayListControl.this.dataCallbackOnError(i, str, XmPlayListControl.this.mPositiveSeq);
            }

            public void onSuccess(CommonTrackList commonTrackList) {
                XmPlayListControl.this.mLoading = false;
                Logger.i(XmPlayListControl.TAG, "CommonRequest.getTrackList 获取播放器下一页数据");
                if (commonTrackList == null) {
                    XmPlayListControl.this.dataCallbackOnError(400, "加载失败", XmPlayListControl.this.mPositiveSeq);
                    return;
                }
                XmPlayListControl.this.mTotalPage = commonTrackList.getTotalPage();
                List tracks = commonTrackList.getTracks();
                if (tracks == null || tracks.size() == 0) {
                    XmPlayListControl.this.dataCallbackOnError(400, "加载失败", XmPlayListControl.this.mPositiveSeq);
                    return;
                }
                XmPlayListControl.this.mNextPageId = XmPlayListControl.this.mNextPageId + 1;
                synchronized (XmPlayListControl.this.mPlayList) {
                    if (XmPlayListControl.this.mPositiveSeq) {
                        XmPlayListControl.this.mPlayList.addAll(tracks);
                    } else {
                        Collections.reverse(tracks);
                        XmPlayListControl.this.mPlayList.addAll(0, tracks);
                        XmPlayListControl.this.mCurrIndex = XmPlayListControl.this.mCurrIndex + tracks.size();
                    }
                    XmPlayListControl.this.mCurrSize = XmPlayListControl.this.mPlayList.size();
                }
                boolean hasNextPage = XmPlayListControl.this.hasNextPage();
                if (XmPlayListControl.this.mDataCallback != null) {
                    try {
                        XmPlayListControl.this.mDataCallback.onDataReady(tracks, hasNextPage, XmPlayListControl.this.mPositiveSeq);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        XmPlayListControl.this.dataCallbackOnError(400, "加载失败", XmPlayListControl.this.mPositiveSeq);
                    }
                }
            }
        });
    }

    private void loadPrePageSync() {
        Logger.i(TAG, "loadPrePageSync");
        if (this.mLoading || this.mParam == null) {
            dataCallbackOnError(400, "加载失败", 1 ^ this.mPositiveSeq);
            return;
        }
        this.mLoading = true;
        Map map = this.mParam;
        String str = DTransferConstants.PAGE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.mPrePageId);
        map.put(str, stringBuilder.toString());
        if (!this.mParam.containsKey(DTransferConstants.PAGE_SIZE)) {
            map = this.mParam;
            str = DTransferConstants.PAGE_SIZE;
            stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(this.mXimalaya.getDefaultPagesize());
            map.put(str, stringBuilder.toString());
        }
        CommonRequest.getTrackList(this.mParam, new IDataCallBack<CommonTrackList>() {
            public void onError(int i, String str) {
                String str2 = XmPlayListControl.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("CommonRequest.getTrackList 获取播放器下一页数据 onError ");
                stringBuilder.append(i);
                stringBuilder.append(", ");
                stringBuilder.append(str);
                Logger.i(str2, stringBuilder.toString());
                XmPlayListControl.this.mLoading = false;
                XmPlayListControl.this.dataCallbackOnError(i, str, XmPlayListControl.this.mPositiveSeq ^ 1);
            }

            public void onSuccess(CommonTrackList commonTrackList) {
                Logger.i(XmPlayListControl.TAG, "CommonRequest.getTrackList 获取播放器下一页数据");
                XmPlayListControl.this.mLoading = false;
                if (commonTrackList == null) {
                    XmPlayListControl.this.dataCallbackOnError(400, "加载失败", XmPlayListControl.this.mPositiveSeq ^ 1);
                    return;
                }
                XmPlayListControl.this.mTotalPage = commonTrackList.getTotalPage();
                List tracks = commonTrackList.getTracks();
                if (tracks == null || tracks.size() == 0) {
                    XmPlayListControl.this.dataCallbackOnError(400, "加载失败", XmPlayListControl.this.mPositiveSeq ^ 1);
                    return;
                }
                XmPlayListControl.this.mPrePageId = XmPlayListControl.this.mPrePageId - 1;
                synchronized (XmPlayListControl.this.mPlayList) {
                    if (XmPlayListControl.this.mPositiveSeq) {
                        XmPlayListControl.this.mPlayList.addAll(0, tracks);
                        XmPlayListControl.this.mCurrIndex = XmPlayListControl.this.mCurrIndex + tracks.size();
                    } else {
                        Collections.reverse(tracks);
                        XmPlayListControl.this.mPlayList.addAll(tracks);
                    }
                }
                XmPlayListControl.this.mCurrSize = XmPlayListControl.this.mPlayList.size();
                boolean hasPrePage = XmPlayListControl.this.hasPrePage();
                if (XmPlayListControl.this.mDataCallback != null) {
                    try {
                        XmPlayListControl.this.mDataCallback.onDataReady(tracks, hasPrePage, XmPlayListControl.this.mPositiveSeq ^ 1);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        XmPlayListControl.this.dataCallbackOnError(400, "加载失败", XmPlayListControl.this.mPositiveSeq);
                    }
                }
            }
        });
    }

    private boolean needLoadNextPage(int i) {
        if (this.mParam == null || PlayerConstants.PRE_LOAD_INDEX + i < this.mCurrSize || !hasNextPage()) {
            return false;
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("needLoadNextPage currPage:");
        stringBuilder.append(this.mNextPageId);
        stringBuilder.append(", currPageSize:");
        stringBuilder.append(this.mPageSize);
        stringBuilder.append(", next:");
        stringBuilder.append(i);
        Logger.i(str, stringBuilder.toString());
        return true;
    }

    private boolean needLoadPrePage(int i) {
        if (this.mParam == null || i - PlayerConstants.PRE_LOAD_INDEX > 0 || !hasPrePage()) {
            return false;
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("needLoadNextPage currPage:");
        stringBuilder.append(this.mNextPageId);
        stringBuilder.append(", currPageSize:");
        stringBuilder.append(this.mPageSize);
        stringBuilder.append(", next:");
        stringBuilder.append(i);
        Logger.i(str, stringBuilder.toString());
        return true;
    }

    public void addPlayList(List<Track> list) {
        synchronized (this.mPlayList) {
            if (this.mPlayList == null) {
                this.mPlayList = new ArrayList();
            }
            this.mPlayList.addAll(list);
            this.mCurrSize = this.mPlayList.size();
            if (this.mPlayList.contains(this.mCurrModel)) {
                this.mCurrIndex = this.mPlayList.indexOf(this.mCurrModel);
            }
        }
    }

    public int getCurrIndex() {
        return this.mCurrIndex;
    }

    public int getCurrListSize() {
        return this.mCurrSize;
    }

    public PlayableModel getCurrentPlayableModel() {
        return this.mCurrModel;
    }

    public int getLastIndex() {
        return this.mLastIndex;
    }

    public Radio getLastRadio() {
        return this.mLastModel instanceof Radio ? (Radio) this.mLastModel : null;
    }

    public int getNextIndex(boolean z) {
        return (this.mPlaySource != 3 && this.mPlaySource == 2) ? getTrackNextIndex(z) : -1;
    }

    public void getNextPlayList(boolean z) {
        if (!this.mPositiveSeq && !z) {
            getPrePlayList(true);
        } else if (hasNextPage()) {
            if (this.mParam == null || this.mLoading) {
                dataCallbackOnError(400, "加载失败", this.mPositiveSeq);
            } else {
                loadNextPageSync();
            }
        } else {
            if (this.mDataCallback != null) {
                try {
                    this.mDataCallback.onDataReady(null, false, this.mPositiveSeq);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Track getNextPlayTrack() {
        return (this.mCurrIndex < 0 || this.mCurrIndex + 1 >= this.mPlayList.size()) ? null : (Track) this.mPlayList.get(this.mCurrIndex + 1);
    }

    public Map<String, String> getParams() {
        if (this.mParam == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.mParam);
        String str = DTransferConstants.PRE_PAGE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mPrePageId);
        stringBuilder.append("");
        hashMap.put(str, stringBuilder.toString());
        str = DTransferConstants.PAGE;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.mNextPageId);
        stringBuilder.append("");
        hashMap.put(str, stringBuilder.toString());
        str = POSITIVE_SEQ;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.mPositiveSeq);
        stringBuilder.append("");
        hashMap.put(str, stringBuilder.toString());
        str = DTransferConstants.TOTAL_PAGE;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.mTotalPage);
        stringBuilder.append("");
        hashMap.put(str, stringBuilder.toString());
        str = DTransferConstants.LOCAL_IS_ASC;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.isAsc);
        stringBuilder.append("");
        hashMap.put(str, stringBuilder.toString());
        return hashMap;
    }

    public List<Track> getPlayList() {
        return this.mPlayList;
    }

    public boolean getPlayListOrder() {
        return this.isAsc;
    }

    public PlayMode getPlayMode() {
        return this.mPlayMode;
    }

    public int getPlaySource() {
        if (getCurrentPlayableModel() == null) {
            return 1;
        }
        Track track = (Track) getCurrentPlayableModel();
        if (TextUtils.isEmpty(track.getKind())) {
            return 1;
        }
        if ("radio".endsWith(track.getKind())) {
            this.mPlaySource = 3;
        } else if ("track".endsWith(track.getKind())) {
            this.mPlaySource = 2;
        } else if ("schedule".endsWith(track.getKind())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(track.getStartTime());
            stringBuilder.append("-");
            stringBuilder.append(track.getEndTime());
            String stringBuilder2 = stringBuilder.toString();
            if (BaseUtil.isInTime(stringBuilder2) == 0) {
                this.mPlaySource = 3;
            } else if (BaseUtil.isInTime(stringBuilder2) == -1) {
                this.mPlaySource = 2;
            }
        }
        return this.mPlaySource;
    }

    public PlayableModel getPlayableModel(int i) {
        return (this.mPlayList == null || this.mPlayList.size() <= 0 || i < 0 || i >= this.mPlayList.size()) ? null : (PlayableModel) this.mPlayList.get(i);
    }

    public int getPreIndex() {
        return getTrackPreIndex();
    }

    public void getPrePlayList(boolean z) {
        if (!this.mPositiveSeq && !z) {
            getNextPlayList(true);
        } else if (hasPrePage()) {
            if (this.mParam == null || this.mLoading) {
                dataCallbackOnError(400, "加载失败", 1 ^ this.mPositiveSeq);
            } else {
                loadPrePageSync();
            }
        } else {
            if (this.mDataCallback != null) {
                try {
                    this.mDataCallback.onDataReady(null, false, 1 ^ this.mPositiveSeq);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Radio getRadio() {
        return this.mCurrModel instanceof Radio ? (Radio) this.mCurrModel : null;
    }

    /* Access modifiers changed, original: protected */
    public boolean hasNextPage() {
        boolean z = false;
        if (this.mTotalPage <= 0) {
            return false;
        }
        if (this.mNextPageId < this.mTotalPage) {
            z = true;
        }
        return z;
    }

    /* Access modifiers changed, original: protected */
    public boolean hasPrePage() {
        boolean z = false;
        if (this.mTotalPage <= 0) {
            return false;
        }
        if (this.mPrePageId < this.mTotalPage && this.mPrePageId > 0) {
            z = true;
        }
        return z;
    }

    public void insertPlayListHead(List<Track> list) {
        synchronized (this.mPlayList) {
            if (this.mPlayList == null) {
                this.mPlayList = new ArrayList();
            }
            this.mPlayList.addAll(0, list);
            this.mCurrSize = this.mPlayList.size();
            if (this.mPlayList.contains(this.mCurrModel)) {
                this.mCurrIndex = this.mPlayList.indexOf(this.mCurrModel);
            }
        }
    }

    public boolean isLoading() {
        return this.mLoading;
    }

    public synchronized boolean permutePlayList() {
        this.isAsc ^= 1;
        this.mPositiveSeq ^= 1;
        if (this.mPlayList != null && this.mPlayList.size() > 0) {
            Collections.reverse(this.mPlayList);
            if (this.mCurrModel != null) {
                this.mCurrIndex = this.mPlayList.indexOf(this.mCurrModel);
            }
            if (this.mLastModel != null) {
                this.mLastIndex = this.mPlayList.indexOf(this.mLastModel);
            }
        }
        return true;
    }

    public void removeListByIndex(int i) {
        if (this.mPlayList != null && this.mPlayList.size() >= i) {
            this.mPlayList.remove(i);
            switch (this.mPlayMode) {
                case PLAY_MODEL_LIST:
                case PLAY_MODEL_LIST_LOOP:
                    if (i <= this.mCurrIndex) {
                        this.mCurrIndex--;
                        break;
                    }
                    break;
            }
            this.mCurrSize--;
        }
    }

    public void resetPlayList() {
        synchronized (this.mPlayList) {
            this.mParam = null;
            this.mPlayList.clear();
            this.mNextPageId = 0;
            this.mPrePageId = 0;
            this.mPageSize = 0;
            this.mTotalPage = 0;
            this.mCurrIndex = -1;
            this.mCurrSize = 0;
            this.mLastIndex = -1;
            this.mCurrModel = null;
            this.mLastModel = null;
            this.mPositiveSeq = true;
        }
    }

    public void setCurrIndex(int i) {
        if (i != this.mCurrIndex) {
            this.mLastIndex = this.mCurrIndex;
            this.mCurrIndex = i;
            this.mLastModel = this.mCurrModel;
        }
        this.mCurrModel = getPlayableModel(this.mCurrIndex);
        if (needLoadNextPage(i + 1)) {
            loadNextPageSync();
        }
        if (needLoadPrePage(i - 1)) {
            loadPrePageSync();
        }
    }

    public void setPlayList(Map<String, String> map, List<Track> list) {
        Map map2;
        if (map2 != null) {
            if (map2.containsKey(DTransferConstants.LOCAL_IS_ASC)) {
                this.isAsc = Boolean.parseBoolean((String) map2.remove(DTransferConstants.LOCAL_IS_ASC));
            } else {
                if (map2.containsKey("asc")) {
                    this.isAsc = Boolean.parseBoolean((String) map2.get("asc"));
                }
                if (map2.containsKey("isAsc")) {
                    this.isAsc = Boolean.parseBoolean((String) map2.get("isAsc"));
                }
            }
            if (!map2.containsKey(DTransferConstants.TRACK_BASE_URL)) {
                map2 = null;
            }
        }
        this.mPlaySource = 2;
        resetPlayList();
        synchronized (this.mPlayList) {
            this.mTotalPage = 0;
            this.mParam = map2;
            if (this.mParam != null) {
                if (map2.containsKey("trackId")) {
                    map2.remove("trackId");
                }
                String str = (String) this.mParam.remove(POSITIVE_SEQ);
                if (!TextUtils.isEmpty(str)) {
                    this.mPositiveSeq = Boolean.valueOf(str).booleanValue();
                }
                if (!this.mParam.containsKey(DTransferConstants.TOTAL_PAGE) || this.mParam.get(DTransferConstants.TOTAL_PAGE) == null) {
                    this.mTotalPage = 0;
                } else {
                    this.mTotalPage = Integer.valueOf((String) this.mParam.remove(DTransferConstants.TOTAL_PAGE)).intValue() + 1;
                }
                if (!this.mParam.containsKey(DTransferConstants.PAGE_SIZE) || this.mParam.get(DTransferConstants.PAGE_SIZE) == null) {
                    this.mPageSize = 0;
                } else {
                    this.mPageSize = Integer.valueOf((String) this.mParam.get(DTransferConstants.PAGE_SIZE)).intValue();
                }
                if (this.mPageSize <= 0) {
                    this.mPageSize = this.mXimalaya.getDefaultPagesize();
                }
                if (!this.mParam.containsKey(DTransferConstants.PAGE) || this.mParam.get(DTransferConstants.PAGE) == null) {
                    this.mNextPageId = 0;
                } else {
                    this.mNextPageId = Integer.valueOf((String) this.mParam.get(DTransferConstants.PAGE)).intValue();
                }
                if (this.mNextPageId <= 0) {
                    this.mNextPageId = list.size() / this.mPageSize;
                }
                if (!this.mParam.containsKey(DTransferConstants.PRE_PAGE) || this.mParam.get(DTransferConstants.PRE_PAGE) == null) {
                    this.mPrePageId = 0;
                } else {
                    this.mPrePageId = Integer.valueOf((String) this.mParam.get(DTransferConstants.PRE_PAGE)).intValue();
                    if (this.mPrePageId < 0) {
                        this.mPrePageId = 0;
                    }
                }
            } else {
                this.mPageSize = 0;
                this.mNextPageId = 0;
                this.mPrePageId = 0;
            }
            this.mPlayList.clear();
            this.mPlayList.addAll(list);
            this.mCurrSize = this.mPlayList.size();
            if (this.mPlayList.contains(this.mCurrModel)) {
                this.mCurrIndex = this.mPlayList.indexOf(this.mCurrModel);
            } else {
                this.mCurrIndex = -1;
            }
        }
    }

    public void setPlayListChangeListener(IXmDataCallback iXmDataCallback) {
        this.mDataCallback = iXmDataCallback;
    }

    public PlayMode setPlayMode(PlayMode playMode) {
        this.mPlayMode = playMode;
        return playMode;
    }

    public void setRadio(Radio radio) {
        if (radio != null) {
            if (this.mPlaySource != 3) {
                resetPlayList();
                this.mPlaySource = 3;
            }
            if (!radio.equals(this.mCurrModel)) {
                this.mLastModel = this.mCurrModel;
                this.mCurrModel = radio;
            }
        }
    }

    public void updateTrackInPlayList(int i, Track track) {
        getPlayList().set(i, track);
        if (this.mCurrModel != null && track != null && this.mCurrModel.getDataId() == track.getDataId()) {
            this.mCurrModel = track;
        }
    }
}
