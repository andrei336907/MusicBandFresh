package ui.command;

import lombok.NonNull;
import ui.UserInterface;


public abstract class NonTerminatingCommand extends UserCommand {
	public NonTerminatingCommand(@NonNull UserInterface userInterface) {
		super(true, userInterface);
	}
}