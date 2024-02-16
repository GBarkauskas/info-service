package com.car.info.service.infoservice.repository;

import com.car.info.service.infoservice.model.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<UserRole, Long> {
}
