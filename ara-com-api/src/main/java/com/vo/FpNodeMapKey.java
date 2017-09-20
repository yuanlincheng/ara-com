package com.vo;

import java.io.Serializable;

/**
 * 文件名：
 * 作者：tree
 * 时间：2016/7/13
 * 描述：指纹引擎节点信息表符合主键类
 *
 * 版权：亚略特
 */
public class FpNodeMapKey implements Serializable {
    // 主键属性
    private String masterId;
    // 主键属性
    private String nodeId;

    /**
     * 无参数的public构造方法，必须要有
     */
    public FpNodeMapKey(){}

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * 覆盖hashCode方法，必须要有
     */
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (masterId == null ? 0 : masterId.hashCode());
        result = PRIME * result + (nodeId == null ? 0 : nodeId.hashCode());
        return result;
    }

    /**
     * 覆盖equals方法，必须要有
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        FpNodeMapKey objKey = (FpNodeMapKey)obj;
        if(masterId.equalsIgnoreCase(objKey.masterId) &&
                nodeId.equalsIgnoreCase(objKey.nodeId)) {
            return true;
        }
        return false;
    }
}
