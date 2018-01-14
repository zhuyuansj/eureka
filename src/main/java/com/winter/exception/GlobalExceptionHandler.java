package com.winter.exception;

import com.winter.utils.ReturnJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@ResponseBody
class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ReturnJson defaultErrorHandler(HttpServletRequest req, MethodArgumentNotValidException exception) throws Exception {
        //输出错误详细信息
        log.error(exception.getMessage(), exception);
        //按需重新封装需要返回的错误信息
        List<ArgumentInvalidResult> invalidArguments = new ArrayList<ArgumentInvalidResult>();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            ArgumentInvalidResult invalidArgument = new ArgumentInvalidResult();
            invalidArgument.setErrorMessage(error.getDefaultMessage());
            invalidArgument.setFieldCode(error.getField());
            invalidArgument.setRejectedValue(error.getRejectedValue());
            invalidArgument.setExceptionName(exception.getClass().getSimpleName());
            invalidArguments.add(invalidArgument);
            log.warn(error.toString());
        }
        return ReturnJson.fail(invalidArguments);
    }

    @ExceptionHandler(value = CommonException.class)
    public ReturnJson defaultErrorHandler(HttpServletRequest req, CommonException exception) throws Exception {
        //输出错误详细信息
        log.error(exception.getMessage(), exception);
        //解析原错误信息，封装后返回
        CommonResult commonResult = new CommonResult();
        commonResult.setErrorMessage(exception.getMessage());
        commonResult.setExceptionName(exception.getClass().getSimpleName());
        return ReturnJson.json(exception.getResponseCode(), commonResult);
    }


    @ExceptionHandler(value = Exception.class)
    public ReturnJson defaultErrorHandler(HttpServletRequest req, Exception exception) throws Exception {
        //输出错误详细信息
        log.error(exception.getMessage(), exception);
        //解析原错误信息，封装后返回
        CommonResult commonResult = new CommonResult();
        commonResult.setErrorMessage(exception.getMessage());
        commonResult.setExceptionName(exception.getClass().getSimpleName());
        return ReturnJson.fail(commonResult);
    }
}