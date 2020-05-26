package com.designpattern.one;

abstract class MyLogger {
    public String serializeObject(Object message) {
        System.out.println("Serializing log object");
        return message.toString();
    }
}
public class RefactorStepOne {
    public static void main(String[] args) {
        DatabaseLogger databaseLogger = new DatabaseLogger();
        databaseLogger.log("Logs");
        FileLogger fileLogger = new FileLogger();
        fileLogger.log("Logs");
    }
}
class DatabaseLogger extends MyLogger {
    public void log(String message) {
        String messageTolog = serializeObject(message);
        openConnection();
        insertlogToDb(messageTolog);
        closeConnection();
    }
    private void openConnection() {
        System.out.println("Connecting to db");
    }
    private void insertlogToDb(String message) {
        System.out.println("Inserting logs to db = " + message);
    }
    private void closeConnection() {
        System.out.println("Close db connection");
    }
}
class FileLogger extends MyLogger {
    public void log(Object object) {
        String messageTolog = serializeObject(object);
        openFile();
        writeLogToFile(messageTolog);
        closeFile();
    }
    private void openFile() {
        System.out.println("Opening file");
    }
    private void writeLogToFile(String message) {
        System.out.println("Inserting logs to file = " + message);
    }
    private void closeFile() {
        System.out.println("Close file");
    }
}