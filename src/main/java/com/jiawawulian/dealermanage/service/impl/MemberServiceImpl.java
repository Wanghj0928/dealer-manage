package com.jiawawulian.dealermanage.service.impl;

import com.jiawawulian.dealermanage.dao.MemberMapper;
import com.jiawawulian.dealermanage.domain.Member;
import com.jiawawulian.dealermanage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wanghj
 * @create 2018-01-18 9:44
 **/
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member selectByPrimaryKey(String memberId) {
        return memberMapper.selectByPrimaryKey(memberId);
    }

    @Override
    public List<Member> selectListByDealerId(String dealerId) {
        return memberMapper.selectListByDealerId(dealerId);
    }

    @Override
    public List<Member> selectByDealerIdAndBrandName(String dealerId, String brandName) {
        return memberMapper.selectByDealerIdAndBrandName(dealerId, brandName);
    }
}
