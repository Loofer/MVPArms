package me.jessyan.mvparms.demo.mvp.model.entity;

import java.io.Serializable;

/**
 * 如果你服务器返回的数据固定为这种方式(字段名可根据服务器更改)
 * 替换范型即可重用BaseJson
 * Created by jess on 26/09/2016 15:19
 * Contact with jess.yan.effort@gmail.com
 */

public class GankBaseJson<T> implements Serializable {
    private T results;

    private String error;

    public T getData() {
        return results;
    }

    public String getError() {
        return error;
    }




}
