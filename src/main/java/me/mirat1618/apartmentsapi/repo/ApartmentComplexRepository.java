package me.mirat1618.apartmentsapi.repo;

import me.mirat1618.apartmentsapi.model.ApartmentComplex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentComplexRepository extends JpaRepository<ApartmentComplex, Long> {
    public List<ApartmentComplex> findAllByOrderByIdAsc();
}
