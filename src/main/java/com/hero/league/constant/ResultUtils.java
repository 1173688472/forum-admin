package com.hero.league.constant;

/**
 * @author: shayu
 * @date: 2022/10/14/ 11:18
 * @ClassName: BaseResponse
 * @Description:    返回工具类
 */

public class ResultUtils {

    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败
     * @param codeEnums
     * @return
     */
    public static BaseResponse error(CodeEnums codeEnums) {
        return new BaseResponse<>(codeEnums);
    }

    /**
     * 失败
     *
     * @param message
     * @param description
     * @return
     */
    public static BaseResponse error(int code, String message, String description) {
        return new BaseResponse(code, null, message, description);
    }

    /**
     * 失败
     * @param codeEnums
     * @return
     */
    public static BaseResponse error(CodeEnums codeEnums, String message, String description) {
        return new BaseResponse(codeEnums.getCode(), null, message, description);
    }

    /**
     * 失败
     * @param codeEnums
     * @return
     */
    public static BaseResponse error(CodeEnums codeEnums, String description) {
        return new BaseResponse(codeEnums.getCode(), codeEnums.getMessage(), description);
    }
}
