// UserAlreadyExistsException.java
package com.Ecommerce.project.Exceptions;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}