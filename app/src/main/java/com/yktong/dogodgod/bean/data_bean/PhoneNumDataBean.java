package com.yktong.dogodgod.bean.data_bean;

/**
 * Created by Eileen on 2017/9/30.
 * 数据管理中的手机号码bean
 *
 */

public class PhoneNumDataBean {
    /**
     * 主键
     */
    private Integer fileId;

    /**
     * 文件名字
     */
    private String fileName;

    /**
     * 上传时间
     */
    private String addTime;

    /**
     * 上传类别(0未使用,1使用中,2已用完)
     */
    private String fileType;

    /**
     * 外键
     */
    private Integer companyId;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
