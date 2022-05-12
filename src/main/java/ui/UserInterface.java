package ui;

public interface UserInterface {
	String readStringValue(String message);
	long readLongValue(String message);
	Double readDoubleValue(String message);
	Integer readIntegerValue(String message);
	void writeMessage(String message);
	void writeReturnedValue(String valueName, String value);
	void writeWarning(String message);
}
