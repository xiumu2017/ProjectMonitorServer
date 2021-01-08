package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.PmDingTalkRobotBody;
import com.paradise.core.dto.query.PmDingTalkRobotQuery;
import com.paradise.core.example.PmDingTalkRobotExample;
import com.paradise.core.mapper.PmDingTalkRobotMapper;
import com.paradise.core.model.PmDingTalkRobot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
public class PmDingTalkRobotService {
    private final PmDingTalkRobotMapper pmDingTalkRobotMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.pmDingTalkRobotMapper.deleteByPrimaryKey(id);
    }

    public int insert(PmDingTalkRobotBody record) {
        PmDingTalkRobot pmDingTalkRobot = new PmDingTalkRobot();
        BeanUtils.copyProperties(record, pmDingTalkRobot);
        return this.pmDingTalkRobotMapper.insert(pmDingTalkRobot);
    }

    public int insertSelective(PmDingTalkRobotBody record) {
        PmDingTalkRobot pmDingTalkRobot = new PmDingTalkRobot();
        BeanUtils.copyProperties(record, pmDingTalkRobot);
        return this.pmDingTalkRobotMapper.insertSelective(pmDingTalkRobot);
    }

    public PmDingTalkRobot selectByPrimaryKey(Long id) {
        return this.pmDingTalkRobotMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(PmDingTalkRobotBody record) {
        PmDingTalkRobot pmDingTalkRobot = new PmDingTalkRobot();
        BeanUtils.copyProperties(record, pmDingTalkRobot);
        return this.pmDingTalkRobotMapper.updateByPrimaryKeySelective(pmDingTalkRobot);
    }

    public int updateByPrimaryKey(Long id, PmDingTalkRobotBody record) {
        PmDingTalkRobot pmDingTalkRobot = new PmDingTalkRobot();
        BeanUtils.copyProperties(record, pmDingTalkRobot);
        pmDingTalkRobot.setId(id);
        return this.pmDingTalkRobotMapper.updateByPrimaryKeySelective(pmDingTalkRobot);
    }

    public List<PmDingTalkRobot> selectByPage(PmDingTalkRobotQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.pmDingTalkRobotMapper.selectByExample(new PmDingTalkRobotExample()
                .createCriteria()
                .when(query.getGroupId() != null, criteria -> criteria.andGroupIdEqualTo(query.getGroupId()))
                .when(query.getEnable() != null, criteria -> criteria.andEnableEqualTo(query.getEnable()))
                .when(StringUtils.isNotEmpty(query.getName()), criteria -> criteria.andNameLike("%" + query.getName() + "%"))
                .when(StringUtils.isNotEmpty(query.getType()), criteria -> criteria.andTypeEqualTo(query.getType()))
                .example().orderBy(PmDingTalkRobot.Column.createAt.desc()));
    }
}