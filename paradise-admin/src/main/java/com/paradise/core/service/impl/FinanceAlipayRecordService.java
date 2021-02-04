package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.FinanceAlipayRecordBody;
import com.paradise.core.dto.query.FinanceAlipayRecordQuery;
import com.paradise.core.example.FinanceAlipayRecordExample;
import com.paradise.core.mapper.FinanceAlipayRecordMapper;
import com.paradise.core.model.FinanceAlipayRecord;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 支付宝账单表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class FinanceAlipayRecordService {
    private final FinanceAlipayRecordMapper financeAlipayRecordMapper;

    public int deleteByPrimaryKey(Integer id) {
        return this.financeAlipayRecordMapper.deleteByPrimaryKey(id);
    }

    public int insert(FinanceAlipayRecordBody record) {
        FinanceAlipayRecord financeAlipayRecord = new FinanceAlipayRecord();
        BeanUtils.copyProperties(record, financeAlipayRecord);
        return this.financeAlipayRecordMapper.insert(financeAlipayRecord);
    }

    public int insertSelective(FinanceAlipayRecordBody record) {
        FinanceAlipayRecord financeAlipayRecord = new FinanceAlipayRecord();
        BeanUtils.copyProperties(record, financeAlipayRecord);
        return this.financeAlipayRecordMapper.insertSelective(financeAlipayRecord);
    }

    public FinanceAlipayRecord selectByPrimaryKey(Integer id) {
        return this.financeAlipayRecordMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(FinanceAlipayRecordBody record) {
        FinanceAlipayRecord financeAlipayRecord = new FinanceAlipayRecord();
        BeanUtils.copyProperties(record, financeAlipayRecord);
        return this.financeAlipayRecordMapper.updateByPrimaryKeySelective(financeAlipayRecord);
    }

    public int updateByPrimaryKey(Integer id, FinanceAlipayRecordBody record) {
        FinanceAlipayRecord financeAlipayRecord = new FinanceAlipayRecord();
        BeanUtils.copyProperties(record, financeAlipayRecord);
        financeAlipayRecord.setId(id);
        return this.financeAlipayRecordMapper.updateByPrimaryKeySelective(financeAlipayRecord);
    }

    public List<FinanceAlipayRecord> selectByPage(FinanceAlipayRecordQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.financeAlipayRecordMapper.selectByExample(new FinanceAlipayRecordExample()
                .createCriteria()
                .when(!StringUtils.isEmpty(query.getDirection()), criteria -> criteria.andDirectionEqualTo(query.getDirection()))
                .example()
                .orderBy(FinanceAlipayRecord.Column.createTime.desc()));
    }
}