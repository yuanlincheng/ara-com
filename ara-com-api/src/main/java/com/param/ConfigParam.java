package com.param;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tree on 2017/5/4.
 */
public class ConfigParam {
    /**
     * 每页显示的数据条数
     */
    public static final int PAGE_COUNT=10;

    /**
     * TrustAfis配置文件
     */
    public static final String SETTING_FILE = "\\WEB-INF\\classes\\config.properties";

    /**
     * 超级管理员用户名
     */
    public static final String ADMINISTRATOR = "admin";

    /**
     * COOKIE中的TrustAfis管理员字段
     */
    public static final String MANAGER_COOKIE = "trustaifs.manager.cookie";

    public static final String SYSTEM_LOG = "SYSTEM";

    //此处默认引擎故障编码为 1，如果修改了引擎故障编码，此处需要修改
    public static final int ENGINE_WARN_CODE = 1;
    public static final int ENGINE_FAULT_CODE = 2;

    /**
     * 系统初始数据内存区
     */
    public static Map<String,String> SYSTEM_INIT_DATA = new HashMap<String,String>();
    public static Map<String, Object> SYSTEM_STORE_DATA = new HashMap<>();
    //临时数据内存区
    public static Map<String,String> SYSTEM_TEMPORARY_DATA = new HashMap<String,String>();
    //批量捞取指纹图片
    public static String IMAGE_SAVE_ADDRESS = "C:/make/imgfile";
    public static String IMAGE_SAVE_TYPES = "WSQ";
    public static String EXPORT_FILE_PRE = "ARA_AFIS_";

    public static Map<String,Long> ANALYSE_DATA = new HashMap<String,Long>();
    public static Map<Integer,Long> FP_ADD_DATA = new HashMap<Integer,Long>();
    public static Map<Integer,Long> BUS_TYPE_DATA = new HashMap<Integer,Long>();
    public static Map<Integer,Long> SERVER_STATU_DATA = new HashMap<Integer,Long>();
    public static Map<Integer,Long> TASK_STATU_DATA = new HashMap<Integer,Long>();

    public static final int QUERY_TYPE_ALL = 1;
    public static final int QUERY_TYPE_SOME = 2;

    public enum SYSTEM_MODULE {
        MAS("MAS"), SUP("SUP"), MON("MON"), MAN("MAN");
        private final String elementName;
        SYSTEM_MODULE(String elementName){
            this.elementName = elementName;
        }
        public String getElementName() {
            return elementName;
        }
    }

    public enum ORDER_LEVEL {
        URGENT("1"), MEDIUM("2"), DELAY("3");
        private final String elementName;
        ORDER_LEVEL(String elementName){
            this.elementName = elementName;
        }
        public String getElementName() {
            return elementName;
        }
    }

    public enum ACTIVE_STATU {
        AVAILABLE("E"), DISABLED("D");
        private final String elementName;
        ACTIVE_STATU(String elementName){
            this.elementName = elementName;
        }
        public String getElementName() {
            return elementName;
        }
    }

    public enum PROGRAM_FLAG {
        SUCCESS("Y"), FAIL("N");
        private final String elementName;
        PROGRAM_FLAG(String elementName){
            this.elementName = elementName;
        }
        public String getElementName() {
            return elementName;
        }
    }

    public enum TIME_TYPE {
        YEAR("Y"),MONTH("MO"), DAY("D"), HOUR("H"), MINUTE("MI"), SECOND("s");
        private final String elementName;
        TIME_TYPE(String elementName){
            this.elementName = elementName;
        }
        public String getElementName() {
            return elementName;
        }
    }

    public enum ENGINE_TYPE {
        MASTER("0"), NODE("1");
        private final String elementName;
        ENGINE_TYPE(String elementName){
            this.elementName = elementName;
        }
        public String getElementName() {
            return elementName;
        }
    }

    public enum OPERATE_TYPE {
        ADD("I"), UPDATE("U"), DELETE("D");
        private final String elementName;
        OPERATE_TYPE(String elementName){
            this.elementName = elementName;
        }
        public String getElementName() {
            return elementName;
        }
    }

    public enum EXPORT_FILE_TYPE {
        EXCEL("EXCEL"), LOG("LOG"),EXCEL_FILE_END(".xls"),LOG_FILE_END(".log");
        private final String elementName;
        EXPORT_FILE_TYPE(String elementName){
            this.elementName = elementName;
        }
        public String getElementName() {
            return elementName;
        }
    }
}
