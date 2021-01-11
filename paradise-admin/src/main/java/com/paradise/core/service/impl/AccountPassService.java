package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.AccountPassBody;
import com.paradise.core.dto.query.AccountPassQuery;
import com.paradise.core.example.AccountPassExample;
import com.paradise.core.mapper.AccountPassMapper;
import com.paradise.core.model.AccountPass;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 网络账号资产表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class AccountPassService {
    private final AccountPassMapper accountPassMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.accountPassMapper.deleteByPrimaryKey(id);
    }

    public int insert(AccountPassBody record) {
        AccountPass accountPass = new AccountPass();
        BeanUtils.copyProperties(record, accountPass);
        return this.accountPassMapper.insert(accountPass);
    }

    public int insertSelective(AccountPassBody record) {
        AccountPass accountPass = new AccountPass();
        BeanUtils.copyProperties(record, accountPass);
        return this.accountPassMapper.insertSelective(accountPass);
    }

    public AccountPass selectByPrimaryKey(Long id) {
        return this.accountPassMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(AccountPassBody record) {
        AccountPass accountPass = new AccountPass();
        BeanUtils.copyProperties(record, accountPass);
        return this.accountPassMapper.updateByPrimaryKeySelective(accountPass);
    }

    public int updateByPrimaryKey(Long id, AccountPassBody record) {
        AccountPass accountPass = new AccountPass();
        BeanUtils.copyProperties(record, accountPass);
        accountPass.setId(id);
        return this.accountPassMapper.updateByPrimaryKeySelective(accountPass);
    }

    public List<AccountPass> selectByPage(AccountPassQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.accountPassMapper.selectByExample(new AccountPassExample());
    }
}