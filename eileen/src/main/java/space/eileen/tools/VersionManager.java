package space.eileen.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

import java.io.File;
import java.util.Date;

import space.eileen.free_util.DialogAppUpdate;

/**
 * Created by Eileen on 2017/8/8.
 */

public abstract class VersionManager {
    protected Activity activity;
    protected void showUpdateMsgView(final Context context, final String content, final int versionCode, final String url) {
        new DialogAppUpdate(context, content, new DialogAppUpdate.OkCancelDialogListener() {
            @Override
            public void onOkClick() {
                    String apkName = new Date().getTime() + "_" + versionCode + ".apk";
             doDownloadApk(url, apkName);

            }

            @Override
            public void onCancelClick() {

            }
        }).show();

    }

    protected abstract void doDownloadApk(String url, String apkName);


    protected int getVersionCode() {
        try {
            return activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }


}
