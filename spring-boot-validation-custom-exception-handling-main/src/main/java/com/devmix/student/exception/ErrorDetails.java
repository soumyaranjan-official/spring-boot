package com.devmix.student.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ErrorDetails {


    private int statusCode;
    private LocalDateTime timeStamp;
    private String errMessage;
    private String status;


}
