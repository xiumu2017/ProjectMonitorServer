package com.paradise.core.service.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.paradise.core.dao.DayMealRecordDao;
import com.paradise.core.dto.DayMealRecordGroupData;
import com.paradise.core.dto.body.DayMealRecordBody;
import com.paradise.core.dto.query.DayMealRecordQuery;
import com.paradise.core.dto.statistics.DayMealRecordChartData;
import com.paradise.core.dto.statistics.DayMealRecordDayData;
import com.paradise.core.dto.statistics.DayMealRecordMonthData;
import com.paradise.core.example.DayMealRecordExample;
import com.paradise.core.mapper.DayMealRecordMapper;
import com.paradise.core.model.DayMealRecord;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 用餐记录表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class DayMealRecordService {
    private final DayMealRecordMapper dayMealRecordMapper;
    private final DayMealRecordDao dayMealRecordDao;

    public int deleteByPrimaryKey(Long id) {
        return this.dayMealRecordMapper.deleteByPrimaryKey(id);
    }

    public int insert(DayMealRecordBody record) {
        DayMealRecord dayMealRecord = new DayMealRecord();
        BeanUtils.copyProperties(record, dayMealRecord);
        return this.dayMealRecordMapper.insert(dayMealRecord);
    }

    public int insertSelective(DayMealRecordBody record) {
        DayMealRecord dayMealRecord = new DayMealRecord();
        BeanUtils.copyProperties(record, dayMealRecord);
        return this.dayMealRecordMapper.insertSelective(dayMealRecord);
    }

    public DayMealRecord selectByPrimaryKey(Long id) {
        return this.dayMealRecordMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(DayMealRecordBody record) {
        DayMealRecord dayMealRecord = new DayMealRecord();
        BeanUtils.copyProperties(record, dayMealRecord);
        return this.dayMealRecordMapper.updateByPrimaryKeySelective(dayMealRecord);
    }

    public int updateByPrimaryKey(Long id, DayMealRecordBody record) {
        DayMealRecord dayMealRecord = new DayMealRecord();
        BeanUtils.copyProperties(record, dayMealRecord);
        dayMealRecord.setId(id);
        return this.dayMealRecordMapper.updateByPrimaryKeySelective(dayMealRecord);
    }

    public List<DayMealRecord> selectByPage(DayMealRecordQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.dayMealRecordMapper.selectByExample(new DayMealRecordExample()
                .createCriteria()
                .when(query.getType() != null, criteria -> criteria.andTypeEqualTo(query.getType()))
                .when(query.getDate() != null, criteria -> criteria.andDateEqualTo(query.getDate()))
                .when(query.getPayType() != null, criteria -> criteria.andPayTypeEqualTo(query.getPayType()))
                .example().orderBy(DayMealRecord.Column.date.desc(), DayMealRecord.Column.type.desc()));
    }

    /**
     * 统计数据
     *
     * @param query {@link DayMealRecordQuery}
     * @return {@link DayMealRecordChartData}
     */
    public DayMealRecordChartData chartData(DayMealRecordQuery query) {
        // 时间区间
        Date start = query.getStartTime() == null ? DateUtil.offsetDay(new Date(), -15) : query.getStartTime();
        Date end = query.getEndTime() == null ? DateUtil.date() : query.getEndTime();
        List<DayMealRecord> recordList =
                this.dayMealRecordMapper.selectByExample(new DayMealRecordExample()
                        .createCriteria()
                        .andDateBetween(start, end)
                        .example().orderBy(DayMealRecord.Column.date.desc(), DayMealRecord.Column.type.asc()));
        DayMealRecordChartData chartData = new DayMealRecordChartData();
        List<String> dateList = new ArrayList<>();
        List<String> breakfastList = new ArrayList<>();
        List<String> lunchList = new ArrayList<>();
        List<String> dinnerList = new ArrayList<>();
        List<String> totalList = new ArrayList<>();

        Map<String, DayMealRecordDayData> dataMap = new LinkedHashMap<>();
        // 构造日期列表
        while (end.after(start)) {
            start = DateUtil.offsetDay(start, 1);
            dataMap.put(DateUtil.formatDate(start), new DayMealRecordDayData());
        }
        for (DayMealRecord dayMealRecord : recordList) {
            String date = DateUtil.formatDate(dayMealRecord.getDate());
            DayMealRecordDayData dayData = dataMap.get(date);
            if (dayData != null) {
                switch (dayMealRecord.getType()) {
                    case 1:
                        dayData.setBreakfast(dayMealRecord.getCost());
                        dayData.setTotal(add(dayData.getTotal(), dayMealRecord.getCost()));
                        break;
                    case 2:
                        dayData.setLunch(dayMealRecord.getCost());
                        dayData.setTotal(add(dayData.getTotal(), dayMealRecord.getCost()));
                        break;
                    case 3:
                        dayData.setDinner(dayMealRecord.getCost());
                        dayData.setTotal(add(dayData.getTotal(), dayMealRecord.getCost()));
                        break;
                    default:
                        dayData.setTotal(add(dayData.getTotal(), dayMealRecord.getCost()));
                        break;
                }
            }
        }

        for (Map.Entry<String, DayMealRecordDayData> entry : dataMap.entrySet()) {
            DayMealRecordDayData dayData = entry.getValue();
            dateList.add(entry.getKey());
            breakfastList.add(StringUtils.defaultString(cal(dayData.getBreakfast()), "0"));
            lunchList.add(StringUtils.defaultString(cal(dayData.getLunch()), "0"));
            dinnerList.add(StringUtils.defaultString(cal(dayData.getDinner()), "0"));
            totalList.add(StringUtils.defaultString(cal(dayData.getTotal()), "0"));
        }
        chartData.setDateList(dateList);
        chartData.setBreakfast(breakfastList);
        chartData.setLunch(lunchList);
        chartData.setDinner(dinnerList);
        chartData.setTotal(totalList);
        return chartData;
    }

    private String cal(Integer cost) {
        if (cost == null) {
            return "0";
        }
        return new BigDecimal(cost).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP).toString();
    }

    private Integer add(Integer v1, Integer v2) {
        v1 = v1 == null ? 0 : v1;
        v2 = v2 == null ? 0 : v2;
        return v1 + v2;
    }

    public List<DayMealRecordMonthData> monthData() {
        // 查询缓存数据
        // 数据库查询 根据月度和type 汇总数据
        List<DayMealRecordGroupData> list = dayMealRecordDao.queryByMonth();
        Map<String, DayMealRecordMonthData> resMap = new TreeMap<>();
        for (DayMealRecordGroupData data : list) {
            DayMealRecordMonthData monthData = resMap.get(data.getMonth());
            if (monthData == null) {
                monthData = new DayMealRecordMonthData();
                monthData.setMonth(data.getMonth());
                resMap.put(data.getMonth(), monthData);
            }
            switch (data.getType()) {
                case 0:
                    monthData.setSnacks(add(monthData.getSnacks(), data.getCost()));
                    break;
                case 1:
                    monthData.setBreakfast(add(monthData.getBreakfast(), data.getCost()));
                    break;
                case 2:
                    monthData.setLunch(add(monthData.getLunch(), data.getCost()));
                    break;
                case 3:
                    monthData.setDinner(add(monthData.getDinner(), data.getCost()));
                    break;
                case 4:
                    monthData.setSupper(add(monthData.getSupper(), data.getCost()));
                    break;
                default:
                    break;
            }
        }
        return new ArrayList<>(resMap.values());
    }
}