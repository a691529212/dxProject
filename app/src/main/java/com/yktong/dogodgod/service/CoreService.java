package com.yktong.dogodgod.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.yktong.dogodgod.base.MyApp;
import com.yktong.dogodgod.bean.ToaskBaseBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by vampire on 2017/9/30.
 */

public class CoreService extends Service {
    private Context mContext;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void toastUtil(ToaskBaseBean bean) {
        if (null != bean) {
            Toast toast = new Toast(MyApp.mContext);
            toast.setText(bean.getContent());
            toast.show();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //bind eventBus
        EventBus.getDefault().register(this);
        mContext = this;
    }

}
