package com.ximalaya.ting.android.opensdk.util;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.album.Announcer;
import com.ximalaya.ting.android.opensdk.model.live.program.Program;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.live.schedule.LiveAnnouncer;
import com.ximalaya.ting.android.opensdk.model.live.schedule.Schedule;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ModelUtil {
    static SimpleDateFormat format = new SimpleDateFormat("yy:MM:dd:HH:mm");

    public static LiveAnnouncer announcerToLiveAnnouncer(Announcer announcer) {
        if (announcer == null) {
            return null;
        }
        LiveAnnouncer liveAnnouncer = new LiveAnnouncer();
        liveAnnouncer.setLiveAnnouncerId(announcer.getAnnouncerId());
        liveAnnouncer.setNickName(announcer.getNickname());
        liveAnnouncer.setAvatarUrl(announcer.getAvatarUrl());
        return liveAnnouncer;
    }

    public static Announcer liveAnnouncerToAnnouncer(LiveAnnouncer liveAnnouncer) {
        if (liveAnnouncer == null) {
            return null;
        }
        Announcer announcer = new Announcer();
        announcer.setAnnouncerId(liveAnnouncer.getLiveAnnouncerId());
        announcer.setNickname(liveAnnouncer.getNickName());
        announcer.setAvatarUrl(liveAnnouncer.getAvatarUrl());
        return announcer;
    }

    public static Schedule radioToSchedule(Radio radio) {
        if (radio == null) {
            return null;
        }
        Schedule schedule = new Schedule();
        schedule.setKind("radio");
        String str = BaseUtil.getYDTDayNum()[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(":00:00");
        schedule.setStartTime(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(":23:59");
        schedule.setEndTime(stringBuilder.toString());
        Program program = new Program();
        program.setBackPicUrl(radio.getCoverUrlLarge());
        program.setRate24AacUrl(radio.getRate24AacUrl());
        program.setRate24TsUrl(radio.getRate24TsUrl());
        program.setRate64AacUrl(radio.getRate64AacUrl());
        program.setRate64TsUrl(radio.getRate64TsUrl());
        program.setProgramName(radio.getRadioName());
        schedule.setDataId(radio.getDataId());
        schedule.setRelatedProgram(program);
        schedule.setRadioId(radio.getDataId());
        schedule.setRadioName(radio.getRadioName());
        schedule.setRadioPlayCount(radio.getRadioPlayCount());
        return schedule;
    }

    public static Track radioToTrack(Radio radio, boolean z) {
        if (radio == null) {
            return null;
        }
        Track track = new Track();
        track.setDataId(radio.getDataId());
        track.setKind("radio");
        track.setTrackTitle(radio.getRadioName());
        track.setTrackIntro(radio.getRadioDesc());
        track.setScheduleId(radio.getScheduleID());
        track.setRadioRate24AacUrl(radio.getRate24AacUrl());
        track.setRadioRate24TsUrl(radio.getRate24TsUrl());
        track.setRadioRate64AacUrl(radio.getRate64AacUrl());
        track.setRadioRate64TsUrl(radio.getRate64TsUrl());
        track.setPlayCount(radio.getRadioPlayCount());
        track.setCoverUrlLarge(radio.getCoverUrlLarge());
        track.setCoverUrlSmall(radio.getCoverUrlSmall());
        track.setUpdatedAt(radio.getUpdateAt());
        track.setPlayCount(radio.getRadioPlayCount());
        track.setExtra(z);
        try {
            track.setStartTime(format.format(new Date(radio.getStartTime())));
            track.setEndTime(format.format(new Date(radio.getEndTime())));
        } catch (Exception unused) {
        }
        track.setTrackActivityId(radio.getActivityId());
        return track;
    }

    public static Track scheduleToTrack(Schedule schedule) {
        if (schedule == null) {
            return null;
        }
        Track track = new Track();
        track.setStartTime(schedule.getStartTime());
        track.setEndTime(schedule.getEndTime());
        track.setKind("schedule");
        track.setPlayUrl32(schedule.getListenBackUrl());
        track.setPlayUrl64(schedule.getListenBackUrl());
        track.setDataId(schedule.getDataId());
        Program relatedProgram = schedule.getRelatedProgram();
        track.setProgramId(relatedProgram.getProgramId());
        track.setScheduleId(schedule.getDataId());
        track.setTrackTitle(relatedProgram.getProgramName());
        track.setCoverUrlLarge(relatedProgram.getBackPicUrl());
        track.setCoverUrlMiddle(relatedProgram.getBackPicUrl());
        track.setCoverUrlSmall(relatedProgram.getBackPicUrl());
        track.setRadioRate24AacUrl(relatedProgram.getRate24AacUrl());
        track.setRadioRate24TsUrl(relatedProgram.getRate24TsUrl());
        track.setRadioRate64AacUrl(relatedProgram.getRate64AacUrl());
        track.setRadioRate64TsUrl(relatedProgram.getRate64TsUrl());
        track.setUpdatedAt(relatedProgram.getUpdateAt());
        track.setRadioId(schedule.getRadioId());
        track.setRadioName(schedule.getRadioName());
        track.setPlayCount(schedule.getRadioPlayCount());
        if (relatedProgram.getAnnouncerList() != null && relatedProgram.getAnnouncerList().size() > 0) {
            track.setAnnouncer(liveAnnouncerToAnnouncer((LiveAnnouncer) relatedProgram.getAnnouncerList().get(0)));
        }
        return track;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static List<Track> toTrackList(List<Schedule> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Schedule scheduleToTrack : list) {
            arrayList.add(scheduleToTrack(scheduleToTrack));
        }
        return arrayList;
    }

    public static Radio trackToRadio(Track track) {
        if (track == null) {
            return null;
        }
        Radio radio = new Radio();
        radio.setDataId(track.getDataId());
        radio.setKind("radio");
        radio.setRadioName(track.getTrackTitle());
        radio.setScheduleID(track.getScheduleId());
        radio.setRate24AacUrl(track.getRadioRate24AacUrl());
        radio.setRate24TsUrl(track.getRadioRate24TsUrl());
        radio.setRate64AacUrl(track.getRadioRate64AacUrl());
        radio.setRate64TsUrl(track.getRadioRate64TsUrl());
        radio.setRadioPlayCount(track.getPlayCount());
        radio.setCoverUrlSmall(track.getCoverUrlSmall());
        radio.setCoverUrlLarge(track.getCoverUrlLarge());
        radio.setUpdateAt(track.getUpdatedAt());
        radio.setRadioPlayCount(track.getPlayCount());
        radio.setRadioDesc(track.getTrackIntro());
        radio.setActivityLive(track.getExtra());
        try {
            radio.setStartTime(format.parse(track.getStartTime()).getTime());
            radio.setEndTime(format.parse(track.getEndTime()).getTime());
        } catch (Exception unused) {
        }
        radio.setActivityId(track.getTrackActivityId());
        return radio;
    }

    public static Schedule trackToSchedule(Track track) {
        if (track == null) {
            return null;
        }
        Schedule schedule = new Schedule();
        schedule.setDataId(track.getDataId());
        schedule.setKind("schedule");
        schedule.setStartTime(track.getStartTime());
        schedule.setEndTime(track.getEndTime());
        schedule.setUpdateAt(track.getUpdatedAt());
        schedule.setListenBackUrl(TextUtils.isEmpty(track.getPlayUrl64()) ? track.getPlayUrl32() : track.getPlayUrl64());
        Program program = new Program();
        program.setProgramId(track.getProgramId());
        program.setProgramName(track.getTrackTitle());
        program.setBackPicUrl(TextUtils.isEmpty(track.getCoverUrlSmall()) ? track.getCoverUrlLarge() : track.getCoverUrlSmall());
        program.setRate24AacUrl(track.getRadioRate24AacUrl());
        program.setRate64AacUrl(track.getRadioRate64AacUrl());
        program.setRate24TsUrl(track.getRadioRate24TsUrl());
        program.setRate64TsUrl(track.getRadioRate64TsUrl());
        if (announcerToLiveAnnouncer(track.getAnnouncer()) != null) {
            program.setAnnouncerList(new ArrayList(Arrays.asList(new LiveAnnouncer[]{announcerToLiveAnnouncer(track.getAnnouncer())})));
        }
        schedule.setRelatedProgram(program);
        schedule.setRadioId(track.getRadioId());
        schedule.setRadioName(track.getRadioName());
        schedule.setRadioPlayCount(track.getPlayCount());
        return schedule;
    }
}
