package com.paradise.core.schedule;

import com.paradise.core.common.service.impl.QCloudOssService;
import com.paradise.core.mapper.DayBingImageMapper;
import com.paradise.core.model.DayBingImage;
import com.paradise.core.utils.bing.BingImageUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Paradise
 */
@Slf4j
@Component
@Profile({"test", "dev"})
@AllArgsConstructor
public class SchedulerJob {

    private final DayBingImageMapper bingImageMapper;
    private final QCloudOssService ossService;

    @Scheduled(cron = "1 0 0 1/1 * *")
    public void resetWorkerOrderCount() {
        log.info("每日零点：开始重置会员订单数量");
    }

    @Scheduled(cron = "0 0 0 1/1 * *")
    public void resetWorkerLevel() {
        log.info("每日零点：开始重置会员等级");
    }


    /**
     * 每天7点 查询 bing 壁纸
     */
    @Scheduled(cron = "0 0 7 * * ?")
    public void bingImage() {
        // 获取壁纸
        DayBingImage bingImage = BingImageUtils.dayBingImage();
        if (bingImage != null) {
            bingImageMapper.insertSelective(bingImage);
            // 上传到对象存储服务
            try {
                URL url = new URL(bingImage.getUrl());
                URLConnection connection = url.openConnection();
                ossService.upload("bing", connection.getInputStream(), bingImage.getTitleEn());
            } catch (IOException e) {
                log.error("bing 壁纸上传到Oss异常：{}", e.getLocalizedMessage(), e);
            }
        }
    }
}
