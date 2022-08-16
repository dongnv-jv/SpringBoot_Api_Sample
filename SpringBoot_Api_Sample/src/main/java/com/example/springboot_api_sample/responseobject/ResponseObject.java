package com.example.springboot_api_sample.responseobject;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseObject {
    private String message;
    private String status;
    private Object data;

}
