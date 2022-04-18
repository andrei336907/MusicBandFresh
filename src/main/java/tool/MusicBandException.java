package tool;

import lombok.NonNull;

public class MusicBandException extends RuntimeException {
	public MusicBandException(@NonNull String message) {
		super(message);
	}
}
