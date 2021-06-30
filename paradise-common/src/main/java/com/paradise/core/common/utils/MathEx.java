package com.paradise.core.common.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.stream.LongStream;

public class MathEx {
    public static final BigInteger SWEEP_PAGE_SIZE = BigInteger.valueOf(1000);

    public static void main(String[] args) {
        BigInteger b1 = BigInteger.valueOf(46147);
        BigInteger b2 = BigInteger.valueOf(1490192);
        final long s = b1.divide(SWEEP_PAGE_SIZE).longValue();
        System.out.println(s);
        final long x = b2.divide(SWEEP_PAGE_SIZE).longValue();
        System.out.println(x);

        LongStream.range(s, x).parallel().mapToObj(BigInteger::valueOf).forEach(System.out::println);

        BigInteger start = SWEEP_PAGE_SIZE.multiply(BigInteger.valueOf(s));
        BigInteger end = start.add(SWEEP_PAGE_SIZE).subtract(BigInteger.ONE);
        System.out.println("start = " + start);
        System.out.println("end = " + end);

        BigDecimal confidence = new BigDecimal("0.95");
        confidence = confidence.divide(BigDecimal.valueOf(2), 10, RoundingMode.DOWN);
        System.out.println("confidence = " + confidence);
    }
}
