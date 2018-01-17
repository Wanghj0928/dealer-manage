package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.VehicleInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class VehicleInfoMapperTest {

    @Autowired
    private VehicleInfoMapper vehicleInfoMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {
        VehicleInfo vehicleInfo = vehicleInfoMapper.selectByPrimaryKey("003ed60c77b743cc80a549726c223982");
        Assert.assertNotNull(vehicleInfo);
    }

}