package com.example.dsz.handler;

import com.example.dsz.base.SkadiResult;
import com.example.dsz.enums.GlobalExceptionCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;


/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/1 13:18
 * @Description: 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({GlobalException.class})
    public SkadiResult<Object> handleException(GlobalException exception) {
        exception.printStackTrace();
        return response(exception);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public SkadiResult<Object> validationBodyException(MethodArgumentNotValidException exception){
        exception.printStackTrace();
        BindingResult bindingResult = exception.getBindingResult();
        return responseValidate(GlobalExceptionCodeEnum.PARAMS_VALIDATED_CODE.getCode(),getBindingResult(bindingResult));
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public SkadiResult<Object> validationBodyException(BindException exception){
        exception.printStackTrace();
        BindingResult bindingResult = exception.getBindingResult();
        return responseValidate(GlobalExceptionCodeEnum.PARAMS_VALIDATED_CODE.getCode(),getBindingResult(bindingResult));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public SkadiResult<Object> handleServiceException(ConstraintViolationException e) {
        e.printStackTrace();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        return  responseValidate(GlobalExceptionCodeEnum.PARAMS_VALIDATED_CODE.getCode(),message);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public SkadiResult<Object> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        e.printStackTrace();
        MissingServletRequestParameterException ex = (MissingServletRequestParameterException)e;
        return  responseValidate(GlobalExceptionCodeEnum.PARAMS_VALIDATED_CODE.getCode(),ex.getParameterName() + "不能为空！");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public SkadiResult<Object> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        e.printStackTrace();
        return  responseValidate(GlobalExceptionCodeEnum.PARAMS_VALIDATED_CODE.getCode(),"不能用" + request.getMethod() + "方式请求，请检查接口具体请求方式post?get?put?delete? or others");
    }

    private SkadiResult<Object> response(GlobalException exceptionEnum) {
        return  responseValidate(exceptionEnum.getGlobalExceptionCodeEnum().getCode(),exceptionEnum.getGlobalExceptionCodeEnum().getMsg());
    }

    private SkadiResult<Object> responseValidate(Integer code, String msg) {
        return SkadiResult.builder().code(code).msg(msg).build();
    }

    private String getBindingResult(BindingResult bindingResult){
        List<ObjectError> list = bindingResult.getAllErrors();
        return CollectionUtils.isEmpty(list) ? "" : list.get(0).getDefaultMessage().toString();
    }
}
