package com.hero.league.constant;

import java.io.Serializable;

/**
 * @author: shayu
 * @date: 2022/10/14/ 11:18
 * @ClassName: BaseResponse
 * @Description:    通用返回类
 */

public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    private String description;

    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data, String message) {
        this(code, data, message, "");
    }

    public BaseResponse(int code, T data) {
        this(code, data, "", "");
    }

    public BaseResponse(CodeEnums codeEnums) {
        this(codeEnums.getCode(), null, codeEnums.getMessage(), codeEnums.getDescription());
    }

}
