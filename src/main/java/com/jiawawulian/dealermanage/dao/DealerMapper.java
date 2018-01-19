package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.Dealer;
import org.springframework.stereotype.Component;

@Component
public interface DealerMapper {

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
    Dealer selectByUsernameAndPassword(String username, String password);

    /**
     * 插入dealer对象
     *
     * @param dealer
     * @return
     */
    int insert(Dealer dealer);

}