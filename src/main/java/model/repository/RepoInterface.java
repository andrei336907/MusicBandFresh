package model.repository;

import lombok.NonNull;

import java.util.Collection;

public interface RepoInterface<T> {
	void add(@NonNull T item);
	void remove(@NonNull Integer itemId);
	void update(@NonNull T itemId);
	T getById(@NonNull Integer itemId);
	Collection<T> getAll();
	void clear();
}
