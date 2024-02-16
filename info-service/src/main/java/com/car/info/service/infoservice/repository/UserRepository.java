package com.car.info.service.infoservice.repository;

import com.car.info.service.infoservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
     User findByUsername(String username);
}
