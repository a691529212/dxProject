package com.yktong.dogodgod.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

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
        mContext = this;
        initView();
        initData();
    }

    protected T getActivity() {
        return (T) this;
    }

    protected abstract int setLayout();

    protected abstract void initView();

    protected abstract void initData();


}
