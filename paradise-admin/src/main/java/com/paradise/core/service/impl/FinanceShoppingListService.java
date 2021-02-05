package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.FinanceShoppingListBody;
import com.paradise.core.dto.query.FinanceShoppingListQuery;
import com.paradise.core.example.FinanceShoppingListExample;
import com.paradise.core.mapper.FinanceShoppingListMapper;
import com.paradise.core.model.FinanceShoppingList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物清单表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class FinanceShoppingListService {
    private final FinanceShoppingListMapper financeShoppingListMapper;

    public int deleteByPrimaryKey(Integer id) {
        return this.financeShoppingListMapper.deleteByPrimaryKey(id);
    }

    public int insert(FinanceShoppingListBody record) {
        FinanceShoppingList financeShoppingList = new FinanceShoppingList();
        BeanUtils.copyProperties(record, financeShoppingList);
        return this.financeShoppingListMapper.insert(financeShoppingList);
    }

    public int insertSelective(FinanceShoppingListBody record) {
        FinanceShoppingList financeShoppingList = new FinanceShoppingList();
        BeanUtils.copyProperties(record, financeShoppingList);
        return this.financeShoppingListMapper.insertSelective(financeShoppingList);
    }

    public FinanceShoppingList selectByPrimaryKey(Integer id) {
        return this.financeShoppingListMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(FinanceShoppingListBody record) {
        FinanceShoppingList financeShoppingList = new FinanceShoppingList();
        BeanUtils.copyProperties(record, financeShoppingList);
        return this.financeShoppingListMapper.updateByPrimaryKeySelective(financeShoppingList);
    }

    public int updateByPrimaryKey(Integer id, FinanceShoppingListBody record) {
        FinanceShoppingList financeShoppingList = new FinanceShoppingList();
        BeanUtils.copyProperties(record, financeShoppingList);
        financeShoppingList.setId(id);
        return this.financeShoppingListMapper.updateByPrimaryKeySelective(financeShoppingList);
    }

    public List<FinanceShoppingList> selectByPage(FinanceShoppingListQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.financeShoppingListMapper.selectByExample(new FinanceShoppingListExample());
    }
}