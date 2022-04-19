package ui.command;

import model.entity.MusicBand;
import model.repository.MusicBandRepo;
import ui.UserInterface;

import java.util.Collection;

public class FilterByParts extends NonTerminatingCommand {
    private final MusicBandRepo musicBandRepo;

    public FilterByParts(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() {
        Integer i = getUserInterface().readIntegerValue("parts sum");
        Collection<MusicBand> musicBands = musicBandRepo.filterByParts(i);
        for (MusicBand musicBand : musicBands) {
            getUserInterface().writeMessage(musicBand.toString());
        }
    }
}
