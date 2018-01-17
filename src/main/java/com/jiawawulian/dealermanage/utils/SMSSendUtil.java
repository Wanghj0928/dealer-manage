package com.jiawawulian.dealermanage.utils;

import com.jiawawulian.dealermanage.config.SMSConfig;
import com.jiawawulian.dealermanage.exception.DealerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Random;

@Component
public class SMSSendUtil {

    @Autowired
    private SMSConfig smsConfig;

    /**
     * @param content
     * @param mobile
     * @param sign
     * @return
     * @throws IOException
     */
    public String sendSMS(String content, String mobile, String sign) {
        //发送内容
//		String content = " JAVA示例测试"; 
//		String sign="签名";

        // 创建StringBuffer对象用来操作字符串
        StringBuffer sb = new StringBuffer(smsConfig.getUrl());

        // 向StringBuffer追加用户名
        sb.append("name=" + smsConfig.getName());

        // 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
        sb.append("&pwd=" + smsConfig.getPwd());

        InputStream is = null;

        // 向StringBuffer追加手机号码
        try {
            sb.append("&mobile=" + URLEncoder.encode(mobile, "UTF-8"));

            // 向StringBuffer追加消息内容转URL标准码
            sb.append("&content=" + URLEncoder.encode(content, "UTF-8"));

            //追加发送时间，可为空，为空为及时发送
            sb.append("&stime=");

            //加签名
            sb.append("&sign=" + URLEncoder.encode(sign, "UTF-8"));

            //type为固定值pt  extno为扩展码，必须为数字 可为空
            sb.append("&type=pt&extno=");
            // 创建url对象
            //String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
            System.out.println("sb:" + sb.toString());
            URL url = new URL(sb.toString());

            // 打开url连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置url请求方式 ‘get’ 或者 ‘post’
            connection.setRequestMethod("POST");

            // 发送
            is = url.openStream();
        } catch (IOException e) {
            throw new DealerException("短信发送失败", 101);
        }

        //转换返回值
        String returnStr = convertStreamToString(is);

        // 返回结果为‘0，20140009090990,1，提交成功’ 发送成功   具体见说明文档
        System.out.println(returnStr);
        // 返回发送结果

        return returnStr;
    }

    /**
     * 转换返回值类型为UTF-8格式.
     *
     * @param is
     * @return
     */
    private String convertStreamToString(InputStream is) {
        StringBuilder sb1 = new StringBuilder();
        byte[] bytes = new byte[4096];
        int size = 0;

        try {
            while ((size = is.read(bytes)) > 0) {
                String str = new String(bytes, 0, size, "UTF-8");
                sb1.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb1.toString();
    }

    public String getRandomUid(int max) {
        Random r = new Random();
        return String.valueOf(r.nextDouble()).substring(2, max);
    }
}
