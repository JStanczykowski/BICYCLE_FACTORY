package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {
}
