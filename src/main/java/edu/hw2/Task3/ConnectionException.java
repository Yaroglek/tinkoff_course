package edu.hw2.Task3;

public class ConnectionException extends RuntimeException {
    private final int code;
    private final String errorMessage;

    public ConnectionException(int code, String message) {
        super("Exception: " + message + ". Code: " + code);
        this.code = code;
        this.errorMessage = message;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
