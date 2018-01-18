package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.Member;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberMapper {

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