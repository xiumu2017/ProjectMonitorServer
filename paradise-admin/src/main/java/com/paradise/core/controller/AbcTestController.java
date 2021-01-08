package com.paradise.core.controller;

import chatbot.DentalCabotClient;
import chatbot.SendResult;
import chatbot.message.MarkdownMessage;
import chatbot.message.Message;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.paradise.core.common.api.Result;
import com.paradise.core.entity.HqData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/test")
public class AbcTestController {

    @GetMapping("/hq")
    public Result<HqData> test() {
        HttpRequest request = HttpUtil.createGet("http://hq.sinajs.cn/list=gb_bidu");
        HttpResponse response = request.execute();
        log.info("{}", response);
        if (response.isOk()) {
            HqData data = parse(response.body());
            push(data);
            return Result.success(data);
        }

        return Result.failed();
    }

    private HqData parse(String body) {
        HqData hqData = new HqData();
//        var hq_str_gb_bidu="百度,
//        203.9700,
//        -4.69,
//        2021-01-07 18:50:36,
//        -10.0300,212.7800,213.3400,203.6200,227.5800,82.0000,8006049,9222548,69569198290,9.91,20.580000,0.00,0.00,0.00,0.00,341075640,84,213.7000,4.77,9.73,Jan 07 05:50AM EST,Jan 06 04:00PM EST,214.0000,63528,1,2021,1665788152.8147,215.2500,208.0000,13585872.6500";
        String data = body.substring(body.indexOf("\"") + 1, body.lastIndexOf("\""));
        String[] dataArr = data.split(",");
        hqData.setName(dataArr[0]);
        hqData.setCurrentPrice(new BigDecimal(dataArr[1]));
        hqData.setIncrease(new BigDecimal(dataArr[2]));
        hqData.setDate(DateUtil.parseDateTime(dataArr[3]));
        return hqData;
    }

    private void push(HqData data) {
//https://oapi.dingtalk.com/robot/send?access_token=ba181262d3c9fec090a82b8835bdf5d277d78c930a3c878dc949e40633d39eee
        SendResult result = DentalCabotClient.send("ba181262d3c9fec090a82b8835bdf5d277d78c930a3c878dc949e40633d39eee", toMessage(data), "SEC562a6359d5b1943bc9393f76ed4bcb25d2503eedd8d6c1df0490935eeb33873f");
        log.info("result :{}", result);
    }

    private Message toMessage(HqData data) {
        MarkdownMessage message = new MarkdownMessage();
        message.setTitle("股票推送");
        message.add(MarkdownMessage.getHeaderText(1, data.getName()));
        message.add(MarkdownMessage.getBoldText("当前股价：" + data.getCurrentPrice().toString()));
        message.add(MarkdownMessage.getBoldText("涨幅：" + data.getIncrease().toString() + "%"));
        message.add(MarkdownMessage.getBoldText("查询时间：" + DateUtil.formatDateTime(data.getDate())));
        return message;
    }
}
