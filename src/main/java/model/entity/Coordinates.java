package model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Value
@NoArgsConstructor(force = true)
@AllArgsConstructor
@XmlRootElement(name = "Coordinates")
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
	@NonNull
	Double x;
	@NonNull
	Integer y;
}
