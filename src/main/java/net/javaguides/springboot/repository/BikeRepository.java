package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Bike;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
