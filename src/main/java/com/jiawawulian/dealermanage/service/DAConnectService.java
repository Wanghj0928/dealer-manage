package com.jiawawulian.dealermanage.service;

import com.jiawawulian.dealermanage.domain.DAConnect;
import com.jiawawulian.dealermanage.domain.Dealer;

import java.util.List;

/**
 * @author wanghj
 * @create 2018-01-19 10:46
 **/
public interface DAConnectService {

    int insert(DAConnect record);

    public DAConnect selectByPrimaryKey(String daconnectId);

    List<Dealer> selectByParentId(String parentId, Boolean active);

    int updateByPrimaryKey(DAConnect record);
}
