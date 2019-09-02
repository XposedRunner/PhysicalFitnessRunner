package com.zjwh.android_wh_physicalfitness.service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;

@TargetApi(21)
public class DaemonJobService extends JobService {
    private static final String O000000o = "DaemonJobService";

    public boolean onStartJob(JobParameters jobParameters) {
        if (!O00Oo0.O000000o(RunLocationService.O00000oO)) {
            sendBroadcast(new Intent(RunLocationService.O00000oO));
        }
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
