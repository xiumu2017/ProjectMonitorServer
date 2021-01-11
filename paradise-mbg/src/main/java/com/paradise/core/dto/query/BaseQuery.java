package com.paradise.core.dto.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 基础查询参数
 *
 * @author Paradise
 */
@Getter
@Setter
public class BaseQuery {
    @ApiModelProperty(value = "分页参数", required = true, example = "1")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "分页参数", required = true, example = "10")
    private Integer pageSize = 10;
    @ApiModelProperty("是否启用")
    private Integer enable;

    @ApiModelProperty("查询开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @ApiModelProperty("查询结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
