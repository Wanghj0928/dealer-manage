package com.jiawawulian.dealermanage.domain;

import lombok.Data;

@Data
public class Assistant {
    private String assistantId;

    private String assistantName;

    private String username;

    private String password;

    private String phone;

    private Boolean isDelete;
}