package com.winter.exception;

import java.io.Serializable;

/**
 * 接口调用失败的异常信息
 */
public class CommonResult implements Serializable {
    /**
     * 异常类
     */
    private String exceptionName;
    /**
     * 错误原因
     */
    private String errorMessage;

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}