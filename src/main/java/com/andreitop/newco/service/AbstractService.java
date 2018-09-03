package com.andreitop.newco.service;

import com.andreitop.newco.dto.IdentifiableDto;
import com.andreitop.newco.repository.AbstractRepository;

import java.util.List;

public class AbstractService<T extends AbstractRepository, U extends IdentifiableDto> {
    private final T repository;

    public AbstractService(T repository) {
        this.repository = repository;
    }

    public List<U> findAll() {
        return repository.findAll();
    }

    public U findById(Long id) {
        return (U) repository.findById(id);
    }

    public void save(U trip) {
        repository.save(trip);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public void update(U newTrip) {
        repository.update(newTrip);
    }
}
