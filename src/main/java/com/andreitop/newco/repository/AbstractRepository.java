package com.andreitop.newco.repository;

import com.andreitop.newco.dto.IdentifiableDto;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T extends IdentifiableDto>{

    private final List<T> data = new ArrayList<>();

    public List<T> findAll() {
        return data;
    }

    public T findById(final Long id) {
        return data.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(final T entry) {
        entry.setId((long) (data.size() + 1));
        data.add(entry);
    }

    public void delete(final Long id) {
        data.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresent(data::remove);
    }

    public void update(final T newEntry) {
        data.stream()
                .filter(t -> t.getId().equals(newEntry.getId()))
                .findFirst()
                .ifPresent(t -> data.set(data.indexOf(t), newEntry));
    }

}
