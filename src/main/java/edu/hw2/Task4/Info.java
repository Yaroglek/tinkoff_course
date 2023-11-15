package edu.hw2.Task4;

public class Info {
    private Info() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement callingMethodStackTraceElement = stackTrace[0];

        String className = callingMethodStackTraceElement.getClassName();
        String methodName = callingMethodStackTraceElement.getMethodName();

        return new CallingInfo(className, methodName);
    }
}
