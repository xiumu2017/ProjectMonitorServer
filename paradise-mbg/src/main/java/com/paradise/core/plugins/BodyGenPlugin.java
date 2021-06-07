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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * dto生成插件
 *
 * @author yanfeilin
 * @version 1.0.0
 * @date 2020/5/23 19:06
 */
public class BodyGenPlugin extends PluginAdapter {

    private String targetPackage;
    private boolean enable;

    @Override
    public boolean validate(List<String> warnings) {
        targetPackage = getProperties().getProperty("targetPackage");
        enable = Boolean.parseBoolean(getProperties().getProperty("enable"));
        if (StringUtils.isEmpty(targetPackage)) {
            warnings.add("targetPackage must not be empty");
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
        TopLevelClass topLevelClass = MbgCommonUtils.generate(introspectedTable, context, targetPackage);
        if (topLevelClass == null) {
            return new ArrayList<>();
        }
        setBodyBaseInfo(topLevelClass, introspectedTable);
        addBodyFields(introspectedTable, topLevelClass);
        GeneratedJavaFile queryJavaFile = new GeneratedJavaFile(topLevelClass, targetProject, new DefaultJavaFormatter());
        List<GeneratedJavaFile> additionalJavaFileList = super.contextGenerateAdditionalJavaFiles(introspectedTable);
        if (CollectionUtil.isEmpty(additionalJavaFileList)) {
            return Collections.singletonList(queryJavaFile);
        }
        additionalJavaFileList.add(queryJavaFile);
        return additionalJavaFileList;
    }

    protected void setBodyBaseInfo(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //设置可见性
        topLevelClass.setFinal(false);
        topLevelClass.setVisibility(JavaVisibility.PUBLIC);
        //添加注释
        topLevelClass.addJavaDocLine(MbgCommentUtils.genClassRemarks(introspectedTable.getRemarks(), "Body"));
        // 添加注解
        topLevelClass.addAnnotation("@ApiModel(value = \"" + introspectedTable.getRemarks().replace("表", "") + "Body\")");
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addImportedType("io.swagger.annotations.ApiModel");
        topLevelClass.addImportedType("io.swagger.annotations.ApiModelProperty");
        topLevelClass.addImportedType("lombok.Data");
    }

    protected void addBodyFields(IntrospectedTable introspectedTable, TopLevelClass topLevelClass) {
        List<IntrospectedColumn> columnList = introspectedTable.getAllColumns();
        Field field;
        StringBuilder swaggerAnnotationBuilder = new StringBuilder();
        StringBuilder notEmptyAnnotationBuilder = new StringBuilder();
        StringBuilder notNullAnnotationBuilder = new StringBuilder();
        boolean notNullImported = false;
        boolean notEmptyImported = false;

        for (IntrospectedColumn introspectedColumn : columnList) {
            if (MbgCommonUtils.ignore(introspectedColumn)) {
                continue;
            }
            field = new Field(introspectedColumn.getJavaProperty(), introspectedColumn.getFullyQualifiedJavaType());
            field.setVisibility(JavaVisibility.PRIVATE);
            String columnRemark = introspectedColumn.getRemarks();
            //增加注释
            field.addJavaDocLine(MbgCommentUtils.genFieldRemarks(columnRemark));
            // 增加 注解
            swaggerAnnotationBuilder.append("@ApiModelProperty(value = \"").append(columnRemark).append("\"");
            // 数据库配置不为空
            if (!introspectedColumn.isNullable()) {
                swaggerAnnotationBuilder.append(",").append(" required = true,");
                swaggerAnnotationBuilder.append(" example = \"").append(introspectedColumn.getDefaultValue()).append("\"");

                if (new FullyQualifiedJavaType("java.lang.String")
                        .equals(introspectedColumn.getFullyQualifiedJavaType())) {
                    notEmptyAnnotationBuilder.append("@NotEmpty(message = \"").append(columnRemark).append("不能为空!\")");
                } else {
                    notNullAnnotationBuilder.append("@NotNull(message = \"").append(columnRemark).append("不能为空!\")");
                }
            }
            field.addAnnotation(swaggerAnnotationBuilder.append(")").toString());
            swaggerAnnotationBuilder.delete(0, swaggerAnnotationBuilder.length());
            if (notEmptyAnnotationBuilder.length() > 0) {
                field.addAnnotation(notEmptyAnnotationBuilder.toString());
                notEmptyAnnotationBuilder.delete(0, notEmptyAnnotationBuilder.length());
                if (!notEmptyImported) {
                    topLevelClass.addImportedType("javax.validation.constraints.NotEmpty");
                    notEmptyImported = true;
                }
            }
            if (notNullAnnotationBuilder.length() > 0) {
                field.addAnnotation(notNullAnnotationBuilder.toString());
                notNullAnnotationBuilder.delete(0, notNullAnnotationBuilder.length());
                if (!notNullImported) {
                    topLevelClass.addImportedType("javax.validation.constraints.NotNull");
                    notNullImported = true;
                }
            }
            topLevelClass.addField(field);
        }
    }

}
