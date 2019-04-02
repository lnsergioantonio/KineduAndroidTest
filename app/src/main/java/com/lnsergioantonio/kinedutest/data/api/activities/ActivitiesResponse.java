package com.lnsergioantonio.kinedutest.data.api.activities;

import com.google.gson.annotations.SerializedName;

public class ActivitiesResponse {
    @SerializedName("data")
    final Data data;
    @SerializedName("meta")
    final Meta meta;

    public ActivitiesResponse(Data data, Meta meta) {
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
