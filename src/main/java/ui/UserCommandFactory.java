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
			case "quit", "q", "exit" -> new QuitCommand(userInterface);
			case "?", "??", "help" -> new HelpCommand(userInterface);
			case "add music band", "amb" -> new AddMusicBandCommand(userInterface, musicBandRepo);
			case "get all", "ga" -> new GetAllMusicBandsCommand(userInterface, musicBandRepo);
			case "clr", "clear" -> new ClearCommand(userInterface, musicBandRepo);
			case "rmv", "remove" -> new RemoveCommand(userInterface, musicBandRepo);
			case "sv", "save" -> new SaveCommand(userInterface, musicBandRepo);
			case "upd", "update" -> new UpdateCommand(userInterface, musicBandRepo);
			case "i", "info" -> new InfoCommand(userInterface, musicBandRepo);
			case "amx", "add max" -> new AddIfMaxCommand(userInterface, musicBandRepo);
			case "amn", "add min" -> new AddIfMin(userInterface, musicBandRepo);
			case "rmg", "remove gr" -> new RemoveGreater(userInterface, musicBandRepo);
			case "sp", "sum parts" -> new SumPart(userInterface, musicBandRepo);
			case "fp", "filter parts" -> new FilterByParts(userInterface, musicBandRepo);
			case "fn", "filter name" -> new FilterByNamePattern(userInterface, musicBandRepo);
			case "rf", "read file" -> new ReadFromFile(userInterface, musicBandRepo);
			case "ec", "ex com" -> new ExecuteScriptCommand(userInterface, musicBandRepo);

			default -> new UnknownCommand(userInterface);
		};
	}
}