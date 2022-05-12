package ui.command;

import model.entity.Album;
import model.entity.Coordinates;
import model.entity.MusicBand;
import model.entity.MusicGenre;
import model.repository.MusicBandRepo;
import ui.UserInterface;

import java.io.FileNotFoundException;

public class UpdateCommand extends NonTerminatingCommand{
    private MusicBandRepo musicBandRepo ;

    public UpdateCommand(UserInterface userInterface, MusicBandRepo musicBandRepo) {
        super(userInterface);
        this.musicBandRepo = musicBandRepo;
    }

    @Override
    public void run() throws FileNotFoundException {
        Integer id = getUserInterface("eve").readIntegerValue("music band id");
        System.out.println("enter new parameters");
        String name = getUserInterface("eve").readStringValue("music band name");
        double coordinateX = getUserInterface("eve").readDoubleValue("coordinate x");
        Integer coordinateY = getUserInterface("eve").readIntegerValue("coordinate y");
        Coordinates coordinates = new Coordinates(coordinateX, coordinateY);
        Integer participantsNumber = getUserInterface("eve").readIntegerValue("participants number");
        MusicGenre musicGenre = MusicGenre.valueOf(getUserInterface("eve").readStringValue("music genge (jazz, soul, blues)").toUpperCase());
        String albumName = getUserInterface("eve").readStringValue("best album name");
        Long albumSales = getUserInterface("eve").readLongValue("best album sales");
        Album album = new Album(albumName, albumSales);
        MusicBand musicBand = MusicBand.builder()
                .id(id)
                .name(name)
                .coordinates(coordinates)
                .numberOfParticipants(participantsNumber)
                .genre(musicGenre)
                .bestAlbum(album)
                .build();
        musicBandRepo.update(musicBand);
        getUserInterface("eve").writeReturnedValue("updated music band", musicBand.getName());
    }
}
