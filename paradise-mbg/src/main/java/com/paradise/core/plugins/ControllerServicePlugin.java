package com.paradise.core.plugins;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.exception.ShellException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.util.StringUtility;

import java.io.File;
import java.util.*;

/**
 * 在 Mybatis Generator 的基础上生成 Controller 与 Service 类,适用于Spring与Mybatis整合的项目.
 * 为 Mybatis Generator 的 Mapper.java 生成对应的 Controller 与 Service 类.
 *
 * @author linweiyu
 */
@Slf4j
public class ControllerServicePlugin extends PluginAdapter {

    private static final String IS_GENERATE_CONTROLLER_SERVICE = "enable";
    private GeneratorParam generatorParam;
    private Boolean enable;
    private String targetProject;
    private String servicePackage;
    private String serviceImplPackage;
    private String webPackage;

    @Override
    public boolean validate(List<String> warnings) {
        log.info("--- validate invoke");
        enable = Boolean.valueOf(properties.getProperty(IS_GENERATE_CONTROLLER_SERVICE));
        // src/main/java
        targetProject = properties.getProperty("targetProject");
        log.info("--- targetProject=[{}]", targetProject);
        // Service与Controller所在的包的包名
        servicePackage = properties.getProperty("servicePackage");
        serviceImplPackage = servicePackage + ".impl";
        webPackage = properties.getProperty("controllerPackage");
        log.info("--- servicePackage=[{}]", servicePackage);
        log.info("--- webPackage=[{}]", webPackage);
        return true;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        log.info("--- contextGenerateAdditionalJavaFiles invoke");
        List<GeneratedJavaFile> generatedJavaFiles = super.contextGenerateAdditionalJavaFiles(introspectedTable);
        Properties properties = getProperties();
        // 是否生成Service,Controller类
        log.info("--- is_generate_controller_service=[{}]", enable);
        if (enable) {
            if (generatedJavaFiles == null) {
                generatedJavaFiles = new ArrayList<>();
            }
            // 实体类的包名
            String modelTargetPackage = getContext().getJavaModelGeneratorConfiguration().getTargetPackage();
            // 实体类的类名
            String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
            // 实体类的全限定类名
            String modalFullName = modelTargetPackage + "." + domainObjectName;
            // Example
            String example = introspectedTable.getExampleType();
            log.info("--- modalFullName=[{}]", modalFullName);

            // 生成Service类所在的包(对应文件系统的文件夹),同时生成impl包
            DefaultShellCallback shellCallback = new DefaultShellCallback(true);
            generatorParam = GeneratorParam.builder()
                    .domainObjectName(domainObjectName)
                    .exampleFullName(example)
                    .queryFullName(example.replace("example", "dto.query")
                            .replace(domainObjectName + "Example", domainObjectName + "Query"))
                    .bodyFullName(example.replace("example", "dto.body")
                            .replace(domainObjectName + "Example", domainObjectName + "Body"))
                    .targetProject(targetProject)
                    .servicePackage(servicePackage)
                    .serviceImplPackage(serviceImplPackage)
                    .modalFullName(modalFullName)
                    .webPackage(webPackage)
                    .build();
            // 生成Service相关类
            generateServiceFile(introspectedTable, generatedJavaFiles);
            // 生成Controller相关类
            generateControllerJavaFile(introspectedTable, generatedJavaFiles, shellCallback);
        }

        return generatedJavaFiles;
    }


