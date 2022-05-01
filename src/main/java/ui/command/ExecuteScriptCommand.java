package ui.command;

import model.repository.MusicBandRepo;
import ui.FileUserInterface;
import ui.UserCommandFactory;
import ui.UserInterface;

import java.util.HashSet;
import java.util.Set;

public class ExecuteScriptCommand extends NonTerminatingCommand {
    private final MusicBandRepo musicBandRepo;
    private FileUserInterface fileUserInterface;
    private UserCommandFactory userCommandFactory;

    public static Set<String> pathsInExecute = new HashSet<String>();

    public ExecuteScriptCommand(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() {
        System.out.println("enter script path");


        String path = userInterface.readStringValue("script path");


        try {
            fileUserInterface = new FileUserInterface(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        pathsInExecute.add(fileUserInterface.getPath());

        userCommandFactory = new UserCommandFactory(fileUserInterface, musicBandRepo);

        boolean shouldContinue = true;
        while (shouldContinue) {
            if (fileUserInterface.getScanner() == null || !fileUserInterface.getScanner().hasNext()) {
                break;
            }

            String input = fileUserInterface.readStringValue("command");

            UserCommand userCommand = userCommandFactory.getCommand(input);
            try {
                userCommand.run();
            }

            catch (Exception exception) {
                fileUserInterface.writeWarning(exception.getMessage());
            }

            shouldContinue = userCommand.isShouldContinue();

        }

        pathsInExecute.remove(fileUserInterface.getPath());
        System.out.println("execute script finished bitch");
    }
}
