package com.paradise.core.dao;

import com.paradise.core.dto.detail.BillDto;
import com.paradise.core.dto.query.BillQuery;

import java.util.List;

public interface BillDao {
    /**
     * 条件查询
     *
     * @param query {@link BillQuery}
     * @return {@link BillDto}
     */
    List<BillDto> query(BillQuery query);
}
