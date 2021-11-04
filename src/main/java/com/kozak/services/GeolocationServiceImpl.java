package com.kozak.services;

import com.kozak.models.GeolocationData;
import com.kozak.repositories.GeolocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GeolocationServiceImpl implements GeolocationService {
    private final GeolocationRepository geolocationRepository;

    @Autowired
    public GeolocationServiceImpl(GeolocationRepository geolocationRepository) {
        this.geolocationRepository = geolocationRepository;
    }

    public GeolocationData save(GeolocationData data) {
        log.info("Saving geolocation data...");
        return geolocationRepository.save(data);
    }

    public List<GeolocationData> findAll() {
        Iterable<GeolocationData> all = geolocationRepository.findAll();
        List<GeolocationData> allData = new ArrayList<>();
        all.forEach(allData::add);
        return allData;
    }
}
