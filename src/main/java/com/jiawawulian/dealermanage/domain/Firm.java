package com.jiawawulian.dealermanage.domain;

import lombok.Data;

@Data
public class Firm {
    private String firmId;

    private String firmName;

    private String parentId;

    private String firmUrl;

    private String logo;
}