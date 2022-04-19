package ui.command;

import model.entity.MusicBand;
import model.repository.MusicBandRepo;
import ui.UserInterface;

import java.util.Collection;

public class FilterByNamePattern extends NonTerminatingCommand {
    private final MusicBandRepo musicBandRepo;

    public FilterByNamePattern(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() {
        String pattern = getUserInterface().readStringValue("pattern");
        Collection<MusicBand> musicBands = musicBandRepo.findByNamePattern(pattern);
        for (MusicBand musicBand : musicBands) {
            getUserInterface().writeMessage(musicBand.toString());
        }
    }
}
