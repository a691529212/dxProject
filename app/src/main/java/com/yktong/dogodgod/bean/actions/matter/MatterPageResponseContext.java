package com.yktong.dogodgod.bean.actions.matter;

import com.google.gson.annotations.SerializedName;
import com.yktong.dogodgod.bean.actions.ResponseBaseContext;
import com.yktong.dogodgod.bean.data_bean.matter_beans.MatterPageBean;

/**
 * Created by Eileen on 2017/9/30.
 */

public class MatterPageResponseContext extends ResponseBaseContext<MatterPageResponseController> {
    @SerializedName("Librarys")
    private MatterPageBean matterPageBean;

    public MatterPageBean getMatterPageBean() {
        return matterPageBean;
    }

    public void setMatterPageBean(MatterPageBean matterPageBean) {
        this.matterPageBean = matterPageBean;
    }
}
