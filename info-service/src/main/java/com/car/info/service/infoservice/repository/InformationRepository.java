package com.car.info.service.infoservice.repository;

import com.car.info.service.infoservice.model.Information;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InformationRepository extends CrudRepository<Information, Long> {
}
