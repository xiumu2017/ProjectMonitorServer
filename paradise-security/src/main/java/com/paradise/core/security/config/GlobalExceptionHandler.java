package com.paradise.core.security.config;

import com.paradise.core.common.api.IErrorCode;
import com.paradise.core.common.api.Result;
import com.paradise.core.common.exception.ApiException;
import com.paradise.core.common.exception.AppServiceException;
import com.paradise.core.common.exception.ParamValidateFailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author Paradise
 * @date 2020/2/27
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ParamValidateFailException.class)
    @ResponseBody
    public Result<Object> handleParamValidateFail(ParamValidateFailException exception) {
        log.error(exception.getLocalizedMessage());
        return Result.validateFailed("参数错误，请检查参数");
    }

    @ResponseBody
    @ExceptionHandler(value = UsernameNotFoundException.class)
    public Result<Object> handleUsernameNotFoundException(UsernameNotFoundException exception) {
        return Result.unauthorized(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public Result<Object> handle(ApiException e) {
        log.error(e.getLocalizedMessage(), e);
        if (e.getErrorCode() != null) {
            return Result.failed(e.getErrorCode());
        }
        return Result.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = AppServiceException.class)
    public Result<Object> handle(AppServiceException e) {
        log.error(e.getLocalizedMessage(), e);
        IErrorCode errorCode = e.getErrorCode();
        if (errorCode != null) {
            return Result.failed(e.getErrorCode());
        } else {
            return Result.failed(e.getMessage());
        }
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<Object> handleValidException(MethodArgumentNotValidException e) {
        log.error(e.getLocalizedMessage(), e);
        return Result.validateFailed(getMsg(e.getBindingResult()));
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public Result<Object> handleValidException(BindException e) {
        log.error(e.getLocalizedMessage(), e);
        return Result.validateFailed(getMsg(e.getBindingResult()));
    }

    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public Result<Object> handleRuntimeException(RuntimeException e) {
        log.error(e.getLocalizedMessage(), e);
        return Result.failed("服务器出错了~");
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result<Object> handleException(Exception e) {
        log.error(e.getLocalizedMessage(), e);
        return Result.failed("服务器出错了~");
    }

    private String getMsg(BindingResult bindingResult) {
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return message;
    }
}
