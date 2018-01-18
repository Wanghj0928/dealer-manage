package com.jiawawulian.dealermanage.service;

import com.jiawawulian.dealermanage.domain.Member;

import java.util.List;

/**
 * @author wanghj
 * @create 2018-01-18 9:42
 **/
public interface MemberService {

    /**
     * 根据memberId查询详细的会员信息
     * @param memberId
     * @return
     */
    Member selectByPrimaryKey(String memberId);

    /**
     * 根据dealerId查询该经销商对应的所有会员
     * @param dealerId
     * @return
     */
    List<Member> selectListByDealerId(String dealerId);
}
