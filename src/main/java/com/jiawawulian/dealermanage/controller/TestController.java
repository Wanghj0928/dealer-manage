package com.jiawawulian.dealermanage.controller;

import com.jiawawulian.dealermanage.dao.VehicleInfoMapper;
import com.jiawawulian.dealermanage.domain.Firm;
import com.jiawawulian.dealermanage.domain.VehicleInfo;
import com.jiawawulian.dealermanage.service.FirmService;
import com.jiawawulian.dealermanage.service.VehicleinfoService;
import com.jiawawulian.dealermanage.utils.CodeUtil;
import com.jiawawulian.dealermanage.utils.SMSSendUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author wanghj
 * @create 2018-01-16 16:32
 **/
@RestController
@Slf4j
public class TestController {

    @Autowired
    private SMSSendUtil smsSendUtil;

    @Autowired
    private VehicleinfoService vehicleinfoService;

    @Autowired
    private FirmService firmService;

    @RequestMapping("/sendSms")
    public String sendSms() {
        String verifyCode = CodeUtil.getVerifyCode();
        String content = "短信验证码为：" + verifyCode + "，请勿将验证码提供给他人。";
        String result = null;
        result = smsSendUtil.sendSMS(content, "15700082812", "保镖电子");
        log.info("【短信发送结果】: " + result);
        return result;
    }

    @RequestMapping("/vehicleinfo")
    public VehicleInfo getVehicleinfo(@RequestParam("vehicleinfoId") String vehicleinfoId) {
        VehicleInfo vehicleInfo = vehicleinfoService.selectByPrimaryKey(vehicleinfoId);
        return vehicleInfo;
    }

    @RequestMapping("/firm")
    public Firm getFirm(@RequestParam("firmId") String firmId) {
        Firm firm = firmService.selectByPrimaryKey(firmId);
        return firm;
    }
}
