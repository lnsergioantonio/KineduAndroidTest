package com.lnsergioantonio.kinedutest.data.api.articles;

import com.google.gson.annotations.SerializedName;
import com.lnsergioantonio.kinedutest.data.api.activities.Meta;

public class ArticlesResponse {
    @SerializedName("data")
    final Data data;
    @SerializedName("meta")
    final Meta meta;

    public ArticlesResponse(Data data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public Data getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }
}
