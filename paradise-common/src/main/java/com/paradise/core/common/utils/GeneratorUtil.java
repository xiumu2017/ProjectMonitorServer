package com.paradise.core.common.utils;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import static cn.hutool.core.date.DatePattern.PURE_TIME_PATTERN;

/**
 * 常见随机数序列生成
 *
 * @author Paradise
 */
@Slf4j
public class GeneratorUtil {
    private static final String USER_NAME_FORMAT = "U%05d";

    private GeneratorUtil() {
        throw new IllegalStateException();
    }

    public static void main(String[] args) {
        log.info(getNonceString());
    }

    /**
     * 得到from到to的随机数，包括to
     */
    private static int getRandomNumber(int from, int to) {
        float a = from + (to - from) * (new Random().nextFloat());
        int b = (int) a;
        return ((a - b) > 0.5 ? 1 : 0) + b;
    }

    public static String getNonceString(int len) {
        String seed = "23456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < len; i++) {
            tmp.append(seed.charAt(getRandomNumber(0, 33)));
        }
        return tmp.toString();
    }

    public static String getNonceString() {
        String seed = "1234567890AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            tmp.append(seed.charAt(getRandomNumber(0, 33)));
        }
        return tmp.toString();
    }

    public static String getNonceNumberString(int len) {
        String seed = "1234567890";
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < len; i++) {
            tmp.append(seed.charAt(getRandomNumber(0, 9)));
        }
        return tmp.toString();
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String getOrderId(String prefix) {
        String body = String.valueOf(System.currentTimeMillis());
        return prefix + body + getRandomNumber(10, 99);
    }

    /**
     * 注册成功生成推广码
     *
     * @return 推广码
     */
    public static String generatePromotionCode(Long id) {
        return String.format(USER_NAME_FORMAT, id) + GeneratorUtil.getNonceString(2);
    }

    public static String fileNamePrefix() {
        return DateUtil.format(new Date(), PURE_TIME_PATTERN) + GeneratorUtil.getNonceString(2);
    }

    /**
     * 生成文件名
     *
     * @param originFileName 原始文件名称
     * @return 时间 HHmmss+文件名 切割
     */
    public static String generateFileName(String originFileName) {
        if (StringUtils.isEmpty(originFileName)) {
            originFileName = "";
        }
        // 保留后缀名
        String suffix = "";
        int s = originFileName.lastIndexOf(".");
        if (s >= 0) {
            suffix = originFileName.substring(s);
            originFileName = originFileName.substring(0, s);
        }
        if (originFileName.length() > 30) {
            originFileName = originFileName.substring(0, 30);
        }
        return fileNamePrefix() + originFileName + suffix;
    }

}