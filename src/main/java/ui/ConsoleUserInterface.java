package ui;

import java.util.Scanner;

public class ConsoleUserInterface<T> implements UserInterface {
	private final Scanner in = new Scanner(System.in);

	@Override
	public String readStringValue(String message) {
		System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
		while (!in.hasNext()) {
			System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
			in.next();
		}
		return in.next();
	}

	@Override
	public long readLongValue(String message) {
		System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
		while (!in.hasNextLong()) {
			System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
			in.next();
		}
		return in.nextLong();
	}

	@Override
	public Double readDoubleValue(String message) {
		System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
		while (!in.hasNextDouble()) {
			System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
			in.next();
		}
		return in.nextDouble();
	}

	@Override
	public Integer readIntegerValue(String message) {
		System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
		while (!in.hasNextInt()) {
			System.out.println((char) 27 + "[35mEnter " + message + " >" + (char) 27 + "[0m");
			in.next();
		}
		return in.nextInt();
	}


	@Override
	public void writeMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void writeReturnedValue(String valueName, String value) {
		System.out.println((char) 27 + "[32m" + valueName + ": " + value + (char)27 + "[0m");
	}

	@Override
	public void writeWarning(String message) {
		System.out.println((char) 27 + "[31m" + message + (char)27 + "[0m");
	}
}
