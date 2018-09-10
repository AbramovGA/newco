package com.andreitop.newco.repository;

import com.andreitop.newco.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripJpaRepository extends JpaRepository<Trip, Long> {

    @Query("update Trip set origin = :orig, destination = :dest, price = :pr where id = :id")
    void update(@Param("orig") String origin,
                @Param("dest") String destination,
                @Param("pr") int price,
                @Param("id") Long id);
}
