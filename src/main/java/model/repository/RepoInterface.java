package model.repository;

import lombok.NonNull;

import java.util.Collection;

public interface RepoInterface<T> {
	void add(@NonNull T item);
	void remove(@NonNull Integer itemId);
	void update(@NonNull T itemId);
	T getById(@NonNull Integer itemId);
	void save();
	void readFromFile();
	void addIfMax(@NonNull T item);
	void addIfMin(@NonNull T item);
	void removeGreater(@NonNull T item);
	Long sumParticipants();
	Collection<T> getAll();
	Collection<T> filterByParts(Integer partsNum);
	Collection<T> findByNamePattern(String pattern);
	void clear();
}
