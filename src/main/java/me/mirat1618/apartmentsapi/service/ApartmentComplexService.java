package me.mirat1618.apartmentsapi.service;

import me.mirat1618.apartmentsapi.exception.ApartmentComplexNotFoundException;
import me.mirat1618.apartmentsapi.model.ApartmentComplex;
import me.mirat1618.apartmentsapi.repo.ApartmentComplexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentComplexService {
    private final ApartmentComplexRepository repo;

    @Autowired
    public ApartmentComplexService(ApartmentComplexRepository repo) {
        this.repo = repo;
    }

    public List<ApartmentComplex> findAllApartmentComplexes() {
        return repo.findAll();
    }

    public ApartmentComplex findApartmentComplexById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ApartmentComplexNotFoundException("An apartment with an ID of" + id + " was not found in the database"));
    }

    public ApartmentComplex createApartmentComplex(ApartmentComplex apartmentComplex) {
        return repo.save(apartmentComplex);
    }

    public ApartmentComplex updateApartmentComplex(ApartmentComplex apartmentComplex) {
        return repo.save(apartmentComplex);
    }

    public void deleteApartmentComplex(Long id) { repo.deleteById(id);}

}
