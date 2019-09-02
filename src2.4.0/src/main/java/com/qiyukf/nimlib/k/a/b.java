package com.qiyukf.nimlib.k.a;

import com.qiyukf.unicorn.R;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<String, Integer> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("xls", Integer.valueOf(R.drawable.ysf_message_file_icon_xls));
        a.put("xlsx", Integer.valueOf(R.drawable.ysf_message_file_icon_xls));
        a.put("csv", Integer.valueOf(R.drawable.ysf_message_file_icon_xls));
        a.put("ppt", Integer.valueOf(R.drawable.ysf_message_file_icon_ppt));
        a.put("pptx", Integer.valueOf(R.drawable.ysf_message_file_icon_ppt));
        a.put("doc", Integer.valueOf(R.drawable.ysf_message_file_icon_doc));
        a.put("docx", Integer.valueOf(R.drawable.ysf_message_file_icon_doc));
        a.put("pdf", Integer.valueOf(R.drawable.ysf_message_file_icon_pdf));
        a.put("key", Integer.valueOf(R.drawable.ysf_message_file_icon_key));
        a.put("txt", Integer.valueOf(R.drawable.ysf_message_file_icon_txt));
        a.put("htm", Integer.valueOf(R.drawable.ysf_message_file_icon_txt));
        a.put("html", Integer.valueOf(R.drawable.ysf_message_file_icon_txt));
        a.put("zip", Integer.valueOf(R.drawable.ysf_message_file_icon_zip));
        a.put("rar", Integer.valueOf(R.drawable.ysf_message_file_icon_zip));
        a.put("7z", Integer.valueOf(R.drawable.ysf_message_file_icon_zip));
        a.put("bmp", Integer.valueOf(R.drawable.ysf_message_file_icon_jpg));
        a.put("jpg", Integer.valueOf(R.drawable.ysf_message_file_icon_jpg));
        a.put("jpeg", Integer.valueOf(R.drawable.ysf_message_file_icon_jpg));
        a.put("png", Integer.valueOf(R.drawable.ysf_message_file_icon_jpg));
        a.put("gif", Integer.valueOf(R.drawable.ysf_message_file_icon_jpg));
        a.put("exif", Integer.valueOf(R.drawable.ysf_message_file_icon_jpg));
        a.put("mp3", Integer.valueOf(R.drawable.ysf_message_file_icon_mp3));
        a.put("wma", Integer.valueOf(R.drawable.ysf_message_file_icon_mp3));
        a.put("ape", Integer.valueOf(R.drawable.ysf_message_file_icon_mp3));
        a.put("flac", Integer.valueOf(R.drawable.ysf_message_file_icon_mp3));
        a.put("wav", Integer.valueOf(R.drawable.ysf_message_file_icon_mp3));
        a.put("aac", Integer.valueOf(R.drawable.ysf_message_file_icon_mp3));
        a.put("ogg", Integer.valueOf(R.drawable.ysf_message_file_icon_mp3));
        a.put("avi", Integer.valueOf(R.drawable.ysf_message_file_icon_mp4));
        a.put("mov", Integer.valueOf(R.drawable.ysf_message_file_icon_mp4));
        a.put("mkv", Integer.valueOf(R.drawable.ysf_message_file_icon_mp4));
        a.put("rmvb", Integer.valueOf(R.drawable.ysf_message_file_icon_mp4));
        a.put("wmv", Integer.valueOf(R.drawable.ysf_message_file_icon_mp4));
        a.put("3gp", Integer.valueOf(R.drawable.ysf_message_file_icon_mp4));
        a.put("flv", Integer.valueOf(R.drawable.ysf_message_file_icon_mp4));
        a.put("mp4", Integer.valueOf(R.drawable.ysf_message_file_icon_mp4));
        a.put("mpg", Integer.valueOf(R.drawable.ysf_message_file_icon_mp4));
    }

    public static int a(String str, boolean z) {
        Integer num = (Integer) a.get(com.qiyukf.basesdk.c.a.b.a(str).toLowerCase());
        return num == null ? z ? R.drawable.ysf_message_file_icon_unknown_preview : R.drawable.ysf_message_file_icon_unknown : num.intValue();
    }
}
