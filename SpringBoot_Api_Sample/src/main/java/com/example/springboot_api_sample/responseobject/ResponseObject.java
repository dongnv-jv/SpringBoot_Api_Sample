package com.example.springboot_api_sample.responseobject;

//import com.example.springboot_api_sample.exceptionhandle.ExceptionHandel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ResponseObject {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private String message;
    private String status;
    private Object data;


}
