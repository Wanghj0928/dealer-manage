package com.jiawawulian.dealermanage.service;

import com.jiawawulian.dealermanage.domain.Breakdown;
import com.jiawawulian.dealermanage.dto.BreakdownDTO;

import java.util.List;

/**
 * @author wanghj
 * @create 2018-01-18 12:57
 **/
public interface BreakdownService {

    /**
     * 根据breakdownId查询breakdown信息
     * @param breakdownsId
     * @return
     */
    Breakdown selectByPrimaryKey(String breakdownsId);

    /**
     * 根据breakdownId查询breakdown信息
     * @param dealerId
     * @return
     */
    List<BreakdownDTO> selectByDealerId(String dealerId);


}
