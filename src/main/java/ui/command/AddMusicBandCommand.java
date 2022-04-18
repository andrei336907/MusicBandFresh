package ui.command;

import model.entity.Album;
import model.entity.Coordinates;
import model.entity.MusicBand;
import model.entity.MusicGenre;
import model.repository.MusicBandRepo;
import ui.UserInterface;

import java.io.FileNotFoundException;

public class AddMusicBandCommand extends NonTerminatingCommand {
	private final MusicBandRepo musicBandRepo;

	public AddMusicBandCommand(UserInterface userInterface, MusicBandRepo musicBandRepo) {
		super(userInterface);
		this.musicBandRepo = musicBandRepo;
	}

	@Override
	public void run() throws FileNotFoundException {
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
		musicBandRepo.add(musicBand);
		getUserInterface().writeReturnedValue("music band name", musicBand.getName());
	}
}
