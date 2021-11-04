package com.kozak.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
public class GeolocationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "deviceId must not be null")
    private String deviceId;

    @NotNull(message = "longitude must not be null")
    private Integer longitude;

    @NotNull(message = "latitude must not be null")
    private Integer latitude;
}
