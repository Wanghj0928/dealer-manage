package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.DAConnect;
import com.jiawawulian.dealermanage.domain.Dealer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DAConnectMapper {
    int deleteByPrimaryKey(String daconnectId);

    int insert(DAConnect record);

    int insertSelective(DAConnect record);

    DAConnect selectByPrimaryKey(String daconnectId);

    List<Dealer> selectByParentId(String parentId, Boolean active);

    int updateByPrimaryKeySelective(DAConnect record);

    int updateByPrimaryKey(DAConnect record);

}