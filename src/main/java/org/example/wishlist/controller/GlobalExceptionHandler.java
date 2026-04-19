package org.example.wishlist.controller;

import org.example.wishlist.exception.*;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthenticatedException.class)
    public String handleUnauthorized() {
        return "redirect:/login";
    }

    @ExceptionHandler(InvalidInputException.class)
    public String handleInvalidInput() {
        return "error/400";
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public String handleInvalidCredentials() {
        return "error/401";
    }

    @ExceptionHandler(ForbiddenAccessException.class)
    public String handleForbidden() {
        return "error/403";
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String handleUserNotFound() {
        return "error/404";
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public String handleUserAlreadyExists() {
        return "error/409";
    }

    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseError() {
        return "error/500";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleGenericError() {
        return "error/500";
    }
}