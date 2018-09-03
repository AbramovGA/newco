package com.andreitop.newco.controller;

import com.andreitop.newco.dto.IdentifiableDto;
import com.andreitop.newco.service.AbstractService;

import java.util.List;

public abstract class AbstractController<S extends AbstractService, D extends IdentifiableDto> {

    protected final S service;

    protected AbstractController(S service) {
        this.service = service;
    }

    protected final List<D> findAllInternal() {
        return service.findAll();
    }

    protected D findByIdInternal(final Long id) {
        return (D) service.findById(id);
    }

    protected void createInternal(final D entry) {
        service.save(entry);
    }

    protected void deleteInternal(final Long id) {
        service.delete(id);
    }

    protected void updateInternal(final D newEntry) {
        service.update(newEntry);
    }




}
