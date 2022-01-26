package me.mirat1618.apartmentsapi.controller;

import me.mirat1618.apartmentsapi.model.Apartment;
import me.mirat1618.apartmentsapi.model.ApartmentComplex;
import me.mirat1618.apartmentsapi.service.ApartmentComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private ApartmentComplexService apartmentComplexService;

    @Autowired
    public MainController(ApartmentComplexService apartmentComplexService) {
        this.apartmentComplexService = apartmentComplexService;
    }

    @GetMapping("/")
    public List<ApartmentComplex> index() {
        return apartmentComplexService.findAllApartmentComplexes();
    }

}
