package com.nikfce.wht.work.hard.tool.dto;

import com.nikfce.wht.work.hard.tool.constant.ResponseCode;
import lombok.Data;

/**
 * @author shenzhencheng 2022/9/23
 */
@Data
public class CommonResponse<T> {

    private int code;
    private String msg;
    private T data;
    private boolean success;

    public static <T> CommonResponse<T> ofFailed(String msg) {
        return ofFailed(msg, ResponseCode.FAILED);
    }

    public static <T> CommonResponse<T> ofFailed(String msg, int code) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setSuccess(false);
        return response;
    }

    public static <T> CommonResponse<T> ofSuccess(T data) {
        CommonResponse<T> response = new CommonResponse<>();
        response.setSuccess(true);
        response.setCode(ResponseCode.SUCCESS);
        response.setData(data);
        return response;
    }

}
