package com.andreitop.newco.controller;

import com.andreitop.newco.common.ApiConstant;
import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.service.TripService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TripsController.class)
public class TripsControllerTest {

    private static final String TRIP_JSON = "{\"origin\": \"LED\" , \"destination\":\"MOW\", \"price\" : 12256}";
    private static final String UPDATED_TRIP_JSON = "{\"origin\": \"FOO\" , \"destination\":\"BAR\", \"price\" : 9001}";
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    private static final String API_URL = ApiConstant.API_V_1 + "/trips";
    private static final String BY_ID_URL = API_URL + "/{id}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TripService tripService;

    static TripDto testTrip;

    static {
        testTrip = new TripDto();
        testTrip.setId(1L);
        testTrip.setOrigin("MOW");
        testTrip.setDestination("LED");
        testTrip.setPrice(4232);
    }

    @Test
    public void whenPostTrip_thenCreateTrip() throws Exception {
        mockMvc.perform(post(API_URL)
                .contentType(CONTENT_TYPE)
                .content(TRIP_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void givenTrips_whenGetTrips_thenReturnJsonArray() throws Exception {

        List<TripDto> allTrips = Collections.singletonList(testTrip);
        given(tripService.findAll()).willReturn(allTrips);

        mockMvc.perform(get(API_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].origin", is("MOW")))
                .andExpect(jsonPath("$[0].destination", is("LED")))
                .andExpect(jsonPath("$[0].price", is(4232)));
    }

    @Test
    public void givenTrips_whenGetTripsById_thenReturnJson() throws Exception {

        Long id = 1L;

        given(tripService.findById(id)).willReturn(testTrip);

        mockMvc.perform(get((BY_ID_URL), id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$['id']", is(1)))
                .andExpect(jsonPath("$['origin']", is("MOW")))
                .andExpect(jsonPath("$['destination']", is("LED")))
                .andExpect(jsonPath("$['price']", is(4232)));
    }

    @Test
    public void givenTrips_whenDeleteTrip_thenReturnJson() throws Exception {

        Long id = 1L;
        mockMvc.perform(delete(BY_ID_URL, id)).andExpect(status().isNoContent());
    }

    @Test
    public void givenTrips_whenPutTrip_thenReturnJson() throws Exception {
        mockMvc.perform(put(API_URL)
                .contentType(CONTENT_TYPE)
                .content(UPDATED_TRIP_JSON))
                .andExpect(status().isOk());
    }
}