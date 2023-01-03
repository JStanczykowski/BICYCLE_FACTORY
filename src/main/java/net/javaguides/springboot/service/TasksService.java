package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Tasks;
import net.javaguides.springboot.model.TypeTask;
import net.javaguides.springboot.model.Worker;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface TasksService {

        Tasks save(Tasks tasks);
        List<Tasks> getAllTasks();
        Tasks getTaskById(long id);
        Tasks updateTask(Tasks tasks);
        void deleteTaskById(long id);
        void doSomething(TypeTask typeTask, Object o);
}
