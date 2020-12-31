package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.example.UmsAdminRoleRelationExample;
import com.paradise.core.mapper.UmsAdminRoleRelationMapper;
import com.paradise.core.model.UmsAdminRoleRelation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台用户和角色关系表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class UmsAdminRoleRelationService {
    private final UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.umsAdminRoleRelationMapper.deleteByPrimaryKey(id);
    }

    public int insert(UmsAdminRoleRelation record) {
        return this.umsAdminRoleRelationMapper.insert(record);
    }

    public UmsAdminRoleRelation selectByPrimaryKey(Long id) {
        return this.umsAdminRoleRelationMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(UmsAdminRoleRelation record) {
        return this.umsAdminRoleRelationMapper.updateByPrimaryKey(record);
    }

    public List<UmsAdminRoleRelation> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.umsAdminRoleRelationMapper.selectByExample(new UmsAdminRoleRelationExample());
    }
}