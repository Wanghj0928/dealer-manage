package com.jiawawulian.dealermanage.controller;

import com.jiawawulian.dealermanage.VO.BreakdownVO;
import com.jiawawulian.dealermanage.VO.ResultVO;
import com.jiawawulian.dealermanage.dto.BreakdownDTO;
import com.jiawawulian.dealermanage.enums.ResultEnum;
import com.jiawawulian.dealermanage.service.BreakdownService;
import com.jiawawulian.dealermanage.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wanghj
 * @create 2018-01-18 12:56
 **/
@RestController
public class BreakdownController {

    @Autowired
    private BreakdownService breakdownService;

    @RequestMapping("/breakdown/list")
    public ResultVO getBreakdownList(@RequestParam("dealerId") String dealerId) {
/*        if(StringUtils.isEmpty(dealerId)) {
            return ResultVOUtil.error(ResultEnum.DEALERID_EMPTY.getCode(), ResultEnum.DEALERID_EMPTY.getMessage());
        }
        List<BreakdownDTO> breakdownList = breakdownService.selectByDealerId(dealerId);
        HashMap map = new HashMap(1);
        map.put("breakdownList", breakdownList);
        return ResultVOUtil.success(map);*/

        List<BreakdownDTO> breakdownList = breakdownService.selectByDealerId(dealerId);
        Set<String> firmNameList = breakdownList.stream()
                .map(e -> e.getFirmName())
                .collect(Collectors.toSet());

        //3. 数据拼装
        List<BreakdownVO> breakdownVOList = new ArrayList<>();
        for (String firmName: firmNameList) {
            BreakdownVO breakdownVO = new BreakdownVO();
            breakdownVO.setFirmName(firmName);

            List<BreakdownDTO> breakdowns = new ArrayList<>();
            for (BreakdownDTO breakdownDTO: breakdownList) {
                if (breakdownDTO.getFirmName().equals(firmName)) {
                    breakdowns.add(breakdownDTO);
                }
            }
            breakdownVO.setBreakdownList(breakdowns);
            breakdownVOList.add(breakdownVO);
        }

        return ResultVOUtil.success(breakdownVOList);
    }

}
