package com.jiawawulian.dealermanage.domain;

import lombok.Data;

@Data
public class Breakdown {
    private String breakdownsId;

    private String memberId;

    private String content;

    private String phone;

    private String lat;

    private String lon;

    private String location;

    private String recordDate;

    private String vehicleId;

    private String type;

    private String pictureName;

    private String readstate;
}