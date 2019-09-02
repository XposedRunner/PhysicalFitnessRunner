package com.baidu.mapapi.synchronization.histroytrace;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter.CoordType;
import java.util.List;

public class HistoryTraceData implements Parcelable {
    public static final Creator<HistoryTraceData> CREATOR = new a();
    private int a;
    private double b;
    private double c;
    private int d;
    private LatLng e;
    private LatLng f;
    private CoordType g = CoordType.BD09LL;
    private List<HistoryTracePoint> h;
    private int i;

    public static class HistoryTracePoint implements Parcelable {
        public static final Creator<HistoryTracePoint> CREATOR = new b();
        private LatLng a;
        private long b;
        private String c;

        protected HistoryTracePoint(Parcel parcel) {
            this.a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.b = parcel.readLong();
            this.c = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String getCreateTime() {
            return this.c;
        }

        public long getLocationTime() {
            return this.b;
        }

        public LatLng getPoint() {
            return this.a;
        }

        public void setCreateTime(String str) {
            this.c = str;
        }

        public void setLocationTime(long j) {
            this.b = j;
        }

        public void setPoint(LatLng latLng) {
            this.a = latLng;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeLong(this.b);
            parcel.writeString(this.c);
        }
    }

    protected HistoryTraceData(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readDouble();
        this.c = parcel.readDouble();
        this.d = parcel.readInt();
        this.e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public CoordType getCoordType() {
        return this.g;
    }

    public int getCurrentOrderState() {
        return this.d;
    }

    public int getCurrentPageIndex() {
        return this.i;
    }

    public double getDistance() {
        return this.b;
    }

    public LatLng getOrderEndPosition() {
        return this.f;
    }

    public LatLng getOrderStartPosition() {
        return this.e;
    }

    public List<HistoryTracePoint> getPointsList() {
        return this.h;
    }

    public double getTollDiatance() {
        return this.c;
    }

    public int getTotalPoints() {
        return this.a;
    }

    public void setCoordType(CoordType coordType) {
        this.g = coordType;
    }

    public void setCurrentOrderState(int i) {
        this.d = i;
    }

    public void setCurrentPageIndex(int i) {
        this.i = i;
    }

    public void setDistance(double d) {
        this.b = d;
    }

    public void setOrderEndPosition(LatLng latLng) {
        this.f = latLng;
    }

    public void setOrderStartPosition(LatLng latLng) {
        this.e = latLng;
    }

    public void setPointsList(List<HistoryTracePoint> list) {
        this.h = list;
    }

    public void setTollDiatance(double d) {
        this.c = d;
    }

    public void setTotalPoints(int i) {
        this.a = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
        stringBuffer.append("TotalPoints = ");
        stringBuffer.append(this.a);
        stringBuffer.append("; Distance = ");
        stringBuffer.append(this.b);
        stringBuffer.append("; TollDistance = ");
        stringBuffer.append(this.c);
        stringBuffer.append("; CurrentOrderState = ");
        stringBuffer.append(this.d);
        stringBuffer.append("; OrderStartPosition = ");
        stringBuffer.append(this.e);
        stringBuffer.append("; OrderEndPosition = ");
        stringBuffer.append(this.f);
        if (!(this.h == null || this.h.isEmpty())) {
            stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
            for (int i = 0; i < this.h.size(); i++) {
                HistoryTracePoint historyTracePoint = (HistoryTracePoint) this.h.get(i);
                if (historyTracePoint != null) {
                    stringBuffer.append("The ");
                    stringBuffer.append(i);
                    stringBuffer.append(" Point Info: ");
                    stringBuffer.append("Point = ");
                    stringBuffer.append(historyTracePoint.getPoint().toString());
                    stringBuffer.append("; LocationTime = ");
                    stringBuffer.append(historyTracePoint.getLocationTime());
                    stringBuffer.append("; CreateTime = ");
                    stringBuffer.append(historyTracePoint.getCreateTime());
                    stringBuffer.append("\n");
                }
            }
        }
        return stringBuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeDouble(this.b);
        parcel.writeDouble(this.c);
        parcel.writeInt(this.d);
        parcel.writeParcelable(this.e, i);
        parcel.writeParcelable(this.f, i);
        parcel.writeTypedList(this.h);
    }
}
