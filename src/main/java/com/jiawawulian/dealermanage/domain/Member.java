package com.jiawawulian.dealermanage.domain;

import lombok.Data;

@Data
public class Member {
    private String memberId;

    private String userName;

    private String realName;

    private String password;

    private String phone;

    private String phoneType;

    private String registerTime;

    private String softwareType;

    private String remark;

    private String sessionId;
}