package me.mirat1618.apartmentsapi.controller;

import lombok.Getter;
import me.mirat1618.apartmentsapi.model.Apartment;
import me.mirat1618.apartmentsapi.service.ApartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {
    private ApartmentService service;

    public ApartmentController(ApartmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Apartment> findAllApartments() {
        return service.findAllApartments();
    }

    @GetMapping("/{id}")
    public Apartment findApartment(@PathVariable("id") Long id) {
        return service.findApartmentById(id);
    }

    @PostMapping
    public Apartment createApartment(@RequestBody Apartment apartment) {
        return service.createApartment(apartment);
    }

    @PutMapping
    public Apartment updateApartment(@RequestBody Apartment apartment) {
        return service.updateApartment(apartment);
    }

    @DeleteMapping("/{id}")
    public void deleteApartment(@PathVariable("id") long id) {
        service.deleteApartment(id);
    }
}
