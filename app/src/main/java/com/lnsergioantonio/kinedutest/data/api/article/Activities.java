package com.lnsergioantonio.kinedutest.data.api.article;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Activities {
    @SerializedName("id")
    final int id;
    @SerializedName("name")
    final String name;
    @SerializedName("description")
    final String description;
    @SerializedName("purpose")
    final String purpose;
    @SerializedName("age")
    final int age;
    @SerializedName("age_group")
    final String age_group;
    @SerializedName("activity_type")
    final String activity_type;
    @SerializedName("video_provider_thumbnails")
    final VideoProviderThumbnails video_provider_thumbnails;
    @SerializedName("video_id")
    final String video_id;
    @SerializedName("area_id")
    final int area_id;
    @SerializedName("shareable_video_url")
    final String shareable_video_url;
    @SerializedName("shareable_thumbnail_url")
    final String shareable_thumbnail_url;
    @SerializedName("locked")
    final boolean locked;
    @SerializedName("picture")
    final String picture;
    @SerializedName("faved")
    final boolean faved;


    public Activities(int id, String name, String description, String purpose, int age, String age_group, String activity_type, VideoProviderThumbnails video_provider_thumbnails, String video_id, int area_id, String shareable_video_url, String shareable_thumbnail_url, boolean locked, String picture, boolean faved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.purpose = purpose;
        this.age = age;
        this.age_group = age_group;
        this.activity_type = activity_type;
        this.video_provider_thumbnails = video_provider_thumbnails;
        this.video_id = video_id;
        this.area_id = area_id;
        this.shareable_video_url = shareable_video_url;
        this.shareable_thumbnail_url = shareable_thumbnail_url;
        this.locked = locked;
        this.picture = picture;
        this.faved = faved;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPurpose() {
        return purpose;
    }

    public int getAge() {
        return age;
    }

    public String getAge_group() {
        return age_group;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public VideoProviderThumbnails getVideo_provider_thumbnails() {
        return video_provider_thumbnails;
    }

    public String getVideo_id() {
        return video_id;
    }

    public int getArea_id() {
        return area_id;
    }

    public String getShareable_video_url() {
        return shareable_video_url;
    }

    public String getShareable_thumbnail_url() {
        return shareable_thumbnail_url;
    }

    public boolean isLocked() {
        return locked;
    }

    public String getPicture() {
        return picture;
    }

    public boolean isFaved() {
        return faved;
    }
}
