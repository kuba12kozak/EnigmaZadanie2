package com.kozak.controllers;

import com.kozak.models.GeolocationData;
import com.kozak.services.GeolocationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest()
class GeolocationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GeolocationService geolocationService;

    @Test
    void testSaveEndpoint() throws Exception {
        //given
        String bodyString = "{\"deviceId\":\"1234\", \"longitude\":12345, \"latitude\":4567}";
        GeolocationData data = new GeolocationData();
        data.setId(1);
        data.setDeviceId("1234");
        data.setLongitude(12345);
        data.setLatitude(4567);

        //when
        when(geolocationService.save(any())).thenReturn(data);

        //then
        this.mockMvc.perform(post("/geolocation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bodyString))
                .andExpect(status().isCreated());
    }

    @Test
    void testSaveEndpointWithBrokenData() throws Exception {
        //given
        String bodyString = "{\"deviceId\":\"1234\", \"latitude\":4567}";
        GeolocationData data = new GeolocationData();
        data.setId(1);
        data.setDeviceId("1234");
        data.setLatitude(4567);

        //when
        when(geolocationService.save(any())).thenReturn(data);

        //then
        this.mockMvc.perform(post("/geolocation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bodyString))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testGetAllEndpoint() throws Exception {
        //when
        when(geolocationService.findAll()).thenReturn(new ArrayList<>());

        //then
        this.mockMvc.perform(get("/geolocation"))
                .andExpect(status().isOk());
    }
}