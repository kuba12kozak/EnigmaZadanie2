package com.kozak.controllers;

import com.kozak.models.GeolocationData;
import com.kozak.services.GeolocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("geolocation")
public class GeolocationController {

    private GeolocationService geolocationService;

    @Autowired
    public GeolocationController(GeolocationService geolocationService) {
        this.geolocationService = geolocationService;
    }

    @PostMapping
    public void saveGeolocationData(GeolocationData data) {
        geolocationService.save(data);
    }
}
