package com.yktong.dogodgod.bean.data_bean;

/**
 * Created by Eileen on 2017/9/30.
 * 任务
 */

public class TaskBean {

    private Integer taskId;
    /**
     * 启动时间
     */
    private Long startTime;
    /**
     * 时间间隔
     */
    private Integer interValTime;
    /**
     * 性别(性别(1/男；2/女；3/不限))
     */
    private Integer sex;
    /**
     * 添加数量
     */
    private Integer num;
    /**
     * 验证/评论内容
     */
    private String checkMage;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 营销对象(1/好友；2/群；3/标签)
     */
    private Integer cMarketee1;
    /**
     * 任务类型
     */
    private Integer taskType;
    /**
     * 微信群名
     */
    private String weChatQun;
    /**
     * 文件id
     */
    private Integer fileId;
    /**
     * 互动方式（1：点赞 2：朋友圈）
     */
    private Integer interactive;
    /**
     * 素材id
     */
    private Integer libraryId;
    /**
     * 提交时间
     */
    private Long submitTime;
    /**
     * 提交人
     */
    private Integer submitter;
    /**
     * 任务状态（0：未执行 1：执行）
     */
    private Integer taskStage;

    /**
     * 小程序名称
     */
    private String xcxName;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Integer getInterValTime() {
        return interValTime;
    }

    public void setInterValTime(Integer interValTime) {
        this.interValTime = interValTime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCheckMage() {
        return checkMage;
    }

    public void setCheckMage(String checkMage) {
        this.checkMage = checkMage;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getcMarketee1() {
        return cMarketee1;
    }

    public void setcMarketee1(Integer cMarketee1) {
        this.cMarketee1 = cMarketee1;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getWeChatQun() {
        return weChatQun;
    }

    public void setWeChatQun(String weChatQun) {
        this.weChatQun = weChatQun;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getInteractive() {
        return interactive;
    }

    public void setInteractive(Integer interactive) {
        this.interactive = interactive;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public Long getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Long submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getSubmitter() {
        return submitter;
    }

    public void setSubmitter(Integer submitter) {
        this.submitter = submitter;
    }

    public Integer getTaskStage() {
        return taskStage;
    }

    public void setTaskStage(Integer taskStage) {
        this.taskStage = taskStage;
    }

    public String getXcxName() {
        return xcxName;
    }

    public void setXcxName(String xcxName) {
        this.xcxName = xcxName;
    }
}
