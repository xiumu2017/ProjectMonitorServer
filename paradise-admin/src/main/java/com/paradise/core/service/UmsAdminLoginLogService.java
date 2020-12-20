package com.paradise.core.service;

import com.github.pagehelper.PageHelper;
import com.paradise.core.example.UmsAdminLoginLogExample;
import com.paradise.core.mapper.UmsAdminLoginLogMapper;
import com.paradise.core.model.UmsAdminLoginLog;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台用户登录日志表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class UmsAdminLoginLogService {
    private final UmsAdminLoginLogMapper umsAdminLoginLogMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.umsAdminLoginLogMapper.deleteByPrimaryKey(id);
    }

    public int insert(UmsAdminLoginLog record) {
        return this.umsAdminLoginLogMapper.insert(record);
    }

    public UmsAdminLoginLog selectByPrimaryKey(Long id) {
        return this.umsAdminLoginLogMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(UmsAdminLoginLog record) {
        return this.umsAdminLoginLogMapper.updateByPrimaryKey(record);
    }

    public List<UmsAdminLoginLog> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.umsAdminLoginLogMapper.selectByExample(new UmsAdminLoginLogExample());
    }
}