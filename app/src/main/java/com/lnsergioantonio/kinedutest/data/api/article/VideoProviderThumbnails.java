package com.lnsergioantonio.kinedutest.data.api.article;

import com.google.gson.annotations.SerializedName;

public class VideoProviderThumbnails {
    @SerializedName("size1")
    final String size1;
    @SerializedName("size2")
    final String size2;
    @SerializedName("size3")
    final String size3;
    @SerializedName("size4")
    final String size4;
    @SerializedName("size5")
    final String size5;
    @SerializedName("size6")
    final String size6;

    public VideoProviderThumbnails(String size1, String size2, String size3, String size4, String size5, String size6) {
        this.size1 = size1;
        this.size2 = size2;
        this.size3 = size3;
        this.size4 = size4;
        this.size5 = size5;
        this.size6 = size6;
    }

    public String getSize1() {
        return size1;
    }

    public String getSize2() {
        return size2;
    }

    public String getSize3() {
        return size3;
    }

    public String getSize4() {
        return size4;
    }

    public String getSize5() {
        return size5;
    }

    public String getSize6() {
        return size6;
    }
}
