package com.car.info.service.infoservice.controller;

import com.car.info.service.infoservice.model.Information;
import com.car.info.service.infoservice.service.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cars-information")
public class CarInformationController {

    private final InformationService informationService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Information createCar(@RequestBody Information information) {
        return informationService.createInformation(information);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Information updateCar(@PathVariable Long id, @RequestBody Information information) {
        return informationService.updateInformation(id, information);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteCar(@PathVariable Long id) {
        informationService.deleteInformationById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<Information> getAllCars() {
        return informationService.getAllCarsInformation();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public Information getCarById(@PathVariable Long id) {
        return informationService.getInformationById(id);
    }
}
