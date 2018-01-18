package com.jiawawulian.dealermanage.controller;

import com.jiawawulian.dealermanage.VO.ResultVO;
import com.jiawawulian.dealermanage.constant.SMSConstant;
import com.jiawawulian.dealermanage.enums.ResultEnum;
import com.jiawawulian.dealermanage.enums.SingletonSMSEnum;
import com.jiawawulian.dealermanage.exception.DealerException;
import com.jiawawulian.dealermanage.service.DealerService;
import com.jiawawulian.dealermanage.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghj
 * @create 2018-01-16 17:53
 **/
@RestController
@Slf4j
public class DealerInfoController {

    @Autowired
    private DealerService dealerService;

    @RequestMapping("/login")
    public ResultVO loginByUsernameAndPassword(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (!dealerService.checkNameAndPass(username, password)) {
            return ResultVOUtil.error(1, "用户名或者密码不匹配");
        }
        return ResultVOUtil.success();
    }

    @RequestMapping("/login/code")
    public ResultVO loginByVerifyCode(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        if (StringUtils.isEmpty(phone)) {
            throw new DealerException(ResultEnum.PHONE_EMPTY);
        }
        if(StringUtils.isEmpty(code)) {
            throw new DealerException(ResultEnum.SMS_CODE_EMPTY);
        }
        Long generatorDate = SingletonSMSEnum.INSTANCE.getDateSession(phone);
        if(generatorDate == null) {
            log.error("【登录失败】"+ ResultEnum.SMS_CODE_INVALID.getMessage());
            return ResultVOUtil.error(ResultEnum.SMS_CODE_INVALID.getCode(), ResultEnum.SMS_CODE_INVALID.getMessage());
        } else if(System.currentTimeMillis() - generatorDate > SMSConstant.EXPIRE_TIME) {
            log.error("【登录失败】"+ ResultEnum.SMS_CODE_INVALID.getMessage());
            return ResultVOUtil.error(ResultEnum.SMS_CODE_EXPIRE.getCode(), ResultEnum.SMS_CODE_EXPIRE.getMessage());
        }
        String verifyCode = SingletonSMSEnum.INSTANCE.getCodeSession(phone);
        if(!code.equals(verifyCode)) {
            return ResultVOUtil.error(ResultEnum.SMS_CODE_ERROR.getCode(), ResultEnum.SMS_CODE_ERROR.getMessage());
        }
        SingletonSMSEnum.INSTANCE.deleteCodeSession(phone);
        SingletonSMSEnum.INSTANCE.deleteDateSession(phone);
        return ResultVOUtil.success(0, ResultEnum.LOGIN_SUCCESS.getMessage());
    }
}
