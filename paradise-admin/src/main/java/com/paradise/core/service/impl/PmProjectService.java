package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.example.PmProjectExample;
import com.paradise.core.mapper.PmProjectMapper;
import com.paradise.core.model.PmProject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目监控项目表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class PmProjectService {
    private final PmProjectMapper pmProjectMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.pmProjectMapper.deleteByPrimaryKey(id);
    }

    public int insert(PmProject record) {
        return this.pmProjectMapper.insertSelective(record);
    }

    public PmProject selectByPrimaryKey(Long id) {
        return this.pmProjectMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(PmProject record) {
        return this.pmProjectMapper.updateByPrimaryKeySelective(record);
    }

    public List<PmProject> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.pmProjectMapper.selectByExample(new PmProjectExample());
    }
}