package com.yktong.dogodgod.bean.actions.location;

import com.google.gson.annotations.SerializedName;
import com.yktong.dogodgod.bean.actions.ResponseBaseContext;
import com.yktong.dogodgod.bean.data_bean.location.UserLocationListViewBean;

/**
 * Created by Eileen on 2017/9/30.
 */

public class UserLocationListResponseContext extends ResponseBaseContext<UserLocationListResponseController> {
    @SerializedName("cLocusfreeList")
    private UserLocationListViewBean usersLocationViewBean;

    public UserLocationListViewBean getUsersLocationViewBean() {
        return usersLocationViewBean;
    }

    public void setUsersLocationViewBean(UserLocationListViewBean usersLocationViewBean) {
        this.usersLocationViewBean = usersLocationViewBean;
    }
}
