package com.eduard.demowebflux2.repository;

import com.eduard.demowebflux2.repository.entity.CarEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CarRepository extends R2dbcRepository<CarEntity, Integer> {
}
