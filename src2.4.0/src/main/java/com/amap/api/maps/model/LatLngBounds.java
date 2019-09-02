package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.amap.api.mapcore.util.OOo000;

public final class LatLngBounds implements Parcelable {
    private static final String CLASSNAME = "LatLngBounds";
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double mEast = Double.NaN;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mWest = Double.NaN;

        private boolean a(double d) {
            boolean z = false;
            if (this.mWest <= this.mEast) {
                if (this.mWest <= d && d <= this.mEast) {
                    z = true;
                }
                return z;
            }
            if (this.mWest <= d || d <= this.mEast) {
                z = true;
            }
            return z;
        }

        public LatLngBounds build() {
            if (Double.isNaN(this.mWest)) {
                Log.w(LatLngBounds.CLASSNAME, "no included points");
                return null;
            }
            double d;
            if (this.mWest > this.mEast) {
                d = this.mWest;
                this.mWest = this.mEast;
                this.mEast = d;
            }
            if (this.mSouth > this.mNorth) {
                d = this.mSouth;
                this.mSouth = this.mNorth;
                this.mNorth = d;
            }
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
        }

        public Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.mSouth = Math.min(this.mSouth, latLng.latitude);
            this.mNorth = Math.max(this.mNorth, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.mWest)) {
                this.mWest = d;
                this.mEast = d;
            } else if (!a(d)) {
                if (LatLngBounds.c(this.mWest, d) < LatLngBounds.d(this.mEast, d)) {
                    this.mWest = d;
                } else {
                    this.mEast = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        Object obj;
        if (latLng == null) {
            try {
                throw new RuntimeRemoteException("null southwest");
            } catch (Throwable th) {
                Log.e(CLASSNAME, "the structure parameters are illegal!");
                th.printStackTrace();
                obj = null;
            }
        } else if (latLng2 == null) {
            throw new RuntimeRemoteException("null northeast");
        } else if (latLng2.latitude < latLng.latitude) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("southern latitude exceeds northern latitude (");
            stringBuilder.append(latLng.latitude);
            stringBuilder.append(" > ");
            stringBuilder.append(latLng2.latitude);
            stringBuilder.append(")");
            throw new RuntimeRemoteException(stringBuilder.toString());
        } else {
            obj = 1;
            if (obj == null) {
                i = 0;
            }
            this.mVersionCode = i;
            LatLng latLng3 = null;
            if (obj == null) {
                latLng = null;
            }
            this.southwest = latLng;
            if (obj != null) {
                latLng3 = latLng2;
            }
            this.northeast = latLng3;
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    private boolean a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean a(LatLngBounds latLngBounds) {
        boolean z = false;
        if (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) {
            return false;
        }
        double d = ((latLngBounds.northeast.latitude + latLngBounds.southwest.latitude) - this.northeast.latitude) - this.southwest.latitude;
        double d2 = ((this.northeast.latitude - this.southwest.latitude) + latLngBounds.northeast.latitude) - latLngBounds.southwest.latitude;
        if (Math.abs(((latLngBounds.northeast.longitude + latLngBounds.southwest.longitude) - this.northeast.longitude) - this.southwest.longitude) < ((this.northeast.longitude - this.southwest.longitude) + latLngBounds.northeast.longitude) - this.southwest.longitude && Math.abs(d) < d2) {
            z = true;
        }
        return z;
    }

    private boolean b(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            if (this.southwest.longitude <= d && d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        }
        if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
            z = true;
        }
        return z;
    }

    public static Builder builder() {
        return new Builder();
    }

    private static double c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private static double d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    /* Access modifiers changed, original: 0000 */
    public int a() {
        return this.mVersionCode;
    }

    public boolean contains(LatLng latLng) {
        boolean z = false;
        if (latLng == null) {
            return false;
        }
        if (this.northeast == null || this.southwest == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return false;
        }
        if (a(latLng.latitude) && b(latLng.longitude)) {
            z = true;
        }
        return z;
    }

    public boolean contains(LatLngBounds latLngBounds) {
        boolean z = false;
        if (latLngBounds == null) {
            return false;
        }
        if (contains(latLngBounds.southwest) && contains(latLngBounds.northeast)) {
            z = true;
        }
        return z;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (!(this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return OOo000.O000000o(new Object[]{this.southwest, this.northeast});
    }

    public LatLngBounds including(LatLng latLng) {
        LatLng latLng2 = latLng;
        if (latLng2 == null) {
            return this;
        }
        if (this.northeast == null || this.southwest == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return this;
        }
        double d;
        double min = Math.min(this.southwest.latitude, latLng2.latitude);
        double max = Math.max(this.northeast.latitude, latLng2.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = latLng2.longitude;
        if (!b(d4)) {
            if (c(d3, d4) < d(d2, d4)) {
                d3 = d4;
            } else {
                d = d4;
                return new LatLngBounds(new LatLng(min, d3, false), new LatLng(max, d, false));
            }
        }
        d = d2;
        try {
            return new LatLngBounds(new LatLng(min, d3, false), new LatLng(max, d, false));
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        boolean z = false;
        if (latLngBounds == null) {
            return false;
        }
        if (this.northeast == null || this.southwest == null) {
            Log.e(CLASSNAME, "current LatLngBounds is invalid, please check the structure parameters are legal");
            return false;
        }
        if (a(latLngBounds) || latLngBounds.a(this)) {
            z = true;
        }
        return z;
    }

    public String toString() {
        return OOo000.O000000o(OOo000.O000000o("southwest", this.southwest), OOo000.O000000o("northeast", this.northeast));
    }

    public void writeToParcel(Parcel parcel, int i) {
        LatLngBoundsCreator.a(this, parcel, i);
    }
}
