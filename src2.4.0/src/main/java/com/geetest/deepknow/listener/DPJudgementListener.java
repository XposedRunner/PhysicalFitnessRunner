package com.geetest.deepknow.listener;

import org.json.JSONObject;

public interface DPJudgementListener {
    void onDeepKnowResult(JSONObject jSONObject);

    void onError(String str, String str2);
}
