package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.BillTypeBody;
import com.paradise.core.dto.query.BillTypeQuery;
import com.paradise.core.example.BillTypeExample;
import com.paradise.core.mapper.BillTypeMapper;
import com.paradise.core.model.BillType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账单分类表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class BillTypeService {
    private final BillTypeMapper billTypeMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.billTypeMapper.deleteByPrimaryKey(id);
    }

    public int insert(BillTypeBody record) {
        BillType billType = new BillType();
        BeanUtils.copyProperties(record, billType);
        return this.billTypeMapper.insert(billType);
    }

    public int insertSelective(BillTypeBody record) {
        BillType billType = new BillType();
        BeanUtils.copyProperties(record, billType);
        return this.billTypeMapper.insertSelective(billType);
    }

    public BillType selectByPrimaryKey(Long id) {
        return this.billTypeMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(BillTypeBody record) {
        BillType billType = new BillType();
        BeanUtils.copyProperties(record, billType);
        return this.billTypeMapper.updateByPrimaryKeySelective(billType);
    }

    public int updateByPrimaryKey(Long id, BillTypeBody record) {
        BillType billType = new BillType();
        BeanUtils.copyProperties(record, billType);
        billType.setId(id);
        return this.billTypeMapper.updateByPrimaryKeySelective(billType);
    }

    public List<BillType> selectByPage(BillTypeQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.billTypeMapper.selectByExample(new BillTypeExample());
    }
}