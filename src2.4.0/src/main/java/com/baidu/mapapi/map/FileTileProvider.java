package com.baidu.mapapi.map;

public abstract class FileTileProvider implements TileProvider {
    public abstract Tile getTile(int i, int i2, int i3);
}
