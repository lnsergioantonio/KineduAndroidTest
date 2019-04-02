package com.lnsergioantonio.kinedutest.data.api.article;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("article")
    final Article article;
    @SerializedName("related_items")
    final RelatedItems related_items;

    public Data(Article article, RelatedItems relatedItems) {
        this.article = article;
        this.related_items = relatedItems;
    }

    public Article getArticle() {
        return article;
    }

    public RelatedItems getRelatedItems() {
        return related_items;
    }
}

