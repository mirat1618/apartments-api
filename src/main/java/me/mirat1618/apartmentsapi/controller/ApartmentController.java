package me.mirat1618.apartmentsapi.controller;

import me.mirat1618.apartmentsapi.model.Apartment;
import me.mirat1618.apartmentsapi.service.ApartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:9002", "https://apartments-frontend-ui.herokuapp.com"})
@RequestMapping("/apartments")
public class ApartmentController {
    private ApartmentService service;

    public ApartmentController(ApartmentService service) {
        this.service = service;
    }

//    @GetMapping
//    public List<Apartment> findAllApartments() {
//        return service.findAllApartments();
//    }
//
//    @GetMapping("/{id}")
//    public Apartment findApartment(@PathVariable("id") Long id) {
//        return service.findApartmentById(id);
//    }
//
//    @PostMapping
//    public Apartment createApartment(@RequestBody Apartment apartment) {
//        return service.createApartment(apartment);
//    }

    @PutMapping("/{id}")
    public Apartment updateApartment(@PathVariable("id") Long id, @RequestBody Apartment apartment) {
        apartment.setId(id);
        return service.updateApartment(apartment);
    }

//    @DeleteMapping("/{id}")
//    public void deleteApartment(@PathVariable("id") Long id) {
//        service.deleteApartment(id);
//    }
}
