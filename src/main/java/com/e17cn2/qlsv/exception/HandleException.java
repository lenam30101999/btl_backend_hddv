package com.e17cn2.qlsv.exception;

import com.e17cn2.qlsv.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<?> unauthorizedException(UnAuthorizedException ex, WebRequest webRequest){
        BaseResponse baseResponse = new BaseResponse(
                null, ex.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                ((ServletWebRequest) webRequest).getRequest().getServletPath());
        return new ResponseEntity<>(baseResponse, HttpStatus.UNAUTHORIZED);
    }
}
