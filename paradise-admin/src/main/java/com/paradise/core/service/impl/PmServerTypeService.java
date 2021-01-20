package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.PmServerTypeBody;
import com.paradise.core.dto.query.PmServerTypeQuery;
import com.paradise.core.example.PmServerTypeExample;
import com.paradise.core.mapper.PmServerTypeMapper;
import com.paradise.core.model.PmServerType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务器类别表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class PmServerTypeService {
    private final PmServerTypeMapper pmServerTypeMapper;

    public int deleteByPrimaryKey(Integer id) {
        return this.pmServerTypeMapper.deleteByPrimaryKey(id);
    }

    public int insert(PmServerTypeBody record) {
        PmServerType pmServerType = new PmServerType();
        BeanUtils.copyProperties(record, pmServerType);
        return this.pmServerTypeMapper.insert(pmServerType);
    }

    public int insertSelective(PmServerTypeBody record) {
        PmServerType pmServerType = new PmServerType();
        BeanUtils.copyProperties(record, pmServerType);
        return this.pmServerTypeMapper.insertSelective(pmServerType);
    }

    public PmServerType selectByPrimaryKey(Integer id) {
        return this.pmServerTypeMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(PmServerTypeBody record) {
        PmServerType pmServerType = new PmServerType();
        BeanUtils.copyProperties(record, pmServerType);
        return this.pmServerTypeMapper.updateByPrimaryKeySelective(pmServerType);
    }

    public int updateByPrimaryKey(Integer id, PmServerTypeBody record) {
        PmServerType pmServerType = new PmServerType();
        BeanUtils.copyProperties(record, pmServerType);
        pmServerType.setId(id);
        return this.pmServerTypeMapper.updateByPrimaryKeySelective(pmServerType);
    }

    public List<PmServerType> selectByPage(PmServerTypeQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.pmServerTypeMapper.selectByExample(new PmServerTypeExample());
    }

    public List<PmServerType> all() {
        return this.pmServerTypeMapper.selectByExample(new PmServerTypeExample());
    }
}