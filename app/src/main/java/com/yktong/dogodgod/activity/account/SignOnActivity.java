package com.yktong.dogodgod.activity.account;

import android.view.View;
import android.widget.TextView;

import com.yktong.dogodgod.R;
import com.yktong.dogodgod.base.BaseDataBindingActivity;
import com.yktong.dogodgod.bean.view_bean.UserViewBean;
import com.yktong.dogodgod.databinding.ActivitySignOnBinding;

import java.util.Timer;
import java.util.TimerTask;

public class SignOnActivity extends BaseDataBindingActivity<ActivitySignOnBinding,SignOnActivity> {
    UserViewBean userViewBean;

    @Override
    protected void doBindData(ActivitySignOnBinding bind) {
        if (userViewBean == null) userViewBean = new UserViewBean();
        int type = getIntent().getIntExtra(UserViewBean.ViewType.VIEW_TYPE_INDEX, -1);
        if (type == -1) finish();
        userViewBean.setViewTypeIndex(type);
        bind.setUser(userViewBean);
        bind.setControl(this);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_sign_on;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    public void getVerifyCode(View view) {
        showWaitCode(view);

    }

    private void showWaitCode(View view) {
        view.setEnabled(false);
        view.setBackground(getDrawable(R.drawable.shape_login_un));
        new Timer().schedule(new TimerTask() {
            TextView currentView = (TextView) view;
            int currentTime, times = 60;

            @Override
            public void run() {
                int waitTime=times-currentTime;
                if (waitTime == 0) {
                    cancel();
                    runOnUiThread(() -> {
                        currentView.setText("获取验证码");
                        currentView.setEnabled(true);
                        view.setBackground(getDrawable(R.drawable.shape_login));

                    });
                    return;
                }
                runOnUiThread(() -> {
                    currentView.setText("还剩" + waitTime + "秒再获取");
                });
                currentTime++;
            }
        }, 0, 1000);
    }

    public void getVerifyCodeManager(View view) {
        showWaitCode(view);
    }

    public void doNext(View view) {
        if (userViewBean.getViewTypeIndex() == UserViewBean.ViewType.FIND_PASSWORD_VIEW) {
            //// TODO: 2017/10/10 找回密码
            return;
        }
        if (userViewBean.getViewTypeIndex() == UserViewBean.ViewType.SIGN_ON_NEXT_VIEW) {
            ///// TODO: 2017/10/10 下一步
            userViewBean.setViewTypeIndex(UserViewBean.ViewType.SIG_ON_VIEW);
            return;
        }
        if (userViewBean.getViewTypeIndex() == UserViewBean.ViewType.SIG_ON_VIEW) {
            //// TODO: 2017/10/10 注册
        }
    }
}
