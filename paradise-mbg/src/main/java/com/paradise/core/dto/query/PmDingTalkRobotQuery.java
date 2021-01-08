package com.paradise.core.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 钉钉群组管理查询参数
 *
 * @author Paradise
 */
@ApiModel(value = "钉钉群组管理查询参数")
@Data
@EqualsAndHashCode(callSuper = true)
public class PmDingTalkRobotQuery extends BaseQuery {
    /**
     * 钉钉群组ID
     */
    @ApiModelProperty(value = "钉钉群组ID")
    private Long groupId;

    /**
     * 钉钉群组机器人名称
     */
    @ApiModelProperty(value = "钉钉群组机器人名称")
    private String name;

    /**
     * 钉钉群组机器人类别
     */
    @ApiModelProperty(value = "钉钉群组机器人类别")
    private String type;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    private Integer enable;
}