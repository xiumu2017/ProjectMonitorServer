package com.paradise.core;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 应用启动入口
 *
 * @author Paradise
 * @date 2018/4/26
 */
@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.paradise.core")
@EnableKnife4j
public class ParadiseAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ParadiseAdminApplication.class, args);
    }

}
