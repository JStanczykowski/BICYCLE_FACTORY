package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Tasks;
import net.javaguides.springboot.model.TypeTask;
import net.javaguides.springboot.repository.TasksRepo;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TasksServiceImpl implements TasksService{
    @Autowired
    private TasksRepo tasksRepo;


    @Autowired
    public TasksServiceImpl(TasksRepo tasksRepo ) {
        super();
        this.tasksRepo = tasksRepo;
//        this.typeTaskFactory = typeTaskFactory;
    }
    @Override
    public Tasks save(Tasks tasks) {
        return tasksRepo.save(tasks);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return tasksRepo.findAll();
    }
    @Override
    public Tasks getTaskById(long id){
        return tasksRepo.findById(id).get();
    }
    @Override
    public Tasks updateTask(Tasks tasks){
        return tasksRepo.save(tasks);
    }
    @Override
    public void deleteTaskById(long id){
        tasksRepo.deleteById(id);
    }


}
