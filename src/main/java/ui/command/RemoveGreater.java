package ui.command;

import model.entity.MusicBand;
import model.repository.MusicBandRepo;
import ui.UserInterface;

import java.io.FileNotFoundException;

public class RemoveGreater extends NonTerminatingCommand{
    private final MusicBandRepo musicBandRepo;

    public RemoveGreater(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() throws FileNotFoundException {

        Integer id = getUserInterface().readIntegerValue("id");
        MusicBand musicBand = musicBandRepo.getById(id);
        musicBandRepo.removeGreater(musicBand);
    }
}
