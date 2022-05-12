package model.entity;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import tool.ExceptionMessages;
import tool.MusicBandException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Value
@NoArgsConstructor(force = true)
@XmlRootElement(name = "Album")
@XmlAccessorType(XmlAccessType.FIELD)
public class Album {
	String name;
	long sales;

	public Album(@NonNull String name, @NonNull long sales) {
		if (name.isBlank()) {
			throw new MusicBandException(ExceptionMessages.BLANK_FIELD);
		}
		if (sales <= 0) {
			throw new MusicBandException(ExceptionMessages.NEGATIVE_FIELD);
		}
		this.name = name;
		this.sales = sales;
	}
}
