package com.meyok.config.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springmvc的异常处理器
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //拦截所有的异常信息,可在括号内添加类来指定拦截哪些异常
    @ExceptionHandler(Exception.class)
    public R doException(Exception e) {
        //记录日志
        //通知运维
        //通知开发
        e.printStackTrace();
        return new R(false, "服务器故障，请稍后再试！");
    }



}
