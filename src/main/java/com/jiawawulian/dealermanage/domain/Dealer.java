package com.jiawawulian.dealermanage.domain;

import lombok.Data;

@Data
public class Dealer {
    private String dealerId;

    private String lat;

    private String lon;

    private String location;

    private String phone;

    private String username;

    private String password = "123456";

    private Integer role = 0;

}