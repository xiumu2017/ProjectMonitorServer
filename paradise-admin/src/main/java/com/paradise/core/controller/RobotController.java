package com.paradise.core.controller;

import com.paradise.core.entity.ding.DingMsg;
import com.paradise.core.entity.ding.ResMsg;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@Slf4j
@ApiIgnore
@AllArgsConstructor
public class RobotController {

    private static final String SECRET = "lTSsp8qnWqbo_SX3M2TcyEp9DJ6TTPCqdAaXn13q4OZLe56QWbYRzu_gv3phfXPl";

    @PostMapping("/msg")
    public String message(@RequestBody DingMsg msg, HttpServletRequest request) {
        log.info("收到钉钉机器人消息：");
        log.info(msg.toString());

        log.info("验签结果：{}", check(request));

        return new ResMsg(msg.getText().getContent(), msg.getSenderStaffId()).toJsonString();
    }

    private boolean check(HttpServletRequest request) {
        Long timestamp = Long.valueOf(request.getHeader("timestamp"));

        String sign = request.getHeader("sign");
        String stringToSign = timestamp + "\n" + SECRET;

        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(SECRET.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            String signStr = new String(Base64.encodeBase64(signData));
            return signStr.equals(sign);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return false;
    }

}
