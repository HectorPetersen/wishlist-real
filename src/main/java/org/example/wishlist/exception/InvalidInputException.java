package org.example.wishlist.exception;

public class InvalidInputException extends UserServiceException {
    public InvalidInputException(String message) {
        super(message);
    }
}
