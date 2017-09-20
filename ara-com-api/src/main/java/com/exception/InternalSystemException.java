package com.exception;

/**
 * 文件名：
 * 作者：tree
 * 时间：2017/3/2
 * 描述：自定义的系统内部异常
 * 版权：亚略特
 */
public class InternalSystemException extends Exception {
    public InternalSystemException(String message){
        super(message);
    }
}
