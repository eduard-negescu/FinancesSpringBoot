package com.eduard.demowebflux2.controller;


import com.eduard.demowebflux2.controller.dto.CarDto;
import com.eduard.demowebflux2.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @GetMapping
    Flux<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    Mono<CarDto> getCarById(@PathVariable("id") Integer id) {
        return carService.getCarById(id);
    }

    @PostMapping
    Mono<CarDto> saveCar(@RequestBody CarDto carDto) {
        return carService.saveCar(carDto);
    }

    @PutMapping("/{id}")
    Mono<CarDto> updateCar(@PathVariable("id") Integer id, @RequestBody CarDto carDto) {
        return carService.updateCar(id, carDto);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteCar(@PathVariable("id") Integer id) {
        return carService.deleteCar(id);
    }
}
