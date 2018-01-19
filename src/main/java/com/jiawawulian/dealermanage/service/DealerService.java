package com.jiawawulian.dealermanage.service;

import com.jiawawulian.dealermanage.domain.Dealer;

/**
 * @author wanghj
 * @create 2018-01-18 9:09
 **/
public interface DealerService {

    /**
     * 根据dealerId查找dealer
     *
     * @param dealerId
     * @return
     */
    Dealer selectByPrimaryKey(String dealerId);

    /**
     * 根据用户名和密码查找dealer，用于账号密码登录
     *
     * @param username
     * @param password
     * @return
     */
    Boolean checkNameAndPass(String username, String password);

    /**
     * 插入dealer对象
     *
     * @param dealer
     * @return
     */
    int insert(Dealer dealer);
}
