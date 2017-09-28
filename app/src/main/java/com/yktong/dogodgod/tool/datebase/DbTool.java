package com.yktong.dogodgod.tool.datebase;

import android.os.Handler;
import android.os.Looper;

import com.litesuits.orm.LiteOrm;
import com.yktong.dogodgod.base.MyApp;
import com.yktong.dogodgod.tool.ThreadPool;

import java.util.ArrayList;

/**
 * Created by vampire on 2017/9/28.
 */

public class DbTool {
    private static DbTool ourInstance;
    private LiteOrm liteOrm;
    private Handler handler = new Handler(Looper.getMainLooper());

    public static DbTool getInstance() {
        if (ourInstance == null) {
            synchronized (DbTool.class) {
                if (ourInstance == null) {
                    ourInstance = new DbTool();
                }
            }
        }
        return ourInstance;

    }

    private DbTool() {
        liteOrm = LiteOrm.newSingleInstance(MyApp.mContext, "dongxiao.db");
        handler = new Handler(Looper.getMainLooper());
    }

    public <T> void saveSingleDate(final T t) {
        ThreadPool.thredP.execute(new Runnable() {
            @Override
            public void run() {
                liteOrm.save(t);
            }
        });
    }

    public <T> void saveDateList(final ArrayList<T> dateList) {
        ThreadPool.thredP.execute(new Runnable() {
            @Override
            public void run() {
                liteOrm.save(dateList);
            }
        });
    }

    public <T> void querDate(final Class<T> tClass, final OnQueryListener<T> listener) {
        ThreadPool.thredP.execute(new Runnable() {
            @Override
            public void run() {
                final ArrayList<T> query = liteOrm.query(tClass);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.queryLinster(query);
                    }
                });
            }
        });
    }

    public <T> void delDate(final Class<T> tClass) {
        ThreadPool.thredP.execute(new Runnable() {
            @Override
            public void run() {
                liteOrm.delete(tClass);
            }
        });
    }

}