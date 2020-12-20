package com.paradise.core.service;

import com.github.pagehelper.PageHelper;
import com.paradise.core.example.UmsAdminPermissionRelationExample;
import com.paradise.core.mapper.UmsAdminPermissionRelationMapper;
import com.paradise.core.model.UmsAdminPermissionRelation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台用户额外权限关系表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class UmsAdminPermissionRelationService {
    private final UmsAdminPermissionRelationMapper umsAdminPermissionRelationMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.umsAdminPermissionRelationMapper.deleteByPrimaryKey(id);
    }

    public int insert(UmsAdminPermissionRelation record) {
        return this.umsAdminPermissionRelationMapper.insert(record);
    }

    public UmsAdminPermissionRelation selectByPrimaryKey(Long id) {
        return this.umsAdminPermissionRelationMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(UmsAdminPermissionRelation record) {
        return this.umsAdminPermissionRelationMapper.updateByPrimaryKey(record);
    }

    public List<UmsAdminPermissionRelation> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.umsAdminPermissionRelationMapper.selectByExample(new UmsAdminPermissionRelationExample());
    }
}