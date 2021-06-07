package com.paradise.core.plugins;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.Context;

import java.util.List;

public class MbgCommonUtils {
    private MbgCommonUtils() {
        throw new IllegalStateException();
    }

    public static TopLevelClass generate(IntrospectedTable introspectedTable, Context context, String targetPackage) {

        List<GeneratedJavaFile> generatedJavaFileList = introspectedTable.getGeneratedJavaFiles();
        if (generatedJavaFileList == null) {
            return null;
        }
        GeneratedJavaFile domainJavaFile = generatedJavaFileList.get(1);
        TopLevelClass domainLevelClass = (TopLevelClass) domainJavaFile.getCompilationUnit();
        String domainClsShortName = domainLevelClass.getType().getShortName().split("\\.")[0];
        return new TopLevelClass(targetPackage + "." + domainClsShortName + "Body");
    }

    public static boolean ignore(IntrospectedColumn column) {
        if (
                "createBy".equals(column.getJavaProperty()) ||
                        "updateBy".equals(column.getJavaProperty()) ||
                        "deleted".equals(column.getJavaProperty()) ||
                        "createAt".equals(column.getJavaProperty()) ||
                        "updateAt".equals(column.getJavaProperty())
        ) {
            return true;
        }
        return "id".equals(column.getJavaProperty());
    }
}
