package com.paradise.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.paradise.core.common.api.Result;
import com.paradise.core.common.api.ResultCode;
import com.paradise.core.dto.body.PmServerSshBody;
import com.paradise.core.example.PmServerSshExample;
import com.paradise.core.mapper.PmServerSshMapper;
import com.paradise.core.model.PmServerSsh;
import com.paradise.core.model.UmsAdmin;
import com.paradise.core.utils.ssh.LinuxCmdUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    private final AdminCommonService adminCommonService;

    public int deleteByPrimaryKey(Long id) {
        PmServerSsh serverSsh = PmServerSsh.builder().id(id).enable(-1).build();
        return this.pmServerSshMapper.updateByPrimaryKeySelective(serverSsh);
    }

    public int insert(PmServerSshBody record) {
        PmServerSsh serverSsh = new PmServerSsh();
        BeanUtils.copyProperties(record, serverSsh);
        UmsAdmin admin = adminCommonService.getCurrentAdmin();
        serverSsh.setCreateBy(admin.getId());
        serverSsh.setUpdateBy(admin.getId());
        serverSsh.setCreateAt(new Date());
        serverSsh.setUpdateAt(new Date());
        return this.pmServerSshMapper.insertSelective(serverSsh);
    }

    public PmServerSsh selectByPrimaryKey(Long id) {
        return this.pmServerSshMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKey(Long id, PmServerSshBody record) {
        PmServerSsh serverSsh = new PmServerSsh();
        BeanUtils.copyProperties(record, serverSsh);
        serverSsh.setUpdateAt(new Date());
        serverSsh.setId(id);
        UmsAdmin admin = adminCommonService.getCurrentAdmin();
        serverSsh.setUpdateBy(admin.getId());
        return this.pmServerSshMapper.updateByPrimaryKeySelective(serverSsh);
    }

    public List<PmServerSsh> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.pmServerSshMapper.selectByExample(new PmServerSshExample().createCriteria()
                .andEnableNotEqualTo(-1).example().orderBy(PmServerSsh.Column.createAt.desc()));
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

    public List<PmServerSsh> all() {
        return pmServerSshMapper.selectByExample(new PmServerSshExample().createCriteria()
                .andEnableEqualTo(1).example().orderBy(PmServerSsh.Column.updateAt.desc()));
    }
}