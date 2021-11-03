package com.kozak.services;

import com.kozak.models.GeolocationData;
import com.kozak.repositories.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeolocationService {
    private GeolocationRepository geolocationRepository;

    @Autowired
    public GeolocationService(GeolocationRepository geolocationRepository) {
        this.geolocationRepository = geolocationRepository;
    }

    public GeolocationData save(GeolocationData data) {
        return geolocationRepository.save(data);
    }
}
