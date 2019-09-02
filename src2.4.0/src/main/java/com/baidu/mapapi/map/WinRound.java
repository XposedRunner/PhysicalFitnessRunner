package com.baidu.mapapi.map;

public class WinRound {
    public int bottom = 0;
    public int left = 0;
    public int right = 0;
    public int top = 0;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WinRound{left=");
        stringBuilder.append(this.left);
        stringBuilder.append(", right=");
        stringBuilder.append(this.right);
        stringBuilder.append(", top=");
        stringBuilder.append(this.top);
        stringBuilder.append(", bottom=");
        stringBuilder.append(this.bottom);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
