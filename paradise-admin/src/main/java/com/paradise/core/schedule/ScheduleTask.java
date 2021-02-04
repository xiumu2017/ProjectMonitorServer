
package com.paradise.core.schedule;

import chatbot.DentalCabotClient;
import com.paradise.core.entity.poem.PoemEntity;
import com.paradise.core.model.DayBingImage;
import com.paradise.core.service.impl.DayBingImageService;
import com.paradise.core.utils.bing.BingImageUtils;
import com.paradise.core.utils.poem.PoemSendUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author dzhang
 */
@Slf4j
@Component
public class ScheduleTask {

    public final String secret = "SEC562a6359d5b1943bc9393f76ed4bcb25d2503eedd8d6c1df0490935eeb33873f";
    private final String token = "ba181262d3c9fec090a82b8835bdf5d277d78c930a3c878dc949e40633d39eee";
    private final DayBingImageService dayBingImageService;

    public ScheduleTask(DayBingImageService dayBingImageService) {
        this.dayBingImageService = dayBingImageService;
    }

    /**
     * 每天8点 推送古诗词一首
     */
    @Scheduled(cron = "0 0 8 * * ?")
    public void scheduled() {
        try {
            PoemEntity poemEntity = PoemSendUtils.getPoem();
            DentalCabotClient.send(token, PoemSendUtils.poem2Md(poemEntity), secret);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 每天9点 推送壁纸 到钉钉群
     */
    @Scheduled(cron = "0 0 9 * * ?")
    public void scheduled1() {
        DayBingImage bingImage = dayBingImageService.selectToday();
        DentalCabotClient.send(token, BingImageUtils.bingResult2Msg(bingImage), secret);
        log.info("<<< Bing push success!");
    }

}
