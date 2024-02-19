package common;

/**
 * 返回对象工具类
 */
public class ResultUtils {


    /**
     * 成功
     * @param data  返回数据对象
     * @param <T>   返回数据对象泛型（这里指代数据对象的类型）
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败
     * @param errorCode 自定义错误码枚举类
     */
    public static BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    /**
     * 失败
     * @param code 错误代码
     * @param message 错误信息
     * @param description 错误描述
     */
    public static BaseResponse error(int code, String message, String description) {
        return new BaseResponse(code, null, message, description);
    }

    /**
     * 失败
     * @param errorCode 错误代码
     */
    public static BaseResponse error(ErrorCode errorCode, String message, String description) {
        return new BaseResponse(errorCode.getCode(), null, message, description);
    }


    /**
     * 失败
     * @param errorCode 错误代码
     */
    public static BaseResponse error(ErrorCode errorCode, String description) {
        return new BaseResponse(errorCode.getCode(), "",errorCode.getMessage(), description);
    }
}
