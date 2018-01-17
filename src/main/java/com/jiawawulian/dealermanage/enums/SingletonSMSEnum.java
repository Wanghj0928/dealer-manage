package com.jiawawulian.dealermanage.enums;

import java.util.HashMap;
import java.util.Map;

public enum SingletonSMSEnum {

    INSTANCE;

    private static Map<String, String> verifyCodeMap = new HashMap<>();

    private static Map<String, Long> dateMap = new HashMap<>();

    /**
     * 添加验证码session
     * @param key
     * @param code
     */
    public void addCodeSession(String key, String code) {
        verifyCodeMap.put(key, code);
    }

    /**
     * 删除验证码session
     * @param key
     */
    public void deleteCodeSession(String key) {
        verifyCodeMap.remove(key);
    }

    /**
     * 获取验证码session
     * @param key
     * @return
     */
    public String getCodeSession(String key) {
        return verifyCodeMap.get(key);
    }

    /**
     * 添加生成日期session
     * @param key
     * @param date
     */
    public void addDateSession(String key, long date) {
        dateMap.put(key, date);
    }

    /**
     * 删除生成日期session
     * @param key
     */
    public void deleteDateSession(String key) {
        dateMap.remove(key);
    }

    /**
     * 获取生成日期session
     * @param key
     * @return
     */
    public Long getDateSession(String key) {
        return dateMap.get(key);
    }
}
