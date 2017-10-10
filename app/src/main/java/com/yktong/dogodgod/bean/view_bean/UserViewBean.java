package com.yktong.dogodgod.bean.view_bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.yktong.dogodgod.BR;


/**
 * Created by Eileen on 2017/10/9.
 */

public class UserViewBean extends BaseObservable {
    private String loginName;
    private String password;
    private String verifyPassword;
    private String companyId;
    private String companyName;
    private String verifyCode;
    private String verifyCodeManager;
    private OnPropertyChangeListener<String> onCompanyIdChangeListener;
    private Integer viewTypeIndex;//0.找回密码,1.下一步,2.注册
    private String viewTypeText;

    @Bindable
    public String getViewTypeText() {
        switch (viewTypeIndex) {
            case ViewType.FIND_PASSWORD_VIEW:
                return "找回密码";
            case ViewType.SIGN_ON_NEXT_VIEW:
                return "下一步";
            case ViewType.SIG_ON_VIEW:
                return "注册";
        }
        return viewTypeText;
    }

    public void setViewTypeText(String viewTypeText) {
        this.viewTypeText = viewTypeText;
        notifyPropertyChanged(BR.viewTypeText);
    }

    @Bindable
    public Integer getViewTypeIndex() {
        return viewTypeIndex;
    }

    public void setViewTypeIndex(Integer viewTypeIndex) {
        this.viewTypeIndex = viewTypeIndex;
        notifyPropertyChanged(BR.viewTypeIndex);
        notifyPropertyChanged(BR.viewTypeText);
    }

    @Bindable
    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        notifyPropertyChanged(BR.verifyCode);
    }

    @Bindable
    public String getVerifyCodeManager() {
        return verifyCodeManager;
    }

    public void setVerifyCodeManager(String verifyCodeManager) {
        this.verifyCodeManager = verifyCodeManager;
        notifyPropertyChanged(BR.verifyCodeManager);
    }

    @Bindable
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
        notifyPropertyChanged(BR.companyName);
    }

    @Bindable
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
        notifyPropertyChanged(BR.loginName);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);

    }

    @Bindable
    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        notifyPropertyChanged(BR.verifyPassword);

    }

    @Bindable
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
        notifyPropertyChanged(BR.companyId);
        if (onCompanyIdChangeListener != null) onCompanyIdChangeListener.changed(companyId);
    }

    public void setOnCompanyIdChangeListener(OnPropertyChangeListener<String> onCompanyIdChangeListener) {
        this.onCompanyIdChangeListener = onCompanyIdChangeListener;
    }

    public static interface ViewType {
        String VIEW_TYPE_INDEX = "viewTypeIndex";
        int FIND_PASSWORD_VIEW = 0;
        int SIGN_ON_NEXT_VIEW = 1;
        int SIG_ON_VIEW = 2;
    }


}
