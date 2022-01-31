package me.mirat1618.apartmentsapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "apartment")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Apartment {
    @Id
    @SequenceGenerator(name="apartment_sequence", sequenceName = "apartment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_sequence")
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "number")
    private int number;

    @Column(name = "floor")
    private int floor;

    @Column(name = "square_meters")
    private float squareMeters;

    @Column(name = "number_of_bedrooms")
    private int  numberOfBedrooms;

    @Column(name = "has_dishwasher")
    private boolean hasDishwasher;

    @Column(name = "has_washing_machine")
    private boolean hasWashingMachine;

    @Column(name = "rent_price")
    private float rentPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apartment_complex_id")
    private ApartmentComplex apartmentComplex;

    public Apartment(int number, int floor, float squareMeters, int numberOfBedrooms, boolean hasWashingMachine, boolean hasDishwasher, float rentPrice, ApartmentComplex apartmentComplex) {
        this.number = number;
        this.floor = floor;
        this.squareMeters = squareMeters;
        this.numberOfBedrooms = numberOfBedrooms;
        this.hasWashingMachine = hasWashingMachine;
        this.hasDishwasher = hasDishwasher;
        this.rentPrice = rentPrice;
        this.apartmentComplex = apartmentComplex;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", number=" + number +
                ", floor=" + floor +
                ", squareMeters=" + squareMeters +
                ", numberOfBedrooms=" + numberOfBedrooms +
                ", hasDishwasher=" + hasDishwasher +
                ", hasWashingMachine=" + hasWashingMachine +
                ", rentPrice=" + rentPrice +
                '}';
    }
}
