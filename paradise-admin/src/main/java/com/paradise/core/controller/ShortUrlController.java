package com.paradise.core.controller;

import com.paradise.core.common.api.Result;
import com.paradise.core.common.service.RedisService;
import com.paradise.core.common.utils.GeneratorUtil;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yangzhi
 */
@Slf4j
@Controller
@RequestMapping("/su")
@Api(tags = {"二维码用短链接"})
@AllArgsConstructor
public class ShortUrlController {
    /**
     * key 前缀
     */
    private static final String KEY_PREFIX = "SHORT-URL:";
    /**
     * 超时时间
     */
    private static final long OVER_TIME = 1800L;
    private final RedisService redisService;

    @PostMapping("create")
    @ResponseBody
    public Result<String> create(String url) {
        String key = GeneratorUtil.getNonceString(6);
        redisService.set(KEY_PREFIX + key, url, OVER_TIME);
        return Result.success(key);
    }

    @GetMapping("{hash}")
    public String getByHash(@PathVariable String hash, HttpServletResponse response) {
        String url = (String) redisService.get(KEY_PREFIX + hash);
        if (url != null) {
            try {
                response.sendRedirect(url);
            } catch (IOException e) {
                log.error(e.getLocalizedMessage(), e);
            }
        }
        return url;
    }

    @GetMapping("/v/{hash}")
    public void getByHashV2(@PathVariable String hash, HttpServletResponse response) {
        String url = (String) redisService.get(KEY_PREFIX + hash);
        if (url != null) {
            response.setHeader("Location", url);
            response.setStatus(302);
        } else {
            response.setStatus(404);
        }
    }

    @GetMapping("/v2/{hash}")
    public ModelAndView getByHashV3(@PathVariable String hash, ModelAndView mav) {
        String url = (String) redisService.get(KEY_PREFIX + hash);
        // 跳转
        mav.setViewName("redirect:" + url);
        return mav;
    }
}
