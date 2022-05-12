package ui.command;

import model.repository.MusicBandRepo;
import ui.UserInterface;

public class RemoveCommand extends NonTerminatingCommand {
    private final MusicBandRepo musicBandRepo;

    public RemoveCommand(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() {
        Integer id = getUserInterface("eve").readIntegerValue("music band id");
        musicBandRepo.remove(id);

    }


}