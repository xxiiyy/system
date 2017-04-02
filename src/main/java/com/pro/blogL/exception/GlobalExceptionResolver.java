package com.pro.blogL.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lhd on 2017/3/28.
 * @author lhd
 */

public class GlobalExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request
            , HttpServletResponse response, Object o, Exception e) {
        String message = null;
        ModelAndView mav = new ModelAndView();
        if(e instanceof UserException){
            message = ((UserException)e).getMessage();
            mav.setViewName("/error.jsp");
            mav.addObject("errorMsg",message);
        }else{
            message = "未知错误";
            mav.setViewName("/error.jsp");
            mav.addObject("errorMsg",message);
        }
        return mav;
    }
}
