package com.paradise.core.service.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.paradise.core.dto.body.DayBingImageBody;
import com.paradise.core.dto.query.DayBingImageQuery;
import com.paradise.core.example.DayBingImageExample;
import com.paradise.core.mapper.DayBingImageMapper;
import com.paradise.core.model.DayBingImage;
import com.paradise.core.utils.bing.BingImageUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 每日bing壁纸表
 *
 * @author Paradise
 */
@Slf4j
@Service
@AllArgsConstructor
public class DayBingImageService {
    private final DayBingImageMapper dayBingImageMapper;

    public int deleteByPrimaryKey(Long id) {
        return this.dayBingImageMapper.deleteByPrimaryKey(id);
    }

    public int insert(DayBingImageBody record) {
        DayBingImage dayBingImage = new DayBingImage();
        BeanUtils.copyProperties(record, dayBingImage);
        return this.dayBingImageMapper.insert(dayBingImage);
    }

    public int insertSelective(DayBingImageBody record) {
        DayBingImage dayBingImage = new DayBingImage();
        BeanUtils.copyProperties(record, dayBingImage);
        return this.dayBingImageMapper.insertSelective(dayBingImage);
    }

    public DayBingImage selectByPrimaryKey(Long id) {
        return this.dayBingImageMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(DayBingImageBody record) {
        DayBingImage dayBingImage = new DayBingImage();
        BeanUtils.copyProperties(record, dayBingImage);
        return this.dayBingImageMapper.updateByPrimaryKeySelective(dayBingImage);
    }

    public int updateByPrimaryKey(Long id, DayBingImageBody record) {
        DayBingImage dayBingImage = new DayBingImage();
        BeanUtils.copyProperties(record, dayBingImage);
        dayBingImage.setId(id);
        return this.dayBingImageMapper.updateByPrimaryKeySelective(dayBingImage);
    }

    public List<DayBingImage> selectByPage(DayBingImageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return this.dayBingImageMapper.selectByExample(new DayBingImageExample()
                .createCriteria()
                .when(query.getStartTime() != null, criteria -> criteria.andDateGreaterThanOrEqualTo(DateUtil.beginOfDay(query.getStartTime())))
                .when(query.getEndTime() != null, criteria -> criteria.andDateLessThanOrEqualTo(DateUtil.endOfDay(query.getEndTime())))
                .example()
                .orderBy(DayBingImage.Column.date.desc()));
    }

    public DayBingImage selectToday() {
        refresh();
        return dayBingImageMapper.selectOneByExample(new DayBingImageExample().createCriteria()
                .andDateBetween(DateUtil.offsetDay(new Date(), -1), new Date()).example()
                .orderBy(DayBingImage.Column.date.desc()));
    }

    public void refresh() {
        // 判断有没有今天的壁纸 ，没有则刷新
        long c = dayBingImageMapper.countByExample(new DayBingImageExample().createCriteria()
                .andDateBetween(DateUtil.offsetDay(new Date(), -1), new Date()).example());
        if (c < 1) {
            List<DayBingImage> list = BingImageUtils.dayBingImage();
            for (DayBingImage image : list) {
                DayBingImage db = dayBingImageMapper.selectOneByExample(new DayBingImageExample().createCriteria()
                        .andTitleEnEqualTo(image.getTitleEn()).example());
                if (db == null) {
                    dayBingImageMapper.insertSelective(image);
                }
            }
        }
    }

    public DayBingImage todayImage() {
        return dayBingImageMapper.selectOneByExample(new DayBingImageExample().createCriteria()
                .andDateBetween(DateUtil.offsetDay(new Date(), -1), new Date()).example());
    }
}