package me.mirat1618.apartmentsapi.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "apartment_complex", uniqueConstraints = {
        @UniqueConstraint(name = "apartment_complex_title_unique", columnNames = "title")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ApartmentComplex {
    @Id
    @SequenceGenerator(name="apartment_complex_sequence", sequenceName = "apartment_complex_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_complex_sequence")
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "apartmentComplex")
    private List<Apartment> apartments;

    public ApartmentComplex(String title, String address) {
        this.title = title;
        this.address = address;
        this.apartments = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "ApartmentComplex{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
