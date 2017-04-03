package com.pro.blogL.interceptor;

import com.pro.blogL.entrty.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lhd on 2017/3/28.
 * @author lhd
 */
public class PathInterceptor implements HandlerInterceptor {


    //设置不需要拦截的路径
    private String[] urlAnon = {};

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object o) throws Exception {
        String url = request.getRequestURI().toString();
        if(urlAnon!=null&&urlAnon.length>0){
            for (String urlanon:urlAnon){
                if(url.contains(urlanon)){
                    return true;
                }
            }
        }
        Subject subject = SecurityUtils.getSubject();
        User user  = (User)subject.getPrincipal();
        if(user == null){
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request,response);
            return false;
        }
        if(url.equals("/test")){
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object o, Exception e) throws Exception {

    }

    public void setUrlAnon(String[] urlAnon) {
        this.urlAnon = urlAnon;
    }

    public String[] getUrlAnon() {
        return urlAnon;
    }
}
