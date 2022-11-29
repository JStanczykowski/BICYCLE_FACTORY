package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TasksRepo extends JpaRepository<Tasks, Long> {

}
