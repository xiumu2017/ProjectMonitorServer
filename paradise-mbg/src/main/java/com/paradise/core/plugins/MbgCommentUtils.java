package com.paradise.core.plugins;

/**
 * MBG 生成注释工具类
 *
 * @author Paradise
 */
public class MbgCommentUtils {

    private MbgCommentUtils() {
        throw new IllegalStateException();
    }

    /**
     * 生成类注释
     *
     * @param remark 数据库表注释
     * @return 类注释
     */
    public static String genClassRemarks(String remark, String params) {
        remark = remark.replace("表", "");
        if (params != null) {
            remark = remark + params;
        }
        return "/**\n" +
                " * " + remark + "\n" +
                " *\n" +
                " * @author Paradise\n" +
                " */";
    }

    public static String genFieldRemarks(String remark) {
        return "/**\n" +
                "     * " + remark + "\n" +
                "     */";
    }
}
