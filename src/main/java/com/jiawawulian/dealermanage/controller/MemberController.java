package com.jiawawulian.dealermanage.controller;

import com.jiawawulian.dealermanage.VO.ResultVO;
import com.jiawawulian.dealermanage.domain.Member;
import com.jiawawulian.dealermanage.service.MemberService;
import com.jiawawulian.dealermanage.utils.ResultVOUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author wanghj
 * @create 2018-01-18 10:42
 **/
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/member/list")
    public ResultVO getMemberList(@RequestParam("dealerId") String dealerId, @RequestParam(value = "brandName", required = false) String brandName) {
        List<Member> memberList = null;
        if (!StringUtils.isEmpty(brandName)) {
            memberList = memberService.selectByDealerIdAndBrandName(dealerId, brandName);
        } else {
            memberList = memberService.selectListByDealerId(dealerId);
        }
        HashMap map = new HashMap(1);
        map.put("memberList", memberList);
        return ResultVOUtil.success(map);
    }
}
