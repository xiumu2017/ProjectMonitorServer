package com.paradise.core.controller.test;

import chatbot.DentalCabotClient;
import chatbot.SendResult;
import chatbot.message.MarkdownMessage;
import chatbot.message.Message;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.paradise.core.common.api.Result;
import com.paradise.core.entity.HqData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
public class AbcTestController {

    private static final String TOKEN = "123456";

    @ApiOperationSupport(order = 1)
    @PostMapping("/interface")
    public TxCloudMarketResult txInterface(HttpServletRequest request, @RequestBody TxInterfaceData data) {
        if (!check(request)) {
            return TxCloudMarketResult.fail();
        }
        TxCloudMarketResult result = new TxCloudMarketResult();
        switch (data.getAction()) {
            case TxCloudMarketConst.Action.VERIFY:
                result = verifyInterface(data);
                break;
            case TxCloudMarketConst.Action.CREATE:
                result = createInstance(data);
                break;
            case TxCloudMarketConst.Action.RENEW:
                result = renewInstance(data);
                break;
            case TxCloudMarketConst.Action.MODIFY:
                result = modifyInstance(data);
                break;
            case TxCloudMarketConst.Action.EXPIRE:
                result = expireInstance(data);
                break;
            case TxCloudMarketConst.Action.DESTROY:
                result = destroyInstance(data);
                break;
            default:
                break;
        }
        return result;
    }

    //region 各种action的具体实现 待完成

    /**
     * 身份校验接口
     * <p>用户在 云市场服务商管理控制台 更改发货 URL 和 Token 时，后台会调用接口 URL 对 Token 进行实时校验，校验通过才可以设置成功</p>
     *
     * @param data 验证信息
     * @return {@link TxInterfaceData#getEchoback()}
     */
    public TxCloudMarketResult verifyInterface(TxInterfaceData data) {
        TxCloudMarketResult result = TxCloudMarketResult.success();
        result.setEchoback(data.getEchoback());
        return result;
    }

    /**
     * 实例创建通知接口
     * <p>用户购买商品并支付后，云市场将通过实例创建通知接口发送信息至发货 URL</p>
     *
     * @param data 参数 {@link TxInterfaceData}
     * @return {@link TxCloudMarketResult}
     */
    public TxCloudMarketResult createInstance(TxInterfaceData data) {
        // 关联业务
        return new TxCloudMarketResult();
    }

    /**
     * 实例续费通知接口
     * <p>用户续费商品后，云市场将通过实例续费通知接口发送消息至发货 URL。该接口需要服务商立即返回响应</p>
     *
     * @param data 参数 {@link TxInterfaceData}
     * @return {@link TxCloudMarketResult}
     */
    public TxCloudMarketResult renewInstance(TxInterfaceData data) {
        // 关联业务
        return new TxCloudMarketResult("false");
    }

    /**
     * 实例配置变更通知接口
     * <p>用户将实例从试用版转为正式版时，云市场将通过实例配置变更通知接口发送消息至发货 URL</p>
     * <p>注意：如果用户仅是配置变更，则参数中只会包含实例的新规格，而不会包含实例价格参数。</p>
     *
     * @param data 参数 {@link TxInterfaceData}
     * @return {@link TxCloudMarketResult}
     */
    public TxCloudMarketResult modifyInstance(TxInterfaceData data) {
        TxCloudMarketResult result = new TxCloudMarketResult();
        // 关联业务
        AppInfo appInfo = new AppInfo();
        appInfo.setAuthUrl("");
        result.setAppInfo(appInfo);
        return result;
    }

    /**
     * 实例过期通知接口
     * <p>实例到期后（用户最后操作后的 instanceExpireTime ），云市场将通过实例续费通知接口发送消息至发货 URL</p>
     *
     * @param data 参数 {@link TxInterfaceData}
     * @return {@link TxCloudMarketResult}
     */
    public TxCloudMarketResult expireInstance(TxInterfaceData data) {
        TxCloudMarketResult result = new TxCloudMarketResult();
        return new TxCloudMarketResult("false");
    }

    /**
     * 实例销毁通知接口
     * <p>用户退款、实例到期后的七天内如果用户没有进行续费操作，云市场会销毁该实例并通过该接口发送消息至发货 URL</p>
     *
     * @param data 参数 {@link TxInterfaceData}
     * @return {@link TxCloudMarketResult}
     */
    public TxCloudMarketResult destroyInstance(TxInterfaceData data) {
        TxCloudMarketResult result = new TxCloudMarketResult();
        return new TxCloudMarketResult("false");
    }
//endregion

//region 理解错了，其实是一个接口，不同参数

