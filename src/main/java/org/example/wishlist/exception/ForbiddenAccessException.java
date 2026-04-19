package org.example.wishlist.exception;

public class ForbiddenAccessException extends UserServiceException {
    public ForbiddenAccessException(String message) {
        super(message);
    }
}
