package com.jiawawulian.dealermanage.controller;

import com.jiawawulian.dealermanage.VO.ResultVO;
import com.jiawawulian.dealermanage.enums.ResultEnum;
import com.jiawawulian.dealermanage.enums.SingletonSMSEnum;
import com.jiawawulian.dealermanage.utils.CodeUtil;
import com.jiawawulian.dealermanage.utils.PhoneFormatCheckUtils;
import com.jiawawulian.dealermanage.utils.ResultVOUtil;
import com.jiawawulian.dealermanage.utils.SMSSendUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信发送接口
 *
 * @author wanghj
 * @create 2018-01-17 11:18
 **/
@RestController
@Slf4j
public class SendSMSController {

    @Autowired
    private SMSSendUtil smsSendUtil;

    @RequestMapping("/sendSMS")
    public ResultVO sendSMS(@RequestParam("phone") String phone) {
        phone = phone.trim();
        if(StringUtils.isEmpty(phone)) {
            return ResultVOUtil.error(ResultEnum.PHONE_EMPTY.getCode(), ResultEnum.PHONE_EMPTY.getMessage());
        } else if(!PhoneFormatCheckUtils.isChinaPhoneLegal(phone)){
            return ResultVOUtil.error(ResultEnum.PHONE_INVALID.getCode(), ResultEnum.PHONE_INVALID.getMessage());
        }
        String verifyCode = CodeUtil.getVerifyCode();
        String content = "短信验证码为：" + verifyCode + "，请勿将验证码提供给他人。";
        String resultStr = smsSendUtil.sendSMS(content, phone, "保镖电子");
        String firstLetter = "0";
        if(!firstLetter.equals(resultStr.substring(0, 1))) {
            return ResultVOUtil.error(ResultEnum.SMS_SEND_FAIL.getCode(), ResultEnum.SMS_SEND_FAIL.getMessage());
        }
        SingletonSMSEnum.INSTANCE.addCodeSession(phone, verifyCode);
        long generatorDate = System.currentTimeMillis();
        SingletonSMSEnum.INSTANCE.addDateSession(phone, generatorDate);
        log.info("【短信发送结果】: " + resultStr);
        return ResultVOUtil.success(ResultEnum.SMS_SEND_SUCCESS.getCode(), ResultEnum.SMS_SEND_SUCCESS.getMessage());
    }
}
