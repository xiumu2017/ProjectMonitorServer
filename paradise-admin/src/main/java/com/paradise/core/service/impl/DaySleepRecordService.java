package com.paradise.core.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import com.github.pagehelper.PageHelper;
import com.paradise.core.common.constant.SleepPieType;
import com.paradise.core.dto.body.DaySleepRecordBody;
import com.paradise.core.dto.query.DaySleepRecordQuery;
import com.paradise.core.example.DaySleepRecordExample;
import com.paradise.core.mapper.DaySleepRecordMapper;
import com.paradise.core.model.DaySleepRecord;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 睡眠记录表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class DaySleepRecordService {
    private final DaySleepRecordMapper daySleepRecordMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.daySleepRecordMapper.deleteByPrimaryKey(id);
    }

    public int insert(DaySleepRecordBody record) {
        DaySleepRecord daySleepRecord = new DaySleepRecord();
        BeanUtils.copyProperties(record, daySleepRecord);
        dealRecord(record, daySleepRecord);
        daySleepRecord.setCreateAt(new Date());
        daySleepRecord.setUpdateAt(new Date());
        return this.daySleepRecordMapper.insertSelective(daySleepRecord);
    }

    private Integer cal(DaySleepRecordBody record) {
        long mis = record.getWakeTime() - record.getSleepTime();
        return Math.toIntExact(mis / (1_000));
    }

    public int insertSelective(DaySleepRecordBody record) {
        DaySleepRecord daySleepRecord = new DaySleepRecord();
        BeanUtils.copyProperties(record, daySleepRecord);
        return this.daySleepRecordMapper.insertSelective(daySleepRecord);
    }

    public DaySleepRecord selectByPrimaryKey(Long id) {
        return this.daySleepRecordMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(DaySleepRecordBody record) {
        DaySleepRecord daySleepRecord = new DaySleepRecord();
        BeanUtils.copyProperties(record, daySleepRecord);
        return this.daySleepRecordMapper.updateByPrimaryKeySelective(daySleepRecord);
    }

    public int updateByPrimaryKey(Long id, DaySleepRecordBody record) {
        DaySleepRecord daySleepRecord = new DaySleepRecord();
        BeanUtils.copyProperties(record, daySleepRecord);
        daySleepRecord.setId(id);
        dealRecord(record, daySleepRecord);
        return this.daySleepRecordMapper.updateByPrimaryKeySelective(daySleepRecord);
    }

    private void dealRecord(DaySleepRecordBody record, DaySleepRecord daySleepRecord) {
        daySleepRecord.setDate(new Date(record.getDate()));
        daySleepRecord.setBedTime(new Date(record.getBedTime()));
        daySleepRecord.setSleepTime(new Date(record.getSleepTime()));
        daySleepRecord.setWakeTime(new Date(record.getWakeTime()));
        daySleepRecord.setUpTime(new Date(record.getUpTime()));
        // 计算睡眠时长
        daySleepRecord.setDuration(cal(record));
    }

    public List<DaySleepRecord> selectByPage(DaySleepRecordQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.daySleepRecordMapper.selectByExample(new DaySleepRecordExample()
                .createCriteria().example().orderBy(DaySleepRecord.Column.date.desc()));
    }

    public List<List<String>> statistics() {
        List<DaySleepRecord> list =
                this.daySleepRecordMapper.selectByExampleSelective(new DaySleepRecordExample()
                                .createCriteria()
                                .andDateGreaterThanOrEqualTo(DateUtil.offsetDay(new Date(), -30))
                                .example().orderBy(DaySleepRecord.Column.date.asc()),
                        DaySleepRecord.Column.date, DaySleepRecord.Column.duration);
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> dateList = new ArrayList<>();
        ArrayList<String> durationList = new ArrayList<>();
        for (DaySleepRecord daySleepRecord : list) {
            dateList.add(DateUtil.format(daySleepRecord.getDate(), "MM-dd"));
            durationList.add(new BigDecimal(daySleepRecord.getDuration()).divide(
                    new BigDecimal("3600"), 4, BigDecimal.ROUND_HALF_UP).toString());
        }
        result.add(dateList);
        result.add(durationList);
        return result;
    }

    /**
     * 批量插入数据
     *
     * @param recordList 睡眠记录数据
     * @return 插入数量
     */
    public int batchInsert(List<DaySleepRecord> recordList) {
        return daySleepRecordMapper.batchInsert(recordList);
    }


    /**
     * 入睡时间分布统计
     *
     * @param type 类型
     * @return 统计数据
     */
    public List<Map<String, String>> statisticsPie(SleepPieType type) {
        if (type == null) {
            type = SleepPieType.ALL;
        }
        List<DaySleepRecord> daySleepRecordList;
        DaySleepRecordExample example = new DaySleepRecordExample().createCriteria().example();
        switch (type) {
            case ALL:
                example = new DaySleepRecordExample().createCriteria().example();
                break;
            case YEAR:
                example = new DaySleepRecordExample().createCriteria().andDateBetween(DateUtil.beginOfYear(new Date()), new Date()).example();
                break;
            case MONTH:
                example = new DaySleepRecordExample().createCriteria().andDateBetween(DateUtil.beginOfMonth(new Date()), new Date()).example();
                break;
            case LAST_30_DAY:
                example = new DaySleepRecordExample().createCriteria().andDateBetween(DateUtil.offsetDay(new Date(), -30), new Date()).example();
                break;
            default:
                break;
        }
        daySleepRecordList = daySleepRecordMapper.selectByExample(example);
        long less22 = daySleepRecordList.stream().filter(item -> getHour(item) < 22 && getHour(item) > 10).count();
        long in22 = daySleepRecordList.stream().filter(item -> getHour(item) == 22).count();
        long in23 = daySleepRecordList.stream().filter(item -> getHour(item) == 23).count();
        long in0 = daySleepRecordList.stream().filter(item -> getHour(item) == 0).count();
        long in1 = daySleepRecordList.stream().filter(item -> getHour(item) == 1).count();
        long in2 = daySleepRecordList.stream().filter(item -> getHour(item) == 2).count();
        long g2 = daySleepRecordList.stream().filter(item -> getHour(item) > 2 && getHour(item) < 10).count();

        List<Map<String, String>> resultList = new ArrayList<>(8);
        resultList.add(MapUtil.builder("name", "22点之前").put("value", String.valueOf(less22)).build());
        resultList.add(MapUtil.builder("name", "22点~23点").put("value", String.valueOf(in22)).build());
        resultList.add(MapUtil.builder("name", "23点~0点").put("value", String.valueOf(in23)).build());
        resultList.add(MapUtil.builder("name", "0点~1点").put("value", String.valueOf(in0)).build());
        resultList.add(MapUtil.builder("name", "1点~2点").put("value", String.valueOf(in1)).build());
        resultList.add(MapUtil.builder("name", "2点~3点").put("value", String.valueOf(in2)).build());
        resultList.add(MapUtil.builder("name", "2点以后").put("value", String.valueOf(g2)).build());

        return resultList;
    }

    private Integer getHour(DaySleepRecord daySleepRecord) {
        Date sleepTime = daySleepRecord.getSleepTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sleepTime);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
}