package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.BillBody;
import com.paradise.core.dto.query.BillQuery;
import com.paradise.core.example.BillExample;
import com.paradise.core.mapper.BillMapper;
import com.paradise.core.model.Bill;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账单表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class BillService {
    private final BillMapper billMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.billMapper.deleteByPrimaryKey(id);
    }

    public int insert(BillBody record) {
        Bill bill = new Bill();
        BeanUtils.copyProperties(record, bill);
        return this.billMapper.insert(bill);
    }

    public int insertSelective(BillBody record) {
        Bill bill = new Bill();
        BeanUtils.copyProperties(record, bill);
        return this.billMapper.insertSelective(bill);
    }

    public Bill selectByPrimaryKey(Long id) {
        return this.billMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(BillBody record) {
        Bill bill = new Bill();
        BeanUtils.copyProperties(record, bill);
        return this.billMapper.updateByPrimaryKeySelective(bill);
    }

    public int updateByPrimaryKey(Long id, BillBody record) {
        Bill bill = new Bill();
        BeanUtils.copyProperties(record, bill);
        bill.setId(id);
        return this.billMapper.updateByPrimaryKeySelective(bill);
    }

    public List<Bill> selectByPage(BillQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.billMapper.selectByExample(new BillExample());
    }
}