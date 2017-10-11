package com.yktong.dogodgod.bean.actions;

/**
 * Created by Eileen on 2017/9/29.
 */

public interface ResponseBaseController<T extends ResponseBaseBean> {
    //成功
    int successCode = 1;
    //没有权限
    int not_admin = 4;
    String not_admin_text = "没有权限";
    //不能执行
    int cannot_do = 25;
    String cannot_do_text = "不能执行";

    void success(T dataContext);
}
