package com.yktong.dogodgod.bean.actions;

import com.yktong.dogodgod.bean.data_bean.UserBean;

/**
 * Created by Eileen on 2017/9/29.
 */

public class RequestBaseBean {
    private UserBean userBean;

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
