package ui.command;

import model.entity.Album;
import model.entity.Coordinates;
import model.entity.MusicBand;
import model.entity.MusicGenre;
import model.repository.MusicBandRepo;
import ui.UserInterface;

public class AddIfMaxCommand extends NonTerminatingCommand{
    MusicBandRepo musicBandRepo;

    public AddIfMaxCommand(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() {
        String name = getUserInterface().readStringValue("music band name");
        double coordinateX = getUserInterface().readDoubleValue("coordinate x");
        Integer coordinateY = getUserInterface().readIntegerValue("coordinate y");
        Coordinates coordinates = new Coordinates(coordinateX, coordinateY);
        Integer participantsNumber = getUserInterface().readIntegerValue("participants number");
        MusicGenre musicGenre = MusicGenre.valueOf(getUserInterface().readStringValue("music genge (jazz, soul, blues)").toUpperCase());
        String albumName = getUserInterface().readStringValue("best album name");
        Long albumSales = getUserInterface().readLongValue("best album sales");
        Album album = new Album(albumName, albumSales);
        MusicBand musicBand = MusicBand.builder()
                .name(name)
                .coordinates(coordinates)
                .numberOfParticipants(participantsNumber)
                .genre(musicGenre)
                .bestAlbum(album)
                .build();
        musicBandRepo.addIfMax(musicBand);
    }
}
