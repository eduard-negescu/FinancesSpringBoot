package com.eduard.demowebflux2.service.Impl;

import com.eduard.demowebflux2.controller.dto.CarDto;
import com.eduard.demowebflux2.repository.CarRepository;
import com.eduard.demowebflux2.repository.entity.CarEntity;
import com.eduard.demowebflux2.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public Flux<CarDto> getAllCars() {
        return carRepository.findAll()
                .map(car -> new CarDto(car.getId(), car.getBrand(), car.getKilowatt()));
    }

    @Override
    public Mono<CarDto> getCarById(Integer id) {
        return carRepository.findById(id)
                .map(car -> new CarDto(car.getId(), car.getBrand(), car.getKilowatt()));
    }

    @Override
    public Mono<CarDto> saveCar(CarDto carDto) {
        return carRepository.save(CarEntity.builder()
                .brand(carDto.brand())
                .kilowatt(carDto.kilowatt())
                .build()
        )
                .map(car -> new CarDto(car.getId(), car.getBrand(), car.getKilowatt()));
    }

    @Override
    public Mono<CarDto> updateCar(Integer id, CarDto carDto) {
        return carRepository.save(CarEntity.builder()
                .id(id)
                .brand(carDto.brand())
                .kilowatt(carDto.kilowatt())
                .build()
        )
                .map(car -> new CarDto(car.getId(), car.getBrand(), car.getKilowatt()));
    }

    @Override
    public Mono<Void> deleteCar(Integer id) {
        return carRepository.deleteById(id);
    }
}
