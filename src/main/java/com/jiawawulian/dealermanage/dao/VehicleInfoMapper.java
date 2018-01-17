package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.VehicleInfo;
import org.springframework.stereotype.Component;

@Component
public interface VehicleInfoMapper {
    int deleteByPrimaryKey(String vehicleinfoId);

    int insert(VehicleInfo record);

    int insertSelective(VehicleInfo record);

    VehicleInfo selectByPrimaryKey(String vehicleinfoId);

    int updateByPrimaryKeySelective(VehicleInfo record);

    int updateByPrimaryKeyWithBLOBs(VehicleInfo record);

    int updateByPrimaryKey(VehicleInfo record);
}