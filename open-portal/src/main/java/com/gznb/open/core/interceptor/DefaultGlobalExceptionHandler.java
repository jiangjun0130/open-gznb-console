package com.gznb.open.core.interceptor;

import com.gznb.open.domain.manual.DataCenter;
import com.gznb.open.common.alert.ExceptionPoolExecutorUtils;
import com.gznb.open.common.constants.Constants;
import com.gznb.open.common.exception.SystemErrorException;
import com.gznb.open.common.exception.SystemWarnException;
import com.gznb.open.common.support.ThreadPoolExecutorSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * <p>
 * Created by jj02 on 2017/3/8.
 */
@ControllerAdvice
public class DefaultGlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(DefaultGlobalExceptionHandler.class);

    @Autowired
    private ExceptionPoolExecutorUtils exceptionPoolAExecutor;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public DataCenter handle(Exception exception) {
        DataCenter responseData = new DataCenter();
        if (exception instanceof SystemErrorException) {
            // 系统严重异常
            SystemErrorException errorException = (SystemErrorException) exception;
            logger.error("系统发生严重异常！异常类：[" + errorException.toString() +"], 异常信息:"+ exception.getCause());
            // 创建线程异步，异常池处理逻辑
            ThreadPoolExecutorSingleton.getInstance().execute(()->{
                exceptionPoolAExecutor.push2ExceptionMap(errorException);
            });
            responseData.setFlag(Constants.EXECUTE_ERROR);
            responseData.setMessage(errorException.getErrorMsg());
            return responseData;
        } else if (exception instanceof SystemWarnException) {
            // 业务异常
            SystemWarnException warnException = (SystemWarnException) exception;
            logger.error("系统发生异常！异常类：[" + warnException.toString() +"], 异常信息:"+ exception.getCause());
        }else {
            // 其余类型异常
            logger.error("系统发生未知类型异常！异常类：[{}], 异常信息:{}", exception.getClass(), exception);
        }
        responseData.setFlag(Constants.EXECUTE_ERROR);
        responseData.setMessage("系统异常！");
        return responseData;
    }
}
