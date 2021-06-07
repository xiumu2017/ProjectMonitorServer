package com.paradise.core.dao;

import com.paradise.core.dto.detail.BillTypeDto;
import com.paradise.core.dto.query.BillTypeQuery;

import java.util.List;

public interface BillTypeDao {
    /**
     * 条件查询
     *
     * @param query {@link BillTypeQuery}
     * @return {@link BillTypeDto}
     */
    List<BillTypeDto> query(BillTypeQuery query);
}
