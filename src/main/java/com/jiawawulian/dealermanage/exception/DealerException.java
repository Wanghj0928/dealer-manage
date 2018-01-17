package com.jiawawulian.dealermanage.exception;

import com.jiawawulian.dealermanage.enums.ResultEnum;

/**
 * 自定义异常处理类
 *
 * @author wanghj
 * @create 2018-01-16 17:04
 **/
public class DealerException extends RuntimeException{

    private Integer code;

    public DealerException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public DealerException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
