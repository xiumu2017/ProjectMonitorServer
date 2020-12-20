package com.paradise.core.service;

import com.github.pagehelper.PageHelper;
import com.paradise.core.example.PmDbExample;
import com.paradise.core.mapper.PmDbMapper;
import com.paradise.core.model.PmDb;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public int insert(PmDb record) {
        return this.pmDbMapper.insert(record);
    }

    public PmDb selectByPrimaryKey(Long id) {
        return this.pmDbMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(PmDb record) {
        return this.pmDbMapper.updateByPrimaryKey(record);
    }

    public List<PmDb> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.pmDbMapper.selectByExample(new PmDbExample());
    }
}