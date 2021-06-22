package com.qidaiai.domain;

import com.qidaiai.hiscommons.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
    * 操作日志记录
    */
@ApiModel(value="com-qidaiai-domain-OperLog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OperLog extends BaseDto {
    /**
    * 日志主键
    */
    @ApiModelProperty(value="日志主键")
    private Long operId;

    /**
    * 模块标题
    */
    @ApiModelProperty(value="模块标题")
    private String title;

    /**
    * 业务类型（0其它 1新增 2修改 3删除）
    */
    @ApiModelProperty(value="业务类型（0其它 1新增 2修改 3删除）")
    private String businessType;

    /**
    * 方法名称
    */
    @ApiModelProperty(value="方法名称")
    private String method;

    /**
    * 请求方式
    */
    @ApiModelProperty(value="请求方式")
    private String requestMethod;

    /**
    * 操作类别（0其它 1后台用户 2手机端用户）
    */
    @ApiModelProperty(value="操作类别（0其它 1后台用户 2手机端用户）")
    private Integer operatorType;

    /**
    * 操作人员
    */
    @ApiModelProperty(value="操作人员")
    private String operName;

    /**
    * 请求URL
    */
    @ApiModelProperty(value="请求URL")
    private String operUrl;

    /**
    * 主机地址
    */
    @ApiModelProperty(value="主机地址")
    private String operIp;

    /**
    * 操作地点
    */
    @ApiModelProperty(value="操作地点")
    private String operLocation;

    /**
    * 请求参数
    */
    @ApiModelProperty(value="请求参数")
    private String operParam;

    /**
    * 返回参数
    */
    @ApiModelProperty(value="返回参数")
    private String jsonResult;

    /**
    * 操作状态（0成功1失败）
    */
    @ApiModelProperty(value="操作状态（0成功1失败）")
    private String status;

    /**
    * 错误消息
    */
    @ApiModelProperty(value="错误消息")
    private String errorMsg;

    /**
    * 操作时间
    */
    @ApiModelProperty(value="操作时间")
    private Date operTime;

    public static final String COL_OPER_ID = "oper_id";

    public static final String COL_TITLE = "title";

    public static final String COL_BUSINESS_TYPE = "business_type";

    public static final String COL_METHOD = "method";

    public static final String COL_REQUEST_METHOD = "request_method";

    public static final String COL_OPERATOR_TYPE = "operator_type";

    public static final String COL_OPER_NAME = "oper_name";

    public static final String COL_OPER_URL = "oper_url";

    public static final String COL_OPER_IP = "oper_ip";

    public static final String COL_OPER_LOCATION = "oper_location";

    public static final String COL_OPER_PARAM = "oper_param";

    public static final String COL_JSON_RESULT = "json_result";

    public static final String COL_STATUS = "status";

    public static final String COL_ERROR_MSG = "error_msg";

    public static final String COL_OPER_TIME = "oper_time";
}