package com.lnsergioantonio.kinedutest.data.api.article;
import com.google.gson.annotations.SerializedName;

public class DataResponse {
    @SerializedName("data")
    final Data data;

    public DataResponse(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }
}