package com.paradise.core.app.service;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.query.DayBingImageQuery;
import com.paradise.core.example.DayBingImageExample;
import com.paradise.core.mapper.DayBingImageMapper;
import com.paradise.core.model.DayBingImage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 每日bing壁纸表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class BingImageService {
    private final DayBingImageMapper dayBingImageMapper;

    public List<DayBingImage> selectByPage(DayBingImageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.dayBingImageMapper.selectByExample(new DayBingImageExample()
                .createCriteria()
                .when(query.getStartTime() != null, criteria -> criteria.andDateGreaterThanOrEqualTo(DateUtil.beginOfDay(query.getStartTime())))
                .when(query.getEndTime() != null, criteria -> criteria.andDateLessThanOrEqualTo(DateUtil.endOfDay(query.getEndTime())))
                .example()
                .orderBy(DayBingImage.Column.date.desc()));
    }

    public List<String> selectUrlByPage(DayBingImageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.dayBingImageMapper.selectByExampleSelective(new DayBingImageExample()
                .createCriteria()
                .when(query.getStartTime() != null, criteria -> criteria.andDateGreaterThanOrEqualTo(DateUtil.beginOfDay(query.getStartTime())))
                .when(query.getEndTime() != null, criteria -> criteria.andDateLessThanOrEqualTo(DateUtil.endOfDay(query.getEndTime())))
                .example()
                .orderBy(DayBingImage.Column.date.desc()), DayBingImage.Column.url).stream().map(DayBingImage::getUrl).collect(Collectors.toList());
    }

    public DayBingImage todayImage() {
        return dayBingImageMapper.selectOneByExample(new DayBingImageExample().createCriteria()
                .andDateBetween(DateUtil.offsetDay(new Date(), -1), new Date()).example());
    }
}