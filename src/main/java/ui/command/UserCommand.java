package ui.command;

import lombok.NonNull;
import ui.UserInterface;

import java.io.FileNotFoundException;

public abstract class UserCommand {
	private final boolean shouldContinue;
	protected UserInterface userInterface;

	public UserCommand(
			boolean shouldContinue,
			@NonNull UserInterface userInterface) {
		this.shouldContinue = shouldContinue;
		this.userInterface = userInterface;
	}

	public abstract void run() throws FileNotFoundException;

	public boolean isShouldContinue() {
		return shouldContinue;
	}

	public UserInterface getUserInterface(String eve) {
		return userInterface;
	}
}
