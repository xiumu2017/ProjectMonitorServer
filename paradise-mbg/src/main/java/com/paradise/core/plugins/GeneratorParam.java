package com.paradise.core.plugins;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class GeneratorParam {
    private String domainObjectName;
    private String modalFullName;
    private String queryFullName;
    private String bodyFullName;
    private String exampleFullName;
    private String targetProject;
    private String servicePackage;
    private String serviceImplPackage;
    private String webPackage;
}