    private void generateControllerJavaFile(IntrospectedTable introspectedTable, List<GeneratedJavaFile> generatedJavaFiles,
                                            DefaultShellCallback shellCallback) {
        try {
            File controllerDirectory = shellCallback.getDirectory(generatorParam.getTargetProject(), generatorParam.getWebPackage());
            String absolutePath = controllerDirectory.getAbsolutePath();
            if (StringUtility.stringHasValue(absolutePath)) {
                log.info("--- 创建目录(包)成功=[{}]", absolutePath);
            }
        } catch (ShellException e) {
            log.error(e.getMessage(), e);
        }
        // ServiceImpl类
        // typeName为类的全限定类名
        String typeName = generatorParam.getWebPackage() + "." + generatorParam.getDomainObjectName() + "Controller";
        // TopLevelClass类代表要生成的类,mybatis根据TopLevelClass类代表要生成一个类的field,method等
        TopLevelClass controllerClass = new TopLevelClass(typeName);
        controllerClass.addJavaDocLine("/**\n" +
                " * " + introspectedTable.getRemarks() + "控制器 \n" +
                " *\n" +
                " * @author Paradise\n" +
                " */");
        controllerClass.setVisibility(JavaVisibility.PUBLIC);

        // 为类添加注解
        controllerClass.addAnnotation("@RestController");
        controllerClass.addAnnotation("@AllArgsConstructor");
        controllerClass.addAnnotation("@Api(tags = \"" + introspectedTable.getRemarks().replaceAll("表", "") + "相关接口\")");
        controllerClass.addAnnotation("@RequestMapping(\"/" + toLowerCaseFirstOne(generatorParam.getDomainObjectName()) + "\")");
        // 为类添加Field
        setControllerField(controllerClass, introspectedTable, generatorParam.getServiceImplPackage());
        // 为类添加方法
        setControllerMethod(controllerClass, introspectedTable);
        // 为Service类添加import类
        // 添加实现的接口的包
        controllerClass.addImportedType(new FullyQualifiedJavaType("com.github.xiaoymin.knife4j.annotations.ApiOperationSupport"));
        controllerClass.addImportedType(new FullyQualifiedJavaType("com.paradise.core.common.api.CommonPage"));
        controllerClass.addImportedType(new FullyQualifiedJavaType("com.paradise.core.common.api.Result"));
        controllerClass.addImportedType(new FullyQualifiedJavaType("io.swagger.annotations.Api"));
        controllerClass.addImportedType(new FullyQualifiedJavaType("io.swagger.annotations.ApiOperation"));
        controllerClass.addImportedType(new FullyQualifiedJavaType("lombok.AllArgsConstructor"));
        controllerClass.addImportedType(new FullyQualifiedJavaType("org.springframework.web.bind.annotation.*"));
        controllerClass.addImportedType(new FullyQualifiedJavaType("org.springframework.validation.annotation.Validated"));
        controllerClass.addImportedType(new FullyQualifiedJavaType(generatorParam.getServiceImplPackage() + "." + generatorParam.getDomainObjectName() + "Service"));
        controllerClass.addImportedType(new FullyQualifiedJavaType(generatorParam.getModalFullName()));
        controllerClass.addImportedType(new FullyQualifiedJavaType(generatorParam.getQueryFullName()));
        controllerClass.addImportedType(new FullyQualifiedJavaType(generatorParam.getBodyFullName()));
        controllerClass.addImportedType(new FullyQualifiedJavaType("java.util.List"));
        GeneratedJavaFile controller = new GeneratedJavaFile(controllerClass, generatorParam.getTargetProject(), "UTF-8", getContext().getJavaFormatter());
        generatedJavaFiles.add(controller);
    }

    private void setControllerMethod(TopLevelClass controllerCompilationUnit, IntrospectedTable introspectedTable) {
        addSelectByPageMethod4Controller(controllerCompilationUnit, introspectedTable);
        addInsertMethod4Controller(controllerCompilationUnit, introspectedTable);
        addUpdateByPrimaryKeyMethod4Controller(controllerCompilationUnit, introspectedTable);
        addSelectByPrimaryKeyMethod4Controller(controllerCompilationUnit, introspectedTable);
        addDeleteByPrimaryKeyMethod4Controller(controllerCompilationUnit, introspectedTable);

//        addInsertSelectiveMethod4Controller(controllerCompilationUnit, introspectedTable);
//        addUpdateByPrimaryKeySelectiveMethod4Controller(controllerCompilationUnit, introspectedTable);
    }

    private void addSelectByPageMethod4Controller(TopLevelClass controllerCompilationUnit, IntrospectedTable introspectedTable) {
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();

        // @update 1.4.0
        Method method = new Method("selectByPage");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("Result<CommonPage<" + domainObjectName + ">>"));
        method.setName("selectByPage");

        // 添加方法参数
        // offsetParam
        Parameter queryParam = new Parameter(new FullyQualifiedJavaType(generatorParam.getQueryFullName()), "query");
        method.addParameter(queryParam);

        method.addAnnotation("@ApiOperationSupport(order = 1)");
        method.addAnnotation("@ApiOperation(value = \"分页查询\")");
        method.addAnnotation("@GetMapping(value = \"/s\")");

