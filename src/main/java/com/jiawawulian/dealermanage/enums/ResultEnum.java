package com.jiawawulian.dealermanage.enums;

import lombok.Getter;

@Getter
public enum ResultEnum implements CodeEnum{
    SUCCESS(0, "成功"),
    FAIL(1, "参数不正确"),
    PHONE_INVALID(10, "无效的手机号"),
    PHONE_EMPTY(11, "手机号不能为空"),
    SMS_SEND_FAIL(12, "消息发送失败"),
    SMS_SEND_SUCCESS(13, "消息发送成功"),
    SMS_CODE_EXPIRE(14, "验证码已失效，请重新获取"),
    SMS_CODE_INVALID(15, "验证码无效"),
    SMS_CODE_EMPTY(16, "验证码不能为空"),
    SMS_CODE_ERROR(17, "验证码错误"),
    LOGIN_SUCCESS(18, "登录成功"),
    DEALERID_EMPTY(19, "经销商id为空"),
    INSERT_ERROR(20, "数据库插入数据出错"),
    UPDATE_ERROR(20, "更新数据出错")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
