package com.kozak.controllers;

import com.kozak.models.GeolocationData;
import com.kozak.services.GeolocationService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("geolocation")
@Slf4j
public class GeolocationController {

    private final GeolocationService geolocationService;

    @Autowired
    public GeolocationController(GeolocationService geolocationService) {
        this.geolocationService = geolocationService;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public boolean saveGeolocationData(@Valid @RequestBody GeolocationData data) {
        log.info("Geolocation data received.");
        GeolocationData savedData = geolocationService.save(data);
        if (savedData == null) {
            return false;
        }
        log.info("Saved data: " + savedData);
        return true;
    }

    @GetMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<GeolocationData> findAll() {
        log.info("Getting all geolocation data.");
        return geolocationService.findAll();
    }
}
