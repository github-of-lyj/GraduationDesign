package lyj.exception;

import common.BaseResponse;
import common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import lyj.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("businessException: " + e.getMessage() + ":" + e.getDescription());
        return ResultUtils.error(e.getCode(), e.getMessage(), e.getDescription());
    }

}
