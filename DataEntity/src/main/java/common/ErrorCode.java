package common;

/*
 * @author 林英杰
 * @since JDK 版本 17
 * @enum 错误码
 */
public enum ErrorCode {

    SUCCESS(0, "ok", ""),
    PARAMS_ERROR(601, "请求参数错误", ""),
    USER_ERROR(602, "用户状态异常", ""),
    NOT_LOGIN(603, "未登录", ""),
    NO_AUTH(604, "无权限", "");

    //状态码
    private final int code;

    //状态码信息
    private final String message;

    //状态码描述
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
