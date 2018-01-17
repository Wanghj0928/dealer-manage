package com.jiawawulian.dealermanage.domain;

import lombok.Data;

@Data
public class Connect {
    private String connectId;

    private String dealerId;

    private String assistantId;

    private Byte isDelete;

    private Byte canPush;

    private Byte canLook;
}