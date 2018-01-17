package com.jiawawulian.dealermanage.service;

import com.jiawawulian.dealermanage.domain.Firm;

public interface FirmService {
    int deleteByPrimaryKey(String firmId);

    int insert(Firm record);

    int insertSelective(Firm record);

    Firm selectByPrimaryKey(String firmId);

    int updateByPrimaryKeySelective(Firm record);

    int updateByPrimaryKey(Firm record);
}
