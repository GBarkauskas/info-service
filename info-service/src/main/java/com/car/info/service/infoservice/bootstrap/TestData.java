package com.car.info.service.infoservice.bootstrap;

import com.car.info.service.infoservice.model.Information;
import com.car.info.service.infoservice.model.User;
import com.car.info.service.infoservice.model.UserRole;
import com.car.info.service.infoservice.repository.InformationRepository;
import com.car.info.service.infoservice.repository.RolesRepository;
import com.car.info.service.infoservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class TestData implements ApplicationListener<ContextRefreshedEvent> {

    private final InformationRepository informationRepository;
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        rolesRepository.save(UserRole.builder().id(1).name("ADMIN").build());
        rolesRepository.save(UserRole.builder().id(2).name("USER").build());

        UserRole admin_role = UserRole.builder()
                .id(1)
                .name("ADMIN")
                .build();

        UserRole user_role = UserRole.builder()
                .id(2)
                .name("USER")
                .build();

        User admin = User.builder()
                .id(1)
                .username("adminas")
                .password("$2a$12$Azn9/AmErnJIhKPRCA3K.uOFDRzjihjbdQD4Cm2bR6mHKhXGk//JO") //slaptazodis
                .roles(Collections.singleton(admin_role))
                .build();

        User user = User.builder()
                .id(2)
                .username("useris")
                .password("$2a$12$ChHkNkhKSizJdbiurYLux.xUMZnuIjTlgFAc1jLB8JPSfMUYHEEki") //stipresnis_slaptazodis
                .roles(Collections.singleton(user_role))
                .build();

        userRepository.save(admin);
        userRepository.save(user);

        Information toyota = Information.builder()
                .make("Toyota")
                .model("Camry")
                .year("2022")
                .engine("V6")
                .acceleration("0-60 mph in 6.5 seconds")
                .fuelType("Gasoline")
                .build();

        Information bmw = Information.builder()
                .make("BMW")
                .model("M5")
                .year("2022")
                .engine("I6")
                .acceleration("0-60 mph in 3 seconds")
                .fuelType("Gasoline")
                .build();

        toyota.setCreatedAt(ZonedDateTime.now());
        toyota.setModifiedAt(ZonedDateTime.now());

        bmw.setCreatedAt(ZonedDateTime.now());
        bmw.setModifiedAt(ZonedDateTime.now());

        informationRepository.save(toyota);
        informationRepository.save(bmw);
    }
}
