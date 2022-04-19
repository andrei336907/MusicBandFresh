package model.entity;


import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import tool.ExceptionMessages;
import tool.MusicBandException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@Value
@NoArgsConstructor(force = true)
@XmlRootElement(name = "MusicBand")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBand implements Comparable<MusicBand> {
    private static Integer idCounter = 1;

    Integer id;
    String name;
    Coordinates coordinates;
    String creationDate;
    Integer numberOfParticipants;
    MusicGenre genre;
    Album bestAlbum;

    @Builder(toBuilder = true)
    MusicBand(
            Integer id,
            @NonNull String name,
            @NonNull Coordinates coordinates,
            Integer numberOfParticipants,
            @NonNull MusicGenre genre,
            Album bestAlbum
    ) {
        if (name.isBlank()) {
            throw new MusicBandException(ExceptionMessages.BLANK_FIELD);
        }
        if (numberOfParticipants != null && numberOfParticipants <= 0) {
            throw new MusicBandException(ExceptionMessages.NEGATIVE_FIELD);
        }
        this.id = (id == null) ? idCounter++ : id;
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.bestAlbum = bestAlbum;
        creationDate = LocalDateTime.now().toString();
    }

    @Override
    public int compareTo(MusicBand o) {
        return numberOfParticipants.compareTo(o.numberOfParticipants);
    }
}
