package com.jiawawulian.dealermanage.dao;

import com.jiawawulian.dealermanage.domain.Breakdown;
import com.jiawawulian.dealermanage.dto.BreakdownDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wanghj
 */
@Component
public interface BreakdownMapper {

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