package com.yktong.dogodgod.value;

/**
 * Created by vampire on 2017/10/1.
 */

public interface StringValue {
    String WORK_STATE = "workState";
    String GROUP_NAME = "geoup_name";

    int STATE_NORMAL = 0; // 状态常规
    int STATE_ADD_LINK = 1; //添加联系人
    int STATE_PRAISE = 2; //点赞
    int STATE_QUERY_FRIENDS_NUMS = 3; // 统计好友数;
    int STATE_QUERY_GROUPS = 4; // 校验群组列表
    int STATE_ADD_BY_GROUP = 5; //通过群组添加
    int STATE_INTREACT = 6;  // 统计今日聊天   ps. 废弃
    int STATE_COMMENT =7 ; // 统计今日互动
    int STATE_SEND_SNS = 8; // send to sns;
    int STATE_SNED_FRIEND =9 ;  // send msg to friend
    int STATE_SEND_MINI_PROJECT = 10 ; // send miniProject to friend
    int STATE_GET_NICK = 11 ; // get user nick name

}
