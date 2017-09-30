package com.yktong.dogodgod.bean.actions;

/**
 * Created by Eileen on 2017/9/29.
 */

public class ResponseBaseContext<T extends ResponseBaseController> extends ResponseBaseBean<T> {

    public void doResponse(T dataController){
        if (getCode()==T.successCode){
            dataController.success(this);
        }
    }
}
