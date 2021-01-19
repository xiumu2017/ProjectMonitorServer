package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.PmProjectBody;
import com.paradise.core.dto.query.PmProjectQuery;
import com.paradise.core.example.PmProjectExample;
import com.paradise.core.mapper.PmProjectMapper;
import com.paradise.core.model.PmProject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    public int insert(PmProjectBody record) {
        PmProject pmProject = new PmProject();
        BeanUtils.copyProperties(record, pmProject);
        return this.pmProjectMapper.insertSelective(pmProject);
    }

    public int insertSelective(PmProjectBody record) {
        PmProject pmProject = new PmProject();
        BeanUtils.copyProperties(record, pmProject);
        return this.pmProjectMapper.insertSelective(pmProject);
    }

    public PmProject selectByPrimaryKey(Long id) {
        return this.pmProjectMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(PmProjectBody record) {
        PmProject pmProject = new PmProject();
        BeanUtils.copyProperties(record, pmProject);
        return this.pmProjectMapper.updateByPrimaryKeySelective(pmProject);
    }

    public int updateByPrimaryKey(Long id, PmProjectBody record) {
        PmProject pmProject = new PmProject();
        BeanUtils.copyProperties(record, pmProject);
        pmProject.setId(id);
        return this.pmProjectMapper.updateByPrimaryKeySelective(pmProject);
    }

    public List<PmProject> selectByPage(PmProjectQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.pmProjectMapper.selectByExample(new PmProjectExample());
    }
}