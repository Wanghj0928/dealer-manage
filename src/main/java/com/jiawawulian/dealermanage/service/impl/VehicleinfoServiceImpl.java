package com.jiawawulian.dealermanage.service.impl;

import com.jiawawulian.dealermanage.dao.VehicleInfoMapper;
import com.jiawawulian.dealermanage.domain.VehicleInfo;
import com.jiawawulian.dealermanage.service.VehicleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wanghj
 * @create 2018-01-17 15:31
 **/
@Service
public class VehicleinfoServiceImpl implements VehicleinfoService {

    @Autowired
    private VehicleInfoMapper vehicleInfoMapper;

    @Override
    public VehicleInfo selectByPrimaryKey(String vehicleinfoId) {
        return vehicleInfoMapper.selectByPrimaryKey(vehicleinfoId);
    }
}
