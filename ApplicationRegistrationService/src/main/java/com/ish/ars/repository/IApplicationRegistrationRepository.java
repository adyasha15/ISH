package com.ish.ars.repository;

import com.ish.ars.entity.CitizenApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface IApplicationRegistrationRepository extends
        JpaRepository<CitizenApplicationEntity, Integer> {
}
