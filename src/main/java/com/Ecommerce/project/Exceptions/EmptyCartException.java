// EmptyCartException.java
package com.Ecommerce.project.Exceptions;

public class EmptyCartException extends RuntimeException {

    public EmptyCartException(String message) {
        super(message);
    }
}