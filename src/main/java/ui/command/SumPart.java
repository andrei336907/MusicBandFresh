package ui.command;

import model.repository.MusicBandRepo;
import ui.UserInterface;

public class SumPart extends NonTerminatingCommand {
    private final MusicBandRepo musicBandRepo;

    public SumPart(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() {
        getUserInterface().writeReturnedValue(musicBandRepo.sumParticipants().toString(), "sum of parts");
    }
}
