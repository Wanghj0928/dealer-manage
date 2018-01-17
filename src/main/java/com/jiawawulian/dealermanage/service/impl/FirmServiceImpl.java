package com.jiawawulian.dealermanage.service.impl;

import com.jiawawulian.dealermanage.dao.FirmMapper;
import com.jiawawulian.dealermanage.domain.Firm;
import com.jiawawulian.dealermanage.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wanghj
 * @create 2018-01-17 16:00
 **/
@Service
public class FirmServiceImpl implements FirmService {

    @Autowired
    private FirmMapper firmMapper;

    @Override
    public int deleteByPrimaryKey(String firmId) {
        return 0;
    }

    @Override
    public int insert(Firm record) {
        return 0;
    }

    @Override
    public int insertSelective(Firm record) {
        return 0;
    }

    @Override
    public Firm selectByPrimaryKey(String firmId) {
        return firmMapper.selectByPrimaryKey(firmId);
    }

    @Override
    public int updateByPrimaryKeySelective(Firm record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Firm record) {
        return 0;
    }
}
