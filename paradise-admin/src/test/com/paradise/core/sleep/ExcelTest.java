package com.paradise.core.sleep;

import com.alibaba.excel.EasyExcel;
import com.paradise.core.excel.SleepRecordExcel;
import com.paradise.core.excel.SleepRecordListener;
import com.paradise.core.service.impl.DaySleepRecordService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelTest {

    @Autowired
    DaySleepRecordService daySleepRecordService;

    @Test
//    @Transactional
//    @Rollback
    public void test() {
        String filePath = "D:\\Docs\\SleepRecord_12.xlsx";
//        String filePath = "D:\\Docs\\睡眠记录.xlsx";
        EasyExcel.read(filePath, SleepRecordExcel.class,
                new SleepRecordListener(daySleepRecordService)).sheet().doRead();
        Assert.assertEquals(5, 5);
    }
}
