package me.mirat1618.apartmentsapi.repo;

import me.mirat1618.apartmentsapi.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    public List<Apartment> findAllByOrderByIdAsc();
}
