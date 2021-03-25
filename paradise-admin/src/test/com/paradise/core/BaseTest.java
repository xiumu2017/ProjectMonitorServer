package com.paradise.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    @Before
    public void before() {
        log.info("default before test fun..");
    }

    @After
    public void after() {
        log.info("default after test fun..");
    }

    @Test
    public void test() {
        Assert.assertEquals(123L, 122 + 1L);
        log.info("main test fun");
    }

}
