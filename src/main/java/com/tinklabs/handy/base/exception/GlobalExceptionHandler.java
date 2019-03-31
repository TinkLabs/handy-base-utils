package com.tinklabs.handy.base.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tinklabs.handy.base.vo.ResultVO;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
    @ExceptionHandler(value = AuthenticationException.class)
    public ResultVO authExceptionHandler(Exception e) throws Exception {
    	logger.error("UNKNOW_EXCEPTION: " + e.getMessage());
        return ResultVO.fail(BaseErrors.AUTHENTICATION_EXCEPTION);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResultVO businessExceptionHandler(BusinessException e)
            throws Exception {
    	logger.error("BusinessException: " + e.getMessage());
        return ResultVO.fail(e.getError());
    }

    @ExceptionHandler(value = SystemException.class)
    public ResultVO systemExceptionHandler(SystemException e)
            throws Exception {
        logger.error("SystemException: " + e.getMessage());
        return ResultVO.fail(BaseErrors.SYSTEM_EXCEPTION);
    }

    @ExceptionHandler(value = Exception.class)
    public ResultVO exceptionHandler(Exception e) throws Exception {
    	logger.error("UNKNOW_EXCEPTION: " + e.getMessage());
        return ResultVO.fail(BaseErrors.UNKNOW_EXCEPTION);
    }
    
}
