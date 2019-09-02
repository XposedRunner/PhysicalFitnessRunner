package com.ximalaya.ting.android.opensdk.model.customized;

import android.support.annotation.Nullable;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.util.ArrayList;
import java.util.List;

public class XmCustomizedModelUtil {
    public static List<Album> customizedAlbumListToAlbumList(List<ColumnAlbumItem> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ColumnAlbumItem customizedAlbumToAlbum : list) {
            arrayList.add(customizedAlbumToAlbum(customizedAlbumToAlbum));
        }
        return arrayList;
    }

    @Nullable
    public static Album customizedAlbumToAlbum(ColumnAlbumItem columnAlbumItem) {
        if (columnAlbumItem == null) {
            return null;
        }
        Album album = new Album();
        album.setId((long) columnAlbumItem.getId());
        album.setAlbumTitle(columnAlbumItem.getTitle());
        album.setCategoryId(columnAlbumItem.getCategoryId());
        album.setAlbumIntro(columnAlbumItem.getIntro());
        album.setCoverUrlLarge(columnAlbumItem.getCoverUrlLarge());
        album.setCoverUrlSmall(columnAlbumItem.getCoverUrlSmall());
        album.setCoverUrlMiddle(columnAlbumItem.getCoverUrlMiddle());
        album.setPlayCount((long) columnAlbumItem.getPlayCount());
        album.setIncludeTrackCount((long) columnAlbumItem.getIncludeTrackCount());
        album.setIsFinished(columnAlbumItem.getIsFinished());
        album.setCreatedAt(columnAlbumItem.getCreatedAt());
        album.setUpdatedAt(columnAlbumItem.getUpdatedAt());
        return album;
    }

    @Nullable
    public static List<Track> customizedTrackListToTrackList(List<ColumnItems> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ColumnItems customizedTrackToTrack : list) {
            arrayList.add(customizedTrackToTrack(customizedTrackToTrack));
        }
        return arrayList;
    }

    @Nullable
    public static Track customizedTrackToTrack(ColumnItems columnItems) {
        if (columnItems == null) {
            return null;
        }
        Track track = new Track();
        track.setKind("track");
        track.setDataId((long) columnItems.getId());
        track.setOrderNum(columnItems.getOrderNum());
        track.setTrackTitle(columnItems.getTitle());
        track.setTrackIntro(columnItems.getIntro());
        track.setCoverUrlSmall(columnItems.getCoverUrlSmall());
        track.setCoverUrlMiddle(columnItems.getCoverUrlMiddle());
        track.setCoverUrlLarge(columnItems.getCoverUrlLarge());
        track.setPlayCount(columnItems.getPlayCount());
        track.setPlaySize32((int) columnItems.getPlaySize32());
        track.setPlaySize64((int) columnItems.getPlaySize64());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(columnItems.getPlaySize24M4a());
        stringBuilder.append("");
        track.setPlaySize24M4a(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(columnItems.getPlaySize64M4());
        stringBuilder.append("");
        track.setPlaySize64m4a(stringBuilder.toString());
        track.setCanDownload(columnItems.isCanDownload());
        track.setDownloadedSize((long) columnItems.getDownloadSize());
        track.setCreatedAt(columnItems.getCreatedAt());
        track.setUpdatedAt(columnItems.getUpdatedAt());
        track.setPlayUrl32(columnItems.getPlayUrl32());
        track.setPlayUrl64(columnItems.getPlayUrl64());
        track.setPlayUrl24M4a(columnItems.getPlayUrl24M4a());
        track.setPlayUrl64M4a(columnItems.getPlayUrl64M4a());
        track.setDownloadUrl(columnItems.getDownloadUrl());
        track.setDuration(columnItems.getDuration());
        track.setAlbum(columnItems.getAlbum());
        return track;
    }
}
