package com.lnsergioantonio.kinedutest.data.api.activities;

import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("page")
    final int page;
    @SerializedName("per_page")
    final int per_page;
    @SerializedName("total_pages")
    final int total_pages;
    @SerializedName("total")
    final int total;

    public Meta(int page, int per_page, int total_pages, int total) {
        this.page = page;
        this.per_page = per_page;
        this.total_pages = total_pages;
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal() {
        return total;
    }
}
