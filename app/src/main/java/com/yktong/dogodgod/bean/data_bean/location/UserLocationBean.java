package com.yktong.dogodgod.bean.data_bean.location;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Eileen on 2017/9/30.
 */

public class UserLocationBean {
    @SerializedName("cLocususerid")
    private Integer userId;
    @SerializedName("cLatitude")
    private Double latitude;
    @SerializedName("cLongitude")
    private Double longitude;
    @SerializedName("cLocustime")
    private Long dateTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }
}
