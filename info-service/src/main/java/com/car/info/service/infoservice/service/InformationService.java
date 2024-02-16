package com.car.info.service.infoservice.service;

import com.car.info.service.infoservice.model.Information;

import java.util.List;

public interface InformationService {

    Information createInformation(Information information);

    Information updateInformation(Long id, Information information);

    void deleteInformationById(Long id);

    List<Information> getAllCarsInformation();

    Information getInformationById(Long id);
}
