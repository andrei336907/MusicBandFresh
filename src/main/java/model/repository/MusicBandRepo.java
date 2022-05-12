package model.repository;

import lombok.NonNull;
import model.entity.MusicBand;
import tool.ExceptionMessages;
import tool.MusicBandException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.*;

@XmlRootElement(name = "MusicBandRepo")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBandRepo implements RepoInterface<MusicBand> {
	private PriorityQueue<MusicBand> musicBands = new PriorityQueue<>();

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
	public void save() {
		try {
			JAXBContext context = JAXBContext.newInstance(MusicBandRepo.class);
			Marshaller marshaller = context.createMarshaller();
			// устанавливаем флаг для читабельного вывода XML в JAXB
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// маршаллинг объекта в файл
			marshaller.marshal(this, new File("C:\\Users\\andre\\IdeaProjects\\andrea\\src\\main\\resources\\data.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readFromFile() {
		try {
                // создаем объект JAXBContext - точку входа для JAXB
                JAXBContext jaxbContext = JAXBContext.newInstance(MusicBandRepo.class);
                Unmarshaller un = jaxbContext.createUnmarshaller();
                musicBands = ((MusicBandRepo) un.unmarshal(new File("C:\\Users\\andre\\IdeaProjects\\andrea\\src\\main\\resources\\data.xml"))).musicBands;
            } catch (JAXBException e) {
                e.printStackTrace();
            }
	}

	@Override
	public void addIfMax(@NonNull MusicBand item) {
		MusicBand maxMusicBand = musicBands.stream().max(MusicBand::compareTo).orElse(null);
		if (item.compareTo(maxMusicBand) > 0) {
			add(item);
		}
		else {
			System.out.println("wrong id");
		}
	}

	@Override
	public void removeGreater(@NonNull MusicBand item) {
		List<MusicBand> toRemove = musicBands.stream()
				.filter(musicBand -> musicBand.compareTo(item) > 0)
				.toList();
		musicBands.removeAll(toRemove);
	}

	@Override
	public Long sumParticipants() {
		Long result = 0L;
		for (MusicBand musicBand : musicBands) {
			result += musicBand.getNumberOfParticipants();
		}
		return result;
	}

	@Override
	public void addIfMin(@NonNull MusicBand item) {
		MusicBand minMusicBand = musicBands.peek();
		if (item.compareTo(minMusicBand) < 0) {
			add(item);
		}
		else {
			System.out.println("wrong id");
		}
	}

	@Override
	public Collection<MusicBand> getAll() {
		return Collections.unmodifiableCollection(musicBands);
	}

	@Override
	public Collection<MusicBand> findByNamePattern(String pattern) {
		String tmp = ".*" + pattern + ".*";
		return musicBands.stream().filter(musicBand -> musicBand.getName().matches(tmp)).toList();
	}

	@Override
	public Collection<MusicBand> filterByParts(Integer partsNum) {
		return musicBands.stream().filter(musicBand -> Objects.equals(musicBand.getNumberOfParticipants(), partsNum)).toList();
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
