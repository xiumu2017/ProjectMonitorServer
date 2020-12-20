package com.paradise.core.service;

import com.github.pagehelper.PageHelper;
import com.paradise.core.common.api.Result;
import com.paradise.core.common.api.ResultCode;
import com.paradise.core.example.PmServerSshExample;
import com.paradise.core.mapper.PmServerSshMapper;
import com.paradise.core.model.PmServerSsh;
import com.paradise.core.utils.ssh.LinuxCmdUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目监控服务器信息表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class PmServerSshService {
    private final PmServerSshMapper pmServerSshMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.pmServerSshMapper.deleteByPrimaryKey(id);
    }

    public int insert(PmServerSsh record) {
        return this.pmServerSshMapper.insert(record);
    }

    public PmServerSsh selectByPrimaryKey(Long id) {
        return this.pmServerSshMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(PmServerSsh record) {
        return this.pmServerSshMapper.updateByPrimaryKey(record);
    }

    public List<PmServerSsh> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.pmServerSshMapper.selectByExample(new PmServerSshExample());
    }

    public Result<String> serverConnectTest(Long id) {
        PmServerSsh server = selectByPrimaryKey(id);
        log.info(String.valueOf(id));
        try {
            // TODO 增加后端校验逻辑
            // TODO 增加 多种校验以及结果处理
            LinuxCmdUtils utils = new LinuxCmdUtils(server);
            Result<Object> mr = utils.login();
            if ((ResultCode.SUCCESS.getCode() == mr.getCode())) {
                return Result.success(utils.date());
            } else {
                return Result.failed();
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return Result.failed(e.getLocalizedMessage());
        }
    }
}