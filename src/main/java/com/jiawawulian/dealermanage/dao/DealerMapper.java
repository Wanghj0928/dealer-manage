package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.Dealer;

public interface DealerMapper {
    int deleteByPrimaryKey(String dealerId);

    int insert(Dealer record);

    int insertSelective(Dealer record);

    Dealer selectByPrimaryKey(String dealerId);

    int updateByPrimaryKeySelective(Dealer record);

    int updateByPrimaryKey(Dealer record);
}