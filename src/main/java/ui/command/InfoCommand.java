package ui.command;

import model.repository.MusicBandRepo;
import ui.UserInterface;

public class InfoCommand extends NonTerminatingCommand {
    private final MusicBandRepo musicBandRepo;

    public InfoCommand(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() {

        if (musicBandRepo.getAll().isEmpty()) {
            getUserInterface("eve").writeMessage("Your collection doesn't exist");
        }
        else {
            getUserInterface("eve").writeMessage("Collection type - PriorityQueue");
            Integer size = musicBandRepo.getAll().size();
            getUserInterface("eve").writeMessage("Collection size - " + size.toString());
            getUserInterface("eve").writeMessage("Collection creation date - " + musicBandRepo.getAll().stream().findFirst().get().getCreationDate());}
    }
}

