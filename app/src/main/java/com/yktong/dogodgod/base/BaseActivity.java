package com.yktong.dogodgod.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by vampire on 2017/9/27.
 */

public abstract class BaseActivity<T extends BaseActivity> extends FragmentActivity {
    protected Context mContext;
    protected View rootView;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      if (setLayout() != 0) {
            rootView = LayoutInflater.from(this).inflate(setLayout(), null);
            setContentView(rootView);//绑定布局
        } else {
            //没有绑定布局,弹出错误日志
            Log.e("BaseAty", "Activity:" + this.getClass().getSimpleName() + " 没有绑定布局");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        mContext = this;
        initView();
        initData();
    }




    protected <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }
    protected T getActivity() {
        return (T) this;
    }

    protected abstract int setLayout();

    protected abstract void initView();

    protected abstract void initData();


}
