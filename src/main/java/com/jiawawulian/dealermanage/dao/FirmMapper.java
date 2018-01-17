package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.Firm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
public interface FirmMapper {
    int deleteByPrimaryKey(String firmId);

    int insert(Firm record);

    int insertSelective(Firm record);

    Firm selectByPrimaryKey(String firmId);

    int updateByPrimaryKeySelective(Firm record);

    int updateByPrimaryKey(Firm record);
}