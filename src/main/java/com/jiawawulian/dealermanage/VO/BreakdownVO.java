package com.jiawawulian.dealermanage.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiawawulian.dealermanage.domain.Breakdown;
import com.jiawawulian.dealermanage.dto.BreakdownDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 故障列表VO
 * Created by wanghj
 * 2017-01-18 13:29
 */
@Data
public class BreakdownVO {

    private String firmName;

    private List<BreakdownDTO> breakdownList;
}
