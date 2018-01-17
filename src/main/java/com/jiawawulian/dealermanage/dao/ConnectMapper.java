package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.Connect;

public interface ConnectMapper {
    int deleteByPrimaryKey(String connectId);

    int insert(Connect record);

    int insertSelective(Connect record);

    Connect selectByPrimaryKey(String connectId);

    int updateByPrimaryKeySelective(Connect record);

    int updateByPrimaryKey(Connect record);
}