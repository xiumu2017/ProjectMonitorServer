package com.paradise.core.service;

import com.github.pagehelper.PageHelper;
import com.paradise.core.example.PmDingTalkRobotExample;
import com.paradise.core.mapper.PmDingTalkRobotMapper;
import com.paradise.core.model.PmDingTalkRobot;
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
public class PmDingTalkRobotService {
    private final PmDingTalkRobotMapper pmDingTalkRobotMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.pmDingTalkRobotMapper.deleteByPrimaryKey(id);
    }

    public int insert(PmDingTalkRobot record) {
        return this.pmDingTalkRobotMapper.insert(record);
    }

    public PmDingTalkRobot selectByPrimaryKey(Long id) {
        return this.pmDingTalkRobotMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(PmDingTalkRobot record) {
        return this.pmDingTalkRobotMapper.updateByPrimaryKey(record);
    }

    public List<PmDingTalkRobot> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.pmDingTalkRobotMapper.selectByExample(new PmDingTalkRobotExample());
    }
}