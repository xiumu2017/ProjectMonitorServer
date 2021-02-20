package com.paradise.core.excel;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.annotation.ExcelProperty;
import com.paradise.core.model.DaySleepRecord;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class SleepRecordExcel {
    @ExcelProperty(value = "日期")
    private String date;
    @ExcelProperty(value = "入睡时间")
    private String sleepTime;
    @ExcelProperty(value = "醒来时间")
    private String wakeTime;
    @ExcelProperty(value = "起床时间")
    private String upTime;
    @ExcelProperty(index = 4)
    private String quality;
    @ExcelProperty(value = "睡前回忆")
    private String memory;
    @ExcelProperty(index = 5)
    private String remark;
    @ExcelProperty(index = 6)
    private String remark1;
    @ExcelProperty(index = 8)
    private String remark2;
    @ExcelProperty(index = 9)
    private String remark3;
    @ExcelProperty(value = "熬夜原因")
    private String reason;

    DaySleepRecord toSleepRecord() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String sleepTimeStr = this.date + " " + this.sleepTime;
        int sleepTimeInt = Math.toIntExact(sdf.parse(sleepTimeStr).getTime() / 1000);
        String prefix = this.sleepTime.split(":")[0];
        if (Integer.parseInt(prefix) > 18) {
            sleepTimeInt = sleepTimeInt - 24 * 3600;
        }
        String wakeTimeStr = this.date + " " + this.wakeTime;
        Date wakeTime = sdf.parse(wakeTimeStr);
        String upTimeStr = this.date + " " + this.upTime;
        Integer qualityInt = this.quality == null ? 0 : this.quality.length();
//        Integer qualityInt = Integer.parseInt(this.quality);
        String remark = getRemarkStr();
        int duration = Math.toIntExact(wakeTime.getTime() / 1000 - sleepTimeInt);
        return DaySleepRecord.builder()
                .date(DateUtil.parse(this.date, "yyyy/MM/dd"))
                .bedTime(new Date(sleepTimeInt * 1000L))
                .createAt(new Date())
                .sleepTime(new Date(sleepTimeInt * 1000L))
                .remark(remark)
                .sleepQuality(qualityInt)
                .upTime(sdf.parse(upTimeStr))
                .wakeTime(wakeTime)
                .duration(duration)
                .appData("/")
                .bestTime("/")
                .createBy(0L)
                .lateReason(nullStr(this.reason))
                .memory(nullStr(this.memory))
                .updateAt(new Date())
                .updateBy(0L)
                .build();
    }

    private String getRemarkStr() {
        if (isNull(this.remark)) {
            this.remark = "";
        }
        if (isNull(this.remark1)) {
            this.remark1 = "";
        }
        if (isNull(this.remark2)) {
            this.remark2 = "";
        }
        if (isNull(this.remark3)) {
            this.remark3 = "";
        }
        return this.remark + "; " + this.remark1 + "; " + this.remark2 + "; " + this.remark3;
    }

    private boolean isNull(String target) {
        return target == null || "null".equals(target);
    }

    private String nullStr(String tar) {
        if (isNull(tar)) {
            return "/";
        }
        return tar;
    }

}