    /**
     * 身份校验接口
     * <p>用户在 云市场服务商管理控制台 更改发货 URL 和 Token 时，后台会调用接口 URL 对 Token 进行实时校验，校验通过才可以设置成功</p>
     *
     * @param request 请求信息
     * @param data    验证信息
     * @return {@link TxInterfaceData#getEchoback()}
     */
    @PostMapping("/verifyInterface")
    public String verifyInterface(HttpServletRequest request, @RequestBody TxInterfaceData data) {
        if (check(request)) {
            return data.getEchoback();
        }
        return "";
    }

    /**
     * 实例创建通知接口
     * <p>用户购买商品并支付后，云市场将通过实例创建通知接口发送信息至发货 URL</p>
     *
     * @param request 请求信息
     * @param data    参数 {@link TxInterfaceData}
     * @return {@link TxCloudMarketResult}
     */
    @PostMapping("/createInstance")
    public TxCloudMarketResult createInstance(HttpServletRequest request, @RequestBody TxInterfaceData data) {
        if (check(request)) {
            // 关联业务
            return new TxCloudMarketResult();
        }
        return null;
    }

    /**
     * 实例续费通知接口
     * <p>用户续费商品后，云市场将通过实例续费通知接口发送消息至发货 URL。该接口需要服务商立即返回响应</p>
     *
     * @param request 请求信息
     * @param data    参数 {@link TxInterfaceData}
     * @return {@link TxCloudMarketResult}
     */
    @PostMapping("/renewInstance")
    public TxCloudMarketResult renewInstance(HttpServletRequest request, @RequestBody TxInterfaceData data) {
        if (check(request)) {
            // 关联业务
            return new TxCloudMarketResult();
        }
        return new TxCloudMarketResult("false");
    }

    /**
     * 实例配置变更通知接口
     * <p>用户将实例从试用版转为正式版时，云市场将通过实例配置变更通知接口发送消息至发货 URL</p>
     * <p>注意：如果用户仅是配置变更，则参数中只会包含实例的新规格，而不会包含实例价格参数。</p>
     *
     * @param request 请求信息
     * @param data    参数 {@link TxInterfaceData}
     * @return {@link TxCloudMarketResult}
     */
    @PostMapping("/modifyInstance")
    public TxCloudMarketResult modifyInstance(HttpServletRequest request, @RequestBody TxInterfaceData data) {
        TxCloudMarketResult result = new TxCloudMarketResult();
        if (check(request)) {
            // 关联业务
            AppInfo appInfo = new AppInfo();
            appInfo.setAuthUrl("");
            result.setAppInfo(appInfo);
            return result;
        }
        return new TxCloudMarketResult("false");
    }

    /**
     * 实例过期通知接口
     * <p>实例到期后（用户最后操作后的 instanceExpireTime ），云市场将通过实例续费通知接口发送消息至发货 URL</p>
     *
     * @param request 请求信息
     * @param data    参数 {@link TxInterfaceData}
     * @return {@link TxCloudMarketResult}
     */
    @PostMapping("/expireInstance")
    public TxCloudMarketResult expireInstance(HttpServletRequest request, @RequestBody TxInterfaceData data) {
        TxCloudMarketResult result = new TxCloudMarketResult();
        if (check(request)) {
            // 关联业务
            return result;
        }
        return new TxCloudMarketResult("false");
    }

    /**
     * 实例销毁通知接口
     * <p>用户退款、实例到期后的七天内如果用户没有进行续费操作，云市场会销毁该实例并通过该接口发送消息至发货 URL</p>
     *
     * @param request 请求信息
     * @param data    参数 {@link TxInterfaceData}
     * @return {@link TxCloudMarketResult}
     */
    @PostMapping("/destroyInstance")
    public TxCloudMarketResult destroyInstance(HttpServletRequest request, @RequestBody TxInterfaceData data) {
        TxCloudMarketResult result = new TxCloudMarketResult();
        if (check(request)) {
            // 关联业务
            return result;
        }
        return new TxCloudMarketResult("false");
    }
//endregion

    /**
     * 验签方法
     *
     * @param request 请求信息
     * @return true 校验通过
     */
    private boolean check(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestampStr = request.getParameter("timestamp");
        String eventId = request.getParameter("eventId");
        // 参数不能为空
        if (StrUtil.hasEmpty(signature, timestampStr, eventId)) {
            return false;
        }
        // 判断是否超时
        long timestamp = Long.parseLong(timestampStr);
//        if (System.currentTimeMillis() / 1000 - timestamp > 30) {
//            return false;
//        }
        // 签名校验
        List<String> params = CollectionUtil.newArrayList(TOKEN, timestampStr, eventId);
        params.sort(null);
        StringBuilder paramStr = new StringBuilder();
        for (String param : params) {
            paramStr.append(param);
        }
        byte[] bytes = DigestUtil.sha256(paramStr.toString());
        String ss = Base64.getEncoder().encodeToString(bytes);
        String sss = new String(bytes);
        System.out.println(ss.equals(sss));
        return ss.equals(signature);
    }

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
