package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.Firm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
public interface FirmMapper {

    Firm selectByPrimaryKey(String firmId);
}