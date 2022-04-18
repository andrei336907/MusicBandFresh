package model.repository;

import lombok.NonNull;
import model.entity.MusicBand;
import tool.ExceptionMessages;
import tool.MusicBandException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.PriorityQueue;

@XmlRootElement(name = "MusicBandRepo")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBandRepo implements RepoInterface<MusicBand> {
	private final PriorityQueue<MusicBand> musicBands = new PriorityQueue<>();

	@Override
	public void add(@NonNull MusicBand musicBand) {
		musicBands.add(musicBand);
	}

	@Override
	public void remove(@NonNull Integer musicBandId) {
		MusicBand musicBand = getById(musicBandId);
		musicBands.remove(musicBand);
	}

	@Override
	public void update(@NonNull MusicBand musicBand) {
		MusicBand musicBandToRemove = getById(musicBand.getId());
		musicBands.remove(musicBandToRemove);
		musicBands.add(musicBand);
	}

	@Override
	public MusicBand getById(@NonNull Integer musicBandId) {
		Optional<MusicBand> musicBandResult = musicBands.stream()
				.filter(musicBand -> musicBand.getId().equals(musicBandId))
				.findFirst();
		if (musicBandResult.isEmpty()) {
			throw new MusicBandException(ExceptionMessages.INVALID_ID);
		}
		return musicBandResult.get();
	}

	@Override
	public Collection<MusicBand> getAll() {
		return Collections.unmodifiableCollection(musicBands);
	}

	@Override
	public void clear() {
		musicBands.clear();
	}

	@Override
	public String toString() {
		return "MusicBandRepo{" +
				"musicBands=" + musicBands +
				'}';
	}
}
