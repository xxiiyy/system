package com.pro.blogL.exception;

/**
 * Created by lhd on 2017/3/28.
 * @author lhd
 */
public class UserException extends Exception{

    //异常信息
    private String message;

    public UserException(String message){
        super(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
