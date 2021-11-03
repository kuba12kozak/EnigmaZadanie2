package com.kozak.repositories;

import com.kozak.models.GeolocationData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeolocationRepository extends CrudRepository<GeolocationData, Long> {
}
