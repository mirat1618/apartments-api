package me.mirat1618.apartmentsapi.repo;

import me.mirat1618.apartmentsapi.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
