package com.example.ApiRestFulSpringBoot.api;

import com.example.ApiRestFulSpringBoot.domain.Carro;
import com.example.ApiRestFulSpringBoot.domain.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
    @Autowired
    private CarroService service;

    @GetMapping()
    public Iterable<Carro> get()
    {
        return service.getCarros();
    }

}