        method.addBodyLine("List<" + domainObjectName + "> list = this." + toLowerCaseFirstOne(domainObjectName)
                + "Service.selectByPage(" + getParameterStr(method) + ");");
        method.addBodyLine("return Result.success(CommonPage.restPage(list));");

        controllerCompilationUnit.addImportedTypes(Collections.singleton(queryParam.getType()));
        controllerCompilationUnit.addMethod(method);
        // @update 1.4.0
//        if (context.getPlugins().clientDeleteByPrimaryKeyMethodGenerated(
//                method, controllerCompilationUnit, introspectedTable)) {
//        }
    }

    private void addUpdateByPrimaryKeyMethod4Controller(TopLevelClass controllerCompilationUnit, IntrospectedTable introspectedTable) {
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        Method method = new Method(introspectedTable.getUpdateByPrimaryKeyStatementId());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("Result<Integer>"));
        method.setName(introspectedTable.getUpdateByPrimaryKeyStatementId());

        StringBuilder pathVar = addMethodParameter(introspectedTable, method);
        // 添加方法参数
        FullyQualifiedJavaType generatorParameterType = new FullyQualifiedJavaType(generatorParam.getBodyFullName());
        Parameter generatorParameter = new Parameter(generatorParameterType, "record");
        generatorParameter.addAnnotation("@RequestBody");
        generatorParameter.addAnnotation("@Validated");
        method.addParameter(generatorParameter);
        // 添加方法注解
        method.addAnnotation("@ApiOperationSupport(order = 3)");
        method.addAnnotation("@ApiOperation(\"修改\")");
        method.addAnnotation("@PutMapping(value = \"/" + pathVar.toString() + "\")");
        String sb = this.getParameterStr(method);
        method.addBodyLine("int count = this." + toLowerCaseFirstOne(domainObjectName) + "Service." + introspectedTable.getUpdateByPrimaryKeyStatementId() + "(" + sb + ");");
        method.addBodyLine("if (count > 0) {\n" +
                "            return Result.success(count);\n" +
                "        }\n" +
                "        return Result.failed();");

        controllerCompilationUnit.addMethod(method);
//        if (context.getPlugins().clientDeleteByPrimaryKeyMethodGenerated(method, controllerCompilationUnit, introspectedTable)) {
//        }
    }


    private void addSelectByPrimaryKeyMethod4Controller(TopLevelClass controllerCompilationUnit, IntrospectedTable introspectedTable) {
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        Method method = new Method(introspectedTable.getSelectByPrimaryKeyStatementId());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("Result<" + domainObjectName + ">"));
        method.setName(introspectedTable.getSelectByPrimaryKeyStatementId());
        StringBuilder pathVar = addMethodParameter(introspectedTable, method);
        // 添加方法注解
        method.addAnnotation("@ApiOperationSupport(order = 4)");
        method.addAnnotation("@ApiOperation(\"详情\")");
        method.addAnnotation("@GetMapping(value = \"/" + pathVar.toString() + "\")");
        String sb = getParameterStr(method);
        method.addBodyLine(domainObjectName + " " + toLowerCaseFirstOne(domainObjectName) + " = this." +
                toLowerCaseFirstOne(domainObjectName) + "Service." + introspectedTable.getSelectByPrimaryKeyStatementId() + "(" + sb + ");");
        method.addBodyLine("return Result.success(" + toLowerCaseFirstOne(domainObjectName) + ");");
        controllerCompilationUnit.addMethod(method);
//        if (context.getPlugins().clientDeleteByPrimaryKeyMethodGenerated(
//                method, controllerCompilationUnit, introspectedTable)) {
//        }
    }

    private void addInsertMethod4Controller(TopLevelClass controllerCompilationUnit, IntrospectedTable introspectedTable) {
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();

        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        Method method = new Method(introspectedTable.getInsertStatementId());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("Result<Integer>"));
        method.setName(introspectedTable.getInsertStatementId());

        // 添加方法参数
        FullyQualifiedJavaType generatorParameterType = new FullyQualifiedJavaType(generatorParam.getBodyFullName());
        importedTypes.add(generatorParameterType);
        Parameter generatorParameter = new Parameter(generatorParameterType, "record");
        generatorParameter.addAnnotation("@RequestBody");
        generatorParameter.addAnnotation("@Validated");
        method.addParameter(generatorParameter); //$NON-NLS-1$

        // 添加方法注解
        method.addAnnotation("@ApiOperationSupport(order = 2)");
        method.addAnnotation("@ApiOperation(\"添加\")");
        method.addAnnotation("@PostMapping");

        method.addBodyLine("int count = this." + toLowerCaseFirstOne(domainObjectName) + "Service." + introspectedTable.getInsertSelectiveStatementId() + "(record);");
        method.addBodyLine("if (count > 0) {");
        method.addBodyLine("return Result.success(count);");
        method.addBodyLine("}");
        method.addBodyLine("return Result.failed();");

        controllerCompilationUnit.addImportedTypes(importedTypes);
        controllerCompilationUnit.addMethod(method);
