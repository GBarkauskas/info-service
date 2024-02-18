package com.car.info.service.infoservice.service.implementation;

import com.car.info.service.infoservice.exception.UnableToFindInformationException;
import com.car.info.service.infoservice.model.Information;
import com.car.info.service.infoservice.repository.InformationRepository;
import com.car.info.service.infoservice.service.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InformationServiceImplementation implements InformationService {

    private final InformationRepository informationRepository;


    @Override
    public Information createInformation(Information information) {
        information.setModifiedAt(ZonedDateTime.now());
        information.setCreatedAt(ZonedDateTime.now());
        return informationRepository.save(information);
    }

    @Override
    public Information updateInformation(Long id, Information information) {
        Information existingInformation = getInformationById(id);

        if (existingInformation == null) {
            throw new UnableToFindInformationException("Unable to find information with given parameters.");
        }

        existingInformation.setMake(information.getMake());
        existingInformation.setModel(information.getModel());
        existingInformation.setAcceleration(information.getAcceleration());
        existingInformation.setEngine(information.getEngine());
        existingInformation.setFuelType(information.getFuelType());
        existingInformation.setModifiedAt(ZonedDateTime.now());

        return informationRepository.save(existingInformation);
    }

    @Override
    public void deleteInformationById(Long id) {
        informationRepository.deleteById(id);
    }


    @Override
    public List<Information> getAllCarsInformation() {
        return (List<Information>) informationRepository.findAll();
    }

    @Override
    public Information getInformationById(Long id) {
        return informationRepository.findById(id).orElse(null);
    }
}
