package com.vo;

import java.io.Serializable;

/**
 * 文件名：
 * 作者：tree
 * 时间：2016/6/23
 * 描述：指纹特征表符合主键类
 *
 * 版权：亚略特
 */
public class TemplateMapKey implements Serializable {
    // 主键属性
    private String personId;
    // 主键属性
    private String fpIndexCode;
    // 主键属性
    private String fpTemplateNo;

    /**
     * 无参数的public构造方法，必须要有
     */
    public TemplateMapKey(){}

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFpIndexCode() {
        return fpIndexCode;
    }

    public void setFpIndexCode(String fpIndexCode) {
        this.fpIndexCode = fpIndexCode;
    }

    public String getFpTemplateNo() {
        return fpTemplateNo;
    }

    public void setFpTemplateNo(String fpTemplateNo) {
        this.fpTemplateNo = fpTemplateNo;
    }

    /**
     * 覆盖hashCode方法，必须要有
     */
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (fpIndexCode == null ? 0 : fpIndexCode.hashCode());
        result = PRIME * result + (personId == null ? 0 : personId.hashCode());
        result = PRIME * result + (fpTemplateNo ==null ? 0 : fpTemplateNo.hashCode());
        return result;
    }

    /**
     * 覆盖equals方法，必须要有
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        TemplateMapKey objKey = (TemplateMapKey)obj;
        if(fpIndexCode.equalsIgnoreCase(objKey.fpIndexCode) &&
                personId.equalsIgnoreCase(objKey.personId) &&
                fpTemplateNo.equalsIgnoreCase(objKey.fpTemplateNo)) {
            return true;
        }
        return false;
    }
}
