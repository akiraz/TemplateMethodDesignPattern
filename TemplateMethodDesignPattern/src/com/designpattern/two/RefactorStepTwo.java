package com.designpattern.two;

abstract class MyLogger {
    public String serializeObject(Object log) {
        System.out.println("Serializing log object");
        return log.toString();
    }
    public final void log(Object log) {
        String logText = serializeObject(log);
        openDataSource();
        insertLog(logText);
        closeDataSource();
    }
    public abstract void openDataSource();
    public abstract void closeDataSource();
    public abstract void insertLog(String log);
}
public class RefactorStepTwo {
    public static void main(String[] args) {
        DatabaseLogger databaseLogger = new DatabaseLogger();
        databaseLogger.log("Some Logs");
        FileLogger fileLogger = new FileLogger();
        fileLogger.log("Some Logs");
    }
}
class DatabaseLogger extends MyLogger {
    public void openDataSource() {
        System.out.println("Connecting to db");
    }
    public void insertLog(String message) {
        System.out.println("Inserting logs to db = " + message);
    }
    public void closeDataSource() {
        System.out.println("Closing db connection");
    }
}
class FileLogger extends MyLogger {
    public void openDataSource() {
        System.out.println("Opening file");
    }
    public void insertLog(String message) {
        System.out.println("Inserting logs to file = " + message);
    }
    public void closeDataSource() {
        System.out.println("Closing file");
    }
}