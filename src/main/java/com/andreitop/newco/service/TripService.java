package com.andreitop.newco.service;

import com.andreitop.newco.entity.Trip;
import com.andreitop.newco.repository.TripJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripJpaRepository tripRepository;

    @Autowired
    public TripService(TripJpaRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    public Trip findById(Long id) {
        return tripRepository.findById(id).get();
    }

    public void save(Trip trip) {
        tripRepository.save(trip);
    }

    public void delete(Long id) {
        tripRepository.deleteById(id);
    }

    public void update(Trip newTrip) {
        tripRepository.update(newTrip.getOrigin(),
                newTrip.getDestination(),
                newTrip.getPrice(),
                newTrip.getId());
    }
}
