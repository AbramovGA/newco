package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

public class TripServiceTest {


    @MockBean
    private TripRepository mockRepository = Mockito.mock(TripRepository.class);

    private TripService tripService = new TripService(mockRepository);

    private static TripDto testTrip;
    private static TripDto testUpdatedTrip;

    static {
        testTrip = new TripDto();
        testTrip.setId(1L);
        testTrip.setOrigin("MOW");
        testTrip.setDestination("LED");
        testTrip.setPrice(4232);

        testTrip = new TripDto();
        testTrip.setId(1L);
        testTrip.setOrigin("LAMA");
        testTrip.setDestination("WOMBAT");
        testTrip.setPrice(42);
    }

    @Test
    public void givenTrips_whenFindAll_thenReturnList() {

        List<TripDto> allTrips = Collections.singletonList(testTrip);
        given(mockRepository.findAll()).willReturn(allTrips);

        assertThat(tripService.findAll(), is(allTrips));

    }

    @Test
    public void givenTrips_whenFindById_thenReturnTrip() {

        Long id = 1L;

        given(mockRepository.findById(id)).willReturn(testTrip);

        assertThat(tripService.findById(id), is(testTrip));
    }

    @Test
    public void save() {
        tripService.save(testTrip);
    }

    @Test
    public void delete() {
        Long id = 1L;
        tripService.delete(id);
    }

    @Test
    public void update() {
        tripService.update(testTrip);
    }
}