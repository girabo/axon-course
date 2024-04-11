package nl.rabobank.axondemo.repository;

import nl.rabobank.axondemo.entity.FlightEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FlightRepository extends JpaRepository<FlightEntity, String> {
}
