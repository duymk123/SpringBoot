package com.example.duy_backend.exception;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(  //Exception Valid
                                                                    MethodArgumentNotValidException ex,
                                                                    HttpHeaders headers,
                                                                    HttpStatusCode status,
                                                                    WebRequest request) {

        String message = ex.getBindingResult().getFieldError().getDefaultMessage();

        int code = 400;

        ErrorResponse errorResponse = new ErrorResponse(message, code);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    //exception goi sai API
//    @Override
//    protected ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException ex,
//                                                                    HttpHeaders headers,
//                                                                    HttpStatusCode status,
//                                                                    WebRequest request) {
//
//        String message = ("Đường dẫn không tồn tại");
//        int code = 404;
//
//        ErrorResponse errorResponse = new ErrorResponse(message, code);
//
//        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(Exception.class) // cac loi con lai
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception exception) {
        String message = "Loi he thong, vui long thu lai sau";
        int code = 500;
        ErrorResponse errorResponse = new ErrorResponse(message, code);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //defind ham NOTFOUND
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException exception) {

        String message = exception.getMessage();
        int code = exception.getStatus().value();

        ErrorResponse errorResponse = new ErrorResponse(message, code);

        return ResponseEntity.status(exception.getStatus()).body(errorResponse);
    }
}
