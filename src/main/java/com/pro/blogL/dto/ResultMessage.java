package com.pro.blogL.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lhd on 2017/3/27.
 * @author lhd
 */
public class ResultMessage<T> {

    //返回数据信息
    private String message;

    //判断是否是自己预期1（返回结果是自己预期结果），0（出现过异常）
    private boolean result;

    //存放对象数据
    private List<T> list = new ArrayList<T>();

    //存放一些额外数据
    private Map<String,Object> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultMessage{" +
                "message='" + message + '\'' +
                ", result=" + result +
                ", list=" + list +
                ", data=" + data +
                '}';
    }
}
