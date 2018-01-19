package com.jiawawulian.dealermanage.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Data
@DynamicUpdate
public class DAConnect {
    private String daconnectId;

    private String dealerId;

    private String parentId;

    private Boolean active = true;

    private Date createTime;

    private Date updateTime;
}