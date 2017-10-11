package com.yktong.dogodgod.bean.data_bean;

/**
 * Created by Eileen on 2017/9/30.
 * 微信群
 */

public class WeChatGroup {

    /**
     * 主键
     */
    private Integer weChatQunId;
    /**
     * 群名称
     */
    private String weChatQunName;
    /**
     * 外键(用户id)
     */
    private Integer userId;

    public String getWeChatQunName() {
        return weChatQunName;
    }

    public void setWeChatQunName(String weChatQunName) {
        this.weChatQunName = weChatQunName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWeChatQunId() {

        return weChatQunId;
    }

    public void setWeChatQunId(Integer weChatQunId) {
        this.weChatQunId = weChatQunId;
    }
}
