package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TripService extends AbstractService<TripRepository, TripDto>{

    @Autowired
    public TripService(TripRepository repository) {
        super(repository);
    }
}
