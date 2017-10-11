package com.yktong.dogodgod.bean.actions;

/**
 * Created by Eileen on 2017/9/29.
 */

public class ResponseBaseBean<T extends ResponseBaseController> {

    private Integer code;
    private String errorMessage;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
