package com.paradise.core.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

public class AesUtils {
    /**
     * Aes 加密
     *
     * @param content 待加密的内容
     * @param key     秘钥
     * @return 加密后的字符串
     */
    public static String encryptBase64(String content, String key) {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes());
        return aes.encryptBase64(content);
    }

    /**
     * Aes 解密
     *
     * @param encryptBase64 待解密的内容
     * @param key           秘钥
     * @return 解密后的字符串
     */
    public static String decryptStr(String encryptBase64, String key) {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes());
        return aes.decryptStr(encryptBase64, CharsetUtil.CHARSET_UTF_8);
    }

    public static void main(String[] args) {
        String key = "5a2986bf35e6a0a54f4fe94a8261ab27";
        String content = "Qwer125@5_67";
        String encryptHex = encryptBase64(content, key);
        System.out.println(encryptHex);
        String decryptStr = decryptStr(encryptHex, key);
        System.out.println(decryptStr);
    }

}
