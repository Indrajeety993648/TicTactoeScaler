package org.buildproduct.tictactoe.exception;

public class InvalidGameException extends RuntimeException{
    public InvalidGameException(String message) {
        super(message);
    }
}
