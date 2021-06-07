package com.paradise.core.plugins;

import cn.hutool.core.collection.CollectionUtil;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.DefaultJavaFormatter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * dto生成插件
 *
 * @author yanfeilin
 * @version 1.0.0
 * @date 2020/5/23 19:06
 */
public class QueryGenPlugin extends PluginAdapter {

    private boolean enable;
    private String targetPackage;
    private String baseQuery;

    @Override
    public boolean validate(List<String> warnings) {
        targetPackage = getProperties().getProperty("targetPackage");
        baseQuery = getProperties().getProperty("baseQuery");
        enable = Boolean.parseBoolean(getProperties().getProperty("enable"));
        if (StringUtils.isEmpty(targetPackage) || StringUtils.isEmpty(baseQuery)) {
            warnings.add("targetPackage baseQuery must not be empty");
            return false;
        }
        return true;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        if (!enable) {
            return Collections.emptyList();
        }
        String targetProject = context.getJavaModelGeneratorConfiguration().getTargetProject();
        List<GeneratedJavaFile> generatedJavaFileList = introspectedTable.getGeneratedJavaFiles();
        if (generatedJavaFileList == null) {
            return Collections.emptyList();
        }
        GeneratedJavaFile domainJavaFile = generatedJavaFileList.get(1);
        TopLevelClass domainLevelClass = (TopLevelClass) domainJavaFile.getCompilationUnit();
        //获取domain简类名
        String domainClsShortName = domainLevelClass.getType().getShortName().split("\\.")[0];
        //dto全类名
        String dtoClsFullName = targetPackage + "." + domainClsShortName + "Query";
        TopLevelClass dtoLevelClass = new TopLevelClass(dtoClsFullName);

        //设置dto基本信息
        setQueryBaseInfo(dtoLevelClass, introspectedTable);

        addQueryFields(introspectedTable, dtoLevelClass);

        DefaultJavaFormatter javaFormatter = new DefaultJavaFormatter();
        GeneratedJavaFile queryJavaFile = new GeneratedJavaFile(dtoLevelClass, targetProject, javaFormatter);
        // 这里怎么递归了？ 堆栈溢出了！！！
//        List<GeneratedJavaFile> additionalJavaFileList = context.getPlugins().contextGenerateAdditionalJavaFiles(introspectedTable);
//        additionalJavaFileList.add(queryJavaFile);
//        return additionalJavaFileList;
        List<GeneratedJavaFile> additionalJavaFileList = super.contextGenerateAdditionalJavaFiles(introspectedTable);
        if (CollectionUtil.isEmpty(additionalJavaFileList)) {
            return Collections.singletonList(queryJavaFile);
        }
        additionalJavaFileList.add(queryJavaFile);
        return additionalJavaFileList;
    }

    protected void setQueryBaseInfo(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //设置可见性
        topLevelClass.setVisibility(JavaVisibility.PUBLIC);
        topLevelClass.setFinal(false);
        //添加注释
        topLevelClass.addJavaDocLine(MbgCommentUtils.genClassRemarks(introspectedTable.getRemarks(), "查询参数"));
        // 添加注解
        topLevelClass.addAnnotation("@ApiModel(value = \"" + introspectedTable.getRemarks().replace("表", "") + "查询参数\")");
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = true)");
        //继承基类
        if (StringUtils.isEmpty(baseQuery)) {
            String dtoBaseCls = "java.io.Serializable";
            topLevelClass.addSuperInterface(new FullyQualifiedJavaType(dtoBaseCls));
        } else {
            topLevelClass.setSuperClass(baseQuery);
        }
        topLevelClass.addImportedType(baseQuery);
        topLevelClass.addImportedType("io.swagger.annotations.ApiModel");
        topLevelClass.addImportedType("io.swagger.annotations.ApiModelProperty");
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addImportedType("lombok.EqualsAndHashCode");
    }

    protected void addQueryFields(IntrospectedTable introspectedTable, TopLevelClass dtoLevelCls) {
        List<IntrospectedColumn> columnList = introspectedTable.getAllColumns();
        Field field;
        StringBuilder swaggerAnnotationBuilder = new StringBuilder(128);
        for (IntrospectedColumn introspectedColumn : columnList) {
            if (ignore(introspectedColumn)) {
                continue;
            }
            String fieldName = introspectedColumn.getJavaProperty();
            field = new Field(fieldName, introspectedColumn.getFullyQualifiedJavaType());
            field.setVisibility(JavaVisibility.PRIVATE);
            String columnRemark = introspectedColumn.getRemarks();
            //增加注释
            field.addJavaDocLine(MbgCommentUtils.genFieldRemarks(columnRemark));
            // 增加 注解
            swaggerAnnotationBuilder.delete(0, swaggerAnnotationBuilder.length());
            swaggerAnnotationBuilder.append("@ApiModelProperty(value = \"").append(columnRemark).append("\"").append(")");
            field.addAnnotation(swaggerAnnotationBuilder.toString());
            if (!introspectedColumn.isNullable()) {
                swaggerAnnotationBuilder.append(" ,required=true");
                if (introspectedColumn.getDefaultValue() != null) {
                    swaggerAnnotationBuilder.append(" ,example=\"").append(introspectedColumn.getDefaultValue()).append("\"");
                }
                swaggerAnnotationBuilder.append(")");
            }
            dtoLevelCls.addField(field);
        }
    }

    private boolean ignore(IntrospectedColumn column) {
        if (column.getFullyQualifiedJavaType().equals(new FullyQualifiedJavaType("java.util.Date"))) {
            return true;
        }
        if ("createBy".equals(column.getJavaProperty()) || "updateBy".equals(column.getJavaProperty())) {
            return true;
        }
        if ("deleted".equals(column.getJavaProperty())) {
            return true;
        }
        return "id".equals(column.getJavaProperty()) || "remark".equals(column.getJavaProperty());
    }

}
