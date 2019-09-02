package com.ximalaya.ting.android.opensdk.model.coldboot;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class GenreList extends XimalayaResponse {
    private List<String> genreList;

    public List<String> getGenreList() {
        return this.genreList;
    }

    public void setGenreList(List<String> list) {
        this.genreList = list;
    }
}
