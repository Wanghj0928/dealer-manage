package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.Assistant;

public interface AssistantMapper {
    int deleteByPrimaryKey(String assistantId);

    int insert(Assistant record);

    int insertSelective(Assistant record);

    Assistant selectByPrimaryKey(String assistantId);

    int updateByPrimaryKeySelective(Assistant record);

    int updateByPrimaryKey(Assistant record);
}