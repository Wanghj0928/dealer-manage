package com.jiawawulian.dealermanage.controller;

import com.jiawawulian.dealermanage.VO.ResultVO;
import com.jiawawulian.dealermanage.constant.SMSConstant;
import com.jiawawulian.dealermanage.domain.DAConnect;
import com.jiawawulian.dealermanage.domain.Dealer;
import com.jiawawulian.dealermanage.enums.ResultEnum;
import com.jiawawulian.dealermanage.enums.SingletonSMSEnum;
import com.jiawawulian.dealermanage.exception.DealerException;
import com.jiawawulian.dealermanage.service.DAConnectService;
import com.jiawawulian.dealermanage.service.DealerService;
import com.jiawawulian.dealermanage.utils.KeyUtil;
import com.jiawawulian.dealermanage.utils.PhoneFormatCheckUtils;
import com.jiawawulian.dealermanage.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanghj
 * @create 2018-01-16 17:53
 **/
@RestController
@Slf4j
public class DealerInfoController {

    @Autowired
    private DealerService dealerService;

    @Autowired
    private DAConnectService daConnectService;

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

    @PostMapping("/dealer")
    public ResultVO createAssistant(@RequestParam("dealerId") String dealerId, @RequestParam("phone") String phone) {
        phone = phone.trim();
        if(StringUtils.isEmpty(phone)) {
            return ResultVOUtil.error(ResultEnum.PHONE_EMPTY.getCode(), ResultEnum.PHONE_EMPTY.getMessage());
        } else if(!PhoneFormatCheckUtils.isChinaPhoneLegal(phone)){
            return ResultVOUtil.error(ResultEnum.PHONE_INVALID.getCode(), ResultEnum.PHONE_INVALID.getMessage());
        }
        Dealer dealer = dealerService.selectByPrimaryKey(dealerId);
        Dealer assistant = new Dealer();
        DAConnect daConnect = new DAConnect();
        String newDealerId = KeyUtil.genUniqueKey();
        String newDaconnectId = KeyUtil.genUniqueKey();
        BeanUtils.copyProperties(dealer, assistant);
        assistant.setDealerId(newDealerId);
        assistant.setPhone(phone);
        assistant.setRole(0);
        try {
            dealerService.insert(assistant);
            daConnect.setDaconnectId(newDaconnectId);
            daConnect.setParentId(dealerId);
            daConnect.setDealerId(newDealerId);
            daConnectService.insert(daConnect);
        } catch (Exception e) {
            return ResultVOUtil.error(ResultEnum.INSERT_ERROR.getCode(), ResultEnum.INSERT_ERROR.getMessage());
        }
        return ResultVOUtil.success();
    }

    @GetMapping("/assistant/{active}")
    public ResultVO getAssistantList(@PathVariable("active") Boolean active, @RequestParam("dealerId") String dealerId) {
        List<Dealer> assistantList = daConnectService.selectByParentId(dealerId, active);
        Map map = new HashMap(1);
        map.put("assistantList", assistantList);
        return ResultVOUtil.success(map);
    }

    @PutMapping("/assistant")
    public ResultVO updateAssistant(@RequestParam("connectId") String connectId) {
        DAConnect connect = daConnectService.selectByPrimaryKey(connectId);
        connect.setActive(!connect.getActive());
        try {
            daConnectService.updateByPrimaryKey(connect);
        } catch (Exception e) {
            return ResultVOUtil.error(ResultEnum.UPDATE_ERROR.getCode(), ResultEnum.UPDATE_ERROR.getMessage());
        }
        return ResultVOUtil.success();
    }


}
