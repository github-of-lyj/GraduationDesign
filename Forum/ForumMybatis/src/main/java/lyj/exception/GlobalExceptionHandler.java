package lyj.exception;

import common.BaseResponse;
import common.BusinessException;
import common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("businessException: " + e.getMessage() + ":" + e.getDescription());
        return ResultUtils.error(e.getCode(), e.getMessage(), e.getDescription());
    }
}