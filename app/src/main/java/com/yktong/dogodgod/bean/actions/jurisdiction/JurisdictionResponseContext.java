package com.yktong.dogodgod.bean.actions.jurisdiction;

import com.google.gson.annotations.SerializedName;
import com.yktong.dogodgod.bean.actions.ResponseBaseContext;
import com.yktong.dogodgod.bean.actions.ResponseBaseController;
import com.yktong.dogodgod.bean.data_bean.jurisdiction.JurisdictionBean;

import java.util.List;

/**
 * Created by Eileen on 2017/9/30.
 */

public class JurisdictionResponseContext extends ResponseBaseContext<JurisdictionResponseController> {
    @SerializedName("resource")
    private List<JurisdictionBean> jurisdictionBeanList;

    public List<JurisdictionBean> getJurisdictionBeanList() {
        return jurisdictionBeanList;
    }

    public void setJurisdictionBeanList(List<JurisdictionBean> jurisdictionBeanList) {
        this.jurisdictionBeanList = jurisdictionBeanList;
    }

    @Override
    public void doResponse(JurisdictionResponseController dataController) {
        super.doResponse(dataController);
        if (getCode()== ResponseBaseController.not_admin){
            dataController.notAdmin(ResponseBaseController.not_admin_text);
        }
    }
}
