package com.jiawawulian.dealermanage.dto;

import lombok.Data;

/**
 * @author wanghj
 * @create 2018-01-18 13:16
 **/
@Data
public class BreakdownDTO {

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

    private String firmName;
}
