package com.yktong.dogodgod.bean.data_bean.location;

import com.google.gson.annotations.SerializedName;
import com.yktong.dogodgod.bean.data_bean.DeptBean;

import java.util.List;

/**
 * Created by Eileen on 2017/9/30.
 */

public class UserLocationListViewBean {
    @SerializedName("depts")
    private List<DeptBean> deptBeanList;
    @SerializedName("userCountLocusfree")
    private List<UserLocationListBean> userLocationListBeanList;

    public List<DeptBean> getDeptBeanList() {
        return deptBeanList;
    }

    public void setDeptBeanList(List<DeptBean> deptBeanList) {
        this.deptBeanList = deptBeanList;
    }

    public List<UserLocationListBean> getUserLocationListBeanList() {
        return userLocationListBeanList;
    }

    public void setUserLocationListBeanList(List<UserLocationListBean> userLocationListBeanList) {
        this.userLocationListBeanList = userLocationListBeanList;
    }
}
