package com.jack.api.controller.exceptionHandler;

import com.jack.api.common.enums.CommonCode;
import com.jack.api.common.exceptions.CommonException;
import com.jack.api.common.utils.ApiUtil;
import com.jack.api.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.UndeclaredThrowableException;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class WebExceptionHandler {
    /**
     * 公共异常
     */
    @ResponseBody
    @ExceptionHandler(value = CommonException.class)
    public Result<Object> commonExceptionHandler(CommonException ex){
        if (CommonCode.UNAUTHORIZED.getCode() == ex.getCode()){
            Map<String, String> data = new HashMap<>(2);
//            data.put()
        }
        log.error("公共异常: {}", ExceptionUtils.getStackTrace(ex));
        return ApiUtil.genErrorResult(-1, ex.getMessage());
    }

    /**
     * 业务异常
     */
    @ResponseBody
    @ExceptionHandler(value = IllegalArgumentException.class)
    public Result<Object> assertGateWayExceptionHandler(IllegalArgumentException e){
        log.error("参数异常: {}", ExceptionUtils.getStackTrace(e));
        return ApiUtil.genErrorResult(-1, "参数错误");
    }

    /**
     * valid异常
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<Object> bindingErrorHandler(MethodArgumentNotValidException e){
        log.error("参数校验失败: {}", ExceptionUtils.getStackTrace(e));
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        return ApiUtil.genErrorResult(CommonCode.PARAM_ERROR.getCode(), errors.get(0).getDefaultMessage());
    }

    /**
     * 网络连接异常
     */
    @ResponseBody
    @ExceptionHandler(value = UndeclaredThrowableException.class)
    public Result<Object> connectErrorHandler(UndeclaredThrowableException e){
        if (e.getCause().getClass().equals(ConnectException.class)){
            log.error("网络连接失败失败: {}", ExceptionUtils.getStackTrace(e));
            return ApiUtil.genErrorResult(CommonCode.CONNECT_ERROR.getCode(), CommonCode.CONNECT_ERROR.getMessage());
        }else {
            log.info("动态代理失败, {}", ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
            return ApiUtil.genErrorResult(CommonCode.PROXY_FAILED.getCode(), CommonCode.PROXY_FAILED.getMessage());
        }

    }

    /**
     * 全局异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result<Object> errorHandler(Exception e){
        log.error("未知异常, {}", ExceptionUtils.getStackTrace(e));
        return ApiUtil.genErrorResult(-1, "系统异常");
    }
}
