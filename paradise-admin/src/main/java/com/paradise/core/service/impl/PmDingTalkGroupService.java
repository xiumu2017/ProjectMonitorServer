package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.PmDingTalkGroupBody;
import com.paradise.core.dto.query.PmDingTalkGroupQuery;
import com.paradise.core.example.PmDingTalkGroupExample;
import com.paradise.core.mapper.PmDingTalkGroupMapper;
import com.paradise.core.model.PmDingTalkGroup;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    public int insert(PmDingTalkGroupBody record) {
        PmDingTalkGroup pmDingTalkGroup = new PmDingTalkGroup();
        BeanUtils.copyProperties(record, pmDingTalkGroup);
        return this.pmDingTalkGroupMapper.insert(pmDingTalkGroup);
    }

    public int insertSelective(PmDingTalkGroupBody record) {
        PmDingTalkGroup pmDingTalkGroup = new PmDingTalkGroup();
        BeanUtils.copyProperties(record, pmDingTalkGroup);
        return this.pmDingTalkGroupMapper.insertSelective(pmDingTalkGroup);
    }

    public PmDingTalkGroup selectByPrimaryKey(Long id) {
        return this.pmDingTalkGroupMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(PmDingTalkGroupBody record) {
        PmDingTalkGroup pmDingTalkGroup = new PmDingTalkGroup();
        BeanUtils.copyProperties(record, pmDingTalkGroup);
        return this.pmDingTalkGroupMapper.updateByPrimaryKeySelective(pmDingTalkGroup);
    }

    public int updateByPrimaryKey(Long id, PmDingTalkGroupBody record) {
        PmDingTalkGroup pmDingTalkGroup = new PmDingTalkGroup();
        BeanUtils.copyProperties(record, pmDingTalkGroup);
        pmDingTalkGroup.setId(id);
        return this.pmDingTalkGroupMapper.updateByPrimaryKeySelective(pmDingTalkGroup);
    }

    public List<PmDingTalkGroup> selectByPage(PmDingTalkGroupQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.pmDingTalkGroupMapper.selectByExample(new PmDingTalkGroupExample());
    }
}