package com.ximalaya.ting.android.opensdk.model.history;

import com.google.gson.annotations.SerializedName;

public class PlayHistoryRadio {
    @SerializedName("program_name")
    private String programName;
    @SerializedName("radio_cover_url_Large")
    private String radioCoverUrlLarge;
    @SerializedName("radio_cover_url_small")
    private String radioCoverUrlSmall;
    @SerializedName("radio_id")
    private String radioId;
    @SerializedName("radio_name")
    private String radioName;
    @SerializedName("schedule_id")
    private long scheduleId;

    public String getProgramName() {
        return this.programName;
    }

    public String getRadioCoverUrlLarge() {
        return this.radioCoverUrlLarge;
    }

    public String getRadioCoverUrlSmall() {
        return this.radioCoverUrlSmall;
    }

    public String getRadioId() {
        return this.radioId;
    }

    public String getRadioName() {
        return this.radioName;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public void setProgramName(String str) {
        this.programName = str;
    }

    public void setRadioCoverUrlLarge(String str) {
        this.radioCoverUrlLarge = str;
    }

    public void setRadioCoverUrlSmall(String str) {
        this.radioCoverUrlSmall = str;
    }

    public void setRadioId(String str) {
        this.radioId = str;
    }

    public void setRadioName(String str) {
        this.radioName = str;
    }

    public void setScheduleId(long j) {
        this.scheduleId = j;
    }
}
