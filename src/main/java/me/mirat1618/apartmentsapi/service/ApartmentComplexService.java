package me.mirat1618.apartmentsapi.service;

import me.mirat1618.apartmentsapi.exception.RecordNotFoundException;
import me.mirat1618.apartmentsapi.model.Apartment;
import me.mirat1618.apartmentsapi.model.ApartmentComplex;
import me.mirat1618.apartmentsapi.repo.ApartmentComplexRepository;
import me.mirat1618.apartmentsapi.repo.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentComplexService {
    private final ApartmentComplexRepository apartmentComplexRepo;
    private final ApartmentRepository apartmentRepo;

    @Autowired
    public ApartmentComplexService(ApartmentComplexRepository apartmentComplexRepo, ApartmentRepository apartmentRepo) {
        this.apartmentComplexRepo = apartmentComplexRepo;
        this.apartmentRepo = apartmentRepo;
    }

    public List<ApartmentComplex> findAllApartmentComplexes() {
        return apartmentComplexRepo.findAll();
    }

    public ApartmentComplex findApartmentComplexById(Long id) {
        return apartmentComplexRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("An apartment complex with an ID of " + id + " was not found in the database"));
    }

    public ApartmentComplex createApartmentComplex(ApartmentComplex apartmentComplex) {
        return apartmentComplexRepo.save(apartmentComplex);
    }

    public ApartmentComplex updateApartmentComplex(ApartmentComplex apartmentComplex) {
        return apartmentComplexRepo.save(apartmentComplex);
    }

    public void deleteApartmentComplex(Long id) { apartmentComplexRepo.deleteById(id);}

    public ApartmentComplex addApartment(Long apartmentComplexId, Apartment apartment) {
        // locate the apartment complex by its ID
        ApartmentComplex apartmentComplex = apartmentComplexRepo.findById(apartmentComplexId).orElseThrow(() ->
                new RecordNotFoundException("An apartment complex with an ID of " + apartmentComplexId + " was not found in the database"));

        apartment.setApartmentComplex(apartmentComplex);  // set parent (apartment complex) of the apartment
        Apartment addedApartment = apartmentRepo.save(apartment); // save the apartment to the database
        apartmentComplex.getApartments().add(addedApartment); // add the apartment to the complex to return it later

        return apartmentComplex; // return the updated version of the apartment complex
    }

    public ApartmentComplex removeApartment(Long apartmentComplexId, Long apartmentId) {
        // locate the apartment complex by its ID
        ApartmentComplex apartmentComplex = apartmentComplexRepo.findById(apartmentComplexId).orElseThrow(() ->
                new RecordNotFoundException("An apartment complex with an ID of " + apartmentComplexId + " was not found in the database"));

        // check if the apartment complex has an apartment with such an ID
        Optional<Apartment> apartmentOptional = apartmentComplex.getApartments().
                stream().
                filter((apartment -> apartment.getId() == apartmentId)).
                findFirst();

        // if it does
        if(apartmentOptional.isPresent()) {
            Apartment apartment = apartmentOptional.get();
            apartment.setApartmentComplex(null); // destroy the link between them
            apartmentRepo.save(apartment); // saving changes to the database
        }
        return apartmentComplex; // return the updated version
    }

}
