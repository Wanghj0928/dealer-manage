package com.jiawawulian.dealermanage.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Connect {
    private String connectId;

    private String dealerId;

    private String assistantId;

    private Boolean active;

    private Date createTime;

    private Date updateTime;
}