package com.jiawawulian.dealermanage.enums;

import lombok.Getter;

/**
 * 经销商角色枚举类
 *
 * @author wanghj
 * @create 2018-01-19 10:35
 **/
@Getter
public enum RoleEnum implements CodeEnum {
    ROLE_ASSISTANT(0, "店员"),
    ROLE_DEALER(1, "法定注册人")
    ;

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
