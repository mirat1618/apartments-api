package me.mirat1618.apartmentsapi.seed;

import me.mirat1618.apartmentsapi.model.Apartment;
import me.mirat1618.apartmentsapi.model.ApartmentComplex;
import me.mirat1618.apartmentsapi.service.ApartmentComplexService;
import me.mirat1618.apartmentsapi.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private ApartmentComplexService apartmentComplexService;
    private ApartmentService apartmentService;

    @Autowired
    public DatabaseSeeder(ApartmentComplexService apartmentComplexService, ApartmentService apartmentService) {
        this.apartmentComplexService = apartmentComplexService;
        this.apartmentService = apartmentService;
    }

    @Override
    public void run(String[] args) {
        ApartmentComplex apartmentComplex1 = apartmentComplexService.createApartmentComplex(new ApartmentComplex("Клубный Дом \"Соты\"", "ул. Цюрупы, д. 30", "https://ibb.co/H7vhL4z"));
        ApartmentComplex apartmentComplex2 = apartmentComplexService.createApartmentComplex(new ApartmentComplex("Идель-Тауэр", "пр. Октября, д. 107а", "https://ibb.co/j61wcxm"));

        Apartment apartment1 = new Apartment(39, 4, new Float(34.7), 1, true, false, 27000, apartmentComplex1);
        Apartment apartment2 = new Apartment(27, 6, new Float(55), 1, true, false, 25000, apartmentComplex1);
        Apartment apartment3 = new Apartment(325, 13, new Float(145), 3, true, true, 55000, apartmentComplex2);
        Apartment apartment4 = new Apartment(229, 8, new Float(77), 3, true, false, 32000, apartmentComplex2);

        apartmentService.createApartment(apartment1);
        apartmentService.createApartment(apartment2);
        apartmentService.createApartment(apartment3);
        apartmentService.createApartment(apartment4);
    }
}

