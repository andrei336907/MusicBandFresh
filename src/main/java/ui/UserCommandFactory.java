package ui;

import lombok.AllArgsConstructor;
import model.repository.MusicBandRepo;
import ui.command.*;

import java.util.Locale;

@AllArgsConstructor
public class UserCommandFactory {
	private final UserInterface userInterface;
	private final MusicBandRepo musicBandRepo;

	public UserCommand getCommand(String input) {
		return switch (input.toLowerCase(Locale.ROOT)) {
			case "quit", "q", "term", "terminate" -> new QuitCommand(userInterface);
			case "?", "??", "???", "help" -> new HelpCommand(userInterface);
			case "add music band", "amb" -> new AddMusicBandCommand(userInterface, musicBandRepo);
			case "get all", "ga" -> new GetAllMusicBandsCommand(userInterface, musicBandRepo);
			case "clr", "clear" -> new ClearCommand(userInterface, musicBandRepo);
			case "rmv", "remove" -> new RemoveCommand(userInterface, musicBandRepo);
			case "sv", "save" -> new SaveCommand(userInterface, musicBandRepo);
			case "upd", "update" -> new UpdateCommand(userInterface, musicBandRepo);
			default -> new UnknownCommand(userInterface);
		};
	}
}