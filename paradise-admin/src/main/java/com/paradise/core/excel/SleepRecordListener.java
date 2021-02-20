package com.paradise.core.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.StringUtils;
import com.paradise.core.model.DaySleepRecord;
import com.paradise.core.service.impl.DaySleepRecordService;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Paradise
 */
@Slf4j
public class SleepRecordListener extends AnalysisEventListener<SleepRecordExcel> {

    private final List<DaySleepRecord> recordList = new ArrayList<>();
    private final DaySleepRecordService sleepRecordService;

    public SleepRecordListener(DaySleepRecordService sleepRecordService) {
        this.sleepRecordService = sleepRecordService;
    }

    public SleepRecordListener() {
        this.sleepRecordService = null;
    }

    @Override
    public void invoke(SleepRecordExcel sleepRecordExcel, AnalysisContext analysisContext) {
        try {
            if (StringUtils.isEmpty(sleepRecordExcel.getDate())) {
                return;
            }
            recordList.add(sleepRecordExcel.toSleepRecord());
        } catch (ParseException e) {
            log.error("Excel 数据转换异常", e);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("总数量：{}", recordList.size());
        if (this.sleepRecordService == null) {
            return;
        }
        int count = sleepRecordService.batchInsert(recordList);
        log.info("Excel批量导入{}行", count);
//        for (DaySleepRecord daySleepRecord : recordList) {
//            log.info(daySleepRecord.toString());
//        }
    }
}
