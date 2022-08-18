//package com.example.springboot_api_sample.exceptionhandle;
//
//import com.example.springboot_api_sample.responseobject.ResponseObject;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestControllerAdvice
//public class ExceptionHandel {
////    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> exceptionHandle(MethodArgumentNotValidException ex) {
//        Map<String, String> errorHandle = new HashMap<>();
//
//        ResponseObject responseObject= new ResponseObject(new Date(),"User is already exist", "fail", "");
//        List<FieldError> list = ex.getBindingResult().getFieldErrors();
//        for (FieldError FieldError : list) {
//            errorHandle.put(FieldError.getField(), FieldError.getDefaultMessage());
//
//        }
//        String message=errorHandle.toString();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject(new Date(),message, "fail", ""));
//
//    }
//}
