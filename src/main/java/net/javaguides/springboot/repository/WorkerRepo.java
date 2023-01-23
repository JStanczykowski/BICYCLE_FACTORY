package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepo extends JpaRepository<Worker,Long> {
}
