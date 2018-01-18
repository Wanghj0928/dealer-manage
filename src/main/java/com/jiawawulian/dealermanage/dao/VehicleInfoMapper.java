package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.VehicleInfo;
import org.springframework.stereotype.Component;

@Component
public interface VehicleInfoMapper {

    VehicleInfo selectByPrimaryKey(String vehicleinfoId);
}