package org.example.wishlist.exception;

public class UserAlreadyExistsException extends UserServiceException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
