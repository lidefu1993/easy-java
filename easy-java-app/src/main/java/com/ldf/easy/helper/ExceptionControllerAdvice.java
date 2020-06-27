package com.ldf.easy.helper;

import com.ldf.easy.domain.APIException;
import com.ldf.easy.domain.ResultVO;
import com.ldf.easy.domain.enums.ResultCode;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.xml.transform.Result;

/**
 * @author ldf
 * @date 2020/6/27 18:52
 **/
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return resultVO(objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public ResultVO apiExceptionHandler(APIException e) {
        return resultVO(e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO defaultExceptionHandler(Exception e) {
        return resultVO(ResultCode.ERROR.getMsg());
    }

    @ExceptionHandler(ValidationException.class)
    public ResultVO validExceptionHandler(ValidationException e) {
        return resultVO(e.getLocalizedMessage());
    }

    @ExceptionHandler(BindException.class)
    public ResultVO bindExceptionHandler(BindException e) {
        return resultVO(e.getAllErrors().get(0).getDefaultMessage());
    }

    private ResultVO resultVO(String msg){
        return ResultVO.fail(msg);
    }

}
