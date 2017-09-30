package com.yktong.dogodgod.bean.actions.location;

import com.google.gson.annotations.SerializedName;
import com.yktong.dogodgod.bean.actions.ResponseBaseContext;
import com.yktong.dogodgod.bean.data_bean.location.UserLocationBean;

import java.util.List;

/**
 * Created by Eileen on 2017/9/30.
 */

public class UserLocationResponseContext extends ResponseBaseContext<UserLocationResponseController> {
    @SerializedName("cLocusfrees")
    private List<UserLocationBean> userLocationBeanList;

    public List<UserLocationBean> getUserLocationBeanList() {
        return userLocationBeanList;
    }

    public void setUserLocationBeanList(List<UserLocationBean> userLocationBeanList) {
        this.userLocationBeanList = userLocationBeanList;
    }
}
