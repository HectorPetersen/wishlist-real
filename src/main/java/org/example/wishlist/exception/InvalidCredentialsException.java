package org.example.wishlist.exception;

public class InvalidCredentialsException extends UserServiceException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}