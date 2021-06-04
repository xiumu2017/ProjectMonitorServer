package com.paradise.core.controller;

import com.baomidou.kaptcha.Kaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

/**
 * 图形验证码接口
 *
 * @author Paradise
 */
@Slf4j
@Api(tags = "0. 图形验证码")
@RestController
@RequestMapping("/kaptcha")
public class KaptchaController {

    private final Kaptcha kaptcha;

    public KaptchaController(Kaptcha kaptcha) {
        this.kaptcha = kaptcha;
    }

    @GetMapping("/render")
    @ApiOperation(value = "获取图形验证码", notes = "图形验证")
    public void render(@ApiIgnore HttpSession httpSession) {
        String code = kaptcha.render();
        log.info("图形验证码：{}", code);
        log.info("SessionId: {}", httpSession.getId());
    }

    @PostMapping("/valid")
    public String validDefaultTime(@RequestParam String code, @ApiIgnore HttpSession httpSession) {
        //default timeout 900 seconds
        log.info("Validate SessionId: {}", httpSession.getId());
        if (kaptcha.validate(code)) {
            return "true";
        }
        return "false";
    }

}