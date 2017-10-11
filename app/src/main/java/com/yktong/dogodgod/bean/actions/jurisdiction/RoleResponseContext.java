package com.yktong.dogodgod.bean.actions.jurisdiction;

import com.google.gson.annotations.SerializedName;
import com.yktong.dogodgod.bean.actions.ResponseBaseContext;
import com.yktong.dogodgod.bean.actions.ResponseBaseController;
import com.yktong.dogodgod.bean.data_bean.jurisdiction.RoleBean;

import java.util.List;

/**
 * Created by Eileen on 2017/9/30.
 */

public class RoleResponseContext extends ResponseBaseContext<RoleResponseController> {
    @SerializedName("roles")
    private List<RoleBean> roleBeanList;

    public List<RoleBean> getRoleBeanList() {
        return roleBeanList;
    }

    public void setRoleBeanList(List<RoleBean> roleBeanList) {
        this.roleBeanList = roleBeanList;
    }
    @Override
    public void doResponse(RoleResponseController dataController) {
        super.doResponse(dataController);
        if (getCode()== ResponseBaseController.not_admin){
            dataController.notAdmin(ResponseBaseController.not_admin_text);
        }
    }
}
