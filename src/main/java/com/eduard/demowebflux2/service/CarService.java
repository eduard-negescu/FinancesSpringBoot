package com.eduard.demowebflux2.service;

import com.eduard.demowebflux2.controller.dto.CarDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarService {
    Flux<CarDto> getAllCars();
    Mono<CarDto> getCarById(Integer id);
    Mono<CarDto> saveCar(CarDto carDto);
    Mono<CarDto> updateCar(Integer id, CarDto carDto);
    Mono<Void> deleteCar(Integer id);
}