//        if (context.getPlugins().clientDeleteByPrimaryKeyMethodGenerated(
//                method, controllerCompilationUnit, introspectedTable)) {
//        }
    }

    private void addDeleteByPrimaryKeyMethod4Controller(TopLevelClass controllerCompilationUnit, IntrospectedTable introspectedTable) {
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();

        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        Method method = new Method(introspectedTable.getDeleteByPrimaryKeyStatementId());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("Result<Integer>"));
        method.setName(introspectedTable.getDeleteByPrimaryKeyStatementId());

        // 添加方法参数
        StringBuilder pathVar = addMethodParameter(introspectedTable, method);
        // 添加方法注解
        method.addAnnotation("@ApiOperationSupport(order = 5)");
        method.addAnnotation("@ApiOperation(\"删除\")");
        method.addAnnotation("@DeleteMapping(value = \"/" + pathVar.toString() + "\")");

        method.addBodyLine("int count = this." + toLowerCaseFirstOne(domainObjectName) + "Service."
                + introspectedTable.getDeleteByPrimaryKeyStatementId() + "(" + getParameterStr(method) + ");");
        method.addBodyLine("if (count > 0) {\n" +
                "            return Result.success(count);\n" +
                "        }");
        method.addBodyLine("return Result.failed();");

        controllerCompilationUnit.addImportedTypes(importedTypes);
        controllerCompilationUnit.addMethod(method);
