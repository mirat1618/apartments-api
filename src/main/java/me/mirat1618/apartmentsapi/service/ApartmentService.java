package me.mirat1618.apartmentsapi.service;

import me.mirat1618.apartmentsapi.exception.RecordNotFoundException;
import me.mirat1618.apartmentsapi.model.Apartment;
import me.mirat1618.apartmentsapi.repo.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {
    private ApartmentRepository repo;

    @Autowired
    public ApartmentService(ApartmentRepository repo) {
        this.repo = repo;
    }

    public List<Apartment> findAllApartments() {
        return repo.findAllByOrderByIdAsc();
    }

    public Apartment findApartmentById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RecordNotFoundException("Apartment with an ID of " + id + " was not found in the database"));
    }

    public Apartment createApartment(Apartment apartment) {
        return repo.save(apartment);
    }

    public Apartment updateApartment(Apartment apartment) {
        return repo.save(apartment);
    }

    public void deleteApartment(Long id) {
        repo.deleteById(id);
    }






}
