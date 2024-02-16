package com.car.info.service.infoservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAR_INFORMATION")
public class Information extends BaseEntity {

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "'year'", nullable = false)
    private String year;

    @Column(name = "engine", nullable = false)
    private String engine;

    @Column(name = "acceleration", nullable = false)
    private String acceleration;

    @Column(name = "fuel_type", nullable = false)
    private String fuelType;

}
