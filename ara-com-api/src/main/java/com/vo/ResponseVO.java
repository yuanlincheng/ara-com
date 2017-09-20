package com.vo;

/**
 * 文件名：
 * 作者：tree
 * 时间：2016/8/3
 * 描述：
 * <p>
 * 版权：亚略特
 */
public class ResponseVO {

    private int anyStatus;
    private String msg;
    private String tr;
    private int anyId;
    private String result;
    private String anyData;

    public int getAnyStatus() {
        return anyStatus;
    }

    public void setAnyStatus(int anyStatus) {
        this.anyStatus = anyStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public int getAnyId() {
        return anyId;
    }

    public void setAnyId(int anyId) {
        this.anyId = anyId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAnyData() {
        return anyData;
    }

    public void setAnyData(String anyData) {
        this.anyData = anyData;
    }
}
