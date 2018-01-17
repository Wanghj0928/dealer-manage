package com.jiawawulian.dealermanage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 短信发送参数配置
 *
 * @author wanghj
 * @create 2018-01-16 15:55
 **/
@Data
@ConfigurationProperties(prefix = "SMS")
@Component
public class SMSConfig {

    private String url;

    private String name;

    private String pwd;
}
