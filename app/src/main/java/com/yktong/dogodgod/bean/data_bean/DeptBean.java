package com.yktong.dogodgod.bean.data_bean;

import com.yktong.dogodgod.bean.BaseViewBean;

/**
 * Created by Eileen on 2017/9/30.
 * 部门
 */

public class DeptBean extends BaseViewBean {
    //部门id
    private Integer deptId;
    //公司id
    private Integer companyId;
    //部门名称
    private String deptName;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public Integer getId() {
        return deptId;
    }

    @Override
    public void setId(Integer id) {
        setDeptId(id);
    }

    @Override
    public String getName() {
        return deptName;
    }

    @Override
    public void setName(String name) {
        setDeptName(name);
    }
}
