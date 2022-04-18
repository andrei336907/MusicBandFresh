package ui.command;

import model.entity.MusicBand;
import model.repository.MusicBandRepo;
import ui.UserInterface;

public class GetAllMusicBandsCommand extends NonTerminatingCommand {
    private final MusicBandRepo musicBandRepo;

    public GetAllMusicBandsCommand(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() {
        for (MusicBand musicBand : musicBandRepo.getAll()) {
            getUserInterface().writeMessage(musicBand.toString());
        }
    }
}
