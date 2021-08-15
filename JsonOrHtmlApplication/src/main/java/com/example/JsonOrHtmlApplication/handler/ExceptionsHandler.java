package com.example.JsonOrHtmlApplication.handler;

import com.example.JsonOrHtmlApplication.exception.PageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler
    public ModelAndView notFoundExceptionHandler(PageNotFoundException exception) {
        return new ModelAndView("not_found", HttpStatus.NOT_FOUND);
    }
}
