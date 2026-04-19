package org.example.wishlist.exception;

public class UnauthenticatedException extends UserServiceException {
    public UnauthenticatedException(String message) {
        super(message);
    }
}