//        if (context.getPlugins().clientDeleteByPrimaryKeyMethodGenerated(
//                method, controllerCompilationUnit, introspectedTable)) {
//        }
    }

    private StringBuilder addMethodParameter(IntrospectedTable introspectedTable, Method method) {
        StringBuilder pathVar = new StringBuilder();
        List<IntrospectedColumn> introspectedColumns = introspectedTable.getPrimaryKeyColumns();
        for (IntrospectedColumn introspectedColumn : introspectedColumns) {
            FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
            Parameter generatorParameter = new Parameter(type, introspectedColumn.getJavaProperty());
            generatorParameter.addAnnotation("@PathVariable(\"" + generatorParameter.getName() + "\")");
            pathVar.append("{").append(generatorParameter.getName()).append("}").append("/");
            method.addParameter(generatorParameter);
        }
        pathVar.delete(pathVar.lastIndexOf("/"), pathVar.length());
        return pathVar;
    }

    private void setControllerField(TopLevelClass controllerCompilationUnit, IntrospectedTable introspectedTable, String servicePackage) {
        // 实体类的类名
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        // 添加Service类
        Field serviceField = new Field(toLowerCaseFirstOne(domainObjectName) + "Service",
                new FullyQualifiedJavaType(domainObjectName + "Service"));
        serviceField.setName(toLowerCaseFirstOne(domainObjectName) + "Service");
        serviceField.setVisibility(JavaVisibility.PRIVATE);
        serviceField.setFinal(true);
        serviceField.setType(new FullyQualifiedJavaType(domainObjectName + "Service"));
        controllerCompilationUnit.addField(serviceField);
        controllerCompilationUnit.addImportedType(new FullyQualifiedJavaType(servicePackage + "." + domainObjectName + "Service"));
    }

    private void generateServiceFile(IntrospectedTable introspectedTable, List<GeneratedJavaFile> generatedJavaFiles) {
        // 生成ServiceImpl类
        generateServiceImplJavaFile(introspectedTable, generatedJavaFiles);
    }


    /**
     * 生成ServiceImpl,Service接口的实现类
     */
    private void generateServiceImplJavaFile(IntrospectedTable introspectedTable, List<GeneratedJavaFile> generatedJavaFiles) {
        // ServiceImpl类
        // typeName为类的全限定类名
        String typeName = generatorParam.getServiceImplPackage() + "." + generatorParam.getDomainObjectName() + "Service";
        // TopLevelClass类代表要生成的类,mybatis根据TopLevelClass类代表要生成一个类的field,method等
        TopLevelClass serviceClass = new TopLevelClass(typeName);
        // 增加类注释
        serviceClass.addJavaDocLine("/**\n" +
                " * " + introspectedTable.getRemarks() + "\n" +
                " *\n" +
                " * @author Paradise\n" +
                " */");
        serviceClass.setVisibility(JavaVisibility.PUBLIC);
        // 为类添加注解
        serviceClass.addAnnotation("@Slf4j");
        serviceClass.addAnnotation("@Service");
        serviceClass.addAnnotation("@AllArgsConstructor");
        // 为类添加Field
        setServiceImplField(serviceClass, introspectedTable);
        // 为类添加方法
        setServiceImplMethod(serviceClass, introspectedTable);

        serviceClass.addImportedType(new FullyQualifiedJavaType("com.github.pagehelper.PageHelper"));
        serviceClass.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Service"));
        serviceClass.addImportedType(new FullyQualifiedJavaType("lombok.AllArgsConstructor"));
        serviceClass.addImportedType(new FullyQualifiedJavaType(generatorParam.getModalFullName()));
        serviceClass.addImportedType(new FullyQualifiedJavaType(generatorParam.getQueryFullName()));
        serviceClass.addImportedType(new FullyQualifiedJavaType(generatorParam.getBodyFullName()));
        serviceClass.addImportedType(new FullyQualifiedJavaType(generatorParam.getExampleFullName()));
        serviceClass.addImportedType(new FullyQualifiedJavaType("org.springframework.beans.BeanUtils"));
        serviceClass.addImportedType(new FullyQualifiedJavaType("java.util.List"));
        serviceClass.addImportedType(new FullyQualifiedJavaType("lombok.extern.slf4j.Slf4j"));

        GeneratedJavaFile service = new GeneratedJavaFile(serviceClass, generatorParam.getTargetProject(), "UTF-8", getContext().getJavaFormatter());

        generatedJavaFiles.add(service);
    }

    /**
     * 为类添加Field
     */
    private void setServiceImplField(TopLevelClass serviceImplCompilationUnit, IntrospectedTable introspectedTable) {
        // 实体类的类名
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        // DAO类所在包的包名
        String daoTargetPackage = introspectedTable.getContext().getJavaClientGeneratorConfiguration().getTargetPackage();
        Field daoField = new Field(toLowerCaseFirstOne(domainObjectName) + "Mapper",
                new FullyQualifiedJavaType(domainObjectName + "Mapper"));
        // 设置Field的注解
        daoField.setVisibility(JavaVisibility.PRIVATE);
        daoField.setFinal(true);
        // 设置Field的类型
        daoField.setType(new FullyQualifiedJavaType(domainObjectName + "Mapper"));
        // 设置Field的名称
        daoField.setName(toLowerCaseFirstOne(domainObjectName) + "Mapper");
        // 将Field添加到对应的类中
        serviceImplCompilationUnit.addField(daoField);
        // 对应的类需要import DAO类(使用全限定类名)
        serviceImplCompilationUnit.addImportedType(new FullyQualifiedJavaType(daoTargetPackage + "." + domainObjectName + "Mapper"));
    }

    /**
     * 为类添加方法
     */
    private void setServiceImplMethod(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addDeleteByPrimaryKeyMethod4Impl(topLevelClass, introspectedTable);
        addInsertMethod4Impl(topLevelClass, introspectedTable);
        addInsertSelectiveMethod4Impl(topLevelClass, introspectedTable);
        addSelectByPrimaryKeyMethod4Impl(topLevelClass, introspectedTable);
        addUpdateByPrimaryKeySelectiveMethod4Impl(topLevelClass, introspectedTable);
        addUpdateByPrimaryKeyMethod4Impl(topLevelClass, introspectedTable);
        // 创建selectByPage方法,对应DAO中的selectByPage方法,与 https://github.com/linweiyu21/PaginationPlugin 插件配合时使用
        addSelectByPageMethod4Impl(topLevelClass, introspectedTable);
    }

    private void addSelectByPageMethod4Impl(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();

        Method method = new Method("selectByPage");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("List<" + domainObjectName + ">"));
        method.setName("selectByPage");
        Parameter queryParam = new Parameter(new FullyQualifiedJavaType(generatorParam.getQueryFullName()), "query");
        method.addParameter(queryParam);
        method.addBodyLine("PageHelper.startPage(query.getPageNum(), query.getPageSize());");
        String example = "new " + domainObjectName + "Example()";
        method.addBodyLine("return this." + toLowerCaseFirstOne(domainObjectName) + "Mapper.selectByExample(" + example + ");");

        topLevelClass.addImportedTypes(importedTypes);
        topLevelClass.addMethod(method);
