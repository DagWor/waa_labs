package edu.miu.lab.exception;

public class AccountNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccountNotFoundException() {
        super();
    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}
