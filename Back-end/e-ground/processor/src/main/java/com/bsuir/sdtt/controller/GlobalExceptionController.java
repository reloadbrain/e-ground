package com.bsuir.sdtt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class GlobalExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    private String handleException(Exception exception) {
        StringBuilder message = new StringBuilder("ERROR: ");
        message.append(exception.getMessage());

        log.error("ERROR: ", exception);

        return message.toString();
    }
}
