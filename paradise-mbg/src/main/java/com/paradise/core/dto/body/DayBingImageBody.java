package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 每日bing壁纸Body
 *
 * @author Paradise
 */
@ApiModel(value = "每日bing壁纸Body")
@Data
public class DayBingImageBody {
    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址", required = true, example = "null")
    @NotEmpty(message = "图片地址不能为空!")
    private String url;

    /**
     * 版权信息
     */
    @ApiModelProperty(value = "版权信息", required = true, example = "null")
    @NotEmpty(message = "版权信息不能为空!")
    private String copyright;

    /**
     * 版权链接
     */
    @ApiModelProperty(value = "版权链接", required = true, example = "null")
    @NotEmpty(message = "版权链接不能为空!")
    private String copyrightLink;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题", required = true, example = "null")
    @NotEmpty(message = "标题不能为空!")
    private String title;

    /**
     * 作者
     */
    @ApiModelProperty(value = "作者", required = true, example = "null")
    @NotEmpty(message = "作者不能为空!")
    private String author;
}