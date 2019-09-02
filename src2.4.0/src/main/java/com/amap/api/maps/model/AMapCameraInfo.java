package com.amap.api.maps.model;

public class AMapCameraInfo {
    private float aspectRatio = 1.0f;
    private float fov = 0.0f;
    private float positionX = 0.0f;
    private float positionY = 0.0f;
    private float positionZ = 0.0f;
    private float rotate = 0.0f;

    public AMapCameraInfo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.fov = f;
        this.aspectRatio = f2;
        this.rotate = f3;
        this.positionX = f4;
        this.positionY = f5;
        this.positionZ = f6;
    }

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public float getFov() {
        return this.fov;
    }

    public float getRotate() {
        return this.rotate;
    }

    public float getX() {
        return this.positionX;
    }

    public float getY() {
        return this.positionY;
    }

    public float getZ() {
        return this.positionZ;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("fov:");
        stringBuilder.append(this.fov);
        stringBuilder.append(" ");
        stringBuilder.append("aspectRatio:");
        stringBuilder.append(this.aspectRatio);
        stringBuilder.append(" ");
        stringBuilder.append("rotate:");
        stringBuilder.append(this.rotate);
        stringBuilder.append(" ");
        stringBuilder.append("pos_x:");
        stringBuilder.append(this.positionX);
        stringBuilder.append(" ");
        stringBuilder.append("pos_y:");
        stringBuilder.append(this.positionY);
        stringBuilder.append(" ");
        stringBuilder.append("pos_z:");
        stringBuilder.append(this.positionZ);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
