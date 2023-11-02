package edu.project1;

public class GuessingException extends Exception {
    private final String errorMessage;

    public GuessingException(String message) {
        this.errorMessage = message;
    }

    public String getMessage() {
        return "Error message:" + " " + errorMessage + ".";
    }
}
