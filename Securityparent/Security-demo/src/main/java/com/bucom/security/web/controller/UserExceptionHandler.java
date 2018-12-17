package com.bucom.security.web.controller;

import com.bucom.security.exception.UserNullException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNullException.class)//指定那个异常类进行处处理
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object>handleuserNotException(UserNullException une){
        Map<String,Object>map=new HashMap<>();
        map.put("id",une.getId());
        map.put("message",une.getMessage()); //继承了runtimException,所以可以拿到getmessage();

        return map;
    }
}
