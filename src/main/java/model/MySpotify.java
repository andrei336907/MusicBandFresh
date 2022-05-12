package model;

import lombok.NonNull;
import model.repository.MusicBandRepo;
import ui.ConsoleUserInterface;
import ui.UserCommandFactory;
import ui.UserInterface;
import ui.command.UserCommand;

import java.io.FileNotFoundException;



public class MySpotify {
	private final UserInterface userInterface;
	private final UserCommandFactory userCommandFactory;

	public MySpotify(){
		userInterface = new ConsoleUserInterface<MusicBandRepo>();
		MusicBandRepo mbp = new MusicBandRepo();
		userCommandFactory = new UserCommandFactory(userInterface, mbp);
	}

	public MySpotify(UserInterface userInterface) {
		this.userInterface = userInterface;
		MusicBandRepo mbp = new MusicBandRepo();
		userCommandFactory = new UserCommandFactory(userInterface, mbp);
	}

	public MySpotify(@NonNull UserInterface ui, @NonNull MusicBandRepo mbp){
		userInterface = ui;
		userCommandFactory = new UserCommandFactory(userInterface, mbp);
	}

	public void Start() throws FileNotFoundException {
		userInterface.writeMessage("Hello");
		userInterface.writeMessage("Enter '?' or 'help' for command list");
		boolean shouldContinue = true;
		while (shouldContinue) {
			String input = userInterface.readStringValue("command");
			UserCommand userCommand = userCommandFactory.getCommand(input);
			try {
				userCommand.run();
			}

			catch (Exception exception) {
				userInterface.writeWarning(exception.getMessage());
			}

			shouldContinue = userCommand.isShouldContinue();
		}
	}
}
