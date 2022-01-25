package me.mirat1618.apartmentsapi.controller;

import me.mirat1618.apartmentsapi.model.Apartment;
import me.mirat1618.apartmentsapi.model.ApartmentComplex;
import me.mirat1618.apartmentsapi.service.ApartmentComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartment-complexes")
public class ApartmentComplexController {
    private ApartmentComplexService service;

    @Autowired
    public ApartmentComplexController(ApartmentComplexService service) {
        this.service = service;
    }

    @GetMapping
    public List<ApartmentComplex> findAllApartmentComplexes() {
        return service.findAllApartmentComplexes();
    }

    @GetMapping("/{id}")
    public ApartmentComplex findApartmentComplex(@PathVariable("id") Long id) {
        return service.findApartmentComplexById(id);
    }

    @PostMapping
    public ApartmentComplex createApartmentComplex(@RequestBody ApartmentComplex complex) {
        return service.createApartmentComplex(complex);
    }

    @PutMapping
    public ApartmentComplex updateApartmentComplex(@RequestBody ApartmentComplex complex) {
        return service.updateApartmentComplex(complex);
    }

    @DeleteMapping("/{id}")
    public void deleteApartmentComplex(@PathVariable("id") Long id) {
        service.deleteApartmentComplex(id);
    }

    @PostMapping("/{id}")
    public ApartmentComplex addApartment(@PathVariable("id") Long apartmentComplexId, @RequestBody Apartment apartment) {
        return service.addApartment(apartmentComplexId, apartment);
    }

    @DeleteMapping("/{apartmentComplexId}/apartment/{apartmentId}")
    public ApartmentComplex removeApartment(@PathVariable("apartmentComplexId") Long apartmentComplexId, @PathVariable("apartmentId") Long apartmentId) {
        return service.removeApartment(apartmentComplexId, apartmentId);
    }
}
