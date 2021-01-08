package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.PmDbBody;
import com.paradise.core.dto.query.PmDbQuery;
import com.paradise.core.example.PmDbExample;
import com.paradise.core.mapper.PmDbMapper;
import com.paradise.core.model.PmDb;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目监控数据库信息表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class PmDbService {
    private final PmDbMapper pmDbMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.pmDbMapper.deleteByPrimaryKey(id);
    }

    public int insert(PmDbBody record) {
        PmDb pmDb = new PmDb();
        BeanUtils.copyProperties(record, pmDb);
        return this.pmDbMapper.insertSelective(pmDb);
    }

    public int insertSelective(PmDbBody record) {
        PmDb pmDb = new PmDb();
        BeanUtils.copyProperties(record, pmDb);
        return this.pmDbMapper.insertSelective(pmDb);
    }

    public PmDb selectByPrimaryKey(Long id) {
        return this.pmDbMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(PmDbBody record) {
        PmDb pmDb = new PmDb();
        BeanUtils.copyProperties(record, pmDb);
        return this.pmDbMapper.updateByPrimaryKeySelective(pmDb);
    }

    public int updateByPrimaryKey(Long id, PmDbBody record) {
        PmDb pmDb = new PmDb();
        BeanUtils.copyProperties(record, pmDb);
        pmDb.setId(id);
        return this.pmDbMapper.updateByPrimaryKeySelective(pmDb);
    }

    public List<PmDb> selectByPage(PmDbQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.pmDbMapper.selectByExample(new PmDbExample());
    }
}