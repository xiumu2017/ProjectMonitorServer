package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 每日bing壁纸查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "每日bing壁纸查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class DayBingImageQuery extends BaseQuery {
    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String url;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 英文标题
     */
    @ApiModelProperty(value = "英文标题")
    private String titleEn;

    /**
     * 作者
     */
    @ApiModelProperty(value = "作者")
    private String author;
}