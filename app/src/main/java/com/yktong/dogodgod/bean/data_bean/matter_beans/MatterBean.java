package com.yktong.dogodgod.bean.data_bean.matter_beans;

/**
 * Created by Eileen on 2017/9/30.
 */

public class MatterBean {
    /**
     * 主键
     */
    private Integer libraryId;
    /**
     * 公司id(外键)
     */
    private Integer companyId;
    /**
     * 用户id(外键)
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 标题
     */
    private String headLine;
    /**
     * 内容（链接）
     */
    private String content;
    /**
     * 添加时间
     */
    private Long addTime;
    /**
     * 类别（外键）
     */
    private Integer libraryStortId;
    /**
     * 类别（图文/链接）
     */
    private Integer libraryStage;
    /**
     * 链接
     */
    private String interLinkage;
    /**
     * 使用次数
     */
    private Integer useTimes;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Integer getLibraryStortId() {
        return libraryStortId;
    }

    public void setLibraryStortId(Integer libraryStortId) {
        this.libraryStortId = libraryStortId;
    }

    public Integer getLibraryStage() {
        return libraryStage;
    }

    public void setLibraryStage(Integer libraryStage) {
        this.libraryStage = libraryStage;
    }

    public String getInterLinkage() {
        return interLinkage;
    }

    public void setInterLinkage(String interLinkage) {
        this.interLinkage = interLinkage;
    }

    public Integer getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(Integer useTimes) {
        this.useTimes = useTimes;
    }
}
