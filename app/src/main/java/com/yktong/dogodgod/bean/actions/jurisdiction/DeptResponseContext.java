package com.yktong.dogodgod.bean.actions.jurisdiction;

import com.google.gson.annotations.SerializedName;
import com.yktong.dogodgod.bean.actions.ResponseBaseContext;
import com.yktong.dogodgod.bean.actions.ResponseBaseController;
import com.yktong.dogodgod.bean.data_bean.DeptBean;

import java.util.List;

/**
 * Created by Eileen on 2017/9/30.
 */

public class DeptResponseContext extends ResponseBaseContext<DeptResponseController> {
    @SerializedName("dept")
    private List<DeptBean> deptBeanList;


    public List<DeptBean> getDeptBeanList() {
        return deptBeanList;
    }

    public void setDeptBeanList(List<DeptBean> deptBeanList) {
        this.deptBeanList = deptBeanList;
    }
    @Override
    public void doResponse(DeptResponseController dataController) {
        super.doResponse(dataController);
        if (getCode()==ResponseBaseController.not_admin){
            dataController.notAdmin(ResponseBaseController.not_admin_text);
        }
    }
}
