package com.jiawawulian.dealermanage.service.impl;

import com.jiawawulian.dealermanage.dao.DAConnectMapper;
import com.jiawawulian.dealermanage.domain.DAConnect;
import com.jiawawulian.dealermanage.domain.Dealer;
import com.jiawawulian.dealermanage.service.DAConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wanghj
 * @create 2018-01-19 10:47
 **/
@Service
public class DAConnectServiceImpl implements DAConnectService {

    @Autowired
    private DAConnectMapper daConnectMapper;
    @Override
    public int insert(DAConnect record) {
        return daConnectMapper.insert(record);
    }

    @Override
    public DAConnect selectByPrimaryKey(String daconnectId) {
        return daConnectMapper.selectByPrimaryKey(daconnectId);
    }

    @Override
    public List<Dealer> selectByParentId(String parentId, Boolean active) {
       return daConnectMapper.selectByParentId(parentId, active);
    }

    @Override
    public int updateByPrimaryKey(DAConnect record) {
        return daConnectMapper.updateByPrimaryKey(record);
    }
}
