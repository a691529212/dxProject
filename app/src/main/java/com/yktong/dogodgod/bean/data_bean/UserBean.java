package com.yktong.dogodgod.bean.data_bean;

import com.yktong.dogodgod.bean.BaseViewBean;

/**
 * Created by Eileen on 2017/9/29.
 * 用户
 */

public class UserBean extends BaseViewBean {


    private Integer deptId;
    //用户id
    private Integer userId;
    //公司id
    private Integer companyId;
    //密码
    private String passWord;
    //账号（手机号）
    private String loginName;
    //姓名
    private String userName;
    //个人验证码
    private String verifyCode;
    //管理员验证码
    private String verifyCodeManager;
    //推送标识
    private String registrationId;
    //IMEI
    private String iMei;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getVerifyCodeManager() {
        return verifyCodeManager;
    }

    public void setVerifyCodeManager(String verifyCodeManager) {
        this.verifyCodeManager = verifyCodeManager;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getiMei() {
        return iMei;
    }

    public void setiMei(String iMei) {
        this.iMei = iMei;
    }

    @Override
    public Integer getId() {
        return getUserId();
    }

    @Override
    public void setId(Integer id) {
        setUserId(id);
    }

    @Override
    public String getName() {
        return getUserName();
    }

    @Override
    public void setName(String name) {
        setUserName(name);
    }
}
