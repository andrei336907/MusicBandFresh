package ui.command;

import model.repository.MusicBandRepo;
import ui.UserInterface;

public class UpdateCommand extends NonTerminatingCommand{
    private MusicBandRepo musicBandRepo ;

    public UpdateCommand(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() {
//        musicBandRepo.update(MusicBand);

    }
}
