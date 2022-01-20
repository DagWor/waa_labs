package edu.miu.lab.exception;

public class BookNotFoundException extends Exception {
    private String errorMessage;

    public BookNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
