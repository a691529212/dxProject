package com.yktong.dogodgod.activity;

import android.content.Intent;
import android.util.Log;
import android.view.Display;

import com.yktong.dogodgod.R;
import com.yktong.dogodgod.activity.account.LoginActivity;
import com.yktong.dogodgod.base.BaseActivity;
import com.yktong.dogodgod.base.MyApp;
import com.yktong.dogodgod.tool.SPUtil;
import com.yktong.dogodgod.value.SpValue;

import java.util.Timer;
import java.util.TimerTask;

public class WelActivity extends BaseActivity<WelActivity>  implements SpValue {

    @Override
    protected int setLayout() {
        return R.layout.activity_wel;
    }


    @Override
    protected void initView() {
        // 获取屏幕的默认分辨率
        Display display = getWindowManager().getDefaultDisplay();
        float width = display.getWidth() / 720;
        float height = display.getHeight() / 1280;
        Log.d("WelActivity", "width:" + width);
        Log.d("WelActivity", "height:" + height);
        SPUtil.putAndApply(MyApp.getmContext(), SCREEN_WIDE, width + "");
        SPUtil.putAndApply(MyApp.getmContext(), SCREEN_HEIGHT, height + "");
        String w = (String) SPUtil.get(MyApp.getmContext(), SCREEN_WIDE, "1");
        String h = (String) SPUtil.get(MyApp.getmContext(), SCREEN_HEIGHT, "1");
        Log.d("WelActivity", w);
        Log.d("WelActivity", h);
    }

    @Override
    protected void initData() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getActivity(), LoginActivity.class));
                finish();
            }
        },2000);

//        boolean rootAhth = WorkManger.getRootAhth();
//        if (rootAhth) {
//
//        } else {
//            Toast.makeText(mContext, "未获取Root权限", Toast.LENGTH_SHORT).show();
//        }
    }
}
