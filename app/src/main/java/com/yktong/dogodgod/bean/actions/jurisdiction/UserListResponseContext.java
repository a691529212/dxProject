package com.yktong.dogodgod.bean.actions.jurisdiction;

import com.yktong.dogodgod.bean.actions.ResponseBaseContext;
import com.yktong.dogodgod.bean.actions.ResponseBaseController;

/**
 * Created by Eileen on 2017/9/30.
 */

public class UserListResponseContext extends ResponseBaseContext<UserListResponseController> {
    @Override
    public void doResponse(UserListResponseController dataController) {
        super.doResponse(dataController);
        if (getCode()== ResponseBaseController.not_admin){
            dataController.notAdmin(ResponseBaseController.not_admin_text);
        }
    }
}
