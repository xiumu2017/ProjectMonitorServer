package com.paradise.core.dto.body;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
     * 英文标题
     */
    @ApiModelProperty(value = "英文标题", required = true, example = "null")
    @NotEmpty(message = "英文标题不能为空!")
    private String titleEn;

    /**
     * 作者
     */
    @ApiModelProperty(value = "作者", required = true, example = "null")
    @NotEmpty(message = "作者不能为空!")
    private String author;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期", required = true, example = "null")
    @NotNull(message = "日期不能为空!")
    private java.util.Date date;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true, example = "null")
    @NotNull(message = "创建时间不能为空!")
    private java.util.Date createTime;
}