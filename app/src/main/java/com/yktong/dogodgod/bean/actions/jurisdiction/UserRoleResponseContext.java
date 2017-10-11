package com.yktong.dogodgod.bean.actions.jurisdiction;

import com.yktong.dogodgod.bean.actions.ResponseBaseContext;
import com.yktong.dogodgod.bean.actions.ResponseBaseController;

/**
 * Created by Eileen on 2017/9/30.
 */

public class UserRoleResponseContext extends ResponseBaseContext<UserRoleResponseController> {
    @Override
    public void doResponse(UserRoleResponseController dataController) {
        super.doResponse(dataController);
        switch (getCode()) {
            case ResponseBaseController.not_admin:
                dataController.notAdmin(ResponseBaseController.not_admin_text);
                break;
            case ResponseBaseController.cannot_do:
                dataController.cannotDo(ResponseBaseController.cannot_do_text);
                break;
        }
    }
}
