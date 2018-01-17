package com.jiawawulian.dealermanage.utils;

import java.util.Random;

/**
 * 验证码生成工具类
 *
 * @author wanghj
 * @create 2018-01-16 17:09
 **/
public class CodeUtil {

    public static String getVerifyCode() {
        Random random = new Random();
        String code = String.valueOf(random.nextDouble()).substring(2, 8);
        return code;
    }
}
