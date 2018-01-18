package com.jiawawulian.dealermanage.service.impl;

import com.jiawawulian.dealermanage.dao.BreakdownMapper;
import com.jiawawulian.dealermanage.domain.Breakdown;
import com.jiawawulian.dealermanage.dto.BreakdownDTO;
import com.jiawawulian.dealermanage.service.BreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wanghj
 * @create 2018-01-18 12:58
 **/
@Service
public class BreakdownServiceImpl implements BreakdownService {

    @Autowired
    private BreakdownMapper breakdownMapper;
    @Override
    public Breakdown selectByPrimaryKey(String breakdownsId) {
        return breakdownMapper.selectByPrimaryKey(breakdownsId);
    }

    @Override
    public List<BreakdownDTO> selectByDealerId(String dealerId) {
        return breakdownMapper.selectByDealerId(dealerId);
    }
}
