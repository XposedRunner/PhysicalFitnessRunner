package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.tag.Tag;
import com.ximalaya.ting.android.opensdk.model.tag.TagList;
import java.util.List;

class CommonRequest$92 implements CommonRequest$IRequestCallBack<TagList> {
    CommonRequest$92() {
    }

    public TagList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Tag>>() {
        }.getType(), str);
        TagList tagList = new TagList();
        tagList.setTagList(list);
        return tagList;
    }
}
