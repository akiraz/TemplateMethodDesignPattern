package com.designpattern.zero;

public class ToBeRefactored {
	public static void main(String[] args) {

		DatabaseLogger databaseLogger = new DatabaseLogger();
		databaseLogger.log("Some Logs");

		FileLogger fileLogger = new FileLogger();
		fileLogger.log("Some Logs");

	}

}

class DatabaseLogger {

	public void log(String message) {
		String messageTolog = serializeObject(message);
		connecToDb();
		insertlogToDb(messageTolog);
		closeDbConnection();
	}

	private String serializeObject(Object message) {
		System.out.println("Serializing log object");
		return message.toString();
	}

	private void connecToDb() {
		System.out.println("Connecting to db");
	}

	private void insertlogToDb(String message) {
		System.out.println("Inserting logs to db = " + message);
	}

	private void closeDbConnection() {
		System.out.println("Closing db connection");
	}
}

class FileLogger {
	public void log(Object object) {
		String messageTolog = serializeObject(object);
		openFile();
		writeLogToFile(messageTolog);
		closeFile();
	}

	private String serializeObject(Object object) {
		System.out.println("Serializing log object");
		return object.toString();
	}

	private void openFile() {
		System.out.println("Opening file");
	}

	private void writeLogToFile(String message) {
		System.out.println("Writing logs to file = " + message);
	}

	private void closeFile() {
		System.out.println("Closing file");
	}
}