package com.yktong.dogodgod.activity.account;

import android.content.Intent;
import android.view.View;

import com.yktong.dogodgod.R;
import com.yktong.dogodgod.activity.MainActivity;
import com.yktong.dogodgod.base.BaseDataBindingActivity;
import com.yktong.dogodgod.bean.view_bean.UserViewBean;
import com.yktong.dogodgod.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseDataBindingActivity<ActivityLoginBinding,LoginActivity> {
    UserViewBean userViewBean;

    @Override
    protected void doBindData(ActivityLoginBinding bind) {
        if (userViewBean == null) {
            userViewBean = new UserViewBean();
            userViewBean.setOnCompanyIdChangeListener(property -> {
                requestCompanyName();
            });
        }

        bind.setUser(userViewBean);
        bind.setControl(this);
    }

    private void requestCompanyName() {
        if (userViewBean.getCompanyId().trim().length() == 0) return;
//        NetTool.getInstance().startRequest(OkHttpUtil.GET, UrlValue.REQUEST_COMPANY_NAME + companyId, CompanyRequestBean.class, new OnHttpCallBack<CompanyRequestBean>() {
//            @Override
//            public void onSuccess(CompanyRequestBean response) {
//                response.doResponse(new CompanyRequestBean.CompanyNameResponseStatus() {
//                    @Override
//                    public void noCompany(String msg) {
//                        cleanCompany();
//                    }
//
//                    @Override
//                    public void doSuccess() {
//                        setCompanyName(response.getCompanyName());
//                    }
//                });
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    public void doLogin(View view) {
      startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void goSignOn(View view) {
        Intent intent = new Intent(this,SignOnActivity.class);
        intent.putExtra(UserViewBean.ViewType.VIEW_TYPE_INDEX,UserViewBean.ViewType.SIGN_ON_NEXT_VIEW);
        startActivity(intent);
    }

    public void goFindPassword(View view) {
        Intent intent = new Intent(this,SignOnActivity.class);
        intent.putExtra(UserViewBean.ViewType.VIEW_TYPE_INDEX,UserViewBean.ViewType.FIND_PASSWORD_VIEW);
        startActivity(intent);
    }
}
