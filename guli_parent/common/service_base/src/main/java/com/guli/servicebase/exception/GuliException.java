package com.guli.servicebase.exception;

import lombok.Data;

/**
 * @author zzy
 * @description: 自定义异常
 * @date 2023/11/27 20:24
 */
@Data
public class GuliException extends RuntimeException{
    private Integer code; //状态码
    private String msg; //异常信息
}
