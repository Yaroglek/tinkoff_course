package edu.hw2.Task3;

public class ConnectionException extends RuntimeException {
    private final int code;
    private final String errorMessage;

    public ConnectionException(int code, String message) {
        this.code = code;
        this.errorMessage = message;
    }

    public String getMessage() {
        return "Error message:" + " " + errorMessage + ". " + "Code:" + " " + code;
    }
}
