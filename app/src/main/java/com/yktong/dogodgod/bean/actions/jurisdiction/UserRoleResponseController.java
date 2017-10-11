package com.yktong.dogodgod.bean.actions.jurisdiction;

import com.yktong.dogodgod.bean.actions.ResponseBaseController;

/**
 * Created by Eileen on 2017/9/30.
 */

interface UserRoleResponseController extends ResponseBaseController<UserRoleResponseContext> {
    void notAdmin(String msg);
    void cannotDo(String msg);

}
