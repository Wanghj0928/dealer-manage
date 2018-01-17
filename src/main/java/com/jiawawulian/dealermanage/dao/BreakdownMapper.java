package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.Breakdown;

public interface BreakdownMapper {
    int deleteByPrimaryKey(String breakdownsId);

    int insert(Breakdown record);

    int insertSelective(Breakdown record);

    Breakdown selectByPrimaryKey(String breakdownsId);

    int updateByPrimaryKeySelective(Breakdown record);

    int updateByPrimaryKeyWithBLOBs(Breakdown record);

    int updateByPrimaryKey(Breakdown record);
}