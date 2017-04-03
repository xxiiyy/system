package com.pro.blogL.dto;

import java.io.Serializable;


/**
 * Created by lhd on 2017/3/27.
 * @author lhd
 */
public class Message implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2991603577177353117L;
    private String messageInfo;
    private boolean result;
    private Object object;

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Message [phoneNum="  + messageInfo + ", result=" + result + ", object="
                + object + "]";
    }

}
