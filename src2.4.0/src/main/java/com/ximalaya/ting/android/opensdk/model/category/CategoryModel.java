package com.ximalaya.ting.android.opensdk.model.category;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CategoryModel implements Parcelable {
    public static final Creator<CategoryModel> CREATOR = new Creator<CategoryModel>() {
        public CategoryModel createFromParcel(Parcel parcel) {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setCategoryId(parcel.readInt());
            categoryModel.setCategoryName(parcel.readString());
            return categoryModel;
        }

        public CategoryModel[] newArray(int i) {
            return new CategoryModel[i];
        }
    };
    private int categoryId;
    private String categoryName;

    public int describeContents() {
        return 0;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.categoryId);
        parcel.writeString(this.categoryName);
    }
}
