package com.yktong.dogodgod.bean.data_bean;

/**
 * Created by Eileen on 2017/9/30.
 * 微信好友
 */

public class WeChatFriend {

    private Integer weChatFriendId;
    /**
     * 好友名字
     */
    private String weChatFriendName;
    /**
     * 外键（用户id）
     */
    private Integer userId;
    /**
     * 添加时间
     */
    private Long addTime;

    public Integer getWeChatFriendId() {
        return weChatFriendId;
    }

    public void setWeChatFriendId(Integer weChatFriendId) {
        this.weChatFriendId = weChatFriendId;
    }

    public String getWeChatFriendName() {
        return weChatFriendName;
    }

    public void setWeChatFriendName(String weChatFriendName) {
        this.weChatFriendName = weChatFriendName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }
}
