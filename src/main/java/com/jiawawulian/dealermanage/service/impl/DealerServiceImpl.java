package com.jiawawulian.dealermanage.service.impl;

import com.jiawawulian.dealermanage.dao.DealerMapper;
import com.jiawawulian.dealermanage.domain.Dealer;
import com.jiawawulian.dealermanage.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author wanghj
 * @create 2018-01-18 9:10
 **/
@Service
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerMapper dealerMapper;

    @Override
    public Dealer selectByPrimaryKey(String dealerId) {
        return dealerMapper.selectByPrimaryKey(dealerId);
    }


    @Override
    public Boolean checkNameAndPass(String username, String password) {
        Dealer dealer = dealerMapper.selectByUsernameAndPassword(username, password);
        if(ObjectUtils.isEmpty(dealer)) {
            return false;
        } else {
            return true;
        }
    }
}
