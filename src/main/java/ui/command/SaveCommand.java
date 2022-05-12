package ui.command;

import model.repository.MusicBandRepo;
import ui.UserInterface;

public class SaveCommand extends NonTerminatingCommand {
    private MusicBandRepo musicBandRepo;

    public SaveCommand(UserInterface ui, MusicBandRepo musicBandRepo) {
        super(ui);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() {
        musicBandRepo.save();
    }
}

