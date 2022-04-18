package ui.command;

import model.repository.MusicBandRepo;
import ui.UserInterface;

public class ClearCommand extends NonTerminatingCommand {
    private MusicBandRepo musicBandRepo ;

    public ClearCommand(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() {
       musicBandRepo.clear();
    }


}

