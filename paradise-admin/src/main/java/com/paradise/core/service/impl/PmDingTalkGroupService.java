package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.example.PmDingTalkGroupExample;
import com.paradise.core.mapper.PmDingTalkGroupMapper;
import com.paradise.core.model.PmDingTalkGroup;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 钉钉群组管理
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class PmDingTalkGroupService {
    private final PmDingTalkGroupMapper pmDingTalkGroupMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.pmDingTalkGroupMapper.deleteByPrimaryKey(id);
    }

    public int insert(PmDingTalkGroup record) {
        return this.pmDingTalkGroupMapper.insert(record);
    }

    public PmDingTalkGroup selectByPrimaryKey(Long id) {
        return this.pmDingTalkGroupMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(PmDingTalkGroup record) {
        return this.pmDingTalkGroupMapper.updateByPrimaryKey(record);
    }

    public List<PmDingTalkGroup> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.pmDingTalkGroupMapper.selectByExample(new PmDingTalkGroupExample());
    }
}