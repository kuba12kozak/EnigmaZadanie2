package com.kozak.services;

import com.kozak.models.GeolocationData;

import java.util.List;

public interface GeolocationService {

    GeolocationData save(GeolocationData data);

    List<GeolocationData> findAll();
}