//        if (context.getPlugins()
//                .clientUpdateByPrimaryKeySelectiveMethodGenerated(method,
//                        topLevelClass, introspectedTable)) {
//        }
    }

    private void addUpdateByPrimaryKeyMethod4Impl(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        FullyQualifiedJavaType generatorParameterType = new FullyQualifiedJavaType(generatorParam.getBodyFullName());
        importedTypes.add(generatorParameterType);
        Method method = new Method(introspectedTable.getUpdateByPrimaryKeyStatementId());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName(introspectedTable.getUpdateByPrimaryKeyStatementId());
        for (IntrospectedColumn primaryKeyColumn : introspectedTable.getPrimaryKeyColumns()) {
            method.addParameter(new Parameter(primaryKeyColumn.getFullyQualifiedJavaType(), primaryKeyColumn.getJavaProperty()));
        }
        method.addParameter(new Parameter(generatorParameterType, "record"));
        method.addBodyLine(domainObjectName + " " + toLowerCaseFirstOne(domainObjectName) + " = new " + domainObjectName + "();");
        method.addBodyLine("BeanUtils.copyProperties(record, " + toLowerCaseFirstOne(domainObjectName) + ");");
        method.addBodyLine(toLowerCaseFirstOne(domainObjectName) + ".setId(id);");
        method.addBodyLine("return this." + toLowerCaseFirstOne(domainObjectName) + "Mapper."
                + introspectedTable.getUpdateByPrimaryKeySelectiveStatementId() + "(" + toLowerCaseFirstOne(domainObjectName) + ");");

        topLevelClass.addImportedTypes(importedTypes);
        topLevelClass.addMethod(method);
//        if (context.getPlugins()
//                .clientUpdateByPrimaryKeySelectiveMethodGenerated(method,
//                        topLevelClass, introspectedTable)) {
//        }
    }

    private void addUpdateByPrimaryKeySelectiveMethod4Impl(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType generatorParameterType = new FullyQualifiedJavaType(generatorParam.getBodyFullName());
        Method method = new Method(introspectedTable.getUpdateByPrimaryKeySelectiveStatementId());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName(introspectedTable.getUpdateByPrimaryKeySelectiveStatementId());
        method.addParameter(new Parameter(generatorParameterType, "record"));
        String domainObjectName = generatorParam.getDomainObjectName();
        method.addBodyLine(domainObjectName + " " + toLowerCaseFirstOne(domainObjectName) + " = new " + domainObjectName + "();");
        method.addBodyLine("BeanUtils.copyProperties(record, " + toLowerCaseFirstOne(domainObjectName) + ");");
        method.addBodyLine("return this." + toLowerCaseFirstOne(domainObjectName) + "Mapper."
                + introspectedTable.getUpdateByPrimaryKeySelectiveStatementId() + "(" + toLowerCaseFirstOne(domainObjectName) + ");");

        topLevelClass.addImportedTypes(Collections.singleton(generatorParameterType));
        topLevelClass.addMethod(method);
//        if (context.getPlugins().clientUpdateByPrimaryKeySelectiveMethodGenerated(method,
//                topLevelClass, introspectedTable)) {
//        }
    }

    private void addSelectByPrimaryKeyMethod4Impl(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        Method method = new Method(introspectedTable.getSelectByPrimaryKeyStatementId());
        method.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType returnType = introspectedTable.getRules().calculateAllFieldsClass();
        method.setReturnType(returnType);
        importedTypes.add(returnType);
        method.setName(introspectedTable.getSelectByPrimaryKeyStatementId());
        // 遍历主键 作为参数
        for (IntrospectedColumn introspectedColumn : introspectedTable.getPrimaryKeyColumns()) {
            FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
            method.addParameter(new Parameter(type, introspectedColumn.getJavaProperty()));
            importedTypes.add(type);
        }
        method.addBodyLine("return this." + toLowerCaseFirstOne(domainObjectName) + "Mapper."
                + introspectedTable.getSelectByPrimaryKeyStatementId() + "(" + getParameterStr(method) + ");");

        topLevelClass.addImportedTypes(importedTypes);
        topLevelClass.addMethod(method);
//        if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, topLevelClass, introspectedTable)) {
//        }
    }

    private void addInsertSelectiveMethod4Impl(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        Method method = new Method(introspectedTable.getInsertSelectiveStatementId());
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName(introspectedTable.getInsertSelectiveStatementId());
        FullyQualifiedJavaType generatorParameterType = new FullyQualifiedJavaType(generatorParam.getBodyFullName());
        method.addParameter(new Parameter(generatorParameterType, "record"));
        method.addBodyLine(domainObjectName + " " + toLowerCaseFirstOne(domainObjectName) + " = new " + domainObjectName + "();");
        method.addBodyLine("BeanUtils.copyProperties(record, " + toLowerCaseFirstOne(domainObjectName) + ");");
        method.addBodyLine("return this." + toLowerCaseFirstOne(domainObjectName) + "Mapper."
                + introspectedTable.getInsertSelectiveStatementId() + "(" + toLowerCaseFirstOne(domainObjectName) + ");");
        topLevelClass.addMethod(method);

//        if (context.getPlugins().clientInsertSelectiveMethodGenerated(method, topLevelClass, introspectedTable)) {
//        }
    }

    private void addInsertMethod4Impl(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();

        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        Method method = new Method(introspectedTable.getInsertStatementId());

        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName(introspectedTable.getInsertStatementId());

        FullyQualifiedJavaType generatorParameterType = new FullyQualifiedJavaType(generatorParam.getBodyFullName());
        importedTypes.add(generatorParameterType);
        method.addParameter(new Parameter(generatorParameterType, "record"));

        method.addBodyLine(domainObjectName + " " + toLowerCaseFirstOne(domainObjectName) + " = new " + domainObjectName + "();");
        method.addBodyLine("BeanUtils.copyProperties(record, " + toLowerCaseFirstOne(domainObjectName) + ");");
        method.addBodyLine("return this." + toLowerCaseFirstOne(domainObjectName) + "Mapper."
                + introspectedTable.getInsertStatementId() + "(" + toLowerCaseFirstOne(domainObjectName) + ");");

        topLevelClass.addImportedTypes(importedTypes);
        topLevelClass.addMethod(method);
//        if (context.getPlugins().clientInsertMethodGenerated(method, topLevelClass,
//                introspectedTable)) {
//        }
    }

    public void addDeleteByPrimaryKeyMethod4Impl(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String domainObjectName = introspectedTable.getTableConfiguration().getDomainObjectName();
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<>();
        Method method = new Method(introspectedTable.getDeleteByPrimaryKeyStatementId());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName(introspectedTable.getDeleteByPrimaryKeyStatementId());
        List<IntrospectedColumn> introspectedColumns = introspectedTable.getPrimaryKeyColumns();
        for (IntrospectedColumn introspectedColumn : introspectedColumns) {
            FullyQualifiedJavaType type = introspectedColumn
                    .getFullyQualifiedJavaType();
            importedTypes.add(type);
            Parameter generatorParameter = new Parameter(type, introspectedColumn
                    .getJavaProperty());
            method.addParameter(generatorParameter);
        }
        String sb = getParameterStr(method);
        method.addBodyLine("return this." + toLowerCaseFirstOne(domainObjectName) + "Mapper." + introspectedTable.getDeleteByPrimaryKeyStatementId() + "(" + sb + ");");

        topLevelClass.addImportedTypes(importedTypes);
        topLevelClass.addMethod(method);
//        if (context.getPlugins().clientDeleteByPrimaryKeyMethodGenerated(
//                method, topLevelClass, introspectedTable)) {
//        }
    }

    private String getParameterStr(Method method) {
        List<Parameter> generatorParameters = method.getParameters();
        StringBuilder sb = new StringBuilder();
        for (Parameter generatorParameter : generatorParameters) {
            sb.append(generatorParameter.getName());
            sb.append(",");
        }
        sb.delete(sb.lastIndexOf(","), sb.length());
        return sb.toString();
    }

    private static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return Character.toLowerCase(s.charAt(0)) + s.substring(1);
        }
    }


}
