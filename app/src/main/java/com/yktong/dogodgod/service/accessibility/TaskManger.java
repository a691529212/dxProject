package com.yktong.dogodgod.service.accessibility;

import android.util.Log;

import com.yktong.dogodgod.bean.TaskBaseBean;

import org.greenrobot.eventbus.EventBus;

import java.io.DataOutputStream;

/**
 * 任务集中管理池
 * Created by vampire on 2017/10/1.
 */

public class TaskManger {
    private static TaskManger ourInstance;

    public static TaskManger getInstance() {
        if (ourInstance == null) {
            synchronized (TaskManger.class) {
                if (ourInstance == null) {
                    ourInstance = new TaskManger();
                }
            }
        }
        return ourInstance;

    }

    private TaskManger() {
    }


    public void doTask(int state) {
        if (!getRootAhth()) {
            EventBus.getDefault().post(new TaskBaseBean("未获取Root权限! "));
            return;
        }

    }

    //判断 是否获取Root权限
    private static synchronized boolean getRootAhth() {
        Process process = null;
        DataOutputStream os = null;
        try {
            process = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(process.getOutputStream());
            os.writeBytes("exit\n");
            os.flush();
            int exitValue = process.waitFor();
            if (exitValue == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.d("*** DEBUG ***", "Unexpected error - Here is what I know: "
                    + e.getMessage());
            return false;
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                process.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}